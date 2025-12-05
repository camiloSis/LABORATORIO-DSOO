
package Banco.vista;
import Banco.clases.*;
import javax.swing.*;

public class MenuCuentaGUI extends javax.swing.JFrame {

    private Cliente cliente;
    private Cuenta cuenta;
    public MenuCuentaGUI(Cliente cliente, Cuenta cuenta) {
        this.cliente = cliente;
        this.cuenta = cuenta;
        initComponents();
        setLocationRelativeTo(null);
        cargarDatosCuenta();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelSaldo = new javax.swing.JLabel();
        lblNumeroCuenta = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        btnDeposito = new javax.swing.JButton();
        btnRetiro = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitulo.setText("MENU DE LA CUENTA");

        jLabelNumero.setText("Numero de Cuenta:");

        jLabelSaldo.setText("Saldo Actual:");

        lblNumeroCuenta.setText("---");

        lblSaldo.setText("---");

        btnDeposito.setText("Depositar");
        btnDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositoActionPerformed(evt);
            }
        });

        btnRetiro.setText("Retirar");
        btnRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroActionPerformed(evt);
            }
        });

        btnHistorial.setText("Ver Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNumero)
                            .addComponent(jLabelSaldo)
                            .addComponent(btnDeposito)
                            .addComponent(btnRetiro)
                            .addComponent(btnHistorial)
                            .addComponent(btnRegresar))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(lblNumeroCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNumero)
                    .addComponent(lblNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSaldo)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDeposito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRetiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap(46, Short.MAX_VALUE))
        );


        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositoActionPerformed
                String montoStr = JOptionPane.showInputDialog(this, "Ingrese monto a depositar:");

        if (montoStr == null) return; // cancelar

        if (!Validador.esMontoValido(montoStr)) {
            JOptionPane.showMessageDialog(this, "Monto inválido");
            return;
        }

        double monto = Double.parseDouble(montoStr);

        Empleado cajero = Main.elegirEmpleadoAtencionGUI();
        if (cajero == null) {
            JOptionPane.showMessageDialog(this, "Empleado no seleccionado.");
            return;
        }

        Deposito dep = Main.getOperaciones().RegistrarDeposito(cliente, cuenta, cajero, monto);

        if (dep != null) {
            JOptionPane.showMessageDialog(this, "Depósito exitoso");
            cargarDatosCuenta();
        }
    }//GEN-LAST:event_btnDepositoActionPerformed

    private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
        String montoStr = JOptionPane.showInputDialog(this, "Ingrese monto a retirar:");

        if (montoStr == null) return;

        if (!Validador.esMontoValido(montoStr)) {
            JOptionPane.showMessageDialog(this, "Monto inválido");
            return;
        }

        double monto = Double.parseDouble(montoStr);

        Empleado cajero = Main.elegirEmpleadoAtencionGUI();
        if (cajero == null) {
            JOptionPane.showMessageDialog(this, "Empleado no seleccionado.");
            return;
        }

        Retiro ret = Main.getOperaciones().RegistrarRetiro(cliente, cuenta, cajero, monto);

        if (ret != null) {
            JOptionPane.showMessageDialog(this, "Retiro exitoso");
            cargarDatosCuenta();
        }
    }//GEN-LAST:event_btnRetiroActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        new HistorialGUI(cuenta).setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cargarDatosCuenta() {
        lblNumeroCuenta.setText(cuenta.getNumeroCuenta());
        lblSaldo.setText("" + cuenta.getSaldo());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeposito;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRetiro;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel lblNumeroCuenta;
    private javax.swing.JLabel lblSaldo;
    // End of variables declaration//GEN-END:variables
}
