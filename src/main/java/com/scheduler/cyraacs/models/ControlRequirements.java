package com.scheduler.cyraacs.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ControlRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer controlId;

    private String org_key;
    private String statement;
    private Integer domain_id;

    private String type;
    private Integer owner_id;
    private String health;
    private Integer implementationStatusId;

    private String implementationGuideline;
    private Date implementationTargetDate;
    private Date implementationDueDate;
    private Integer ruleId;
    private String applicabilityStatus;
    private String createdBy;

    public ControlRequirements(){

    }

    // USED
    public ControlRequirements(Integer controlId, String description, boolean compliance_status, Date created_at, Date updated_at, int frequency, Date last_snapshot_on, Date frequency_expiry_date) {
        this.controlId = controlId;
        this.description = description;
        this.compliance_status = compliance_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.frequency = frequency;
        this.last_snapshot_on = last_snapshot_on;
        this.frequency_expiry_date = frequency_expiry_date;
    }


    public ControlRequirements(Integer controlId, String org_key, String statement, Integer domain_id, String type, Integer owner_id, String health, Integer implementationStatusId, String implementationGuideline, Date implementationTargetDate, Date implementationDueDate, Integer ruleId, String applicabilityStatus, String createdBy, String description, boolean compliance_status, Date created_at, Date updated_at, int frequency, Date last_snapshot_on, Date frequency_expiry_date) {
        this.controlId = controlId;
        this.org_key = org_key;
        this.statement = statement;
        this.domain_id = domain_id;
        this.type = type;
        this.owner_id = owner_id;
        this.health = health;
        this.implementationStatusId = implementationStatusId;
        this.implementationGuideline = implementationGuideline;
        this.implementationTargetDate = implementationTargetDate;
        this.implementationDueDate = implementationDueDate;
        this.ruleId = ruleId;
        this.applicabilityStatus = applicabilityStatus;
        this.createdBy = createdBy;
        this.description = description;
        this.compliance_status = compliance_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.frequency = frequency;
        this.last_snapshot_on = last_snapshot_on;
        this.frequency_expiry_date = frequency_expiry_date;
    }

    public String getOrg_key() {
        return org_key;
    }

    public void setOrg_key(String org_key) {
        this.org_key = org_key;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Integer getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Integer domain_id) {
        this.domain_id = domain_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Integer implementationStatusId() {
        return implementationStatusId;
    }

    public void implementationStatusId(Integer implementatioStatusId) {
        this.implementationStatusId = implementatioStatusId;
    }

    public String getImplementationGuideline() {
        return implementationGuideline;
    }

    public void setImplementationGuideline(String implementationGuideline) {
        this.implementationGuideline = implementationGuideline;
    }

    public Date getImplementationTargetDate() {
        return implementationTargetDate;
    }

    public void setImplementationTargetDate(Date implementationTargetDate) {
        this.implementationTargetDate = implementationTargetDate;
    }

    public Date getImplementationDueDate() {
        return implementationDueDate;
    }

    public void setImplementationDueDate(Date implementationDueDate) {
        this.implementationDueDate = implementationDueDate;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getApplicabilityStatus() {
        return applicabilityStatus;
    }

    public void setApplicabilityStatus(String applicabilityStatus) {
        this.applicabilityStatus = applicabilityStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private String description;
    private boolean compliance_status;

    private Date created_at;


    private Date updated_at;


    private int frequency;

    private Date last_snapshot_on;

    private Date frequency_expiry_date;


    public Date getFrequency_expiry_date() {
        return frequency_expiry_date;
    }

    public void setFrequency_expiry_date(Date frequency_expiry_date) {
        this.frequency_expiry_date = frequency_expiry_date;
    }

    public Integer getControlId() {
        return controlId;
    }

    public void setControlId(Integer controlId) {
        this.controlId = controlId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompliance_status() {
        return compliance_status;
    }

    public void setCompliance_status(boolean compliance_status) {
        this.compliance_status = compliance_status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Date getLast_snapshot_on() {
        return last_snapshot_on;
    }

    public void setLast_snapshot_on(Date last_snapshot_on) {
        this.last_snapshot_on = last_snapshot_on;
    }
}
