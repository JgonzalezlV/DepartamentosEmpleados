public interface OperacionesEmpleado extends Operaciones{

    void mostrarEmpleados(Departamento d);
    boolean empleadosLleno(Departamento d);
    boolean empleadosVacios(Departamento d);
    int existeEmpleado(int num_empleado, Departamento d);
    public int buscarHuecosEmpleados(Departamento d);

}
