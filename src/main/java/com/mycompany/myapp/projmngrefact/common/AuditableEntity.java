package com.mycompany.myapp.projmngrefact.common;

import java.time.LocalDateTime;

import static com.mycompany.myapp.projmngrefact.common.ChangingStatus.*;

public abstract class AuditableEntity {

  protected ChangingStatus changingStatus = NEW;
  protected LocalDateTime createdAt;
  protected Long createdBy;
  protected LocalDateTime lastUpdatedAt;
  protected Long lastUpdatedBy;

  public AuditableEntity(LocalDateTime createdAt, Long createdBy) {
    this.createdAt = createdAt;
    this.createdBy = createdBy;
  }

  public ChangingStatus getChangingStatus() {
    return changingStatus;
  }

  public void toUpdate() {
    this.changingStatus = MODIFIED;
  }

  public void toDelete() {
    this.changingStatus = DELETED;
  }

  public void toUnChange() {
    this.changingStatus = UNCHANGED;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public AuditableEntity setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
    this.lastUpdatedAt = lastUpdatedAt;
    return this;
  }

  public LocalDateTime getLastUpdatedAt() {
    return lastUpdatedAt;
  }

  public AuditableEntity setLastUpdatedBy(Long lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
    return this;
  }

  public Long getLastUpdatedBy() {
    return lastUpdatedBy;
  }
}
