package com.mycompany.myapp.dummy.application;

import com.mycompany.myapp.dummy.domain.beer.BeerToCreate;
import com.mycompany.myapp.kipe.application.AccessChecker;
import com.mycompany.myapp.kipe.application.AccessContext;
import com.mycompany.myapp.kipe.application.ProjectsysAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerToCreateAccessChecker implements AccessChecker<BeerToCreate> {

  private final ProjectsysAuthorizations authorizations;

  public BeerToCreateAccessChecker(ProjectsysAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerToCreate> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
