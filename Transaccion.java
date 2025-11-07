

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
        System.out.println("Ejecutando transaccion...");
        estadoTransaccion = true;
        return this;
    }

    public String mostrarDetalles() {
        return "Transacción " + tipo + " | Monto: " + monto + 
               " | Fecha: " + fecha + " | Estado: " + (estadoTransaccion ? "Exitosa" : "Fallida");
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "fecha=" + fecha +
                ", idTransaccion='" + idTransaccion + '\'' +
                ", monto=" + monto +
                ", tipo='" + tipo + '\'' +
                ", cuenta=" + cuenta.getNumeroCuenta() +
                ", cliente=" + (cliente != null ? cliente.getNombre() : "N/A") +
                ", empleado=" + (cuenta != null ? cuenta.getNumeroCuenta() : "N/A") +
                ", estado=" + (estadoTransaccion ? "Exitosa" : "Fallida") +
                '}';
    }
}