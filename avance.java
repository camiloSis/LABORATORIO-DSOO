public class avance{
    public static void main (Strings [] args){
// Clase Libro - Implementación básica
class Libro {
    // Atributos privados (encapsulamiento)
    private String titulo;
    private String autor;
    private String ISBN;
    private boolean disponible;
    
    // Constructor sin parámetros
    public Libro() {
        this.titulo = "Sin título";
        this.autor = "Desconocido";
        this.ISBN = "000-0-0000-0000-0";
        this.disponible = true;
    }
    
    // Constructor con todos los parámetros (sobrecarga)
    public Libro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.disponible = true; // Por defecto está disponible
    }
    
    // Constructor con disponibilidad personalizada (sobrecarga)
    public Libro(String titulo, String autor, String ISBN, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.disponible = disponible;
    }
    
    // Getters (Accessors)
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    // Setters (Mutators)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    // Método booleano específico
    public boolean estaDisponible() {
        return this.disponible;
    }
    
    // Método toString sobrescrito
    @Override
    public String toString() {
        return "Libro [Título: " + titulo + 
               ", Autor: " + autor + 
               ", ISBN: " + ISBN + 
               ", Disponible: " + (disponible ? "Sí" : "No") + "]";
    }
}

// ESQUELETO BÁSICO de la clase Usuario (para que lo completes)
class Usuario {
    private String nombre;
    private String id;
    // TODO: Agregar ArrayList para libros prestados
    
    // Constructor
    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        // TODO: Inicializar ArrayList
    }
    
    // Método para tomar prestado un libro
    public boolean tomarPrestado(Libro libro) {
        // TODO: Implementar validación
        // 1. Verificar si el libro está disponible usando estaDisponible()
        // 2. Si está disponible, cambiar su estado con setDisponible(false)
        // 3. Agregar el libro a la lista de prestados del usuario
        // 4. Retornar true si fue exitoso, false si no
        return false; // Placeholder
    }
    
    // TODO: Implementar método devolverLibro
    // TODO: Implementar getters y setters
    // TODO: Implementar toString
}

// Clase principal para pruebas
public class SistemaBiblioteca {
    public static void main(String[] args) {
        // Crear algunos libros de prueba
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0-307-47472-3");
        Libro libro2 = new Libro("1984", "George Orwell", "978-0-452-28423-4");
        Libro libro3 = new Libro(); // Constructor sin parámetros
        
        // Probar métodos
        System.out.println(libro1);
        System.out.println("¿Libro1 disponible? " + libro1.estaDisponible());
        
        // TODO: Crear usuarios
        // TODO: Crear ArrayList para gestionar múltiples libros y usuarios
        // TODO: Probar préstamos y devoluciones
    }
}

/*
 * TAREAS PENDIENTES PARA COMPLETAR:
 * 
 * 1. Completar la clase Usuario con:
 *    - ArrayList<Libro> librosPrestados
 *    - Método tomarPrestado() completo con validaciones
 *    - Método devolverLibro()
 *    - Getters, setters y toString
 * 
 * 2. En la clase principal:
 *    - Crear ArrayList<Libro> para gestionar biblioteca
 *    - Crear ArrayList<Usuario> para gestionar usuarios
 *    - Inicializar datos de prueba (varios libros y usuarios)
 *    - Implementar menú o casos de prueba para demostrar funcionalidad
 * 
 * 3. Validaciones importantes:
 *    - No permitir prestar un libro no disponible
 *    - Verificar que el usuario tiene el libro antes de devolverlo
 * 
 * 4. Mejoras opcionales:
 *    - Límite de libros por usuario
 *    - Fecha de préstamo/devolución
 *    - Búsqueda de libros por título o autor
 */




    }
}