package com.mycompany.myapp.projmngrefact.adapter;

import com.mycompany.myapp.projmngrefact.domain.Org;
import com.mycompany.myapp.projmngrefact.domain.OrgStatus;
import com.mycompany.myapp.projmngrefact.domain.OrgType;
import com.mycompany.myapp.projmngrefact.domain.OrgTypeRepository;
import com.mycompany.myapp.projmngrefact.domain.OrgTypeStatus;
import java.util.Optional;
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

  @Override
  public Org findByIdAndStatus(long tenatId, long superiorId, OrgStatus status) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByIdAndStatus'");
  }

  @Override
  public Optional<OrgType> findByCodeAndStatus(long tenantId, String code, OrgTypeStatus status) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByCodeAndStatus'");
  }
}
