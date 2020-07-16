package com.github.airatgaliev.limitcalculation.view;

import com.github.airatgaliev.limitcalculation.model.Borrower;
import java.util.Scanner;

public class ConsoleBorrowerView implements IBorrowerView {

  @Override
  public void printBorrowerInfoResponse(Borrower borrower) {
    System.out.println("Добавлена следующая информация по заемщику: " + borrower.toString());
  }

  @Override
  public void printBorrowerInfoRequest() {
    System.out.println("\n\nПожалуйста введите информацию по заемщику:");
  }

  @Override
  public String getBorrowerAInc() {
    Scanner scanner = new Scanner(System.in);
    System.out.print(" Основной ежемесячный доход: ");
    return scanner.nextLine();
  }

  @Override
  public String getBorrowerKolIzhd() {
    Scanner scanner = new Scanner(System.in);
    System.out.print(" Количество иждивенцев: ");
    return scanner.nextLine();
  }

  @Override
  public String getBorrowerAExpBank() {
    Scanner scanner = new Scanner(System.in);
    System.out.print(" Платеж по кредитам Банка: ");
    return scanner.nextLine();
  }

  @Override
  public String getBorrowerAExpAnk() {
    Scanner scanner = new Scanner(System.in);
    System.out.print(" Совокупный Платеж по кредитам, который указал клиент в анкете: ");
    return scanner.nextLine();
  }

  @Override
  public String getBorrowerAExpBKI() {
    Scanner scanner = new Scanner(System.in);
    System.out.print(" Совокупный Платеж по кредитам других Банков: ");
    return scanner.nextLine();
  }

  @Override
  public boolean isCoBorrower() {
    while (true) {
      System.out.print("Принимает ли участие в сделке созаемщик?\n"
          + "Если да, то введите 'yes', если нет - 'no': ");
      Scanner scanner = new Scanner(System.in);
      String isCoBorrower = scanner.nextLine();
      if (isCoBorrower.equals("yes")) {
        return true;
      }
      if (isCoBorrower.equals("no")) {
        return false;
      } else {
        System.out.println("Извините, вы ввели неверные данные, повторите попытку");
      }
    }
  }
}
