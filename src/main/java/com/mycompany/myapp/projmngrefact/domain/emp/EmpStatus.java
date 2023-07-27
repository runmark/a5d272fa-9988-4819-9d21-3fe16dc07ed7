package com.mycompany.myapp.projmngrefact.domain.emp;

import com.mycompany.myapp.projmngrefact.domain.BusinessException;

public enum EmpStatus {
  REGULAR("REGULAR", "正式"),
  PROBATION("PROBATION", "试用"),
  REGISTRATION("REGISTRATION", "登记"),
  RETIREMENT("RETIREMENT", "退休"),
  DISMISSAL("DISMISSAL", "离职"),
  TERMINATED("TERMINATED", "解雇");

  private final String code;
  private final String desc;

  private EmpStatus(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String code() {
    return code;
  }

  public static EmpStatus ofCode(String code) {
    for (EmpStatus status : EmpStatus.values()) {
      if (status.code.equals(code)) {
        return status;
      }
    }
    throw new IllegalArgumentException("无效的员工状态代码：" + code);
  }

  public EmpStatus becomeRegular() {
    if (this != PROBATION) {
      throw new BusinessException("只有试用员工才能转正");
    }
    return REGULAR;
  }

  public EmpStatus terminate() {
    if (this == TERMINATED) {
      throw new BusinessException("员工已经是解雇状态");
    }
    return TERMINATED;
  }
}
