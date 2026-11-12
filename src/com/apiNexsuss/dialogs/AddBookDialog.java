package com.apiNexsuss.dialogs;

import static com.apiNexsuss.screens.HomeScreen.logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class AddBookDialog extends javax.swing.JDialog {

    private HashMap<String, Integer> categoryMap;

    public AddBookDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadCategoriesFromDB();
    }

    private void loadCategoriesFromDB() {
        categoryMap = new HashMap<>();
        categoryget.removeAllItems();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/api_nexsuss", "root", "Savindu@2008");
            Statement s = c.createStatement();

            ResultSet rs = s.executeQuery("SELECT id, name FROM category");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                categoryget.addItem(name);
                categoryMap.put(name, id);
            }

            rs.close();
            s.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading categories: " + e.getMessage());
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nameget = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        copiesget = new javax.swing.JTextField();
        categoryget = new javax.swing.JComboBox<>();
        authorget = new javax.swing.JTextField();
        barcodein = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        barcodela = new javax.swing.JLabel();

        jLabel1.setText("book");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Books");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Add Book");

        jLabel3.setText("Book Name");

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nameget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namegetActionPerformed(evt);
            }
        });

        jLabel4.setText("Author");

        jLabel5.setText("Category");

        jLabel6.setText("Avariable Copies");

        copiesget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiesgetActionPerformed(evt);
            }
        });

        categoryget.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Book Category", "Fiction ", "Non-fiction", "Science & Technology ", "History", "Biography & Autobiography ", "Children's Books", "Rligious & Philosophy ", "Education & Textbooks ", "Art & Literature ", "Health & Wellness" }));
        categoryget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorygetActionPerformed(evt);
            }
        });

        barcodein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeinActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Genarate Barcode");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Barcode");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(copiesget)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameget)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryget, 0, 430, Short.MAX_VALUE)
                            .addComponent(authorget)
                            .addComponent(jLabel3)
                            .addComponent(barcodein)
                            .addComponent(barcodela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(authorget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copiesget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barcodein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barcodela, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void namegetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namegetActionPerformed

    }//GEN-LAST:event_namegetActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void copiesgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiesgetActionPerformed

    }//GEN-LAST:event_copiesgetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        String name = nameget.getText();
//        String author = authorget.getText();
//        String category = (String) categoryget.getSelectedItem();
//        String copies = copiesget.getText();
//
//        // Step 1: Validation BEFORE database operations
//        if (name.isEmpty() || author.isEmpty() || category.equals("Select Book Category") || copies.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please fill all the fields properly.");
//            return;
//        }
//
//        int copiesInt;
//        try {
//            copiesInt = Integer.parseInt(copies);
//            if (copiesInt < 0) {
//                JOptionPane.showMessageDialog(null, "Copies must be a non-negative number.");
//                return;
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Copies must be a valid number.");
//            return;
//        }
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/api_nexsuss", "root", "Savindu@2008");
//            Statement s = c.createStatement();
//
//            String query = "INSERT books SET Name = '" + name + "', Author = '" + author + "', Category = '" + category + "', Copies = " + copies + " ;";
//            int rowsAffected = s.executeUpdate(query);
//
//            if (rowsAffected > 0) {
//                System.out.println("Book updated successfully!");
//                JOptionPane.showMessageDialog(null, "Book updated successfully!");
//            } else {
//                System.out.println("Update failed. No rows affected.");
//            }
//
//            s.close();
//            c.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String name = nameget.getText().trim();
        String author = authorget.getText().trim();
//        int category = categoryget.getSelectedIndex();
        String selectedCategory = categoryget.getSelectedItem().toString();
        String copies = copiesget.getText().trim();
        String barcode = barcodein.getText().trim();
        
//        System.out.println(category);
        
        if (name.isEmpty() || author.isEmpty() || copies.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields.");
            return;
        }

//        int categoryId = categoryMap.get(Category);
        int copiesInt;

        int categoryId = 1; 
        if (categoryMap.containsKey(selectedCategory)) {
            categoryId = categoryMap.get(selectedCategory);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Category Selected!");
            return;
        }

        try {
            copiesInt = Integer.parseInt(copies);
            if (copiesInt < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for copies.");
            return;
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/api_nexsuss", "root", "Savindu@2008"); 
             PreparedStatement ps = c.prepareStatement("INSERT INTO books (Name, Author, Category_id, Copies, Barcode) VALUES (?, ?, ?, ?, ?)")) {

            ps.setString(1, name);
            ps.setString(2, author);
            ps.setInt(3, categoryId);
            ps.setInt(4, copiesInt);
            ps.setString(5, barcode);
            
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Book added successfully!");
                logger.log(java.util.logging.Level.INFO, "[SUCCESS] {0} Book is successfully added at {1}", new Object[]{name, new java.util.Date()});

                nameget.setText("");
                authorget.setText("");
                copiesget.setText("");
                categoryget.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add book.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void barcodeinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodeinActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String codeData = barcodein.getText().trim();

            if (codeData.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Please enter a valid Book ID or ISBN!");
                return;
            }

            String barcodeUrl = "https://bwipjs-api.metafloor.com/?bcid=code128&text=" + codeData + "&width=40&height=15&scale=2&rotate=N&includetext";
            java.net.URL url = new java.net.URL(barcodeUrl);
            javax.swing.ImageIcon barcodeIcon = new javax.swing.ImageIcon(url);

            barcodela.setIcon(barcodeIcon);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error generating barcode: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void categorygetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorygetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categorygetActionPerformed

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
            java.util.logging.Logger.getLogger(AddBookDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBookDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBookDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBookDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddBookDialog dialog = new AddBookDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorget;
    private javax.swing.JTextField barcodein;
    private javax.swing.JLabel barcodela;
    private javax.swing.JComboBox<String> categoryget;
    private javax.swing.JTextField copiesget;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField nameget;
    // End of variables declaration//GEN-END:variables
}
