package pe.edu.unprg.java.ejemplos.model;

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

}
