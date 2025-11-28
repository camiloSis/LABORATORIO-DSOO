
public class ServicioAlCliente {
    private String idAtencion;
    private String fecha; // CAMBIO: mantengo String por compatibilidad con el curso
    private Cliente cliente;
    private Empleado empleado;
    private String motivo;
    private String notas; // CAMBIO: uso String (métodos convencionales)

    public ServicioAlCliente(String idAtencion, String fecha, Cliente cliente,
                             Empleado empleado, String motivo) {
        this.idAtencion = idAtencion;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.motivo = motivo;
        this.notas = "";
    }

    // CAMBIO: validar entrada y evitar notas vacías; separar notas existentes con " | "
    public void agregarNota(String nota) {
        if (nota == null) return;
        String t = nota.trim();
        if (t.isEmpty()) return;
        if (!this.notas.isEmpty()) {
            this.notas += " | ";
        }
        this.notas += t;
    }

    // Getters y setters convencionales (CAMBIO: añadidos)
    public String getIdAtencion() { return idAtencion; }
    public void setIdAtencion(String idAtencion) { this.idAtencion = idAtencion; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) {
        this.notas = (notas == null) ? "" : notas.trim();
    }

    @Override
    public String toString() {
        // CAMBIO: proteger contra posibles NPE en cliente/empleado
        String nombreCliente = (cliente != null && cliente.getNombre() != null) ? cliente.getNombre() : "N/A";
        String nombreEmpleado = (empleado != null && empleado.getNombre() != null) ? empleado.getNombre() : "N/A";
        return "Servicio{" +
                "idAtencion=" + idAtencion +
                ", fecha=" + fecha +
                ", cliente=" + nombreCliente +
                ", empleado=" + nombreEmpleado +
                ", motivo=" + (motivo != null ? motivo : "N/A") +
                ", notas=" + (notas != null ? notas : "") +
                "}";
    }
}
