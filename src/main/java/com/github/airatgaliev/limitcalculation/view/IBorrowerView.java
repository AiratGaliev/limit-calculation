package com.github.airatgaliev.limitcalculation.view;

import com.github.airatgaliev.limitcalculation.model.Borrower;

public interface IBorrowerView {

  void printBorrowerInfoResponse(Borrower borrower);

  void printBorrowerInfoRequest();

  String getBorrowerAInc();

  String getBorrowerKolIzhd();

  String getBorrowerAExpBank();

  String getBorrowerAExpAnk();

  String getBorrowerAExpBKI();

  boolean isCoBorrower();

  void printExceptionResponse(Exception e);
}
