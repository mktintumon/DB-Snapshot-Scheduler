package com.scheduler.cyraacs.service;

import java.sql.Date;
import java.util.List;
import java.util.TimeZone;

import com.scheduler.cyraacs.repo.CrRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.scheduler.cyraacs.models.ControlRequirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DbSnapshot {
    private Logger logger = LoggerFactory.getLogger(DbSnapshot.class);

    @Autowired
    CrRepo crRepo;

    @Autowired
    SnapshotHelper snapshotHelper;

    @Autowired
    NotificationService notificationService;

    // Main function for creating snapshot by looping over potential CR's(whose expiry date arrived)
    @Scheduled(cron = "0/15 * * * * *")
    public void Snapshot() {
        String timeZone = notificationService.getTimeZone();
        // Set the time zone for this thread
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));

        try {
            Date today = new Date(System.currentTimeMillis());

            List<ControlRequirements> crList = crRepo.findByFrequencyExpiryDate(today);
    
            if (!crList.isEmpty()) {
                for (ControlRequirements cr : crList) {
                    snapShotHelper(cr,today);
                }
                logger.info("Scheduler executed the job");

            } else {
                logger.info("No need to take snapshot");
            }

            // Check CR for sending prior notification
            notificationService.sendNotification(today);

        } catch (Exception e) {
            logger.error("An error occurred in takeSnapshot: " + e.getMessage(), e);
        }
    }


    // Helper function for calculating Dates and taking snapshots
    private void snapShotHelper(ControlRequirements cr , Date today) {
        try {
            int frequency = convertToDays(cr.getFrequency());

            long next_expiry_time = today.getTime() + ((long) frequency * 24 * 60 * 60 * 1000);
            Date next_expiry_date = new Date(next_expiry_time);

            // setting updated value in CR table
            cr.setFrequencyExpiryDate(next_expiry_date);
            cr.setLastSnapshotOn(today);
            crRepo.save(cr);
            logger.info("Starting snapshot for ControlRequirements ID: " + cr.getControlId());

            // Calling snapshot helper to take snapshot
            snapshotHelper.takeSnapshot(cr, today);

        } catch (Exception e) {
            logger.error("An error occurred in snapShotHelper: " + e.getMessage(), e);
        }
    }


    // Converts String frequency to Int type
    private static int convertToDays(String timePeriod) {
        switch (timePeriod.toLowerCase().trim()) {
            case "daily":
                return 1;
            case "weekly":
                return 7;
            case "biweekly":
                return 14;
            case "fortnight":
            case "fortnightly":
                return 15; 
            case "monthly":
                return 30;
            case "quarterly":
                return 90; // 3 months approximately
            case "halfyearly":
            case "half-yearly":
                return 180; // 6 months approximately
            case "yearly":
            case "annually":
                return 365; // 1 year approximately
            default:
                throw new IllegalArgumentException("Unsupported time period: " + timePeriod);
        }
    }


    
}
