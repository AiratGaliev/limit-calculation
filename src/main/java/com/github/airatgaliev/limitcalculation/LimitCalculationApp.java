package com.github.airatgaliev.limitcalculation;

import com.github.airatgaliev.limitcalculation.controller.BorrowerController;
import com.github.airatgaliev.limitcalculation.repository.IBorrowerRepository;
import com.github.airatgaliev.limitcalculation.repository.InMemoryBorrowerRepositoryImpl;
import com.github.airatgaliev.limitcalculation.view.ConsoleBorrowerView;
import com.github.airatgaliev.limitcalculation.view.ConsoleLimitView;
import com.github.airatgaliev.limitcalculation.view.IBorrowerView;
import com.github.airatgaliev.limitcalculation.view.ILimitView;

public class LimitCalculationApp {

  public static void main(String[] args) {
    IBorrowerRepository borrowerRepository = new InMemoryBorrowerRepositoryImpl();
    IBorrowerView borrowerView = new ConsoleBorrowerView();
    ILimitView limitView = new ConsoleLimitView();
    BorrowerController borrowerController = new BorrowerController(borrowerRepository,
        borrowerView, limitView);
    borrowerController.createBorrowers();
    borrowerController.getLimitInfo();
  }
}
