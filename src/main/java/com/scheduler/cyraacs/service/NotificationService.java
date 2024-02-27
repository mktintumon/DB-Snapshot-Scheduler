package com.scheduler.cyraacs.service;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.scheduler.cyraacs.models.ControlRequirements;
import com.scheduler.cyraacs.models.CrPreference;
import com.scheduler.cyraacs.repo.CrPreferenceRepo;
import com.scheduler.cyraacs.repo.CrRepo;

@Service
public class NotificationService {

    private final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    CrPreferenceRepo crPreferenceRepo;

    @Autowired
    CrRepo crRepo;

    public void sendNotification(Date today) {
        try {
            CrPreference preference = crPreferenceRepo.findTimeZoneOfSchedulerById(1);
            Integer advanceNotifyDay = preference.getFrequencyAdvanceReminderNotification();

            // 1 day = (long)(24 * 60 * 60 * 1000)
            long expireNotifyDay = today.getTime() + ((long) advanceNotifyDay * 24 * 60 * 60 * 1000);
            Date notifyDate = new Date(expireNotifyDay);

            List<ControlRequirements> crNotificationList = crRepo.findByFrequencyExpiryDate(notifyDate);

            for (ControlRequirements cr : crNotificationList) {
                logger.info("NOTIFICATION - Expiry date for CR id {} is {}", cr.getControlId(), notifyDate);
            }
        } catch (DataAccessException e) {
            // Handle data access exceptions
            logger.error("Not able to access data. Date: {}. Error: {}", today, e.getMessage(),
                    e);
        } catch (Exception e) {
            // Handle other exceptions
            logger.error("Error occurred during notification processing. Date: {}. Error: {}", today, e.getMessage(),e);
        }
    }

    public String getTimeZone() {
        CrPreference preference = crPreferenceRepo.findTimeZoneOfSchedulerById(1);
        return (preference != null) ? preference.getTimeZoneOfScheduler() : "Asia/Kolkata";
    }
}
