class Operaciones {
    private String tipo;

    public Operaciones(String tipo) { this.tipo = tipo; }

    public Deposito RegistrarDeposito(Cliente cliente, Cuenta cuenta, Empleado empleado, double monto) {
        return (Deposito) cuenta.depositar(monto, empleado, cliente);
    }

    public Retiro RegistrarRetiro(Cliente cliente, Cuenta cuenta, Empleado empleado, double monto) {
        return (Retiro) cuenta.retirar(monto, empleado, cliente);
    }
}