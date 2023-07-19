package com.mycompany.myapp.projmngrefact.domain;

public interface EmpRepository {
  boolean existsByIdAndStatus(long tenantId, long id, EmpStatus... status);
}
