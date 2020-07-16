package com.github.airatgaliev.limitcalculation.view;

import com.github.airatgaliev.limitcalculation.model.Borrower;
import com.github.airatgaliev.limitcalculation.model.BorrowerType;

public interface IBorrowerView {

  void printBorrowerInfo(Borrower borrower);

  Borrower getBorrower(BorrowerType borrowerType);

  boolean isCoBorrower();
}
