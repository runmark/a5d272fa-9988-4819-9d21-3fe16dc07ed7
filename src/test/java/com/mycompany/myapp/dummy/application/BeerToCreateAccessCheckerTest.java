package com.mycompany.myapp.dummy.application;

import static com.mycompany.myapp.dummy.domain.beer.BeersFixture.*;
import static com.mycompany.myapp.kipe.application.TestAuthentications.*;
import static org.assertj.core.api.Assertions.*;

import com.mycompany.myapp.UnitTest;
import com.mycompany.myapp.kipe.application.AccessContext;
import com.mycompany.myapp.kipe.application.ProjectsysAuthorizations;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class BeerToCreateAccessCheckerTest {

  private static final BeerToCreateAccessChecker checker = new BeerToCreateAccessChecker(
    new ProjectsysAuthorizations(List.of(new BeersAccessesConfiguration().beersAccesses()))
  );

  @Test
  void shouldNotAuthorizedUnauthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "unauthorized", beerToCreate()))).isFalse();
  }

  @Test
  void shouldAuthorizedAuthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "create", beerToCreate()))).isTrue();
  }
}
