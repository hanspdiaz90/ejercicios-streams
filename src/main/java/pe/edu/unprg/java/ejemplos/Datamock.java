package pe.edu.unprg.java.ejemplos;

import pe.edu.unprg.java.ejemplos.modelo.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Datamock {

    public static List<Empleado> obtenerEmpleados() {
        return Arrays.asList(
                new Empleado(1L, "Ana", "IT", 4500.0, true, LocalDate.of(2020, 1, 15)),
                new Empleado(2L, "Bruno", "Ventas", 2800.0, true, LocalDate.of(2021, 3, 10)),
                new Empleado(3L, "Carlos", "IT", 5200.0, true, LocalDate.of(2019, 7, 1)),
                new Empleado(4L, "Diana", "RRHH", 3100.0, false, LocalDate.of(2018, 5, 20)),
                new Empleado(5L, "Elena", "Ventas", 2600.0, true, LocalDate.of(2022, 2, 5)),
                new Empleado(6L, "Andrés", "Soporte", 2300.0, true, LocalDate.of(2023, 1, 12)),
                new Empleado(7L, "Alberto", "IT", 4800.0, false, LocalDate.of(2017, 11, 30)),
                new Empleado(8L, "Beatriz", "Finanzas", 6000.0, true, LocalDate.of(2016, 8, 18)),
                new Empleado(9L, "Alex", "Ventas", 3500.0, true, LocalDate.of(2020, 9, 25)),
                new Empleado(10L, "Marcos", "Soporte", 2100.0, false, LocalDate.of(2021, 12, 3))
        );
    }

    public static List<Pedido> obtenerPedidos() {
        return Arrays.asList(
                new Pedido(1L, "Juan", "Tecnología", 1200.0, true, LocalDate.of(2024, 1, 10)),
                new Pedido(2L, "María", "Hogar", 450.0, true, LocalDate.of(2024, 1, 12)),
                new Pedido(3L, "Pedro", "Tecnología", 780.0, false, LocalDate.of(2024, 1, 15)),
                new Pedido(4L, "Lucía", "Deportes", 620.0, true, LocalDate.of(2024, 1, 20)),
                new Pedido(5L, "Carlos", "Tecnología", 2500.0, true, LocalDate.of(2024, 2, 5)),
                new Pedido(6L, "Ana", "Hogar", 320.0, false, LocalDate.of(2024, 2, 8)),
                new Pedido(7L, "Luis", "Tecnología", 150.0, true, LocalDate.of(2024, 2, 10)),
                new Pedido(8L, "Sofía", "Moda", 980.0, true, LocalDate.of(2024, 2, 15)),
                new Pedido(9L, "Miguel", "Deportes", 1100.0, false, LocalDate.of(2024, 3, 1)),
                new Pedido(10L, "Elena", "Tecnología", 430.0, true, LocalDate.of(2024, 3, 5))
        );
    }

    public static List<Curso> obtenerCursos() {
        return Arrays.asList(
                new Curso("C0001", "Java Básico", 500, 40, LocalDate.of(2025, 2, 10)),
                new Curso("C0002", "Spring Boot", 900, 60, LocalDate.of(2025, 3, 5)),
                new Curso("C0003", "Docker", 700, 30, LocalDate.of(2025, 1, 20)),
                new Curso("C0004", "SQL Avanzado", 600, 50, LocalDate.of(2025, 4, 1)),
                new Curso("C0005", "Python Fundamentals", 550, 45, LocalDate.of(2025, 2, 18)),
                new Curso("C0006", "Kubernetes", 1200, 70, LocalDate.of(2025, 5, 10)),
                new Curso("C0007", "Angular", 800, 55, LocalDate.of(2025, 3, 22)),
                new Curso("C0008", "React", 850, 50, LocalDate.of(2025, 4, 15)),
                new Curso("C0009", "PostgreSQL", 650, 48, LocalDate.of(2025, 1, 30)),
                new Curso("C0010", "DevOps Essentials", 1000, 65, LocalDate.of(2025, 6, 5))
        );
    }

    public static List<Alumno> obtenerAlumnos() {
        return Arrays.asList(
                new Alumno("70123456", "Ana María", "Pérez", "Rojas", LocalDate.of(2000, 5, 10)),
                new Alumno("70987654", "Luis Alberto", "Gómez", "Díaz", LocalDate.of(1998, 8, 3)),
                new Alumno("70896547", "Carla", "Torres", "Vargas", LocalDate.of(2002, 11, 25)),
                new Alumno("71234598", "Miguel", "Ramírez", "Salas", LocalDate.of(1995, 2, 15)),
                new Alumno("71984562", "Paola", "Fernández", "León", LocalDate.of(2001, 7, 8)),
                new Alumno("70654789", "Jorge", "Mendoza", "Paredes", LocalDate.of(1997, 12, 19)),
                new Alumno("71589632", "Lucía", "Castillo", "Reyes", LocalDate.of(2003, 3, 2)),
                new Alumno("70321456", "Diego", "Rivas", "Campos", LocalDate.of(1999, 9, 27)),
                new Alumno("71784596", "Valeria", "Quispe", "Huamán", LocalDate.of(2004, 1, 14)),
                new Alumno("70458963", "Ricardo", "Navarro", "Peña", LocalDate.of(1996, 6, 30))
        );
    }

    public static List<Matricula> obtenerMatriculas(List<Alumno> alumnos, List<Curso> cursos) {
        return Arrays.asList(
                new Matricula(alumnos.get(0), cursos.get(0), LocalDate.of(2025, 1, 5), 16, true),
                new Matricula(alumnos.get(1), cursos.get(1), LocalDate.of(2025, 1, 12), 14, true),
                new Matricula(alumnos.get(2), cursos.get(2), LocalDate.of(2025, 1, 20), 18, true),
                new Matricula(alumnos.get(3), cursos.get(3), LocalDate.of(2025, 2, 2), 11, false),
                new Matricula(alumnos.get(4), cursos.get(4), LocalDate.of(2025, 2, 10), 15, true),
                new Matricula(alumnos.get(5), cursos.get(5), LocalDate.of(2025, 2, 18), 9, false),
                new Matricula(alumnos.get(6), cursos.get(6), LocalDate.of(2025, 3, 1), 17, true),
                new Matricula(alumnos.get(7), cursos.get(7), LocalDate.of(2025, 3, 5), 13, true),
                new Matricula(alumnos.get(8), cursos.get(8), LocalDate.of(2025, 3, 10), 12, true),
                new Matricula(alumnos.get(9), cursos.get(9), LocalDate.of(2025, 3, 18), 19, true)
        );
    }

}
