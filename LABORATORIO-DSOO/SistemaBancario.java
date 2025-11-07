import java.util.ArrayList;
import java.util.List;

class SistemaBancario {
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

    public void registrarCliente(Cliente cliente) { if (cliente != null) clientes.add(cliente); }
    public void registrarEmpleado(Empleado empleado) { if (empleado != null) empleados.add(empleado); }
    public void registrarCuenta(Cuenta cuenta) { if (cuenta != null) cuentas.add(cuenta); }

    public Cliente buscarCliente(String dni) {
        for (Cliente c : clientes) if (c.getDni().equals(dni)) return c;
        return null;
    }

    public Empleado buscarEmpleado(String id) {
        for (Empleado e : empleados) if (e.getIdEmpleado().equals(id)) return e;
        return null;
    }

    public Cuenta buscarCuenta(String numero) {
        for (Cuenta c : cuentas) if (c.getNumeroCuenta().equals(numero)) return c;
        return null;
    }

    public List<Cliente> listarClientes() { return new ArrayList<>(clientes); }
    public List<Empleado> listarEmpleados() { return new ArrayList<>(empleados); }
    public List<Cuenta> listarCuentas() { return new ArrayList<>(cuentas); }

    public double calcularTotalFondos() {
        double total = 0;
        for (Cuenta c : cuentas) total += c.getSaldo();
        return total;
    }
}