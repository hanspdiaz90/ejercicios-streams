package pe.edu.unprg.java.ejemplos;

import pe.edu.unprg.java.ejemplos.constante.Constante;
import pe.edu.unprg.java.ejemplos.enumerado.Departamento;
import pe.edu.unprg.java.ejemplos.modelo.*;
import pe.edu.unprg.java.ejemplos.enunciado.Basico;
import pe.edu.unprg.java.ejemplos.utilidad.Consola;
import pe.edu.unprg.java.ejemplos.utilidad.Validacion;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class MenuOpciones {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void procesarMenu(List<Empleado> datamockEmpleados, List<Pedido> datamockPedidos,
            List<Curso> datamockCursos, List<Alumno> datamockAlumnos, List<Matricula> datamockMatriculas) {

        int opcionPrincipal;
        do {
            mostrarMenuPrincipal();
            opcionPrincipal = Validacion.leerEntero(Constante.MENSAJE_SELECCION_OPCION, SCANNER);
            switch (opcionPrincipal) {
                case 1:
                    int opcionNivelBasico;
                    do {
                        mostrarMenuNivelBasico();
                        opcionNivelBasico = Validacion.leerEntero(Constante.MENSAJE_SELECCION_OPCION, SCANNER);
                        switch (opcionNivelBasico) {
                            case 1:
                                List<Empleado> empleadosActivos = Basico.obtenerEmpleadosByActivo(datamockEmpleados);
                                Consola.imprimirSubtitulo("Lista de empleados activos");
                                empleadosActivos.forEach(System.out::println);
                                break;
                            case 2:
                                List<String> empleadosNombres = Basico.obtenerEmpleadosByNombre(datamockEmpleados);
                                Consola.imprimirSubtitulo("Lista de nombres de todos los empleados");
                                empleadosNombres.forEach(System.out::println);
                                break;
                            case 3:
                                double salario = Validacion.leerDoble("\nIngrese un salario (S/.): ", SCANNER);
                                List<Empleado> empleadosSalariosMayorA = Basico.obtenerEmpleadosBySalarioMayorA(datamockEmpleados, salario);
                                Consola.imprimirSubtitulo("Lista de empleados con salario mayor a S/." + salario);
                                empleadosSalariosMayorA.forEach(System.out::println);
                                break;
                            case 4:
                                Map<Integer, String> departamentosMap = Departamento.convertirAMapa();
                                Consola.imprimirTabla("DEPARTAMENTO", departamentosMap);
                                int dptoOpcion = Validacion.leerOpciones(Constante.MENSAJE_SELECCION_OPCION, SCANNER, departamentosMap);
                                String dptoValor = departamentosMap.get(dptoOpcion);
                                long totalEmpleadosByDpto = Basico.contarEmpleadosByDepartamento(datamockEmpleados, dptoValor);
                                Consola.imprimirTotal("Total de empleados --> Departamento \"" + dptoValor + "\"", totalEmpleadosByDpto);
                                break;
                            case 5:
                                List<Double> empleadosSalarios = Basico.obtenerEmpleadosBySalario(datamockEmpleados);
                                Consola.imprimirSubtitulo("Lista de salarios de todos los empleados");
                                empleadosSalarios.forEach(System.out::println);
                                break;
                            case 6:
                                List<Empleado> empleadosByNombresOrdenAsc = Basico.ordenarEmpleadosByNombreOrdenAscendente(datamockEmpleados);
                                Consola.imprimirSubtitulo("Lista de empleados ordenados por nombre de forma ascendente");
                                empleadosByNombresOrdenAsc.forEach(System.out::println);
                                break;
                            case 7:
                                List<Empleado> empleadosBySalariosOrdenDesc = Basico.obtenerEmpleadosBySalariosOrdenDescendente(datamockEmpleados);
                                Consola.imprimirSubtitulo("Lista de empleados ordenados por salario de forma descendente");
                                empleadosBySalariosOrdenDesc.forEach(System.out::println);
                                break;
                            case 8:
                                long cantidad = 3;
                                List<Empleado> empleadosByFechaIngreso = Basico.obtenerEmpleadosByFechaIngresoOrdenAscendente(datamockEmpleados, cantidad);
                                Consola.imprimirSubtitulo("Lista de los 3 primeros empleados ordenados por fecha de ingreso");
                                empleadosByFechaIngreso.forEach(System.out::println);
                                break;
                            case 9:
                                boolean existeEmpleadoInactivo = Basico.existeEmpleadosInactivo(datamockEmpleados);
                                System.out.println("\n¿Existe algún empleado inactivo?: " + (existeEmpleadoInactivo ? "SI" : "NO") );
                                break;
                            case 10:
                                String letraNombre = Validacion.leerCadena("\nIngrese una letra: ", SCANNER);
                                List<Empleado> empleadosByNombreEmpiezaCon = Basico.obtenerEmpleadosByNombresEmpiezaCon(datamockEmpleados, letraNombre);
                                Consola.imprimirSubtitulo("Lista de empleados cuyo nombre empieza con la letra \"" + letraNombre.toUpperCase() + "\"");
                                empleadosByNombreEmpiezaCon.forEach(System.out::println);
                                break;
                            case 11:
                                break;
                            case 12:
                                break;
                            case 13:
                                break;
                            case 14:
                                break;
                            case 15:
                                break;
                            case 16:
                                double precio = Validacion.leerDoble("\nIngrese un precio (S/.): ", SCANNER);
                                List<Curso> cursosByPrecioMayorA = Basico.obtenerCursosByPrecioMayorA(datamockCursos, precio);
                                Consola.imprimirSubtitulo("Lista de cursos cuyo precio sea mayor a S/. " + precio);
                                cursosByPrecioMayorA.forEach(System.out::println);
                                break;
                            case 17:
                                List<String> cursosByNombresOrdenAscendente = Basico.obtenerCursosByNombreOrdenAscendente(datamockCursos);
                                Consola.imprimirSubtitulo("Lista con los nombres de todos los cursos ordenados alfabéticamente");
                                cursosByNombresOrdenAscendente.forEach(System.out::println);
                                break;
                            case 18:
                                List<Matricula> matriculasAprobadas = Basico.obtenerMatriculasAprobadas(datamockMatriculas);
                                Consola.imprimirSubtitulo("Listado de todas las matrículas aprobadas");
                                matriculasAprobadas.forEach(System.out::println);
                                break;
                            case 19:
                                long totalCursos = Basico.contarTotalCursos(datamockCursos);
                                Consola.imprimirTotal("Total de cursos", totalCursos);
                                break;
                            case 20:
                                long totalMatriculasDesaprobadas = Basico.contarMatriculasByDesaprobado(datamockMatriculas);
                                Consola.imprimirTotal("Total de matriculas desaprobadas: ", totalMatriculasDesaprobadas);
                                break;
                            case 21:
                                List<String> alumnosByDni = Basico.obtenerAlumnosByDni(datamockAlumnos);
                                Consola.imprimirSubtitulo("Lista con los DNI de todos los alumnos");
                                alumnosByDni.forEach(System.out::println);
                                break;
                            case 22:
                                int duracion = Validacion.leerEntero("\nIngrese un duración: ", SCANNER);
                                List<Curso> cursosByDuracionMayorA = Basico.obtenerCursosByDuracionMayorA(datamockCursos, duracion);
                                Consola.imprimirSubtitulo("Lista de cursos cuya duración sea mayor a " + duracion + " horas");
                                cursosByDuracionMayorA.forEach(System.out::println);
                                break;
                            case 23:
                                int anio = Validacion.leerEntero("\nIngrese anio: ", SCANNER);
                                Map<Integer, String> mesesMap = convertirMesesATabla();
                                Consola.imprimirTabla("MES", mesesMap);
                                int mesOpcion = Validacion.leerOpciones(Constante.MENSAJE_SELECCION_OPCION, SCANNER, mesesMap);
                                Month mes = Month.of(mesOpcion);
                                List<Matricula> matriculasByMesEspecifico = Basico.obtenerMatriculasByMesEspecifico(datamockMatriculas, anio, mes);
                                Consola.imprimirSubtitulo("Lista de matrículas realizadas en el mes de \"" + mesesMap.get(mesOpcion) +  "\" de " + anio);
                                matriculasByMesEspecifico.forEach(System.out::println);
                                break;
                            case 24:
                                String letraAlumn = Validacion.leerCadena("\nIngrese una letra: ", SCANNER);
                                List<Alumno> alumnosByApellidoPaterno = Basico.obtenerAlumnosByApellidoPaternoEmpiezaCon(datamockAlumnos, letraAlumn);
                                Consola.imprimirSubtitulo("Lista de alumnos cuyo nombre empieza con la letra \"" + letraAlumn.toUpperCase() + "\"");
                                alumnosByApellidoPaterno.forEach(System.out::println);
                                break;
                            case 25:
                                List<Double> matriculaByNotasIncrementadaEn1 = Basico.obtenerMatriculaByNotasIncrementadaEn1(datamockMatriculas);
                                Consola.imprimirSubtitulo("Lista de las notas finales de todas las matrículas incrementadas en 1 punto");
                                matriculaByNotasIncrementadaEn1.forEach(System.out::println);
                                break;
                        }
                    } while (opcionNivelBasico != 0);
                    break;
                case 2:
                    System.out.println("Opción 2 no operativa");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println(Constante.MENSAJE_OPCION_INVALIDO);
            }
        } while (opcionPrincipal != 3);
        SCANNER.close();
    }

    private static void mostrarMenuPrincipal() {
        Consola.imprimirTitulo("MENÚ PRINCIPAL");
        System.out.println("▶ [1] Nivel Básico");
        System.out.println("▶ [2] Nivel Intermedio");
        System.out.println("▶ [3] Salir");
    }

    private static void mostrarMenuNivelBasico() {
        Consola.imprimirTitulo("MENÚ DE OPCIONES (NIVEL BÁSICO)");
        System.out.println("▶ [1] Lista de empleados activos");
        System.out.println("▶ [2] Lista de nombres de todos los empleados");
        System.out.println("▶ [3] Lista de empleados con salario mayor a S/.");
        System.out.println("▶ [4] Total de empleados que pertenecen a un departamento específico");
        System.out.println("▶ [5] Lista de salarios de todos los empleados");
        System.out.println("▶ [6] Lista de empleados ordenados por nombre ascendente");
        System.out.println("▶ [7] Lista de empleados ordenados por salario descendente");
        System.out.println("▶ [8] 3 primeros empleados ordenados por fecha de ingreso");
        System.out.println("▶ [9] ¿Existe algún empleado inactivo?");
        System.out.println("▶ [10] Lista de empleados cuyos nombres empiece con una letra específica");
        System.out.println("▶ [16] Lista de todos los cursos cuyo precio sea mayor a S/.");
        System.out.println("▶ [17] Lista con los nombres de todos los cursos ordenados alfabéticamente");
        System.out.println("▶ [18] Lista de todas las matrículas que estén aprobadas");
        System.out.println("▶ [19] Contar cuántos cursos existen en total");
        System.out.println("▶ [20] Total de matrículas desaprobadas");
        System.out.println("▶ [21] Lista con los DNI de todos los alumnos");
        System.out.println("▶ [22] Lista de los cursos cuya duración sea mayor a 50 horas");
        System.out.println("▶ [23] Lista de todas las matrículas realizadas en un mes y año específico");
        System.out.println("▶ [24] Lista de los alumnos cuyo apellido paterno comience con una letra específica");
        System.out.println("▶ [25] Lista con las notas finales de todas las matrículas incrementadas en 1 punto (sin modificar el objeto original)");
        System.out.println("▶ [0] Volver al menu principal");
    }

    private static Map<Integer, String> convertirMesesATabla() {
        Locale localPE = new Locale("es", "PE");
        return Arrays.stream(Month.values())
                .collect(Collectors.toMap(
                        Month::getValue,
                        month -> {
                            String mes = month.getDisplayName(TextStyle.FULL, localPE);
                            return mes.substring(0, 1).toUpperCase(localPE) + mes.substring(1).toLowerCase(localPE);
                        },
                        (m1, m2) -> m1,
                        TreeMap::new
                ));
    }

}
