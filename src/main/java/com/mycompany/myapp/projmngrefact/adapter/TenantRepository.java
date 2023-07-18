package com.mycompany.myapp.projmngrefact.adapter;

import com.mycompany.myapp.projmngrefact.domain.TenantStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TenantRepository {

  private final JdbcTemplate jdbcTemplate;

  public TenantRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public int countById(long id) {
    return jdbcTemplate.queryForObject("select count(*) from tenant where id = ?", Integer.class, id);
  }

  public int countByIdAndStatus(long id, TenantStatus status) {
    return jdbcTemplate.queryForObject("select count(*) from tenants where id = ? and status = ?", Integer.class, id, status.code());
  }

  public boolean existsByIdAndStatus(long id, TenantStatus status) {
    return countByIdAndStatus(id, status) > 0;
  }
}
