import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SistemaBancario {
    private Map<String, Cuenta> mapaCuentas;
    private Map<String, Cliente> mapaClientes;
    private Map<String, Empleado> mapaEmpleados;
    private String nombreBanco;
    private Operaciones operaciones;

    private static int contadorClientes = 4;
    private static int contadorCuentas = 1003;
    private static int contadorEmpleados = 3;

    public SistemaBancario(String nombreBanco) {
        this.operaciones = Main.getOperaciones();
        this.nombreBanco = nombreBanco;
        this.mapaCuentas = new HashMap<>();
        this.mapaClientes = new HashMap<>();
        this.mapaEmpleados = new HashMap<>();

        //empleados iniciales
        Empleado cajeroPrincipal = new Empleado("Luis", "Gómez", "72846315", "958431276", "luis@mail.com", "Av. Libertad 123", "EMP-001", "Cajero", "lgomez", "Lgomez@2025!");
        Empleado adminSucursal = new Empleado("Ana", "Martínez", "49302784", "994205318", "ana@mail.com", "Calle Central 45", "EMP-002", "Administrador", "amartinez", "Amartinez#2025");
        registrarEmpleado(cajeroPrincipal);
        registrarEmpleado(adminSucursal);

        //clientes iniciales
        Cliente clienteDina = new Cliente("Dina", "Boluarte", "74120589", "977412589", "dina.boluarte@gmail.com", "Av. Perú 100", "CLI-0001", new ArrayList<>(), "dina_bolua", "Dina!2025#");
        Cliente clienteJose = new Cliente("Jose", "Jeri", "61908347", "962190347", "jose.jeri@gmail.com", "Calle Lima 200", "CLI-0002", new ArrayList<>(), "jeri_jose", "Jeri@Dev#98");
        Cliente clientePedro = new Cliente("Pedro", "Castillo", "58320714", "985832714", "pedro.castillo@gmail.com", "Calle Norte 300", "CLI-0003", new ArrayList<>(), "pedro_cast", "Pcastle2025!%");
        registrarCliente(clienteDina);
        registrarCliente(clienteJose);
        registrarCliente(clientePedro);

        //cuentas iniciales
        Cuenta cuentaAhorrosDina = new Cuenta("CTA-001000", "Ahorros", 1500);
        Cuenta cuentaCorrienteJose = new Cuenta("CTA-001001", "Corriente", 800);
        Cuenta cuentaAhorrosPedro = new Cuenta("CTA-001002", "Ahorros", 3000);

        //asignar cuentas a los clientes
        clienteDina.agregarCuenta(cuentaAhorrosDina);
        clienteJose.agregarCuenta(cuentaCorrienteJose);
        clientePedro.agregarCuenta(cuentaAhorrosPedro);

        //establecer titulares
        cuentaAhorrosDina.agregarTitular(clienteDina);
        cuentaCorrienteJose.agregarTitular(clienteJose);
        cuentaAhorrosPedro.agregarTitular(clientePedro);

        //registrar cuentas en el banco
        registrarCuenta(cuentaAhorrosDina);
        registrarCuenta(cuentaCorrienteJose);
        registrarCuenta(cuentaAhorrosPedro);
    }

    // Metodos de Registro
    public void registrarCliente(Cliente cliente) { 
        if (cliente != null && !mapaClientes.containsKey(cliente.getDni())) 
            mapaClientes.put(cliente.getDni(), cliente); 
    }

    public void registrarEmpleado(Empleado empleado) { 
        if (empleado != null && !mapaEmpleados.containsKey(empleado.getDni())) 
            mapaEmpleados.put(empleado.getIdEmpleado(), empleado); 
    }

    public void registrarCuenta(Cuenta cuenta) { 
        if (cuenta != null && !mapaCuentas.containsKey(cuenta.getNumeroCuenta())) 
            mapaCuentas.put(cuenta.getNumeroCuenta(), cuenta); 
    }

    // Metodos de busqueda
    public Cliente buscarClientePorDni(String dniCliente) { 
        return mapaClientes.getOrDefault(dniCliente, null); 
    }

    public Empleado buscarEmpleadoPorId(String idEmpleado) { 
        return mapaEmpleados.getOrDefault(idEmpleado, null); 
    }

    public Cuenta buscarCuenta(String numeroCuenta) { 
        return mapaCuentas.getOrDefault(numeroCuenta, null); 
    }

    // Generadores de IDs
    public String generarIdCliente() {
        return String.format("CLI-%04d", contadorClientes++); // Ej: CLI-0001
    }

    public String generarNumeroCuenta() {
        return String.format("CTA-%06d", contadorCuentas++); // Ej: CTA-001000
    }

    public String generarIdEmpleado() {
        return String.format("EMP-%03d", contadorEmpleados++); // Ej: EMP-004
    }

    public ArrayList<Cliente> listarClientes() { return new ArrayList<>(mapaClientes.values()); }
    public ArrayList<Empleado> listarEmpleados() { return new ArrayList<>(mapaEmpleados.values()); }
    public ArrayList<Cuenta> listarCuentas() { return new ArrayList<>(mapaCuentas.values()); }

    public double calcularTotalFondos() {
        double totalFondos = 0;
        for (Cuenta cuenta : mapaCuentas.values()) {
            totalFondos += cuenta.getSaldo();
        }
        return totalFondos;
    }

    public void contratarEmpleado(Empleado empAtiende) {
        Scanner sc = new Scanner(System.in);
        SistemaBancario banco = Main.getBanco(); // Permite trabajar con un solo objeto tipo SistemaBancario

        System.out.println("\n=== ENTREVISTA AL EMPLEADO ===");

        Empleado nuevoEmpleado = new Empleado();

        // Nombre
        String nombre;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Cuál es su nombre? ");
            nombre = sc.nextLine().trim().toUpperCase();
        } while (!nuevoEmpleado.setNombre(nombre));

        // Apellido
        String apellido;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Y su apellido? ");
            apellido = sc.nextLine().trim().toUpperCase();
        } while (!nuevoEmpleado.setApellido(apellido));

        // DNI
        String dni;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Su DNI? ");
            dni = sc.nextLine().trim();

            if (Persona.buscarPersonaPorDni(dni) != null) {
                System.out.println("\nYa existe una persona con ese DNI. Registro cancelado.");
                dni = null;
            }
        } while (dni == null || !nuevoEmpleado.setDni(dni));

        // Telefono
        String telefono;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Su teléfono (9 dígitos)? ");
            telefono = sc.nextLine().trim();
            
            if (Persona.buscarPersonaPorTelefono(telefono) != null) {
                System.out.println("\nYa existe una persona con ese TELEFONO. Registro cancelado.");
                telefono = null;
            }
        } while (telefono == null || !nuevoEmpleado.setTelefono(telefono));

        // Correo
        String correo;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Su correo electrónico? ");
            correo = sc.nextLine().trim();
            
            if (Persona.buscarPersonaPorCorreo(correo) != null) {
                System.out.println("\nYa existe una persona con ese CORREO. Registro cancelado.");
                correo = null;
            }
        } while (correo == null || !nuevoEmpleado.setCorreo(correo));

        // Direccion
        System.out.print(empAtiende.getNombre() + ": ¿Dirección? ");
        String direccion = sc.nextLine().trim();
        nuevoEmpleado.setDireccion(direccion);

        // Cargo
        System.out.println(empAtiende.getNombre() + ": Cargos disponibles: ");

        int opcionEmp;
        do { 
            System.out.println("1. Cajero");
            System.out.print("Seleccione una opcion: ");
            opcionEmp = Integer.parseInt(sc.nextLine().trim());
            switch (opcionEmp) {
                case 1 -> nuevoEmpleado.setCargo("Cajero");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcionEmp != 1);
        
        // Usuario
        String usuario;
        do {
            System.out.print(empAtiende.getNombre() + ": Ingrese un nombre de usuario: ");
            usuario = sc.nextLine().trim();
            if (Persona.buscarPersonaPorUsuario(usuario) != null) {
                System.out.println("Ese nombre de usuario ya está en uso. Intente otro.");
                usuario = null;
            }
        } while (usuario == null || usuario.isEmpty());
        nuevoEmpleado.setUsuario(usuario);

        // Contraseña
        String contrasena;
        do {
            System.out.print(empAtiende.getNombre() + ": Ingrese una contraseña: ");
            contrasena = sc.nextLine().trim();
            if (contrasena.length() < 4) {
                System.out.println("La contraseña debe tener al menos 4 caracteres.");
                contrasena = null;
            }
        } while (contrasena == null);
        nuevoEmpleado.setContrasena(contrasena);

        // Crear ID único para empleado
        String idEmpleado = banco.generarIdEmpleado();
        nuevoEmpleado.setIdEmpleado(idEmpleado);

        // Registrar ambos en el sistema
        banco.registrarEmpleado(nuevoEmpleado);
        Persona.getPersonasRegistradas().add(nuevoEmpleado);

        System.out.println("\nEmpleado registrado con éxito.");
        System.out.println("ID Emplado: " + idEmpleado);
        System.out.println("Cargo Empleado: " + nuevoEmpleado.getCargo());
    }

    public Persona iniciarSesion(String usuario, String contrasena) {
        for (Persona p : Persona.getPersonasRegistradas()) {
            if (p.getUsuario() != null && 
                p.getContrasena() != null &&
                p.getUsuario().equals(usuario) &&
                p.getContrasena().equals(contrasena)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarMenuCliente(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        do { 
            System.out.println("\n=== MENU DEL CLIENTE ===");
            System.out.println("Bienvenido, " + cliente.getNombre());
            System.out.println("1. Ver mis cuentas");
            System.out.println("2. Ingresar a una cuenta");
            System.out.println("3. Crear cuenta");
            System.out.println("4. Actualizar datos");
            System.out.println("5. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            String entrada = sc.nextLine();
            if (!Validador.esSoloNumeros(entrada)){
                System.out.println("Ingrese un NUMERO valido");
                continue;
            }
            opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    System.out.println("\n=== LISTA DE CUENTAS ===");
                    if (cliente.getCuentas().isEmpty()){
                        System.out.println("No tiene cuentas registradas");
                    } else {
                        for (Cuenta c : cliente.getCuentas()) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 2:
                    if (cliente.getCuentas().isEmpty()){
                        System.out.println("No tiene cuentas registradas");
                        break;
                    }
                    System.out.println("\n=== SELECCIONE UNA CUENTA ===");
                    for (int i = 0; i<cliente.getCuentas().size(); i++){
                        System.out.println((i + 1) + ". " + cliente.getCuentas().get(i).getNumeroCuenta());
                    }
                    System.out.print("Seleccione una cuenta: ");
                    String entradaCuenta = sc.nextLine().trim();

                    if (!Validador.esSoloNumeros(entradaCuenta)){
                        System.out.println("Ingrese un NUMERO valido");
                        break;
                    }

                    int indice = Integer.parseInt(entradaCuenta) - 1;
                    if (indice < 0 || indice >= cliente.getCuentas().size()){
                        System.out.println("Cuenta no valida.");
                        break;
                    }

                    Cuenta cuentaSeleccionada = cliente.getCuentas().get(indice);
                    mostrarMenuCuenta(cliente, cuentaSeleccionada);

                    break;
                case 3:
                    System.out.println("\n=== CREAR NUEVA CUENTA ===");
                    System.out.print("Ingrese tipo de cuenta (Ahorros / Corriente): ");
                    String tipoCuenta = sc.nextLine().trim().toUpperCase();

                    if (!tipoCuenta.equals("AHORROS") && !tipoCuenta.equals("CORRIENTE")){
                        System.out.println("Tipo de cuenta no valido o dato no valido");
                        break;
                    }

                    String numeroCuenta = generarNumeroCuenta();
                    Cuenta nuevaCuenta = new Cuenta(numeroCuenta, tipoCuenta, 0.0);

                    cliente.agregarCuenta(nuevaCuenta);
                    registrarCuenta(nuevaCuenta);

                    System.out.println("Cuenta creada exitosamente.");
                    System.out.println("Numero de cuenta: " + numeroCuenta);
                    System.out.println("Tipo: " + tipoCuenta);
                    break;
                case 4:
                    System.out.println("\n=== ACTUALIZAR DATOS ===");
                    System.out.print("Nuevo teléfono: ");
                    cliente.setTelefono(sc.nextLine().trim());
                    System.out.print("Nuevo correo: ");
                    cliente.setCorreo(sc.nextLine().trim());
                    System.out.println("Datos actualizados correctamente.");
                    break;
                case 5:
                    System.out.println("Cerrando sesion...");
                    return;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (true);
    }

    public void mostrarMenuCuenta(Cliente cliente, Cuenta cuenta) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do { 
            System.out.println("\n=== MENÚ DE CUENTA ===");
            System.out.println("Cuenta: " + cuenta.getNumeroCuenta() + " | Saldo: S/." + cuenta.getSaldo());
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Ver historial de transacciones");
            System.out.println("4. Regresar al menú del cliente");
            System.out.print("Seleccione una opcion: ");

            String entrada = sc.nextLine().trim();
            if (!Validador.esSoloNumeros(entrada)){
                System.out.println("Ingrese un NUMERO valido");
                continue;
            }

            opcion = Integer.parseInt(entrada);
            switch (opcion) {
                case 1 -> {
                    Main.mostrarEmpleados();
                    Empleado cajero1 = Main.elegirEmpleadoAtencion();
                    System.out.println("\nEl empleado/a " + cajero1.getNombre() + " lo atendera ahora.");

                    System.out.print("Ingrese monto a depositar: ");
                    String montoEntrada1 = sc.nextLine().trim();
                    if (!Validador.esMontoValido(montoEntrada1)) {
                        System.out.println("Ingrese un monto valido");
                        break;
                    }

                    double montoDep = Double.parseDouble(montoEntrada1);
                    Deposito deposito = operaciones.RegistrarDeposito(cliente, cuenta, cajero1, montoDep);

                    if (deposito != null) {
                        System.out.println("Deposito realizado correctamente.");
                    }
                }

                case 2 -> {
                    Main.mostrarEmpleados();
                    Empleado cajero2 = Main.elegirEmpleadoAtencion();
                    System.out.println("\nEl empleado/a " + cajero2.getNombre() + " lo atendera ahora.");

                    System.out.print("Ingrese monto a retirar: ");
                    String montoEntrada2 = sc.nextLine().trim();
                    if (!Validador.esMontoValido(montoEntrada2)) {
                        System.out.println("Ingrese un monto valido");
                        break;
                    }

                    double montoRet = Double.parseDouble(montoEntrada2);
                    Retiro retiro = operaciones.RegistrarRetiro(cliente, cuenta, cajero2, montoRet);

                    if (retiro != null) {
                        System.out.println("Retiro realizado correctamente.");
                    }
                }
                case 3 -> cuenta.imprimirHistorial();
                case 4 -> {
                    System.out.println("Regresando al menu de cliente...");
                    return;
                }
                default -> System.out.println("Opcion no valida");
            }
        } while (true);
    }

    public void mostrarMenuCajero(Empleado cajero){
        System.out.println("\n=== MENU DEL CAJERO ===");
        // Aqui iran las opciones para un cajero
    } 
   
    public void mostrarMenuAdministrador(Empleado cajero){
        System.out.println("\n=== MENU DEL ADMINISTRADOR ===");
        // Aqui iran las opciones para un administrador
    } 
}