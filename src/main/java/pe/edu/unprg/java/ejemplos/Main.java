package pe.edu.unprg.java.ejemplos;

import pe.edu.unprg.java.ejemplos.enums.Departamento;
import pe.edu.unprg.java.ejemplos.model.*;
import pe.edu.unprg.java.ejemplos.utilidad.Datamock;
import pe.edu.unprg.java.ejemplos.utilidad.Basico;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String MENSAJE_OPCION = "Seleccione una opción: ";
    private static final String MENSAJE_OPCION_INVALIDO = "Opción no válida";
    private static final String MENSAJE_NUMERO_INVALIDO = "Ingrese un número válido: ";

    public static void main(String[] args) {
        List<Empleado> datamockEmpleados = Datamock.obtenerEmpleados();
        List<Pedido> datamockPedidos = Datamock.obtenerPedidos();
        List<Curso> datamockCursos = Datamock.obtenerCursos();
        List<Alumno> datamockAlumnos = Datamock.obtenerAlumnos();
        List<Matricula> datamockMatriculas = Datamock.obtenerMatriculas(datamockAlumnos, datamockCursos);

        int opcionPrincipal;
        do {
            mostrarMenuPrincipal();
            opcionPrincipal = leerEntero(MENSAJE_OPCION);
            switch (opcionPrincipal) {
                case 1:
                    int opcionNivelBasico;
                    do {
                        mostrarMenuNivelBasico();
                        opcionNivelBasico = leerEntero(MENSAJE_OPCION);
                        switch (opcionNivelBasico) {
                            case 1:
                                List<Empleado> empleadosActivos = Basico.obtenerEmpleadosByActivo(datamockEmpleados);
                                System.out.println("Listado de empleados activos");
                                empleadosActivos.forEach(System.out::println);
                                break;
                            case 2:
                                List<String> empleadosSoloNombres = Basico.obtenerEmpleadosByNombre(datamockEmpleados);
                                System.out.println("Listado de nombres de todos los empleados");
                                empleadosSoloNombres.forEach(System.out::println);
                                break;
                            case 3:
                                double salario = leerDoble("Ingrese un salario (S/.): ");
                                List<Empleado> empleadosSalariosMayorA = Basico.obtenerEmpleadosBySalarioMayorA(datamockEmpleados, salario);
                                System.out.println("Listado de empleados con salario mayor a S/." + salario);
                                empleadosSalariosMayorA.forEach(System.out::println);
                                break;
                            case 4:
                                Map<Integer, String> departamentosMap = Departamento.convertirAMapa();
                                mostrarTabla("[===== DEPARTAMENTO =====]", departamentosMap);
                                int departamentoOpcion = leerOpciones(MENSAJE_OPCION, departamentosMap);
                                String departamento = departamentosMap.get(departamentoOpcion);
                                long cantidadEmpleadosByDepartamento = Basico.contarEmpleadosByDepartamento(datamockEmpleados, departamento);
                                System.out.println("Cantidad de emplados que pertenecen al departamento de \"" + departamento + "\": " + cantidadEmpleadosByDepartamento);
                                break;
                            case 5:
                                List<Double> empleadosSalarios = Basico.obtenerEmpleadosBySalario(datamockEmpleados);
                                System.out.println("Listado de salarios de todos los empleados");
                                empleadosSalarios.forEach(System.out::println);
                                break;
                            case 6:
                                List<Empleado> empleadosByNombresOrdenAscendente = Basico.ordenarEmpleadosByNombreOrdenAscendente(datamockEmpleados);
                                System.out.println("Listado de empleados ordenados por nombre de forma ascendente");
                                empleadosByNombresOrdenAscendente.forEach(System.out::println);
                                break;
                            case 7:
                                List<Empleado> empleadosBySalariosOrdenDescendente = Basico.obtenerEmpleadosBySalariosOrdenDescendente(datamockEmpleados);
                                System.out.println("Listado de empleados ordenados por salario de forma descendente");
                                empleadosBySalariosOrdenDescendente.forEach(System.out::println);
                                break;
                            case 8:
                                long cantidad = 3;
                                List<Empleado> primerosEmpleadosByFechaIngreso = Basico.obtenerEmpleadosByFechaIngresoOrdenAscendente(datamockEmpleados, cantidad);
                                System.out.println("Listado de los 3 primeros empleados ordenados por fecha de ingreso");
                                primerosEmpleadosByFechaIngreso.forEach(System.out::println);
                                break;
                            case 9:
                                boolean existeEmpleadoInactivo = Basico.existeEmpleadosInactivo(datamockEmpleados);
                                System.out.println("¿Existe algún empleado inactivo?: " + (existeEmpleadoInactivo ? "SI" : "NO") );
                                break;
                            case 10:
                                String letraEmp = leerCadena("Ingrese una letra: ");
                                List<Empleado> empleadosNombreEmpiezaCon = Basico.obtenerEmpleadosByNombresEmpiezaCon(datamockEmpleados, letraEmp);
                                System.out.println("Listado de empleados cuyo nombre empieza con la letra \"" + letraEmp.toUpperCase() + "\"");
                                empleadosNombreEmpiezaCon.forEach(System.out::println);
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
                                double precio = leerDoble("Ingrese un sueldo (S/.): ");
                                List<Curso> cursosByPrecioMayorA = Basico.obtenerCursosByPrecioMayorA(datamockCursos, precio);
                                System.out.println("Listado de cursos cuyo precio sea mayor a S/. " + precio);
                                cursosByPrecioMayorA.forEach(System.out::println);
                                break;
                            case 17:
                                List<String> cursosByNombresOrdenAscendente = Basico.obtenerCursosByNombreOrdenAscendente(datamockCursos);
                                System.out.println("Listado con los nombres de todos los cursos ordenados alfabéticamente");
                                cursosByNombresOrdenAscendente.forEach(System.out::println);
                                break;
                            case 18:
                                List<Matricula> matriculasAprobadas = Basico.obtenerMatriculasAprobadas(datamockMatriculas);
                                System.out.println("Listado de todas las matrículas que estén aprobadas");
                                matriculasAprobadas.forEach(System.out::println);
                                break;
                            case 19:
                                long totalCursos = Basico.contarTotalCursos(datamockCursos);
                                System.out.println("Total de cursos: " + totalCursos);
                                break;
                            case 20:
                                long totalMatriculasDesaprobadas = Basico.contarMatriculasByDesaprobado(datamockMatriculas);
                                System.out.println("Total de matriculas desaprobadas: " + totalMatriculasDesaprobadas);
                                break;
                            case 21:
                                List<String> alumnosByDni = Basico.obtenerAlumnosByDni(datamockAlumnos);
                                System.out.println("Listado con los DNI de todos los alumnos");
                                alumnosByDni.forEach(System.out::println);
                                break;
                            case 22:
                                int duracion = leerEntero("Ingrese un duración: ");
                                List<Curso> cursosByDuracionMayorA = Basico.obtenerCursosByDuracionMayorA(datamockCursos, duracion);
                                cursosByDuracionMayorA.forEach(System.out::println);
                                break;
                            case 23:
                                int anio = leerEntero("Ingrese anio: ");
                                Map<Integer, String> mesesMap = convertirMesesATabla();
                                mostrarTabla("[===== MES =====]", mesesMap);
                                int mesOpcion = leerOpciones(MENSAJE_OPCION, mesesMap);
                                Month mes = Month.of(mesOpcion);
                                List<Matricula> matriculasByMesEspecifico = Basico.obtenerMatriculasByMesEspecifico(datamockMatriculas, anio, mes);
                                System.out.println("Listado de matrículas realizadas en el mes de \"" + mesesMap.get(mesOpcion) +  "\" de " + anio);
                                matriculasByMesEspecifico.forEach(System.out::println);
                                break;
                            case 24:
                                String letraAlumn = leerCadena("Ingrese una letra: ");
                                List<Alumno> alumnosByApellidoPaterno = Basico.obtenerAlumnosByApellidoPaternoEmpiezaCon(datamockAlumnos, letraAlumn);
                                System.out.println("Listado de alumnos cuyo nombre empieza con la letra \"" + letraAlumn.toUpperCase() + "\"");
                                alumnosByApellidoPaterno.forEach(System.out::println);
                                break;
                            case 25:
                                List<Double> matriculaByNotasIncrementadaEn1 = Basico.obtenerMatriculaByNotasIncrementadaEn1(datamockMatriculas);
                                System.out.println("Listado con las notas finales de todas las matrículas incrementadas en 1 punto");
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
                    System.out.println("Opción no valida");
            }
        } while (opcionPrincipal != 3);
        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("[===== MENÚ PRINCIPAL =====]");
        System.out.println("[1] Nivel Básico");
        System.out.println("[2] Nivel Intermedio");
        System.out.println("[3] Salir");
    }

    private static void mostrarMenuNivelBasico() {
        System.out.println("[===== MENÚ DE OPCIONES (NIVEL BÁSICO) =====]");
        System.out.println("[1] Obtener una lista de empleados activos");
        System.out.println("[2] Obtener los nombres de todos los empleados");
        System.out.println("[3] Obtener empleados con salario mayor a S/.");
        System.out.println("[4] Cantidad de empleados que pertenecen a un departamento específico");
        System.out.println("[5] Obtener una lista de salarios");
        System.out.println("[6] Ordenar empleados por nombre ascendente");
        System.out.println("[7] Ordenar empleados por salario descendente");
        System.out.println("[8] Obtener los 3 primeros empleados ordenados por fecha de ingreso");
        System.out.println("[9] ¿Existe algún empleado inactivo?");
        System.out.println("[10] Obtener empleados cuyos nombres empiece con una letra específica");
        System.out.println("[16] Listar todos los cursos cuyo precio sea mayor a S/.");
        System.out.println("[17] Obtener una lista con los nombres de todos los cursos ordenados alfabéticamente");
        System.out.println("[18] Listar todas las matrículas que estén aprobadas");
        System.out.println("[19] Contar cuántos cursos existen en total");
        System.out.println("[20] Contar cuántas matrículas están desaprobadas");
        System.out.println("[21] Obtener una lista con los DNI de todos los alumnos");
        System.out.println("[22] Listar los cursos cuya duración sea mayor a 50 horas");
        System.out.println("[23] Obtener todas las matrículas realizadas en un mes y año específico");
        System.out.println("[24] Listar los alumnos cuyo apellido paterno comience con una letra específica");
        System.out.println("[25] Obtener una lista con las notas finales de todas las matrículas incrementadas en 1 punto (sin modificar el objeto original)");
        System.out.println("[0] Volver al menu principal");
    }

    private static void mostrarTabla(String titulo, Map<Integer, String> mapa) {
        System.out.println(titulo);
        mapa.forEach((clave, valor) -> System.out.println("[" + clave + "] " + valor));
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print(MENSAJE_NUMERO_INVALIDO);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double leerDoble(String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print(MENSAJE_NUMERO_INVALIDO);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private static int leerOpciones(String mensaje, Map<Integer, String> tabla) {
        int opcion;
        do {
            opcion = leerEntero(mensaje);
            if (!tabla.containsKey(opcion)) {
                System.out.println(MENSAJE_OPCION_INVALIDO);
            }
        } while (!tabla.containsKey(opcion));
        return opcion;
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