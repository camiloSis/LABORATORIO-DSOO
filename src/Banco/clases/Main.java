
package Banco.clases;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    
    // CAMBIO: Getter para que otras clases accedan al Scanner compartido
    public static Scanner getScanner() { return sc; }
    
    // CAMBIO: Constructor sin parámetros
    private static final Operaciones operaciones = new Operaciones();
    public static Operaciones getOperaciones() { return operaciones; }
    
    private static final SistemaBancario banco = new SistemaBancario("Banco Interactivo");
    public static SistemaBancario getBanco() { return banco; }

    public static void main(String[] args) {
        try {
            int opcion;
            do {
                System.out.println("\n===== MENU PRINCIPAL =====");
                System.out.println("1. Registrar cliente");
                System.out.println("2. Registrar empleado (entrevista)");
                System.out.println("3. Iniciar sesión");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                String entrada = sc.nextLine().trim();

                if (!Validador.esSoloNumeros(entrada)) {
                    System.out.println("Ingrese un NUMERO valido");
                    continue;
                }
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    // CAMBIO: Registrar cliente con empleado que lo atienda
                    case 1 -> {
                        mostrarEmpleados();
                        Empleado empleadoAtiende = elegirEmpleadoAtencion();
                        if (empleadoAtiende == null) { System.out.println("Error: empleado no válido"); break; }
                        System.out.println("\nEl empleado " + empleadoAtiende.getNombre() + " lo atendera ahora.");
                        // CAMBIO: Pasar empleadoAtiende en lugar de null
                        empleadoAtiende.registrarCliente(empleadoAtiende);
                    }
                    // CAMBIO: Registrar empleado mediante entrevista
                    case 2 -> {
                        mostrarEmpleados();
                        Empleado entrevistador = elegirEmpleadoEntrevistador();
                        if (entrevistador == null) { System.out.println("Error: entrevistador no válido"); break; }
                        System.out.println("\nEl empleado " + entrevistador.getNombre() + " lo entrevistara ahora.");
                        // CAMBIO: contratarEmpleado espera un Empleado que realice la entrevista
                        banco.contratarEmpleado(entrevistador);
                    }
                    // CAMBIO: Iniciar sesión (Usuario, Contraseña)
                    case 3 -> {
                        System.out.print("Usuario: "); String usuario = sc.nextLine().trim();
                        System.out.print("Contrasena: "); String contrasena = sc.nextLine().trim();

                        Persona personaLogin = banco.iniciarSesion(usuario, contrasena);
                        if (personaLogin == null) {
                            System.out.println("Usuario o contraseña incorrectos.");
                        } else {
                            // CAMBIO: Ahora funciona con Cliente, Empleado Y Administrador
                            personaLogin.mostrarMenu();
                        }
                    }
                    // CAMBIO: Salir del programa
                    case 4 -> { System.out.println("Saliendo..."); return; }
                    default -> System.out.println("Opcion no valida");
                }
            } while (true);
        } finally {
            // CAMBIO: Cerrar Scanner al salir, sin importar cómo (excepción o return)
            sc.close();
        }
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
        // CAMBIO: Obtener banco localmente
        SistemaBancario banco = Main.getBanco();
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
            // CAMBIO: Validación de rango
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
        // CAMBIO: Obtener banco localmente
        SistemaBancario banco = Main.getBanco();
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
            // CAMBIO: Validación de rango
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