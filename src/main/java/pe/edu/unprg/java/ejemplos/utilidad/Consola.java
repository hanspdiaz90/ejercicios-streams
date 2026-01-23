package pe.edu.unprg.java.ejemplos.utilidad;

import java.util.Map;

public class Consola {

    private static final String LINEA_DOBLE = "======================================================";
    private static final String LINEA = "------------------------------------------------------";

    public static void imprimirTitulo(String titulo) {
        System.out.println("\n" + LINEA_DOBLE);
        System.out.println(" " + titulo.toUpperCase());
        System.out.println(LINEA_DOBLE);
    }

    public static void imprimirSubtitulo(String subtitulo) {
        System.out.println("\n" + subtitulo);
        System.out.println(LINEA);
    }

    public static void imprimirTabla(String titulo, Map<Integer, String> mapa) {
        imprimirSubtitulo(titulo);
        mapa.forEach((clave, valor) -> System.out.println("▶ [" + clave + "] " + valor));
    }

    public static void imprimirTotal(String etiqueta, Object valor) {
        System.out.printf("%n%s: %s%n", etiqueta, valor);
    }

}
