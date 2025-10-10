import java.util.ArrayList;

public class avance{

    public static void main(String[] args) {

    
    }

    static class Libro{  
        private String titulo;
        private String autor;
        private String isbn;
        private boolean disponible;

//sobre carga de constructores

        public Libro(String titulo, String autor, String isbn, boolean disponible) //constructor
        {
            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
            this.disponible = disponible;
        }

        public Libro() { //constructor por defecto
            this.titulo = " ";
            this.autor = " ";
            this.isbn = " ";
            this.disponible = true;
        }

        //metodos accesores

        public String getTitulo() { return titulo; }
        public String getAutor() { return autor; }
        public String getIsbn() { return isbn; }
        public boolean getDisponible() { return disponible; }

        //metodos mutadores

        public void setTitulo(String titulo) {this.titulo = titulo; }
        public void setAutor(String autor) {this.autor = autor; }
        public void setIsbn(String isbn) {this.isbn = isbn; }
        public void setDisponible(boolean disponible) {this.disponible = disponible; }
        //metodo ToString

        @Override
        public String toString() {
            return "Libro{" +"titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", disponible=" + disponible +
                    '}';

        // ...

        }

        static class Usuario{

            private String idUsuario;
            private String nombre;
            private ArrayList<Libro> librosPrestados;

        
// sobrecarga de constructores

        public Usuario(String idUsuario, String nombre, ArrayList<Libro> librosPrestados) { //constructor
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.librosPrestados = librosPrestados;
        }

        public Usuario () {
            this.idUsuario = " ";
            this.nombre = " ";
            this.librosPrestados = new ArrayList<>();
        } 

        //metodos accesores

        public String getIdUsuario() { return idUsuario; }
        public String getNombre() { return nombre; }
        public ArrayList<Libro> getLibrosPrestados() {return librosPrestados; }

        //metodos mutadores

        public void setIdUsuario(String idUsuario) {this.idUsuario = idUsuario; }
        public void setNombre(String nombre) { this.nombre = nombre;}
        public void setLIBROSpRESTADOS (ArrayList<Libro> librosPrestados) {this.librosPrestados = librosPrestados; }

        //metodo ToString
        @Override 
        public String toString(){
            return "Usuario{" + "idUsuario='" + idUsuario + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", librosPrestados=" + librosPrestados +
                    '}';
        }

        // ...

        static class Prestamo{

            private String idUsuario;
            private String isbn;
            private String fechaPrestamo;
            private boolean prestamoActivo;

// sobrecarga de constructores

            public Prestamo (String idUsuario, String isbn, String fechaPrestamo, boolean prestamoActivo){ //constructor
                this.idUsuario = idUsuario;
                this.isbn = isbn;
                this.fechaPrestamo = fechaPrestamo;
                this.prestamoActivo = prestamoActivo;
            }

            public Prestamo () { 
                this.idUsuario = " ";
                this.isbn = " ";
                this.fechaPrestamo = " ";
                this.prestamoActivo = true;
            }

            //metodos accesores

            public String getIdUsuario() {return idUsuario; }
            public String getIsbn() { return isbn; }
            public String getFechaPrestamo() { return fechaPrestamo; }
            public boolean getPrestamoActivo() {return prestamoActivo; }
            //metodos mutadores
            public void setIdUsuario (String idUsuario) {this.idUsuario = idUsuario; }
            public void setIsbn (String isbn) {this.isbn = isbn; }
            public void setFechaPrestamo (String fechaPrestamo) {this.fechaPrestamo = fechaPrestamo; }
            public void setPrestamoActivo (boolean prestamoActivo) {this.prestamoActivo = prestamoActivo; }

            //metodo ToString
            @Override
            public String toString() {
                return "Prestamo{" + "idUsuario='" + idUsuario + '\'' +
                        ", isbn='" + isbn + '\'' +
                        ", fechaPrestamo='" + fechaPrestamo + '\'' +
                        ", prestamoActivo=" + prestamoActivo +
                        '}';
            }

            // ... 

        }

        static class Sistema{

            private ArrayList<Libro> listaLibros;
            private ArrayList<Usuario> listaUsuarios;
            private ArrayList<Prestamo> listaPrestamos;

// sobrecarga de constructores

        public Sistema(ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuarios, ArrayList<Prestamo> listaPrestamos){ //constructor
            this.listaLibros = listaLibros;
            this.listaUsuarios = listaUsuarios;
            this.listaPrestamos = listaPrestamos;
        }
        public Sistema() {
            this.listaLibros = new ArrayList<>();
            this.listaUsuarios = new ArrayList<>();
            this.listaPrestamos = new ArrayList<>();
        }

        //metodos accesores

        public ArrayList<Libro> getListaLibros() { return listaLibros; }
        public ArrayList<Usuario> getListaUsuarios() { return listaUsuarios; }
        public ArrayList<Prestamo> getListaPrestamos() { return listaPrestamos;}
        
        //metodos mutadores

