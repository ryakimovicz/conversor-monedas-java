package com.romanyaki.conversordemonedas.ui;

import java.util.Scanner;
import com.romanyaki.conversordemonedas.service.CurrencyConverter;

public class Conversor {
    private CurrencyConverter currencyConverter;
    private Scanner scanner;

    // Constructor recibe el com.romanyaki.conversordemonedas.Service.CurrencyConverter ya creado
    public Conversor(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
        this.scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú y controlar la interacción
    public void mostrarMenu() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== Sea bienvenido/a al com.romanyaki.conversordemonedas.ui.Conversor de Moneda ===");
            System.out.println("Moneda base: " + currencyConverter.getBaseCurrency());
            System.out.println("1. Convertir USD a ARS");
            System.out.println("2. Convertir ARS a USD");
            System.out.println("3. Convertir USD a BRL");
            System.out.println("4. Convertir BRL a USD");
            System.out.println("5. Convertir ARS a BRL");
            System.out.println("6. Convertir BRL a ARS");
            System.out.println("0. Salir");
            System.out.print("Elija una opción válida: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> convertirMoneda("USD", "ARS");
                case 2 -> convertirMoneda("ARS", "USD");
                case 3 -> convertirMoneda("USD", "BRL");
                case 4 -> convertirMoneda("BRL", "USD");
                case 5 -> convertirMoneda("ARS", "BRL");
                case 6 -> convertirMoneda("BRL", "ARS");
                case 0 -> System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private void convertirMoneda(String from, String to) {
        System.out.print("Ingrese el monto a convertir de " + from + " a " + to + ": ");
        double monto = scanner.nextDouble();

        Double resultado = currencyConverter.convert(monto, from, to);
        if (resultado != null) {
            System.out.printf("%.2f %s equivalen a %.2f %s%n", monto, from, resultado, to);
        } else {
            System.out.println("No se pudo realizar la conversión.");
        }
    }
}