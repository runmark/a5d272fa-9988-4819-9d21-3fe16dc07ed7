package com.mycompany.myapp.projmngrefact.adapter;

import com.mycompany.myapp.projmngrefact.domain.emp.Emp;
import com.mycompany.myapp.projmngrefact.domain.emp.EmpRepository;
import com.mycompany.myapp.projmngrefact.domain.emp.EmpStatus;

import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpRepositoryJdbc implements EmpRepository {

  private final JdbcTemplate jdbc;

  public EmpRepositoryJdbc(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public boolean existByIdAndStatus(Long tenantId, Long id, EmpStatus... statuses) {
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

  @Override
  public boolean save(Emp emp) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

  // @Override
  // public boolean existByIdAndStatus(Long tenant, Long id, EmpStatus...
  // statuses) {
  // // TODO Auto-generated method stub
  // throw new UnsupportedOperationException("Unimplemented method
  // 'existByIdAndStatus'");
  // }

  @Override
  public Optional<Emp> findById(Long tenantId, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }
}
