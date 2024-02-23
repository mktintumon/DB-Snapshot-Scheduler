package com.scheduler.cyraacs.models;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer task_id;

    private String task_desc;
    private boolean task_status;
    private int task_frequency;

    private Date task_created_at;
    private Date task_updated_at;

    private Date last_snapshot_on;

    @ManyToOne
    @JoinColumn(name="controlId")
    private ControlRequirements controlRequirements;

    public Date getLast_snapshot_on() {
        return last_snapshot_on;
    }

    public void setLast_snapshot_on(Date last_snapshot_on) {
        this.last_snapshot_on = last_snapshot_on;
    }

    public Task(Integer task_id, String task_desc, boolean task_status, int task_frequency, Date task_created_at, Date task_updated_at, Date last_snapshot_on) {
        this.task_id = task_id;
        this.task_desc = task_desc;
        this.task_status = task_status;
        this.task_frequency = task_frequency;
        this.task_created_at = task_created_at;
        this.task_updated_at = task_updated_at;
        this.last_snapshot_on = last_snapshot_on;
    }
    public Task(){
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public boolean isTask_status() {
        return task_status;
    }

    public void setTask_status(boolean task_status) {
        this.task_status = task_status;
    }

    public int getTask_frequency() {
        return task_frequency;
    }

    public void setTask_frequency(int task_frequency) {
        this.task_frequency = task_frequency;
    }

    public Date getTask_created_at() {
        return task_created_at;
    }

    public void setTask_created_at(Date task_created_at) {
        this.task_created_at = task_created_at;
    }

    public Date getTask_updated_at() {
        return task_updated_at;
    }

    public void setTask_updated_at(Date task_updated_at) {
        this.task_updated_at = task_updated_at;
    }

}
