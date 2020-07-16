package com.github.airatgaliev.limitcalculation.model;

public class Borrower {

  private Double aInc;
  private int kolIzhd;
  private Double aExpBank;
  private Double aExpAnk;
  private Double aExpBKI;
  private BorrowerType borrowerType;

  public Borrower(Double aInc, int kolIzhd, Double aExpBank, Double aExpAnk, Double aExpBKI,
      BorrowerType borrowerType) {
    this.aInc = aInc;
    this.kolIzhd = kolIzhd;
    this.aExpBank = aExpBank;
    this.aExpAnk = aExpAnk;
    this.aExpBKI = aExpBKI;
    this.borrowerType = borrowerType;
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

  public BorrowerType getBorrowerType() {
    return borrowerType;
  }

  public void setBorrowerType(BorrowerType borrowerType) {
    this.borrowerType = borrowerType;
  }

  @Override
  public String toString() {
    return "Заемщик: " +
        "\n Основной ежемесячный доход: " + aInc +
        "\n Количество иждивенцев: " + kolIzhd +
        "\n Платеж по кредитам Банка: " + aExpBank +
        "\n Совокупный Платеж по кредитам, который указал клиент в анкете: " + aExpAnk +
        "\n Совокупный Платеж по кредитам других Банков: " + aExpBKI +
        "\n Тип заемщика: " + borrowerType.getValue() +
        '}';
  }
}
