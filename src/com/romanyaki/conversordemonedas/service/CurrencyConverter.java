package com.romanyaki.conversordemonedas.service;

import java.util.Map;

public class CurrencyConverter {
    private Map<String, Double> rates;
    private String baseCurrency;

    public CurrencyConverter(String baseCurrency, Map<String, Double> rates) {
        this.baseCurrency = baseCurrency;
        this.rates = rates;
    }

    /**
     * Convierte un monto desde la moneda base hacia la moneda destino
     * @param amount monto a convertir
     * @param targetCurrency moneda destino
     * @return monto convertido o null si no existe la tasa
     */
    public Double convertFromBase(double amount, String targetCurrency) {
        Double rate = rates.get(targetCurrency);
        if (rate == null) {
            System.out.println("No se encontró la tasa para " + targetCurrency);
            return null;
        }
        return amount * rate;
    }

    /**
     * Convierte un monto desde cualquier moneda hacia cualquier otra moneda
     * @param amount monto a convertir
     * @param fromCurrency moneda origen
     * @param toCurrency moneda destino
     * @return monto convertido o null si no existen las tasas necesarias
     */
    public Double convert(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equalsIgnoreCase(toCurrency)) {
            return amount; // misma moneda, sin cambio
        }

        if (fromCurrency.equalsIgnoreCase(baseCurrency)) {
            return convertFromBase(amount, toCurrency);
        }

        // Para convertir entre monedas que no son base, primero convertimos a base y luego a destino
        Double fromRate = rates.get(fromCurrency);
        Double toRate = rates.get(toCurrency);

        if (fromRate == null) {
            System.out.println("No se encontró la tasa para " + fromCurrency);
            return null;
        }
        if (toRate == null) {
            System.out.println("No se encontró la tasa para " + toCurrency);
            return null;
        }

        // Convierte a base (dividiendo por la tasa de fromCurrency), luego multiplica por tasa de toCurrency
        double amountInBase = amount / fromRate;
        return amountInBase * toRate;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

}