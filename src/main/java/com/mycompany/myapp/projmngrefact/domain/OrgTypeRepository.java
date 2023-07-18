package com.mycompany.myapp.projmngrefact.domain;

public interface OrgTypeRepository {
  boolean existsByCodeAndStatus(long tenantId, String code, OrgTypeStatus status);

  Org findByIdAndStatus(long tenatId, long superiorId, OrgStatus status);
}
