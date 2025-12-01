
package Banco.clases;

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

    public Empleado() {super();}

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

    // CAMBIO: Registrar un nuevo cliente usando Scanner compartido
    public void registrarCliente(Empleado empAtiende) {
        // CAMBIO: usar Main.getScanner() en lugar de new Scanner(System.in)
        Scanner sc = Main.getScanner();
        SistemaBancario banco = Main.getBanco();

        System.out.println("\n=== REGISTRO DE NUEVO CLIENTE ===");

        Cliente nuevoCliente = new Cliente();

        // Nombre
        String nombre;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Cuál es su nombre? ");
            nombre = sc.nextLine().trim();

            // CAMBIO: validar que nombre solo contenga letras
            if (!Validador.esSoloLetrasNombre(nombre)) {
                System.out.println("Nombre inválido. Use solo letras, espacios, guiones o apóstrofes.");
                nombre = null;
                continue;
            }
        } while (nombre == null || !nuevoCliente.setNombre(nombre));

        // Apellido
        String apellido;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Y su apellido? ");
            apellido = sc.nextLine().trim();

            // CAMBIO: validar que apellido solo contenga letras
            if (!Validador.esSoloLetrasNombre(apellido)) {
                System.out.println("Apellido inválido. Use solo letras, espacios, guiones o apóstrofes.");
                apellido = null;
                continue;
            }
        } while (apellido == null || !nuevoCliente.setApellido(apellido));

        // DNI
        String dni;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Su DNI? ");
            dni = sc.nextLine().trim();

            // CAMBIO: validar que el DNI tenga exactamente 8 dígitos numéricos
            if (dni == null || !dni.matches("\\d{8}")) {
                System.out.println("DNI inválido. Debe contener exactamente 8 dígitos numéricos.");
                dni = null;
                continue;
            }

            if (Persona.buscarPersonaPorDni(dni) != null) {
                System.out.println("\nYa existe una persona con ese DNI. Registro cancelado.");
                dni = null;
            }
        } while (dni == null || !nuevoCliente.setDni(dni));

        // Telefono
        String telefono;
        do { 
            System.out.print(empAtiende.getNombre() + ": ¿Su teléfono? ");
            telefono = sc.nextLine().trim();

            // CAMBIO: normalizar quitando espacios y validar 9 dígitos
            String telefonoDigits = telefono.replaceAll("\\D", "");

            if (telefonoDigits == null || !telefonoDigits.matches("\\d{9}")) {
                System.out.println("Teléfono inválido. Debe contener exactamente 9 dígitos numéricos (puede incluir espacios o guiones).");
                telefono = null;
                continue;
            }
            
            if (Persona.buscarPersonaPorTelefono(telefonoDigits) != null) {
                System.out.println("\nYa existe una persona con ese TELEFONO. Registro cancelado.");
                telefono = null;
            } else {
                telefono = telefonoDigits;
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
        // CAMBIO: NO cerrar el Scanner aquí
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Empleado " + getNombre() + " sin menú definido.");
    }

    @Override
    public String toString() {
        return "Empleado{" + super.toString() + " | idEmpleado=" + idEmpleado + " | cargo=" + cargo + "}";
    }
}