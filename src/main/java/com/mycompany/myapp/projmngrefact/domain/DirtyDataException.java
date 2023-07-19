package com.mycompany.myapp.projmngrefact.domain;

public class DirtyDataException extends RuntimeException {

  public DirtyDataException(String message) {
    super(message);
  }
}
