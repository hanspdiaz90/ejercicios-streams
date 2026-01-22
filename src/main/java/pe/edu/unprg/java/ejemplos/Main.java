package pe.edu.unprg.java.ejemplos;

import pe.edu.unprg.java.ejemplos.modelo.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Empleado> datamockEmpleados = Datamock.obtenerEmpleados();
        List<Pedido> datamockPedidos = Datamock.obtenerPedidos();
        List<Curso> datamockCursos = Datamock.obtenerCursos();
        List<Alumno> datamockAlumnos = Datamock.obtenerAlumnos();
        List<Matricula> datamockMatriculas = Datamock.obtenerMatriculas(datamockAlumnos, datamockCursos);
        MenuOpciones.procesarMenu(datamockEmpleados, datamockPedidos, datamockCursos, datamockAlumnos, datamockMatriculas);
    }

}