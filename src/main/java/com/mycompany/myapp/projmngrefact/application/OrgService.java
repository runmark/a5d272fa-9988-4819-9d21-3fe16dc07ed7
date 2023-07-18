package com.mycompany.myapp.projmngrefact.application;

import com.mycompany.myapp.projmngrefact.domain.OrgBuilderFactor;

public class OrgService {

  private final OrgBuilderFactor orgBuilderFactor;
  private final OrgRepository orgRepository;
  private final OrgHandler orgHandler;

  public OrgService(OrgBuilderFactor orgBuilderFactor, OrgRepository orgRepository, OrgHandler orgHandler) {
    this.orgBuilderFactor = orgBuilderFactor;
    this.orgRepository = orgRepository;
    this.orgHandler = orgHandler;
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

    Org org = builder.build(request, userId);
    orgRepository.save(org);
    return orgHandler.handle(org);
  }
}
