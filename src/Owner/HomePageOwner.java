package Owner;
import Login.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import KoneksiDatabase.ClassKoneksi;
import javax.swing.ImageIcon;

public class HomePageOwner extends javax.swing.JFrame {

    public HomePageOwner() {
        initComponents();
        Item();
    }
    
    ImageIcon keluar = new ImageIcon(getClass().getResource("/Images/icon keluar.png"));
    
// Variable Global
    private int harga;
    private int stok;
    private String nama_alat;
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
        lblKeluar = new javax.swing.JLabel();
        lblHargaMolen = new javax.swing.JLabel();
        lblstokmolen = new javax.swing.JLabel();
        lblHargaScaffolding = new javax.swing.JLabel();
        lblStokScaffolding = new javax.swing.JLabel();
        LblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Beranda");
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

        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });
        getContentPane().add(lblKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 950, 120, 50));

        lblHargaMolen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        getContentPane().add(lblHargaMolen, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 770, 260, 40));

        lblstokmolen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        getContentPane().add(lblstokmolen, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 820, 260, 40));

        lblHargaScaffolding.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        getContentPane().add(lblHargaScaffolding, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 770, 190, 30));

        lblStokScaffolding.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        getContentPane().add(lblStokScaffolding, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 820, 220, 30));

        LblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HomePage Owner.png"))); // NOI18N
        getContentPane().add(LblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1024));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Item(){
    try {
        Connection koneksi = ClassKoneksi.GetConnection();
        Statement st = koneksi.createStatement();
        String sql = "SELECT * from alat";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            nama_alat = rs.getString("nama_alat");
            if("molen".equals(nama_alat)){
            harga = rs.getInt("harga_sewa");
            stok = rs.getInt("stock");
            lblHargaMolen.setText("Harga Sewa = " + harga);
            lblstokmolen.setText("Tersedia = " + stok);
            } else if ("scaffolding".equals(nama_alat)){
            harga = rs.getInt("harga_sewa");
            stok = rs.getInt("stock");
            lblHargaScaffolding.setText("Harga Sewa = " + harga);
            lblStokScaffolding.setText("Tersedia = " + stok);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Kesalahan dalam label Item Homepage " + e);
    }
}
    private void lblBerandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBerandaMouseClicked

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

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar aplikasi ? ", "Konrirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, keluar) == JOptionPane.YES_OPTION){
        Login pgLogin = new Login();
        pgLogin.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_lblKeluarMouseClicked

    private void lblPermintaanMaintenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPermintaanMaintenMouseClicked
        Permintaan_Perawatan_Owner pgRequest = new Permintaan_Perawatan_Owner();
        pgRequest.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblPermintaanMaintenMouseClicked

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
            java.util.logging.Logger.getLogger(HomePageOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePageOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePageOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePageOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePageOwner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblBackground;
    private javax.swing.JLabel lblBeranda;
    private javax.swing.JLabel lblDataPegawai;
    private javax.swing.JLabel lblDataPenyewa;
    private javax.swing.JLabel lblHargaMolen;
    private javax.swing.JLabel lblHargaScaffolding;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblLaporanAkhir;
    private javax.swing.JLabel lblLaporanPengeluaran;
    private javax.swing.JLabel lblPageStok;
    private javax.swing.JLabel lblPageTransSewa;
    private javax.swing.JLabel lblPermintaanMainten;
    private javax.swing.JLabel lblStokScaffolding;
    private javax.swing.JLabel lblTransPerawatan;
    private javax.swing.JLabel lblstokmolen;
    // End of variables declaration//GEN-END:variables
}
