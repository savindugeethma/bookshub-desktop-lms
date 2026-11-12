
package com.apiNexsuss.dialogs;

import com.apiNexsuss.screens.AppIconUtil;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.itextpdf.text.log.Logger;
import com.apiNexsuss.screens.HomeScreen;
import static com.apiNexsuss.screens.HomeScreen.logger;
import com.apiNexsuss.screens.RegisterScreen;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.apiNexsuss.validation.Validator;

/**
 *
 * @author ASUS
 */
public class loginDialog extends javax.swing.JDialog {

    private JTextField emailField;
    private JPasswordField passwordField;

    public loginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    private void init() {

        FlatSVGIcon svgIcon = new FlatSVGIcon("img/loginbg.svg", 950, 540);
        test.setIcon(svgIcon);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setOpaque(false); // Transparent background ekak danna oni
        loginPanel.setBounds(600, 120, 300, 290);

        JLabel LoginLable = new JLabel("Login");
        LoginLable.setBounds(70, 0, 280, 50);
        LoginLable.setForeground(Color.WHITE); // White color text
        LoginLable.setFont(new Font("Arial", Font.BOLD, 46));
        loginPanel.add(LoginLable);

        JLabel emailLabel = new JLabel("Enter Your Email Address");
        emailLabel.setBounds(0, 57, 280, 30);
        emailLabel.setForeground(Color.WHITE); // White color text
        emailLabel.setFont(new Font("Arial", Font.BOLD, 10)); // Bold and size 24
        loginPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(0, 87, 280, 30);
        loginPanel.add(emailField);

        JLabel passLabel = new JLabel("Enter Your Password");
        passLabel.setBounds(0, 127, 280, 30);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Arial", Font.BOLD, 10));
        loginPanel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(0, 157, 280, 30);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(0, 217, 280, 30);
        loginButton.setBackground(new Color(0, 29, 61));
        loginButton.setForeground(Color.WHITE);
        loginPanel.add(loginButton);

        JButton registerButton = new JButton("Register Now");
        registerButton.setBounds(0, 255, 280, 25);
        registerButton.setBackground(new Color(162, 210, 255));
        registerButton.setForeground(new Color(2, 48, 71));
        loginPanel.add(registerButton);

        loginButton.addActionListener(this::loginButtonActionPerformed);
        registerButton.addActionListener(this::registerButtonActionPerformed);

        test.add(loginPanel);
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {

        String email = emailField.getText();
        String password = passwordField.getText();

//        System.out.println(email + password);
        if (!Validator.isEmailValid(email)) {
            return;
        }
        if (!Validator.isPasswordValid(password)) {
            return;
        }

        try {

            Connection c = com.apiNexsuss.connection.mysql.createConnection();
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `admin` "
                    + "WHERE `admin`.`email` = '" + email + "' &&"
                    + " `admin`.`password` = '" + password + "'");
            if (rs.next()) {
                if (rs.getInt("status_id") == 1) { // Active
                    JOptionPane.showMessageDialog(this, "Login Successfully", "Success Message", JOptionPane.INFORMATION_MESSAGE);
                    new HomeScreen().setVisible(true);
                    this.dispose();
                    // Logging with email
                    logger.log(Level.INFO, "[SUCCESS] " + email + " logged in at " + new java.util.Date());

                } else {
                    JOptionPane.showMessageDialog(this,
                            "OOPS!... Your account is suspended. Please contact super admin", "Error Message",
                            JOptionPane.ERROR_MESSAGE);
                    logger.log(Level.WARNING, "[FAILURE] " + email + " failed to login at " + new java.util.Date());
                }

            } else {
                JOptionPane.showMessageDialog(this,
                        "OOPS!... Somthing went wrong! Please check the login credintials.", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                logger.log(Level.WARNING, "[FAILURE] " + email + " failed to login at " + new java.util.Date());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
//        new RegisterScreen().setVisible(true);       

        this.setVisible(false);

        RegisterScreen registerDialog = new RegisterScreen(); 
        registerDialog.setLocationRelativeTo(this);
        registerDialog.setVisible(true);

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        test = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        test.setBackground(new java.awt.Color(0, 51, 153));
        test.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(test, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        FlatDarkLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                loginDialog dialog = new loginDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel test;
    // End of variables declaration//GEN-END:variables

}
