/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.apiNexsuss.dialogs;

import com.formdev.flatlaf.FlatDarkLaf;
import static com.apiNexsuss.screens.HomeScreen.logger;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class BorrowDialog extends javax.swing.JDialog {

    public static int Remaining_copies;
    
    public BorrowDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Dataload();
        
        java.time.LocalDate today = java.time.LocalDate.now();
        bdateget.setText(today.toString());
    }

    private void Dataload() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/api_nexsuss", "root", "Savindu@2008");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM `MEMBERS`");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0); // Clear table

            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(rs.getString("id"));
                v.add(rs.getString("Full_Name"));
                v.add(rs.getString("status_id"));

                dtm.addRow(v);

            }
            rs.close();

        } catch (Exception e) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        memberidget = new javax.swing.JTextField();
        membernameget = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bdateget = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        copiesget = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bookidget = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel1.setText("Borrow Books");

        jLabel2.setText("Member Name");

        membernameget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membernamegetActionPerformed(evt);
            }
        });

        jLabel3.setText("Book Id");

        jLabel4.setText("Borrowing Date (Today)");

        bdateget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdategetActionPerformed(evt);
            }
        });

        jLabel5.setText("Note");

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Member Id");

        bookidget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookidgetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(copiesget, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bdateget, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(membernameget, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(memberidget)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookidget, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookidget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(memberidget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(membernameget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bdateget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copiesget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Member Id", "Member Name", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bdategetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdategetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdategetActionPerformed

    private void membernamegetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membernamegetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_membernamegetActionPerformed

    private void bookidgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookidgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookidgetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String bookId = bookidget.getText();
        String memberId = memberidget.getText();
        String memberName = membernameget.getText();
        String borrowingDate = bdateget.getText(); // (if you need to save later)
        String note = copiesget.getText(); // (seems like a mistake – used as "note"?)

        
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/api_nexsuss", "root", "Savindu@2008");
//            Statement statement = c.createStatement();
//
//            // Get copies for the selected book
//            String selectQuery = "SELECT * FROM books WHERE id = '" + bookId + "'";
//            ResultSet rs = statement.executeQuery(selectQuery);
//
//            if (rs.next()) {
//                int available = rs.getInt("Copies");
//
//                if (available > 0) {
//                    // Reduce copies by 1
//                    String updateQuery = "UPDATE books SET Copies = Copies - 1 WHERE id = '" + bookId + "'";
//                    int updated = statement.executeUpdate(updateQuery);
//
//                    if (updated > 0) {
//                        int Remaining_copies = available - 1;
//                        System.out.println("Book borrowed successfully. Remaining copies: " + Remaining_copies);
//                        JOptionPane.showMessageDialog(null, "Book borrowed successfully!");
//                        logger.log(java.util.logging.Level.SEVERE,"[SUCCESS] "+bookId+ "book is successfully and remaining copies "+Remaining_copies+" borrowed at" + new java.util.Date());
//
//
//                        try {
//                            
//                            Statement s1 = c.createStatement();
//
//                  
//                            String query = "INSERT INTO issue_and_returns (Books_id, Members_id, borrow_status_id) "
//                                    + "VALUES ('" + bookId + "', '" + memberId + "', 1)";
//                            int rowsAffected = s1.executeUpdate(query);
//
//                            if (rowsAffected > 0) {
//                                System.out.println("Borrow record added to database!");
////                                logger.log(java.util.logging.Level.SEVERE,"[SUCCESS] "+bookId+ "Borrow record added to database! at" + new java.util.Date());
//                            } else {
//                                System.out.println("Failed to add borrow record.");
////                                logger.log(java.util.logging.Level.SEVERE,"[SUCCESS] "+bookId+ "Failed to add borrow record. at" + new java.util.Date());
//
//                            }
//
//                            s1.close();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    } else {
//                        System.out.println("Failed to update book.");
//                        JOptionPane.showMessageDialog(null, "Borrow failed!");
//                        logger.log(java.util.logging.Level.SEVERE,"[FAIL] "+bookId+ "book is borrow failed! at" + new java.util.Date());
//
//                    }
//
//                } else {
//                    System.out.println("No copies available.");
//                    JOptionPane.showMessageDialog(null, "No copies available!");
//                }
//
//            } else {
//                System.out.println("Book not found.");
//                JOptionPane.showMessageDialog(null, "Book not found in database!");
//            }
//
//            rs.close();
//            statement.close();
//            c.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/api_nexsuss", "root", "Savindu@2008");
            Statement statement = c.createStatement();

            String borrowDate = bdateget.getText().trim();

            if (bookId.isEmpty() || memberId.isEmpty() || borrowDate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields, including the Borrow Date!");
                return;
            }

            String selectQuery = "SELECT Available_books FROM books WHERE id = '" + bookId + "'";
            ResultSet rs = statement.executeQuery(selectQuery);

            if (rs.next()) {
                String availableStr = rs.getString("Available_books");

                if (availableStr != null) {
                    int available = Integer.parseInt(availableStr);

                    if (available > 0) {

                        String updateQuery = "UPDATE books SET Available_books = Available_books - 1 WHERE id = '" + bookId + "'";
                        int updated = statement.executeUpdate(updateQuery);

                        if (updated > 0) {
                            int remainingCopies = available - 1;
                            JOptionPane.showMessageDialog(this, "Book borrowed successfully!");

                            logger.log(java.util.logging.Level.INFO, "[SUCCESS] Book ID: " + bookId + " borrowed by Member ID: " + memberId + " on " + borrowDate);

                            Statement s1 = c.createStatement();
                            String query = "INSERT INTO issue_and_returns (Books_id, Members_id, borrow_status_id, borrow_date) "
                                         + "VALUES ('" + bookId + "', '" + memberId + "', 1, '" + borrowDate + "')";

                            s1.executeUpdate(query);
                            s1.close();

                        } else {
                            JOptionPane.showMessageDialog(this, "Borrow failed!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No copies available in stock!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Available books data is null!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Book ID not found in database!");
            }

            rs.close();
            statement.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
    
        FlatDarkLaf.setup();

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BorrowDialog dialog = new BorrowDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField bdateget;
    private javax.swing.JTextField bookidget;
    private javax.swing.JTextField copiesget;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField memberidget;
    private javax.swing.JTextField membernameget;
    // End of variables declaration//GEN-END:variables

}
