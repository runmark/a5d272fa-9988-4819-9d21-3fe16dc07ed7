package com.mycompany.myapp.projmngrefact.domain.emp;

import java.time.LocalDate;
import java.util.Objects;

public class Period {

  private final LocalDate start;
  private final LocalDate end;

  Period(LocalDate start, LocalDate end) {
    if (start == null || end == null || end.isBefore(start)) throw new IllegalArgumentException("start and end cannot be null");

    this.start = start;
    this.end = end;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;

    if (!(obj instanceof Period)) return false;

    Period other = (Period) obj;
    return this.start.equals(other.start) && this.end.equals(other.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }

  public static Period of(LocalDate start, LocalDate end) {
    return new Period(start, end);
  }

  public static Period of(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
    return new Period(LocalDate.of(startYear, startMonth, startDay), LocalDate.of(endYear, endMonth, endDay));
  }

  public boolean overlap(Period other) {
    if (other == null) {
      throw new IllegalArgumentException("入参不能为空！");
    }
    return other.start.isBefore(this.end) && other.end.isAfter(this.start);
  }

  public Period merge(Period other) {
    LocalDate newStart = this.start.isBefore(other.start) ? this.start : other.start;
    LocalDate newEnd = this.end.isAfter(other.end) ? this.end : other.end;
    return new Period(newStart, newEnd);
  }

  public LocalDate getStart() {
    return start;
  }

  public LocalDate getEnd() {
    return end;
  }

  @Override
  public String toString() {
    return start + " ~ " + end;
  }
}
