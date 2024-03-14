package Owner;
import Login.*;
import Table.TableNoEdit;
import KoneksiDatabase.ClassKoneksi;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Permintaan_Perawatan_Owner extends javax.swing.JFrame {

    public Permintaan_Perawatan_Owner() {
        initComponents();
        TabelDataMainten();
    }

    ImageIcon error = new ImageIcon(getClass().getResource("/Images/icon error.png"));
    ImageIcon simpan = new ImageIcon(getClass().getResource("/Images/icon save.png"));
    ImageIcon ubah = new ImageIcon(getClass().getResource("/Images/icon ubah.png"));
    ImageIcon keluar = new ImageIcon(getClass().getResource("/Images/icon keluar.png"));

    public void TabelDataMainten() {
        TableNoEdit TblDbMainten = new TableNoEdit();
        TblDbMainten.addColumn("ID Permintaan");
        TblDbMainten.addColumn("Nama Alat");
        TblDbMainten.addColumn("Jumlah");
        TblDbMainten.addColumn("Nama Admin");
        TblDbMainten.addColumn("Status");
        TblPermintaanMainten.setModel(TblDbMainten);
        TblPermintaanMainten.getColumnModel().getColumn(0).setPreferredWidth(236);
        TblPermintaanMainten.getColumnModel().getColumn(1).setPreferredWidth(175);
        TblPermintaanMainten.getColumnModel().getColumn(2).setPreferredWidth(227);
        TblPermintaanMainten.getColumnModel().getColumn(3).setPreferredWidth(195);
        TblPermintaanMainten.getTableHeader().setPreferredSize(new Dimension(0, 40));
        TblPermintaanMainten.setOpaque(false);
        TblPermintaanMainten.getTableHeader().setReorderingAllowed(false);
        TableColumnModel Modelkolom = TblPermintaanMainten.getColumnModel();
        for(int i = 0; i < Modelkolom.getColumnCount(); i++){
            TableColumn kolom = Modelkolom.getColumn(i);
            kolom.setResizable(false);
        }
        jScrollPane1.getViewport().setOpaque(false);
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
                TblPermintaanMainten.setModel(TblDbMainten);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat mengambil data pada database" + e, "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBeranda = new javax.swing.JLabel();
        lblPageStok = new javax.swing.JLabel();
        lblPageTransSewa = new javax.swing.JLabel();
        lblPermintaanMainten = new javax.swing.JLabel();
        lblTransPerawatan = new javax.swing.JLabel();
        lblDataPegawai = new javax.swing.JLabel();
        lblDataPenyewa = new javax.swing.JLabel();
        lblLaporanPengeluaran = new javax.swing.JLabel();
        lblLaporanAkhir = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnUbahStatus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblPermintaanMainten = new javax.swing.JTable();
        btnKeluar = new javax.swing.JButton();
        lblKeluar = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Permintaan Perawatan");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        cmbStatus.setBackground(new java.awt.Color(249, 249, 249));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "di proses", "selesai" }));
        getContentPane().add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 511, 150, 25));

        btnUbahStatus.setBackground(new java.awt.Color(249, 249, 249));
        btnUbahStatus.setBorder(null);
        btnUbahStatus.setBorderPainted(false);
        btnUbahStatus.setContentAreaFilled(false);
        btnUbahStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahStatusActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbahStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(848, 511, 90, 25));

        TblPermintaanMainten.setModel(new javax.swing.table.DefaultTableModel(
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
        TblPermintaanMainten.setRowHeight(40);
        TblPermintaanMainten.setShowGrid(true);
        jScrollPane1.setViewportView(TblPermintaanMainten);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 559, 840, 330));

        btnKeluar.setBorder(null);
        btnKeluar.setBorderPainted(false);
        btnKeluar.setContentAreaFilled(false);
        getContentPane().add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1242, 956, 90, 40));

        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });
        getContentPane().add(lblKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 950, 120, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Permintaan Perawatan owner.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahStatusActionPerformed
        String status = (String) cmbStatus.getSelectedItem();
        int pilih_baris = TblPermintaanMainten.getSelectedRow();
        String id_permintaan = TblPermintaanMainten.getValueAt(pilih_baris, 0).toString();
        try {
            Connection koneksi = ClassKoneksi.GetConnection();
            Statement st = koneksi.createStatement();
            String sql = "UPDATE daftar_perawatan SET status = '" + status + "' WHERE id_permintaan = '"+id_permintaan+"'";
            if (JOptionPane.showConfirmDialog(null, "Ubah status permintaan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ubah) == JOptionPane.YES_OPTION) {
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Status berhasil diubah", "Sukses !", JOptionPane.INFORMATION_MESSAGE, simpan);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat mengambil data pada database", "Kesalahan", JOptionPane.ERROR_MESSAGE, error);
        }
    TabelDataMainten();
    }//GEN-LAST:event_btnUbahStatusActionPerformed

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar aplikasi ? ", "Konrirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, keluar) == JOptionPane.YES_OPTION){
        Login pgLogin = new Login();
        pgLogin.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_lblKeluarMouseClicked

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
        Laporan_Akhir_Owner pgLapAkhir = new Laporan_Akhir_Owner();
        pgLapAkhir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLaporanAkhirMouseClicked

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
            java.util.logging.Logger.getLogger(Permintaan_Perawatan_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Permintaan_Perawatan_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Permintaan_Perawatan_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Permintaan_Perawatan_Owner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Permintaan_Perawatan_Owner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblPermintaanMainten;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnUbahStatus;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBeranda;
    private javax.swing.JLabel lblDataPegawai;
    private javax.swing.JLabel lblDataPenyewa;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblLaporanAkhir;
    private javax.swing.JLabel lblLaporanPengeluaran;
    private javax.swing.JLabel lblPageStok;
    private javax.swing.JLabel lblPageTransSewa;
    private javax.swing.JLabel lblPermintaanMainten;
    private javax.swing.JLabel lblTransPerawatan;
    // End of variables declaration//GEN-END:variables
}
