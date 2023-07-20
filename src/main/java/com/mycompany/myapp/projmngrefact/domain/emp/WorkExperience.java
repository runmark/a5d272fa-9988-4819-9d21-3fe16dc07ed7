package com.mycompany.myapp.projmngrefact.domain.emp;

import com.mycompany.myapp.projmngrefact.common.AuditableEntity;
import java.time.LocalDateTime;

public class WorkExperience extends AuditableEntity {

  private Long id;
  private final Long tenantId;
  private final Period period;
  private String companyName;

  WorkExperience(Long tenantId, Period period, Long createdBy) {
    super(LocalDateTime.now(), createdBy);
    this.tenantId = tenantId;
    this.period = period;
  }

  WorkExperience(Long id, Long tenantId, Period period, Long createdBy) {
    this(tenantId, period, createdBy);
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public Period getPeriod() {
    return this.period;
  }

  public String getCompany() {
    return companyName;
  }

  WorkExperience setCompany(String company) {
    this.companyName = company;
    return this;
  }
}
