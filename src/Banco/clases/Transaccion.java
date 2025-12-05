
package Banco.clases;

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

    public Transaccion actualizarCuenta() { estadoTransaccion = true; return this; }
    public String mostrarDetalles() { return tipo + " | monto: " + monto + " | estado: " + (estadoTransaccion ? "ok" : "fallo"); }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Boolean getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(Boolean estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}