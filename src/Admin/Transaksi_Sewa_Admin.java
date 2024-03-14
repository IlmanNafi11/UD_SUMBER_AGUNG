package Admin;

import Login.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import KoneksiDatabase.ClassKoneksi;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import Table.TableNoEdit;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Transaksi_Sewa_Admin extends javax.swing.JFrame {

    public Transaksi_Sewa_Admin() {
        initComponents();
        tabelTransSewa();
    }

    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon simpan = new ImageIcon(getClass().getResource("/Images/icon save.png"));
    ImageIcon ubah = new ImageIcon(getClass().getResource("/Images/icon ubah.png"));
    ImageIcon hapus = new ImageIcon(getClass().getResource("/Images/icon delete.png"));
    ImageIcon notFound = new ImageIcon(getClass().getResource("/Images/icon not found.png"));
    ImageIcon keluar = new ImageIcon(getClass().getResource("/Images/icon keluar.png"));

    private static int Harga(String nama_alat) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select harga_sewa from alat where nama_alat ='" + nama_alat + "' ";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getInt("harga_sewa");
        } else {
            throw new SQLException("Data Alat tidak ditemukan");
        }
    }

    private static String Admin(String nama) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select no_ktp_admin from admin where nama = '" + nama + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("no_ktp_admin");
        } else {
            throw new SQLException("Data admin tidak ditemukan");
        }
    }

    private static String id_alat(String nama_alat) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select id_alat from alat where nama_alat ='" + nama_alat + "' ";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("id_alat");
        } else {
            throw new SQLException("Data id tidak ditemukan");
        }
    }

    private static String id_transaksi(String id) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select id_transaksi from transaksi_menyewa where id_transaksi = '" + id + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("id_transaksi");
        } else {
            throw new SQLException("Data transaksi tidak ditemukan");
        }
    }

    private static String ktpOwner() throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select * from owner";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("ktp_owner");
        } else {
            throw new SQLException("KTP owner tidak ditemukan");
        }
    }

    private static String KtpPenyewa(String noKtp) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select no_ktp_penyewa from penyewa where no_ktp_penyewa = '" + noKtp + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("no_ktp_penyewa");
        } else {
            throw new SQLException("No KTP Penyewa tidak terdaftar");
        }
    }

    public void tabelTransSewa() {
        TableNoEdit tblDBTransSewa = new TableNoEdit();
        tblDBTransSewa.addColumn("ID Transaksi");
        tblDBTransSewa.addColumn("Nama Alat");
        tblDBTransSewa.addColumn("Awal Sewa");
        tblDBTransSewa.addColumn("Akhir Sewa");
        tblDBTransSewa.addColumn("Jml");
        tblDBTransSewa.addColumn("No KTP Penyewa");
        tblDBTransSewa.addColumn("Nama Admin");
        tblDBTransSewa.addColumn("Biaya Sewa");
        tblTransSewa.setModel(tblDBTransSewa);
        tblTransSewa.getColumnModel().getColumn(0).setPreferredWidth(112);
        tblTransSewa.getColumnModel().getColumn(1).setPreferredWidth(124);
        tblTransSewa.getColumnModel().getColumn(2).setPreferredWidth(123);
        tblTransSewa.getColumnModel().getColumn(3).setPreferredWidth(123);
        tblTransSewa.getColumnModel().getColumn(4).setPreferredWidth(61);
        tblTransSewa.getColumnModel().getColumn(5).setPreferredWidth(156);
        tblTransSewa.getColumnModel().getColumn(6).setPreferredWidth(153);
        tblTransSewa.getColumnModel().getColumn(7).setPreferredWidth(170);
        tblTransSewa.getTableHeader().setPreferredSize(new Dimension(0, 40));
        tblTransSewa.setOpaque(false);
        tblTransSewa.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblTransSewa.getColumnModel();
        for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
            TableColumn kolom = Modelkolom.getColumn(i);
            kolom.setResizable(false);
        }
        jScrollPaneTransSewa.getViewport().setOpaque(false);
        try {
            Connection penghubung = ClassKoneksi.GetConnection();
            Statement st = penghubung.createStatement();
            ResultSet rs = st.executeQuery("select * from transaksi_menyewa");
            while (rs.next()) {
                tblDBTransSewa.addRow(new Object[]{
                    rs.getString("id_transaksi"),
                    rs.getString("nama_alat"),
                    rs.getString("awal_sewa"),
                    rs.getString("akhir_sewa"),
                    rs.getString("jumlah"),
                    rs.getString("no_ktp_penyewa"),
                    rs.getString("nama_admin"),
                    rs.getString("biaya_sewa"),});
                tblTransSewa.setModel(tblDBTransSewa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat mengambil data pada database" + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHome = new javax.swing.JLabel();
        lblStok = new javax.swing.JLabel();
        LblTransSewa = new javax.swing.JLabel();
        lblDTPenyewa = new javax.swing.JLabel();
        lblLapPengeluaran = new javax.swing.JLabel();
        lblKeluar = new javax.swing.JLabel();
        txtNamaAlat = new javax.swing.JTextField();
        TanggalAwal = new com.toedter.calendar.JDateChooser();
        TanggalAkhir = new com.toedter.calendar.JDateChooser();
        txtJmlSewa = new javax.swing.JTextField();
        txtNamaAdmin = new javax.swing.JTextField();
        txtNoktpPenyewa = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCariTransSewa = new javax.swing.JTextField();
        lblCari = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jScrollPaneTransSewa = new javax.swing.JScrollPane();
        tblTransSewa = new javax.swing.JTable();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaksi Sewa");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        getContentPane().add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, 320, 60));

        lblStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStokMouseClicked(evt);
            }
        });
        getContentPane().add(lblStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 320, 60));

        LblTransSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblTransSewaMouseClicked(evt);
            }
        });
        getContentPane().add(LblTransSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 345, 320, 60));

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
        getContentPane().add(lblKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 948, 120, 50));

        txtNamaAlat.setBorder(null);
        getContentPane().add(txtNamaAlat, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 156, 149, 25));

        TanggalAwal.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TanggalAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 197, 170, 25));

        TanggalAkhir.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TanggalAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 238, 170, 25));

        txtJmlSewa.setBorder(null);
        getContentPane().add(txtJmlSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 156, 180, 25));

        txtNamaAdmin.setBorder(null);
        getContentPane().add(txtNamaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 197, 180, 25));

        txtNoktpPenyewa.setBorder(null);
        getContentPane().add(txtNoktpPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 238, 180, 25));

        btnSimpan.setBorder(null);
        btnSimpan.setBorderPainted(false);
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(971, 282, 78, 25));

        btnUbah.setToolTipText("");
        btnUbah.setBorder(null);
        btnUbah.setBorderPainted(false);
        btnUbah.setContentAreaFilled(false);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1083, 282, 78, 25));

        btnHapus.setBorder(null);
        btnHapus.setBorderPainted(false);
        btnHapus.setContentAreaFilled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1193, 282, 78, 25));

        txtCariTransSewa.setText("Tanggal Awal sewa");
        txtCariTransSewa.setBorder(null);
        txtCariTransSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariTransSewaMouseClicked(evt);
            }
        });
        getContentPane().add(txtCariTransSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1233, 326, 125, 25));

        lblCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariMouseClicked(evt);
            }
        });
        getContentPane().add(lblCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 327, 30, 23));

        btnKembali.setBorder(null);
        btnKembali.setBorderPainted(false);
        btnKembali.setContentAreaFilled(false);
        getContentPane().add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1279, 956, 100, 40));

        tblTransSewa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTransSewa.setGridColor(new java.awt.Color(34, 170, 170));
        tblTransSewa.setRowHeight(40);
        tblTransSewa.setShowGrid(true);
        tblTransSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransSewaMouseClicked(evt);
            }
        });
        jScrollPaneTransSewa.setViewportView(tblTransSewa);

        getContentPane().add(jScrollPaneTransSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 1020, 520));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Transaksi Sewa admin.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        HomePage_Admin pgHome = new HomePage_Admin();
        pgHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStokMouseClicked
        Stock_Admin pgStok = new Stock_Admin();
        pgStok.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblStokMouseClicked

    private void LblTransSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblTransSewaMouseClicked

    }//GEN-LAST:event_LblTransSewaMouseClicked

    private void lblDTPenyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDTPenyewaMouseClicked
        Penyewa_Admin pgPenyewa = new Penyewa_Admin();
        pgPenyewa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblDTPenyewaMouseClicked

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
    private long biaya_sewa;
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String nama_alat = txtNamaAlat.getText().toLowerCase();
        String nama_admin = txtNamaAdmin.getText().toLowerCase();
        String no_ktp_penyewa = txtNoktpPenyewa.getText();
        int jumlah_sewa = Integer.parseInt(txtJmlSewa.getText());
        Date Ambil_Awal_Sewa = TanggalAwal.getDate();
        Date Ambil_Akhir_Sewa = TanggalAkhir.getDate();
        long lama_sewa = (Ambil_Akhir_Sewa.getTime() - Ambil_Awal_Sewa.getTime()) / (24 * 60 * 60 * 1000);
        try {
            int harga = Harga(nama_alat);
            String id_alat = id_alat(nama_alat);
            String no_ktp_admin = Admin(nama_admin);
            String ktp_owner = ktpOwner();
            String ktp_Penyewa = KtpPenyewa(no_ktp_penyewa);
            biaya_sewa = jumlah_sewa * harga * lama_sewa;
            if (TanggalAwal != null && TanggalAkhir != null && !nama_alat.isEmpty() && !nama_admin.isEmpty() && !no_ktp_penyewa.isEmpty() && jumlah_sewa <= 100) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String awal_Sewa = dateFormat.format(Ambil_Awal_Sewa);
                String akhir_Sewa = dateFormat.format(Ambil_Akhir_Sewa);
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String sql = "INSERT INTO transaksi_menyewa VALUES (NULL,'" + nama_alat + "', '" + awal_Sewa + "', '" + akhir_Sewa + "', '" + jumlah_sewa + "', '" + ktp_Penyewa + "', '" + nama_admin + "', '" + biaya_sewa + "', '" + no_ktp_admin + "', '" + id_alat + "', '" + lama_sewa + "','" + ktp_owner + "')";
                if (JOptionPane.showConfirmDialog(null, "Simpan transaksi menyewa ? \nSilahkan cek kembali, pastikan data di isi dengan benar ! \n"
                        + "No KTP Penyewa = " + no_ktp_penyewa + "\n"
                        + "Alat yang di sewa = " + nama_alat + "\n"
                        + "Mulai menyewa pada = " + awal_Sewa + "\n"
                        + "Lama menyewa = " + lama_sewa + "\n"
                        + "Berakhir pada = " + akhir_Sewa + "\n"
                        + "Biaya Sewa = " + biaya_sewa, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Transaksi berhasil !", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNamaAlat.setText("");
                    txtNamaAdmin.setText("");
                    txtNoktpPenyewa.setText("");
                    txtJmlSewa.setText("");
                    TanggalAkhir.setDate(null);
                    TanggalAwal.setDate(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Transaksi Gagal", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        tabelTransSewa();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String nama_alat = txtNamaAlat.getText().toLowerCase();
        String nama_admin = txtNamaAdmin.getText().toLowerCase();
        String no_ktp_penyewa = txtNoktpPenyewa.getText();
        int jumlah_sewa = Integer.parseInt(txtJmlSewa.getText());
        Date Ambil_Awal_Sewa = TanggalAwal.getDate();
        Date Ambil_Akhir_Sewa = TanggalAkhir.getDate();
        int pilih_baris = tblTransSewa.getSelectedRow();
        try {
            int harga = Harga(nama_alat);
            String id_alat = id_alat(nama_alat);
            String ktp_owner = ktpOwner();
            String ktp_Penyewa = KtpPenyewa(no_ktp_penyewa);
            String id_transaksi = id_transaksi(tblTransSewa.getValueAt(pilih_baris, 0).toString());
            long lama_sewa = (Ambil_Akhir_Sewa.getTime() - Ambil_Awal_Sewa.getTime()) / (24 * 60 * 60 * 1000);
            biaya_sewa = jumlah_sewa * harga * lama_sewa;
            if (TanggalAwal != null && TanggalAkhir != null && !nama_alat.isEmpty() && !nama_admin.isEmpty() && !no_ktp_penyewa.isEmpty() && jumlah_sewa <= 100) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String awal_Sewa = dateFormat.format(Ambil_Awal_Sewa);
                String akhir_Sewa = dateFormat.format(Ambil_Akhir_Sewa);
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String sql = "UPDATE transaksi_menyewa SET nama_alat = '" + nama_alat + "', awal_sewa = '" + awal_Sewa + "', akhir_sewa = '" + akhir_Sewa + "', jumlah = '" + jumlah_sewa + "', no_ktp_penyewa = '" + ktp_Penyewa + "', nama_admin = '" + nama_admin + "', biaya_sewa = '" + biaya_sewa + "', id_alat = '" + id_alat + "', ktp_owner = '" + ktp_owner + "' WHERE id_transaksi = '" + id_transaksi + "'";
                if (JOptionPane.showConfirmDialog(null, "Simpan perubahan ? \n"
                        + "No KTP Penyewa = " + no_ktp_penyewa + "\n"
                        + "Alat yang di sewa = " + nama_alat + "\n"
                        + "Mulai menyewa pada = " + awal_Sewa + "\n"
                        + "Lama menyewa = " + lama_sewa + "\n"
                        + "Berakhir pada = " + akhir_Sewa + "\n"
                        + "Biaya Sewa = " + biaya_sewa, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNamaAlat.setText("");
                    txtNamaAdmin.setText("");
                    txtNoktpPenyewa.setText("");
                    txtJmlSewa.setText("");
                    TanggalAkhir.setDate(null);
                    TanggalAwal.setDate(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal saat mencoba mengubah data transaksi ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        tabelTransSewa();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int pilih_baris = tblTransSewa.getSelectedRow();
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            if (pilih_baris != -1) {
                if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus transaksi?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, hapus) == JOptionPane.YES_OPTION) {
                    String id_transaksi = tblTransSewa.getValueAt(pilih_baris, 0).toString();
                    String sql = "delete from transaksi_menyewa where id_transaksi = '" + id_transaksi + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Transaksi berhasil dihapus", "Sukses !", JOptionPane.INFORMATION_MESSAGE, hapus);
                    st.close();
                } else {
                    txtNamaAlat.setText("");
                    txtNamaAdmin.setText("");
                    txtNoktpPenyewa.setText("");
                    txtJmlSewa.setText("");
                    TanggalAkhir.setDate(null);
                    TanggalAwal.setDate(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        tabelTransSewa();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void lblCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariMouseClicked
        try {
            String CariTransaksi = txtCariTransSewa.getText();
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            if (!CariTransaksi.isEmpty()) {
                ResultSet rs = st.executeQuery("SELECT * FROM transaksi_menyewa WHERE awal_sewa = '"+CariTransaksi+"'");
                TableNoEdit tblDBTransSewa = new TableNoEdit();
                tblDBTransSewa.addColumn("ID Transaksi");
                tblDBTransSewa.addColumn("Nama Alat");
                tblDBTransSewa.addColumn("Awal Sewa");
                tblDBTransSewa.addColumn("Akhir Sewa");
                tblDBTransSewa.addColumn("Jml");
                tblDBTransSewa.addColumn("No KTP Penyewa");
                tblDBTransSewa.addColumn("Nama Admin");
                tblDBTransSewa.addColumn("Biaya Sewa");
                tblTransSewa.setModel(tblDBTransSewa);
                tblTransSewa.getColumnModel().getColumn(0).setPreferredWidth(112);
                tblTransSewa.getColumnModel().getColumn(1).setPreferredWidth(124);
                tblTransSewa.getColumnModel().getColumn(2).setPreferredWidth(123);
                tblTransSewa.getColumnModel().getColumn(3).setPreferredWidth(123);
                tblTransSewa.getColumnModel().getColumn(4).setPreferredWidth(61);
                tblTransSewa.getColumnModel().getColumn(5).setPreferredWidth(156);
                tblTransSewa.getColumnModel().getColumn(6).setPreferredWidth(153);
                tblTransSewa.getColumnModel().getColumn(7).setPreferredWidth(170);
                tblTransSewa.getTableHeader().setPreferredSize(new Dimension(0, 40));
                tblTransSewa.setOpaque(false);
                tblTransSewa.getTableHeader().setReorderingAllowed(false);
                TableColumnModel Modelkolom = tblTransSewa.getColumnModel();
                for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
                    TableColumn kolom = Modelkolom.getColumn(i);
                    kolom.setResizable(false);
                }
                jScrollPaneTransSewa.getViewport().setOpaque(false);
                if (rs.next()) {
                    tblDBTransSewa.addRow(new Object[]{
                        rs.getString("id_transaksi"),
                        rs.getString("nama_alat"),
                        rs.getString("awal_sewa"),
                        rs.getString("akhir_sewa"),
                        rs.getString("jumlah"),
                        rs.getString("no_ktp_penyewa"),
                        rs.getString("nama_admin"),
                        rs.getString("biaya_sewa"),});
                    tblTransSewa.setModel(tblDBTransSewa);
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan !", "Kesalahan", JOptionPane.INFORMATION_MESSAGE, notFound);
                    tabelTransSewa();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Masukan tanggal awal sewa", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mencari data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_lblCariMouseClicked

    private void txtCariTransSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariTransSewaMouseClicked
        txtCariTransSewa.setText("");
    }//GEN-LAST:event_txtCariTransSewaMouseClicked

    private void tblTransSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransSewaMouseClicked
        int row = tblTransSewa.rowAtPoint(evt.getPoint());
        if (row >= 0 && row < tblTransSewa.getRowCount()) {
            isiTextFieldTransSewa(row);
        }
    }//GEN-LAST:event_tblTransSewaMouseClicked
    private void isiTextFieldTransSewa(int row) {
        int pilih_baris = tblTransSewa.getSelectedRow();
        if (pilih_baris >= 0) {
            try {
                String NamaAlat = tblTransSewa.getValueAt(pilih_baris, 1).toString();
                String AwalSewa = tblTransSewa.getValueAt(pilih_baris, 2).toString();
                String AkhirSewa = tblTransSewa.getValueAt(pilih_baris, 3).toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date tanggalAwal = dateFormat.parse(AwalSewa);
                Date tanggalAkhir = dateFormat.parse(AkhirSewa);
                String Jumlah = tblTransSewa.getValueAt(pilih_baris, 4).toString();
                String KtpPenyewa = tblTransSewa.getValueAt(pilih_baris, 5).toString();
                String DataAdmin = tblTransSewa.getValueAt(pilih_baris, 6).toString();
                txtNamaAlat.setText(NamaAlat);
                TanggalAwal.setDate(tanggalAwal);
                TanggalAkhir.setDate(tanggalAkhir);
                txtNamaAdmin.setText(DataAdmin);
                txtJmlSewa.setText(Jumlah);
                txtNoktpPenyewa.setText(KtpPenyewa);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mengambil data " + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
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
            java.util.logging.Logger.getLogger(Transaksi_Sewa_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Sewa_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Sewa_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Sewa_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi_Sewa_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblTransSewa;
    private com.toedter.calendar.JDateChooser TanggalAkhir;
    private com.toedter.calendar.JDateChooser TanggalAwal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JScrollPane jScrollPaneTransSewa;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblDTPenyewa;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblLapPengeluaran;
    private javax.swing.JLabel lblStok;
    private javax.swing.JTable tblTransSewa;
    private javax.swing.JTextField txtCariTransSewa;
    private javax.swing.JTextField txtJmlSewa;
    private javax.swing.JTextField txtNamaAdmin;
    private javax.swing.JTextField txtNamaAlat;
    private javax.swing.JTextField txtNoktpPenyewa;
    // End of variables declaration//GEN-END:variables
}
