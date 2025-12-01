
package Banco.clases;

class Operaciones {
    // Constructor simplificado
    public Operaciones() {
        // Constructor vacío
    }

    // CAMBIO: Agregar validaciones básicas y convencionales
    public Deposito RegistrarDeposito(Cliente cliente, Cuenta cuenta, Empleado empleado, double monto) {
        // Validación de parámetros nulos
        if (cliente == null) {
            System.out.println("Error: Cliente es nulo");
            return null;
        }
        if (cuenta == null) {
            System.out.println("Error: Cuenta es nula");
            return null;
        }
        if (empleado == null) {
            System.out.println("Error: Empleado es nulo");
            return null;
        }

        // CAMBIO: Validación de monto (debe ser mayor a 0)
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser mayor a 0");
            return null;
        }

        // CAMBIO: Usar Validador si existe para validar formato
        if (!Validador.esMontoValido(String.valueOf(monto))) {
            System.out.println("Error: Monto inválido");
            return null;
        }

        // Invocar el método en cuenta y obtener el Deposito
        Deposito deposito = (Deposito) cuenta.depositar(monto, empleado, cliente);

        // CAMBIO: Validar que el depósito se registró correctamente
        if (deposito == null) {
            System.out.println("Error: No se pudo registrar el depósito");
            return null;
        }

        return deposito;
    }

    // CAMBIO: Agregar validaciones básicas y convencionales
    public Retiro RegistrarRetiro(Cliente cliente, Cuenta cuenta, Empleado empleado, double monto) {
        // Validación de parámetros nulos
        if (cliente == null) {
            System.out.println("Error: Cliente es nulo");
            return null;
        }
        if (cuenta == null) {
            System.out.println("Error: Cuenta es nula");
            return null;
        }
        if (empleado == null) {
            System.out.println("Error: Empleado es nulo");
            return null;
        }

        // CAMBIO: Validación de monto (debe ser mayor a 0)
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser mayor a 0");
            return null;
        }

        // CAMBIO: Usar Validador si existe para validar formato
        if (!Validador.esMontoValido(String.valueOf(monto))) {
            System.out.println("Error: Monto inválido");
            return null;
        }

        // CAMBIO: Validar que haya saldo suficiente
        if (cuenta.getSaldo() < monto) {
            System.out.println("Error: Saldo insuficiente. Saldo actual: S/. " + cuenta.getSaldo());
            return null;
        }

        // Invocar el método en cuenta y obtener el Retiro
        Retiro retiro = (Retiro) cuenta.retirar(monto, empleado, cliente);

        // CAMBIO: Validar que el retiro se registró correctamente
        if (retiro == null) {
            System.out.println("Error: No se pudo registrar el retiro");
            return null;
        }

        return retiro;
    }
}