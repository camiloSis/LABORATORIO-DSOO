
package Banco.clases;
import java.util.ArrayList;

class Cliente extends Persona {
    private String idCliente;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, String dni, String telefono, String correo, String direccion,
                   String idCliente, ArrayList<Cuenta> cuentas, String usuario, String contrasena) {
        super(nombre, apellido, dni, telefono, correo, direccion, usuario, contrasena);
        this.idCliente = idCliente;
        this.cuentas = cuentas != null ? cuentas : new ArrayList<>();
    }

    public Cliente() {
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        if (cuenta != null) cuentas.add(cuenta);
    }

    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }
    public ArrayList<Cuenta> getCuentas() { return cuentas; }
    public String getIdCliente() { return idCliente; }

    @Override
    public void mostrarMenu() {
        SistemaBancario banco = Main.getBanco(); // acceso al banco principal
        banco.mostrarMenuCliente(this);
    }

    @Override
    public String toString() {
        return "Cliente{" + super.toString() + " | idCliente=" + idCliente + "}";
    }
}