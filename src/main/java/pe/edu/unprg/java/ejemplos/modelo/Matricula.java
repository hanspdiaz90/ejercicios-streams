package pe.edu.unprg.java.ejemplos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {

    private Alumno alumno;     // asociación
    private Curso curso;       // asociación
    private LocalDate fechaMatricula;
    private double notaFinal;
    private boolean aprobado;

}
