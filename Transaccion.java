

public class Transaccion {
    protected String fecha;
    protected String idTransaccion;
    protected double monto;
    protected Cuenta cuenta;
    protected Cliente cliente;
    protected Empleado empleado;
    protected Boolean estadoTransaccion;
    protected String tipo;

    public Transaccion(String idTransaccion, double monto, String tipo, 
                      Cuenta cuenta, Empleado empleado, Cliente cliente, String fecha) {
        this.fecha = fecha;
        this.idTransaccion = idTransaccion;
        this.monto = monto;
        this.tipo = tipo;
        this.cuenta = cuenta;
        this.empleado = empleado;
        this.cliente = cliente;
        this.estadoTransaccion = false; 
    }

    public Transaccion ejecutar() {

        return null;
    }

    public String mostrarDetalles() {
 
        return null;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "fecha=" + fecha +
                ", idTransaccion='" + idTransaccion + '\'' +
                ", monto=" + monto +
                ", tipo='" + tipo + '\'' +
                ", cuenta=" + cuenta.getNumeroCuenta() +
                ", cliente=" + cliente.getNombre() +
                ", empleado=" + empleado.getNombre() +
                ", estado=" + estadoTransaccion +
                '}';
    }
}