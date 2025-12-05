
package Banco.vista;
import Banco.clases.*;
import javax.swing.*;

public class MenuCajeroGUI extends javax.swing.JFrame {

    SistemaBancario banco = Main.getBanco();
    private Empleado cajero;
    public MenuCajeroGUI(Empleado cajero) {
        this.cajero = cajero;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnDepositoEmp = new javax.swing.JButton();
        btnRetiroCaj = new javax.swing.JButton();
        btnVerOperaciones = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MENU DE CAJERO");

        btnDepositoEmp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDepositoEmp.setText("Realizar Deposito");
        btnDepositoEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositoEmpActionPerformed(evt);
            }
        });

        btnRetiroCaj.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRetiroCaj.setText("Realizar Retiro");
        btnRetiroCaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroCajActionPerformed(evt);
            }
        });

        btnVerOperaciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVerOperaciones.setText("Ver Operaciones");
        btnVerOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerOperacionesActionPerformed(evt);
            }
        });

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrarSesion.setText("CerrarSesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDepositoEmp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRetiroCaj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerOperaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnDepositoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRetiroCaj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositoEmpActionPerformed
        String dniCliente = JOptionPane.showInputDialog(this, "Ingrese el DNI del cliente:");
        if (dniCliente == null || dniCliente.isEmpty()) return;

        Cliente cliente = banco.buscarClientePorDni(dniCliente.trim());
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado o DNI invalido");
            return;
        }

        if (cliente.getCuentas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El cliente no tiene cuentas registradas.");
            return;
        }

        // Selección de cuenta
        String[] opciones = cliente.getCuentas().stream()
                            .map(c -> c.getNumeroCuenta() + " (" + c.getTipo() + ")")
                            .toArray(String[]::new);
        String seleccion = (String) JOptionPane.showInputDialog(this, 
                            "Seleccione una cuenta:", "Cuentas", 
                            JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (seleccion == null) return;

        Cuenta cuenta = cliente.getCuentas().get(
            java.util.Arrays.asList(opciones).indexOf(seleccion)
        );

        String montoStr = JOptionPane.showInputDialog(this, "Ingrese monto a depositar:");
        if (montoStr == null || !Validador.esMontoValido(montoStr)) {
            JOptionPane.showMessageDialog(this, "Monto inválido.");
            return;
        }

        double monto = Double.parseDouble(montoStr);
        Empleado cajero1 = this.cajero; // asigna el empleado logueado
        Deposito deposito = Main.getOperaciones().RegistrarDeposito(cliente, cuenta, cajero1, monto);

        if (deposito != null) {
            JOptionPane.showMessageDialog(this, "Depósito realizado. Nuevo saldo: S/. " + cuenta.getSaldo());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar el depósito.");
        }
    }//GEN-LAST:event_btnDepositoEmpActionPerformed

    private void btnRetiroCajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroCajActionPerformed
        String dniCliente = JOptionPane.showInputDialog(this, "Ingrese el DNI del cliente:");
        if (dniCliente == null || dniCliente.isEmpty()) return;

        Cliente cliente = banco.buscarClientePorDni(dniCliente.trim());
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado o DNI invalido");
            return;
        }

        if (cliente.getCuentas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El cliente no tiene cuentas registradas.");
            return;
        }

        // Selección de cuenta
        String[] opciones = cliente.getCuentas().stream()
                            .map(c -> c.getNumeroCuenta() + " (" + c.getTipo() + ")")
                            .toArray(String[]::new);
        String seleccion = (String) JOptionPane.showInputDialog(this, 
                            "Seleccione una cuenta:", "Cuentas", 
                            JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (seleccion == null) return;

        Cuenta cuenta = cliente.getCuentas().get(
            java.util.Arrays.asList(opciones).indexOf(seleccion)
        );

        String montoStr = JOptionPane.showInputDialog(this, "Ingrese monto a retirar:");
        if (montoStr == null || !Validador.esMontoValido(montoStr)) {
            JOptionPane.showMessageDialog(this, "Monto invalido.");
            return;
        }

        double monto = Double.parseDouble(montoStr);
        Empleado cajero1 = this.cajero; // asigna el empleado logueado
        Retiro retiro = Main.getOperaciones().RegistrarRetiro(cliente, cuenta, cajero1, monto);

        if (retiro != null) {
            JOptionPane.showMessageDialog(this, "Retiro realizado. Nuevo saldo: S/. " + cuenta.getSaldo());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar el retiro.");
        }
    }//GEN-LAST:event_btnRetiroCajActionPerformed

    private void btnVerOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOperacionesActionPerformed
        int totalTransacciones = banco.listarCuentas().stream()
                                .mapToInt(c -> c.mostrarHistorial().size())
                                .sum();
        double fondosTotales = banco.calcularTotalFondos();

        JOptionPane.showMessageDialog(this,
            "Total de cuentas: " + banco.listarCuentas().size() +
            "\nTotal de transacciones: " + totalTransacciones +
            "\nFondos totales del banco: S/. " + fondosTotales
        );
    }//GEN-LAST:event_btnVerOperacionesActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnDepositoEmp;
    private javax.swing.JButton btnRetiroCaj;
    private javax.swing.JButton btnVerOperaciones;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
