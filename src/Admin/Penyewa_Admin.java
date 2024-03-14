package Admin;

import Login.*;
import Table.TableNoEdit;
import KoneksiDatabase.ClassKoneksi;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Penyewa_Admin extends javax.swing.JFrame {

    public Penyewa_Admin() {
        initComponents();
        TablePenyewa();
    }

    ImageIcon user = new ImageIcon(getClass().getResource("/Images/user.png"));
    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon simpan = new ImageIcon(getClass().getResource("/Images/icon save.png"));
    ImageIcon ubah = new ImageIcon(getClass().getResource("/Images/icon ubah.png"));
    ImageIcon hapus = new ImageIcon(getClass().getResource("/Images/icon delete.png"));
    ImageIcon notFound = new ImageIcon(getClass().getResource("/Images/icon not found.png"));
    ImageIcon keluar = new ImageIcon(getClass().getResource("/Images/icon keluar.png"));

    public static String NoKtpPenyewa(String nomorKtpPenyewa) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select no_ktp_penyewa from penyewa where no_ktp_penyewa = '" + nomorKtpPenyewa + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("no_ktp_penyewa");
        } else {
            throw new SQLException("Data penyewa tidak ditemukan");
        }
    }

    public void TablePenyewa() {
        TableNoEdit tblDBPenyewa = new TableNoEdit();
        tblDBPenyewa.addColumn("No KTP Penyewa");
        tblDBPenyewa.addColumn("Nama Penyewa");
        tblDBPenyewa.addColumn("No Hp");
        tblDBPenyewa.addColumn("Alamat");
        tblPenyewa.setModel(tblDBPenyewa);
        tblPenyewa.getColumnModel().getColumn(0).setPreferredWidth(209);
        tblPenyewa.getColumnModel().getColumn(1).setPreferredWidth(206);
        tblPenyewa.getColumnModel().getColumn(2).setPreferredWidth(209);
        tblPenyewa.getColumnModel().getColumn(3).setPreferredWidth(281);
        tblPenyewa.getTableHeader().setPreferredSize(new Dimension(0, 40));
        tblPenyewa.setOpaque(false);
        tblPenyewa.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblPenyewa.getColumnModel();
        for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
            TableColumn kolom = Modelkolom.getColumn(i);
            kolom.setResizable(false);
        }
        jScrollPanePenyewa.getViewport().setOpaque(false);
        try {
            Connection penghubung = ClassKoneksi.GetConnection();
            Statement st = penghubung.createStatement();
            ResultSet rs = st.executeQuery("select * from penyewa");
            while (rs.next()) {
                tblDBPenyewa.addRow(new Object[]{
                    rs.getString("no_ktp_penyewa"),
                    rs.getString("nama"),
                    rs.getString("no_hp"),
                    rs.getString("alamat")});
                tblPenyewa.setModel(tblDBPenyewa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat mengambil data pada database" + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBeranda = new javax.swing.JLabel();
        lblStok = new javax.swing.JLabel();
        lblTransSewa = new javax.swing.JLabel();
        lblDataPenyewa = new javax.swing.JLabel();
        lblLapPengeluaran = new javax.swing.JLabel();
        lblKeluar = new javax.swing.JLabel();
        txtNoKtp = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtNoHp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextPane();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        lblCari = new javax.swing.JLabel();
        jScrollPanePenyewa = new javax.swing.JScrollPane();
        tblPenyewa = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();
        LblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Penyewa");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBeranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBerandaMouseClicked(evt);
            }
        });
        getContentPane().add(lblBeranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, 320, 60));

        lblStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStokMouseClicked(evt);
            }
        });
        getContentPane().add(lblStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 253, 320, 60));

        lblTransSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTransSewaMouseClicked(evt);
            }
        });
        getContentPane().add(lblTransSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 345, 320, 60));

        lblDataPenyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDataPenyewaMouseClicked(evt);
            }
        });
        getContentPane().add(lblDataPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 427, 320, 60));

        lblLapPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLapPengeluaranMouseClicked(evt);
            }
        });
        getContentPane().add(lblLapPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 506, 320, 60));

        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });
        getContentPane().add(lblKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 950, 120, 50));

        txtNoKtp.setBackground(new java.awt.Color(249, 249, 249));
        txtNoKtp.setBorder(null);
        getContentPane().add(txtNoKtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 110, 230, 25));

        txtNama.setBackground(new java.awt.Color(249, 249, 249));
        txtNama.setBorder(null);
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 150, 230, 25));

        txtNoHp.setBackground(new java.awt.Color(249, 249, 249));
        txtNoHp.setBorder(null);
        getContentPane().add(txtNoHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 190, 180, 25));

        jScrollPane1.setBackground(new java.awt.Color(249, 249, 249));
        jScrollPane1.setBorder(null);

        txtAlamat.setBackground(new java.awt.Color(249, 249, 249));
        txtAlamat.setBorder(null);
        jScrollPane1.setViewportView(txtAlamat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 112, 315, 70));

        btnSimpan.setBorder(null);
        btnSimpan.setBorderPainted(false);
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(947, 204, 100, 25));

        btnUbah.setBorder(null);
        btnUbah.setBorderPainted(false);
        btnUbah.setContentAreaFilled(false);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1088, 204, 100, 25));

        btnHapus.setBorder(null);
        btnHapus.setBorderPainted(false);
        btnHapus.setContentAreaFilled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1229, 204, 100, 25));

        txtCari.setBackground(new java.awt.Color(249, 249, 249));
        txtCari.setText("No KTP atau nama penyewa");
        txtCari.setBorder(null);
        txtCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMouseClicked(evt);
            }
        });
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1122, 256, 180, 25));

        lblCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariMouseClicked(evt);
            }
        });
        getContentPane().add(lblCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1308, 258, 30, 20));

        tblPenyewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPenyewa.setRowHeight(40);
        tblPenyewa.setShowGrid(true);
        tblPenyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPenyewaMouseClicked(evt);
            }
        });
        jScrollPanePenyewa.setViewportView(tblPenyewa);

        getContentPane().add(jScrollPanePenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 290, 912, 560));

        btnKembali.setBorder(null);
        btnKembali.setBorderPainted(false);
        btnKembali.setContentAreaFilled(false);
        btnKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKembaliMouseClicked(evt);
            }
        });
        getContentPane().add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1288, 920, 100, 40));

        LblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Penyewa Admin.png"))); // NOI18N
        getContentPane().add(LblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBerandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBerandaMouseClicked
        HomePage_Admin pgHome = new HomePage_Admin();
        pgHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBerandaMouseClicked

    private void lblStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStokMouseClicked
        Stock_Admin pgStok = new Stock_Admin();
        pgStok.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblStokMouseClicked

    private void lblTransSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransSewaMouseClicked
        Transaksi_Sewa_Admin pgtransSewa = new Transaksi_Sewa_Admin();
        pgtransSewa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblTransSewaMouseClicked

    private void lblDataPenyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDataPenyewaMouseClicked
        Penyewa_Admin pgPenyewa = new Penyewa_Admin();
        pgPenyewa.setVisible(true);
    }//GEN-LAST:event_lblDataPenyewaMouseClicked

    private void lblLapPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLapPengeluaranMouseClicked
        Laporan_Pengeluaran_Admin pgLapPengeluaran = new Laporan_Pengeluaran_Admin();
        pgLapPengeluaran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLapPengeluaranMouseClicked

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar aplikasi ? ", "Konrirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, keluar) == JOptionPane.YES_OPTION) {
            Login pgLogin = new Login();
            pgLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblKeluarMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String no_ktp_penyewa = txtNoKtp.getText();
        String nama_penyewa = txtNama.getText().toLowerCase();
        String no_hp = txtNoHp.getText();
        String Alamat = txtAlamat.getText().toLowerCase();
        if (!no_ktp_penyewa.isEmpty() && no_ktp_penyewa.length() == 16 && !nama_penyewa.isEmpty() && nama_penyewa.matches("[a-zA-Z .]+") && nama_penyewa.length() <= 100 && !no_hp.isEmpty() && no_hp.length() <= 13 && no_hp.length() >= 12 && no_hp.matches("\\d+") && !Alamat.isEmpty()) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String sql = "insert into penyewa value ('" + no_ktp_penyewa + "','" + nama_penyewa + "','" + no_hp + "','" + Alamat + "')";
                if (JOptionPane.showConfirmDialog(null, "Simpan data penyewa ? \n"
                        + "No KTP = " + no_ktp_penyewa + "\n"
                        + "Nama = " + nama_penyewa + "\n"
                        + "No Hp = " + no_hp + "\n"
                        + "Alamat = " + Alamat, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, user) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNama.setText("");
                    txtNoKtp.setText("");
                    txtNoHp.setText("");
                    txtAlamat.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data admin ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TablePenyewa();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String no_ktp_penyewa = txtNoKtp.getText();
        String nama_penyewa = txtNama.getText().toLowerCase();
        String no_hp = txtNoHp.getText();
        String Alamat = txtAlamat.getText().toLowerCase();
        int pilih_baris = tblPenyewa.getSelectedRow();
        if (!no_ktp_penyewa.isEmpty() && no_ktp_penyewa.length() == 16 && !nama_penyewa.isEmpty() && nama_penyewa.matches("[a-zA-Z .]+") && nama_penyewa.length() <= 100 && !no_hp.isEmpty() && no_hp.length() <= 13 && no_hp.length() >= 12 && no_hp.matches("\\d+") && !Alamat.isEmpty()) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String no_ktp = NoKtpPenyewa(tblPenyewa.getValueAt(pilih_baris, 0).toString());
                String sql = "UPDATE penyewa SET no_ktp_penyewa = '" + no_ktp_penyewa + "', nama = '" + nama_penyewa + "', no_hp = '" + no_hp + "', alamat = '" + Alamat + "' WHERE no_ktp_penyewa = '" + no_ktp + "'";
                if (JOptionPane.showConfirmDialog(null, "Simpan perubahan ? \n"
                        + "No KTP = " + no_ktp_penyewa + "\n"
                        + "Nama = " + nama_penyewa + "\n"
                        + "No Hp = " + no_hp + "\n"
                        + "Alamat = " + Alamat, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNama.setText("");
                    txtNoKtp.setText("");
                    txtNoHp.setText("");
                    txtAlamat.setText("");
                } else {
                    txtNoKtp.setText("");
                    txtNama.setText("");
                    txtNoHp.setText("");
                    txtAlamat.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mengubah data penyewa", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Isi data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TablePenyewa();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int pilih_baris = tblPenyewa.getSelectedRow();
        if (pilih_baris != -1) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, hapus) == JOptionPane.YES_OPTION) {
                    String no_ktp = tblPenyewa.getValueAt(pilih_baris, 0).toString();
                    String sql = "delete from penyewa where no_ktp_penyewa = '" + no_ktp + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                } else {
                    txtNoKtp.setText("");
                    txtNama.setText("");
                    txtNoHp.setText("");
                    txtAlamat.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        }
        TablePenyewa();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void lblCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariMouseClicked
        String CariData = txtCari.getText();
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();

            if (!CariData.isEmpty()) {
                String sql = "select * from penyewa where no_ktp_penyewa = '" + CariData + "' OR nama = '" + CariData + "'";
                ResultSet rs = st.executeQuery(sql);
                TableNoEdit tblDBPenyewa = new TableNoEdit();
                tblDBPenyewa.addColumn("No KTP Penyewa");
                tblDBPenyewa.addColumn("Nama Penyewa");
                tblDBPenyewa.addColumn("No Hp");
                tblDBPenyewa.addColumn("Alamat");
                tblPenyewa.setModel(tblDBPenyewa);
                tblPenyewa.getColumnModel().getColumn(0).setPreferredWidth(209);
                tblPenyewa.getColumnModel().getColumn(1).setPreferredWidth(206);
                tblPenyewa.getColumnModel().getColumn(2).setPreferredWidth(209);
                tblPenyewa.getColumnModel().getColumn(3).setPreferredWidth(281);
                tblPenyewa.getTableHeader().setPreferredSize(new Dimension(0, 40));
                tblPenyewa.setOpaque(false);
                tblPenyewa.getTableHeader().setReorderingAllowed(false);
                TableColumnModel Modelkolom = tblPenyewa.getColumnModel();
                for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
                    TableColumn kolom = Modelkolom.getColumn(i);
                    kolom.setResizable(false);
                }
                jScrollPanePenyewa.getViewport().setOpaque(false);
                if (rs.next()) {
                    tblDBPenyewa.addRow(new Object[]{
                        rs.getString("no_ktp_penyewa"),
                        rs.getString("nama"),
                        rs.getString("no_hp"),
                        rs.getString("alamat")});
                    tblPenyewa.setModel(tblDBPenyewa);
                    txtCari.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan !", "Kesalahan", JOptionPane.INFORMATION_MESSAGE, notFound);
                    TablePenyewa();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Masukan No KTP atau nama penyewa", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mencari data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_lblCariMouseClicked

    private void btnKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseClicked

    }//GEN-LAST:event_btnKembaliMouseClicked

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        txtCari.setText("");
    }//GEN-LAST:event_txtCariMouseClicked

    private void tblPenyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPenyewaMouseClicked
        int row = tblPenyewa.rowAtPoint(evt.getPoint());
        if (row >= 0 && row < tblPenyewa.getRowCount()) {
            isiTextFieldPenyewa(row);
        }
    }//GEN-LAST:event_tblPenyewaMouseClicked
    private void isiTextFieldPenyewa(int row) {
        int pilih_baris = tblPenyewa.getSelectedRow();
        if (pilih_baris >= 0) {
            String NoKtpPenyewa = tblPenyewa.getValueAt(pilih_baris, 0).toString();
            String Nama = tblPenyewa.getValueAt(pilih_baris, 1).toString();
            String NoHp = tblPenyewa.getValueAt(pilih_baris, 2).toString();
            String Alamat = tblPenyewa.getValueAt(pilih_baris, 3).toString();
            txtNoKtp.setText(NoKtpPenyewa);
            txtNama.setText(Nama);
            txtNoHp.setText(NoHp);
            txtAlamat.setText(Alamat);
        }
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
            java.util.logging.Logger.getLogger(Penyewa_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penyewa_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penyewa_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penyewa_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penyewa_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblBackground;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPanePenyewa;
    private javax.swing.JLabel lblBeranda;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblDataPenyewa;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblLapPengeluaran;
    private javax.swing.JLabel lblStok;
    private javax.swing.JLabel lblTransSewa;
    private javax.swing.JTable tblPenyewa;
    private javax.swing.JTextPane txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtNoKtp;
    // End of variables declaration//GEN-END:variables
}
