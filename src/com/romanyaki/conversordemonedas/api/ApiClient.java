package com.romanyaki.conversordemonedas.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ApiClient {
    private static final String API_KEY = "06c6ef9d97c59dd7d0369013";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public String obtenerDatos(String monedaBase) {
        String url = BASE_URL + API_KEY + "/latest/" + monedaBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10)) // Tiempo máximo para esperar la respuesta
                .header("User-Agent", "Java HttpClient") // Header opcional, para practicar
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 📌 NUEVO: Imprimir información de la respuesta
            System.out.println("Código de estado: " + response.statusCode());

            System.out.println("Encabezados:");
            response.headers().map().forEach((k, v) -> System.out.println(k + ": " + v));

            System.out.println("Cuerpo de la respuesta:");
            System.out.println(response.body());

            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al hacer la solicitud a la API: " + e.getMessage());
            return null;
        }
    }
}
