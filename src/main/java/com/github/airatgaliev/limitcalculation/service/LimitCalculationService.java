package com.github.airatgaliev.limitcalculation.service;

public class LimitCalculationService {

  public Double getCalculatedLimitMA(Double aInc, int kolIzd, Double aExpBank, Double aExpAnk,
      Double aExpBKI) {
    return aInc - kolIzd * 0.09 - aExpBank - aExpAnk - aExpBKI;
  }

  public Double getCalculatedLimitSP(Double aInc, int kolIzd, Double aExpBank, Double aExpAnk,
      Double aExpBKI) {
    return aInc * 0.5 - kolIzd * 0.03 - aExpBank - aExpAnk - aExpBKI;
  }

  public Double getCalculatedLimit(Double limitMA, Double limitSP) {
    return limitMA + limitSP * 0.3;
  }
}
