package com.github.airatgaliev.limitcalculation.view;

import com.github.airatgaliev.limitcalculation.model.Borrower;
import com.github.airatgaliev.limitcalculation.model.BorrowerType;
import java.util.Scanner;

public class ConsoleBorrowerView implements IBorrowerView {

  @Override
  public void printBorrowerInfo(Borrower borrower) {
    System.out.println("Добавлена следующая информация по заемщику: " + borrower.toString());
  }

  @Override
  public Borrower getBorrower(BorrowerType borrowerType) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n\nПожалуйста введите информацию по заемщику:");
    System.out.print(" Основной ежемесячный доход: ");
    Double aInc = Double.parseDouble(scanner.nextLine());
    System.out.print(" Количество иждивенцев: ");
    int kolIzhd = Integer.parseInt(scanner.nextLine());
    System.out.print(" Платеж по кредитам Банка: ");
    Double aExpBank = Double.parseDouble(scanner.nextLine());
    System.out.print(" Совокупный Платеж по кредитам, который указал клиент в анкете: ");
    Double aExpAnk = Double.parseDouble(scanner.nextLine());
    System.out.print(" Совокупный Платеж по кредитам других Банков: ");
    Double aExpBKI = Double.parseDouble(scanner.nextLine());
    return new Borrower(aInc, kolIzhd, aExpBank, aExpAnk, aExpBKI, borrowerType);
  }

  @Override
  public boolean isCoBorrower() {
    while (true) {
      System.out.println("Принимает ли участие в сделке созаемщик?\n"
          + "Если да, то введите 'yes', если нет - 'no'");
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
