package com.mycompany.myapp.projmngrefact.domain;

import java.time.LocalDateTime;

public class OrgBuilder {

  private final CommonValidator commonValidator;
  private final OrgTypeValidator orgTypeValidator;
  private final SuperiorValidator superiorValidator;
  private final OrgNameValidator orgNameValidator;
  private final OrgLeaderValidator orgLeaderValidator;

  private Long tenantId;
  private Long superiorId;
  private String orgTypeCode;
  private Long leaderId;
  private String name;
  private Long createdBy;

  OrgBuilder(
    CommonValidator commonValidator,
    OrgTypeValidator orgTypeValidator,
    SuperiorValidator superiorValidator,
    OrgNameValidator orgNameValidator,
    OrgLeaderValidator orgLeaderValidator
  ) {
    this.commonValidator = commonValidator;
    this.orgTypeValidator = orgTypeValidator;
    this.superiorValidator = superiorValidator;
    this.orgNameValidator = orgNameValidator;
    this.orgLeaderValidator = orgLeaderValidator;
  }

  public OrgBuilder tenantId(Long tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public OrgBuilder superiorId(Long superiorId) {
    this.superiorId = superiorId;
    return this;
  }

  public OrgBuilder orgTypeCode(String orgTypeCode) {
    this.orgTypeCode = orgTypeCode;
    return this;
  }

  public OrgBuilder leaderId(Long leaderId) {
    this.leaderId = leaderId;
    return this;
  }

  public OrgBuilder name(String name) {
    this.name = name;
    return this;
  }

  public OrgBuilder createdBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Org build() {
    validate();

    Org org = new Org(tenantId, orgTypeCode, LocalDateTime.now(), createdBy);
    org.setLeaderId(leaderId);
    org.setName(name);
    org.setSuperiorId(superiorId);

    return org;
  }

  private void validate() {
    commonValidator.tenantShouldValid(tenantId);
    orgLeaderValidator.orgLeaderShouldValid(tenantId, leaderId);

    orgNameValidator.orgNameShouldNotEmpty(name);
    orgNameValidator.nameShouldNotDuplicatedInSameSuperior(tenantId, superiorId, name);

    orgTypeValidator.orgTypeShouldNotEmpty(orgTypeCode);
    orgTypeValidator.orgTypeShouldBeValid(tenantId, orgTypeCode);
    orgTypeValidator.shouldNotCreateEntpAlone(orgTypeCode);

    Org superiorOrg = superiorValidator.superiorShouldEffective(tenantId, superiorId);
    OrgType superiorOrgType = superiorValidator.findSuperiorOrgType(tenantId, superiorId, superiorOrg);
    superiorValidator.superiorOfDevGroupMustDevCenter(superiorId, orgTypeCode, superiorOrgType);
    superiorValidator.SuperiorOfDevCenterAndDirectDeptMustEntp(superiorId, orgTypeCode, superiorOrgType);
  }
}
