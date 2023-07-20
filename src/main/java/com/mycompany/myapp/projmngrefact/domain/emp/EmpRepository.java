package com.mycompany.myapp.projmngrefact.domain.emp;

public interface EmpRepository {
  boolean existsByIdAndStatus(long tenantId, long id, EmpStatus... status);
}
