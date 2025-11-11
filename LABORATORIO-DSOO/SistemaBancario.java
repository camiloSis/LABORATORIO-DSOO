import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class SistemaBancario {
    private Map<String, Cuenta> mapaCuentas;
    private Map<String, Cliente> mapaClientes;
    private Map<String, Empleado> mapaEmpleados;
    private String nombreBanco;

    public SistemaBancario(String nombreBanco) {
        this.nombreBanco = nombreBanco;
        this.mapaCuentas = new HashMap<>();
        this.mapaClientes = new HashMap<>();
        this.mapaEmpleados = new HashMap<>();

        //empleados iniciales
        Empleado cajeroPrincipal = new Empleado("Luis", "Gómez", "111", "555-3", "luis@mail.com", "Av. Libertad 123", "E001", "Cajero");
        Empleado gerenteSucursal = new Empleado("Ana", "Martínez", "222", "555-4", "ana@mail.com", "Calle Central 45", "E002", "Gerente");
        registrarEmpleado(cajeroPrincipal);
        registrarEmpleado(gerenteSucursal);

        //clientes iniciales
        Cliente clienteJuan = new Cliente("Dina", "Boluarte", "123", "555-1", "juan@mail.com", "Av. Perú 100", "C001", new ArrayList<>());
        Cliente clienteMaria = new Cliente("Jose", "Jeri", "456", "555-2", "maria@mail.com", "Calle Lima 200", "C002", new ArrayList<>());
        Cliente clienteCarlos = new Cliente("Pedro", "Castillo", "789", "555-5", "carlos@mail.com", "Calle Norte 300", "C003", new ArrayList<>());
        registrarCliente(clienteJuan);
        registrarCliente(clienteMaria);
        registrarCliente(clienteCarlos);

        //cuentas iniciales
        Cuenta cuentaAhorrosJuan = new Cuenta("AC001", "Ahorros", 1500);
        Cuenta cuentaCorrienteMaria = new Cuenta("AC002", "Corriente", 800);
        Cuenta cuentaAhorrosCarlos = new Cuenta("AC003", "Ahorros", 3000);

        //asignar cuentas a los clientes
        clienteJuan.agregarCuenta(cuentaAhorrosJuan);
        clienteMaria.agregarCuenta(cuentaCorrienteMaria);
        clienteCarlos.agregarCuenta(cuentaAhorrosCarlos);

        //establecer titulares
        cuentaAhorrosJuan.agregarTitular(clienteJuan);
        cuentaCorrienteMaria.agregarTitular(clienteMaria);
        cuentaAhorrosCarlos.agregarTitular(clienteCarlos);

        //registrar cuentas en el banco
        registrarCuenta(cuentaAhorrosJuan);
        registrarCuenta(cuentaCorrienteMaria);
        registrarCuenta(cuentaAhorrosCarlos);

    }

    public void registrarCliente(Cliente cliente) { 
        if (cliente != null) 
            mapaClientes.put(cliente.getDni(), cliente); 
    }

    public void registrarEmpleado(Empleado empleado) { 
        if (empleado != null) 
            mapaEmpleados.put(empleado.getIdEmpleado(), empleado); 
    }

    public void registrarCuenta(Cuenta cuenta) { 
        if (cuenta != null) 
            mapaCuentas.put(cuenta.getNumeroCuenta(), cuenta); 
    }

    public Cliente buscarCliente(String dniCliente) { 
        return mapaClientes.getOrDefault(dniCliente, null); 
    }

    public Empleado buscarEmpleado(String idEmpleado) { 
        return mapaEmpleados.getOrDefault(idEmpleado, null); 
    }

    public Cuenta buscarCuenta(String numeroCuenta) { 
        return mapaCuentas.getOrDefault(numeroCuenta, null); 
    }

    public List<Cliente> listarClientes() { 
        return new ArrayList<>(mapaClientes.values()); 
    }

    public List<Empleado> listarEmpleados() { 
        return new ArrayList<>(mapaEmpleados.values()); 
    }

    public List<Cuenta> listarCuentas() { 
        return new ArrayList<>(mapaCuentas.values()); 
    }

    public double calcularTotalFondos() {
        double totalFondos = 0;
        for (Cuenta cuenta : mapaCuentas.values()) {
            totalFondos += cuenta.getSaldo();
        }
        return totalFondos;
    }
}
