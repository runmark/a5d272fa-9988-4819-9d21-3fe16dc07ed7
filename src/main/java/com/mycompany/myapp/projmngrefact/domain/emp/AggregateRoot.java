package com.mycompany.myapp.projmngrefact.domain.emp;

import com.mycompany.myapp.projmngrefact.common.AuditableEntity;
import java.time.LocalDateTime;

public class AggregateRoot extends AuditableEntity {

  public AggregateRoot(LocalDateTime createdAt, Long createdBy) {
    super(createdAt, createdBy);
  }

  protected Long version;

  public Long getVersion() {
    return version;
  }
}
