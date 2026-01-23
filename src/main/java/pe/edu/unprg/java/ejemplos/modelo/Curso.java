package pe.edu.unprg.java.ejemplos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    private String codigo;
    private String nombre;
    private double precio;
    private int duracionHoras;
    private LocalDate fechaInicio;

    @Override
    public String toString() {
        return String.format(
                "Curso{codigo=%s, nombre='%s', precio=S/. %.2f, duracion=%d horas, inicio=%s}",
                codigo, nombre, precio, duracionHoras, fechaInicio
        );
    }

}
