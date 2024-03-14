package Owner;

import KoneksiDatabase.ClassKoneksi;
import Login.*;
import Table.TableNoEdit;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Laporan_Akhir_Owner extends javax.swing.JFrame {

    public Laporan_Akhir_Owner() {
        initComponents();
        TabelLaporanAkhir();
        AmbilPemasukan();
        AmbilPengeluaran();
        LabaBersih();
        totalGaji();
        totalPengeluaranEkseternal();
    }

    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon keluar = new ImageIcon(getClass().getResource("/Images/icon keluar.png"));

    public void TabelLaporanAkhir() {
        AmbilPemasukan();
        AmbilPengeluaran();
        LabaBersih();
        totalGaji();
        totalPengeluaranEkseternal();
        TableNoEdit TblDbLapAkhir = new TableNoEdit();
        TblDbLapAkhir.addColumn("Bulan");
        TblDbLapAkhir.addColumn("Pemasukan Sewa");
        TblDbLapAkhir.addColumn("Pengeluaran Perawatan");
        TblDbLapAkhir.addColumn("Total Pengeluaran");
        TblDbLapAkhir.addColumn("Laba Bersih");
        tblLaporan.setModel(TblDbLapAkhir);
        tblLaporan.getColumnModel().getColumn(0).setPreferredWidth(138);
        tblLaporan.getColumnModel().getColumn(1).setPreferredWidth(203);
        tblLaporan.getColumnModel().getColumn(2).setPreferredWidth(189);
        tblLaporan.getColumnModel().getColumn(3).setPreferredWidth(186);
        tblLaporan.getColumnModel().getColumn(4).setPreferredWidth(262);
        tblLaporan.getTableHeader().setPreferredSize(new Dimension(0, 40));
        tblLaporan.setOpaque(false);
        tblLaporan.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = tblLaporan.getColumnModel();
        for (int i = 0; i < Modelkolom.getColumnCount(); i++) {
            TableColumn kolom = Modelkolom.getColumn(i);
            kolom.setResizable(false);
        }
        jScrollPaneLaporan.getViewport().setOpaque(false);

        try {
            String sql = "SELECT * from laporan_akhir";
            Connection penghubung = ClassKoneksi.GetConnection();
            Statement st = penghubung.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                TblDbLapAkhir.addRow(new Object[]{
                    rs.getString("bulan"),
                    rs.getString("pemasukan_sewa"),
                    rs.getString("pengeluaran_perawatan"),
                    rs.getString("pengeluaran_eksternal"),
                    rs.getString("laba_bersih"),});
                tblLaporan.setModel(TblDbLapAkhir);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghitung total pemasukan kotor " + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    private void AmbilPemasukan() {
        String sql = "INSERT INTO laporan_akhir(bulan, pemasukan_sewa) SELECT DATE_FORMAT(awal_sewa, '%Y-%m') AS bulan, SUM(biaya_sewa) AS total_biaya_sewa FROM transaksi_menyewa GROUP BY DATE_FORMAT(awal_sewa, '%Y-%m') ON DUPLICATE KEY UPDATE pemasukan_sewa = VALUES(pemasukan_sewa)";
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghitung total pemasukan kotor " + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    private void AmbilPengeluaran() {
        String sql = "INSERT INTO laporan_akhir(bulan, pengeluaran_perawatan) SELECT DATE_FORMAT(tanggal, '%Y-%m') AS bulan, SUM(biaya_perawatan) AS total_biaya_perawatan FROM perawatan GROUP BY DATE_FORMAT(tanggal, '%Y-%m') ON DUPLICATE KEY UPDATE pengeluaran_perawatan = VALUES(pengeluaran_perawatan)";
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghitung total pemasukan kotor " + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }

    }

    private void totalPengeluaranEkseternal() {
        String sqlTotal = "UPDATE laporan_akhir SET pengeluaran_eksternal = COALESCE((SELECT SUM(jumlah_pengeluaran) FROM laporan_pengeluaran WHERE MONTH(tanggal) = SUBSTRING(bulan,6,2) AND YEAR(tanggal) = SUBSTRING(bulan,1,4)),0);";
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            st.executeUpdate(sqlTotal);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghitung total pemasukan kotor " + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    private void totalGaji() {
        String sqlGaji = "UPDATE laporan_akhir SET gaji_pegawai = COALESCE((SELECT SUM(gaji) FROM admin),0) + COALESCE((SELECT SUM(gaji) FROM teknisi), 0)";
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            st.executeUpdate(sqlGaji);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghitung total gaji " + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    private void LabaBersih() {
        String sql = "UPDATE laporan_akhir SET laba_bersih = pemasukan_sewa - pengeluaran_eksternal - gaji_pegawai - pengeluaran_perawatan";
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghitung laba bersih " + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneLaporan = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        lblCari = new javax.swing.JLabel();
        lblBeranda = new javax.swing.JLabel();
        lblPageStok = new javax.swing.JLabel();
        lblPageTransSewa = new javax.swing.JLabel();
        lblPermintaanMainten = new javax.swing.JLabel();
        lblTransPerawatan = new javax.swing.JLabel();
        lblDataPegawai = new javax.swing.JLabel();
        lblDataPenyewa = new javax.swing.JLabel();
        lblLaporanPengeluaran = new javax.swing.JLabel();
        lblLaporanAkhir = new javax.swing.JLabel();
        lblKeluar = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laporan Akhir");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLaporan.setFocusable(false);
        tblLaporan.setRowHeight(40);
        tblLaporan.setShowGrid(true);
        tblLaporan.getTableHeader().setReorderingAllowed(false);
        jScrollPaneLaporan.setViewportView(tblLaporan);
        if (tblLaporan.getColumnModel().getColumnCount() > 0) {
            tblLaporan.getColumnModel().getColumn(0).setResizable(false);
            tblLaporan.getColumnModel().getColumn(1).setResizable(false);
            tblLaporan.getColumnModel().getColumn(2).setResizable(false);
            tblLaporan.getColumnModel().getColumn(3).setResizable(false);
            tblLaporan.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPaneLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 180, 980, 710));

        txtCari.setBackground(new java.awt.Color(249, 249, 249));
        txtCari.setBorder(null);
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1156, 145, 178, 25));

        lblCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariMouseClicked(evt);
            }
        });
        getContentPane().add(lblCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 146, 30, 24));

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

        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });
        getContentPane().add(lblKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 950, 120, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Laporan Akhir owner.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        Transaksi_Sewa_Owner pgSewa = new Transaksi_Sewa_Owner();
        pgSewa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblPageTransSewaMouseClicked

    private void lblPermintaanMaintenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPermintaanMaintenMouseClicked
        Permintaan_Perawatan_Owner pgRequest = new Permintaan_Perawatan_Owner();
        pgRequest.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblPermintaanMaintenMouseClicked

    private void lblTransPerawatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransPerawatanMouseClicked
        Transaksi_Maintenance_Owner pgMainten = new Transaksi_Maintenance_Owner();
        pgMainten.setVisible(true);
        this.dispose();
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

    }//GEN-LAST:event_lblLaporanAkhirMouseClicked

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar aplikasi ? ", "Konrirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, keluar) == JOptionPane.YES_OPTION) {
            Login pgLogin = new Login();
            pgLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblKeluarMouseClicked

    private void lblCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariMouseClicked

    }//GEN-LAST:event_lblCariMouseClicked

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
            java.util.logging.Logger.getLogger(Laporan_Akhir_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_Akhir_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_Akhir_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_Akhir_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_Akhir_Owner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPaneLaporan;
    private javax.swing.JLabel lblBackground;
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
    private javax.swing.JTable tblLaporan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
