package pe.edu.unprg.java.ejemplos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    private Long id;
    private String nombre;
    private String departamento;
    private Double salario;
    private boolean activo;
    private LocalDate fechaIngreso;

    @Override
    public String toString() {
        return String.format(
                "Empleado{id=%d, nombre='%s', departamento='%s', salario=S/. %.2f, activo=%s, ingreso=%s}",
                id, nombre, departamento, salario, activo, fechaIngreso
        );
    }

}
