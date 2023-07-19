package com.mycompany.myapp.projmngrefact.domain;

import static com.mycompany.myapp.projmngrefact.common.StringUtil.isBlank;

public class OrgNameValidator {

  private final OrgRepository orgRepository;

  OrgNameValidator(OrgRepository orgRepository) {
    this.orgRepository = orgRepository;
  }

  public void orgNameShouldNotEmpty(String name) {
    if (isBlank(name)) {
      throw new BusinessException("org name should not be empty");
    }
  }

  public void nameShouldNotDuplicatedInSameSuperior(Long tenantId, Long superiorId, String name) {}
}
