package com.mycompany.myapp.projmngrefact.domain.emp;

import com.mycompany.myapp.projmngrefact.common.AuditableEntity;
import java.util.List;

public class Emp extends AuditableEntity {

  private Long id;
  private final Long tenantId;
  private Long orgId;

  private List<Skill> skills;
  private List<WorkExperience> workExperiences;
  private List<String> postCode;
}
