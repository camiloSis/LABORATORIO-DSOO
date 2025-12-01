
package Banco.clases;

class Transaccion {
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

    public Transaccion actualizarCuenta() { estadoTransaccion = true; return this; }
    public String mostrarDetalles() { return tipo + " | monto: " + monto + " | estado: " + (estadoTransaccion ? "ok" : "fallo"); }
}