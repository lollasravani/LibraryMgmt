/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymgmt;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author sravani
 */
public class panelLogin extends javax.swing.JPanel {
    /**
     * Creates new form panelLogin
     */
    public panelLogin() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        passLoginPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        optAdmin = new javax.swing.JRadioButton();
        optStudent = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtLoginUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jLabel1.setText("Operated by : ");

        buttonGroup1.add(optAdmin);
        optAdmin.setSelected(true);
        optAdmin.setText("Admin");
        optAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAdminActionPerformed(evt);
            }
        });

        buttonGroup1.add(optStudent);
        optStudent.setText("Student");

        jLabel2.setText("User Name :");

        jLabel3.setText("Password :");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLoginUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(optAdmin)
                        .addGap(18, 18, 18)
                        .addComponent(optStudent))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel))
                            .addComponent(passLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(optAdmin)
                    .addComponent(optStudent))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLoginUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCancel))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void optAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optAdminActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    // TODO add your handling code here:
    String adminName = "";
    int adminId = 0;
    String userName = "";
    int userId = 0;
    AppValues.selectedUserName = txtLoginUserName.getText();
    AppValues.selectedUserPassword = passLoginPassword.getText();
    Utilities.registerDriver();
    Connection c = Utilities.getSqlConnection();
    AppValues.selectedUser = optAdmin.isSelected() ? AppValues.UserType.Admin : AppValues.UserType.Student;
    if (AppValues.selectedUser == AppValues.UserType.Admin)
    {
        String sqlAdmin = "select * from admin where admin_name = '" + AppValues.selectedUserName + "' and password_admin = '" + AppValues.selectedUserPassword + "';";
        System.out.println(sqlAdmin);
        ResultSet rsa = Utilities.getResultSet(c,sqlAdmin);
        int flag = 0;
        System.out.println(flag);
        try
        {
            if(rsa.next())
            {
                adminId = rsa.getInt(1);
                adminName = rsa.getString(2);
                flag = 1;
                System.out.println(flag);
                System.out.println("Found Admin");
                System.out.println(adminId);
            }
            if(flag == 0)
            {
                AppValues.validAdmin = false;
                JOptionPane optpane = new JOptionPane();
                optpane.showMessageDialog(null, "Please enter valid info", "Error", JOptionPane.WARNING_MESSAGE );
            }
            else
            {
               SwingUtilities.getWindowAncestor(panelLogin.this).setVisible(false);
               AppValues.validAdmin = true;
               System.out.println("AdminId = " + adminId); 
            }  
            rsa.close();
            c.close();
        }
        catch(Exception e)
        {

        }
        
    }
    else if(AppValues.selectedUser == AppValues.UserType.Student)
    {
        String sqlUser = "select * from users where user_name = '" + AppValues.selectedUserName + "' and password = '" + AppValues.selectedUserPassword + "';";
        System.out.println(sqlUser);
        ResultSet rsu = Utilities.getResultSet(c,sqlUser);
        int flag = 0;
        System.out.println(flag);
        try
        {
            if(rsu.next())
            {
                userId = rsu.getInt(1);
                userName = rsu.getString(2);
                flag = 1;
                System.out.println(flag);
                System.out.println("Found User");
                System.out.println(userId);
            }
            if(flag == 0)
            {
                AppValues.validStudent = false;
                JOptionPane optpane = new JOptionPane();
                optpane.showMessageDialog(null, "Please enter valid info", "Error", JOptionPane.WARNING_MESSAGE );
            }
            else
            {
                AppValues.validStudent = true;
                SwingUtilities.getWindowAncestor(panelLogin.this).setVisible(false);
                System.out.println("UserId = " + userId); 
            }  
            rsu.close();
            c.close();
        }
        catch(Exception e)
        {

        }
    }
        
    AppValues.isCancelled = false;
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        AppValues.isCancelled = true;
        if(AppValues.isCancelled == true)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton optAdmin;
    private javax.swing.JRadioButton optStudent;
    private javax.swing.JPasswordField passLoginPassword;
    private javax.swing.JTextField txtLoginUserName;
    // End of variables declaration//GEN-END:variables
}
