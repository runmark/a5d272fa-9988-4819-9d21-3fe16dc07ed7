package com.mycompany.myapp.dummy.application;

import com.mycompany.myapp.dummy.domain.BeerId;
import com.mycompany.myapp.kipe.application.AccessChecker;
import com.mycompany.myapp.kipe.application.AccessContext;
import com.mycompany.myapp.kipe.application.ProjectsysAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerIdAccessChecker implements AccessChecker<BeerId> {

  private final ProjectsysAuthorizations authorizations;

  public BeerIdAccessChecker(ProjectsysAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerId> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
