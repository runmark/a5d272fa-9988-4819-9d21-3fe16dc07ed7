package com.mycompany.myapp.projmngrefact.application;

import com.mycompany.myapp.projmngrefact.domain.Org;
import com.mycompany.myapp.projmngrefact.domain.OrgBuilder;
import com.mycompany.myapp.projmngrefact.domain.OrgBuilderFactor;
import com.mycompany.myapp.projmngrefact.domain.OrgRepository;

public class OrgService {

  private final OrgBuilderFactor orgBuilderFactor;
  private final OrgRepository orgRepository;

  public OrgService(OrgBuilderFactor orgBuilderFactor, OrgRepository orgRepository) {
    this.orgBuilderFactor = orgBuilderFactor;
    this.orgRepository = orgRepository;
  }

  public OrgResponse addOrg(CreateOrgRequest request, Long userId) {
    OrgBuilder builder = orgBuilderFactor.create();

    Org org = builder
      .tenantId(request.getTenantId())
      .orgTypeCode(request.getOrgTypeCode())
      .leaderId(request.getLeaderId())
      .superiorId(request.getSuperiorId())
      .name(request.getName())
      .createdBy(userId)
      .build();

    orgRepository.save(org);
    return buildOrgDto(org);
  }

  private static OrgResponse buildOrgDto(Org org) {
    OrgResponse response = new OrgResponse();
    response.setId(org.getId());
    response.setTenantId(org.getTenantId());
    response.setOrgTypeCode(org.getOrgTypeCode());
    response.setName(org.getName());
    response.setLeaderId(org.getLeaderId());
    response.setSuperiorId(org.getSuperiorId());
    response.setCreatedBy(org.getCreatedBy());
    response.setCreatedAt(org.getCreatedAt());
    response.setLastUpdatedBy(org.getLastUpdatedBy());
    response.setLastUpdatedAt(org.getLastUpdatedAt());
    return response;
  }
}
