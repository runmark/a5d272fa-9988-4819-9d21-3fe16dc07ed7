package com.mycompany.myapp.projmngrefact.domain.emp;

import com.mycompany.myapp.projmngrefact.common.AuditableEntity;
import java.time.LocalDateTime;

public class EmpPost extends AuditableEntity {

  private String postCode;

  public EmpPost(LocalDateTime createdAt, Long createdBy) {
    super(createdAt, createdBy);
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }
}
