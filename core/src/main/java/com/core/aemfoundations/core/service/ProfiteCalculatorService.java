package com.core.aemfoundations.core.service;

public interface ProfiteCalculatorService {
    public  double netProfit(int amount);

    public double netDebt(int amount);

    public double netInvestment(int amount);
}
