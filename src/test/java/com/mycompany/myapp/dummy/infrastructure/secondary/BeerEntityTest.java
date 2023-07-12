package com.mycompany.myapp.dummy.infrastructure.secondary;

import static org.assertj.core.api.Assertions.*;
import static com.mycompany.myapp.dummy.domain.beer.BeersFixture.*;

import org.junit.jupiter.api.Test;
import com.mycompany.myapp.UnitTest;

@UnitTest
class BeerEntityTest {

  @Test
  void shouldConvertFromAndToDomain() {
    assertThat(BeerEntity.from(beer()).toDomain()).usingRecursiveComparison().isEqualTo(beer());
  }
}
