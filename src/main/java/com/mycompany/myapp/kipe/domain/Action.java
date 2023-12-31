package com.mycompany.myapp.kipe.domain;

import com.mycompany.myapp.error.domain.Assert;

public record Action(String action) {
  public Action {
    Assert.notBlank("action", action);
  }
  
  @Override
  public String toString() {
    return action();
  }
}
