package Login;

import Teknisi.*;
import Owner.*;
import Admin.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import KoneksiDatabase.ClassKoneksi;
import javax.swing.ImageIcon;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }
    ImageIcon notFound = new ImageIcon(getClass().getResource("/Images/icon not found.png"));
    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnMasuk = new javax.swing.JButton();
        lblBack = new javax.swing.JLabel();
        lblRegister = new javax.swing.JLabel();
        lblLupaSandi = new javax.swing.JLabel();
        lblBackrgound = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setBackground(new java.awt.Color(234, 240, 247));
        txtUsername.setBorder(null);
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 416, 320, 50));

        txtPassword.setBackground(new java.awt.Color(234, 240, 247));
        txtPassword.setBorder(null);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 499, 320, 50));

        btnMasuk.setBorder(null);
        btnMasuk.setBorderPainted(false);
        btnMasuk.setContentAreaFilled(false);
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });
        getContentPane().add(btnMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(998, 608, 160, 40));

        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        getContentPane().add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 896, 35, 30));

        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });
        getContentPane().add(lblRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 532, 160, 15));

        lblLupaSandi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLupaSandiMouseClicked(evt);
            }
        });
        getContentPane().add(lblLupaSandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 566, 110, 20));

        lblBackrgound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Login.png"))); // NOI18N
        getContentPane().add(lblBackrgound, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        String User = txtUsername.getText();
        String Pass = txtPassword.getText();
        Register pgReg = new Register();
        String HashSandiLogin = pgReg.HashSandi(Pass);
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            String sql = "SELECT * FROM akun WHERE username = '" + User + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String AmbilPass = rs.getString("password");
                String Status = rs.getString("status");
                if (AmbilPass.equals(HashSandiLogin)) {
                    if ("owner".equals(Status)) {
                        HomePageOwner pgHome = new HomePageOwner();
                        pgHome.setVisible(true);
                        this.dispose();
                    } else if ("admin".equals(Status)) {
                        HomePage_Admin pgHome = new HomePage_Admin();
                        pgHome.setVisible(true);
                        this.dispose();
                    } else if ("teknisi".equals(Status)) {
                        Permintaan_Perawatan_Teknisi pgTeknisi = new Permintaan_Perawatan_Teknisi();
                        pgTeknisi.setVisible(true);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sandi salah !", "Gagal Masuk", JOptionPane.ERROR_MESSAGE, notFound);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nama pengguna Tidak ditemukan !", "Gagal Masuk", JOptionPane.ERROR_MESSAGE, notFound);
            }
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan page login" + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_btnMasukActionPerformed

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        Register pgRegister = new Register();
        pgRegister.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblRegisterMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        Welcome pgWelcome = new Welcome();
        pgWelcome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblLupaSandiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLupaSandiMouseClicked
        LupaSandi pgRepass = new LupaSandi();
        pgRepass.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLupaSandiMouseClicked

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMasuk;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblBackrgound;
    private javax.swing.JLabel lblLupaSandi;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
