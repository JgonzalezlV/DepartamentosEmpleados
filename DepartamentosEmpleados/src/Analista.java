import java.time.LocalDate;

public class Analista extends Empleado{

    public Analista(int num_empleado, String nombre, LocalDate fechaAlta, double salario, Departamento departamento) {
        super(num_empleado, nombre, fechaAlta, salario, departamento);
    }

    @Override
    double salarioAnual() {
        return getSalario()*14;
    }
}
