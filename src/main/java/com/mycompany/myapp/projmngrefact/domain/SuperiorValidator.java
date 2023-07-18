package com.mycompany.myapp.projmngrefact.domain;

public class SuperiorValidator {

  private final OrgTypeRepository orgTypeRepository;
  private final OrgRepository orgRepository;

  SuperiorValidator(OrgTypeRepository orgTypeRepository, OrgRepository orgRepository) {
    this.orgTypeRepository = orgTypeRepository;
    this.orgRepository = orgRepository;
  }

  public Org superiorShouldEffective(Long tenantId, Long superiorId) {
    return orgRepository
      .findByIdAndStatus(tenantId, superiorId, OrgStatus.EFFECTIVE)
      .orElseThrow(() -> new BusinessException("'" + superiorId + "' 不是有效的组织 id !"));
  }
}
