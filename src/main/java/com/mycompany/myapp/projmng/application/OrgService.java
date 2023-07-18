package com.mycompany.myapp.projmng.application;

import com.mycompany.myapp.projmng.domain.orgmng.Org;
import com.mycompany.myapp.projmng.domain.orgmng.OrgBuilder;
import com.mycompany.myapp.projmng.domain.orgmng.OrgBuilderFactor;

public class OrgService {

  private final OrgBuilderFactor orgBuilderFactory;

  public OrgService(OrgBuilderFactor orgBuilderFactory) {
    this.orgBuilderFactory = orgBuilderFactory;
  }

  public OrgResponse addOrg(CreateOrgRequest request, Integer userId) {
    OrgBuilder orgBuilder = orgBuilderFactory.create();

    Org org = orgBuilder
      .tenantId(request.getTenantId())
      .superiorId(request.getSuperiorId())
      .orgTypeCode(request.getOrgTypeCode())
      .leaderId(request.getLeaderId())
      .name(request.getName())
      .build();
  }
}
