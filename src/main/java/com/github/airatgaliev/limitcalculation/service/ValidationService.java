package com.github.airatgaliev.limitcalculation.service;

import com.github.airatgaliev.limitcalculation.exceptions.NegativeArgumentException;

public class ValidationService {

  public void validateDoubleValue(Double value) throws NegativeArgumentException {
    if (value < 0d) {
      throw new NegativeArgumentException("отрицательное значение: " + value);
    }
  }

  public void validateIntegerValue(int value) throws NegativeArgumentException {
    if (value < 0) {
      throw new NegativeArgumentException("отрицательное значение: " + value);
    }
  }
}
