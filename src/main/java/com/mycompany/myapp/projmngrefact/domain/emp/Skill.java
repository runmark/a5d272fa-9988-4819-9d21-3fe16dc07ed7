package com.mycompany.myapp.projmngrefact.domain.emp;

import com.mycompany.myapp.projmngrefact.common.AuditableEntity;
import java.time.LocalDateTime;

public class Skill extends AuditableEntity {

  private Long id;
  private final Long tenantId;
  private final Long skillTypeId;
  private SkillLevel level;
  private Integer duration;

  Skill(Long tenantId, Long skillTypeId, Long createdBy) {
    super(LocalDateTime.now(), createdBy);
    this.tenantId = tenantId;
    this.skillTypeId = skillTypeId;
  }

  public Long getId() {
    return id;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public Long getSkillTypeId() {
    return skillTypeId;
  }

  public SkillLevel getLevel() {
    return level;
  }

  Skill setLevel(SkillLevel level) {
    this.level = level;
    return this;
  }

  public Integer getDuration() {
    return duration;
  }

  Skill setDuration(Integer duration) {
    this.duration = duration;
    return this;
  }
}
