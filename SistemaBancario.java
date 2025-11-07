import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {
    private List<Cuenta> cuentas;
    private List<Cliente> clientes;
    private List<Empleado> empleados;
    private String nombre;

    public SistemaBancario(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    public void inicializarDatos() {

    }

    public Cuenta crearCuenta(String tipo, double saldoInicial, Cliente cliente) {

        return null;
    }

    public Cuenta buscarCuenta(String numero) {

        return null;
    }

    public List<Cuenta> listarCuentas() {
        return new ArrayList<>(cuentas);
    }

    public void registrarCliente(Cliente cliente) {

    }

    public Cliente buscarCliente(String dni) {
 
        return null;
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public void registrarEmpleado(Empleado empleado) {

    }

    public Empleado buscarEmpleado(String idEmpleado) {

        return null;
    }

    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }

    public double calcularTotalFondos() {

        return 0.0;
    }
}