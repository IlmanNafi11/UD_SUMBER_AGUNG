package Admin;

import Login.*;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Table.TableNoEdit;
import KoneksiDatabase.ClassKoneksi;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Stock_Admin extends javax.swing.JFrame {

    public Stock_Admin() {
        initComponents();
        TabelStok();
        TabelDataMainten();
    }

    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon simpan = new ImageIcon(getClass().getResource("/Images/icon save.png"));
    ImageIcon ubah = new ImageIcon(getClass().getResource("/Images/icon ubah.png"));
    ImageIcon hapus = new ImageIcon(getClass().getResource("/Images/icon delete.png"));
    ImageIcon notFound = new ImageIcon(getClass().getResource("/Images/icon not found.png"));
    ImageIcon tersedia = new ImageIcon(getClass().getResource("/Images/icon tersedia.png"));
    ImageIcon keluar = new ImageIcon(getClass().getResource("/Images/icon keluar.png"));

    private static boolean CekAlat(String namaAlat) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        String sql = "SELECT COUNT(*) FROM alat WHERE nama_alat = '" + namaAlat + "'";
        try (Statement statement = koneksi.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        }
    }

    private static String id_alat(String nama_alat) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "SELECT id_alat from alat where nama_alat = '" + nama_alat + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("id_alat");
        } else {
            throw new SQLException("Data alat tidak ditemukan");
        }
    }

    private static int stok(String id_alat) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select stock from alat where id_alat = '" + id_alat + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getInt("stock");
        } else {
            throw new SQLException("Jumlah permintaan melebihi alat yang tersedia");
        }
    }

    private static String CekNamaAdmin(String nama_admin) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select nama from admin where nama = '" + nama_admin + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("nama");
        } else {
            throw new SQLException("Admin tidak terdaftar");
        }
    }

    private static String NoKtpAdmin(String nama) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select no_ktp_admin from admin where nama = '" + nama + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("no_ktp_admin");
        } else {
            throw new SQLException("Admin Tidak ditemukan");
        }
    }

    public void TabelStok() {
        TableNoEdit TblDbStokAlat = new TableNoEdit();
        TblDbStokAlat.addColumn("ID Alat");
        TblDbStokAlat.addColumn("Nama Alat");
        TblDbStokAlat.addColumn("Stok Alat");
        TblDbStokAlat.addColumn("Harga Sewa");
        tblStokAlat.setModel(TblDbStokAlat);
        tblStokAlat.getColumnModel().getColumn(0).setPreferredWidth(134);
        tblStokAlat.getColumnModel().getColumn(1).setPreferredWidth(236);
        tblStokAlat.getColumnModel().getColumn(2).setPreferredWidth(152);
        tblStokAlat.getColumnModel().getColumn(3).setPreferredWidth(296);
        tblStokAlat.getTableHeader().setPreferredSize(new Dimension(0, 40));
        tblStokAlat.setOpaque(false);
        tblStokAlat.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblStokAlat.getColumnModel();
        for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
            TableColumn kolom = Modelkolom.getColumn(i);
            kolom.setResizable(false);
        }
        jScrollPaneTblStok.getViewport().setOpaque(false);
        try {
            Connection penghubung = ClassKoneksi.GetConnection();
            Statement st = penghubung.createStatement();
            ResultSet rs = st.executeQuery("select * from alat");
            while (rs.next()) {
                TblDbStokAlat.addRow(new Object[]{
                    rs.getString("id_alat"),
                    rs.getString("nama_alat"),
                    rs.getString("stock"),
                    rs.getString("harga_sewa"),});
                tblStokAlat.setModel(TblDbStokAlat);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat mengambil data pada database" + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    public void TabelDataMainten() {
        TableNoEdit TblDbMainten = new TableNoEdit();
        TblDbMainten.addColumn("ID Permintaan");
        TblDbMainten.addColumn("Nama Alat");
        TblDbMainten.addColumn("Jumlah");
        TblDbMainten.addColumn("Nama Admin");
        TblDbMainten.addColumn("Status");
        tblMainten.setModel(TblDbMainten);
        tblMainten.getColumnModel().getColumn(0).setPreferredWidth(137);
        tblMainten.getColumnModel().getColumn(1).setPreferredWidth(236);
        tblMainten.getColumnModel().getColumn(2).setPreferredWidth(175);
        tblMainten.getColumnModel().getColumn(3).setPreferredWidth(296);
        tblMainten.getColumnModel().getColumn(3).setPreferredWidth(213);
        tblMainten.getTableHeader().setPreferredSize(new Dimension(0, 40));
        tblMainten.setOpaque(false);
        tblMainten.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblMainten.getColumnModel();
        for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
            TableColumn kolom = Modelkolom.getColumn(i);
            kolom.setResizable(false);
        }
        jScrollPaneTblMainten.getViewport().setOpaque(false);
        try {
            Connection penghubung = ClassKoneksi.GetConnection();
            Statement st = penghubung.createStatement();
            ResultSet rs = st.executeQuery("select * from daftar_perawatan");
            while (rs.next()) {
                TblDbMainten.addRow(new Object[]{
                    rs.getString("id_permintaan"),
                    rs.getString("nama_alat"),
                    rs.getString("jumlah"),
                    rs.getString("nama_admin"),
                    rs.getString("status"),});
                tblMainten.setModel(TblDbMainten);
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
        lblDTPenyewa = new javax.swing.JLabel();
        lblLapPengeluaran = new javax.swing.JLabel();
        lblKeluar = new javax.swing.JLabel();
        txtNamaAlatStok = new javax.swing.JTextField();
        txtStokAlatStok = new javax.swing.JTextField();
        txtBiayaSewaStok = new javax.swing.JTextField();
        btnSimpanStok = new javax.swing.JButton();
        btnUbahStok = new javax.swing.JButton();
        btnHapusStok = new javax.swing.JButton();
        jScrollPaneTblStok = new javax.swing.JScrollPane();
        tblStokAlat = new javax.swing.JTable();
        txtNamaAlatMainten = new javax.swing.JTextField();
        txtJmlMainten = new javax.swing.JTextField();
        txtAdminMainten = new javax.swing.JTextField();
        btnSimpanMainten = new javax.swing.JButton();
        btnUbahMainten = new javax.swing.JButton();
        btnHapusMainten = new javax.swing.JButton();
        txtCariMainten = new javax.swing.JTextField();
        lblCariMainten = new javax.swing.JLabel();
        jScrollPaneTblMainten = new javax.swing.JScrollPane();
        tblMainten = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();
        cmbStatus = new javax.swing.JComboBox<>();
        LabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Alat");
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

        txtNamaAlatStok.setBackground(new java.awt.Color(249, 249, 249));
        txtNamaAlatStok.setBorder(null);
        getContentPane().add(txtNamaAlatStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 113, 190, 25));

        txtStokAlatStok.setBackground(new java.awt.Color(249, 249, 249));
        txtStokAlatStok.setBorder(null);
        getContentPane().add(txtStokAlatStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 152, 200, 25));

        txtBiayaSewaStok.setBackground(new java.awt.Color(249, 249, 249));
        txtBiayaSewaStok.setBorder(null);
        getContentPane().add(txtBiayaSewaStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 113, 180, 25));

        btnSimpanStok.setBorder(null);
        btnSimpanStok.setBorderPainted(false);
        btnSimpanStok.setContentAreaFilled(false);
        btnSimpanStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanStokActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpanStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(866, 157, 96, 25));

        btnUbahStok.setBorder(null);
        btnUbahStok.setBorderPainted(false);
        btnUbahStok.setContentAreaFilled(false);
        btnUbahStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahStokActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbahStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1006, 157, 96, 25));

        btnHapusStok.setBorder(null);
        btnHapusStok.setBorderPainted(false);
        btnHapusStok.setContentAreaFilled(false);
        btnHapusStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusStokActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapusStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1144, 157, 96, 25));

        tblStokAlat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStokAlat.setGridColor(new java.awt.Color(34, 170, 170));
        tblStokAlat.setRowHeight(40);
        tblStokAlat.setShowGrid(true);
        tblStokAlat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStokAlatMouseClicked(evt);
            }
        });
        jScrollPaneTblStok.setViewportView(tblStokAlat);

        getContentPane().add(jScrollPaneTblStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 198, 820, 200));

        txtNamaAlatMainten.setBackground(new java.awt.Color(249, 249, 249));
        txtNamaAlatMainten.setBorder(null);
        getContentPane().add(txtNamaAlatMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 549, 200, 25));

        txtJmlMainten.setBackground(new java.awt.Color(249, 249, 249));
        txtJmlMainten.setBorder(null);
        getContentPane().add(txtJmlMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 589, 200, 25));

        txtAdminMainten.setBackground(new java.awt.Color(249, 249, 249));
        txtAdminMainten.setBorder(null);
        getContentPane().add(txtAdminMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(1036, 549, 204, 25));

        btnSimpanMainten.setBorder(null);
        btnSimpanMainten.setBorderPainted(false);
        btnSimpanMainten.setContentAreaFilled(false);
        btnSimpanMainten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanMaintenActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpanMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 596, 94, 25));

        btnUbahMainten.setBorder(null);
        btnUbahMainten.setBorderPainted(false);
        btnUbahMainten.setContentAreaFilled(false);
        btnUbahMainten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahMaintenActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbahMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(1017, 596, 90, 25));

        btnHapusMainten.setBackground(new java.awt.Color(249, 249, 249));
        btnHapusMainten.setBorder(null);
        btnHapusMainten.setBorderPainted(false);
        btnHapusMainten.setContentAreaFilled(false);
        btnHapusMainten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusMaintenActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapusMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(1147, 596, 100, 25));

        txtCariMainten.setBackground(new java.awt.Color(249, 249, 249));
        txtCariMainten.setText("Nama Alat");
        txtCariMainten.setBorder(null);
        txtCariMainten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariMaintenMouseClicked(evt);
            }
        });
        getContentPane().add(txtCariMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(1153, 653, 160, 25));

        lblCariMainten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariMaintenMouseClicked(evt);
            }
        });
        getContentPane().add(lblCariMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(1319, 654, 27, 20));

        tblMainten.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMainten.setGridColor(new java.awt.Color(34, 170, 170));
        tblMainten.setRowHeight(40);
        tblMainten.setShowGrid(true);
        tblMainten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaintenMouseClicked(evt);
            }
        });
        jScrollPaneTblMainten.setViewportView(tblMainten);

        getContentPane().add(jScrollPaneTblMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 688, 950, 200));

        btnKembali.setBorder(null);
        btnKembali.setBorderPainted(false);
        btnKembali.setContentAreaFilled(false);
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1255, 950, 100, 40));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diminta", "Di Proses", "Selesai" }));
        getContentPane().add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 629, 198, -1));

        LabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Stock Admin.png"))); // NOI18N
        getContentPane().add(LabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

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

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed

    }//GEN-LAST:event_btnKembaliActionPerformed
    private String nama_alat;
    private void btnSimpanStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanStokActionPerformed
        nama_alat = txtNamaAlatStok.getText().toLowerCase();
        int stok_alat = Integer.parseInt(txtStokAlatStok.getText());
        int harga_sewa = Integer.parseInt(txtBiayaSewaStok.getText());
        if (nama_alat.length() <= 25) {
            nama_alat = txtNamaAlatStok.getText().toLowerCase();
        } else {
            JOptionPane.showMessageDialog(null, "Nama Alat tidak boleh lebih dari 25 digit !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        if (stok_alat <= 1000) {
            stok_alat = Integer.parseInt(txtStokAlatStok.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Stok lebih dari 1000", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        if (harga_sewa <= 7000000) {
            harga_sewa = Integer.parseInt(txtBiayaSewaStok.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Biaya sewa lebih dari 7000000", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }

        if (nama_alat.length() <= 25 && nama_alat.matches("[a-zA-Z ]+") && stok_alat <= 1000 && harga_sewa <= 7000000) {
            try {
                if (CekAlat(nama_alat)) {
                    JOptionPane.showMessageDialog(null, "Alat telah tersedia ! ", "Alat ditemukan", JOptionPane.INFORMATION_MESSAGE, tersedia);
                } else {
                    Connection koneksi = ClassKoneksi.GetConnection();
                    Statement st = koneksi.createStatement();
                    String sql = "insert into alat value (null,'" + nama_alat + "','" + harga_sewa + "','" + stok_alat + "')";
                    if (JOptionPane.showConfirmDialog(null, "Tambah alat baru ? \n"
                            + "Nama Alat = " + nama_alat + "\n"
                            + "Stok = " + stok_alat + "\n"
                            + "Harga sewa = " + harga_sewa, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                        st.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                        st.close();
                        txtNamaAlatStok.setText("");
                        txtBiayaSewaStok.setText("");
                        txtStokAlatStok.setText("");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menambahkan alat baru ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TabelStok();
    }//GEN-LAST:event_btnSimpanStokActionPerformed

    private void btnUbahStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahStokActionPerformed
        String nama_alat = txtNamaAlatStok.getText().toLowerCase();
        int stok = Integer.parseInt(txtStokAlatStok.getText());
        int biaya_sewa = Integer.parseInt(txtBiayaSewaStok.getText());
        int pilih_baris = tblStokAlat.getSelectedRow();
        if (pilih_baris != 1) {
            if (nama_alat.length() <= 25 && nama_alat.matches("[a-zA-Z ]+") && stok <= 1000 && biaya_sewa <= 7000000) {
                try {
                    Connection koneksi = ClassKoneksi.GetConnection();
                    Statement st = koneksi.createStatement();
                    String id_alat = tblStokAlat.getValueAt(pilih_baris, 0).toString();
                    String sql = "UPDATE alat set nama_alat = '" + nama_alat + "', harga_sewa = '" + biaya_sewa + "', stock = '" + stok + "' WHERE id_alat = '" + id_alat + "'";
                    if (JOptionPane.showConfirmDialog(null, "Simpan perubahan ? \n"
                            + "Nama Alat = " + nama_alat + "\n"
                            + "Stok Alat = " + stok + "\n"
                            + "Biaya Sewa = " + biaya_sewa + "\n",
                            "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                        st.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                        st.close();
                        txtNamaAlatStok.setText("");
                        txtStokAlatStok.setText("");
                        txtBiayaSewaStok.setText("");
                    } else {
                        txtNamaAlatStok.setText("");
                        txtStokAlatStok.setText("");
                        txtBiayaSewaStok.setText("");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal mengubah data alat ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Isi data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }

        TabelStok();
    }//GEN-LAST:event_btnUbahStokActionPerformed

    private void btnHapusStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusStokActionPerformed
        nama_alat = txtNamaAlatStok.getText();
        int pilihBaris = tblStokAlat.getSelectedRow();
        if (pilihBaris != -1) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String id_alat = tblStokAlat.getValueAt(pilihBaris, 0).toString();
                String sql = "delete from alat where id_alat = '" + id_alat + "'";
                if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, hapus) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNamaAlatStok.setText("");
                    txtStokAlatStok.setText("");
                    txtBiayaSewaStok.setText("");
                } else {
                    txtNamaAlatStok.setText("");
                    txtStokAlatStok.setText("");
                    txtBiayaSewaStok.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        }
        TabelStok();
    }//GEN-LAST:event_btnHapusStokActionPerformed

    private void btnSimpanMaintenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanMaintenActionPerformed
        String nama_alat = txtNamaAlatMainten.getText();
        int jumlah = Integer.parseInt(txtJmlMainten.getText());
        String status = (String) cmbStatus.getSelectedItem();
        String nama_admin = txtAdminMainten.getText().toLowerCase();
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            String admin = CekNamaAdmin(nama_admin);
            String id_alat = id_alat(nama_alat);
            int cekStok = stok(id_alat);
            String Ktp_Admin = NoKtpAdmin(nama_admin);
            if (!nama_alat.isEmpty() && nama_alat.length() <= 25 && nama_alat.matches("[a-zA-Z ]+") && jumlah <= cekStok && !admin.isEmpty() && !status.isEmpty()) {
                String sql = "insert into daftar_perawatan value (NULL,'" + nama_alat + "', '" + jumlah + "','" + status + "','" + nama_admin + "','" + Ktp_Admin + "','" + id_alat + "')";
                if (JOptionPane.showConfirmDialog(null, "Simpan permintaan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Permintaan berhasil disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE, simpan);
                    txtNamaAlatMainten.setText("");
                    txtJmlMainten.setText("");
                    txtAdminMainten.setText("");
                } else {
                    txtNamaAlatMainten.setText("");
                    txtJmlMainten.setText("");
                    txtAdminMainten.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal membuat permintaan ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TabelDataMainten();
    }//GEN-LAST:event_btnSimpanMaintenActionPerformed

    private void btnUbahMaintenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahMaintenActionPerformed
        String nama_alat = txtNamaAlatMainten.getText();
        int jumlah = Integer.parseInt(txtJmlMainten.getText());
        String namaAdmin = txtAdminMainten.getText();
        String Status = (String) cmbStatus.getSelectedItem();
        int pilih_baris = tblMainten.getSelectedRow();
        String id_permintaan = tblMainten.getValueAt(pilih_baris, 0).toString();
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            String admin = CekNamaAdmin(namaAdmin);
            String id_alat = id_alat(nama_alat);
            int cekStok = stok(id_alat);
            String Ktp_Admin = NoKtpAdmin(namaAdmin);
            if (!nama_alat.isEmpty() && nama_alat.length() <= 25 && nama_alat.matches("[a-zA-Z ]+") && jumlah <= cekStok && !admin.isEmpty() && !Status.isEmpty()) {
                String sql = "UPDATE daftar_perawatan SET nama_alat = '" + nama_alat + "', jumlah = '" + jumlah + "', nama_admin = '" + namaAdmin + "', status = '" + Status + "', no_ktp_admin = '" + Ktp_Admin + "', id_alat = '" + id_alat + "' WHERE id_permintaan = '"+id_permintaan+"'";
                if (JOptionPane.showConfirmDialog(null, "Simpan perubahan ? \n"
                        + "Nama alat = " + nama_alat + "\n"
                        + "Jumlah = " + jumlah + "\n"
                        + "Status = " + Status + "\n"
                        + "Admin = " + namaAdmin, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtAdminMainten.setText("");
                    txtJmlMainten.setText("");
                    txtNamaAlatMainten.setText("");
                } else {
                    txtAdminMainten.setText("");
                    txtJmlMainten.setText("");
                    txtNamaAlatMainten.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan perubahan ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }

        TabelDataMainten();
    }//GEN-LAST:event_btnUbahMaintenActionPerformed

    private void btnHapusMaintenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusMaintenActionPerformed
        int pilih_baris = tblMainten.getSelectedRow();
        if (pilih_baris != -1) {
            String id_permintaan = tblMainten.getValueAt(pilih_baris, 0).toString();
            String sql = "delete from daftar_perawatan where id_permintaan = '" + id_permintaan + "'";
            try {
                if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, hapus) == JOptionPane.YES_OPTION) {
                    Connection koneksi = ClassKoneksi.GetConnection();
                    Statement st = koneksi.createStatement();
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtAdminMainten.setText("");
                    txtJmlMainten.setText("");
                    txtNamaAlatMainten.setText("");
                } else {
                    txtAdminMainten.setText("");
                    txtJmlMainten.setText("");
                    txtNamaAlatMainten.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        }
        TabelDataMainten();
    }//GEN-LAST:event_btnHapusMaintenActionPerformed

    private void lblCariMaintenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariMaintenMouseClicked
        String cariAlatMainten = txtCariMainten.getText();
        if (cariAlatMainten != null) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String sql = "select * from daftar_perawatan where nama_alat = '" + cariAlatMainten + "'";
                ResultSet rs = st.executeQuery(sql);
                TableNoEdit TblDbMainten = new TableNoEdit();
                TblDbMainten.addColumn("ID Permintaan");
                TblDbMainten.addColumn("Nama Alat");
                TblDbMainten.addColumn("Jumlah");
                TblDbMainten.addColumn("Nama Admin");
                TblDbMainten.addColumn("Status");
                tblMainten.setModel(TblDbMainten);
                tblMainten.getColumnModel().getColumn(0).setPreferredWidth(137);
                tblMainten.getColumnModel().getColumn(1).setPreferredWidth(236);
                tblMainten.getColumnModel().getColumn(2).setPreferredWidth(175);
                tblMainten.getColumnModel().getColumn(3).setPreferredWidth(296);
                tblMainten.getColumnModel().getColumn(3).setPreferredWidth(213);
                tblMainten.getTableHeader().setPreferredSize(new Dimension(0, 40));
                tblMainten.setOpaque(false);
                tblMainten.getTableHeader().setReorderingAllowed(false);
                TableColumnModel Modelkolom = tblMainten.getColumnModel();
                for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
                    TableColumn kolom = Modelkolom.getColumn(i);
                    kolom.setResizable(false);
                }
                jScrollPaneTblMainten.getViewport().setOpaque(false);
                if (rs.next()) {
                    TblDbMainten.addRow(new Object[]{
                        rs.getString("id_permintaan"),
                        rs.getString("nama_alat"),
                        rs.getString("jumlah"),
                        rs.getString("nama_admin"),
                        rs.getString("status"),});
                    tblMainten.setModel(TblDbMainten);
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan !", "Kesalahan", JOptionPane.INFORMATION_MESSAGE, notFound);
                    TabelDataMainten();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mencari data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Masukan nama alat", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_lblCariMaintenMouseClicked

    private void tblStokAlatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStokAlatMouseClicked
        int row = tblStokAlat.rowAtPoint(evt.getPoint());
        if (row >= 0 && row < tblStokAlat.getRowCount()) {
            isiTextFieldStok(row);
        }
    }//GEN-LAST:event_tblStokAlatMouseClicked

    private void txtCariMaintenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariMaintenMouseClicked
        txtCariMainten.setText("");
    }//GEN-LAST:event_txtCariMaintenMouseClicked

    private void tblMaintenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaintenMouseClicked
        int row = tblMainten.rowAtPoint(evt.getPoint());
        if (row >= 0 && row < tblMainten.getRowCount()) {
            isiTextFieldMainten(row);
        }
    }//GEN-LAST:event_tblMaintenMouseClicked
    private void isiTextFieldStok(int row) {
        int pilih_baris = tblStokAlat.getSelectedRow();
        if (pilih_baris >= 0) {
            String DataNamaAlat = tblStokAlat.getValueAt(pilih_baris, 1).toString();
            String DataStok = tblStokAlat.getValueAt(pilih_baris, 2).toString();
            String DataBiaya = tblStokAlat.getValueAt(pilih_baris, 3).toString();
            txtNamaAlatStok.setText(DataNamaAlat);
            txtStokAlatStok.setText(DataStok);
            txtBiayaSewaStok.setText(DataBiaya);
        }
    }

    private void isiTextFieldMainten(int row) {
        int pilih_baris = tblMainten.getSelectedRow();
        if (pilih_baris >= 0) {
            String DataNamaAlat = tblMainten.getValueAt(pilih_baris, 1).toString();
            String Jml = tblMainten.getValueAt(pilih_baris, 2).toString();
            String NamaAdmin = tblMainten.getValueAt(pilih_baris, 3).toString();
            String Status = tblMainten.getValueAt(pilih_baris, 4).toString();
            txtNamaAlatMainten.setText(DataNamaAlat);
            txtJmlMainten.setText(Jml);
            txtAdminMainten.setText(NamaAdmin);
            cmbStatus.setSelectedItem(Status);
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
            java.util.logging.Logger.getLogger(Stock_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBackground;
    private javax.swing.JButton btnHapusMainten;
    private javax.swing.JButton btnHapusStok;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpanMainten;
    private javax.swing.JButton btnSimpanStok;
    private javax.swing.JButton btnUbahMainten;
    private javax.swing.JButton btnUbahStok;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JScrollPane jScrollPaneTblMainten;
    private javax.swing.JScrollPane jScrollPaneTblStok;
    private javax.swing.JLabel lblBeranda;
    private javax.swing.JLabel lblCariMainten;
    private javax.swing.JLabel lblDTPenyewa;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblLapPengeluaran;
    private javax.swing.JLabel lblStok;
    private javax.swing.JLabel lblTransSewa;
    private javax.swing.JTable tblMainten;
    private javax.swing.JTable tblStokAlat;
    private javax.swing.JTextField txtAdminMainten;
    private javax.swing.JTextField txtBiayaSewaStok;
    private javax.swing.JTextField txtCariMainten;
    private javax.swing.JTextField txtJmlMainten;
    private javax.swing.JTextField txtNamaAlatMainten;
    private javax.swing.JTextField txtNamaAlatStok;
    private javax.swing.JTextField txtStokAlatStok;
    // End of variables declaration//GEN-END:variables
}
