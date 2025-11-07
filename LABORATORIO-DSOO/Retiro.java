class Retiro extends Transaccion {
    public Retiro(String idTransaccion, double monto, String tipo,
                  Cuenta cuenta, Empleado empleado, Cliente cliente, String fecha) {
        super(idTransaccion, monto, tipo, cuenta, empleado, cliente, fecha);
    }

    public boolean validarSaldo() { return monto > 0 && monto <= cuenta.getSaldo(); }

    @Override
    public Transaccion actualizarCuenta() {
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        estadoTransaccion = true;
        return this;
    }
}