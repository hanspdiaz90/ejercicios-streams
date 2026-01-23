package pe.edu.unprg.java.ejemplos.enunciado;

import pe.edu.unprg.java.ejemplos.modelo.Empleado;
import pe.edu.unprg.java.ejemplos.modelo.Pedido;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Intermedio {

    //1. Agrupar empleados por departamento
    public static Map<String, List<Empleado>> agruparEmpleadosByDepartamento(List<Empleado> datamockEmpleados){
        Function<Empleado, String> empleadoByDepartamentoFunction = Empleado::getDepartamento;
        return datamockEmpleados.stream()
                .collect(Collectors.groupingBy(empleadoByDepartamentoFunction));
    }

    //1.A. Agrupar empleados ordenados por nombre dentro de cada departamento
    public static Map<String, List<Empleado>> agruparEmpleadosByDepartamentoYOrdenNombresAscendente(List<Empleado> datamockEmpleados){
        Function<Empleado, String> empleadoByDepartamentoFunction = emp ->
                Optional.ofNullable(emp.getDepartamento()).orElse("SIN DEPARTAMENTO");
        Comparator<Empleado> empleadoNombresComparator = Comparator.comparing(Empleado::getNombre);
        return datamockEmpleados.stream()
                .collect(Collectors.groupingBy(empleadoByDepartamentoFunction,
                        Collectors.collectingAndThen(Collectors.toList(), empNombresList ->
                                empNombresList.stream().sorted(empleadoNombresComparator).collect(Collectors.toList()))));
    }

    //2. Obtener el salario promedio de todos los empleados.
    public static Double obtenerSalarioPromedioEmpleados(List<Empleado> datamockEmpleados){
        ToDoubleFunction<Empleado> empleadoSalarioFunction = Empleado::getSalario;
        return datamockEmpleados.stream()
                .collect(Collectors.averagingDouble(empleadoSalarioFunction));
    }

    //3. Obtener el empleado con mayor salario.
    public static Optional<Empleado> obtenerEmpleadoMayorSalario(List<Empleado> datamockEmpleados){
        Comparator<Empleado> empleadoComparator = Comparator.comparingDouble(Empleado::getSalario);
        return datamockEmpleados.stream()
                .max(empleadoComparator);
    }

    //4. Agrupar empleados por departamento y contar cuántos hay en cada uno
    public static Map<String, Long> obtenerEmpleadosByDepartamentoYConteo(List<Empleado> datamockEmpleados){
        Function<Empleado, String> empleadoByDepartamentoFunction = empl ->
                Optional.ofNullable(empl.getDepartamento()).orElse("SIN DEPARTAMENTO");
        return datamockEmpleados.stream()
                .collect(Collectors.groupingBy(empleadoByDepartamentoFunction, Collectors.counting()));
    }

    //5. Obtener un Map<departamento, salarioPromedio>
    public static Map<String, Double> obtenerSalarioPromedioByDepartamento(List<Empleado> datamockEmpleados){
        Function<Empleado, String> empleadoByDepartamentoFunction = Empleado::getDepartamento;
        ToDoubleFunction<Empleado> empleadoSalarioFunction = Empleado::getSalario;
        return datamockEmpleados.stream()
                .collect(Collectors.groupingBy(empleadoByDepartamentoFunction,
                        Collectors.averagingDouble(empleadoSalarioFunction)));
    }

    //6. Particionar empleados en activos e inactivos
    public static Map<Boolean, List<Empleado>> obtenerEmpleadosParticionadoByActivo(List<Empleado> datamockEmpleados){
        Predicate<Empleado> empleadoActivoPredicate = Empleado::isActivo;
        return datamockEmpleados.stream()
                .collect(Collectors.partitioningBy(empleadoActivoPredicate));
    }

    //7. Obtener el empleado más antiguo (fechaIngreso más antigua)
    public static Optional<Empleado> obtenerEmpleadoMasAntiguo(List<Empleado> datamockEmpleados){
        Comparator<Empleado> empleadoFechaIngresoPredicate = Comparator.comparing(Empleado::getFechaIngreso);
        return datamockEmpleados.stream()
                .min(empleadoFechaIngresoPredicate);
    }

    //8. Obtener un Map<Boolean, List<String>> donde true → nombres de empleados activos, false → nombres de empleados inactivos
    public static Map<Boolean, List<String>> obtenerNombresEmpleadosByActivo(List<Empleado> datamockEmpleados){
        Predicate<Empleado> empleadoActivoPredicate = Empleado::isActivo;
        Function<Empleado, String> empleadoNombreFunction = Empleado::getNombre;
        return datamockEmpleados.stream()
                .collect(Collectors.partitioningBy(empleadoActivoPredicate,
                        Collectors.mapping(empleadoNombreFunction, Collectors.toList())));
    }

    //9. Sumar todos los salarios
    public static Double obtenerSumaSalariosEmpleados(List<Empleado> datamockEmpleados){
        ToDoubleFunction<Empleado> empleadoSalarioFunction = Empleado::getSalario;
        return datamockEmpleados.stream()
                .mapToDouble(empleadoSalarioFunction)
                .sum();
    }

    //10. Obtener estadísticas de salarios
    public static DoubleSummaryStatistics obtenerEstadisticaSalariosEmpleados(List<Empleado> datamockEmpleados){
        ToDoubleFunction<Empleado> empleadoSalarioFunction = Empleado::getSalario;
        return datamockEmpleados.stream()
                .mapToDouble(empleadoSalarioFunction)
                .summaryStatistics();
    }

    //11. Agrupar pedidos por categoría
    public static Map<String, List<Pedido>> obtenerPedidosByCategoria(List<Pedido> datamockPedidos){
        Function<Pedido, String> pedidoByCategoriaFunction = ped -> Optional.ofNullable(ped.getCategoria()).orElse("SIN CATEGORIA");
        return datamockPedidos.stream()
                .collect(Collectors.groupingBy(pedidoByCategoriaFunction));
    }

    //12. Calcular el total de ventas (suma de total)
    public static Double calcularMontoTotalVentasPedidos(List<Pedido> datamockPedidos){
        ToDoubleFunction<Pedido> pedidoFunction = Pedido::getTotal;
        return datamockPedidos.stream()
                .mapToDouble(pedidoFunction)
                .sum();
    }

    //13. Obtener el pedido más caro
    public static Optional<Pedido> obtenerPedidoMasCaro(List<Pedido> datamockPedidos){
        Comparator<Pedido> pedidoTotalComparator = Comparator.comparingDouble(Pedido::getTotal);
        return datamockPedidos.stream()
                .max(pedidoTotalComparator);
    }

    //14. Agrupar pedidos por cliente y sumar el total gastado
    public static Map<String, Double> obtenerTotalGastadoByCliente(List<Pedido> datamockPedidos){
        Function<Pedido, String> pedidoByClienteFunction = pedido -> Optional.ofNullable(pedido.getCliente()).orElse("CLIENTE DESCONOCIDO");
        ToDoubleFunction<Pedido> pedidoTotalFunction = Pedido::getTotal;
        return datamockPedidos.stream()
                .collect(Collectors.groupingBy(pedidoByClienteFunction,
                        Collectors.summingDouble(pedidoTotalFunction)));
    }

    //15. Particionar pedidos entre entregados y no entregados
    public static Map<Boolean, List<Pedido>> obtenerPedidosByEntregados(List<Pedido> datamockPedidos){
        Predicate<Pedido> pedidoEntregadoPredicate = Pedido::isEntregado;
        Comparator<Pedido> pedidoClienteComparator = Comparator.comparing(Pedido::getCliente);
        return datamockPedidos.stream()
                .collect(Collectors.partitioningBy(pedidoEntregadoPredicate,
                        Collectors.collectingAndThen(Collectors.toList(), pedClientesList ->
                                pedClientesList.stream().sorted(pedidoClienteComparator).collect(Collectors.toList()))));
    }

}
