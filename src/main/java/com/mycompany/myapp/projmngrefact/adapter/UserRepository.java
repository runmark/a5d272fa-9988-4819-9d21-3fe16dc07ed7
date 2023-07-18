package com.mycompany.myapp.projmngrefact.adapter;

public class UserRepository {

  public int countByIdAndStatus(long tenantId, long id, UserStatus status) {
    return 0;
  }

  public boolean existsByIdAndStatus(long tenantId, long id, UserStatus status) {
    return countByIdAndStatus(tenantId, id, status) > 0;
  }
}
