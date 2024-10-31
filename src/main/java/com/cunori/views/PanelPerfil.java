/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cunori.views;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ferna
 */
public class PanelPerfil extends javax.swing.JPanel {

    private Color colorEnteredMenu; 
    private Color colorExitedMenu; 
    
    public PanelPerfil() {
        initComponents();
        
        colorEnteredMenu = new Color(0,87,95);
        colorExitedMenu = new Color(0,109,119);
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel22 = new javax.swing.JLabel();
        pDataPerfil = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNitUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();
        lbGuardarCambios = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRol = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        lbCambiarContrasenia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel22.setText("Perfil de Usuario");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        pDataPerfil.setBackground(new java.awt.Color(237, 246, 249));
        pDataPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 87, 95));
        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel2.setText("Nit *");
        pDataPerfil.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 160, -1));

        txtNitUsuario.setBackground(new java.awt.Color(237, 246, 249));
        txtNitUsuario.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtNitUsuario.setForeground(java.awt.Color.gray);
        txtNitUsuario.setText("123456");
        txtNitUsuario.setBorder(null);
        txtNitUsuario.setEnabled(false);
        pDataPerfil.add(txtNitUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 300, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        pDataPerfil.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 300, 10));

        jLabel3.setBackground(new java.awt.Color(0, 87, 95));
        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel3.setText("Nombre *");
        pDataPerfil.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 160, -1));

        txtNombre.setBackground(new java.awt.Color(237, 246, 249));
        txtNombre.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtNombre.setText("Juan");
        txtNombre.setBorder(null);
        pDataPerfil.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 300, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        pDataPerfil.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 300, 10));

        jLabel4.setBackground(new java.awt.Color(0, 87, 95));
        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel4.setText("Apellido(s) *");
        pDataPerfil.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 160, -1));

        txtApellidos.setBackground(new java.awt.Color(237, 246, 249));
        txtApellidos.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtApellidos.setText("López");
        txtApellidos.setBorder(null);
        pDataPerfil.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 300, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        pDataPerfil.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 300, 10));

        jLabel5.setBackground(new java.awt.Color(0, 87, 95));
        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel5.setText("Teléfono *");
        pDataPerfil.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 160, -1));

        txtTelefono.setBackground(new java.awt.Color(237, 246, 249));
        txtTelefono.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtTelefono.setText("123456");
        txtTelefono.setBorder(null);
        pDataPerfil.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 300, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        pDataPerfil.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 300, 10));

        jLabel6.setBackground(new java.awt.Color(0, 87, 95));
        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel6.setText("Contraseña *");
        pDataPerfil.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 160, -1));

        txtCorreo.setBackground(new java.awt.Color(237, 246, 249));
        txtCorreo.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtCorreo.setText("juanlop@gmail.com");
        txtCorreo.setBorder(null);
        pDataPerfil.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 300, -1));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        pDataPerfil.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 300, 10));

        jLabel7.setBackground(new java.awt.Color(0, 87, 95));
        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel7.setText("Correo *");
        pDataPerfil.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 160, -1));

        txtContrasenia.setBackground(new java.awt.Color(237, 246, 249));
        txtContrasenia.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtContrasenia.setText("******************");
        txtContrasenia.setBorder(null);
        txtContrasenia.setEnabled(false);
        pDataPerfil.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 300, -1));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        pDataPerfil.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 300, 10));

        lbGuardarCambios.setBackground(new java.awt.Color(0, 109, 119));
        lbGuardarCambios.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        lbGuardarCambios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGuardarCambios.setText("Guardar Cambios");
        lbGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbGuardarCambios.setOpaque(true);
        lbGuardarCambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbGuardarCambiosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbGuardarCambiosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbGuardarCambiosMousePressed(evt);
            }
        });
        pDataPerfil.add(lbGuardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 190, 30));

        jLabel8.setBackground(new java.awt.Color(0, 87, 95));
        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel8.setText("Rol *");
        pDataPerfil.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 160, -1));

        txtRol.setBackground(new java.awt.Color(237, 246, 249));
        txtRol.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtRol.setText("Recepcionista");
        txtRol.setBorder(null);
        txtRol.setEnabled(false);
        pDataPerfil.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 300, -1));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        pDataPerfil.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 300, 10));

        lbCambiarContrasenia.setBackground(new java.awt.Color(0, 109, 119));
        lbCambiarContrasenia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbCambiarContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        lbCambiarContrasenia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCambiarContrasenia.setText("Cambiar \nContraseña");
        lbCambiarContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCambiarContrasenia.setOpaque(true);
        lbCambiarContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCambiarContraseniaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCambiarContraseniaMouseExited(evt);
            }
        });
        pDataPerfil.add(lbCambiarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 190, 30));

        add(pDataPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 950, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void lbGuardarCambiosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGuardarCambiosMouseEntered
        lbGuardarCambios.setBackground(colorEnteredMenu);
    }//GEN-LAST:event_lbGuardarCambiosMouseEntered

    private void lbGuardarCambiosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGuardarCambiosMouseExited
        lbGuardarCambios.setBackground(colorExitedMenu);
    }//GEN-LAST:event_lbGuardarCambiosMouseExited

    private void lbCambiarContraseniaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCambiarContraseniaMouseEntered
        lbCambiarContrasenia.setBackground(colorEnteredMenu);
    }//GEN-LAST:event_lbCambiarContraseniaMouseEntered

    private void lbCambiarContraseniaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCambiarContraseniaMouseExited
        lbCambiarContrasenia.setBackground(colorExitedMenu);
    }//GEN-LAST:event_lbCambiarContraseniaMouseExited

    private void lbGuardarCambiosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbGuardarCambiosMousePressed
        JOptionPane.showMessageDialog(null, "Hola", "Saludo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lbGuardarCambiosMousePressed

    public JLabel getLbCambiarContrasenia() {
        return lbCambiarContrasenia;
    }

    public void setLbCambiarContrasenia(JLabel lbCambiarContrasenia) {
        this.lbCambiarContrasenia = lbCambiarContrasenia;
    }

    public JLabel getLbGuardarCambios() {
        return lbGuardarCambios;
    }

    public void setLbGuardarCambios(JLabel lbGuardarCambios) {
        this.lbGuardarCambios = lbGuardarCambios;
    }

    public JPanel getpDataPerfil() {
        return pDataPerfil;
    }

    public void setpDataPerfil(JPanel pDataPerfil) {
        this.pDataPerfil = pDataPerfil;
    }

    public JTextField getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(JTextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public JPasswordField getTxtContrasenia() {
        return txtContrasenia;
    }

    public void setTxtContrasenia(JPasswordField txtContrasenia) {
        this.txtContrasenia = txtContrasenia;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public JTextField getTxtNitUsuario() {
        return txtNitUsuario;
    }

    public void setTxtNitUsuario(JTextField txtNitUsuario) {
        this.txtNitUsuario = txtNitUsuario;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtRol() {
        return txtRol;
    }

    public void setTxtRol(JTextField txtRol) {
        this.txtRol = txtRol;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbCambiarContrasenia;
    private javax.swing.JLabel lbGuardarCambios;
    private javax.swing.JPanel pDataPerfil;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNitUsuario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}