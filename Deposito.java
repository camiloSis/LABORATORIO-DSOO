public class Deposito extends Transaccion {
    public Deposito (String idTransaccion, double monto, String tipo, 
                      Cuenta cuenta, Empleado empleado, Cliente cliente, String fecha){
        super(idTransaccion, monto, tipo, cuenta, empleado, cliente, fecha);
    }

    public boolean validarMonto (){
        return monto > 0;
    }

    public Transaccion actualizarCuenta (){
        double nuevoSaldo = cuenta.getSaldo() + monto;
        cuenta.setSaldo(nuevoSaldo);
        estadoTransaccion = true;
        return this;
    }
}