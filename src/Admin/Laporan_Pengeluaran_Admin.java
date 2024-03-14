package Admin;

import Login.*;
import Table.TableNoEdit;
import KoneksiDatabase.ClassKoneksi;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Laporan_Pengeluaran_Admin extends javax.swing.JFrame {

    public Laporan_Pengeluaran_Admin() {
        initComponents();
        TableLaporan();
    }

    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon simpan = new ImageIcon(getClass().getResource("/Images/icon save.png"));
    ImageIcon ubah = new ImageIcon(getClass().getResource("/Images/icon ubah.png"));
    ImageIcon notFound = new ImageIcon(getClass().getResource("/Images/icon not found.png"));
    ImageIcon hapus = new ImageIcon(getClass().getResource("/Images/icon delete.png"));
    ImageIcon keluar = new ImageIcon(getClass().getResource("/Images/icon keluar.png"));

    private static String no_ktp_admin(String nama_admin) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select no_ktp_admin from admin where nama = '" + nama_admin + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("no_ktp_admin");
        } else {
            throw new SQLException("Data No KTP Admin tidak ditemukan");
        }
    }

    public static String Admin(String nama) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select nama_admin from laporan_pengeluaran where nama_admin = '" + nama + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("nama_admin");
        } else {
            throw new SQLException("Data admin " + nama + "Tidak ditemukan");
        }
    }

    public void TableLaporan() {
        TableNoEdit tblDBLaporan = new TableNoEdit();
        tblDBLaporan.addColumn("Tanggal");
        tblDBLaporan.addColumn("Nama Admin");
        tblDBLaporan.addColumn("Jumlah Pengeluaran");
        tblDBLaporan.addColumn("Keterangan");
        tblLapPengeluaran.setModel(tblDBLaporan);
        tblLapPengeluaran.getColumnModel().getColumn(0).setPreferredWidth(148);
        tblLapPengeluaran.getColumnModel().getColumn(1).setPreferredWidth(225);
        tblLapPengeluaran.getColumnModel().getColumn(2).setPreferredWidth(241);
        tblLapPengeluaran.getColumnModel().getColumn(3).setPreferredWidth(360);
        tblLapPengeluaran.getTableHeader().setPreferredSize(new Dimension(0, 40));
        tblLapPengeluaran.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblLapPengeluaran.getColumnModel();
        for(int i = 0; i < Modelkolom.getColumnCount(); i++){
            TableColumn kolom = Modelkolom.getColumn(i);
            kolom.setResizable(false);
        }
        jScrollPanetblLapPengeluaran.getViewport().setOpaque(false);
        try {
            Connection penghubung = ClassKoneksi.GetConnection();
            Statement st = penghubung.createStatement();
            ResultSet rs = st.executeQuery("select * from laporan_pengeluaran");
            while (rs.next()) {
                tblDBLaporan.addRow(new Object[]{
                    rs.getString("tanggal"),
                    rs.getString("nama_admin"),
                    rs.getString("jumlah_pengeluaran"),
                    rs.getString("keterangan")});
                tblLapPengeluaran.setModel(tblDBLaporan);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Kesalahan pada tabel Laporan " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStok = new javax.swing.JLabel();
        lblBeranda = new javax.swing.JLabel();
        lblTransSewa = new javax.swing.JLabel();
        lblDTPenyewa = new javax.swing.JLabel();
        lblLapPengeluaran = new javax.swing.JLabel();
        lblKeluar = new javax.swing.JLabel();
        txtNamaAdmin = new javax.swing.JTextField();
        txtJmlPengeluaran = new javax.swing.JTextField();
        Tanggal = new com.toedter.calendar.JDateChooser();
        jScrollPaneTblPengeluaran = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextPane();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        lblCari = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jScrollPanetblLapPengeluaran = new javax.swing.JScrollPane();
        tblLapPengeluaran = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laporan Pengeluaran");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStokMouseClicked(evt);
            }
        });
        getContentPane().add(lblStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 253, 320, 60));

        lblBeranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBerandaMouseClicked(evt);
            }
        });
        getContentPane().add(lblBeranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, 320, 60));

        lblTransSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTransSewaMouseClicked(evt);
            }
        });
        getContentPane().add(lblTransSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 345, 320, 60));

        lblDTPenyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDTPenyewaMouseClicked(evt);
            }
        });
        getContentPane().add(lblDTPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 427, 320, 60));

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

        txtNamaAdmin.setBackground(new java.awt.Color(249, 249, 249));
        txtNamaAdmin.setBorder(null);
        getContentPane().add(txtNamaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 126, 140, 25));

        txtJmlPengeluaran.setBackground(new java.awt.Color(249, 249, 249));
        txtJmlPengeluaran.setBorder(null);
        getContentPane().add(txtJmlPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 164, 140, 25));

        Tanggal.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 200, 170, 25));

        jScrollPaneTblPengeluaran.setBackground(new java.awt.Color(249, 249, 249));
        jScrollPaneTblPengeluaran.setBorder(null);

        txtKeterangan.setBackground(new java.awt.Color(249, 249, 249));
        txtKeterangan.setBorder(null);
        jScrollPaneTblPengeluaran.setViewportView(txtKeterangan);

        getContentPane().add(jScrollPaneTblPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 132, 175, 85));

        btnSimpan.setBorder(null);
        btnSimpan.setBorderPainted(false);
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1139, 125, 90, 25));

        btnUbah.setBorder(null);
        btnUbah.setBorderPainted(false);
        btnUbah.setContentAreaFilled(false);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1139, 164, 90, 25));

        btnHapus.setBorder(null);
        btnHapus.setBorderPainted(false);
        btnHapus.setContentAreaFilled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 126, 90, 25));

        txtCari.setBackground(new java.awt.Color(249, 249, 249));
        txtCari.setBorder(null);
        txtCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMouseClicked(evt);
            }
        });
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1152, 214, 180, 25));

        lblCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariMouseClicked(evt);
            }
        });
        getContentPane().add(lblCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1338, 215, 30, 22));

        btnKembali.setBackground(new java.awt.Color(249, 249, 249));
        btnKembali.setBorder(null);
        btnKembali.setBorderPainted(false);
        btnKembali.setContentAreaFilled(false);
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1281, 956, 95, 40));

        tblLapPengeluaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLapPengeluaran.setOpaque(false);
        tblLapPengeluaran.setRowHeight(40);
        tblLapPengeluaran.setShowGrid(true);
        tblLapPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLapPengeluaranMouseClicked(evt);
            }
        });
        jScrollPanetblLapPengeluaran.setViewportView(tblLapPengeluaran);

        getContentPane().add(jScrollPanetblLapPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 970, 660));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Laporan Admin.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed

    }//GEN-LAST:event_btnKembaliActionPerformed

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

    private void lblDTPenyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDTPenyewaMouseClicked
        Penyewa_Admin pgPenyewa = new Penyewa_Admin();
        pgPenyewa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblDTPenyewaMouseClicked

    private void lblLapPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLapPengeluaranMouseClicked

    }//GEN-LAST:event_lblLapPengeluaranMouseClicked

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar aplikasi ? ", "Konrirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, keluar) == JOptionPane.YES_OPTION) {
            Login pgLogin = new Login();
            pgLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblKeluarMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String nama_admin = txtNamaAdmin.getText().toLowerCase();
        int JmlPengeluaran = Integer.parseInt(txtJmlPengeluaran.getText());
        String keterangan = txtKeterangan.getText().toLowerCase();
        Date AmbilTanggal = Tanggal.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = dateFormat.format(AmbilTanggal);
        if (nama_admin != null && JmlPengeluaran != 0 && keterangan != null && !keterangan.isEmpty() && keterangan.matches("[a-zA-Z ,]+") && tanggal != null) {
            try {
                String No_Ktp_Admin = no_ktp_admin(nama_admin);
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String sql = "INSERT INTO laporan_pengeluaran VALUES ('" + tanggal + "', '" + nama_admin + "', '" + JmlPengeluaran + "', '" + keterangan + "','" + No_Ktp_Admin + "')";
                if (JOptionPane.showConfirmDialog(null, "Simpan Laporan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNamaAdmin.setText("");
                    txtJmlPengeluaran.setText("");
                    txtKeterangan.setText("");
                    Tanggal.setDate(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menambahkan transaksi ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TableLaporan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String nama_admin = txtNamaAdmin.getText().toLowerCase();
        int JmlPengeluaran = Integer.parseInt(txtJmlPengeluaran.getText());
        String keterangan = txtKeterangan.getText().toLowerCase();
        Date AmbilTanggal = Tanggal.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = dateFormat.format(AmbilTanggal);
        int pilih_baris = tblLapPengeluaran.getSelectedRow();
        if (nama_admin != null && JmlPengeluaran != 0 && keterangan != null && !keterangan.isEmpty() && keterangan.matches("[a-zA-Z ,]+") && tanggal != null) {
            try {
                String AmbilTglLap = tblLapPengeluaran.getValueAt(pilih_baris, 0).toString();
                String No_Ktp_Admin = no_ktp_admin(nama_admin);
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String sql = "UPDATE laporan_pengeluaran SET tanggal = '" + tanggal + "', nama_admin = '" + nama_admin + "', jumlah_pengeluaran = '" + JmlPengeluaran + "', keterangan = '" + keterangan + "', no_ktp_admin = '" + No_Ktp_Admin + "' WHERE tanggal = '" + AmbilTglLap + "'";
                if (JOptionPane.showConfirmDialog(null, "Simpan perubahan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNamaAdmin.setText("");
                    txtJmlPengeluaran.setText("");
                    txtKeterangan.setText("");
                    Tanggal.setDate(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mengubah data transaksi ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TableLaporan();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int pilih_baris = tblLapPengeluaran.getSelectedRow();
        String tanggal = tblLapPengeluaran.getValueAt(pilih_baris, 0).toString();
        String keterangan = tblLapPengeluaran.getValueAt(pilih_baris, 3).toString();
        if (pilih_baris != -1) {
            if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus laporan?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, hapus) == JOptionPane.YES_OPTION) {
                try {
                    String sql = "delete from laporan_pengeluaran where tanggal = '" + tanggal + "' AND keterangan = '" + keterangan + "'";
                    Connection koneksi = ClassKoneksi.GetConnection();
                    Statement st = koneksi.createStatement();
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Laporan berhasil dihapus", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus laporan ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
                }
            }
        }
        TableLaporan();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void lblCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariMouseClicked
        String cariLaporan = txtCari.getText();
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            String sql = "select * from laporan_pengeluaran where tanggal = '" + cariLaporan + "'";
            ResultSet rs = st.executeQuery(sql);
            TableNoEdit tblDBLaporan = new TableNoEdit();
            tblDBLaporan.addColumn("Tanggal");
            tblDBLaporan.addColumn("Nama Admin");
            tblDBLaporan.addColumn("Jumlah Pengeluaran");
            tblDBLaporan.addColumn("Keterangan");
            tblLapPengeluaran.setModel(tblDBLaporan);
            tblLapPengeluaran.getColumnModel().getColumn(0).setPreferredWidth(148);
            tblLapPengeluaran.getColumnModel().getColumn(1).setPreferredWidth(225);
            tblLapPengeluaran.getColumnModel().getColumn(2).setPreferredWidth(241);
            tblLapPengeluaran.getColumnModel().getColumn(3).setPreferredWidth(360);
            tblLapPengeluaran.getTableHeader().setPreferredSize(new Dimension(0, 40));
            tblLapPengeluaran.setOpaque(false);
            tblLapPengeluaran.getTableHeader().setReorderingAllowed(false);
            TableColumnModel Modelkolom = tblLapPengeluaran.getColumnModel();
            for(int i = 0; i < Modelkolom.getColumnCount(); i++){
                TableColumn kolom = Modelkolom.getColumn(i);
                kolom.setResizable(false);
            }
            jScrollPaneTblPengeluaran.getViewport().setOpaque(false);
            if (rs.next()) {
                tblDBLaporan.addRow(new Object[]{
                    rs.getString("tanggal"),
                    rs.getString("nama_admin"),
                    rs.getString("jumlah_pengeluaran"),
                    rs.getString("keterangan")});
                tblLapPengeluaran.setModel(tblDBLaporan);
            } else {
                JOptionPane.showMessageDialog(null, "Data laporan tidak ditemukan !", "Kesalahan", JOptionPane.INFORMATION_MESSAGE, notFound);
                TableLaporan();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mencari data laporan ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }

    }//GEN-LAST:event_lblCariMouseClicked

    private void tblLapPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLapPengeluaranMouseClicked
        int row = tblLapPengeluaran.rowAtPoint(evt.getPoint());
        if (row >= 0 && row < tblLapPengeluaran.getRowCount()) {
            isiTextFieldLaporan(row);
        }
    }//GEN-LAST:event_tblLapPengeluaranMouseClicked

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        txtCari.setText("");
    }//GEN-LAST:event_txtCariMouseClicked

    private void isiTextFieldLaporan(int row) {
        int pilih_baris = tblLapPengeluaran.getSelectedRow();
        if (pilih_baris >= 0) {
            try {
                String TanggalLap = tblLapPengeluaran.getValueAt(pilih_baris, 0).toString();
                String NamaAdmn = tblLapPengeluaran.getValueAt(pilih_baris, 1).toString();
                String Jumlah = tblLapPengeluaran.getValueAt(pilih_baris, 2).toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date TanggalLapor = dateFormat.parse(TanggalLap);
                String Keterangan = tblLapPengeluaran.getValueAt(pilih_baris, 3).toString();
                txtNamaAdmin.setText(NamaAdmn);
                txtJmlPengeluaran.setText(Jumlah);
                Tanggal.setDate(TanggalLapor);
                txtKeterangan.setText(Keterangan);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mengambil data " + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
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
            java.util.logging.Logger.getLogger(Laporan_Pengeluaran_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_Pengeluaran_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_Pengeluaran_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_Pengeluaran_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_Pengeluaran_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Tanggal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPaneTblPengeluaran;
    private javax.swing.JScrollPane jScrollPanetblLapPengeluaran;
    private javax.swing.JLabel lblBeranda;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblDTPenyewa;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblLapPengeluaran;
    private javax.swing.JLabel lblStok;
    private javax.swing.JLabel lblTransSewa;
    private javax.swing.JTable tblLapPengeluaran;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJmlPengeluaran;
    private javax.swing.JTextPane txtKeterangan;
    private javax.swing.JTextField txtNamaAdmin;
    // End of variables declaration//GEN-END:variables
}
