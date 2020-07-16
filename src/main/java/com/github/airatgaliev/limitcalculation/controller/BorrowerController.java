package com.github.airatgaliev.limitcalculation.controller;

import com.github.airatgaliev.limitcalculation.model.Borrower;
import com.github.airatgaliev.limitcalculation.model.BorrowerType;
import com.github.airatgaliev.limitcalculation.repository.IBorrowerRepository;
import com.github.airatgaliev.limitcalculation.service.LimitCalculationService;
import com.github.airatgaliev.limitcalculation.view.IBorrowerView;
import com.github.airatgaliev.limitcalculation.view.ILimitView;

public class BorrowerController {

  private final IBorrowerRepository borrowerRepository;
  private final IBorrowerView borrowerView;
  private final ILimitView limitView;
  private final LimitCalculationService limitCalculationService = new LimitCalculationService();

  public BorrowerController(
      IBorrowerRepository borrowerRepository,
      IBorrowerView borrowerView, ILimitView limitView) {
    this.borrowerRepository = borrowerRepository;
    this.borrowerView = borrowerView;
    this.limitView = limitView;
  }

  public void createBorrowers() {
    Borrower borrowerMA = borrowerView.getBorrower(BorrowerType.MA);
    borrowerView.printBorrowerInfo(borrowerMA);
    borrowerRepository.addBorrower(borrowerMA);
    if (borrowerView.isCoBorrower()) {
      Borrower borrowerSP = borrowerView.getBorrower(BorrowerType.SP);
      borrowerView.printBorrowerInfo(borrowerSP);
      borrowerRepository.addBorrower(borrowerSP);
    }
  }

  public void getLimitInfo() {
    Borrower borrowerMA = borrowerRepository.getBorrowerByType(BorrowerType.MA);
    Borrower borrowerSP = borrowerRepository.getBorrowerByType(BorrowerType.SP);
    Double limitMA = 0d;
    Double limitSP = 0d;
    if (borrowerMA != null) {
      limitMA = limitCalculationService
          .getCalculatedLimitMA(borrowerMA.getaInc(), borrowerMA.getKolIzhd(),
              borrowerMA.getaExpBank(), borrowerMA.getaExpAnk(), borrowerMA.getaExpBKI());
    }
    if (borrowerSP != null) {
      limitSP = limitCalculationService
          .getCalculatedLimitSP(borrowerSP.getaInc(), borrowerSP.getKolIzhd(),
              borrowerSP.getaExpBank(), borrowerSP.getaExpAnk(), borrowerSP.getaExpBKI());
    }
    Double limit = limitCalculationService.getCalculatedLimit(limitMA, limitSP);
    limitView.printCreditInfo(limit);
  }
}
