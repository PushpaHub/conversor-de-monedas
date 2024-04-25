package modelos;

import com.google.gson.Gson;
import exceptions.NoExisteMonedaBaseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {

    public ConversionGson BuscaConversiones(String moneda) {

        String urlDeExchangerate = "https://v6.exchangerate-api.com/v6/d0930bbf387109e79db85581/latest/"
                + moneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlDeExchangerate))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String miJson = response.body();

            if (!miJson.contains(moneda)){
                throw new NoExisteMonedaBaseException("NO EXISTE ESTA MONEDA BASE. Usa el código correcto.");
            } else{
                return new Gson().fromJson(miJson, ConversionGson.class);
            }
        }catch (NoExisteMonedaBaseException | IOException | InterruptedException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}