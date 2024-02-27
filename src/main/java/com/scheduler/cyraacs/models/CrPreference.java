package com.scheduler.cyraacs.models;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CrPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Time timeOfScheduler;
    private String timeZoneOfScheduler;
    private Integer frequencyAdvanceReminderNotification;

    public CrPreference() {
    }

    public CrPreference(Integer id, Time timeOfScheduler, String timeZoneOfScheduler,
            Integer frequencyAdvanceReminderNotification) {
        this.id = id;
        this.timeOfScheduler = timeOfScheduler;
        this.timeZoneOfScheduler = timeZoneOfScheduler;
        this.frequencyAdvanceReminderNotification = frequencyAdvanceReminderNotification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Time getTimeOfScheduler() {
        return timeOfScheduler;
    }

    public void setTimeOfScheduler(Time timeOfScheduler) {
        this.timeOfScheduler = timeOfScheduler;
    }

    public String getTimeZoneOfScheduler() {
        return timeZoneOfScheduler;
    }

    public void setTimeZoneOfScheduler(String timeZoneOfScheduler) {
        this.timeZoneOfScheduler = timeZoneOfScheduler;
    }

    public Integer getFrequencyAdvanceReminderNotification() {
        return frequencyAdvanceReminderNotification;
    }

    public void setFrequencyAdvanceReminderNotification(Integer frequencyAdvanceReminderNotification) {
        this.frequencyAdvanceReminderNotification = frequencyAdvanceReminderNotification;
    }

}
