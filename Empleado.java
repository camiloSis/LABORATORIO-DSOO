public class Empleado extends Persona {
    private String idEmpleado;
    private String cargo;

    public Empleado(String nombre, String apellido, String dni, String telefono, String correo, String direccion,
                   String idEmpleado, String cargo) {
        super(nombre, apellido, dni, telefono, correo, direccion);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Transaccion procesarTransaccion(Cliente cliente, Cuenta cuenta, String tipo, double monto) {

        return null;
    }

    public ServicioAlCliente atenderCliente(Cliente cliente) {

        return null;
    }

    public Transaccion depositar(Cliente cliente, Cuenta cuenta, double monto) {
        return cuenta.depositar(monto, this, cliente);
    }

    public Transaccion retirar(Cliente cliente, Cuenta cuenta, double monto) {
        return cuenta.retirar(monto, this, cliente);
    }

    public void crearCuenta(Cliente cliente, Cuenta cuenta, SistemaBancario banco) {

    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", persona=" + super.toString() +
                '}';
    }
}