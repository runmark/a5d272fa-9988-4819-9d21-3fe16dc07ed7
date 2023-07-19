package com.mycompany.myapp.projmngrefact.adapter;

import com.mycompany.myapp.projmngrefact.domain.EmpRepository;
import com.mycompany.myapp.projmngrefact.domain.EmpStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpRepositoryJdbc implements EmpRepository {

  private final JdbcTemplate jdbc;

  public EmpRepositoryJdbc(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public boolean existsByIdAndStatus(long tenantId, long id, EmpStatus... statuses) {
    final String sql = "select count(*) from emp where tenant_id=? and id=? ";

    if (statuses.length > 0) {
      StringBuilder orSql = new StringBuilder(sql).append(" and ( status='' ");
      for (EmpStatus status : statuses) {
        orSql.append(" or status='").append(status.code()).append("' ");
      }
      orSql.append(")");
    }

    return jdbc.queryForObject(sql, Integer.class, tenantId, id) > 0;
  }
}
