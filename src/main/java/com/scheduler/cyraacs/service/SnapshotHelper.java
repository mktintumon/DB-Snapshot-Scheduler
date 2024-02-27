package com.scheduler.cyraacs.service;

import java.sql.Date;

import com.scheduler.cyraacs.models.ControlRequirements;
import com.scheduler.cyraacs.models.CrSnaphot;
import com.scheduler.cyraacs.models.TaskSnapshot;
import com.scheduler.cyraacs.repo.CrSnapshotRepo;
import com.scheduler.cyraacs.repo.TaskSnapshotRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnapshotHelper {
    private final Logger logger = LoggerFactory.getLogger(SnapshotHelper.class);

    @Autowired
    CrSnapshotRepo crSnapshotRepo;

    @Autowired
    TaskSnapshotRepo taskSnapshotRepo;

    public void takeSnapshot(ControlRequirements cr, Date today) {
        try {
            // setting value in Cr_Snapshot table
            CrSnaphot crSnaphot = new CrSnaphot();
            crSnaphot.setControlRequirements(cr);
            crSnaphot.setCapturedAt(today);
            crSnaphot.setComplainceStatus(cr.isComplianceStatus());
            crSnaphot.setFrequencyExpiryDate(today);
            crSnapshotRepo.save(crSnaphot);
            logger.info("CR table snapshot successfully!!!");

            // Follow-up snapshot of CR_snapshot table to Task_Snapshot table
            TaskSnapshot taskSnapshot = new TaskSnapshot();
            taskSnapshot.setCrSnaphot(crSnaphot);
            taskSnapshot.setCaptured_aAt(today);
            taskSnapshotRepo.save(taskSnapshot);
            logger.info("CR_Snapshot table also snapshot successfully!!!");

            // notificationService.sendNotification("Notification : Snapshot taken
            // successfully");
        } catch (Exception e) {
            logger.error("An error occurred in takeSnapshot: " + e.getMessage(), e);
        }
    }
}
