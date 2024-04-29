package modelos;

import com.google.gson.Gson;
import exceptions.NoExisteMonedaBaseException;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

// Clase ConsultaTasas está encargada de obtener datos de exchangerate-api.com
public class ConsultaTasas {

    Map<String,Double> mapaDeTasas;

    public Map<String, Double> getMapaDeTasas() {
        return mapaDeTasas;
    }

    // Método EncuentraTasas recibe el parametro moneda en el estándar ISO 4217,
    // tres letras mayusculas, lee el API key del archivo APIkey.txt,
    // encuentra la tabla completa de tasas de cambio en exchangerate-api.com
    // y la convierte en Map<String, Double>
    public void EncuentraTasas(String moneda){

        try (Scanner scanner = new Scanner(new File("APIkey.txt"))) {
            // Leemos API key del archivo APIkey.txt
            String apiKey = scanner.nextLine();

            String urlDeExchangerate = "https://v6.exchangerate-api.com/v6/"
                    + apiKey + "/latest/" + moneda;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlDeExchangerate))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 403 || response.statusCode() == 401) {
                throw new IllegalArgumentException("La API key no es válida o no está autorizada.");
            }

            String miJson = response.body();

            if (!miJson.contains(moneda)){
                throw new NoExisteMonedaBaseException("NO EXISTE ESTA MONEDA BASE. Usa el código correcto.");
            } else{
                ConversionGson conversionGson = new Gson().fromJson(miJson, ConversionGson.class);
                mapaDeTasas = conversionGson.conversion_rates();
            }
        } catch (IllegalArgumentException | NoExisteMonedaBaseException | IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}