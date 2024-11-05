/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cunori.views;

import com.cunori.controllers.UsuarioJpaController;
import com.cunori.models.Usuario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ferna
 */
public class GuiLogin extends javax.swing.JFrame {

    private Gui gui;
    private Color colorEnteredMenu;
    private Color colorExitedMenu;
    private Usuario usuario;
    private UsuarioJpaController usuarioJpaController;
    private EntityManagerFactory emf;
    private List<Usuario> listUsuarios;

    public GuiLogin() {
        initComponents();
        this.setLocationRelativeTo(null);

        colorEnteredMenu = new Color(0, 87, 95);
        colorExitedMenu = new Color(0, 109, 119);

        usuario = new Usuario();
        listUsuarios = new ArrayList<>();

        try {
            emf = Persistence.createEntityManagerFactory("com.cunori.hotel.estrella.real_hotel-estrella-real_jar_1.0-SNAPSHOTPU");
            usuarioJpaController = new UsuarioJpaController(emf);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        txtCorreo.requestFocusInWindow();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtContrasenia = new javax.swing.JPasswordField();
        lbBuscarHabitacionReservacion = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(237, 246, 249));

        jLabel3.setBackground(new java.awt.Color(0, 87, 95));
        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel3.setText("Correo *");

        txtCorreo.setBackground(new java.awt.Color(237, 246, 249));
        txtCorreo.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtCorreo.setForeground(java.awt.Color.gray);
        txtCorreo.setText("ejemplo123@gmail.com");
        txtCorreo.setBorder(null);
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 87, 95));
        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jLabel4.setText("Contraseña *");

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        txtContrasenia.setBackground(new java.awt.Color(237, 246, 249));
        txtContrasenia.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        txtContrasenia.setForeground(java.awt.Color.gray);
        txtContrasenia.setText("holamundo");
        txtContrasenia.setToolTipText("");
        txtContrasenia.setBorder(null);
        txtContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtContrasenia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseniaFocusGained(evt);
            }
        });

        lbBuscarHabitacionReservacion.setBackground(new java.awt.Color(0, 109, 119));
        lbBuscarHabitacionReservacion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbBuscarHabitacionReservacion.setForeground(new java.awt.Color(255, 255, 255));
        lbBuscarHabitacionReservacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBuscarHabitacionReservacion.setText("Iniciar Sesión");
        lbBuscarHabitacionReservacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBuscarHabitacionReservacion.setOpaque(true);
        lbBuscarHabitacionReservacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBuscarHabitacionReservacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbBuscarHabitacionReservacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbBuscarHabitacionReservacionMouseExited(evt);
            }
        });

        lbLogin.setBackground(new java.awt.Color(0, 109, 119));
        lbLogin.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lbLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogin.setText("Iniciar Sesión");
        lbLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLoginMouseClicked(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBuscarHabitacionReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lbBuscarHabitacionReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Gui getGui() {
        return gui;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }


    private void lbBuscarHabitacionReservacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBuscarHabitacionReservacionMouseEntered
        lbBuscarHabitacionReservacion.setBackground(colorEnteredMenu);
    }//GEN-LAST:event_lbBuscarHabitacionReservacionMouseEntered

    private void lbBuscarHabitacionReservacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBuscarHabitacionReservacionMouseExited
        lbBuscarHabitacionReservacion.setBackground(colorExitedMenu);
    }//GEN-LAST:event_lbBuscarHabitacionReservacionMouseExited

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        if (txtCorreo.getText().equals("ejemplo123@gmail.com")) {
            txtCorreo.setText("");
            txtCorreo.setForeground(Color.BLACK);
        }

        String password = new String(txtContrasenia.getPassword());
        if (password.isEmpty()) {
            txtContrasenia.setText("holamundo");
            txtContrasenia.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtContraseniaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseniaFocusGained
        String password = new String(txtContrasenia.getPassword());
        if (password.equals("holamundo")) {
            txtContrasenia.setText("");
            txtContrasenia.setForeground(Color.BLACK);
        }

        if (txtCorreo.getText().isEmpty()) {
            txtCorreo.setText("ejemplo123@gmail.com");
            txtCorreo.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtContraseniaFocusGained

    private void lbBuscarHabitacionReservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBuscarHabitacionReservacionMouseClicked
        try{
        String correo = txtCorreo.getText();
        String passWord = new String(txtContrasenia.getPassword());
        listUsuarios = usuarioJpaController.findUsuarioEntities();
        
        if (listUsuarios == null || listUsuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            System.err.println("Listado vacio");
            return;
        }
        usuario = new Usuario();
        for (Usuario listUsuario : listUsuarios) {
            if (listUsuario.getCorreo().equals(correo)) {
                usuario = listUsuario;
                break;
            }
        }
        if (usuario.getCorreo() == null) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            System.err.println("Usuario no econtrado");
            return;
        }

        if (BCrypt.checkpw(passWord, usuario.getContrasenia())) {
            //JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!", "inicio de sesión", JOptionPane.INFORMATION_MESSAGE);
            this.gui.setUsuario(usuario);
            this.gui.tipoRol();
            this.gui.mandarDatosPerfil();
            this.setVisible(false);
            this.gui.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            this.txtCorreo.setText("");
            this.txtContrasenia.setText("");
            //this.txtContrasenia.requestFocusInWindow();
            this.txtCorreo.requestFocusInWindow();
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_lbBuscarHabitacionReservacionMouseClicked

    private void lbLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoginMouseClicked
        usuario.setNitUsuario("112233445");
        usuario.setNombre("Juan");
        usuario.setApellidos("López Morales");
        usuario.setTelefono("53785699");
        usuario.setCorreo("juanlm@gmail.com");
        String hashPassword = BCrypt.hashpw("contra123", BCrypt.gensalt());
        usuario.setContrasenia(hashPassword);
        usuario.setRol("Administrador");

        try {
            usuarioJpaController.create(usuario);
        } catch (Exception ex) {
            Logger.getLogger(GuiLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbLoginMouseClicked

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
            java.util.logging.Logger.getLogger(GuiLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbBuscarHabitacionReservacion;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}