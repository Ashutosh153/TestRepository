package com.core.aemfoundations.core.models;

import com.core.aemfoundations.core.service.ProfiteCalculatorService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ProfitCalculatorModel {
    @OSGiService
    ProfiteCalculatorService profiteCalculatorService;

    @ValueMapValue
    private int amount;

    private double netProfit;
    private double netDebt;
    private double netInvestment;

    @PostConstruct
    protected void init()
    {
        netProfit=profiteCalculatorService.netProfit(this.amount);
        netDebt=profiteCalculatorService.netDebt(this.amount);
        netInvestment=profiteCalculatorService.netInvestment(this.amount);

    }

    public ProfiteCalculatorService getProfiteCalculatorService() {
        return profiteCalculatorService;
    }

    public double getAmount() {
        return amount;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public double getNetDebt() {
        return netDebt;
    }

    public double getNetInvestment() {
        return netInvestment;
    }
}
