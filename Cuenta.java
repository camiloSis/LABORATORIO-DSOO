import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numeroCuenta;
    private String tipo;
    private double saldo;
    private String estado;
    private ArrayList<Transaccion> transacciones;
    private ArrayList<Cliente> titulares;

    public Cuenta(String numeroCuenta, String tipo, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.estado = "Activa"; // Por defecto
        this.transacciones = new ArrayList<>();
        this.titulares = new ArrayList<>();
    }

    public Transaccion depositar(double monto, Empleado empleado, Cliente cliente) {
        Deposito deposito = new Deposito(estado, monto, tipo, this, empleado, cliente, tipo);
        if (!deposito.validarMonto()){
            System.out.println("No se pudo realizar el deposito: monto invalido");
            return null;
        }
        deposito.actualizarCuenta();
        agregarTransaccion(deposito);
        return deposito;
    }

    public Transaccion retirar(double monto, Empleado empleado, Cliente cliente) {
        Retiro retiro = new Retiro(estado, monto, tipo, this, empleado, cliente, tipo);
        if (!retiro.validarSaldo()){
            System.out.println("No se pudo realizar el retiro: saldo insuficiente o monto invalido");
            return null;
        }
        retiro.actualizarCuenta();
        agregarTransaccion(retiro);
        return retiro;
    }

    public String consultarSaldo() {
        return String.valueOf(saldo); //muestra el saldo
    }

    public void agregarTitular(Cliente titular) {
        titulares.add(titular);
    }

    public Transaccion agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
        return transaccion;
    }

    public List<Cliente> mostrarTitulares() {
        return titulares;
    }

    public List<Transaccion> mostrarHistorial() {
        return transacciones;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double  getSaldo() {
        return saldo; //acceder al saldo internamente
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo; //set agregado para actualizar monto
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", tipo='" + tipo + '\'' +
                ", saldo=" + saldo +
                ", estado='" + estado + '\'' +
                ", titulares=" + titulares +
                '}';
    }
}