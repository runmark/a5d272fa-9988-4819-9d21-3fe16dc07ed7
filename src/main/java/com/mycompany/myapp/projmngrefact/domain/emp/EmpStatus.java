package com.mycompany.myapp.projmngrefact.domain.emp;

public enum EmpStatus {
  REGULAR("REGULAR", "正式"),
  PROBATION("PROBATION", "试用"),
  REGISTRATION("REGISTRATION", "登记"),
  RETIREMENT("RETIREMENT", "退休"),
  DISMISSAL("DISMISSAL", "离职");

  private final String code;
  private final String desc;

  private EmpStatus(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String code() {
    return code;
  }
}
