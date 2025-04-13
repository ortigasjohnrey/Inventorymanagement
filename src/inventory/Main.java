/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

/**
 *
 * @author JOHN MICHAEL ORTIGAS
 */
public class Main extends javax.swing.JFrame {
    productRegistration prodReg = new productRegistration();
    stockMonitoring stockM = new stockMonitoring();
    inventoryUpdates inventUp = new inventoryUpdates();
    DatabaseConnection db = new DatabaseConnection("inventories");
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inventoryUp = new javax.swing.JButton();
        productRegistration = new javax.swing.JButton();
        stocksMonitor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        inventoryUp.setText("Inventory Updates");
        inventoryUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryUpActionPerformed(evt);
            }
        });
        getContentPane().add(inventoryUp);
        inventoryUp.setBounds(210, 330, 390, 70);

        productRegistration.setText("Product Registration");
        productRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productRegistrationActionPerformed(evt);
            }
        });
        getContentPane().add(productRegistration);
        productRegistration.setBounds(210, 60, 390, 70);

        stocksMonitor.setText("Stock Monitoring");
        stocksMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocksMonitorActionPerformed(evt);
            }
        });
        getContentPane().add(stocksMonitor);
        stocksMonitor.setBounds(210, 190, 390, 70);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void stocksMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocksMonitorActionPerformed
            stockM.refreshTable();
            stockM.setVisible(true);
    }//GEN-LAST:event_stocksMonitorActionPerformed

    private void inventoryUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryUpActionPerformed
        inventUp.refreshTable();
        inventUp.setVisible(true);
    }//GEN-LAST:event_inventoryUpActionPerformed

    private void productRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productRegistrationActionPerformed
        prodReg.refreshTable();
        prodReg.setVisible(true);
    }//GEN-LAST:event_productRegistrationActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inventoryUp;
    private javax.swing.JButton productRegistration;
    private javax.swing.JButton stocksMonitor;
    // End of variables declaration//GEN-END:variables
}
