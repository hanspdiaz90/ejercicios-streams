package pe.edu.unprg.java.ejemplos.utilidad;

import pe.edu.unprg.java.ejemplos.constante.Constante;

import java.util.Map;
import java.util.Scanner;

public class Validacion {

    public static int leerEntero(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print(Constante.MENSAJE_NUMERO_INVALIDO);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double leerDoble(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print(Constante.MENSAJE_NUMERO_INVALIDO);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static String leerCadena(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        return scanner.next().trim();
    }

    public static int leerOpciones(String mensaje, Scanner scanner, Map<Integer, String> tabla) {
        int opcion;
        do {
            opcion = leerEntero(mensaje, scanner);
            if (!tabla.containsKey(opcion)) {
                System.out.println(Constante.MENSAJE_OPCION_INVALIDO);
            }
        } while (!tabla.containsKey(opcion));
        return opcion;
    }

}
