package com.scheduler.cyraacs.models;


import javax.persistence.*;

import java.sql.Date;

@Entity
public class Cr_snaphot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cr_snapshot_id;

    private boolean complaince_status;
    private Date captured_at;



    public ControlRequirements getControlRequirements() {
        return controlRequirements;
    }

    public void setControlRequirements(ControlRequirements controlRequirements) {
        this.controlRequirements = controlRequirements;
    }

    @ManyToOne
    @JoinColumn(name="controlId")
    private ControlRequirements controlRequirements;



    public Cr_snaphot(Integer cr_snapshot_id, boolean complaince_status, Date captured_at, ControlRequirements controlRequirements) {
        this.cr_snapshot_id = cr_snapshot_id;
        this.complaince_status = complaince_status;
        this.captured_at = captured_at;
        this.controlRequirements=controlRequirements;

    }
    public Cr_snaphot() {

    }

    public Integer getCr_snapshot_id() {
        return cr_snapshot_id;
    }

    public void setCr_snapshot_id(Integer cr_snapshot_id) {
        this.cr_snapshot_id = cr_snapshot_id;
    }

    public boolean isComplaince_status() {
        return complaince_status;
    }

    public void setComplaince_status(boolean complaince_status) {
        this.complaince_status = complaince_status;
    }

    public Date getCaptured_at() {
        return captured_at;
    }

    public void setCaptured_at(Date captured_at) {
        this.captured_at = captured_at;
    }
}
