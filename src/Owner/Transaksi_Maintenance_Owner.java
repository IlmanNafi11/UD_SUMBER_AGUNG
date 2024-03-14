package Owner;

import Login.*;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Table.TableNoEdit;
import KoneksiDatabase.ClassKoneksi;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Transaksi_Maintenance_Owner extends javax.swing.JFrame {

    public Transaksi_Maintenance_Owner() {
        initComponents();
        tabelTransMainten();
    }

    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon simpan = new ImageIcon(getClass().getResource("/Images/icon save.png"));
    ImageIcon ubah = new ImageIcon(getClass().getResource("/Images/icon ubah.png"));
    ImageIcon hapus = new ImageIcon(getClass().getResource("/Images/icon delete.png"));
    ImageIcon notFound = new ImageIcon(getClass().getResource("/Images/icon not found.png"));
    ImageIcon keluar = new ImageIcon(getClass().getResource("/Images/icon keluar.png"));

    private static String id_perawatan(String id) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select id_perawatan from perawatan where id_perawatan = '" + id + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("id_perawatan");
        } else {
            throw new SQLException("Data perawatan tidak ditemukan");
        }
    }

    public void tabelTransMainten() {
        TableNoEdit tblDBTransMainten = new TableNoEdit();
        tblDBTransMainten.addColumn("ID Perawatan");
        tblDBTransMainten.addColumn("Nama Alat");
        tblDBTransMainten.addColumn("Jml");
        tblDBTransMainten.addColumn("Tanggal");
        tblDBTransMainten.addColumn("Nama Teknisi");
        tblDBTransMainten.addColumn("Nama Admin");
        tblDBTransMainten.addColumn("Keterangan");
        tblDBTransMainten.addColumn("Biaya Perawatan");
        tblTransPerawatan.setModel(tblDBTransMainten);
        tblTransPerawatan.getColumnModel().getColumn(0).setPreferredWidth(92);
        tblTransPerawatan.getColumnModel().getColumn(1).setPreferredWidth(124);
        tblTransPerawatan.getColumnModel().getColumn(2).setPreferredWidth(61);
        tblTransPerawatan.getColumnModel().getColumn(3).setPreferredWidth(164);
        tblTransPerawatan.getColumnModel().getColumn(4).setPreferredWidth(125);
        tblTransPerawatan.getColumnModel().getColumn(5).setPreferredWidth(123);
        tblTransPerawatan.getColumnModel().getColumn(6).setPreferredWidth(177);
        tblTransPerawatan.getColumnModel().getColumn(7).setPreferredWidth(155);
        tblTransPerawatan.getTableHeader().setPreferredSize(new Dimension(0, 40));
        tblTransPerawatan.setOpaque(false);
        tblTransPerawatan.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblTransPerawatan.getColumnModel();
        for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
            TableColumn kolom = Modelkolom.getColumn(i);
            kolom.setResizable(false);
        }
        jScrollPaneTblTransMainten.getViewport().setOpaque(false);
        try {
            Connection penghubung = ClassKoneksi.GetConnection();
            Statement st = penghubung.createStatement();
            ResultSet rs = st.executeQuery("select * from perawatan");
            while (rs.next()) {
                tblDBTransMainten.addRow(new Object[]{
                    rs.getString("id_perawatan"),
                    rs.getString("nama_alat"),
                    rs.getString("jumlah"),
                    rs.getString("tanggal"),
                    rs.getString("nama_teknisi"),
                    rs.getString("nama_admin"),
                    rs.getString("keterangan"),
                    rs.getString("biaya_perawatan"),});
                tblTransPerawatan.setModel(tblDBTransMainten);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat mengambil data pada database" + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    private static String no_ktp_teknisi(String nama_teknisi) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select no_ktp_teknisi from teknisi where nama_teknisi = '" + nama_teknisi + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("no_ktp_teknisi");
        } else {
            throw new SQLException("Data No KTP Teknisi tidak ditemukan");
        }
    }

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

    private static String id_alat(String nama_alat) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select id_alat from alat where nama_alat ='" + nama_alat + "' ";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("id_alat");
        } else {
            throw new SQLException("Data Alat tidak ditemukan");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNamaAlat = new javax.swing.JTextField();
        txtJmlAlat = new javax.swing.JTextField();
        txtBiaya = new javax.swing.JTextField();
        Tanggal = new com.toedter.calendar.JDateChooser();
        txtNamaTeknisi = new javax.swing.JTextField();
        txtNamaAdmin = new javax.swing.JTextField();
        txtKeterangan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        lblCari = new javax.swing.JLabel();
        jScrollPaneTblTransMainten = new javax.swing.JScrollPane();
        tblTransPerawatan = new javax.swing.JTable();
        lblKeluar = new javax.swing.JLabel();
        lblBeranda = new javax.swing.JLabel();
        lblPageStok = new javax.swing.JLabel();
        lblPageTransSewa = new javax.swing.JLabel();
        lblPermintaanMainten = new javax.swing.JLabel();
        lblTransPerawatan = new javax.swing.JLabel();
        lblDataPegawai = new javax.swing.JLabel();
        lblDataPenyewa = new javax.swing.JLabel();
        lblLaporanPengeluaran = new javax.swing.JLabel();
        lblLaporanAkhir = new javax.swing.JLabel();
        LblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaksi Perawatan");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNamaAlat.setBorder(null);
        getContentPane().add(txtNamaAlat, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 148, 180, 25));

        txtJmlAlat.setBorder(null);
        getContentPane().add(txtJmlAlat, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 187, 180, 25));

        txtBiaya.setBorder(null);
        getContentPane().add(txtBiaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 265, 180, 25));

        Tanggal.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 226, 200, 25));

        txtNamaTeknisi.setBorder(null);
        getContentPane().add(txtNamaTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 144, 210, 25));

        txtNamaAdmin.setBorder(null);
        getContentPane().add(txtNamaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 183, 210, 25));

        txtKeterangan.setBorder(null);
        getContentPane().add(txtKeterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 222, 210, 25));

        btnSimpan.setBorder(null);
        btnSimpan.setBorderPainted(false);
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 271, 90, 26));

        btnUbah.setBorder(null);
        btnUbah.setBorderPainted(false);
        btnUbah.setContentAreaFilled(false);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1132, 271, 90, 26));

        btnHapus.setBorder(null);
        btnHapus.setBorderPainted(false);
        btnHapus.setContentAreaFilled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1277, 271, 90, 26));

        txtCari.setText("Tanggal Perawatan");
        txtCari.setBorder(null);
        txtCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMouseClicked(evt);
            }
        });
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 315, 170, 25));

        lblCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariMouseClicked(evt);
            }
        });
        getContentPane().add(lblCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 316, 28, 22));

        tblTransPerawatan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTransPerawatan.setGridColor(new java.awt.Color(34, 170, 170));
        tblTransPerawatan.setRowHeight(40);
        tblTransPerawatan.setShowGrid(true);
        tblTransPerawatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransPerawatanMouseClicked(evt);
            }
        });
        jScrollPaneTblTransMainten.setViewportView(tblTransPerawatan);

        getContentPane().add(jScrollPaneTblTransMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 1020, 530));

        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });
        getContentPane().add(lblKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 950, 120, 50));

        lblBeranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBerandaMouseClicked(evt);
            }
        });
        getContentPane().add(lblBeranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, 320, 60));

        lblPageStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPageStokMouseClicked(evt);
            }
        });
        getContentPane().add(lblPageStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 253, 320, 60));

        lblPageTransSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPageTransSewaMouseClicked(evt);
            }
        });
        getContentPane().add(lblPageTransSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 345, 320, 60));

        lblPermintaanMainten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPermintaanMaintenMouseClicked(evt);
            }
        });
        getContentPane().add(lblPermintaanMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 427, 320, 60));

        lblTransPerawatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTransPerawatanMouseClicked(evt);
            }
        });
        getContentPane().add(lblTransPerawatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 320, 60));

        lblDataPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDataPegawaiMouseClicked(evt);
            }
        });
        getContentPane().add(lblDataPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 582, 320, 60));

        lblDataPenyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDataPenyewaMouseClicked(evt);
            }
        });
        getContentPane().add(lblDataPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 667, 320, 60));

        lblLaporanPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLaporanPengeluaranMouseClicked(evt);
            }
        });
        getContentPane().add(lblLaporanPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 742, 320, 60));

        lblLaporanAkhir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLaporanAkhirMouseClicked(evt);
            }
        });
        getContentPane().add(lblLaporanAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 817, 320, 60));

        LblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Transaksi Maintenance owner.png"))); // NOI18N
        getContentPane().add(LblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String nama_alat = txtNamaAlat.getText().toLowerCase();
        String keterangan = txtKeterangan.getText().toLowerCase();
        String nama_admin = txtNamaAdmin.getText().toLowerCase();
        String nama_teknisi = txtNamaTeknisi.getText().toLowerCase();
        int jumlah = Integer.parseInt(txtJmlAlat.getText());
        Date AmbilTanggal = Tanggal.getDate();
        SimpleDateFormat FormatTanggal = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = FormatTanggal.format(AmbilTanggal);
        int biaya = Integer.parseInt(txtBiaya.getText());
        try {
            String no_ktp_admin = no_ktp_admin(nama_admin);
            String no_ktp_teknisi = no_ktp_teknisi(nama_teknisi);
            String id_alat = id_alat(nama_alat);
            String ktp_owner = ktpOwner();
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            String sql = "INSERT INTO perawatan VALUES (NULL, '" + nama_alat + "', '" + jumlah + "', '" + tanggal + "', '" + nama_teknisi + "','" + nama_admin + "', '" + keterangan + "', '" + biaya + "', '" + no_ktp_teknisi + "', '" + no_ktp_admin + "', '" + id_alat + "','" + ktp_owner + "')";
            if (!nama_alat.isEmpty() && nama_alat.matches("[a-zA-Z ]+") && nama_alat.length() <= 25 && !keterangan.isEmpty() && keterangan.length() <= 500 && !nama_admin.isEmpty() && !nama_teknisi.isEmpty() && jumlah < 100 && jumlah != 0 && AmbilTanggal != null && biaya <= 7000000) {
                if (JOptionPane.showConfirmDialog(null, "Simpan Transaksi Perawatan ? \n"
                        + "Nama Alat = " + nama_alat + "\n"
                        + "Jumlah Alat = " + jumlah + "\n"
                        + "Nama Admin = " + nama_admin + "\n"
                        + "Nama Teknisi = " + nama_teknisi + "\n"
                        + "Tanggal Transaksi = " + tanggal + "\n"
                        + "Keterangan = " + keterangan, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNamaAlat.setText("");
                    txtJmlAlat.setText("");
                    txtNamaTeknisi.setText("");
                    txtNamaAdmin.setText("");
                    txtKeterangan.setText("");
                    txtBiaya.setText("");
                    Tanggal.setDate(null);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data perawatan ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }

        tabelTransMainten();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String nama_alat = txtNamaAlat.getText().toLowerCase();
        String keterangan = txtKeterangan.getText().toLowerCase();
        String nama_admin = txtNamaAdmin.getText().toLowerCase();
        String nama_teknisi = txtNamaTeknisi.getText().toLowerCase();
        int jumlah = Integer.parseInt(txtJmlAlat.getText());
        Date AmbilTanggal = Tanggal.getDate();
        SimpleDateFormat FormatTanggal = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = FormatTanggal.format(AmbilTanggal);
        int biaya = Integer.parseInt(txtBiaya.getText());
        int pilih_baris = tblTransPerawatan.getSelectedRow();
        try {
            String no_ktp_admin = no_ktp_admin(nama_admin);
            String no_ktp_teknisi = no_ktp_teknisi(nama_teknisi);
            String id_alat = id_alat(nama_alat);
            String ktp_owner = ktpOwner();
            String id_perawatan = id_perawatan(tblTransPerawatan.getValueAt(pilih_baris, 0).toString());
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            String sql = "UPDATE perawatan SET nama_alat = '" + nama_alat + "', jumlah = '" + jumlah + "', tanggal = '" + tanggal + "', nama_teknisi = '" + nama_teknisi + "', nama_admin = '" + nama_admin + "', keterangan = '" + keterangan + "', biaya_perawatan = '" + biaya + "', no_ktp_teknisi = '" + no_ktp_teknisi + "', no_ktp_admin = '" + no_ktp_admin + "', id_alat = '" + id_alat + "', ktp_owner = '" + ktp_owner + "' WHERE id_perawatan = '" + id_perawatan + "'";
            if (!nama_alat.isEmpty() && nama_alat.matches("[a-zA-Z ]+") && nama_alat.length() <= 25 && !keterangan.isEmpty() && keterangan.length() <= 500 && !nama_admin.isEmpty() && !nama_teknisi.isEmpty() && jumlah < 100 && jumlah != 0 && AmbilTanggal != null && biaya <= 7000000) {
                if (JOptionPane.showConfirmDialog(null, "Simpan perubahan ? \n"
                        + "Nama Alat = " + nama_alat + "\n"
                        + "Jumlah Alat = " + jumlah + "\n"
                        + "Nama Admin = " + nama_admin + "\n"
                        + "Nama Teknisi = " + nama_teknisi + "\n"
                        + "Tanggal Transaksi = " + tanggal + "\n"
                        + "Keterangan = " + keterangan, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNamaAlat.setText("");
                    txtJmlAlat.setText("");
                    txtNamaTeknisi.setText("");
                    txtNamaAdmin.setText("");
                    txtKeterangan.setText("");
                    txtBiaya.setText("");
                    Tanggal.setDate(null);
                } else {
                    txtNamaAlat.setText("");
                    txtJmlAlat.setText("");
                    txtNamaTeknisi.setText("");
                    txtNamaAdmin.setText("");
                    txtKeterangan.setText("");
                    txtBiaya.setText("");
                    Tanggal.setDate(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal saat mencoba mengubah data perawatan ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        tabelTransMainten();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int pilih_baris = tblTransPerawatan.getSelectedRow();
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            if (pilih_baris != -1) {
                if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data perawatan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, hapus) == JOptionPane.YES_OPTION) {
                    String id_perawatan = tblTransPerawatan.getValueAt(pilih_baris, 0).toString();
                    String sql1 = "delete from perawatan where id_perawatan = '" + id_perawatan + "'";
                    st.executeUpdate(sql1);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                } else {
                    txtNamaAlat.setText("");
                    txtJmlAlat.setText("");
                    txtNamaTeknisi.setText("");
                    txtNamaAdmin.setText("");
                    txtKeterangan.setText("");
                    txtBiaya.setText("");
                    Tanggal.setDate(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        tabelTransMainten();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void lblCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariMouseClicked
        try {
            String CariTransaksi = txtCari.getText();
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            if (!CariTransaksi.isEmpty()) {
                ResultSet rs = st.executeQuery("SELECT * FROM `perawatan` WHERE `tanggal`= '" + CariTransaksi + "'");
                TableNoEdit tblDBTransMainten = new TableNoEdit();
                tblDBTransMainten.addColumn("ID Perawatan");
                tblDBTransMainten.addColumn("Nama Alat");
                tblDBTransMainten.addColumn("Jml");
                tblDBTransMainten.addColumn("Tanggal");
                tblDBTransMainten.addColumn("Nama Teknisi");
                tblDBTransMainten.addColumn("Nama Admin");
                tblDBTransMainten.addColumn("Keterangan");
                tblDBTransMainten.addColumn("Biaya Perawatan");
                tblTransPerawatan.setModel(tblDBTransMainten);
                tblTransPerawatan.getColumnModel().getColumn(0).setPreferredWidth(92);
                tblTransPerawatan.getColumnModel().getColumn(1).setPreferredWidth(124);
                tblTransPerawatan.getColumnModel().getColumn(2).setPreferredWidth(61);
                tblTransPerawatan.getColumnModel().getColumn(3).setPreferredWidth(164);
                tblTransPerawatan.getColumnModel().getColumn(4).setPreferredWidth(125);
                tblTransPerawatan.getColumnModel().getColumn(5).setPreferredWidth(123);
                tblTransPerawatan.getColumnModel().getColumn(6).setPreferredWidth(177);
                tblTransPerawatan.getColumnModel().getColumn(7).setPreferredWidth(155);
                tblTransPerawatan.getTableHeader().setPreferredSize(new Dimension(0, 40));
                tblTransPerawatan.setOpaque(false);
                tblTransPerawatan.getTableHeader().setReorderingAllowed(false);
                TableColumnModel Modelkolom = tblTransPerawatan.getColumnModel();
                for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
                    TableColumn kolom = Modelkolom.getColumn(i);
                    kolom.setResizable(false);
                }
                jScrollPaneTblTransMainten.getViewport().setOpaque(false);
                if (rs.next()) {
                    tblDBTransMainten.addRow(new Object[]{
                        rs.getString("id_perawatan"),
                        rs.getString("nama_alat"),
                        rs.getString("jumlah"),
                        rs.getString("tanggal"),
                        rs.getString("nama_teknisi"),
                        rs.getString("nama_admin"),
                        rs.getString("keterangan"),
                        rs.getString("biaya_perawatan"),});
                    tblTransPerawatan.setModel(tblDBTransMainten);
                    txtCari.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan !", "Kesalahan", JOptionPane.INFORMATION_MESSAGE, notFound);
                    tabelTransMainten();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Masukan tanggal perawatan", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mencari data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_lblCariMouseClicked

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar aplikasi ? ", "Konrirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, keluar) == JOptionPane.YES_OPTION) {
            Login pgLogin = new Login();
            pgLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblKeluarMouseClicked

    private void tblTransPerawatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransPerawatanMouseClicked
        int row = tblTransPerawatan.rowAtPoint(evt.getPoint());
        if (row >= 0 && row < tblTransPerawatan.getRowCount()) {
            isiTextFieldTransMainten(row);
        }
    }//GEN-LAST:event_tblTransPerawatanMouseClicked

    private void txtCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMouseClicked
        txtCari.setText("");
    }//GEN-LAST:event_txtCariMouseClicked

    private void lblBerandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBerandaMouseClicked
        HomePageOwner pgHome = new HomePageOwner();
        pgHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBerandaMouseClicked

    private void lblPageStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPageStokMouseClicked
        Stock_Owner pgStok = new Stock_Owner();
        pgStok.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblPageStokMouseClicked

    private void lblPageTransSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPageTransSewaMouseClicked
        Transaksi_Sewa_Owner pgtransSewa = new Transaksi_Sewa_Owner();
        pgtransSewa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblPageTransSewaMouseClicked

    private void lblPermintaanMaintenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPermintaanMaintenMouseClicked
        Permintaan_Perawatan_Owner pgRequest = new Permintaan_Perawatan_Owner();
        pgRequest.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblPermintaanMaintenMouseClicked

    private void lblTransPerawatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransPerawatanMouseClicked

    }//GEN-LAST:event_lblTransPerawatanMouseClicked

    private void lblDataPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDataPegawaiMouseClicked
        Data_Pegawai_Owner pgPegawai = new Data_Pegawai_Owner();
        pgPegawai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblDataPegawaiMouseClicked

    private void lblDataPenyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDataPenyewaMouseClicked
        Penyewa_Owner pgPenyewa = new Penyewa_Owner();
        pgPenyewa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblDataPenyewaMouseClicked

    private void lblLaporanPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLaporanPengeluaranMouseClicked
        Laporan_Pengeluaran_Owner pgLapPengeluaran = new Laporan_Pengeluaran_Owner();
        pgLapPengeluaran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLaporanPengeluaranMouseClicked

    private void lblLaporanAkhirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLaporanAkhirMouseClicked
        Laporan_Akhir_Owner pgLapAkhir = new Laporan_Akhir_Owner();
        pgLapAkhir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLaporanAkhirMouseClicked
    private void isiTextFieldTransMainten(int row) {
        int pilih_baris = tblTransPerawatan.getSelectedRow();
        if (pilih_baris >= 0) {
            try {
                String NamaAlat = tblTransPerawatan.getValueAt(pilih_baris, 1).toString();
                String Jumlah = tblTransPerawatan.getValueAt(pilih_baris, 2).toString();
                String AmbilTanggal = tblTransPerawatan.getValueAt(pilih_baris, 3).toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date TanggalTransaksi = dateFormat.parse(AmbilTanggal);
                String Nama_Teknisi = tblTransPerawatan.getValueAt(pilih_baris, 4).toString();
                String Nama_Admin = tblTransPerawatan.getValueAt(pilih_baris, 5).toString();
                String Keterangan = tblTransPerawatan.getValueAt(pilih_baris, 6).toString();
                String BiayaPerawatan = tblTransPerawatan.getValueAt(pilih_baris, 7).toString();
                txtNamaAlat.setText(NamaAlat);
                txtJmlAlat.setText(Jumlah);
                Tanggal.setDate(TanggalTransaksi);
                txtNamaAdmin.setText(Nama_Admin);
                txtNamaTeknisi.setText(Nama_Teknisi);
                txtKeterangan.setText(Keterangan);
                txtBiaya.setText(BiayaPerawatan);
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
            java.util.logging.Logger.getLogger(Transaksi_Maintenance_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Maintenance_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Maintenance_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Maintenance_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi_Maintenance_Owner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblBackground;
    private com.toedter.calendar.JDateChooser Tanggal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JScrollPane jScrollPaneTblTransMainten;
    private javax.swing.JLabel lblBeranda;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblDataPegawai;
    private javax.swing.JLabel lblDataPenyewa;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblLaporanAkhir;
    private javax.swing.JLabel lblLaporanPengeluaran;
    private javax.swing.JLabel lblPageStok;
    private javax.swing.JLabel lblPageTransSewa;
    private javax.swing.JLabel lblPermintaanMainten;
    private javax.swing.JLabel lblTransPerawatan;
    private javax.swing.JTable tblTransPerawatan;
    private javax.swing.JTextField txtBiaya;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJmlAlat;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtNamaAdmin;
    private javax.swing.JTextField txtNamaAlat;
    private javax.swing.JTextField txtNamaTeknisi;
    // End of variables declaration//GEN-END:variables
}
