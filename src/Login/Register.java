package Login;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import KoneksiDatabase.ClassKoneksi;
import java.security.MessageDigest;
import javax.swing.ImageIcon;


public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
    }

    ImageIcon user = new ImageIcon(getClass().getResource("/Images/user.png"));
    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon simpan = new ImageIcon(getClass().getResource("/Images/icon save.png"));
   
     public static String HashSandi (String sandi) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(sandi.getBytes());
            byte[] rbt = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : rbt) {
            sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghast akun");
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupStatus = new javax.swing.ButtonGroup();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtRepassword = new javax.swing.JPasswordField();
        RbuttonAdmin = new javax.swing.JRadioButton();
        RbuttonTeknisi = new javax.swing.JRadioButton();
        lblBack = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        btnDaftar = new javax.swing.JButton();
        LabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setBackground(new java.awt.Color(234, 240, 247));
        txtUsername.setBorder(null);
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 356, 320, 50));

        txtPassword.setBackground(new java.awt.Color(234, 240, 247));
        txtPassword.setBorder(null);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 462, 320, 50));

        txtRepassword.setBackground(new java.awt.Color(234, 240, 247));
        txtRepassword.setBorder(null);
        getContentPane().add(txtRepassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 568, 320, 50));

        btnGroupStatus.add(RbuttonAdmin);
        RbuttonAdmin.setBorder(null);
        getContentPane().add(RbuttonAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 660, -1, -1));

        btnGroupStatus.add(RbuttonTeknisi);
        RbuttonTeknisi.setBorder(null);
        getContentPane().add(RbuttonTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 660, -1, -1));

        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        getContentPane().add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 171, 36, 40));

        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 546, 120, 20));

        btnDaftar.setBorder(null);
        btnDaftar.setBorderPainted(false);
        btnDaftar.setContentAreaFilled(false);
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 724, 160, 40));

        LabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Register.png"))); // NOI18N
        getContentPane().add(LabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        Login pgLogin = new Login();
        pgLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        Login pgLogin = new Login();
        pgLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLoginMouseClicked
    private String password;
    private String status;
    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        String username = txtUsername.getText();
        String pass = txtPassword.getText();
        String RePass = txtRepassword.getText();
        if (RbuttonAdmin.isSelected()) {
            status = "admin";
        } else if (RbuttonTeknisi.isSelected()) {
            status = "teknisi";
        }
        if (!username.isEmpty() && username.length() <= 12 && !pass.isEmpty() && pass.equals(RePass) && pass.length() <= 12 && status != null) {
            password = HashSandi(pass);
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                if (JOptionPane.showConfirmDialog(null, "Simpan Akun ? \n"
                        + "Username = " + username + "\n"
                        + "Status = " + status, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, user) == JOptionPane.YES_OPTION) {
                    String NoKtp = JOptionPane.showInputDialog(null, "Verivikasi KTP anda");
                    if (!NoKtp.isEmpty() && NoKtp.length() == 16) {
                        String sql = "INSERT INTO akun value('" + username + "', '" + password + "', '" + status + "', '" + NoKtp + "')";
                        st.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Selamat, Registrasi Berhasil !", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                        st.close();
                        Login pgLogin = new Login();
                        pgLogin.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Nomor KTP tidak Valid !", "Peringatan !", JOptionPane.INFORMATION_MESSAGE, error);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan akun ke database !" + e, "Peringatan !", JOptionPane.INFORMATION_MESSAGE, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Isi data dengan benar, data tidak boleh ada yang kosong ! \n"
                    + "Username maksimal 12 Kata \n"
                    + "Password maksimal 12 Kata \n"
                    + "Nilai Sandi dan Ulangi sandi harus bernilai sama", "Peringatan !", JOptionPane.INFORMATION_MESSAGE, error);
        }
    }//GEN-LAST:event_btnDaftarActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBackground;
    private javax.swing.JRadioButton RbuttonAdmin;
    private javax.swing.JRadioButton RbuttonTeknisi;
    private javax.swing.JButton btnDaftar;
    private javax.swing.ButtonGroup btnGroupStatus;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRepassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
