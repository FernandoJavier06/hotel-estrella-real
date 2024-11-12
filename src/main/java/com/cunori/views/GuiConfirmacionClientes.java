/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cunori.views;

import com.cunori.controllers.ClienteJpaController;
import com.cunori.models.Cliente;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferna
 */
public class GuiConfirmacionClientes extends javax.swing.JFrame {

    private PanelReservaciones panelReservaciones;
    private Color colorEnteredMenu;
    private Color colorExitedMenu;
    private Cliente cliente;
    private DefaultComboBoxModel modelCmbBuscar;
    private DefaultTableModel modelTbClientes;
    private EntityManagerFactory emf;
    private ClienteJpaController clienteJpaController;
    private List<Cliente> clientes;
    private String parametroBuscar = "";

    public GuiConfirmacionClientes() {
        initComponents();
        //this.setSize(1100, 655);
        this.setLocationRelativeTo(null);

        colorEnteredMenu = new Color(0, 87, 95);
        colorExitedMenu = new Color(0, 109, 119);

        modelTbClientes = (DefaultTableModel) tbClientes.getModel();
        modelTbClientes.setRowCount(0);
        modelCmbBuscar = (DefaultComboBoxModel) cmbBuscar.getModel();
        cliente = new Cliente();
        clientes = new ArrayList<>();

        lbAceptarNuevoCliente.setVisible(false);
        lbCancelar.setVisible(false);
        txtNit.setEnabled(false);
        txtNombre.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtTelefono.setEnabled(false);

        try {

            emf = Persistence.createEntityManagerFactory("com.cunori.hotel.estrella.real_hotel-estrella-real_jar_1.0-SNAPSHOTPU");
            clienteJpaController = new ClienteJpaController(emf);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lbAgregarCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbSeleccionarCliente = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        cmbBuscar = new javax.swing.JComboBox<>();
        lbBuscarCliente = new javax.swing.JLabel();
        lbAceptarNuevoCliente = new javax.swing.JLabel();
        lbCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1100, 655));
        setPreferredSize(new java.awt.Dimension(1150, 655));
        setResizable(false);
        setSize(new java.awt.Dimension(1100, 680));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel21.setText("Seleccionar Cliente");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(237, 246, 249));

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nit", "Nombre", "Apellido(s)", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        jLabel3.setBackground(new java.awt.Color(0, 87, 95));
        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel3.setText("Nombre *");

        txtNombre.setBackground(new java.awt.Color(237, 246, 249));
        txtNombre.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.setEnabled(false);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(0, 87, 95));
        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel2.setText("Nit *");

        txtNit.setBackground(new java.awt.Color(237, 246, 249));
        txtNit.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtNit.setBorder(null);
        txtNit.setDisabledTextColor(java.awt.Color.gray);
        txtNit.setEnabled(false);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setBackground(new java.awt.Color(0, 87, 95));
        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel4.setText("Apellidos *");

        txtApellidos.setBackground(new java.awt.Color(237, 246, 249));
        txtApellidos.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtApellidos.setBorder(null);

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(0, 87, 95));
        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel5.setText("Teléfono *");

        txtTelefono.setBackground(new java.awt.Color(237, 246, 249));
        txtTelefono.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtTelefono.setBorder(null);

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        lbAgregarCliente.setBackground(new java.awt.Color(0, 109, 119));
        lbAgregarCliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        lbAgregarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAgregarCliente.setText("Agregar Cliente");
        lbAgregarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAgregarCliente.setOpaque(true);
        lbAgregarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAgregarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAgregarClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAgregarClienteMousePressed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 87, 95));
        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel6.setText("Registro de Clientes");

        lbSeleccionarCliente.setBackground(new java.awt.Color(0, 109, 119));
        lbSeleccionarCliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbSeleccionarCliente.setForeground(new java.awt.Color(255, 255, 255));
        lbSeleccionarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSeleccionarCliente.setText("Seleccionar Cliente");
        lbSeleccionarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSeleccionarCliente.setOpaque(true);
        lbSeleccionarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSeleccionarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbSeleccionarClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbSeleccionarClienteMousePressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 87, 95));
        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel7.setText("Buscar por");

        txtBuscar.setBackground(new java.awt.Color(237, 246, 249));
        txtBuscar.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtBuscar.setBorder(null);

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        cmbBuscar.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar todos", "Nit", "Nombre", "Apellido(s)" }));

        lbBuscarCliente.setBackground(new java.awt.Color(0, 109, 119));
        lbBuscarCliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbBuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        lbBuscarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBuscarCliente.setText("Buscar");
        lbBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBuscarCliente.setOpaque(true);
        lbBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbBuscarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbBuscarClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbBuscarClienteMousePressed(evt);
            }
        });

        lbAceptarNuevoCliente.setBackground(new java.awt.Color(0, 109, 119));
        lbAceptarNuevoCliente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbAceptarNuevoCliente.setForeground(new java.awt.Color(255, 255, 255));
        lbAceptarNuevoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAceptarNuevoCliente.setText("Aceptar");
        lbAceptarNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAceptarNuevoCliente.setOpaque(true);
        lbAceptarNuevoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAceptarNuevoClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAceptarNuevoClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbAceptarNuevoClienteMousePressed(evt);
            }
        });

        lbCancelar.setBackground(new java.awt.Color(0, 109, 119));
        lbCancelar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        lbCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCancelar.setText("Cancelar");
        lbCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCancelar.setOpaque(true);
        lbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCancelarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCancelarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAceptarNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator6)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addGap(12, 12, 12)
                                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(23, 23, 23)
                            .addComponent(lbBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(3, 3, 3)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(3, 3, 3)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(3, 3, 3)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAceptarNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(lbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1060, 540));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTabla(int index) {
        clientes.clear();
        modelTbClientes.setRowCount(0);
        switch (index) {
            case 0:
                clientes = clienteJpaController.findClienteEntities();
                break;
            case 1:
                parametroBuscar = txtBuscar.getText();
                clientes = clienteJpaController.findAllByNit(parametroBuscar);
                break;
            case 2:
                parametroBuscar = txtBuscar.getText();
                clientes = clienteJpaController.findAllByNombre(parametroBuscar);
                break;
            case 3:
                parametroBuscar = txtBuscar.getText();
                clientes = clienteJpaController.findAllByApellidos(parametroBuscar);
                break;
        }

        for (Cliente cliente : clientes) {
            Object[] nuevaColumna = {cliente.getNitCliente(), cliente.getNombre(),
                cliente.getApellidos(), cliente.getTelefono()};
            modelTbClientes.addRow(nuevaColumna);
        }
    }


    private void lbAgregarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAgregarClienteMouseEntered
        lbAgregarCliente.setBackground(colorEnteredMenu);
    }//GEN-LAST:event_lbAgregarClienteMouseEntered

    private void lbAgregarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAgregarClienteMouseExited
        lbAgregarCliente.setBackground(colorExitedMenu);
    }//GEN-LAST:event_lbAgregarClienteMouseExited

    private void lbSeleccionarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSeleccionarClienteMouseEntered
        lbSeleccionarCliente.setBackground(colorEnteredMenu);
    }//GEN-LAST:event_lbSeleccionarClienteMouseEntered

    private void lbSeleccionarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSeleccionarClienteMouseExited
        lbSeleccionarCliente.setBackground(colorExitedMenu);
    }//GEN-LAST:event_lbSeleccionarClienteMouseExited

    private void lbSeleccionarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSeleccionarClienteMousePressed
        if (tbClientes.getSelectedRowCount() > 1 || tbClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente.", "Error de selección.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea seleccionar al cliente '"
                + tbClientes.getValueAt(tbClientes.getSelectedRow(), 1).toString() + " "
                + tbClientes.getValueAt(tbClientes.getSelectedRow(), 2).toString() + "'?",
                "Confirmación de reservación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
            return;
        }
        
        Cliente clienteSeleccionado = new Cliente();
        clienteSeleccionado.setNitCliente(tbClientes.getValueAt(tbClientes.getSelectedRow(), 0).toString());
        clienteSeleccionado.setNombre(tbClientes.getValueAt(tbClientes.getSelectedRow(), 1).toString());
        clienteSeleccionado.setApellidos(tbClientes.getValueAt(tbClientes.getSelectedRow(), 2).toString());
        clienteSeleccionado.setTelefono(tbClientes.getValueAt(tbClientes.getSelectedRow(), 3).toString());
        panelReservaciones.clienteSeleccionado(clienteSeleccionado);
        panelReservaciones.getGui().setEnabled(true);
        limpiarGuiConfirmacion();
        this.dispose();
    }//GEN-LAST:event_lbSeleccionarClienteMousePressed

    private void lbBuscarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBuscarClienteMouseEntered
        lbBuscarCliente.setBackground(colorEnteredMenu);
    }//GEN-LAST:event_lbBuscarClienteMouseEntered

    private void lbBuscarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBuscarClienteMouseExited
        lbBuscarCliente.setBackground(colorExitedMenu);
    }//GEN-LAST:event_lbBuscarClienteMouseExited

    private void lbBuscarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBuscarClienteMousePressed
        if (cmbBuscar.getSelectedIndex() != 0 && txtBuscar.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La busqueda no se debe realizar en blanco.", "Error de busqueda.", JOptionPane.ERROR_MESSAGE);
            modelTbClientes.setRowCount(0);
            txtBuscar.setText("");
            txtBuscar.requestFocusInWindow();
            return;
        }
        llenarTabla(cmbBuscar.getSelectedIndex());
    }//GEN-LAST:event_lbBuscarClienteMousePressed

    private void lbAgregarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAgregarClienteMousePressed
        lbAceptarNuevoCliente.setVisible(true);
        lbCancelar.setVisible(true);
        lbAgregarCliente.setEnabled(false);
        lbSeleccionarCliente.setEnabled(false);
        isHabilitarTextos(true);
        vaciarTextos();
        txtNit.requestFocusInWindow();

    }//GEN-LAST:event_lbAgregarClienteMousePressed

    private void lbAceptarNuevoClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAceptarNuevoClienteMouseEntered
        lbAceptarNuevoCliente.setBackground(colorEnteredMenu);
    }//GEN-LAST:event_lbAceptarNuevoClienteMouseEntered

    private void lbAceptarNuevoClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAceptarNuevoClienteMouseExited
        lbAceptarNuevoCliente.setBackground(colorExitedMenu);
    }//GEN-LAST:event_lbAceptarNuevoClienteMouseExited

    private void lbAceptarNuevoClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAceptarNuevoClienteMousePressed
        if (txtNit.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty()
                || txtApellidos.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error de registro.", JOptionPane.ERROR_MESSAGE);
            vaciarTextos();
            txtNit.requestFocusInWindow();
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea agregar un nuevo cliente?", "Agregar nuevo cliente", JOptionPane.DEFAULT_OPTION) == 0) {
            if (clienteJpaController.nitExistente(txtNit.getText().trim()) > 0) {
                JOptionPane.showMessageDialog(null, "El nit ingresado ya se encuentra registrado", "Error de registro.", JOptionPane.ERROR_MESSAGE);
                txtNit.setText("");
                txtNit.requestFocusInWindow();
                return;
            }

            cliente.setNitCliente(txtNit.getText().trim());
            cliente.setNombre(txtNombre.getText().trim());
            cliente.setApellidos(txtApellidos.getText().trim());
            cliente.setTelefono(txtTelefono.getText().trim());

            try {
                clienteJpaController.create(cliente);
                modelTbClientes.setRowCount(0);
                cmbBuscar.setSelectedIndex(0);
                llenarTabla(cmbBuscar.getSelectedIndex());
                vaciarTextos();
                isHabilitarTextos(false);
                lbAgregarCliente.setEnabled(true);
                lbSeleccionarCliente.setEnabled(true);
                lbCancelar.setVisible(false);
                lbAceptarNuevoCliente.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al tratar de registrar un nuevo cliente", "Error de registro.", JOptionPane.ERROR_MESSAGE);
            }

        }


    }//GEN-LAST:event_lbAceptarNuevoClienteMousePressed

    private void lbCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCancelarMouseEntered
        lbCancelar.setBackground(colorEnteredMenu);
    }//GEN-LAST:event_lbCancelarMouseEntered

    private void lbCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCancelarMouseExited
        lbCancelar.setBackground(colorExitedMenu);
    }//GEN-LAST:event_lbCancelarMouseExited

    private void lbCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCancelarMousePressed
        vaciarTextos();
        isHabilitarTextos(false);
        lbAgregarCliente.setEnabled(true);
        lbSeleccionarCliente.setEnabled(true);
        lbAceptarNuevoCliente.setVisible(false);
        lbCancelar.setVisible(false);
    }//GEN-LAST:event_lbCancelarMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        panelReservaciones.getGui().setEnabled(true);
        limpiarGuiConfirmacion();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void vaciarTextos() {
        txtNit.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
    }

    private void isHabilitarTextos(boolean ok) {
        txtNit.setEnabled(ok);
        txtNombre.setEnabled(ok);
        txtApellidos.setEnabled(ok);
        txtTelefono.setEnabled(ok);
    }
    
    private void limpiarGuiConfirmacion(){
        vaciarTextos();
        isHabilitarTextos(false);
        lbAceptarNuevoCliente.setVisible(false);
        lbCancelar.setVisible(false);
        lbAgregarCliente.setEnabled(true);
        lbSeleccionarCliente.setEnabled(true);
        modelTbClientes.setRowCount(0);
        cmbBuscar.setSelectedIndex(0);
        txtBuscar.setText("");
    }

    public PanelReservaciones getPanelReservaciones() {
        return panelReservaciones;
    }

    public void setPanelReservaciones(PanelReservaciones panelReservaciones) {
        this.panelReservaciones = panelReservaciones;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiConfirmacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiConfirmacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiConfirmacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiConfirmacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiConfirmacionClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lbAceptarNuevoCliente;
    private javax.swing.JLabel lbAgregarCliente;
    private javax.swing.JLabel lbBuscarCliente;
    private javax.swing.JLabel lbCancelar;
    private javax.swing.JLabel lbSeleccionarCliente;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
