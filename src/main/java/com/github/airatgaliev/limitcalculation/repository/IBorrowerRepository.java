package com.github.airatgaliev.limitcalculation.repository;

import com.github.airatgaliev.limitcalculation.model.Borrower;
import com.github.airatgaliev.limitcalculation.model.BorrowerType;

public interface IBorrowerRepository {

  void addBorrower(Borrower borrower);

  Borrower getBorrowerByType(BorrowerType borrowerType);
}
