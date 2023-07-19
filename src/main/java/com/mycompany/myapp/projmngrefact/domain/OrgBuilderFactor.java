package com.mycompany.myapp.projmngrefact.domain;

import org.springframework.stereotype.Component;

@Component
public class OrgBuilderFactor {

  private final CommonValidator commonValidator;
  private final OrgTypeValidator orgTypeValidator;
  private final SuperiorValidator superiorValidator;
  private final OrgNameValidator orgNameValidator;
  private final OrgLeaderValidator orgLeaderValidator;

  public OrgBuilderFactor(
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

  public OrgBuilder create() {
    return new OrgBuilder(commonValidator, orgTypeValidator, superiorValidator, orgNameValidator, orgLeaderValidator);
  }
}
