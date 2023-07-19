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

  public OrgType findSuperiorOrgType(Long tenant, Long superior, Org superiorOrg) {
    return orgTypeRepository
      .findByCodeAndStatus(tenant, superiorOrg.getOrgTypeCode(), OrgTypeStatus.EFFECTIVE)
      .orElseThrow(() ->
        new DirtyDataException("id 为 '" + superior + "' 的组织的组织类型代码 '" + superiorOrg.getOrgTypeCode() + "' 无效!")
      );
  }

  // 开发中心和直属部门的上级只能是企业
  public void SuperiorOfDevCenterAndDirectDeptMustEntp(Long superior, String orgType, OrgType superiorOrgType) {
    if (("DEVCENT".equals(orgType) || "DIRDEP".equals(orgType)) && !"ENTP".equals(superiorOrgType.getCode())) {
      throw new BusinessException("开发中心或直属部门的上级(id = '" + superior + "')不是企业！");
    }
  }

  // 开发组的上级只能是开发中心
  public void superiorOfDevGroupMustDevCenter(Long superior, String orgType, OrgType superiorOrgType) {
    if ("DEVGRP".equals(orgType) && !"DEVCENT".equals(superiorOrgType.getCode())) {
      throw new BusinessException("开发组的上级(id = '" + superior + "')不是开发中心！");
    }
  }
}
