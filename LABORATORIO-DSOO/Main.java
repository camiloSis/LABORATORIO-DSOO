import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final SistemaBancario banco = new SistemaBancario("Banco Interactivo");
    private static final Operaciones operaciones = new Operaciones("Depósitos y Retiros");

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar empleado");
            System.out.println("3. Crear cuenta");
            System.out.println("4. Realizar depósito");
            System.out.println("5. Realizar retiro");
            System.out.println("6. Mostrar cuentas y transacciones");
            System.out.println("7. Mostrar total de fondos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> registrarEmpleado();
                case 3 -> crearCuenta();
                case 4 -> realizarDeposito();
                case 5 -> realizarRetiro();
                case 6 -> mostrarCuentas();
                case 7 -> System.out.println("Total de fondos en el banco: " + banco.calcularTotalFondos());
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }

    // --- Métodos de menú ---
    private static void registrarCliente() {
        System.out.println("\n--- Registrar Cliente ---");
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Apellido: "); String apellido = sc.nextLine();
        System.out.print("DNI: "); String dni = sc.nextLine();
        System.out.print("Teléfono: "); String telefono = sc.nextLine();
        System.out.print("Correo: "); String correo = sc.nextLine();
        System.out.print("Dirección: "); String direccion = sc.nextLine();
        String idCliente = "C" + (banco.listarClientes().size() + 1);
        Cliente cliente = new Cliente(nombre, apellido, dni, telefono, correo, direccion, idCliente, new ArrayList<>());
        banco.registrarCliente(cliente);
        System.out.println("Cliente registrado con ID: " + idCliente);
    }

    private static void registrarEmpleado() {
        System.out.println("\n--- Registrar Empleado ---");
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Apellido: "); String apellido = sc.nextLine();
        System.out.print("DNI: "); String dni = sc.nextLine();
        System.out.print("Teléfono: "); String telefono = sc.nextLine();
        System.out.print("Correo: "); String correo = sc.nextLine();
        System.out.print("Dirección: "); String direccion = sc.nextLine();
        System.out.print("Cargo: "); String cargo = sc.nextLine();
        String idEmpleado = "E" + (banco.listarEmpleados().size() + 1);
        Empleado emp = new Empleado(nombre, apellido, dni, telefono, correo, direccion, idEmpleado, cargo);
        banco.registrarEmpleado(emp);
        System.out.println("Empleado registrado con ID: " + idEmpleado);
    }

    private static void crearCuenta() {
        System.out.println("\n--- Crear Cuenta ---");
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cliente = banco.buscarCliente(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Número de cuenta: ");
        String numero = sc.nextLine();
        System.out.print("Tipo de cuenta: ");
        String tipo = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = Double.parseDouble(sc.nextLine());
        Cuenta cuenta = new Cuenta(numero, tipo, saldo);
        cliente.agregarCuenta(cuenta);
        banco.registrarCuenta(cuenta);
        cuenta.agregarTitular(cliente);
        System.out.println("Cuenta creada con éxito para " + cliente.getNombre());
    }

    private static void realizarDeposito() {
        System.out.println("\n--- Realizar Depósito ---");
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cliente = banco.buscarCliente(dni);
        if (cliente == null) { System.out.println("Cliente no encontrado."); return; }

        System.out.print("ID del empleado: ");
        String idE = sc.nextLine();
        Empleado emp = banco.buscarEmpleado(idE);
        if (emp == null) { System.out.println("Empleado no encontrado."); return; }

        System.out.print("Número de cuenta: ");
        String num = sc.nextLine();
        Cuenta cuenta = banco.buscarCuenta(num);
        if (cuenta == null) { System.out.println("Cuenta no encontrada."); return; }

        System.out.print("Monto a depositar: ");
        double monto = Double.parseDouble(sc.nextLine());
        operaciones.RegistrarDeposito(cliente, cuenta, emp, monto);
        System.out.println("Depósito realizado correctamente.");
    }

    private static void realizarRetiro() {
        System.out.println("\n--- Realizar Retiro ---");
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cliente = banco.buscarCliente(dni);
        if (cliente == null) { System.out.println("Cliente no encontrado."); return; }

        System.out.print("ID del empleado: ");
        String idE = sc.nextLine();
        Empleado emp = banco.buscarEmpleado(idE);
        if (emp == null) { System.out.println("Empleado no encontrado."); return; }

        System.out.print("Número de cuenta: ");
        String num = sc.nextLine();
        Cuenta cuenta = banco.buscarCuenta(num);
        if (cuenta == null) { System.out.println("Cuenta no encontrada."); return; }

        System.out.print("Monto a retirar: ");
        double monto = Double.parseDouble(sc.nextLine());
        operaciones.RegistrarRetiro(cliente, cuenta, emp, monto);
        System.out.println("Retiro realizado correctamente.");
    }

    private static void mostrarCuentas() {
        System.out.println("\n--- Cuentas Registradas ---");
        for (Cuenta c : banco.listarCuentas()) {
            System.out.println(c);
            for (Transaccion t : c.mostrarHistorial()) {
                System.out.println("   " + t.mostrarDetalles());
            }
        }
    }
}
