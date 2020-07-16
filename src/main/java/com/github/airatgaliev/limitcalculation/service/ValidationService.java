package com.github.airatgaliev.limitcalculation.service;

import com.github.airatgaliev.limitcalculation.exceptions.NegativeArgumentException;

public class ValidationService {

  private final String NEGATIVE_PREFIX = "-";

  public void validateString(String validationString) throws NegativeArgumentException {
    if (validationString.startsWith(NEGATIVE_PREFIX)) {
      throw new NegativeArgumentException("отрицательное значение: " + validationString);
    }
  }
}
