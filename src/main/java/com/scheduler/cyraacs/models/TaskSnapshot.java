package com.scheduler.cyraacs.models;

import javax.persistence.*;

import java.sql.Date;

@Entity
public class TaskSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer taskSnapshotId;
    private Date captured_aAt;

    @ManyToOne
    @JoinColumn(name = "crSnapshotId")
    private CrSnaphot crSnaphot;

    public TaskSnapshot() {

    }

    public TaskSnapshot(Integer taskSnapshotId, Date captured_aAt, CrSnaphot crSnaphot) {
        this.taskSnapshotId = taskSnapshotId;
        this.captured_aAt = captured_aAt;
        this.crSnaphot = crSnaphot;
    }

    public Integer getTaskSnapshotId() {
        return taskSnapshotId;
    }

    public void setTaskSnapshotId(Integer taskSnapshotId) {
        this.taskSnapshotId = taskSnapshotId;
    }

    public Date getCaptured_aAt() {
        return captured_aAt;
    }

    public void setCaptured_aAt(Date captured_aAt) {
        this.captured_aAt = captured_aAt;
    }

    public CrSnaphot getCrSnaphot() {
        return crSnaphot;
    }

    public void setCrSnaphot(CrSnaphot crSnaphot) {
        this.crSnaphot = crSnaphot;
    }

    
}
