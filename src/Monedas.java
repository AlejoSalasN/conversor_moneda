import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Monedas {
    private HashMap<String, String> monedas = new HashMap<>();
    public Monedas () {
        monedas.put("1", "USD");
        monedas.put("2", "EUR");
        monedas.put("3", "BRL");
        monedas.put("4", "ARS");
        monedas.put("5", "BOB");
        monedas.put("6", "CLP");
        monedas.put("7", "COP");
        monedas.put("8", "CNY");
        monedas.put("9", "JPY");
        monedas.put("10", "PEN");
        monedas.put("11", "VES");
    }

    public HashMap<String, String> getMonedas() {
        return monedas;
    }

    public String validar (int accion) {
        Scanner lee = new Scanner(System.in);
        String valor = "";
        boolean sw = false;
        while (!sw) {
            System.out.println("**************************************");
            System.out.println("""
                      0) Ver Historial
                      1) Dólar
                      2) Euro
                      3) Real Brasileño
                      4) Peso Argentino
                      5) Boliviano
                      6) Peso Chileno
                      7) Peso Colombiano
                      8) Yuan Chino
                      9) Yen Japonés
                      10) Sol Peruano
                      11) Bolívar Venezolano
                """);
            System.out.println("**************************************");
            if (accion == 0) {
                System.out.println("Elija la moneda de origen.");
            } else {
                System.out.println("Elija la moneda de destino.");
            }
            valor = lee.nextLine();
            if (monedas.containsKey(valor)) {
                sw = true;
            } else {
                System.out.println("Introduce una opción válida.\n");
            }
        }
        return valor;
    }

    public void guardar (MonedasOmdb conversiones) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        JsonArray jsonArray;

        try (FileReader reader = new FileReader("conversiones.json")) {
            jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
        } catch (Exception e) {
            jsonArray = new JsonArray();
        }

        JsonElement jsonElement = gson.toJsonTree(conversiones);
        jsonArray.add(jsonElement);

        try (FileWriter writer = new FileWriter("conversiones.json")) {
            gson.toJson(jsonArray, writer);
            System.out.println("Datos añadidos correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void mostrar() {

        try (FileReader reader = new FileReader("conversiones.json")) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement element : jsonArray) {
                System.out.println(element);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
