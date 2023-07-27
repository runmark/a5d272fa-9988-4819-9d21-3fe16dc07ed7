package com.mycompany.myapp.projmng.domain.orgmng;

import java.time.LocalDateTime;

import com.mycompany.myapp.projmngrefact.domain.OrgLeaderValidator;
import com.mycompany.myapp.projmngrefact.domain.OrgNameValidator;
import com.mycompany.myapp.projmngrefact.domain.OrgTypeValidator;
import com.mycompany.myapp.projmngrefact.domain.SuperiorValidator;

public class OrgBuilder {

  private final CommonTenantValidator assertOrgTenant;
  private final OrgTypeValidator assertOrgType;
  private final SuperiorValidator assertSuperior;
  private final OrgNameValidator assertOrgName;
  private final OrgLeaderValidator assertOrgLeader;

  private Long tenantId;
  private Long superiorId;
  private String orgTypeCode;
  private Long leaderId;
  private String name;
  private Long createdBy;

  OrgBuilder(CommonTenantValidator assertOrgTenant, OrgTypeValidator assertOrgType, SuperiorValidator assertSuperior,
      OrgNameValidator assertOrgName, OrgLeaderValidator assertOrgLeader) {

    this.assertOrgTenant = assertOrgTenant;
    this.assertOrgType = assertOrgType;
    this.assertSuperior = assertSuperior;
    this.assertOrgName = assertOrgName;
    this.assertOrgLeader = assertOrgLeader;
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
    org.setLeaderId(this.leaderId);
    org.setName(this.name);
    org.setSuperiorId(this.superiorId);

    return org;
  }

  private void validate() {
    validateOrgTenant();
    validateOrgLeader();
    validateOrgType();
    validateSuperior();
    validateOrgName();
  }

  private void validateOrgLeader() {
    assertOrgLeader.shouldEffective(tenantId, leaderId);
  }

  private void validateOrgTenant() {
    assertOrgTenant.shouldEffective(tenantId);
  }

  private void validateOrgName() {
    assertOrgName.shouldNotEmpty(name);
    assertOrgName.shouldNotDuplicatedInSameSuperior(tenantId, superiorId, name);
  }

  private void validateSuperior() {
    Org superiorOrg = assertSuperior.shouldEffective(tenantId, superiorId);
    OrgType superiorOrgType = assertSuperior.orgTypeShouldEffective(tenantId, superiorId, superiorOrg);
    assertSuperior.ofDevGroupMustDevCenter(superiorId, orgTypeCode, superiorOrgType);
    assertSuperior.ofDevCenterAndDirectDeptMustEntp(superiorId, orgTypeCode, superiorOrgType);
  }

  private void validateOrgType() {
    assertOrgType.shouldNotEmpty(orgTypeCode);
    assertOrgType.shouldEffective(tenantId, orgTypeCode);
    assertOrgType.shouldNotEntp(orgTypeCode);
  }

}
