import java.time.LocalDate;
import java.util.Arrays;

public class Departamento implements Operaciones{

    //final private int TAM = 5;
    private int numeroEmpleados;
    private static int posicionInserciones;
    private String nombre;
    private String localizacion;
    private int dept_no;
    private static Empleado[] empleados;

    //Constructor parametrizado para agregación.
    public Departamento(String nombre, String localizacion, int dept_no, Empleado[] empleado) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.dept_no = dept_no;
        this.empleados = empleado;
    }
    //Constructor parametrizado para composición.
    public Departamento(String nombre, String localizacion, int dept_no) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.dept_no = dept_no;
        this.empleados = new Empleado[TAM];
        empleados[0] = new Director(1,"Ana", LocalDate.of(1999,12,10), 2200,Principal.departamentos[0], 542.36);
        numeroEmpleados++;
        empleados[1] = new Analista(12,"Oscar",LocalDate.of(1989,02,10),2280,Principal.departamentos[0]);
        numeroEmpleados++;
        empleados[2] = new Director(36,"Maria",LocalDate.of(1993,01,06),2300,this,781.36);
        numeroEmpleados++;
        empleados[3] = new Analista(23,"Amancio",LocalDate.of(1978,11,23),3000,this);
        numeroEmpleados++;
        posicionInserciones = 4;
    }//Constructor sin parámetros.
    public Departamento() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public static int getPosicionInserciones() {
        return posicionInserciones;
    }

    public void setPosicionInserciones(int posicionInserciones) {
        this.posicionInserciones = posicionInserciones;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\'' +
                ", Localizacion '" + localizacion + '\'' +
                ", Dept_no " + dept_no +
                " empleados=" + empleados;
    }

    public static int posicionEmpleado(int num_empleado){

        int posicion = 0;
        int i = 0;
        while (i<empleados.length){
            if (empleados[i] != null && num_empleado == empleados[i].getNum_empleado()){
                posicion = i;
            }
            i++;
        }
        return posicion;
    }
}
