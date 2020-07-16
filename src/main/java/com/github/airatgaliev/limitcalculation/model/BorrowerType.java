package com.github.airatgaliev.limitcalculation.model;

public enum BorrowerType {
  MA("Основной"), SP("Созаемщик");
  private String value;

  BorrowerType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
