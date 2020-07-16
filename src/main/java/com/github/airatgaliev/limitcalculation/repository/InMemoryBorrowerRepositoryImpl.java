package com.github.airatgaliev.limitcalculation.repository;

import com.github.airatgaliev.limitcalculation.model.Borrower;
import com.github.airatgaliev.limitcalculation.model.BorrowerType;
import java.util.ArrayList;
import java.util.List;

public class InMemoryBorrowerRepositoryImpl implements IBorrowerRepository {

  private final List<Borrower> borrowers = new ArrayList<>();

  public void addBorrower(Borrower borrower) {
    borrowers.add(borrower);
  }

  public Borrower getBorrowerByType(BorrowerType borrowerType) {
    for (Borrower borrower : borrowers) {
      if (borrower.getBorrowerType().equals(borrowerType)) {
        return borrower;
      }
    }
    return null;
  }
}
