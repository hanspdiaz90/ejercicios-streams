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

    @Override
    public String toString() {
        return String.format(
                "Matricula{alumno='%s %s %s', curso='%s', matricula=%s, nota=%.2f, aprobado=%s}",
                alumno.getNombres(), alumno.getApellidoPaterno(), alumno.getApellidoMaterno(), curso.getNombre(),
                fechaMatricula, notaFinal, aprobado
        );
    }

}
