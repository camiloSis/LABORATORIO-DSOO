import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SistemaBancario banco = new SistemaBancario("Banco GPT");

        Cliente c1 = new Cliente("juan", "perez", "123", "555-1", "juan@mail.com", "calle1", "C001", new ArrayList<>());
        Cliente c2 = new Cliente("maria", "lopez", "456", "555-2", "maria@mail.com", "calle2", "C002", new ArrayList<>());
        banco.registrarCliente(c1);
        banco.registrarCliente(c2);

        Empleado e1 = new Empleado("luis", "gomez", "111", "555-3", "luis@mail.com", "calle3", "E001", "cajero");
        banco.registrarEmpleado(e1);

        Cuenta cuenta1 = new Cuenta("AC001", "ahorros", 1000);
        Cuenta cuenta2 = new Cuenta("AC002", "corriente", 500);
        c1.agregarCuenta(cuenta1);
        c2.agregarCuenta(cuenta2);
        banco.registrarCuenta(cuenta1);
        banco.registrarCuenta(cuenta2);

        Operaciones ops = new Operaciones("deposito/retiro");

        ops.RegistrarDeposito(c1, cuenta1, e1, 200);
        ops.RegistrarRetiro(c2, cuenta2, e1, 100);

        System.out.println("=== cuentas ===");
        for (Cuenta c : banco.listarCuentas()) {
            System.out.println(c);
            for (Transaccion t : c.mostrarHistorial()) System.out.println("   " + t.mostrarDetalles());
        }

        System.out.println("total fondos: " + banco.calcularTotalFondos());
    }
}