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