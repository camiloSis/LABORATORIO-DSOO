package Banco.vista;

import javax.swing.*;
import Banco.clases.*;

public class RegistrarClienteGUI extends javax.swing.JFrame {
    
    SistemaBancario banco = Main.getBanco();
    public RegistrarClienteGUI() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        cargarEmpleados();
        cmbEmpleado.addActionListener(e -> actualizarLabelsEmpleado());
        btnRegistrar.addActionListener(e -> registrarClienteGUI());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        cmbEmpleado = new javax.swing.JComboBox<>();
        jlSelecEmp = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jlNombre = new javax.swing.JLabel();
        jlApellido = new javax.swing.JLabel();
        jlDni = new javax.swing.JLabel();
        jlTelefono = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jlDireccion = new javax.swing.JLabel();
        jlContraseña = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jlCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Cliente");

        jlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlTitulo.setText("REGISTRAR CLIENTE");

        txtNombre.setToolTipText("nombre");

        jlSelecEmp.setText("Seleccionar Empleado: ");

        jlNombre.setText("Nombre:");

        jlApellido.setText("Apellido:");

        jlDni.setText("DNI:");

        jlTelefono.setText("Telefono:");

        jlUsuario.setText("Usuario:");

        jlDireccion.setText("Direccion:");

        jlContraseña.setText("Contraseña:");

        btnRegistrar.setText("Registrar");

        jlCorreo.setText("Correo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlTitulo)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono)
                            .addComponent(txtDni)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlSelecEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellido)
                            .addComponent(txtCorreo)
                            .addComponent(txtDireccion)
                            .addComponent(txtUsuario)
                            .addComponent(txtContrasena)
                            .addComponent(jlTelefono)
                            .addComponent(jlCorreo)
                            .addComponent(jlDni)
                            .addComponent(jlApellido)
                            .addComponent(jlNombre)
                            .addComponent(jlContraseña)
                            .addComponent(jlUsuario)
                            .addComponent(jlDireccion))
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jlTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSelecEmp))
                .addGap(13, 13, 13)
                .addComponent(jlNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        setBounds(0, 0, 341, 622);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    private void registrarClienteGUI() {

        // Obtener banco y lista de personas

        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String dni = txtDni.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String usuario = txtUsuario.getText().trim();
        String contrasena = txtContrasena.getText().trim();

        // VALIDACIONES
        if (!Validador.esSoloLetrasNombre(nombre)) {
            JOptionPane.showMessageDialog(this, "Nombre inválido.");
            return;
        }
        if (!Validador.esSoloLetrasNombre(apellido)) {
            JOptionPane.showMessageDialog(this, "Apellido inválido.");
            return;
        }
        if (!Validador.esDniValido(dni) || Persona.buscarPersonaPorDni(dni) != null) {
            JOptionPane.showMessageDialog(this, "DNI inválido o ya registrado.");
            return;
        }
        if (!Validador.esCorreoValido(correo) || Persona.buscarPersonaPorCorreo(correo) != null) {
            JOptionPane.showMessageDialog(this, "Correo inválido o ya registrado.");
            return;
        }
        if (!Validador.esTelefonoValido(telefono) || Persona.buscarPersonaPorTelefono(telefono) != null) {
            JOptionPane.showMessageDialog(this, "Teléfono inválido o ya registrado.");
            return;
        }
        if (usuario.isEmpty() || Persona.buscarPersonaPorUsuario(usuario) != null) {
            JOptionPane.showMessageDialog(this, "Usuario vacío o ya en uso.");
            return;
        }
        if (contrasena.length() < 4) {
            JOptionPane.showMessageDialog(this, "Contraseña debe tener al menos 4 caracteres.");
            return;
        }

        // CREAR OBJETO CLIENTE
        Cliente nuevo = new Cliente();

        nuevo.setNombre(nombre);
        nuevo.setApellido(apellido);
        nuevo.setDni(dni);
        nuevo.setCorreo(correo);
        nuevo.setTelefono(telefono);
        nuevo.setDireccion(direccion);
        nuevo.setUsuario(usuario);
        nuevo.setContrasena(contrasena);

        String idGenerado = banco.generarIdCliente();
        nuevo.setIdCliente(idGenerado);

        // Registrar
        banco.registrarCliente(nuevo);
        Persona.getPersonasRegistradas().add(nuevo);

        JOptionPane.showMessageDialog(this,
                "Cliente registrado con éxito.\nID asignado: " + idGenerado);

        // LIMPIAR CAMPOS
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
    }

    private void cargarEmpleados() {
        DefaultComboBoxModel<Empleado> modelo = new DefaultComboBoxModel<>();

        for (Empleado emp : banco.listarEmpleados()) {
            modelo.addElement(emp);
        }

        cmbEmpleado.setModel(modelo);

        cmbEmpleado.setRenderer(new DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Empleado emp) {
                    setText(emp.getNombre()); // solo muestra el nombre
                }
                return this;
            }
        });
        actualizarLabelsEmpleado();
    }

    private void actualizarLabelsEmpleado() {
        Empleado emp = (Empleado) cmbEmpleado.getSelectedItem();
        if (emp != null) {
            String nombreEmpleado = emp.getNombre(); // solo el nombre
            jlNombre.setText(nombreEmpleado + ": ¿Cuál es su nombre?");
            jlApellido.setText(nombreEmpleado + ": ¿Cuál es su apellido?");
            jlDni.setText(nombreEmpleado + ": ¿Cuál es su DNI?");
            jlTelefono.setText(nombreEmpleado + ": ¿Cuál es su teléfono?");
            jlCorreo.setText(nombreEmpleado + ": ¿Cuál es su correo?");
            jlDireccion.setText(nombreEmpleado + ": ¿Cuál es su dirección?");
            jlUsuario.setText(nombreEmpleado + ": ¿Cuál es su usuario?");
            jlContraseña.setText(nombreEmpleado + ": ¿Cuál es su contraseña?");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<Empleado> cmbEmpleado;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlContraseña;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlDireccion;
    private javax.swing.JLabel jlDni;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSelecEmp;
    private javax.swing.JLabel jlTelefono;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
