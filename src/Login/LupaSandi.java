package Login;

import KoneksiDatabase.ClassKoneksi;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LupaSandi extends javax.swing.JFrame {

    public LupaSandi() {
        initComponents();
    }

    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon simpan = new ImageIcon(getClass().getResource("/Images/icon save.png"));
    ImageIcon sandi = new ImageIcon(getClass().getResource("/Images/icon lupa password.png"));
    
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

    private static String username(String user) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "SELECT username FROM akun WHERE username = '" + user + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("username");
        } else {
            throw new SQLException("Username salah !");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtSandiBaru = new javax.swing.JPasswordField();
        txtUlangisandi = new javax.swing.JPasswordField();
        btnSimpan = new javax.swing.JButton();
        lblBack = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lupa Sandi");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 650, 280, -1));

        txtUsername.setBackground(new java.awt.Color(234, 240, 247));
        txtUsername.setBorder(null);
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 358, 310, 50));

        txtSandiBaru.setBackground(new java.awt.Color(234, 240, 247));
        txtSandiBaru.setBorder(null);
        getContentPane().add(txtSandiBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 463, 310, 50));

        txtUlangisandi.setBackground(new java.awt.Color(234, 240, 247));
        txtUlangisandi.setBorder(null);
        getContentPane().add(txtUlangisandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 570, 310, 50));

        btnSimpan.setBorder(null);
        btnSimpan.setBorderPainted(false);
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 726, 160, 40));

        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        getContentPane().add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 180, 38, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lupa sandi.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String username = txtUsername.getText();
        String password = txtSandiBaru.getText();
        String RePass = txtUlangisandi.getText();
        try {
            String user = username(username);
            if (!user.isEmpty() && !password.isEmpty()) {
                if (password.equals(RePass)) {
                    Connection koneksi = ClassKoneksi.GetConnection();
                    Statement st = koneksi.createStatement();
                    String pass = HashSandi(password);
                    String sql = "UPDATE akun SET password = '" + pass + "' WHERE username = '" + user + "'";
                    if (JOptionPane.showConfirmDialog(null, "Simpan perubahan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, sandi) == JOptionPane.YES_OPTION) {
                        st.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Sandi berhasil diubah", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                        Login pgLogin = new Login();
                        pgLogin.setVisible(true);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sandi harus sama !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Isi data dengan benar", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Username salah ! ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        Login pgLogin = new Login();
        pgLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBackMouseClicked

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
            java.util.logging.Logger.getLogger(LupaSandi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LupaSandi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LupaSandi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LupaSandi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LupaSandi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JPasswordField txtSandiBaru;
    private javax.swing.JPasswordField txtUlangisandi;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
