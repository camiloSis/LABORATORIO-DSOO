public class Retiro extends Transaccion {
    public Retiro (String idTransaccion, double monto, String tipo, 
                      Cuenta cuenta, Empleado empleado, Cliente cliente, String fecha){
        super(idTransaccion, monto, tipo, cuenta, empleado, cliente, fecha);
    }

    public boolean validarSaldo (){
        return true; // el metodo debe retornar algo, por eso le puse como ejemplo true, no sé si será el indicado 

    }

    public Transaccion actualizarCuenta (){
        return null; 

    }
}