import java.util.Scanner;

/*
 CAMBIO: Administrador ahora extiende Empleado (no Persona).
 Esto permite registrar administradores en mapaEmpleados (Map<String, Empleado>)
 sin errores de tipo.
*/
public class Administrador extends Empleado {
    private int nivelAcceso = 1; // 1 = total

    // Constructor que reusa el constructor de Empleado
    public Administrador(String nombre, String apellido, String dni, String telefono,
                         String correo, String direccion, String idEmpleado,
                         String cargo, String usuario, String contrasena) {
        super(nombre, apellido, dni, telefono, correo, direccion, idEmpleado, cargo, usuario, contrasena);
    }

    public Administrador() { super(); }

    // CAMBIO: alias para mantener la API anterior si usabas getIdAdministrador()
    public String getIdAdministrador() { return getIdEmpleado(); }
    public void setIdAdministrador(String id) { setIdEmpleado(id); }

    public int getNivelAcceso() { return nivelAcceso; }
    public void setNivelAcceso(int nivel) { this.nivelAcceso = nivel; }

    @Override
    public void mostrarMenu() {
        // CAMBIO: usar Main.getScanner() en lugar de new Scanner(System.in)
        SistemaBancario banco = Main.getBanco();
        Scanner sc = Main.getScanner();
        int opcion;
        do {
            System.out.println("\n=== MENU ADMINISTRADOR ===");
            System.out.println("1. Listar clientes");
            System.out.println("2. Listar empleados");
            System.out.println("3. Listar cuentas");
            System.out.println("4. Listar personas");
            System.out.println("5. Ver fondos totales");
            System.out.println("6. Crear nuevo administrador");
            System.out.println("7. Cerrar sesión");
            System.out.print("Seleccione una opcion: ");
            String entrada = sc.nextLine().trim();
            try { 
                opcion = Integer.parseInt(entrada); 
            } catch (NumberFormatException e) { 
                System.out.println("Opcion no valida"); 
                continue; 
            }

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n=== CLIENTES ===");
                    for (Cliente c : banco.listarClientes()) System.out.println(c);
                }
                case 2 -> {
                    System.out.println("\n=== EMPLEADOS ===");
                    for (Empleado e : banco.listarEmpleados()) System.out.println(e);
                }
                case 3 -> {
                    System.out.println("\n=== CUENTAS ===");
                    for (Cuenta c : banco.listarCuentas()) System.out.println(c);
                }
                case 4 -> {
                    System.out.println("\n=== PERSONAS ===");
                    for (Persona p : Persona.getPersonasRegistradas()) System.out.println(p);
                }
                case 5 -> {
                    double total = banco.calcularTotalFondos();
                    System.out.printf("Fondos totales: S/. %.2f%n", total);
                }
                case 6 -> {
                    // CAMBIO: pedir datos y crear administrador; usar registrarAdministrador(nuevo, this)
                    System.out.println("\n=== CREAR ADMINISTRADOR ===");
                    
                    // Nombre
                    String nombre;
                    do {
                        System.out.print("Nombre: ");
                        nombre = sc.nextLine().trim();
                        
                        if (!Validador.esSoloLetrasNombre(nombre)) {
                            System.out.println("Nombre inválido. Use solo letras, espacios, guiones o apóstrofes.");
                            nombre = null;
                            continue;
                        }
                    } while (nombre == null || nombre.isEmpty());

                    // Apellido
                    String apellido;
                    do {
                        System.out.print("Apellido: ");
                        apellido = sc.nextLine().trim();
                        
                        if (!Validador.esSoloLetrasNombre(apellido)) {
                            System.out.println("Apellido inválido. Use solo letras, espacios, guiones o apóstrofes.");
                            apellido = null;
                            continue;
                        }
                    } while (apellido == null || apellido.isEmpty());

                    // DNI
                    String dni;
                    do {
                        System.out.print("DNI: ");
                        dni = sc.nextLine().trim();
                        
                        if (!dni.matches("\\d{8}")) {
                            System.out.println("DNI inválido. Debe contener exactamente 8 dígitos numéricos.");
                            dni = null;
                            continue;
                        }
                        
                        if (Persona.buscarPersonaPorDni(dni) != null) {
                            System.out.println("Ya existe una persona con ese DNI.");
                            dni = null;
                        }
                    } while (dni == null);

                    // Teléfono
                    String telefono;
                    do {
                        System.out.print("Telefono: ");
                        telefono = sc.nextLine().trim();
                        
                        String telefonoDigits = telefono.replaceAll("\\D", "");
                        
                        if (!telefonoDigits.matches("\\d{9}")) {
                            System.out.println("Teléfono inválido. Debe contener exactamente 9 dígitos numéricos.");
                            telefono = null;
                            continue;
                        }
                        
                        if (Persona.buscarPersonaPorTelefono(telefonoDigits) != null) {
                            System.out.println("Ya existe una persona con ese teléfono.");
                            telefono = null;
                        } else {
                            telefono = telefonoDigits;
                        }
                    } while (telefono == null);

                    // Correo
                    String correo;
                    do {
                        System.out.print("Correo: ");
                        correo = sc.nextLine().trim();
                        
                        if (Persona.buscarPersonaPorCorreo(correo) != null) {
                            System.out.println("Ya existe una persona con ese correo.");
                            correo = null;
                        }
                    } while (correo == null || correo.isEmpty());

                    // Dirección
                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine().trim();

                    // Usuario
                    String usuario;
                    do {
                        System.out.print("Usuario: ");
                        usuario = sc.nextLine().trim();
                        
                        if (Persona.buscarPersonaPorUsuario(usuario) != null) {
                            System.out.println("Ese nombre de usuario ya está en uso.");
                            usuario = null;
                        }
                    } while (usuario == null || usuario.isEmpty());

                    // Contraseña
                    String contrasena;
                    do {
                        System.out.print("Contrasena: ");
                        contrasena = sc.nextLine().trim();
                        
                        if (contrasena.length() < 4) {
                            System.out.println("La contraseña debe tener al menos 4 caracteres.");
                            contrasena = null;
                        }
                    } while (contrasena == null);

                    String idAdm = banco.generarIdEmpleado().replace("EMP", "ADM");
                    Administrador nuevo = new Administrador(nombre, apellido, dni, telefono, correo, direccion, idAdm, "Administrador", usuario, contrasena);

                    boolean ok = banco.registrarAdministrador(nuevo, this);
                    if (ok) System.out.println("✓ Administrador creado: " + idAdm);
                    else System.out.println("✗ No se pudo crear el administrador.");
                }
                case 7 -> { 
                    System.out.println("Cerrando sesión..."); 
                    return; 
                }
                default -> System.out.println("Opción no válida");
            }
        } while (true);
        // CAMBIO: NO cerrar el Scanner aquí
    }

    @Override
    public String toString() {
        return super.toString() + " | ADMIN | nivel:" + nivelAcceso;
    }
}