import java.time.LocalDate;

public class Director extends Empleado{

    private double comision;

    public Director(int num_empleado, String nombre, LocalDate fechaAlta, double salario, Departamento departamento, double comision) {
        super(num_empleado, nombre, fechaAlta, salario, departamento);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    double salarioAnual() {
        return getSalario()*14+comision;
    }
}
