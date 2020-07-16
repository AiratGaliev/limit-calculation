package com.github.airatgaliev.limitcalculation.view;

public class ConsoleLimitView implements ILimitView {

  @Override
  public void printCreditInfo(Double limit) {
    System.out.println("\nСовокупный лимит кредитования равен: " + limit);
  }
}
