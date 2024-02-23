package com.scheduler.cyraacs.models;


import javax.persistence.*;

import java.sql.Date;

@Entity
public class Task_snapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer task_snapshot_id;
    private Date captured_at;

    @ManyToOne
    @JoinColumn(name="cr_snapshot_id")
    private Cr_snaphot crSnaphot;
    public Task_snapshot(Integer task_snapshot_id, Date captured_at) {
        this.task_snapshot_id = task_snapshot_id;
        this.captured_at = captured_at;
    }
    public Task_snapshot() {

    }

    public Cr_snaphot getCrSnaphot() {
        return crSnaphot;
    }

    public void setCrSnaphot(Cr_snaphot crSnaphot) {
        this.crSnaphot = crSnaphot;
    }

    public Integer getTask_snapshot_id() {
        return task_snapshot_id;
    }

    public void setTask_snapshot_id(Integer task_snapshot_id) {
        this.task_snapshot_id = task_snapshot_id;
    }

    public Date getCaptured_at() {
        return captured_at;
    }

    public void setCaptured_at(Date captured_at) {
        this.captured_at = captured_at;
    }
}
