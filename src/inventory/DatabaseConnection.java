/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.sql.*;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JTable;
/**
 *
 * @author JOHN MICHAEL ORTIGAS
 */
public class DatabaseConnection {
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    
    public DatabaseConnection(String databaseName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + databaseName, 
                "root", 
                ""
            );
            System.out.println("Database Found!");
        } catch(ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found.");
        } catch(SQLException e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }
    
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from Database.");
            }
        } catch(SQLException e) {
            System.out.println("Failed to close " + e.getMessage());
        }
    }

    public boolean registerProduct(String id, String name, double price, int quantity, String category) {
        String sql = "INSERT INTO product (product_id, product_name, price, quantity, category, created_at, updated_at) VALUES (?, ?, ?, ?, ?, NOW(), NOW())";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setDouble(3, price);
            pst.setInt(4, quantity);
            pst.setString(5, category);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Registration Error: " + e.getMessage());
            return false;
        }
    }

//    public void insertProduct(String name, int quantity, double price) {
//        String query = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?)";
//        
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, name);
//            statement.setInt(2, quantity);
//            statement.setDouble(3, price);
//            
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("Product inserted successfully.");
//            } else {
//                System.out.println("Failed to insert product.");
//            }
//        } catch (SQLException e) {
//            System.out.println("Failed to insert product: " + e.getMessage());
//        }
//    }

    public void updateInventory(String id, int qty, double price) {
        String query = "UPDATE product SET quantity = ?, price = ?, updated_at = NOW() WHERE product_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, qty);
            pst.setDouble(2, price);
            pst.setString(3, id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Inventory updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Product ID not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Update failed: " + e.getMessage());
        }
    }
    
         
        
    
    
    public void Fetch(javax.swing.JTable table) {
        String query = "SELECT * FROM product";
        try (PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear previous data
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("product_id"),
                    rs.getString("product_name"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at"),
                    rs.getString("Category")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to fetch data: " + e.getMessage());
        }
    }

    public void searchProduct(JTable table, String column, String value) {
        String query = "SELECT * FROM product WHERE " + column + " LIKE ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + value + "%");
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear previous results

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getDate("created_at"),
                    rs.getDate("updated_at"),
                    rs.getString("category")
                });
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No results found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Search error: " + e.getMessage());
        }
    }

    public void deleteProduct(String productId) {
        String query = "DELETE FROM product WHERE product_id = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, productId);
            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                JOptionPane.showMessageDialog(null, "Product not found or already deleted.");
            } else {
                JOptionPane.showMessageDialog(null, "Product deleted successfully.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting product: " + e.getMessage());
        }
    }

    // Method to find product by ID
    public ResultSet findProductById(String id) throws SQLException {
        String query = "SELECT * FROM product WHERE product_id = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, id);
        return pst.executeQuery(); // caller is responsible for closing ResultSet
    }

    //INSERT  PRODUCTS
//    public void insertProdcts(String name, int quantity, double price){
//            String query = "INSERT INTO products (name, quantity, price)  VALUES (?, ?, ?)";
//            
//            try{
//                PreparedStatement statement = connection.prepareStatement(query);
//                statement
//            }
//    }

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
