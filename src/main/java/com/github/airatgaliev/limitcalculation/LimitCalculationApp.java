package com.github.airatgaliev.limitcalculation;

import com.github.airatgaliev.limitcalculation.controller.LimitCalculationController;
import com.github.airatgaliev.limitcalculation.repository.IBorrowerRepository;
import com.github.airatgaliev.limitcalculation.repository.InMemoryBorrowerRepositoryImpl;
import com.github.airatgaliev.limitcalculation.view.ConsoleBorrowerView;
import com.github.airatgaliev.limitcalculation.view.ConsoleLimitView;
import com.github.airatgaliev.limitcalculation.view.ConsoleMenuView;
import com.github.airatgaliev.limitcalculation.view.IBorrowerView;
import com.github.airatgaliev.limitcalculation.view.ILimitView;
import com.github.airatgaliev.limitcalculation.view.IMenuView;

public class LimitCalculationApp {

  public static void main(String[] args) {
    boolean isRestartedOrQuit = true;
    while (isRestartedOrQuit) {
      IBorrowerRepository borrowerRepository = new InMemoryBorrowerRepositoryImpl();
      IBorrowerView borrowerView = new ConsoleBorrowerView();
      ILimitView limitView = new ConsoleLimitView();
      IMenuView menuView = new ConsoleMenuView();
      LimitCalculationController limitCalculationController = new LimitCalculationController(
          borrowerRepository,
          borrowerView, limitView, menuView);
      limitCalculationController.createBorrowers();
      limitCalculationController.getLimitInfo();
      isRestartedOrQuit = limitCalculationController.isRestartedCalculation();
    }
  }
}
