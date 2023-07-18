package com.mycompany.myapp.projmngrefact.domain;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }
}
