
package Banco.vista;
import Banco.clases.*;
import javax.swing.*;

public class SeleccionarCuentaGUI extends javax.swing.JFrame {

    private Cliente cliente;
    public SeleccionarCuentaGUI(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
        setLocationRelativeTo(null);
        cargarCuentas();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        listaCuentas = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnSeleccionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("LISTA DE CUENTAS");

        jList1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaCuentas.setViewportView(jList1);

        btnSeleccionar.setText("Ingresar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnSeleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(listaCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int index = jList1.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una cuenta.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cuenta cuentaSeleccionada = cliente.getCuentas().get(index);

        new MenuCuentaGUI(cliente, cuentaSeleccionada).setVisible(true);

        dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cargarCuentas() {
        if (cliente.getCuentas().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No tiene cuentas registradas.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            dispose();
            return;
        }

        DefaultListModel<String> modelo = new DefaultListModel<>();

        cliente.getCuentas().forEach(c -> {
            modelo.addElement("Cuenta: " + c.getNumeroCuenta());
        });

        jList1.setModel(modelo);
    }                                            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane listaCuentas;
    // End of variables declaration//GEN-END:variables
}
