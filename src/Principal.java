import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
        Consulta consulta = new Consulta();
        boolean continuar = true;
        Monedas monedas = new Monedas();

        System.out.println("¿Desea hacer la conversión?\n\t\tSí/s\n\t\tNo/Cualquier otra tecla");
        String confirmacion = lee.nextLine();
        if (!confirmacion.equalsIgnoreCase("s")) {
            continuar = false;
        }

        while (continuar) {
            System.out.println("\t\t\tBienvenido/a al conversor de moneda.");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            float valorAConvertir = 0;


            String origen = monedas.validar(0);
            String destino = monedas.validar(1);


            boolean valorValido = false;

            while (!valorValido) {
                System.out.println("Introduzca el valor que desea convertir:");
                try {
                    valorAConvertir = Float.parseFloat(lee.nextLine());
                    valorValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Valor no válido. Por favor, introduzca un número válido.");
                }
            }
            float valorConvertido = consulta.convertir(
                    monedas.getMonedas().get(origen),
                    monedas.getMonedas().get(destino), valorAConvertir);
            System.out.println("\t\t" + valorConvertido);

            String conversion = monedas.getMonedas().get(origen) + " " + valorAConvertir + " : " + monedas.getMonedas().get(destino) + " " + valorConvertido;

            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String fechaFormateada = ahora.format(formato);

            MonedasOmdb conversiones = new MonedasOmdb(monedas.getMonedas().get(origen), monedas.getMonedas().get(destino), conversion, fechaFormateada);

            monedas.guardar(conversiones);

            System.out.println("¿Desea hacer la conversión?\n\t\tSí/s\n\t\tNo/Cualquier otra tecla");
            confirmacion = lee.nextLine();
            if (!confirmacion.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("¿Desea revisar el historial?\n\t\tSí/s\n\t\tNo/Cualquier otra tecla");
        String h = lee.nextLine();
        if (h.equalsIgnoreCase("s")) {
            monedas.mostrar();
        }
    }
}
