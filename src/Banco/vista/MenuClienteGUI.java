
    package Banco.vista;
    import Banco.clases.*;
    import javax.swing.*;
    
    public class MenuClienteGUI extends javax.swing.JFrame {

        SistemaBancario banco = Main.getBanco();
        private Cliente clienteLogueado;
        public MenuClienteGUI(Cliente clienteLogueado) {
            this.clienteLogueado = clienteLogueado;
            initComponents();
            setLocationRelativeTo(null);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnVerCuentas = new javax.swing.JButton();
        btnIngreCuenta = new javax.swing.JButton();
        btnCrearCuenta = new javax.swing.JButton();
        btnActDatos = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MENU DE CLIENTE");

        btnVerCuentas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVerCuentas.setText("Ver mis Cuentas");
        btnVerCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCuentasActionPerformed(evt);
            }
        });

        btnIngreCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnIngreCuenta.setText("Ingresar a una Cuenta");
        btnIngreCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngreCuentaActionPerformed(evt);
            }
        });

        btnCrearCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });

        btnActDatos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnActDatos.setText("Actualizar Datos");
        btnActDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActDatosActionPerformed(evt);
            }
        });

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVerCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIngreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(97, 97, 97))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnVerCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void btnVerCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCuentasActionPerformed
            new MostrarCuentasGUI(clienteLogueado).setVisible(true);
        }//GEN-LAST:event_btnVerCuentasActionPerformed

    private void btnIngreCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngreCuentaActionPerformed
        new SeleccionarCuentaGUI(clienteLogueado).setVisible(true);
    }//GEN-LAST:event_btnIngreCuentaActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        // Preguntar tipo de cuenta
        String tipo = Main.elegirTipoGUI();

        // Si el usuario canceló la selección
        if (tipo == null) {
            System.out.println("Operación cancelada");
            return; // salir del método sin hacer nada
        }
        // Generar número
        String numeroCuenta = banco.generarNumeroCuenta();  // debe existir en tu Main

        // Crear objeto Cuenta
        Cuenta nuevaCuenta = new Cuenta(numeroCuenta, tipo, 0.0);

        // Agregar la cuenta al cliente
        clienteLogueado.agregarCuenta(nuevaCuenta);

        // Registrar en la base (si usas archivo o lista central)
        banco.registrarCuenta(nuevaCuenta);

        // Mensaje final
        JOptionPane.showMessageDialog(this,
                "Cuenta creada exitosamente\n"
                + "Número: " + numeroCuenta + "\n"
                + "Tipo: " + tipo);
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void btnActDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActDatosActionPerformed
        new ActualizarDatosGUI(clienteLogueado).setVisible(true);
    }//GEN-LAST:event_btnActDatosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActDatos;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnIngreCuenta;
    private javax.swing.JButton btnVerCuentas;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    }
