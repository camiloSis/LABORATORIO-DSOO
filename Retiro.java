public class Retiro extends Transaccion {
    public Retiro (String idTransaccion, double monto, String tipo, 
                      Cuenta cuenta, Empleado empleado, Cliente cliente, String fecha){
        super(idTransaccion, monto, tipo, cuenta, empleado, cliente, fecha);
    }

    public boolean validarSaldo (){
        return monto > 0 && monto <= cuenta.getSaldo(); // el metodo debe retornar algo, por eso le puse como ejemplo true, no sé si será el indicado 
    }

    public Transaccion actualizarCuenta (){
        double nuevoSaldo = cuenta.getSaldo() - monto;
        cuenta.setSaldo(nuevoSaldo);
        estadoTransaccion = true;
        return this; 
    }
}