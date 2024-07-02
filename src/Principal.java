import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
        Consulta consulta = new Consulta();

        System.out.println("Bienvenido/a al conversor de moneda.");
        String origen = "";
        String destino = "";
        float valorAConvertir = 0f;
        //System.out.println(consulta.convertir(origen, destino, 15.5f));
        ArrayList <String> validar = new ArrayList <>();
        for (int i = 0; i < 9; i++) {
            validar.add(i+"");
        }
        boolean sw = false;
        while (!sw) {
            System.out.println("Elija la moneda de origen.");
            System.out.println("""
                1) Dólar
                2) Euro
                3) Real Brasileño
                4) Peso Argentino
                5) Boliviano
                6) Peso Chileno
                7) Peso Colombiano
                8) Yuan Chino
                9) Yen Japonés
                """);
            origen = lee.nextLine();
            if (validar.contains(origen)) {
                sw = true;
            } else {
                System.out.println("Introduce una opción válida.\n");
            }
        }
        switch (origen) {
            case "1":
                origen = "USD";
                break;
            case "2":
                origen = "EUR";
                break;
            case "3":
                origen = "BRL";
                break;
            case "4":
                origen = "ARS";
            break;
            case "5":
                origen = "BOB";
            break;
            case "6":
                origen = "CLP";
            break;
            case "7":
                origen = "COP";
            break;
            case "8":
                origen = "CNY";
            break;
            case "9":
                origen = "JPY";
                break;
            default:
                origen = "USD";
                break;
        }
        sw = false;
        while (!sw) {
            System.out.println("Elija la moneda de destino.");
            System.out.println("""
                1) Dólar
                2) Euro
                3) Real Brasileño
                4) Peso Argentino
                5) Boliviano
                6) Peso Chileno
                7) Peso Colombiano
                8) Yuan Chino
                9) Yen Japonés
                """);
            destino = lee.nextLine();
            if (validar.contains(destino)) {
                sw = true;
            }
        }
        switch (destino) {
            case "1":
                destino = "USD";
                break;
            case "2":
                destino = "EUR";
                break;
            case "3":
                destino = "BRL";
                break;
            case "4":
                destino = "ARS";
                break;
            case "5":
                destino = "BOB";
                break;
            case "6":
                destino = "CLP";
                break;
            case "7":
                destino = "COP";
                break;
            case "8":
                destino = "CNY";
                break;
            case "9":
                destino = "JPY";
                break;
            default:
                destino = "USD";
                break;
        }
        System.out.println("Introduzca el valor que desea convertir:");
        valorAConvertir = lee.nextFloat();
        System.out.println(consulta.convertir(origen, destino, valorAConvertir));
    }
}
