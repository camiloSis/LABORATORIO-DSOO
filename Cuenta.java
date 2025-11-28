import java.util.ArrayList;
import java.util.List;

class Cuenta {
    private String numeroCuenta;
    private String tipo;
    private double saldo;
    private String estado;
    private ArrayList<Transaccion> transacciones = new ArrayList<>();
    private ArrayList<Cliente> titulares;

    public Cuenta(String numeroCuenta, String tipo, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo.toUpperCase();
        this.saldo = saldo;
        this.estado = "Activa";
        this.transacciones = new ArrayList<>();
        this.titulares = new ArrayList<>();
    }

    public Transaccion depositar(double monto, Empleado empleado, Cliente cliente) {
        String idTransaccion = "DEP-" + System.currentTimeMillis();
        String fecha = java.time.LocalDate.now().toString();

        Deposito deposito = new Deposito(idTransaccion, monto, "DEPOSITO",
                                        this, empleado, cliente, fecha);

        if (deposito.validarMonto()) {
            deposito.actualizarCuenta(); // suma al saldo
            transacciones.add(deposito);
        } else {
            System.out.println("Monto invalido. Deposito cancelado.");
            deposito = null; // no se registra la transacción
        }

        return deposito;
    }

    public Transaccion retirar(double monto, Empleado empleado, Cliente cliente) {
        String idTransaccion = "RET-" + System.currentTimeMillis();
        String fecha = java.time.LocalDate.now().toString();

        Retiro retiro = new Retiro(idTransaccion, monto, "RETIRO",
                                        this, empleado, cliente, fecha);

        if (retiro.validarSaldo()) {
            retiro.actualizarCuenta(); // resta al saldo
            transacciones.add(retiro);
        } else {
            System.out.println("Saldo insuficiene o monto invalido. Retiro cancelado.");
            retiro = null; // no se registra la transacción
        }

        return retiro;
    }

    public void agregarTitular(Cliente cliente) { titulares.add(cliente); }
    public void agregarTransaccion(Transaccion t) { transacciones.add(t); }

    public List<Cliente> mostrarTitulares() { return titulares; }
    public void imprimirHistorial() { 
        System.out.println("\n=== HISTORIAL DE TRANSACCIONES ===");
        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
            return;
        }

        for (Transaccion t : transacciones) {
            System.out.println("-------------------------------------");
            System.out.println("ID: " + t.idTransaccion);
            System.out.println("Tipo: " + t.tipo);
            System.out.println("Monto: S/." + t.monto);
            System.out.println("Fecha: " + t.fecha);
            System.out.println("Empleado: " + t.empleado.getNombre());
            System.out.println("Cliente: " + t.cliente.getNombre());
            System.out.println("Estado: " + (t.estadoTransaccion ? "Completada" : "Fallida"));
        }
        System.out.println("-------------------------------------");
    }

    public ArrayList<Transaccion> mostrarHistorial() { return transacciones; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta='" + numeroCuenta + '\'' + ", tipo='" + tipo + '\'' +
                ", saldo=" + saldo + ", estado='" + estado + '\'' + '}';
    }
}