package com.mycompany.myapp.projmngrefact.domain;

public enum TenantStatus {
  EFFECTIVE("EF", "effective"),
  TERMINATED("TE", "terminated");

  private final String code;
  private final String desc;

  TenantStatus(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String code() {
    return code;
  }
}
