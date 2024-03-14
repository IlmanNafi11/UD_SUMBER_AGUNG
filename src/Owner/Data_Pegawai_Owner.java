package Owner;
import Login.*;
import KoneksiDatabase.ClassKoneksi;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Table.TableNoEdit;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Data_Pegawai_Owner extends javax.swing.JFrame {

    public Data_Pegawai_Owner() {
        initComponents();
        TableAdmin();
        TableTeknisi();
    }

    // mengambil gambar untuk icon PopUp
    ImageIcon user = new ImageIcon(getClass().getResource("/Images/user.png"));
    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon simpan = new ImageIcon(getClass().getResource("/Images/icon save.png"));
    ImageIcon ubah = new ImageIcon(getClass().getResource("/Images/icon ubah.png"));
    ImageIcon hapus = new ImageIcon(getClass().getResource("/Images/icon delete.png"));
    ImageIcon notFound = new ImageIcon(getClass().getResource("/Images/icon not found.png"));
    ImageIcon keluar = new ImageIcon(getClass().getResource("/Images/icon keluar.png"));

    // mengambil Username admin untuk method simpan
    public static String UsernameAdmin(String no_ktp) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select username from akun where ktp = '" + no_ktp + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("username");
        } else {
            throw new SQLException("No KTP harus sesuai dengan akun yang didaftarkan !");
        }
    }

    // mengambil Username teknisi untuk method simpan
    public static String UsernameTeknisi(String no_ktp) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select username from akun where ktp = '" + no_ktp + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("username");
        } else {
            throw new SQLException("No KTP harus sesuai dengan akun yang didaftarkan !");
        }
    }

    // mengambil No KTP admin untuk method ubah
    public static String NoKtpAdmin(String nomorKtpAdmin) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select no_ktp_admin from admin where no_ktp_admin = '" + nomorKtpAdmin + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("no_ktp_admin");
        } else {
            throw new SQLException("Data Admin tidak ditemukan");
        }
    }

    // mengambil No KTP teknisi untuk method ubah
    public static String NoKtpTeknisi(String nomorKtpTeknisi) throws SQLException {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "select no_ktp_teknisi from teknisi where no_ktp_teknisi = '" + nomorKtpTeknisi + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("no_ktp_teknisi");
        } else {
            throw new SQLException("Data teknisi tidak ditemukan");
        }
    }

    public void TableAdmin() {
        TableNoEdit tblDBAdmin = new TableNoEdit();
        tblDBAdmin.addColumn("No KTP Admin");
        tblDBAdmin.addColumn("Nama Admin");
        tblDBAdmin.addColumn("No Hp");
        tblDBAdmin.addColumn("Alamat");
        tblDBAdmin.addColumn("Gaji");
        tblAdmin.setModel(tblDBAdmin);
        tblAdmin.getColumnModel().getColumn(0).setPreferredWidth(172);
        tblAdmin.getColumnModel().getColumn(1).setPreferredWidth(146);
        tblAdmin.getColumnModel().getColumn(2).setPreferredWidth(135);
        tblAdmin.getColumnModel().getColumn(3).setPreferredWidth(191);
        tblAdmin.getColumnModel().getColumn(3).setPreferredWidth(283);
        tblAdmin.getTableHeader().setPreferredSize(new Dimension(0, 40));
        tblAdmin.setOpaque(false);
        tblAdmin.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblAdmin.getColumnModel();
        for(int i = 0; i < Modelkolom.getColumnCount(); i++){
        TableColumn kolom = Modelkolom.getColumn(i);
        kolom.setResizable(false);
        }
        jScrollPaneAdmin.getViewport().setOpaque(false);
        try {
            Connection penghubung = ClassKoneksi.GetConnection();
            Statement st = penghubung.createStatement();
            ResultSet rs = st.executeQuery("select * from admin");
            while (rs.next()) {
                tblDBAdmin.addRow(new Object[]{
                    rs.getString("no_ktp_admin"),
                    rs.getString("nama"),
                    rs.getString("no_hp"),
                    rs.getString("alamat"),
                    rs.getString("gaji")
                });
                tblAdmin.setModel(tblDBAdmin);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat mengambil data pada database" + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    public void TableTeknisi() {
        TableNoEdit tblDBTeknisi = new TableNoEdit();
        tblDBTeknisi.addColumn("No KTP Teknisi");
        tblDBTeknisi.addColumn("Nama Teknisi");
        tblDBTeknisi.addColumn("No Hp");
        tblDBTeknisi.addColumn("Alamat");
        tblDBTeknisi.addColumn("Gaji");
        tblTeknisi.setModel(tblDBTeknisi);
        tblTeknisi.getColumnModel().getColumn(0).setPreferredWidth(172);
        tblTeknisi.getColumnModel().getColumn(1).setPreferredWidth(146);
        tblTeknisi.getColumnModel().getColumn(2).setPreferredWidth(135);
        tblTeknisi.getColumnModel().getColumn(3).setPreferredWidth(191);
        tblTeknisi.getColumnModel().getColumn(3).setPreferredWidth(283);
        tblTeknisi.getTableHeader().setPreferredSize(new Dimension(0, 40));
        tblTeknisi.setOpaque(false);
        tblTeknisi.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblTeknisi.getColumnModel();
        for(int i = 0; i < Modelkolom.getColumnCount(); i++){
        TableColumn kolom = Modelkolom.getColumn(i);
        kolom.setResizable(false);
        }
        jScrollPaneTeknisi.getViewport().setOpaque(false);
        try {
            Connection penghubung = ClassKoneksi.GetConnection();
            Statement st = penghubung.createStatement();
            ResultSet rs = st.executeQuery("select * from teknisi");
            while (rs.next()) {
                tblDBTeknisi.addRow(new Object[]{
                    rs.getString("no_ktp_teknisi"),
                    rs.getString("nama_teknisi"),
                    rs.getString("no_hp"),
                    rs.getString("alamat"),
                    rs.getString("gaji")
                });
                tblTeknisi.setModel(tblDBTeknisi);
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
        lblTransaksiSewa = new javax.swing.JLabel();
        lblPermintaanPerawatan = new javax.swing.JLabel();
        lblTransMainten = new javax.swing.JLabel();
        lblDTPegawai = new javax.swing.JLabel();
        lblDTPenyewa = new javax.swing.JLabel();
        lblLapPengeluaran = new javax.swing.JLabel();
        lblLapAkhir = new javax.swing.JLabel();
        lblKeluar = new javax.swing.JLabel();
        txtNoKtpAdmin = new javax.swing.JTextField();
        txtNamaAdmin = new javax.swing.JTextField();
        txtNoHpAdmin = new javax.swing.JTextField();
        txtNoKtpTeknisi = new javax.swing.JTextField();
        txtNamaTeknisi = new javax.swing.JTextField();
        txtNoHpTeknisi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamatAdmin = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamatTeknisi = new javax.swing.JTextPane();
        btnSimpanAdmin = new javax.swing.JButton();
        btnUbahAdmin = new javax.swing.JButton();
        btnHapusAdmin = new javax.swing.JButton();
        btnSimpanTeknisi = new javax.swing.JButton();
        btnUbahTeknisi = new javax.swing.JButton();
        btnHapusTeknisi = new javax.swing.JButton();
        txtCariAdmin = new javax.swing.JTextField();
        txtCariTeknisi = new javax.swing.JTextField();
        lblCariAdmin = new javax.swing.JLabel();
        lblCariTeknisi = new javax.swing.JLabel();
        jScrollPaneAdmin = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        jScrollPaneTeknisi = new javax.swing.JScrollPane();
        tblTeknisi = new javax.swing.JTable();
        txtGajiAdmin = new javax.swing.JTextField();
        txtGajiTeknisi = new javax.swing.JTextField();
        LblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Pegawai");
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

        lblTransaksiSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTransaksiSewaMouseClicked(evt);
            }
        });
        getContentPane().add(lblTransaksiSewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 345, 320, 60));

        lblPermintaanPerawatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPermintaanPerawatanMouseClicked(evt);
            }
        });
        getContentPane().add(lblPermintaanPerawatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 427, 320, 60));

        lblTransMainten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTransMaintenMouseClicked(evt);
            }
        });
        getContentPane().add(lblTransMainten, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 320, 60));

        lblDTPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDTPegawaiMouseClicked(evt);
            }
        });
        getContentPane().add(lblDTPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 582, 320, 60));

        lblDTPenyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDTPenyewaMouseClicked(evt);
            }
        });
        getContentPane().add(lblDTPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 667, 320, 60));

        lblLapPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLapPengeluaranMouseClicked(evt);
            }
        });
        getContentPane().add(lblLapPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 742, 320, 60));

        lblLapAkhir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLapAkhirMouseClicked(evt);
            }
        });
        getContentPane().add(lblLapAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 817, 320, 60));

        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });
        getContentPane().add(lblKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 950, 120, 50));

        txtNoKtpAdmin.setBackground(new java.awt.Color(249, 249, 249));
        txtNoKtpAdmin.setBorder(null);
        getContentPane().add(txtNoKtpAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 94, 200, 25));

        txtNamaAdmin.setBackground(new java.awt.Color(249, 249, 249));
        txtNamaAdmin.setBorder(null);
        getContentPane().add(txtNamaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 134, 200, 25));

        txtNoHpAdmin.setBackground(new java.awt.Color(249, 249, 249));
        txtNoHpAdmin.setBorder(null);
        getContentPane().add(txtNoHpAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 174, 200, 25));

        txtNoKtpTeknisi.setBackground(new java.awt.Color(249, 249, 249));
        txtNoKtpTeknisi.setBorder(null);
        getContentPane().add(txtNoKtpTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 564, 200, 25));

        txtNamaTeknisi.setBackground(new java.awt.Color(249, 249, 249));
        txtNamaTeknisi.setBorder(null);
        getContentPane().add(txtNamaTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 604, 200, 25));

        txtNoHpTeknisi.setBackground(new java.awt.Color(249, 249, 249));
        txtNoHpTeknisi.setBorder(null);
        getContentPane().add(txtNoHpTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 644, 200, 25));

        jScrollPane1.setBackground(new java.awt.Color(249, 249, 249));
        jScrollPane1.setBorder(null);

        txtAlamatAdmin.setBackground(new java.awt.Color(249, 249, 249));
        txtAlamatAdmin.setBorder(null);
        jScrollPane1.setViewportView(txtAlamatAdmin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 137, 212, 50));

        jScrollPane2.setBackground(new java.awt.Color(249, 249, 249));
        jScrollPane2.setBorder(null);

        txtAlamatTeknisi.setBackground(new java.awt.Color(249, 249, 249));
        txtAlamatTeknisi.setBorder(null);
        jScrollPane2.setViewportView(txtAlamatTeknisi);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 605, 212, 50));

        btnSimpanAdmin.setBorder(null);
        btnSimpanAdmin.setBorderPainted(false);
        btnSimpanAdmin.setContentAreaFilled(false);
        btnSimpanAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpanAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 90, 100, 25));

        btnUbahAdmin.setBorder(null);
        btnUbahAdmin.setBorderPainted(false);
        btnUbahAdmin.setContentAreaFilled(false);
        btnUbahAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbahAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 126, 100, 25));

        btnHapusAdmin.setBorder(null);
        btnHapusAdmin.setBorderPainted(false);
        btnHapusAdmin.setContentAreaFilled(false);
        btnHapusAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapusAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 162, 100, 25));

        btnSimpanTeknisi.setBorder(null);
        btnSimpanTeknisi.setBorderPainted(false);
        btnSimpanTeknisi.setContentAreaFilled(false);
        btnSimpanTeknisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanTeknisiActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpanTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1252, 560, 100, 25));

        btnUbahTeknisi.setBorder(null);
        btnUbahTeknisi.setBorderPainted(false);
        btnUbahTeknisi.setContentAreaFilled(false);
        btnUbahTeknisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahTeknisiActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbahTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1252, 596, 100, 25));

        btnHapusTeknisi.setBorder(null);
        btnHapusTeknisi.setBorderPainted(false);
        btnHapusTeknisi.setContentAreaFilled(false);
        btnHapusTeknisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusTeknisiActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapusTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1252, 632, 100, 25));

        txtCariAdmin.setBackground(new java.awt.Color(249, 249, 249));
        txtCariAdmin.setText("No KTP atau Nama");
        txtCariAdmin.setBorder(null);
        txtCariAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariAdminMouseClicked(evt);
            }
        });
        getContentPane().add(txtCariAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 206, 140, 25));

        txtCariTeknisi.setBackground(new java.awt.Color(249, 249, 249));
        txtCariTeknisi.setText("No KTP atau Nama");
        txtCariTeknisi.setBorder(null);
        txtCariTeknisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariTeknisiMouseClicked(evt);
            }
        });
        getContentPane().add(txtCariTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 676, 140, 25));

        lblCariAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariAdminMouseClicked(evt);
            }
        });
        getContentPane().add(lblCariAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 206, 28, 25));

        lblCariTeknisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariTeknisiMouseClicked(evt);
            }
        });
        getContentPane().add(lblCariTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 675, 30, 25));

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAdmin.setFocusable(false);
        tblAdmin.setRequestFocusEnabled(false);
        tblAdmin.setRowHeight(40);
        tblAdmin.setShowGrid(true);
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        jScrollPaneAdmin.setViewportView(tblAdmin);

        getContentPane().add(jScrollPaneAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 950, 200));

        tblTeknisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTeknisi.setFocusable(false);
        tblTeknisi.setRequestFocusEnabled(false);
        tblTeknisi.setRowHeight(40);
        tblTeknisi.setShowGrid(true);
        tblTeknisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTeknisiMouseClicked(evt);
            }
        });
        jScrollPaneTeknisi.setViewportView(tblTeknisi);
        if (tblTeknisi.getColumnModel().getColumnCount() > 0) {
            tblTeknisi.getColumnModel().getColumn(0).setResizable(false);
            tblTeknisi.getColumnModel().getColumn(1).setResizable(false);
            tblTeknisi.getColumnModel().getColumn(2).setResizable(false);
            tblTeknisi.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPaneTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 712, 950, 200));

        txtGajiAdmin.setBackground(new java.awt.Color(249, 249, 249));
        txtGajiAdmin.setBorder(null);
        getContentPane().add(txtGajiAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 93, 205, 25));

        txtGajiTeknisi.setBackground(new java.awt.Color(249, 249, 249));
        txtGajiTeknisi.setBorder(null);
        getContentPane().add(txtGajiTeknisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 564, 205, 25));

        LblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Data Pegawai owner.png"))); // NOI18N
        getContentPane().add(LblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBerandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBerandaMouseClicked
        HomePageOwner pgHome = new HomePageOwner();
        pgHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBerandaMouseClicked

    private void lblStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStokMouseClicked
        Stock_Owner pgStok = new Stock_Owner();
        pgStok.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblStokMouseClicked

    private void lblTransaksiSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransaksiSewaMouseClicked
        Transaksi_Sewa_Owner pgtransSewa = new Transaksi_Sewa_Owner();
        pgtransSewa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblTransaksiSewaMouseClicked

    private void lblTransMaintenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransMaintenMouseClicked
        Transaksi_Maintenance_Owner pgMainten = new Transaksi_Maintenance_Owner();
        pgMainten.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblTransMaintenMouseClicked

    private void lblDTPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDTPegawaiMouseClicked

    }//GEN-LAST:event_lblDTPegawaiMouseClicked

    private void lblDTPenyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDTPenyewaMouseClicked
        Penyewa_Owner pgPenyewa = new Penyewa_Owner();
        pgPenyewa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblDTPenyewaMouseClicked

    private void lblLapPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLapPengeluaranMouseClicked
        Laporan_Pengeluaran_Owner pgLapPengeluaran = new Laporan_Pengeluaran_Owner();
        pgLapPengeluaran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLapPengeluaranMouseClicked

    private void lblLapAkhirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLapAkhirMouseClicked
        Laporan_Akhir_Owner pgLapAkhir = new Laporan_Akhir_Owner();
        pgLapAkhir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLapAkhirMouseClicked

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar aplikasi ? ", "Konrirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, keluar) == JOptionPane.YES_OPTION) {
            Login pgLogin = new Login();
            pgLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblKeluarMouseClicked

    private void btnSimpanAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanAdminActionPerformed
        String no_ktp_admin = txtNoKtpAdmin.getText();
        String nama_admin = txtNamaAdmin.getText().toLowerCase();
        String no_hp = txtNoHpAdmin.getText();
        int gaji = Integer.parseInt(txtGajiAdmin.getText());
        String Alamat = txtAlamatAdmin.getText().toLowerCase();
        if (no_ktp_admin != null && no_ktp_admin.length() == 16 && nama_admin != null && nama_admin.matches("[a-zA-Z .]+") && nama_admin.length() <= 50 && no_hp != null && no_hp.length() <= 13 && no_hp.length() >= 12 && no_hp.matches("\\d+") && Alamat != null && Alamat.length() <= 100 && Alamat.matches("[a-zA-Z ,.]+") && gaji != 0) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String UserAkun = UsernameAdmin(no_ktp_admin);
                String sql = "insert into admin value ('" + no_ktp_admin + "','" + nama_admin + "','" + no_hp + "','" + Alamat + "','" + gaji + "', '" + UserAkun + "')";
                if (JOptionPane.showConfirmDialog(null, "Simpan data Admin ? \n"
                        + "No KTP = " + no_ktp_admin + "\n"
                        + "Nama = " + nama_admin + "\n"
                        + "No Hp = " + no_hp + "\n"
                        + "Gaji = " + gaji + "\n"
                        + "Alamat = " + Alamat, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, user) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNoKtpAdmin.setText("");
                    txtNamaAdmin.setText("");
                    txtNoHpAdmin.setText("");
                    txtAlamatAdmin.setText("");
                    txtGajiAdmin.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data admin ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TableAdmin();
    }//GEN-LAST:event_btnSimpanAdminActionPerformed

    private void btnUbahAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahAdminActionPerformed
        String no_ktp_admin = txtNoKtpAdmin.getText();
        String nama_admin = txtNamaAdmin.getText().toLowerCase();
        String no_hp = txtNoHpAdmin.getText();
        int gaji = Integer.parseInt(txtGajiAdmin.getText());
        String Alamat = txtAlamatAdmin.getText().toLowerCase();
        int pilih_baris = tblAdmin.getSelectedRow();
        if (no_ktp_admin != null && no_ktp_admin.length() == 16 && nama_admin != null && nama_admin.matches("[a-zA-Z .]+") && nama_admin.length() <= 50 && no_hp != null && no_hp.length() <= 13 && no_hp.length() >= 12 && no_hp.matches("\\d+") && Alamat != null && Alamat.length() <= 100 && Alamat.matches("[a-zA-Z ,.]+") && gaji != 0) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String no_ktp = NoKtpAdmin(tblAdmin.getValueAt(pilih_baris, 0).toString());
                String sql = "UPDATE admin SET no_ktp_admin = '" + no_ktp_admin + "', nama = '" + nama_admin + "', no_hp = '" + no_hp + "', alamat = '" + Alamat + "', gaji = '" + gaji + "' WHERE no_ktp_admin = '" + no_ktp + "'";
                if (JOptionPane.showConfirmDialog(null, "Simpan perubahan ? \n"
                        + "No KTP = " + no_ktp_admin + "\n"
                        + "Nama = " + nama_admin + "\n"
                        + "No Hp = " + no_hp + "\n"
                        + "Gaji = " + gaji + "\n"
                        + "Alamat = " + Alamat, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNoKtpAdmin.setText("");
                    txtNamaAdmin.setText("");
                    txtNoHpAdmin.setText("");
                    txtAlamatAdmin.setText("");
                    txtGajiAdmin.setText("");
                } else {
                    txtNoKtpAdmin.setText("");
                    txtNamaAdmin.setText("");
                    txtNoHpAdmin.setText("");
                    txtAlamatAdmin.setText("");
                    txtGajiAdmin.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mengubah data admin ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Isi data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TableAdmin();
    }//GEN-LAST:event_btnUbahAdminActionPerformed

    private void btnHapusAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusAdminActionPerformed
        int pilih_baris = tblAdmin.getSelectedRow();
        if (pilih_baris != -1) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String no_ktp = tblAdmin.getValueAt(pilih_baris, 0).toString();
                String sql = "delete from admin where no_ktp_admin = '" + no_ktp + "'";
                if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, hapus) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                } else {
                    txtNoKtpAdmin.setText("");
                    txtNamaAdmin.setText("");
                    txtNoHpAdmin.setText("");
                    txtAlamatAdmin.setText("");
                    txtGajiAdmin.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        }
        TableAdmin();
    }//GEN-LAST:event_btnHapusAdminActionPerformed

    private void lblCariAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariAdminMouseClicked
        String CariData = txtCariAdmin.getText();
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            if (!CariData.equals("")) {
                String sql = "select * from admin where no_ktp_admin = '" + CariData + "' OR nama = '" + CariData + "'";
                ResultSet rs = st.executeQuery(sql);
                TableNoEdit tblDBAdmin = new TableNoEdit();
                tblDBAdmin.addColumn("No KTP Admin");
                tblDBAdmin.addColumn("Nama Admin");
                tblDBAdmin.addColumn("No Hp");
                tblDBAdmin.addColumn("Alamat");
                tblDBAdmin.addColumn("Gaji");
                tblAdmin.setModel(tblDBAdmin);
                tblAdmin.getColumnModel().getColumn(0).setPreferredWidth(172);
                tblAdmin.getColumnModel().getColumn(1).setPreferredWidth(146);
                tblAdmin.getColumnModel().getColumn(2).setPreferredWidth(135);
                tblAdmin.getColumnModel().getColumn(3).setPreferredWidth(191);
                tblAdmin.getColumnModel().getColumn(3).setPreferredWidth(283);
                tblAdmin.getTableHeader().setPreferredSize(new Dimension(0, 40));
                tblAdmin.setOpaque(false);
                tblAdmin.getTableHeader().setReorderingAllowed(false);
                TableColumnModel Modelkolom = tblAdmin.getColumnModel();
                for(int i = 0; i < Modelkolom.getColumnCount(); i++){
                TableColumn kolom = Modelkolom.getColumn(i);
                kolom.setResizable(false);
                }
                jScrollPaneAdmin.getViewport().setOpaque(false);
                if (rs.next()) {
                    tblDBAdmin.addRow(new Object[]{
                        rs.getString("no_ktp_admin"),
                        rs.getString("nama"),
                        rs.getString("no_hp"),
                        rs.getString("alamat"),
                        rs.getString("gaji")
                    });
                    tblAdmin.setModel(tblDBAdmin);
                    txtCariAdmin.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan !", "Kesalahan", JOptionPane.INFORMATION_MESSAGE, notFound);
                    TableAdmin();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Masukan No KTP atau nama admin", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mencari data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_lblCariAdminMouseClicked

    private void btnSimpanTeknisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanTeknisiActionPerformed
        String no_ktp_teknisi = txtNoKtpTeknisi.getText();
        String nama_teknisi = txtNamaTeknisi.getText().toLowerCase();
        String no_hp = txtNoHpTeknisi.getText();
        int gaji = Integer.parseInt(txtGajiTeknisi.getText());
        String Alamat = txtAlamatTeknisi.getText().toLowerCase();
        if (!no_ktp_teknisi.isEmpty() && no_ktp_teknisi.length() == 16 && !nama_teknisi.isEmpty() && nama_teknisi.matches("[a-zA-Z .]+") && !no_hp.isEmpty() && no_hp.length() <= 13 && no_hp.length() >= 12 && !Alamat.isEmpty() && Alamat.length() <= 100 && Alamat.matches("[a-zA-Z ,.]+") && gaji != 0) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String UserAkun = UsernameTeknisi(no_ktp_teknisi);
                String sql = "insert into teknisi value ('" + no_ktp_teknisi + "','" + nama_teknisi + "','" + no_hp + "','" + Alamat + "','" + gaji + "', '" + UserAkun + "')";
                if (JOptionPane.showConfirmDialog(null, "Simpan data teknisi ? \n"
                        + "No KTP = " + no_ktp_teknisi + "\n"
                        + "Nama = " + nama_teknisi + "\n"
                        + "No Hp = " + no_hp + "\n"
                        + "Gaji = " + gaji + "\n"
                        + "Alamat = " + Alamat, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, user) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNoKtpTeknisi.setText("");
                    txtNamaTeknisi.setText("");
                    txtNoHpTeknisi.setText("");
                    txtAlamatTeknisi.setText("");
                    txtGajiTeknisi.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data teknisi", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Isi Data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TableTeknisi();
    }//GEN-LAST:event_btnSimpanTeknisiActionPerformed

    private void btnUbahTeknisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahTeknisiActionPerformed
        String no_ktp_teknisi = txtNoKtpTeknisi.getText();
        String nama_teknisi = txtNamaTeknisi.getText().toLowerCase();
        String no_hp = txtNoHpTeknisi.getText();
        int gaji = Integer.parseInt(txtGajiTeknisi.getText());
        String Alamat = txtAlamatTeknisi.getText().toLowerCase();
        int pilih_baris = tblTeknisi.getSelectedRow();
        if (!no_ktp_teknisi.isEmpty() && no_ktp_teknisi.length() == 16 && !nama_teknisi.isEmpty() && nama_teknisi.matches("[a-zA-Z .]+") && !no_hp.isEmpty() && no_hp.length() <= 13 && no_hp.length() >= 12 && !Alamat.isEmpty() && Alamat.length() <= 100 && Alamat.matches("[a-zA-Z ,.]+") && gaji != 0) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                String noKtp = NoKtpTeknisi(tblTeknisi.getValueAt(pilih_baris, 0).toString());
                String sql = "UPDATE teknisi SET no_ktp_teknisi = '" + no_ktp_teknisi + "', nama_teknisi = '" + nama_teknisi + "', no_hp = '" + no_hp + "',"
                        + " alamat = '" + Alamat + "', gaji = '" + gaji + "' WHERE no_ktp_teknisi = '" + noKtp + "'";
                if (JOptionPane.showConfirmDialog(null, "Simpan perubahan ? \n"
                        + "No KTP = " + no_ktp_teknisi + "\n"
                        + "Nama = " + nama_teknisi + "\n"
                        + "No Hp = " + no_hp + "\n"
                        + "Gaji = " + gaji + "\n"
                        + "Alamat = " + Alamat, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                    txtNoKtpTeknisi.setText("");
                    txtNamaTeknisi.setText("");
                    txtNoHpTeknisi.setText("");
                    txtAlamatTeknisi.setText("");
                    txtGajiTeknisi.setText("");
                } else {
                    txtNoKtpTeknisi.setText("");
                    txtNamaTeknisi.setText("");
                    txtNoHpTeknisi.setText("");
                    txtAlamatTeknisi.setText("");
                    txtGajiTeknisi.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mengubah data teknisi", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Isi data dengan benar !", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
        TableTeknisi();
    }//GEN-LAST:event_btnUbahTeknisiActionPerformed

    private void btnHapusTeknisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusTeknisiActionPerformed
        int pilih_baris = tblTeknisi.getSelectedRow();
        if (pilih_baris != -1) {
            try {
                Connection koneksi = ClassKoneksi.GetConnection();
                Statement st = koneksi.createStatement();
                if (JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ? ", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, hapus) == JOptionPane.YES_OPTION) {
                    String no_ktp = tblTeknisi.getValueAt(pilih_baris, 0).toString();
                    String sql = "delete from teknisi where no_ktp_teknisi = '" + no_ktp + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
                    st.close();
                } else {
                    txtNoKtpTeknisi.setText("");
                    txtNamaTeknisi.setText("");
                    txtNoHpTeknisi.setText("");
                    txtAlamatTeknisi.setText("");
                    txtGajiTeknisi.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }
        }
        TableTeknisi();
    }//GEN-LAST:event_btnHapusTeknisiActionPerformed

    private void lblCariTeknisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariTeknisiMouseClicked
        String CariData = txtCariTeknisi.getText();
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();

            if (!CariData.equals("")) {
                String sql = "select * from teknisi where no_ktp_teknisi = '" + CariData + "' OR nama_teknisi = '" + CariData + "'";
                ResultSet rs = st.executeQuery(sql);
                TableNoEdit tblDBTeknisi = new TableNoEdit();
                tblDBTeknisi.addColumn("No KTP Teknisi");
                tblDBTeknisi.addColumn("Nama Teknisi");
                tblDBTeknisi.addColumn("No Hp");
                tblDBTeknisi.addColumn("Alamat");
                tblDBTeknisi.addColumn("Gaji");
                tblTeknisi.setModel(tblDBTeknisi);
                tblTeknisi.getColumnModel().getColumn(0).setPreferredWidth(172);
                tblTeknisi.getColumnModel().getColumn(1).setPreferredWidth(146);
                tblTeknisi.getColumnModel().getColumn(2).setPreferredWidth(135);
                tblTeknisi.getColumnModel().getColumn(3).setPreferredWidth(191);
                tblTeknisi.getColumnModel().getColumn(3).setPreferredWidth(283);
                tblTeknisi.getTableHeader().setPreferredSize(new Dimension(0, 40));
                tblTeknisi.setOpaque(false);
                tblTeknisi.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblTeknisi.getColumnModel();
        for(int i = 0; i < Modelkolom.getColumnCount(); i++){
        TableColumn kolom = Modelkolom.getColumn(i);
        kolom.setResizable(false);
        }
                jScrollPaneTeknisi.getViewport().setOpaque(false);
                if (rs.next()) {
                    tblDBTeknisi.addRow(new Object[]{
                        rs.getString("no_ktp_teknisi"),
                        rs.getString("nama_teknisi"),
                        rs.getString("no_hp"),
                        rs.getString("alamat"),
                        rs.getString("gaji")
                    });
                    tblTeknisi.setModel(tblDBTeknisi);
                    txtCariTeknisi.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan !", "Kesalahan", JOptionPane.INFORMATION_MESSAGE, notFound);
                    TableTeknisi();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Masukan No KTP atau nama teknisi", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mencari data ", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_lblCariTeknisiMouseClicked

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
        int row = tblAdmin.rowAtPoint(evt.getPoint());
        if (row >= 0 && row < tblAdmin.getRowCount()) {
            isiTextFieldAdmin(row);
        }
    }//GEN-LAST:event_tblAdminMouseClicked

    private void tblTeknisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTeknisiMouseClicked
        int row = tblTeknisi.rowAtPoint(evt.getPoint());
        if (row >= 0 && row < tblTeknisi.getRowCount()) {
            isiTextFieldTeknisi(row);
        }
    }//GEN-LAST:event_tblTeknisiMouseClicked

    private void txtCariAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariAdminMouseClicked
        txtCariAdmin.setText("");
    }//GEN-LAST:event_txtCariAdminMouseClicked

    private void txtCariTeknisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariTeknisiMouseClicked
        txtCariTeknisi.setText("");
    }//GEN-LAST:event_txtCariTeknisiMouseClicked

    private void lblPermintaanPerawatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPermintaanPerawatanMouseClicked
        Permintaan_Perawatan_Owner pgRequest = new Permintaan_Perawatan_Owner();
        pgRequest.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblPermintaanPerawatanMouseClicked
    private void isiTextFieldAdmin(int row) {
        int pilih_baris = tblAdmin.getSelectedRow();
        if (pilih_baris >= 0) {
            String NoKtpAdmin = tblAdmin.getValueAt(pilih_baris, 0).toString();
            String Nama = tblAdmin.getValueAt(pilih_baris, 1).toString();
            String NoHp = tblAdmin.getValueAt(pilih_baris, 2).toString();
            String Alamat = tblAdmin.getValueAt(pilih_baris, 3).toString();
            String Gaji = tblAdmin.getValueAt(pilih_baris, 4).toString();
            txtNoKtpAdmin.setText(NoKtpAdmin);
            txtNamaAdmin.setText(Nama);
            txtNoHpAdmin.setText(NoHp);
            txtAlamatAdmin.setText(Alamat);
            txtGajiAdmin.setText(Gaji);
        }
    }

    private void isiTextFieldTeknisi(int row) {
        int pilih_baris = tblTeknisi.getSelectedRow();
        if (pilih_baris >= 0) {
            String NoKtpTeknisi = tblTeknisi.getValueAt(pilih_baris, 0).toString();
            String Nama = tblTeknisi.getValueAt(pilih_baris, 1).toString();
            String NoHp = tblTeknisi.getValueAt(pilih_baris, 2).toString();
            String Alamat = tblTeknisi.getValueAt(pilih_baris, 3).toString();
            String Gaji = tblTeknisi.getValueAt(pilih_baris, 4).toString();
            txtNoKtpTeknisi.setText(NoKtpTeknisi);
            txtNamaTeknisi.setText(Nama);
            txtNoHpTeknisi.setText(NoHp);
            txtAlamatTeknisi.setText(Alamat);
            txtGajiTeknisi.setText(Gaji);
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
            java.util.logging.Logger.getLogger(Data_Pegawai_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Pegawai_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Pegawai_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Pegawai_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Pegawai_Owner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblBackground;
    private javax.swing.JButton btnHapusAdmin;
    private javax.swing.JButton btnHapusTeknisi;
    private javax.swing.JButton btnSimpanAdmin;
    private javax.swing.JButton btnSimpanTeknisi;
    private javax.swing.JButton btnUbahAdmin;
    private javax.swing.JButton btnUbahTeknisi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneAdmin;
    private javax.swing.JScrollPane jScrollPaneTeknisi;
    private javax.swing.JLabel lblBeranda;
    private javax.swing.JLabel lblCariAdmin;
    private javax.swing.JLabel lblCariTeknisi;
    private javax.swing.JLabel lblDTPegawai;
    private javax.swing.JLabel lblDTPenyewa;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblLapAkhir;
    private javax.swing.JLabel lblLapPengeluaran;
    private javax.swing.JLabel lblPermintaanPerawatan;
    private javax.swing.JLabel lblStok;
    private javax.swing.JLabel lblTransMainten;
    private javax.swing.JLabel lblTransaksiSewa;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTable tblTeknisi;
    private javax.swing.JTextPane txtAlamatAdmin;
    private javax.swing.JTextPane txtAlamatTeknisi;
    private javax.swing.JTextField txtCariAdmin;
    private javax.swing.JTextField txtCariTeknisi;
    private javax.swing.JTextField txtGajiAdmin;
    private javax.swing.JTextField txtGajiTeknisi;
    private javax.swing.JTextField txtNamaAdmin;
    private javax.swing.JTextField txtNamaTeknisi;
    private javax.swing.JTextField txtNoHpAdmin;
    private javax.swing.JTextField txtNoHpTeknisi;
    private javax.swing.JTextField txtNoKtpAdmin;
    private javax.swing.JTextField txtNoKtpTeknisi;
    // End of variables declaration//GEN-END:variables
}
