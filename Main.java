
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Operaciones operaciones = new Operaciones("Depósitos y Retiros");
    public static Operaciones getOperaciones() { return operaciones; }
    private static final SistemaBancario banco = new SistemaBancario("Banco Interactivo");
    public static SistemaBancario getBanco() { return banco; }

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar empleado");
            System.out.println("3. Ver Empleados, Cliente, Cuentasm Personas");
            System.out.println("4. Iniciar Sesion");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            String entrada = sc.nextLine().trim();

            if (!Validador.esSoloNumeros(entrada)){
                System.out.println("Ingrese un NUMERO valido");
                continue;
            }
            opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1 -> {
                    // Imprime lista de empleados disponibles
                    mostrarEmpleados();

                    // El cliente selecciona a un empleado que lo atienda
                    Empleado empleadoAtiende = elegirEmpleadoAtencion();

                    // Interaccion con el empleado para volverse Cliente
                    System.out.println("\nEl empleado " + empleadoAtiende.getNombre() + " lo atendera ahora.");
                    empleadoAtiende.registrarCliente(empleadoAtiende); // Metodo de empleado para registrar un nuevo Cliente
                }
                case 2 -> {
                    // Imprime lista de empleados disponibles
                    mostrarEmpleados();

                    Empleado empleadoEntrevista = elegirEmpleadoEntrevistador();

                    // Interaccion para volverse emplado
                    System.out.println("\nEl empleado " + empleadoEntrevista.getNombre() + " lo entrevistara ahora.");
                    banco.contratarEmpleado(empleadoEntrevista); // Metodo de SistemaBancario para contratar un nuevo Empleado
                }
                case 3 -> {
                    // Case temporal para seguimiento de creacion de Empleado, Cliente y Cuenta
                    System.out.println("\n=== Empleados ===");
                    for (Empleado e : banco.listarEmpleados()) System.out.println(e);

                    System.out.println("\n=== Clientes ===");
                    for (Cliente c : banco.listarClientes()) System.out.println(c);

                    System.out.println("\n=== Cuentas ===");
                    for (Cuenta c : banco.listarCuentas()) System.out.println(c);

                    System.out.println("\n=== Personas ===");
                    for (Persona p : Persona.getPersonasRegistradas()) System.out.println(p);
                }
                case 4 -> {
                    // Case para iniciar sesion ( Usuario, Contraseña )
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine().trim();

                    System.out.print("Contraseña: ");
                    String contrasena = sc.nextLine().trim();

                    Persona personaLogin = banco.iniciarSesion(usuario, contrasena);

                    if (personaLogin == null) {
                        System.out.println("Usuario o contraseña incorrectos.");
                    } else {
                        personaLogin.mostrarMenu();
                    }
                }
                case 5 -> { System.out.println("Saliendo del programa..."); return; }
                default -> System.out.println("Opción no válida.");
            }
        } while (true);
    }
 
    public static void mostrarEmpleados() {
        SistemaBancario banco = Main.getBanco();
        System.out.println("\nEmpleados disponibles:");
        int i = 1;
        for (Empleado e : banco.listarEmpleados()) {
            System.out.println(i + ". " + e.getNombre() + " (" + e.getIdEmpleado() + ")");
            i++;
        }
    }

    public static Empleado elegirEmpleadoEntrevistador() {
        Empleado empleadoEntrevista = null;
        String empIndex1;
                    
        do { 
            System.out.print("Selecciona un entrevistador: ");
            empIndex1 = sc.nextLine().trim();

            if (!Validador.esSoloNumeros(empIndex1)) {
                System.out.println("Ingresar un NUMERO valido.");
                continue;
            }
                        
            int num = Integer.parseInt(empIndex1);  
            if (num >= 1 && num <= banco.listarEmpleados().size()){
                empleadoEntrevista = banco.listarEmpleados().get(num-1);
            }
            else {
                System.out.println("Numero fuera del rango. Intente nuevamente.");
                empleadoEntrevista = null;
            }
        } while (empleadoEntrevista == null);

        return empleadoEntrevista;
    }

    public static Empleado elegirEmpleadoAtencion() {
        Empleado empleadoAtiende = null;
        String empIndex1;
                    
        do { 
            System.out.print("Selecciona un empleado: ");
            empIndex1 = sc.nextLine().trim();

            if (!Validador.esSoloNumeros(empIndex1)) {
                System.out.println("Ingresar un NUMERO valido.");
                continue;
            }
                        
            int num = Integer.parseInt(empIndex1);  
            if (num >= 1 && num <= banco.listarEmpleados().size()){
                empleadoAtiende = banco.listarEmpleados().get(num-1);
            }
            else {
                System.out.println("Numero fuera del rango. Intente nuevamente.");
                empleadoAtiende = null;
            }
        } while (empleadoAtiende == null);

        return empleadoAtiende;
    }
}