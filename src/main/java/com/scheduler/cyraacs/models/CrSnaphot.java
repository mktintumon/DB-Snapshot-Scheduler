package com.scheduler.cyraacs.models;

import javax.persistence.*;

import java.sql.Date;

@Entity
public class CrSnaphot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer crSnapshotId;
    private boolean complainceStatus;
    private Date capturedAt;
    private String event;
    private Date frequencyExpiryDate;

    @ManyToOne
    @JoinColumn(name = "controlId")
    private ControlRequirements controlRequirements;

    public CrSnaphot() {

    }

    public CrSnaphot(Integer crSnapshotId, boolean complainceStatus, Date capturedAt, String event,
            Date frequencyExpiryDate, ControlRequirements controlRequirements) {
        this.crSnapshotId = crSnapshotId;
        this.complainceStatus = complainceStatus;
        this.capturedAt = capturedAt;
        this.event = event;
        this.frequencyExpiryDate = frequencyExpiryDate;
        this.controlRequirements = controlRequirements;
    }

    public Integer getCrSnapshotId() {
        return crSnapshotId;
    }

    public void setCrSnapshotId(Integer crSnapshotId) {
        this.crSnapshotId = crSnapshotId;
    }

    public boolean isComplainceStatus() {
        return complainceStatus;
    }

    public void setComplainceStatus(boolean complainceStatus) {
        this.complainceStatus = complainceStatus;
    }

    public Date getCapturedAt() {
        return capturedAt;
    }

    public void setCapturedAt(Date capturedAt) {
        this.capturedAt = capturedAt;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getFrequencyExpiryDate() {
        return frequencyExpiryDate;
    }

    public void setFrequencyExpiryDate(Date frequencyExpiryDate) {
        this.frequencyExpiryDate = frequencyExpiryDate;
    }

    public ControlRequirements getControlRequirements() {
        return controlRequirements;
    }

    public void setControlRequirements(ControlRequirements controlRequirements) {
        this.controlRequirements = controlRequirements;
    }

    

}