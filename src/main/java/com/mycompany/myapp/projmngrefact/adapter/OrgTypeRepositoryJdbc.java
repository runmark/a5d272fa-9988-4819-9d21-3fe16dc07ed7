package com.mycompany.myapp.projmngrefact.adapter;

import com.mycompany.myapp.projmngrefact.domain.OrgTypeRepository;
import com.mycompany.myapp.projmngrefact.domain.OrgTypeStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrgTypeRepositoryJdbc implements OrgTypeRepository {

  private final JdbcTemplate jdbcTemplate;

  public OrgTypeRepositoryJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public int countByCodeAndStatus(long tenantId, String code, OrgTypeStatus status) {
    return jdbcTemplate.queryForObject(
      "select count(*) from org_type where tenant_id=? and code=? and status=?",
      Integer.class,
      tenantId,
      code,
      status.code()
    );
  }

  @Override
  public boolean existsByCodeAndStatus(long tenantId, String code, OrgTypeStatus status) {
    return countByCodeAndStatus(tenantId, code, status) > 0;
  }
}
