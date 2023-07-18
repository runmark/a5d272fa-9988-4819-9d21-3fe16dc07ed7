package com.mycompany.myapp.projmngrefact.domain;

import java.util.Arrays;

public enum OrgTypeStatus {
  EFFECTIVE("EF", "effective"),
  TERMINATED("TE", "terminated");

  private String code;
  private String desc;

  private OrgTypeStatus(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String code() {
    return code;
  }

  public static OrgTypeStatus ofCode(String code) {
    return Arrays
      .stream(values())
      .filter(v -> v.code.equals(code))
      .findAny()
      .orElseThrow(() -> new IllegalArgumentException("Unknown code: " + code));
  }
}
