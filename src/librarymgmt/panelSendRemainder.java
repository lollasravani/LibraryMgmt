/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymgmt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sravani
 */
public class panelSendRemainder extends javax.swing.JPanel {

    /**
     * Creates new form panelSendRemainder
     */
    public panelSendRemainder() {
        initComponents();
        getTableData();
    }

    public void getTableData() {  
           
           DefaultTableModel dtm = new DefaultTableModel(0, 0);  
            String s[] = new String[]{"Student Id", "Student Name" , "Email Id" ,"ISBN", "Book Name", "Fine", "Issue Date", "Return Date"};  
            dtm.setColumnIdentifiers(s);  
            tableSendRemainder.setModel(dtm); 
            
          try {  
                Utilities.registerDriver();
                Connection con;
                con = Utilities.getSqlConnection();  
                ResultSet rs = null; 
                String sql = "select issuedbooks.user_id, user_name, email, issuedbooks.isbn,title,fine,issued_date,return_date from issuedbooks inner join books on books.isbn = issuedbooks.isbn inner join users on issuedbooks.user_id = users.user_id  where hasreturned = false;";
                System.out.println(sql);
                rs = Utilities.getResultSet(con,sql);
                while (rs.next()) 
                {  
                    String userId = rs.getString(1);
                    String userName = rs.getString(2);
                    String email = rs.getString(3);
                    String isbn = rs.getString(4);
                    String title = rs.getString(5);
                    String fine = rs.getString(6);
                    String issuedDate = rs.getString(7);
                    String returnDate = rs.getString(8);
                    Vector<String> vector = new Vector<String>();  
                    vector.add(userId);  
                    vector.add(userName);  
                    vector.add(email);
                    vector.add(isbn);  
                    vector.add(title);  
                    vector.add(fine);
                    vector.add(issuedDate);  
                    vector.add(returnDate); 

                    dtm.addRow(vector);  
                }  
        } 
        catch (Exception ex) 
        {   
            
        }  
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
        tableSendRemainder = new javax.swing.JTable();
        btnSendRemainderSend = new javax.swing.JButton();
        txtMailId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        tableSendRemainder.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSendRemainder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSendRemainderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSendRemainder);

        btnSendRemainderSend.setText("Send");
        btnSendRemainderSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRemainderSendActionPerformed(evt);
            }
        });

        jLabel1.setText("Email Id: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(txtMailId, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSendRemainderSend, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnSendRemainderSend))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableSendRemainderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSendRemainderMouseClicked
        // TODO add your handling code here:
        try
        {
            int row = tableSendRemainder.getSelectedRow();
            String Table_click = (tableSendRemainder.getModel().getValueAt(row,0).toString());
            String sql = "select email from users where user_id = " + Table_click + ";";
            Utilities.registerDriver();
            Connection con;
            con = Utilities.getSqlConnection();  
            ResultSet rs = null;
            System.out.println(sql);
            rs = Utilities.getResultSet(con,sql);
            if(rs.next())
            {
                String add1 = rs.getString("email");
                txtMailId.setText(add1);
            
            }
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_tableSendRemainderMouseClicked

    private void btnSendRemainderSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRemainderSendActionPerformed
        // TODO add your handling code here:
        String mailTo = txtMailId.getText();
        String msg = "Your book taken from library has to be returned before return date else fine should be paid";
        String subject = "Remainder from Library";
        Utilities.sendEmail(mailTo,subject,msg);
    }//GEN-LAST:event_btnSendRemainderSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendRemainderSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSendRemainder;
    private javax.swing.JTextField txtMailId;
    // End of variables declaration//GEN-END:variables
}
