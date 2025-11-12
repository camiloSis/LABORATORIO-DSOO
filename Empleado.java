import java.util.Scanner;

class Empleado extends Persona {
    private String idEmpleado;
    private String cargo;

    public Empleado(String nombre, String apellido, String dni, String telefono, String correo, String direccion,
                    String idEmpleado, String cargo, String usuario, String contrasena) {
        super(nombre, apellido, dni, telefono, correo, direccion, usuario, contrasena);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo.toUpperCase();
    }

    public Empleado() {}

    public String getIdEmpleado() { return idEmpleado; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setIdEmpleado(String idEmpleado) { this.idEmpleado = idEmpleado; }

    public Transaccion depositar(Cliente cliente, Cuenta cuenta, double monto) {
        return cuenta.depositar(monto, this, cliente);
    }

    public Transaccion retirar(Cliente cliente, Cuenta cuenta, double monto) {
        return cuenta.retirar(monto, this, cliente);
    }

        // Registrar un nuevo cliente
    public void registrarCliente(Empleado empAtiende) {
        Scanner sc = new Scanner(System.in);
        SistemaBancario banco = Main.getBanco();

        System.out.println("\n=== REGISTRO DE NUEVO CLIENTE ===");

        Cliente nuevoCliente = new Cliente();

        // Nombre
        String nombre;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Cuál es su nombre? ");
            nombre = sc.nextLine().trim().toUpperCase();
        } while (!nuevoCliente.setNombre(nombre));

        // Apellido
        String apellido;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Y su apellido? ");
            apellido = sc.nextLine().trim().toUpperCase();
        } while (!nuevoCliente.setApellido(apellido));

        // DNI
        String dni;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Su DNI? ");
            dni = sc.nextLine().trim();

            if (Persona.buscarPersonaPorDni(dni) != null) {
                System.out.println("\nYa existe una persona con ese DNI. Registro cancelado.");
                dni = null;
            }
        } while (dni == null || !nuevoCliente.setDni(dni));

        // Telefono
        String telefono;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Su teléfono (9 dígitos)? ");
            telefono = sc.nextLine().trim();
            
            if (Persona.buscarPersonaPorTelefono(telefono) != null) {
                System.out.println("\nYa existe una persona con ese TELEFONO. Registro cancelado.");
                telefono = null;
            }
        } while (telefono == null || !nuevoCliente.setTelefono(telefono));

        // Correo
        String correo;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Su correo electrónico? ");
            correo = sc.nextLine().trim();
            
            if (Persona.buscarPersonaPorCorreo(correo) != null) {
                System.out.println("\nYa existe una persona con ese CORREO. Registro cancelado.");
                correo = null;
            }
        } while (correo == null || !nuevoCliente.setCorreo(correo));

        // Direccion
        System.out.print(empAtiende.getNombre() + ": ¿Dirección? ");
        String direccion = sc.nextLine().trim();
        nuevoCliente.setDireccion(direccion);

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
        nuevoCliente.setUsuario(usuario);

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
        nuevoCliente.setContrasena(contrasena);

        // Crear ID único para cliente
        String idCliente = banco.generarIdCliente();
        nuevoCliente.setIdCliente(idCliente);

        // Registrar ambos en el sistema
        banco.registrarCliente(nuevoCliente);
        Persona.getPersonasRegistradas().add(nuevoCliente);

        System.out.println("\nCliente registrado con éxito.");
        System.out.println("ID Cliente: " + idCliente);
    }

    @Override
    public void mostrarMenu() {
        SistemaBancario banco = Main.getBanco();

        if (cargo.equalsIgnoreCase("CAJERO")) {
            banco.mostrarMenuCajero(this);
        } else if (cargo.equalsIgnoreCase("ADMINISTRADOR")) {
            banco.mostrarMenuAdministrador(this);
        } else {
            System.out.println("Rol desconocido para el empleado: " + cargo);
        }
    }

    @Override
    public String toString() {
        return "Empleado{" + super.toString() + " | idEmpleado=" + idEmpleado + " | cargo=" + cargo + "}";
    }
}