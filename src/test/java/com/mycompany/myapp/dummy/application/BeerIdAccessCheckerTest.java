package com.mycompany.myapp.dummy.application;

import static com.mycompany.myapp.dummy.domain.BeersIdentityFixture.*;
import static com.mycompany.myapp.kipe.application.TestAuthentications.*;
import static org.assertj.core.api.Assertions.*;

import com.mycompany.myapp.UnitTest;
import com.mycompany.myapp.kipe.application.AccessContext;
import com.mycompany.myapp.kipe.application.ProjectsysAuthorizations;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class BeerIdAccessCheckerTest {

  private static final BeerIdAccessChecker checker = new BeerIdAccessChecker(
    new ProjectsysAuthorizations(List.of(new BeersAccessesConfiguration().beersAccesses()))
  );

  @Test
  void shouldNotAuthorizedUnauthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "unauthorized", cloackOfFeathersId()))).isFalse();
  }

  @Test
  void shouldAuthorizedAuthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "create", cloackOfFeathersId()))).isTrue();
  }
}
