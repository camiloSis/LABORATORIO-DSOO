
package Banco.vista;
import Banco.clases.*;
import javax.swing.*;

public class ActualizarDatosGUI extends javax.swing.JFrame {

    SistemaBancario banco = Main.getBanco();
    private Cliente cliente;
    public ActualizarDatosGUI(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnTelefono = new javax.swing.JButton();
        btnCorreo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ACTUALIZAR DATOS");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnTelefono.setText("Nuevo Telefono");
        btnTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelefonoActionPerformed(evt);
            }
        });

        btnCorreo.setText("Nuevo Correo");
        btnCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(btnCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelefonoActionPerformed
        // Pedir nuevo teléfono
        String nuevoTelefono = JOptionPane.showInputDialog(
                this,
                "Ingrese nuevo teléfono:",
                "Actualizar Teléfono",
                JOptionPane.PLAIN_MESSAGE
        );

        // Canceló
        if (nuevoTelefono == null) return;

        nuevoTelefono = nuevoTelefono.trim();

        // No puede estar vacío
        if (nuevoTelefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El teléfono no puede estar vacío.");
            return;
        }

        // Validar formato y que no exista en otra persona
        if (!Validador.esTelefonoValido(nuevoTelefono) || Persona.buscarPersonaPorTelefono(nuevoTelefono) != null) {
            JOptionPane.showMessageDialog(this, "Teléfono inválido o ya registrado.");
            return;
        }

        // Actualizar teléfono del cliente
        cliente.setTelefono(nuevoTelefono);
        JOptionPane.showMessageDialog(this, "Teléfono actualizado correctamente.");
    }//GEN-LAST:event_btnTelefonoActionPerformed

    private void btnCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorreoActionPerformed
        // Pedir nuevo correo
        String nuevoCorreo = JOptionPane.showInputDialog(
                this,
                "Ingrese nuevo correo:",
                "Actualizar Correo",
                JOptionPane.PLAIN_MESSAGE
        );

        // Canceló
        if (nuevoCorreo == null) return;

        nuevoCorreo = nuevoCorreo.trim();

        // No puede estar vacío
        if (nuevoCorreo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El correo no puede estar vacío.");
            return;
        }

        // Validación de formato
        if (!Validador.esCorreoValido(nuevoCorreo)) {
            JOptionPane.showMessageDialog(this, "Formato de correo inválido.");
            return;
        }

        // Validar que no esté registrado en otra persona
        if (Persona.buscarPersonaPorCorreo(nuevoCorreo) != null) {
            JOptionPane.showMessageDialog(this, "Correo ya registrado en otro usuario.");
            return;
        }

        // Actualizar correo del cliente
        cliente.setCorreo(nuevoCorreo);
        JOptionPane.showMessageDialog(this, "Correo actualizado correctamente.");
    }//GEN-LAST:event_btnCorreoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCorreo;
    private javax.swing.JButton btnTelefono;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
