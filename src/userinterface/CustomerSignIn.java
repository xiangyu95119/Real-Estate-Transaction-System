/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

//import business.customer.CustomerAccDirectory;
import business.customer.CustomerAccount;
import business.useraccount.UserAccountDirectory;
import javax.swing.JOptionPane;
import business.EcoSystem;
import java.awt.Image;
import java.awt.color.ColorSpace;
import javax.swing.ImageIcon;
/**
 *
 * @author wenhaofeng
 */

public class CustomerSignIn extends javax.swing.JPanel {

    /**
     * Creates new form UserSignIn
     */
    private EcoSystem system;
    public CustomerSignIn(EcoSystem system) {
        initComponents();
        this.system = system;
            ImageIcon icon = new ImageIcon("logazu.jpg");
            icon.setImage(icon.getImage().getScaledInstance(100,130,Image.SCALE_DEFAULT));
            iconT.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        username = new javax.swing.JTextField();
        SignInBtn = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        iconT = new javax.swing.JLabel();

        setBackground(new java.awt.Color(166, 166, 234));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 124, 140, -1));

        SignInBtn.setText("Sign in");
        SignInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInBtnActionPerformed(evt);
            }
        });
        add(SignInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 220, -1, -1));
        add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 168, 140, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Register your account");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 345, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 129, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 173, -1, -1));
        add(iconT, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 110, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void SignInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInBtnActionPerformed
        // TODO add your handling code here:
        if(username.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Username cannot be empty");
            return;
        }
        if(jPasswordField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Password cannot be empty");
            return;
        }
        Boolean exist = false;
        for(CustomerAccount ca: system.getCustomerAccountList()){
            if(username.getText().equals(ca.getUsername())){
                JOptionPane.showMessageDialog(null, "Repeated Username !");
                exist = true;
                return;             
            }             
        }
        if(!exist){                            
            String username1 = username.getText();
            String password1 = String.valueOf(jPasswordField.getPassword());
            CustomerAccount customerAccount = system.createCustomerAccount(username1,password1);
            JOptionPane.showMessageDialog(null, "Successfullyt created");
             
         }
        
    }//GEN-LAST:event_SignInBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignInBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel iconT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
