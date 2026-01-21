package pe.edu.unprg.java.ejemplos.model;

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

}
