# Conversor de Monedas 💱

Este es un proyecto de consola en Java que permite convertir montos entre diferentes monedas utilizando una API de tipo de cambio. Está estructurado siguiendo buenas prácticas de diseño, separando claramente la lógica en capas (API, modelo, servicio y UI).

## 📌 Descripción

El conversor consume los datos de tasas de cambio actualizadas desde la API pública de [ExchangeRate-API](https://www.exchangerate-api.com/) y permite realizar conversiones entre USD, ARS y BRL de forma interactiva desde la consola.

## 📁 Estructura del Proyecto

```
ConversorDeMonedas/
├── libs/
│   └── gson-2.13.1.jar
├── src/
│   └── com/romanyaki/conversordemonedas/
│       ├── api/
│       │   └── ApiClient.java
│       ├── model/
│       │   └── ExchangeRateResponse.java
│       ├── service/
│       │   └── CurrencyConverter.java
│       ├── ui/
│       │   └── Conversor.java
│       └── Main.java
```

## ⚙️ Tecnologías utilizadas

- Java 21
- Librería Gson para parseo de JSON
- API HTTP de ExchangeRate-API
- Java HttpClient (disponible desde Java 11)

## 🚀 Cómo ejecutar

1. Cloná el repositorio o copiá los archivos a un directorio local.
2. Asegurate de tener Java 17 instalado.
3. Asegurate de tener el archivo `gson-2.13.1.jar` en la carpeta `libs`.
4. Compilá y ejecutá el proyecto desde consola:

```bash
javac -cp "libs/gson-2.13.1.jar" -d bin src/com/romanyaki/conversordemonedas/**/*.java
java -cp "libs/gson-2.13.1.jar:bin" com.romanyaki.conversordemonedas.Main
```

📌 En Windows, usá `;` en lugar de `:` como separador de rutas:
```bash
java -cp "libs/gson-2.13.1.jar;bin" com.romanyaki.conversordemonedas.Main
```

## 🧠 Cómo funciona

- `ApiClient`: realiza una consulta HTTP a la API de tasas de cambio.
- `ExchangeRateResponse`: modelo que representa la estructura de respuesta JSON.
- `CurrencyConverter`: contiene la lógica de conversión entre monedas.
- `Conversor`: interfaz de consola para interactuar con el usuario.
- `Main`: punto de entrada del programa.

## 🛡️ Notas

- El proyecto utiliza una **clave de API gratuita** incluida para desarrollo. Para producción, se recomienda crear una propia desde [ExchangeRate-API](https://www.exchangerate-api.com/).
- La lógica está preparada para escalar fácilmente a más monedas o una interfaz gráfica.

## ✍️ Autor

Hecho por **Román Yakimovicz** como parte del challenge de Oracle + Alura Latam.

---

¡Gracias por probar este conversor de monedas! Cualquier sugerencia o mejora es bienvenida. 🚀
