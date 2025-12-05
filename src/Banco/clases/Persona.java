
package Banco.clases;

import java.util.ArrayList;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String telefono;
    protected String correo;
    protected String direccion;
    protected String usuario;
    protected String contrasena;

    private static ArrayList<Persona> personasRegistradas = new ArrayList<>(); 

    public static ArrayList<Persona> getPersonasRegistradas() { return personasRegistradas; }

    public Persona(String nombre, String apellido, String dni, String telefono, 
                    String correo, String direccion, String usuario, String contrasena) {
        this.nombre = nombre.toUpperCase();
        this.apellido = apellido.toUpperCase();
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasena = contrasena;

        personasRegistradas.add(this);
    }

    public Persona() {}

    // Metodos de busqueda ( para evitar dobles )
    public static Persona buscarPersonaPorDni (String dni) {
        if (dni == null) return null;
        for (Persona p : personasRegistradas) {
            if (p.getDni().equals(dni)) return p;
        }
        return null;
    }

    public static Persona buscarPersonaPorTelefono (String telefono) {
        for (Persona p : personasRegistradas) {
            if (p.getTelefono().equals(telefono)) return p;
        }
        return null;
    }

    public static Persona buscarPersonaPorCorreo (String correo) {
        for (Persona p : personasRegistradas) {
            if (p.getCorreo().equals(correo)) return p;
        }   
        return null;
    }

    public static Persona buscarPersonaPorUsuario(String usuario) {
        for (Persona p : personasRegistradas) {
            if (p.getUsuario() != null && p.getUsuario().equals(usuario)) return p;
        }
        return null;
    }

    // Setters con validacion
        // Nombre
    public boolean setNombre(String nombre) {
        if (nombre == null) return false;
        nombre = nombre.trim();
        if (!Validador.esSoloLetrasNombre(nombre)) return false;
        this.nombre = nombre.toUpperCase();
        return true;
    }

    public boolean setApellido(String apellido) {
        if (apellido == null) return false;
        apellido = apellido.trim();
        if (!Validador.esSoloLetrasNombre(apellido)) return false;
        this.apellido = apellido.toUpperCase();
        return true;
    }
        // DNI
    public boolean setDni(String dni) {
        if (!Validador.esDniValido(dni)) return false;

        Persona existente = Persona.buscarPersonaPorDni(dni);
        if (existente != null) return false;

        this.dni = dni;
        return true;
    }
        // Telefono
    public boolean setTelefono(String telefono) {
        if (!Validador.esTelefonoValido(telefono)) return false;

        Persona existente = Persona.buscarPersonaPorTelefono(telefono);
        if (existente != null && existente != this) return false;

        this.telefono = telefono;
        return true;
    }
        // Correo
    public boolean setCorreo(String correo) {
        if (!Validador.esCorreoValido(correo)) return false;

        Persona existente = Persona.buscarPersonaPorCorreo(correo);
        if (existente != null && existente != this) return false;

        this.correo = correo;
        return true;
    }
    
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; } 
 
    public String getUsuario () { return usuario; }
    public String getContrasena () { return contrasena; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDni() { return dni; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
    
    public abstract void mostrarMenu();
    public abstract void mostrarMenuGUI();;

    @Override
    public String toString() {
        return nombre + " " + apellido + " | dni: " + dni;
    }
}
