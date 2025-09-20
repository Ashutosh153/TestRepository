package com.core.aemfoundations.core.service.impl;

import com.core.aemfoundations.core.service.ProfiteCalculatorService;
import org.osgi.service.component.annotations.Component;

@Component(service=ProfiteCalculatorService.class,immediate = true)
public class ProfitCalculatorServiceImpl implements ProfiteCalculatorService {
    @Override
    public double netProfit(int amount) {
        return Math.round(amount * 0.6);
    }

    @Override
    public double netDebt(int amount) {
        return Math.round(amount * 0.2);
    }

    @Override
    public double netInvestment(int amount) {
        return Math.round(amount * 0.7);
    }
}
