
package Banco.vista;
import Banco.clases.*;
import javax.swing.*;
import java.util.*;

public class MenuAdministradorGUI extends javax.swing.JFrame {

    SistemaBancario banco = Main.getBanco();
    private Administrador admin;
    public MenuAdministradorGUI(Administrador admin) {
        this.admin = admin;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        btnListClientes = new javax.swing.JButton();
        btnListEmpleados = new javax.swing.JButton();
        btnListCuentas = new javax.swing.JButton();
        btnListPersonas = new javax.swing.JButton();
        btnFondos = new javax.swing.JButton();
        btnNuevoAdmin = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnElimCliente = new javax.swing.JButton();
        btnElimCuenta = new javax.swing.JButton();
        btnElimEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlTitulo.setText("MENU DE ADMINISTRADOR");

        btnListClientes.setText("Listar Clientes");
        btnListClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListClientesActionPerformed(evt);
            }
        });

        btnListEmpleados.setText("Listar Empleados");
        btnListEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListEmpleadosActionPerformed(evt);
            }
        });

        btnListCuentas.setText("Listar Cuentas");
        btnListCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListCuentasActionPerformed(evt);
            }
        });

        btnListPersonas.setText("Listar Personas");
        btnListPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListPersonasActionPerformed(evt);
            }
        });

        btnFondos.setText("Ver Fondos Totales");
        btnFondos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFondosActionPerformed(evt);
            }
        });

        btnNuevoAdmin.setText("Crear nuevo Admin");
        btnNuevoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAdminActionPerformed(evt);
            }
        });

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnElimCliente.setText("Eliminar Cliente");
        btnElimCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimClienteActionPerformed(evt);
            }
        });

        btnElimCuenta.setText("Eliminar Cuenta");
        btnElimCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimCuentaActionPerformed(evt);
            }
        });

        btnElimEmpleado.setText("Eliminar Empleado");
        btnElimEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnListClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElimCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFondos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnElimEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnElimCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlTitulo)
                        .addGap(26, 26, 26)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListClientes)
                    .addComponent(btnElimCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListEmpleados)
                    .addComponent(btnElimEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListCuentas)
                    .addComponent(btnElimCuenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListPersonas)
                    .addComponent(btnNuevoAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFondos)
                    .addComponent(btnCerrarSesion))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListClientesActionPerformed
        List<Cliente> clientes = banco.listarClientes();

        // Crear columnas y datos
        String[] columnas = {"ID", "Nombre", "DNI", "Usuario"};
        String[][] datos = new String[clientes.size()][4];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            datos[i][0] = c.getIdCliente();
            datos[i][1] = c.getNombre();
            datos[i][2] = c.getDni();
            datos[i][3] = c.getUsuario();
        }

        // Crear tabla
        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new java.awt.Dimension(400, 200));

        // Mostrar en un JOptionPane
        JOptionPane.showMessageDialog(this, scroll, "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnListClientesActionPerformed

    private void btnListEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListEmpleadosActionPerformed
        List<Empleado> empleados = banco.listarEmpleados();

        // Crear columnas y datos
        String[] columnas = {"ID", "Nombre", "Cargo", "Usuario"};
        String[][] datos = new String[empleados.size()][4];

        for (int i = 0; i < empleados.size(); i++) {
            Empleado e = empleados.get(i);
            datos[i][0] = e.getIdEmpleado();
            datos[i][1] = e.getNombre();
            datos[i][2] = e.getCargo();
            datos[i][3] = e.getUsuario();
        }

        // Crear tabla
        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new java.awt.Dimension(400, 200));

        // Mostrar en un JOptionPane
        JOptionPane.showMessageDialog(this, scroll, "Lista de Empleados", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnListEmpleadosActionPerformed

    private void btnListCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListCuentasActionPerformed
        List<Cuenta> cuentas = banco.listarCuentas();

        // Crear columnas y datos
        String[] columnas = {"ID-Cuenta", "Saldo", "Tipo"};
        String[][] datos = new String[cuentas.size()][3];

        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta c = cuentas.get(i);
            datos[i][0] = c.getNumeroCuenta();
            datos[i][1] = Double.toString(c.getSaldo());
            datos[i][2] = c.getTipo();
        }

        // Crear tabla
        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new java.awt.Dimension(400, 200));

        // Mostrar en un JOptionPane
        JOptionPane.showMessageDialog(this, scroll, "Lista de Cuentas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnListCuentasActionPerformed

    private void btnListPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListPersonasActionPerformed
        List<Persona> personas = Persona.getPersonasRegistradas();

        // Crear columnas y datos
        String[] columnas = {"Nombre", "Apellido", "DNI", "Telefono"};
        String[][] datos = new String[personas.size()][4];

        for (int i = 0; i < personas.size(); i++) {
            Persona p = personas.get(i);
            datos[i][0] = p.getNombre();
            datos[i][1] = p.getApellido();
            datos[i][2] = p.getDni();
            datos[i][3] = p.getTelefono();
        }

        // Crear tabla
        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new java.awt.Dimension(400, 200));

        // Mostrar en un JOptionPane
        JOptionPane.showMessageDialog(this, scroll, "Lista de Personas Registradas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnListPersonasActionPerformed

    private void btnFondosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFondosActionPerformed
        double fondosTotales = banco.calcularTotalFondos();
        JOptionPane.showMessageDialog(null, "Fondos Totales: " + fondosTotales);
    }//GEN-LAST:event_btnFondosActionPerformed

    private void btnElimClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimClienteActionPerformed
        // Obtener lista de clientes
        java.util.List<Cliente> clientes = banco.listarClientes();

        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay clientes registrados.");
            return;
        }

        // Crear arreglo de nombres para mostrar en JOptionPane
        String[] nombres = new String[clientes.size()];
        for (int i = 0; i < clientes.size(); i++) {
            nombres[i] = clientes.get(i).getNombre() + " - " + clientes.get(i).getDni();
        }

        // Mostrar selección
        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el cliente a eliminar:",
                "Eliminar Cliente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombres,
                nombres[0]
        );

        // Si canceló
        if (seleccion == null) return;

        // Encontrar el cliente seleccionado
        Cliente clienteAEliminar = null;
        for (Cliente c : clientes) {
            if (seleccion.contains(c.getDni())) {
                clienteAEliminar = c;
                break;
            }
        }

        if (clienteAEliminar != null) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro que desea eliminar al cliente " + clienteAEliminar.getNombre() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                banco.getMapaClientes().remove(clienteAEliminar.getDni());
                Persona.getPersonasRegistradas().remove(clienteAEliminar);
                JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.");
            }
        }
    }//GEN-LAST:event_btnElimClienteActionPerformed

    private void btnElimEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimEmpleadoActionPerformed
        // Obtener lista de clientes
        java.util.List<Empleado> empleados = banco.listarEmpleados();

        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay empleados registrados.");
            return;
        }

        // Crear arreglo de nombres para mostrar en JOptionPane
        String[] nombres = new String[empleados.size()];
        for (int i = 0; i < empleados.size(); i++) {
            nombres[i] = empleados.get(i).getNombre() + " - " + empleados.get(i).getDni();
        }

        // Mostrar selección
        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el empleado a eliminar:",
                "Eliminar Empleado",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombres,
                nombres[0]
        );

        // Si canceló
        if (seleccion == null) return;

        // Encontrar el cliente seleccionado
        Empleado empleadoAEliminar = null;
        for (Empleado e : empleados) {
            if (seleccion.contains(e.getDni())) {
                empleadoAEliminar = e;
                break;
            }
        }

        if (empleadoAEliminar != null) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro que desea eliminar al empleado " + empleadoAEliminar.getNombre() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                banco.getMapaEmpleado().remove(empleadoAEliminar.getDni());
                Persona.getPersonasRegistradas().remove(empleadoAEliminar);
                JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente.");
            }
        }
    }//GEN-LAST:event_btnElimEmpleadoActionPerformed

    private void btnElimCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimCuentaActionPerformed
        // Obtener lista de clientes
        java.util.List<Cuenta> cuentas = banco.listarCuentas();

        if (cuentas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay cuentas registrados.");
            return;
        }

        // Crear arreglo de nombres para mostrar en JOptionPane
        String[] nombres = new String[cuentas.size()];
        for (int i = 0; i < cuentas.size(); i++) {
            nombres[i] = cuentas.get(i).getNumeroCuenta() + " - " + cuentas.get(i).getTipo();
        }

        // Mostrar selección
        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione la cuenta a eliminar:",
                "Eliminar Cuenta",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombres,
                nombres[0]
        );

        // Si canceló
        if (seleccion == null) return;

        // Encontrar el cliente seleccionado
        Cuenta cuentaAEliminar = null;
        for (Cuenta c : cuentas) {
            if (seleccion.contains(c.getNumeroCuenta())) {
                cuentaAEliminar = c;
                break;
            }
        }

        if (cuentaAEliminar != null) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro que desea eliminar la cuenta " + cuentaAEliminar.getNumeroCuenta() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                banco.getMapaCuenta().remove(cuentaAEliminar.getNumeroCuenta());
                JOptionPane.showMessageDialog(this, "Cuenta eliminado correctamente.");
            }
        }
    }//GEN-LAST:event_btnElimCuentaActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnNuevoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAdminActionPerformed
        new CrearAdministradorGUI().setVisible(true);
    }//GEN-LAST:event_btnNuevoAdminActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnElimCliente;
    private javax.swing.JButton btnElimCuenta;
    private javax.swing.JButton btnElimEmpleado;
    private javax.swing.JButton btnFondos;
    private javax.swing.JButton btnListClientes;
    private javax.swing.JButton btnListCuentas;
    private javax.swing.JButton btnListEmpleados;
    private javax.swing.JButton btnListPersonas;
    private javax.swing.JButton btnNuevoAdmin;
    private javax.swing.JLabel jlTitulo;
    // End of variables declaration//GEN-END:variables
}
