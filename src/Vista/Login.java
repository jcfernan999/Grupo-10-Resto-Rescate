/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Conexion;
import Modelo.Mesero;
import Modelo.MeseroData;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {
    int posx,posy;
    
    public Login() {
        initComponents();
         setLocationRelativeTo(null);
        tbUsuario.setBackground(new Color(0,0,0,2) );
        tbPass.setBackground(new Color(0,0,0,2) );
        
        this.setBackground(new Color(0,0,0,2) );
         try {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            meseroData = new MeseroData(conexion);
        
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private MeseroData meseroData;
    private Connection connection = null;
    private Conexion conexion;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbUsuario = new javax.swing.JTextField();
        tbPass = new javax.swing.JPasswordField();
        btnSalir = new javax.swing.JButton();
        btnBien = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setAutoRequestFocus(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbUsuario.setBackground(new java.awt.Color(204, 51, 255));
        tbUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbUsuario.setAutoscrolls(false);
        tbUsuario.setBorder(null);
        tbUsuario.setDragEnabled(true);
        tbUsuario.setOpaque(false);
        getContentPane().add(tbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 180, 30));

        tbPass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbPass.setBorder(null);
        tbPass.setOpaque(false);
        getContentPane().add(tbPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 180, 40));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login/Mal_A.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusPainted(false);
        btnSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login/Mal_B.png"))); // NOI18N
        btnSalir.setVerifyInputWhenFocusTarget(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 110, 90));

        btnBien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login/Bien_A.png"))); // NOI18N
        btnBien.setBorder(null);
        btnBien.setBorderPainted(false);
        btnBien.setContentAreaFilled(false);
        btnBien.setFocusPainted(false);
        btnBien.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login/Bien_B.png"))); // NOI18N
        btnBien.setVerifyInputWhenFocusTarget(false);
        btnBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBienActionPerformed(evt);
            }
        });
        getContentPane().add(btnBien, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 110, 90));

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login/Login_002.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBienActionPerformed

        Mesero mesero=meseroData.buscarUsuario(tbUsuario.getText(),tbPass.getText());
        if(mesero!=null){
            mesero.setActivo(true);
            meseroData.actualizarMesero(mesero);

            Principal ingreso = new Principal();
            ingreso.setVisible(true);
            ingreso.toFront();
            this.dispose();

        }
        else
        {
            JOptionPane.showMessageDialog(this, "NO ENCOTRADO");
        }
    }//GEN-LAST:event_btnBienActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        posx=evt.getX();
        posy=evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
       int xp=evt.getXOnScreen()-posx;
       int yp=evt.getYOnScreen()-posy;
       this.setLocation(xp, yp);
    }//GEN-LAST:event_jLabel1MouseDragged

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBien;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField tbPass;
    private javax.swing.JTextField tbUsuario;
    // End of variables declaration//GEN-END:variables
}
