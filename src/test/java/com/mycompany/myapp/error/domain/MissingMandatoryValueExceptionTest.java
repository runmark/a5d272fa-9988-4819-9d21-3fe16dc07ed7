package com.mycompany.myapp.error.domain;

import static org.assertj.core.api.Assertions.*;

import com.mycompany.myapp.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MissingMandatoryValueExceptionTest {

  public static final String FIELD = "field";

  @Test
  void shouldGetExceptionForBlankValue() {
    MissingMandatoryValueException exception = MissingMandatoryValueException.forBlankValue(FIELD);

    assertDefaultInformation(exception);
    assertThat(exception.getMessage()).isEqualTo("The field \"field\" is mandatory and wasn't set (blank)");
  }

  @Test
  void shouldGetExceptionForNullValue() {
    MissingMandatoryValueException exception = MissingMandatoryValueException.forNullValue(FIELD);

    assertDefaultInformation(exception);
    assertThat(exception.getMessage()).isEqualTo("The field \"field\" is mandatory and wasn't set (null)");
  }

  @Test
  void shouldGetExceptionForEmptyCollection() {
    MissingMandatoryValueException exception = MissingMandatoryValueException.forEmptyValue(FIELD);

    assertDefaultInformation(exception);
    assertThat(exception.getMessage()).isEqualTo("The field \"field\" is mandatory and wasn't set (empty)");
  }

  private void assertDefaultInformation(MissingMandatoryValueException exception) {
    assertThat(exception.type()).isEqualByComparingTo(AssertionErrorType.MISSING_MANDATORY_VALUE);
    assertThat(exception.field()).isEqualTo(FIELD);
    assertThat(exception.parameters()).isEmpty();
  }
}
