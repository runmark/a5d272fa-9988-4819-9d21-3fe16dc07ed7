package com.mycompany.myapp.projmngrefact.adapter;

import com.mycompany.myapp.projmngrefact.domain.Org;
import com.mycompany.myapp.projmngrefact.domain.OrgRepository;
import com.mycompany.myapp.projmngrefact.domain.OrgStatus;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class OrgRepositoryJdbc implements OrgRepository {

  private final JdbcTemplate jdbc;
  private final SimpleJdbcInsert insertOrg;

  @Override
  public Org save(Org org) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

  @Override
  public Optional<Org> findById(Long tenantId, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public Optional<Org> findByIdAndStatus(Long tenantId, Long id, OrgStatus status) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByIdAndStatus'");
  }

  @Override
  public boolean existsBySuperiorAndName(Long tenant, Long superior, String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'existsBySuperiorAndName'");
  }

  @Override
  public int update(Org org) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }
}
