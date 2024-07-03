import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public float convertir(String origen, String destino, float valor) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/71d2777d7f7ba8bed9fa91d3/latest/"+origen);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response =  client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            float precio = Float.parseFloat(conversionRates.get(destino).toString());
            return (valor * precio);
        } catch (Exception e) {
            throw new RuntimeException("No existe el dato.");
        }
    }
}
