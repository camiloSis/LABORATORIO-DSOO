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

    public Transaccion depositar(double monto) {

        return null;
    }

    public Transaccion retirar(double monto) {

        return null;
    }

    public double consultarSaldo() {

        return 0.0;
    }

    public void agregarTitular(Cliente titular) {

    }

    public Transaccion agregarTransaccion(Transaccion transaccion) {

        return null;
    }

    public List<Cliente> mostrarTitulares() {

        return null;
    }

    public List<Transaccion> mostrarHistorial() {

        return null;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getSaldo() {
        return String.valueOf(saldo);
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