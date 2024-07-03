import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
        Consulta consulta = new Consulta();
        boolean continuar = true;
        while (continuar) {
            System.out.println("\t\t\tBienvenido/a al conversor de moneda.");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            float valorAConvertir = 0;
            Monedas monedas = new Monedas();

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
            System.out.println("\t\t" + consulta.convertir(
                    monedas.getMonedas().get(origen),
                    monedas.getMonedas().get(destino), valorAConvertir));

            System.out.println("¿Desea hacer otra conversión?\nSí/s\nNo/Cualquier otra tecla");
            String confirmacion = lee.nextLine();
            if (!confirmacion.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }


    }
}
