package com.mycompany.myapp.projmngrefact.common;

public class StringUtil {

  private StringUtil() {}

  public static boolean isBlank(String str) {
    return str == null || str.trim().isEmpty();
  }
}
