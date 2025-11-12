 
// Clase auxiliar para validacion de datos
class Validador {
    // Verifica que el String contenga solo letras
    public static boolean esSoloLetras(String s) {
        return s.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"); // True
    }

    // Verifica que el String contenga solo numeros
    public static boolean esSoloNumeros(String s) {
        return s.matches("\\d+"); // True
    }

    // Verifica que el String cumpla con un correo ( ejemplo@gmail.com )
    // @ y dominio obligatorios
    public static boolean esCorreoValido(String s) {
        return s.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$"); // True
    }

    // Verifica que el DNI tenga 8 digitos exactamente
    public static boolean esDniValido(String dni) {
        return dni.matches("\\d{8}"); // True
    }

    // Verifica que el Telefono tenga 9 digitos y empiece con 9
    public static boolean esTelefonoValido(String telefono) {
        return telefono.matches("9\\d{8}"); // True
    }

    // Verifica que el monto sea valido
    public static boolean esMontoValido(String monto) {
        return monto.matches("^[0-9]+(\\.[0-9]{1,2})?$");
    }
}
