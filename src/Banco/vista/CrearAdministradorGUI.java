
package Banco.vista;

import Banco.clases.*;
import javax.swing.JOptionPane;

public class CrearAdministradorGUI extends javax.swing.JFrame {

    SistemaBancario banco = Main.getBanco();
    public CrearAdministradorGUI() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        btnRegistrar.addActionListener(e -> crearAdministradorGUI());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitulo.setText("REGISTRAR ADMINISTRADOR");

        jLabel2.setText("Ingresar Nombre:");

        jLabel3.setText("Ingresar Apellido:");

        jLabel4.setText("Ingresar DNI:");

        jLabel5.setText("Ingresar Correo:");

        jLabel6.setText("Ingresar Telefono:");

        jLabel7.setText("Ingresar Direccion:");

        jLabel8.setText("Ingresar Usuario:");

        jLabel9.setText("Ingresar Contraseña:");

        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtDni)
                    .addComponent(txtCorreo)
                    .addComponent(txtTelefono)
                    .addComponent(txtDireccion)
                    .addComponent(txtUsuario)
                    .addComponent(txtContrasena))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaActionPerformed

    private void crearAdministradorGUI() {

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
        Administrador nuevo = new Administrador();

        nuevo.setNombre(nombre);
        nuevo.setApellido(apellido);
        nuevo.setDni(dni);
        nuevo.setCorreo(correo);
        nuevo.setTelefono(telefono);
        nuevo.setDireccion(direccion);
        nuevo.setUsuario(usuario);
        nuevo.setContrasena(contrasena);
        nuevo.setCargo("ADMINISTRADOR");

        String idGenerado = banco.generarIdEmpleado().replace("EMP", "ADM");
        nuevo.setIdEmpleado(idGenerado);

        // Registrar
        banco.registrarEmpleado(nuevo);
        Persona.getPersonasRegistradas().add(nuevo);

        JOptionPane.showMessageDialog(this,
                "Administrador registrado con éxito.\nID asignado: " + idGenerado);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbTitulo;
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
