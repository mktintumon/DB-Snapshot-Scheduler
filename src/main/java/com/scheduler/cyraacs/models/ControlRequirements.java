package com.scheduler.cyraacs.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ControlRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer controlId;

    private String orgKey;
    private String statement;
    private Integer domainId;
    private String type;
    private Integer ownerId;
    private String frequency;
    private String health;
    private Integer ruleId;
    private String createdBy;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private Date lastSnapshotOn;
    private boolean complianceStatus;
    private Date frequencyExpiryDate;
    private String applicabilityStatus;
    private Integer implementationStatusId;
    private String implementationGuideline;
    private Date implementationTargetDate;
    private Date implementationDueDate;

    public ControlRequirements() {

    }

    // USED
    public ControlRequirements(Integer controlId, String description, boolean complianceStatus, Date createdAt,Date updatedAt, String frequency, Date lastSnapshotOn, Date frequencyExpiryDate) {
        this.controlId = controlId;
        this.description = description;
        this.complianceStatus = complianceStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.frequency = frequency;
        this.lastSnapshotOn = lastSnapshotOn;
        this.frequencyExpiryDate = frequencyExpiryDate;
    }

    public ControlRequirements(Integer controlId, String orgKey, String statement, Integer domainId, String type,
            Integer ownerId, String health, Integer implementationStatusId, String implementationGuideline,
            Date implementationTargetDate, Date implementationDueDate, Integer ruleId, String applicabilityStatus,
            String createdBy, String description, boolean complianceStatus, Date createdAt, Date updatedAt,
            String frequency, Date lastSnapshotOn, Date frequencyExpiryDate) {
        this.controlId = controlId;
        this.orgKey = orgKey;
        this.statement = statement;
        this.domainId = domainId;
        this.type = type;
        this.ownerId = ownerId;
        this.health = health;
        this.implementationStatusId = implementationStatusId;
        this.implementationGuideline = implementationGuideline;
        this.implementationTargetDate = implementationTargetDate;
        this.implementationDueDate = implementationDueDate;
        this.ruleId = ruleId;
        this.applicabilityStatus = applicabilityStatus;
        this.createdBy = createdBy;
        this.description = description;
        this.complianceStatus = complianceStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.frequency = frequency;
        this.lastSnapshotOn = lastSnapshotOn;
        this.frequencyExpiryDate = frequencyExpiryDate;
    }

    public Integer getControlId() {
        return controlId;
    }

    public void setControlId(Integer controlId) {
        this.controlId = controlId;
    }

    public String getOrgKey() {
        return orgKey;
    }

    public void setOrgKey(String orgKey) {
        this.orgKey = orgKey;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Integer getImplementationStatusId() {
        return implementationStatusId;
    }

    public void setImplementationStatusId(Integer implementationStatusId) {
        this.implementationStatusId = implementationStatusId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplianceStatus() {
        return complianceStatus;
    }

    public void setComplianceStatus(boolean complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getLastSnapshotOn() {
        return lastSnapshotOn;
    }

    public void setLastSnapshotOn(Date lastSnapshotOn) {
        this.lastSnapshotOn = lastSnapshotOn;
    }

    public Date getFrequencyExpiryDate() {
        return frequencyExpiryDate;
    }

    public void setFrequencyExpiryDate(Date frequencyExpiryDate) {
        this.frequencyExpiryDate = frequencyExpiryDate;
    }

    

}