import java.util.ArrayList;

public class Cliente extends Persona {

    private String idCliente; 
    private ArrayList<Cuenta> cuentas; 

    // constructor 

    public Cliente(String nombre, String apellido, String dni, String telefono, String correo, String direccion,
                   String idCliente, ArrayList<Cuenta> cuentas) {
        super(nombre, apellido, dni, telefono, correo, direccion);
        this.idCliente = idCliente;
        this.cuentas = cuentas;
    }

    public void agregarCuenta (Cuenta cuenta){
        //validacion
        if (cuentas == null ) {
            cuentas = new ArrayList<>();
        }
            cuentas.add(cuenta);
        
    }

    public ArrayList<Cuenta> listarCuentas(){
        //si no hay cuentas, no habría lista y solo retorna un arraylist vacio, de lo contrario retorna el arraylist de las cuentas
        return (cuentas == null)? new ArrayList<>() : new ArrayList<>(cuentas);
    }

    public String getIdCliente(){
        return idCliente; 

    }

    public ArrayList<Cuenta> getCuentas () {
        return (cuentas == null)? new ArrayList<>() : cuentas;
    }
    

    @Override
    public String toString() {
        return "Cliente{" +
               "idCliente='" + idCliente + '\'' +
               ", cuentas=" + (cuentas != null ? cuentas : "[]") +
               ", persona=" + super.toString() +
               '}';
    }


}