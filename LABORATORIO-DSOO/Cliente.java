import java.util.ArrayList;
import java.util.List;

class Cliente extends Persona {
    private String idCliente;
    private List<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, String dni, String telefono, String correo, String direccion,
                   String idCliente, List<Cuenta> cuentas) {
        super(nombre, apellido, dni, telefono, correo, direccion);
        this.idCliente = idCliente;
        this.cuentas = cuentas != null ? cuentas : new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        if (cuenta != null) cuentas.add(cuenta);
    }

    public List<Cuenta> getCuentas() { return cuentas; }
    public String getIdCliente() { return idCliente; }

    @Override
    public String toString() {
        return "Cliente{" + super.toString() + " | idCliente=" + idCliente + "}";
    }
}