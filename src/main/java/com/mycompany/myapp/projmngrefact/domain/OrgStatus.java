package com.mycompany.myapp.projmngrefact.domain;

import java.util.Arrays;

public enum OrgStatus {
  EFFECTIVE("EF", "effective"),
  CANCELLED("CA", "canceled");

  private final String code;
  private final String desc;

  OrgStatus(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String code() {
    return code;
  }

  public static OrgStatus ofCode(String code) {
    // for (OrgStatus status : OrgStatus.values()) {
    // if (status.code.equals(code)) {
    // return status;
    // }
    // }
    // throw new IllegalArgumentException("invalid code: " + code);

    return Arrays
      .stream(values())
      .filter(status -> status.code.equals(code))
      .findFirst()
      .orElseThrow(() -> new BusinessException(code + "不是有效的组织状态代码！"));
  }
}
