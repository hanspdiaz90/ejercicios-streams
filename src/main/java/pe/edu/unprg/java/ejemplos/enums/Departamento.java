package pe.edu.unprg.java.ejemplos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Departamento {

    IT("IT", 1),
    VENTAS("Ventas", 2),
    RRHH("RR.HH", 3),
    SOPORTE("Soporte", 4),
    FINANZAS("Finanzas", 5);

    private String nombre;
    private int valor;

    public static Map<Integer, String> convertirAMapa() {
        return Arrays.stream(Departamento.values())
                .collect(Collectors.toMap(
                        Departamento::getValor,
                        Departamento::getNombre,
                        (d1, d2) -> d1,
                        TreeMap::new
                ));
    }

}
