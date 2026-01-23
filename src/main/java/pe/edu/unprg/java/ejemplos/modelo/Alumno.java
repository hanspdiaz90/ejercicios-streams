package pe.edu.unprg.java.ejemplos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;

    @Override
    public String toString() {
        return String.format(
                "Alumno{dni=%s, nombres='%s', paterno=%s, materno=%s, nacimiento=%s}",
                dni, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento
        );
    }

}
