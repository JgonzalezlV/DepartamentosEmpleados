import java.time.LocalDate;

public abstract class Empleado {

    private int num_empleado;
    private String nombre;
    private LocalDate fechaAlta;
    private double salario;
    private Departamento departamento = new Departamento();

    /**
     *
     * @param num_empleado
     * @param nombre
     * @param fechaAlta
     * @param salario
     * @param departamento
     */
    public Empleado(int num_empleado, String nombre, LocalDate fechaAlta, double salario, Departamento departamento) {
        this.num_empleado = num_empleado;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Empleado(){

    }

    public int getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(int num_empleado) {
        this.num_empleado = num_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento(Departamento departamento) {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Num_empleado: " + num_empleado +
                ", Nombre: '" + nombre + '\'' +
                ", FechaAlta: " + fechaAlta +
                ", Salario: " + salario +
                ", Departamento al que pertenece: " + departamento;
    }

    public void saludar(){

        System.out.println("Saluda un empleado. ");

    }
    abstract double salarioAnual();

}