        public void setListaLibros (ArrayList<Libro> listaLibros) { this.listaLibros = listaLibros; }
        public void setListaUsuarios (ArrayList<Usuario> listaUsuarios) { this.listaUsuarios = listaUsuarios; }
        public void setListaPrestamos (ArrayList<Prestamo> listaPrestamos) { this.listaPrestamos = listaPrestamos; }

        //metodo ToString

        @Override
        public String toString() {  
            return "Sistema{" + "listaLibros=" + listaLibros +
                    ", listaUsuarios=" + listaUsuarios +
                    ", listaPrestamos=" + listaPrestamos +
                    '}';
        }   

        // metodos del sistema
        /* 
- Crear clase Usuario con métodos para tomar prestado un libro, devolverlo y verificar disponibilidad.
- Implementar todos los métodos necesarios.
- Validar que un libro no pueda ser prestado si no está disponible.
- Registrar y mostrar usuarios y libros utilizando ArrayList.
         */

         public Libro buscarLibro(String isbn){
            for (Libro busqueda: listaLibros){
                if (busqueda.getIsbn().equals(isbn))
                return busqueda; //si encuentra el libro lo retorna
            }
            return null; //si el "if" no se cumple, entonces retorna null
        }

        public Usuario buscarUsuario (String idUsuario){
            for (Usuario busqueda: listaUsuarios){
                if(busqueda.getIdUsuario().equals(idUsuario)){
                    return busqueda;
                }
            }
            return null;
        }

        public void agregarLibro (Libro libro){
            listaLibros.add(libro);
        }

        public void agregarUsuario (Usuario usuario){
            listaUsuarios.add(usuario);
        }

//Como se requiere agilizar la prueba, crearemos un metodo de inicializacion 

        public void inicializarDatos(){
            
            Libro libro1 = new Libro("Interestellar", "Crhistopher Nolan", "1234567890", true);
            Libro libro2 = new Libro("To Kill a Mockingbird", "Harper Lee", "0987654321", true);
            agregarLibro(libro1);
            agregarLibro(libro2);

            
            Usuario usuario1 = new Usuario("U001", "Camilo", new ArrayList<>());
            Usuario usuario2 = new Usuario("U002", "Bladimir", new ArrayList<>());
            agregarUsuario(usuario1);
            agregarUsuario(usuario2);

            
            Prestamo prestamo1 = new Prestamo("U001", "1234567890", "2023-10-01", true);
            listaPrestamos.add(prestamo1);

            Prestamo prestamo2 = new Prestamo( "U002", "0987654321", "2023-10-02", true);
            listaPrestamos.add(prestamo2);
        }
        
        public void mostrarLibros(){
            for (Libro elemento: listaLibros){
                System.out.println(elemento.toString()); //llamamos al metodo toString para que muestre el objeto elemento en la forma de texto que lo definimos en el metodo toString
            }
        }

        public void mostrarUsuarios(){
            for (Usuario elemento: listaUsuarios){
                System.out.println(elemento.toString());
            }   
        }

// metodos que hacen interactuar a las 3 clases

        public boolean verificarDisponibilidad (String isbn){
            Libro libro = buscarLibro(isbn); //primero busca el libro, si lo encuentra devuelve el objeto libro
            if (libro != null){
                return libro.getDisponible(); // devuelve true o false dependiendo si el libro esta disponible o no
            }
            return false; // si el "if" nunca se cumple, o sea, libro = "vacio", entonces retorna falso, lo que significa que no esta disponible porque no esta en el sistema
            //lo que implicitamente tambien dice que no se puede prestar
        }

        public boolean prestarLibro (String idUsuario, String isbn){
            if(verificarDisponibilidad(isbn)){
                //validacion 
                Usuario usuario = buscarUsuario(idUsuario);
                Libro libro = buscarLibro(isbn);
                if(usuario != null && libro != null){
                    libro.setDisponible(false); //cambio el estado de ese libro a no disponile
                    usuario.getLibrosPrestados().add(libro); // añade ese libro a la lista de libros prestados de ese usuario
                    Prestamo prestamo = new Prestamo (idUsuario, isbn, "10 de octubre del 2025", true); //creamos el objeto prestamo y ahora lo añadimo a la lista de prestamos ->
                    listaPrestamos.add(prestamo);
                    return true;
                }
            }
            return false; //si no se cumple el "if" inicial, entonces retorna falso, o sea, no se puede prestar
        }

        public boolean devolverLibro (String idUsuario, String isbn){
            //validacion
            Usuario usuario = buscarUsuario(idUsuario);
            Libro libro = buscarLibro(isbn);
            if (usuario != null && libro != null){
                if(usuario.getLibrosPrestados().contains(libro)){
                    libro.setDisponible(true);
                    usuario.getLibrosPrestados().remove(libro);
                    return true;
                }
            }
            return false; //si no se cumple el "if" inicial, entonces retorna falso, o sea, no se puede devolver
        }

        public void mostrarPrestamosActivos(){
            for (Prestamo mostrar: listaPrestamos){
                if (mostrar.getPrestamoActivo()){ // verifica si el prestamo esta activo, si lo está entonces lo muestra
                    System.out.println(mostrar.toString()); 
                }
            }

        }

    }

    }







    }
}