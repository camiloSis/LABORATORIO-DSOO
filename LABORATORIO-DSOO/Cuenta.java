import java.util.ArrayList;
import java.util.List;

class Cuenta {
    private String numeroCuenta;
    private String tipo;
    private double saldo;
    private String estado;
    private List<Transaccion> transacciones;
    private List<Cliente> titulares;

    public Cuenta(String numeroCuenta, String tipo, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.estado = "Activa";
        this.transacciones = new ArrayList<>();
        this.titulares = new ArrayList<>();
    }

    public Transaccion depositar(double monto, Empleado empleado, Cliente cliente) {
        Deposito deposito = new Deposito(numeroCuenta, monto, tipo, this, empleado, cliente, "2025-11-07");
        if (!deposito.validarMonto()) return null;
        deposito.actualizarCuenta();
        agregarTransaccion(deposito);
        return deposito;
    }

    public Transaccion retirar(double monto, Empleado empleado, Cliente cliente) {
        Retiro retiro = new Retiro(numeroCuenta, monto, tipo, this, empleado, cliente, "2025-11-07");
        if (!retiro.validarSaldo()) return null;
        retiro.actualizarCuenta();
        agregarTransaccion(retiro);
        return retiro;
    }

    public void agregarTitular(Cliente cliente) { titulares.add(cliente); }
    public void agregarTransaccion(Transaccion t) { transacciones.add(t); }

    public List<Cliente> mostrarTitulares() { return titulares; }
    public List<Transaccion> mostrarHistorial() { return transacciones; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta='" + numeroCuenta + '\'' + ", tipo='" + tipo + '\'' +
                ", saldo=" + saldo + ", estado='" + estado + '\'' + '}';
    }
}