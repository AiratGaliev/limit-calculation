package com.github.airatgaliev.limitcalculation.controller;

import com.github.airatgaliev.limitcalculation.exceptions.NegativeArgumentException;
import com.github.airatgaliev.limitcalculation.model.Borrower;
import com.github.airatgaliev.limitcalculation.model.BorrowerType;
import com.github.airatgaliev.limitcalculation.repository.IBorrowerRepository;
import com.github.airatgaliev.limitcalculation.service.LimitCalculationService;
import com.github.airatgaliev.limitcalculation.service.ValidationService;
import com.github.airatgaliev.limitcalculation.view.IBorrowerView;
import com.github.airatgaliev.limitcalculation.view.ILimitView;
import com.github.airatgaliev.limitcalculation.view.IMenuView;

public class LimitCalculationController {

  private final IBorrowerRepository borrowerRepository;
  private final IBorrowerView borrowerView;
  private final ILimitView limitView;
  private final IMenuView menuView;
  private final LimitCalculationService limitCalculationService = new LimitCalculationService();
  private final ValidationService validationService = new ValidationService();

  public LimitCalculationController(
      IBorrowerRepository borrowerRepository,
      IBorrowerView borrowerView, ILimitView limitView,
      IMenuView menuView) {
    this.borrowerRepository = borrowerRepository;
    this.borrowerView = borrowerView;
    this.limitView = limitView;
    this.menuView = menuView;
  }

  public void createBorrowers() {
    borrowerView.printBorrowerInfoRequest();
    Borrower borrowerMA = new Borrower(getBorrowerAInc(), getBorrowerKolIzhd(),
        getBorrowerAExpBank(), getBorrowerAExpAnk(), getBorrowerAExpBKI(), BorrowerType.MA);
    borrowerRepository.addBorrower(borrowerMA);
    borrowerView.printBorrowerInfoResponse(borrowerMA);
    if (borrowerView.isCoBorrower()) {
      borrowerView.printBorrowerInfoRequest();
      Borrower borrowerSP = new Borrower(getBorrowerAInc(), getBorrowerKolIzhd(),
          getBorrowerAExpBank(), getBorrowerAExpAnk(), getBorrowerAExpBKI(), BorrowerType.SP);
      borrowerRepository.addBorrower(borrowerSP);
      borrowerView.printBorrowerInfoResponse(borrowerSP);
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

  public boolean isRestartedCalculation() {
    return menuView.getRestartOrQuitProgram();
  }

  private Double getBorrowerAInc() {
    while (true) {
      try {
        String aIncString = borrowerView.getBorrowerAInc();
        validationService.validateString(aIncString);
        return Double.parseDouble(aIncString);
      } catch (NumberFormatException | NegativeArgumentException e) {
        System.out.println("Извините, Вы ввели неверные данные: " + e.getMessage());
        continue;
      }
    }
  }

  private int getBorrowerKolIzhd() {
    while (true) {
      try {
        String kolIzhdString = borrowerView.getBorrowerKolIzhd();
        validationService.validateString(kolIzhdString);
        return Integer.parseInt(kolIzhdString);
      } catch (NumberFormatException | NegativeArgumentException e) {
        System.out.println("Извините, Вы ввели неверные данные: " + e.getMessage());
        continue;
      }
    }
  }

  private Double getBorrowerAExpBank() {
    while (true) {
      try {

        String aExpBankString = borrowerView.getBorrowerAExpBank();
        validationService.validateString(aExpBankString);
        return Double.parseDouble(aExpBankString);
      } catch (NumberFormatException | NegativeArgumentException e) {
        System.out.println("Извините, Вы ввели неверные данные: " + e.getMessage());
        continue;
      }
    }
  }

  private Double getBorrowerAExpAnk() {
    while (true) {
      try {
        String aExpAnkString = borrowerView.getBorrowerAExpAnk();
        validationService.validateString(aExpAnkString);
        return Double.parseDouble(aExpAnkString);
      } catch (NumberFormatException | NegativeArgumentException e) {
        System.out.println("Извините, Вы ввели неверные данные: " + e.getMessage());
        continue;
      }
    }
  }

  private Double getBorrowerAExpBKI() {
    while (true) {
      try {
        String aExpBKIString = borrowerView.getBorrowerAExpBKI();
        validationService.validateString(aExpBKIString);
        return Double.parseDouble(aExpBKIString);
      } catch (NumberFormatException | NegativeArgumentException e) {
        System.out.println("Извините, Вы ввели неверные данные: " + e.getMessage());
        continue;
      }
    }
  }
}
