package pe.edu.unprg.java.ejemplos.utilidad;

import pe.edu.unprg.java.ejemplos.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Basico {

    //1. Obtener una lista de empleados activos
    public static List<Empleado> obtenerEmpleadosByActivo(List<Empleado> datamockEmpleados){
        Predicate<Empleado> empleadoActivoPredicate = Empleado::isActivo;
        return datamockEmpleados.stream()
                .filter(empleadoActivoPredicate)
                .collect(Collectors.toList());
    };

    //2. Obtener los nombres de todos los empleados
    public static List<String> obtenerEmpleadosByNombre(List<Empleado> datamockEmpleados){
        Function<Empleado, String> empleadoNombreFunction = Empleado::getNombre;
        return datamockEmpleados.stream()
                .map(empleadoNombreFunction)
                .collect(Collectors.toList());
    }

    //3. Obtener empleados con salario mayor a S/. 3000
    public static List<Empleado> obtenerEmpleadosBySalarioMayorA(List<Empleado> datamockEmpleados, double salario){
        Predicate<Empleado> empleadoSalarioPredicate = emp -> emp.getSalario() > salario;
        return datamockEmpleados.stream()
                .filter(empleadoSalarioPredicate)
                .collect(Collectors.toList());
    }

    //4. Contar cuántos empleados pertenecen al departamento "IT"
    public static long contarEmpleadosByDepartamento(List<Empleado> datamockEmpleados, String departamento){
        Predicate<Empleado> empleadoByDepartamentoPredicate = emp -> departamento.equalsIgnoreCase(emp.getDepartamento());
        return datamockEmpleados.stream()
                .filter(empleadoByDepartamentoPredicate)
                .count();
    }

    //5. Obtener una lista de salarios
    public static List<Double> obtenerEmpleadosBySalario(List<Empleado> datamockEmpleados){
        Function<Empleado, Double> empleadoSalarioFunction = Empleado::getSalario;
        return datamockEmpleados.stream()
                .map(empleadoSalarioFunction)
                .collect(Collectors.toList());
    }

    //6. Ordenar empleados por nombre ascendente
    public static List<Empleado> ordenarEmpleadosByNombreOrdenAscendente(List<Empleado> datamockEmpleados){
        Comparator<Empleado> empleadoNombreComparator = Comparator.comparing(Empleado::getNombre);
        return datamockEmpleados.stream()
                .sorted(empleadoNombreComparator)
                .collect(Collectors.toList());
    }

    //7. Ordenar empleados por salario descendente
    public static List<Empleado> obtenerEmpleadosBySalariosOrdenDescendente(List<Empleado> datamockEmpleados){
        Comparator<Empleado> empleadoSalarioComparator = Comparator.comparingDouble(Empleado::getSalario);
        return datamockEmpleados.stream()
                .sorted(empleadoSalarioComparator.reversed())
                .collect(Collectors.toList());
    }

    //8. Obtener los primeros 3 empleados ordenados por fecha de ingreso
    public static List<Empleado> obtenerEmpleadosByFechaIngresoOrdenAscendente(List<Empleado> datamockEmpleados, long cantidad){
        Comparator<Empleado> empleadoFechaIngresoComparator = Comparator.comparing(Empleado::getFechaIngreso);
        return datamockEmpleados.stream()
                .sorted(empleadoFechaIngresoComparator)
                .limit(cantidad)
                .collect(Collectors.toList());
    }

    //9. Verificar si existe algún empleado inactivo.
    public static boolean existeEmpleadosInactivo(List<Empleado> datamockEmpleados){
        //Predicate<Empleado> empleadoActivoPredicate = Predicate.not(Empleado::isActivo);
        Predicate<Empleado> empleadoActivoPredicate = Empleado::isActivo;
        return datamockEmpleados.stream()
                .anyMatch(empleadoActivoPredicate.negate());
    }

    //10. Obtener una lista de empleados cuyo nombre empiece con "A"
    public static List<Empleado> obtenerEmpleadosByNombresEmpiezaCon(List<Empleado> datamockEmpleados, String letra){
        Predicate<Empleado> empleadoNombreAPredicate = emp -> {
            String nombre = emp.getNombre();
            return nombre != null && nombre.toUpperCase().startsWith(letra.toUpperCase());
        };
        return datamockEmpleados.stream()
                .filter(empleadoNombreAPredicate)
                .collect(Collectors.toList());
    }

    //11. Obtener pedidos entregados
    public static List<Pedido> obtenerPedidosEntregados(List<Pedido> datamockPedidos){
        Predicate<Pedido> pedidoEntregadoPredicate = Pedido::isEntregado;
        return datamockPedidos.stream()
                .filter(pedidoEntregadoPredicate)
                .collect(Collectors.toList());
    }

    //12. Obtener los totales de todos los pedidos
    public static List<Double> obtenerTotalesPedidos(List<Pedido> datamockPedidos){
        Function<Pedido, Double> pedidoTotalFunction = Pedido::getTotal;
        return datamockPedidos.stream()
                .map(pedidoTotalFunction)
                .collect(Collectors.toList());
    }

    //13. Contar pedidos de la categoría "Tecnología"
    public static long contarPedidosByCategoria(List<Pedido> datamockPedidos, String categoria){
        Predicate<Pedido> pedidoByCategoriaPredicate = pedido -> categoria.equalsIgnoreCase(pedido.getCategoria());
        return datamockPedidos.stream()
                .filter(pedidoByCategoriaPredicate)
                .count();
    }

    //14. Obtener pedidos mayores a S/.500
    public static List<Pedido> obtenerPedidosMayorA(List<Pedido> datamockPedidos, double total){
        Predicate<Pedido> pedidoTotalMayorAPredicate = pedido -> pedido.getTotal() > total;
        return datamockPedidos.stream()
                .filter(pedidoTotalMayorAPredicate)
                .collect(Collectors.toList());
    }

    //15. Ordenar pedidos por total ascendente
    public static List<Pedido> obtenerPedidosTotalByOrdenAscendente(List<Pedido> datamockPedidos){
        Comparator<Pedido> pedidoTotalComparator = Comparator.comparingDouble(Pedido::getTotal);
        return datamockPedidos.stream()
                .sorted(pedidoTotalComparator)
                .collect(Collectors.toList());
    }

    //16. Listar todos los cursos cuyo precio sea mayor a 700
    public static List<Curso> obtenerCursosByPrecioMayorA(List<Curso> datamockCursos, double total){
        Predicate<Curso> cursoPrecioPredicate = curso -> curso.getPrecio() > total;
        return datamockCursos.stream()
                .filter(cursoPrecioPredicate)
                .collect(Collectors.toList());
    }

    //17. Obtener una lista con los nombres de todos los cursos ordenados alfabéticamente
    public static List<String> obtenerCursosByNombreOrdenAscendente(List<Curso> datamockCursos){
        Comparator<Curso> cursoNombreComparator = Comparator.comparing(Curso::getNombre);
        Function<Curso, String> cursoNombreFunction = Curso::getNombre;
        return datamockCursos.stream()
                .sorted(cursoNombreComparator)
                .map(cursoNombreFunction)
                .collect(Collectors.toList());
    }

    //18. Listar todas las matrículas que estén aprobadas
    public static List<Matricula> obtenerMatriculasAprobadas(List<Matricula> datamockMatriculas){
        Predicate<Matricula> matriculaAprobadaPredicate = Matricula::isAprobado;
        return datamockMatriculas.stream()
                .filter(matriculaAprobadaPredicate)
                .collect(Collectors.toList());
    }

    //19. Contar cuántos cursos existen en total
    public static long contarTotalCursos(List<Curso> datamockCursos){
        return datamockCursos.size();
    }

    //20. Contar cuántas matrículas están desaprobadas
    public static long contarMatriculasByDesaprobado(List<Matricula> datamockMatriculas){
        Predicate<Matricula> matriculaDesaprobadoPredicate = Predicate.not(Matricula::isAprobado);
        return datamockMatriculas.stream()
                .filter(matriculaDesaprobadoPredicate)
                .count();
    }

    //21. Obtener una lista con los DNIs de todos los alumnos
    public static List<String> obtenerAlumnosByDni(List<Alumno> datamockAlumnos){
        Function<Alumno, String> alumnoDniFunction = Alumno::getDni;
        return datamockAlumnos.stream()
                .map(alumnoDniFunction)
                .collect(Collectors.toList());
    }

    //22. Listar los cursos cuya duración sea mayor a 50 horas
    public static List<Curso> obtenerCursosByDuracionMayorA(List<Curso> datamockCursos, int duracion){
        Predicate<Curso> cursoDuracionPredicate = curso -> curso.getDuracionHoras() > duracion;
        return datamockCursos.stream()
                .filter(cursoDuracionPredicate)
                .collect(Collectors.toList());
    }

    private static boolean esDelAnioYMes(LocalDate fecha, int anio, Month mes) {
        return fecha.getYear() == anio && fecha.getMonth() == mes;
    }

    //23. Obtener todas las matrículas realizadas en el mes de febrero de 2025
    public static List<Matricula> obtenerMatriculasByMesEspecifico(List<Matricula> datamockMatriculas, int anio, Month mes) {
        Predicate<Matricula> matriculaFechaPredicate = matricula ->
                esDelAnioYMes(matricula.getFechaMatricula(), anio, mes);
        return datamockMatriculas.stream()
                .filter(matriculaFechaPredicate)
                .collect(Collectors.toList());
    }

    //24. Listar los alumnos cuyo apellido paterno comience con la letra “R”
    public static List<Alumno> obtenerAlumnosByApellidoPaternoEmpiezaCon(List<Alumno> datamockAlumnos, String letra) {
        String letraMayuscula = letra.toUpperCase();
        Predicate<Alumno> alumnoApellidoPatPredicate = alumno ->
                alumno.getApellidoPaterno().toUpperCase().startsWith(letraMayuscula);
        return datamockAlumnos.stream()
                .filter(alumnoApellidoPatPredicate)
                .collect(Collectors.toList());
    }

    //25. Obtener una lista con las notas finales de todas las matrículas incrementadas en 1 punto (sin modificar el objeto original)
    public static List<Double> obtenerMatriculaByNotasIncrementadaEn1(List<Matricula> datamockMatriculas){
        Function<Matricula, Double> matriculaNotaFunction = matricula -> matricula.getNotaFinal() + 1.0;
        return datamockMatriculas.stream()
                .map(matriculaNotaFunction)
                .collect(Collectors.toList());
    }

}
