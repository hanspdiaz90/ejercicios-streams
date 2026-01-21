package pe.edu.unprg.java.ejemplos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private Long id;
    private String cliente;
    private String categoria;
    private Double total;
    private boolean entregado;
    private LocalDate fechaPedido;

}
