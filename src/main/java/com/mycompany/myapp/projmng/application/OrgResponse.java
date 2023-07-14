package com.mycompany.myapp.projmng.application;

import java.time.LocalDateTime;

public class OrgResponse {

  private Integer id;
  private Integer tenantId;
  private Integer superiorId;
  private String orgTypeCode;
  private Integer leaderId;
  private String name;
  private String statusCode;
  private LocalDateTime createdAt;
  private Integer createdBy;
  private LocalDateTime lastUpdatedAt;
  private Integer lastUpdatedBy;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getTenantId() {
    return tenantId;
  }

  public void setTenantId(Integer tenantId) {
    this.tenantId = tenantId;
  }

  public Integer getSuperiorId() {
    return superiorId;
  }

  public void setSuperiorId(Integer superiorId) {
    this.superiorId = superiorId;
  }

  public String getOrgTypeCode() {
    return orgTypeCode;
  }

  public void setOrgTypeCode(String orgTypeCode) {
    this.orgTypeCode = orgTypeCode;
  }

  public Integer getLeaderId() {
    return leaderId;
  }

  public void setLeaderId(Integer leaderId) {
    this.leaderId = leaderId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getLastUpdatedAt() {
    return lastUpdatedAt;
  }

  public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
    this.lastUpdatedAt = lastUpdatedAt;
  }

  public Integer getLastUpdatedBy() {
    return lastUpdatedBy;
  }

  public void setLastUpdatedBy(Integer lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  @Override
  public String toString() {
    return (
      "OrgDto{" +
      "id=" +
      id +
      ", tenant=" +
      tenantId +
      ", superior=" +
      superiorId +
      ", orgType='" +
      orgTypeCode +
      '\'' +
      ", leader=" +
      leaderId +
      ", name='" +
      name +
      '\'' +
      ", createdAt=" +
      createdAt +
      ", createdBy=" +
      createdBy +
      ", lastUpdatedAt=" +
      lastUpdatedAt +
      ", lastUpdatedBy=" +
      lastUpdatedBy +
      '}'
    );
  }
}
