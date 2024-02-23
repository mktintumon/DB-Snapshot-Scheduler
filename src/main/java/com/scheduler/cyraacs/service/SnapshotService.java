package com.scheduler.cyraacs.service;

import java.sql.Date;
import java.util.List;
import com.scheduler.cyraacs.models.ControlRequirements;
import com.scheduler.cyraacs.models.Cr_snaphot;
import com.scheduler.cyraacs.models.Task_snapshot;
import com.scheduler.cyraacs.repo.CrRepo;
import com.scheduler.cyraacs.repo.CrSnapshotRepo;
import com.scheduler.cyraacs.repo.TaskSnapshotRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SnapshotService {
        @Autowired
        CrRepo crRepo;

        @Autowired
        CrSnapshotRepo crSnapshotRepo;

        @Autowired
        TaskSnapshotRepo taskSnapshotRepo;

        @Autowired
        NotificationService notificationService;


        @Scheduled(cron="0/15 * * * * *")

        public void takeSnapshot(){
            List<ControlRequirements> cr_list = crRepo.findAll();

            for(ControlRequirements cr : cr_list){
                snapShotHelper(cr);
            }
        }


        public void snapShotHelper(ControlRequirements cr){
            Date today = new Date(System.currentTimeMillis());
            Date expiryDate = cr.getFrequency_expiry_date();
            int frequency = cr.getFrequency();

            long threeDayBefore = expiryDate.getTime() - ((long)3*24*60*60*1000);
            Date notifyDate = new Date(threeDayBefore);
            if(notifyDate.compareTo(today) <= 0){
                System.out.println("======================================================================================");
                notificationService.sendNotification("NOTIFICATION - Expiry date for CR id " + cr.getControlId() + " is " + expiryDate);
            }

            if (expiryDate.compareTo(today) <= 0) {
                long next_expiry_time = expiryDate.getTime() + ((long) frequency * 24 * 60 * 60 * 1000);
                Date next_expiry_date = new Date(next_expiry_time);

                // setting updated value in CR table
                cr.setFrequency_expiry_date(next_expiry_date);
                cr.setLast_snapshot_on(today);
                crRepo.save(cr);
                System.out.println("Starting snapshot for ControlRequirements ID: " + cr.getControlId());


                // setting value in Cr_Snapshot table
                Cr_snaphot crSnaphot = new Cr_snaphot();
                crSnaphot.setControlRequirements(cr);
                crSnaphot.setCaptured_at(today);
                crSnaphot.setComplaince_status(cr.isCompliance_status());
                crSnapshotRepo.save(crSnaphot);
                System.out.println("CR table snapshot successfully taken.");
                notificationService.sendNotification("Sna`pshot taken successfully - Notification  ");

                // Follow-up snapshot of CR_snapshot table to Task_Snapshot table
                Task_snapshot taskSnapshot = new Task_snapshot();
                taskSnapshot.setCrSnaphot(crSnaphot);
                taskSnapshot.setCaptured_at(today);
                taskSnapshotRepo.save(taskSnapshot);
                System.out.println("CR_Snapshot table also snapshotted successfully!!!");
            }

            else{
                System.out.println("STATUS - NO need to take Snapshot");
                System.out.println("======================================================================================");
            }
        }


}
