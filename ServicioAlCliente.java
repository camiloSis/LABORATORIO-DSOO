
public class ServicioAlCliente {
    private String idAtencion;
    private String fecha;
    private Cliente cliente;
    private Empleado empleado;
    private String motivo;
    private String notas;

    public ServicioAlCliente(String idAtencion, String fecha, Cliente cliente, 
                           Empleado empleado, String motivo) {
        this.idAtencion = idAtencion;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.motivo = motivo;
        this.notas = ""; 
    }

    public void agregarNota(String nota) {

    }

    @Override
    public String toString() {
        return "ServicioAlCliente{" +
                "idAtencion='" + idAtencion + '\'' +
                ", fecha=" + fecha +
                ", cliente=" + cliente.getNombre() +
                ", empleado=" + empleado.getNombre() +
                ", motivo='" + motivo + '\'' +
                ", notas='" + notas + '\'' +
                '}';
    }
}