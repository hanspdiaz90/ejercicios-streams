package pe.edu.unprg.java.ejemplos.modelo;

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
    private double total;
    private boolean entregado;
    private LocalDate fechaPedido;

    @Override
    public String toString() {
        return String.format(
                "Pedido{id=%d, cliente='%s', categoria='%s', total=S/. %.2f, entregado=%s pedido=%s}",
                id, cliente, categoria, total, entregado, fechaPedido
        );
    }

}
