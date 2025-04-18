/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOHN MICHAEL ORTIGAS
 */
public class inventoryUpdates extends javax.swing.JFrame {
    DatabaseConnection db;
    private String id;
    private int qty;
    private double prices; 

    /**
     * Creates new form inventoryUpdates
     */
    public inventoryUpdates() {
        initComponents();
        db = new DatabaseConnection("inventories");
        db.Fetch(productTable);
    }

    public void refreshTable(){
        db.Fetch(productTable);
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        update = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        find = new javax.swing.JButton();
        minus = new javax.swing.JRadioButton();
        add = new javax.swing.JRadioButton();
        back = new javax.swing.JButton();
        del = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product  ID", "Product Name", "Price", "Quantity", "Created Date", "Updated Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1095, 750));
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inventory Updates");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(340, 10, 300, 40);

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtId);
        txtId.setBounds(50, 630, 200, 70);

        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        getContentPane().add(txtQty);
        txtQty.setBounds(770, 630, 200, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel6.setText("Quantity");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(770, 610, 130, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel4.setText("Product ID");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 610, 130, 20);
        getContentPane().add(txtPrice);
        txtPrice.setBounds(550, 630, 200, 30);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Product  ID", "Product Name", "Price", "Quantity", "Created Date", "Updated Date", "Category"
            }
        ));
        jScrollPane2.setViewportView(productTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 60, 1070, 530);

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(980, 630, 90, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel7.setText("Price");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(550, 610, 130, 20);

        find.setText("Search");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        getContentPane().add(find);
        find.setBounds(260, 630, 90, 30);

        minus.setText("Minus");
        getContentPane().add(minus);
        minus.setBounds(870, 670, 107, 25);

        add.setText("Add");
        getContentPane().add(add);
        add.setBounds(770, 670, 51, 25);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(10, 10, 90, 30);

        del.setText("Delete");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        getContentPane().add(del);
        del.setBounds(260, 670, 90, 30);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
    try {
        id = txtId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product ID is required.");
            return;
        }

        double newPrice = Double.parseDouble(txtPrice.getText().trim());
        int inputQty = Integer.parseInt(txtQty.getText().trim());

        // Fetch current quantity first
        String query = "SELECT quantity FROM product WHERE product_id = ?";
        PreparedStatement pst = db.connection.prepareStatement(query);
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "Product not found.");
            return;
        }

        int currentQty = rs.getInt("quantity");
        rs.close();
        pst.close();

        // Apply add or minus logic
        if (add.isSelected()) {
            qty = currentQty + inputQty;
        } else if (minus.isSelected()) {
            qty = currentQty - inputQty;
            if (qty < 0) {
                JOptionPane.showMessageDialog(this, "Resulting quantity cannot be negative.");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select Add or Minus.");
            return;
        }

        // Update inventory
        db.updateInventory(id, qty, newPrice);
        refreshTable(); // Update UI

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid input. Enter numeric values for quantity and price.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage());
    }
    }//GEN-LAST:event_updateActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        String searchId = txtId.getText(); // assuming you have a text field for input
        try {
            ResultSet rs = db.findProductById(searchId);
            if (rs.next()) {
                // Example: populate UI fields
                txtPrice.setText(rs.getString("price"));
                txtQty.setText(rs.getString("quantity"));
            } else {
                JOptionPane.showMessageDialog(this, "Product not found.");
            }
            rs.close(); // cleanup after you're done
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error accessing database.");
        }

    }//GEN-LAST:event_findActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        String productId = txtId.getText().trim();

        if (productId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Product ID to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this product?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            db.deleteProduct(productId);
            refreshTable();
        }
    }//GEN-LAST:event_delActionPerformed

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
            java.util.logging.Logger.getLogger(inventoryUpdates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventoryUpdates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventoryUpdates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventoryUpdates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventoryUpdates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton add;
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton del;
    private javax.swing.JButton find;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton minus;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
