package com.github.airatgaliev.limitcalculation.view;

import java.util.Scanner;

public class ConsoleMenuView implements IMenuView {

  @Override
  public boolean getRestartOrQuitProgram() {
    while (true) {
      System.out.print("Если желаете повторить расчет лимита кредитования нажмите 'r',\n"
          + "чтобы выйти из программы - 'q': ");
      Scanner scanner = new Scanner(System.in);
      String isRestartedOrQuit = scanner.nextLine();
      if (isRestartedOrQuit.equals("r")) {
        return true;
      }
      if (isRestartedOrQuit.equals("q")) {
        return false;
      } else {
        System.out.println("Извините, вы ввели неверные данные, повторите попытку");
      }
    }
  }
}
