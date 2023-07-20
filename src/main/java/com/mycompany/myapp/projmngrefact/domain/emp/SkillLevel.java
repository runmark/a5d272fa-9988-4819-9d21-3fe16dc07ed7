package com.mycompany.myapp.projmngrefact.domain.emp;

import com.mycompany.myapp.projmngrefact.domain.BusinessException;
import java.util.Arrays;

public enum SkillLevel {
  BEGINNER("BEG", "BEG"),
  INTERMEDIATE("INTER", "INTER"),
  ADVANCED("ADVNCD", "ADVNCD"),
  EXPERT("EXPT", "EXPT");

  private final String code;
  private final String desc;

  SkillLevel(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String code() {
    return code;
  }

  public static SkillLevel ofCode(String code) {
    return Arrays
      .stream(values())
      .filter(v -> v.code().equals(code))
      .findFirst()
      .orElseThrow(() -> new BusinessException("Invalid SkillLevel code: " + code));
  }
}
