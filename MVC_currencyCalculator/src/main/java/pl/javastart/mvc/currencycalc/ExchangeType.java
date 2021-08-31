package pl.javastart.mvc.currencycalc;

import java.math.BigDecimal;

public enum ExchangeType {
    EURPLN("eur", "pln", new BigDecimal("4.55")),
    PLNEUR("pln", "eur", new BigDecimal("0.22"));


    private String baseCurrency;
    private String targetCurrency;
    private BigDecimal exchangeRate;

    ExchangeType(String baseCurrency, String targetCurrency, BigDecimal exchangeRate) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }
}
