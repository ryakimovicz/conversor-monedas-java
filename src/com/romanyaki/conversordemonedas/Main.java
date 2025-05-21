package com.romanyaki.conversordemonedas;

import com.google.gson.Gson;
import com.romanyaki.conversordemonedas.api.ApiClient;
import com.romanyaki.conversordemonedas.model.ExchangeRateResponse;
import com.romanyaki.conversordemonedas.service.CurrencyConverter;
import com.romanyaki.conversordemonedas.ui.Conversor;


public class Main {
    public static void main(String[] args) {
        ApiClient cliente = new ApiClient();
        String respuestaJson = cliente.obtenerDatos("USD");

        if (respuestaJson != null) {
            Gson gson = new Gson();
            ExchangeRateResponse datos = gson.fromJson(respuestaJson, ExchangeRateResponse.class);

            CurrencyConverter converter = new CurrencyConverter(datos.getBase_code(), datos.getConversion_rates());

            // Crear instancia del menú interactivo
            Conversor conversor = new Conversor(converter);
            conversor.mostrarMenu();

        } else {
            System.out.println("No se pudo obtener la respuesta.");
        }
    }
}