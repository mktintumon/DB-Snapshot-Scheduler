package com.scheduler.cyraacs.models;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer taskId;

    private String taskDesc;
    private boolean taskStatus;
    private int taskFrequency;
    private Date taskCreatedAt;
    private Date taskUpdatedAt;
    private Date lastSnapshotOn;

    @ManyToOne
    @JoinColumn(name="controlId")
    private ControlRequirements controlRequirements;

    public Task(){
    }

    public Task(Integer taskId, String taskDesc, boolean taskStatus, int taskFrequency, Date taskCreatedAt,
            Date taskUpdatedAt, Date lastSnapshotOn, ControlRequirements controlRequirements) {
        this.taskId = taskId;
        this.taskDesc = taskDesc;
        this.taskStatus = taskStatus;
        this.taskFrequency = taskFrequency;
        this.taskCreatedAt = taskCreatedAt;
        this.taskUpdatedAt = taskUpdatedAt;
        this.lastSnapshotOn = lastSnapshotOn;
        this.controlRequirements = controlRequirements;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getTaskFrequency() {
        return taskFrequency;
    }

    public void setTaskFrequency(int taskFrequency) {
        this.taskFrequency = taskFrequency;
    }

    public Date getTaskCreatedAt() {
        return taskCreatedAt;
    }

    public void setTaskCreatedAt(Date taskCreatedAt) {
        this.taskCreatedAt = taskCreatedAt;
    }

    public Date getTaskUpdatedAt() {
        return taskUpdatedAt;
    }

    public void setTaskUpdatedAt(Date taskUpdatedAt) {
        this.taskUpdatedAt = taskUpdatedAt;
    }

    public Date getLastSnapshotOn() {
        return lastSnapshotOn;
    }

    public void setLastSnapshotOn(Date lastSnapshotOn) {
        this.lastSnapshotOn = lastSnapshotOn;
    }

    public ControlRequirements getControlRequirements() {
        return controlRequirements;
    }

    public void setControlRequirements(ControlRequirements controlRequirements) {
        this.controlRequirements = controlRequirements;
    }

    
}
