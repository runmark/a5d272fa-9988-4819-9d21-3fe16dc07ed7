package com.mycompany.myapp.projmng.domain.orgmng;

import com.mycompany.myapp.projmngrefact.common.WithCode;
import com.mycompany.myapp.projmngrefact.domain.BusinessException;
import java.util.Arrays;

/**
 * The Gender enumeration.
 */
public enum Gender implements WithCode {
  MALE("M", "男"),
  FEMALE("F", "女"),
  OTHER("O", "其他");

  private final String code;
  private final String desc;

  Gender(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  @Override
  public String code() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'code'");
  }

  public static Gender ofCode(String code) {
    return Arrays.stream(values()).filter(v -> v.code.equals(code)).findFirst().orElseThrow(() -> new BusinessException("code error"));
  }
}
