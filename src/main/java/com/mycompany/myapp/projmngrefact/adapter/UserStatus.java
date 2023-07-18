package com.mycompany.myapp.projmngrefact.adapter;

public enum UserStatus {
  EFFECTIVE("EF", "effective"),
  TERMINATED("TE", "terminated");

  private String code;
  private String desc;

  private UserStatus(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String code() {
    return code;
  }
}
