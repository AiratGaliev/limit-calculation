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
    createBorrower(BorrowerType.MA);
    if (borrowerView.isCoBorrower()) {
      createBorrower(BorrowerType.SP);
    }
  }

  private void createBorrower(BorrowerType borrowerType) {
    borrowerView.printBorrowerInfoRequest();
    Borrower borrower = new Borrower(getBorrowerAInc(), getBorrowerKolIzhd(),
        getBorrowerAExpBank(), getBorrowerAExpAnk(), getBorrowerAExpBKI(), borrowerType);
    borrowerRepository.addBorrower(borrower);
    borrowerView.printBorrowerInfoResponse(borrower);
  }

  public void getTotalLimitInfo() {
    Double limitMA = getIndividualLimitInfo(BorrowerType.MA);
    Double limitSP = getIndividualLimitInfo(BorrowerType.SP);
    Double limit = limitCalculationService.getCalculatedLimit(limitMA, limitSP);
    limitView.printCreditInfo(limit);
  }

  private Double getIndividualLimitInfo(BorrowerType borrowerType) {
    Borrower borrower = borrowerRepository.getBorrowerByType(borrowerType);
    Double limit = 0d;
    if (borrower != null && borrowerType.equals(BorrowerType.MA)) {
      limit = limitCalculationService
          .getCalculatedLimitMA(borrower.getaInc(), borrower.getKolIzhd(),
              borrower.getaExpBank(), borrower.getaExpAnk(), borrower.getaExpBKI());
    }
    if (borrower != null && borrowerType.equals(BorrowerType.SP)) {
      limit = limitCalculationService
          .getCalculatedLimitSP(borrower.getaInc(), borrower.getKolIzhd(),
              borrower.getaExpBank(), borrower.getaExpAnk(), borrower.getaExpBKI());
    }
    return limit;
  }

  public boolean isRestartedCalculation() {
    return menuView.getRestartOrQuitProgram();
  }

  private Double getBorrowerAInc() {
    while (true) {
      try {
        Double aInc = Double.parseDouble(borrowerView.getBorrowerAInc());
        validationService.validateDoubleValue(aInc);
        return aInc;
      } catch (NumberFormatException | NegativeArgumentException e) {
        borrowerView.printExceptionResponse(e);
      }
    }
  }

  private int getBorrowerKolIzhd() {
    while (true) {
      try {
        int kolIzhdString = Integer.parseInt(borrowerView.getBorrowerKolIzhd());
        validationService.validateIntegerValue(kolIzhdString);
        return kolIzhdString;
      } catch (NumberFormatException | NegativeArgumentException e) {
        borrowerView.printExceptionResponse(e);
      }
    }
  }

  private Double getBorrowerAExpBank() {
    while (true) {
      try {
        Double aExpBankString = Double.parseDouble(borrowerView.getBorrowerAExpBank());
        validationService.validateDoubleValue(aExpBankString);
        return aExpBankString;
      } catch (NumberFormatException | NegativeArgumentException e) {
        borrowerView.printExceptionResponse(e);
      }
    }
  }

  private Double getBorrowerAExpAnk() {
    while (true) {
      try {
        Double aExpAnkString = Double.parseDouble(borrowerView.getBorrowerAExpAnk());
        validationService.validateDoubleValue(aExpAnkString);
        return aExpAnkString;
      } catch (NumberFormatException | NegativeArgumentException e) {
        borrowerView.printExceptionResponse(e);
      }
    }
  }

  private Double getBorrowerAExpBKI() {
    while (true) {
      try {
        Double aExpBKIString = Double.parseDouble(borrowerView.getBorrowerAExpBKI());
        validationService.validateDoubleValue(aExpBKIString);
        return aExpBKIString;
      } catch (NumberFormatException | NegativeArgumentException e) {
        borrowerView.printExceptionResponse(e);
      }
    }
  }
}
