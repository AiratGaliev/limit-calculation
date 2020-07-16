package com.github.airatgaliev.limitcalculation.model;

public class Borrower {

  private Double aInc;
  private int kolIzhd;
  private Double aExpBank;
  private Double aExpAnk;
  private Double aExpBKI;

  public Borrower(Double aInc, int kolIzhd, Double aExpBank, Double aExpAnk, Double aExpBKI) {
    this.aInc = aInc;
    this.kolIzhd = kolIzhd;
    this.aExpBank = aExpBank;
    this.aExpAnk = aExpAnk;
    this.aExpBKI = aExpBKI;
  }

  public Double getaInc() {
    return aInc;
  }

  public void setaInc(Double aInc) {
    this.aInc = aInc;
  }

  public int getKolIzhd() {
    return kolIzhd;
  }

  public void setKolIzhd(int kolIzhd) {
    this.kolIzhd = kolIzhd;
  }

  public Double getaExpBank() {
    return aExpBank;
  }

  public void setaExpBank(Double aExpBank) {
    this.aExpBank = aExpBank;
  }

  public Double getaExpAnk() {
    return aExpAnk;
  }

  public void setaExpAnk(Double aExpAnk) {
    this.aExpAnk = aExpAnk;
  }

  public Double getaExpBKI() {
    return aExpBKI;
  }

  public void setaExpBKI(Double aExpBKI) {
    this.aExpBKI = aExpBKI;
  }
}
