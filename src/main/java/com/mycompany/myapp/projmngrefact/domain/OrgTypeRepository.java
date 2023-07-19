package com.mycompany.myapp.projmngrefact.domain;

import java.util.Optional;

public interface OrgTypeRepository {
  boolean existsByCodeAndStatus(long tenantId, String code, OrgTypeStatus status);

  Org findByIdAndStatus(long tenatId, long superiorId, OrgStatus status);

  Optional<OrgType> findByCodeAndStatus(long tenantId, String code, OrgTypeStatus status);
}
