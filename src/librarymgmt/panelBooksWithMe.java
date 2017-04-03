/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymgmt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sravani
 */
public class panelBooksWithMe extends javax.swing.JPanel {

    /**
     * Creates new form panelBooksWithMe
     */
    public panelBooksWithMe() {
        initComponents();
        getTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
     public void getTableData() {  
           DefaultTableModel dtm = new DefaultTableModel(0, 0);  
            String s[] = new String[]{"ISBN", "Book Name", "Fine", "Issue Date", "Return Date"};  
            dtm.setColumnIdentifiers(s);  
            tabBooksWithMe.setModel(dtm); 
            
          try {  
                Utilities.registerDriver();
                Connection con;
                con = Utilities.getSqlConnection();  
                ResultSet rs = null; 
                String sql = "select issuedbooks.isbn,title,fine,issued_date,return_date from issuedbooks inner join books on books.isbn = issuedbooks.isbn inner join users on issuedbooks.user_id = users.user_id  where user_name = '" + AppValues.selectedUserName + "' and hasreturned = false;";
                System.out.println(sql);
                rs = Utilities.getResultSet(con,sql);
                while (rs.next()) 
                {  
                    String isbn = rs.getString(1);
                    String title = rs.getString(2);
                    String fine = rs.getString(3);
                    String issuedDate = rs.getString(4);
                    String returnDate = rs.getString(5);
                    Vector<String> vector = new Vector<String>();  
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabBooksWithMe = new javax.swing.JTable();
        txtBookNameWithMe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tbtnRenew = new javax.swing.JButton();

        tabBooksWithMe.setModel(new javax.swing.table.DefaultTableModel(
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
        tabBooksWithMe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabBooksWithMeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabBooksWithMe);

        jLabel1.setText("Book Name:");

        tbtnRenew.setText("Renew");
        tbtnRenew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnRenewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txtBookNameWithMe, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbtnRenew)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookNameWithMe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tbtnRenew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabBooksWithMeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabBooksWithMeMouseClicked
        // TODO add your handling code here:
        try
        {
            tbtnRenew.setEnabled(true);
            int row = tabBooksWithMe.getSelectedRow();
            String Table_click = (tabBooksWithMe.getModel().getValueAt(row,0).toString());
            String sql = "select title from books where isbn = '" + Table_click + "';";
            Utilities.registerDriver();
            Connection con;
            con = Utilities.getSqlConnection();  
            ResultSet rs = null;
            System.out.println(sql);
            rs = Utilities.getResultSet(con,sql);
            if(rs.next())
            {
                String add1 = rs.getString("title");
                txtBookNameWithMe.setText(add1);
            
            }
            disableOrEnable();
            
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_tabBooksWithMeMouseClicked

    private void tbtnRenewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnRenewActionPerformed
        // TODO add your handling code here:
            Utilities.registerDriver();
            Connection con;
            con = Utilities.getSqlConnection();
            ResultSet rs = null;
            ResultSet rs1 = null;
            String sql = "";
            String sql1 = "";
            sql = "Update issuedbooks set renew = true where user_id = (select user_id from users where user_name = '" + AppValues.selectedUserName + "') and isbn = (select isbn from books where title = '" + txtBookNameWithMe.getText() +"');";
            sql1 = "Update issuedbooks set return_date = return_date + 5 where user_id = (select user_id from users where user_name = '" + AppValues.selectedUserName + "') and isbn = (select isbn from books where title = '" + txtBookNameWithMe.getText() +"');";
            System.out.println(sql);
            System.out.println(sql1);
            rs = Utilities.getResultSet(con,sql);
            rs1 = Utilities.getResultSet(con,sql1);
    }//GEN-LAST:event_tbtnRenewActionPerformed

    void disableOrEnable()
    {
        Utilities.registerDriver();
        Connection con;
        con = Utilities.getSqlConnection();  
        ResultSet rs = null;
        String sql = "";
        sql = "select * from issuedbooks where user_id = (select user_id from users where user_name = '" + AppValues.selectedUserName + "') and isbn = (select isbn from books where title = '" + txtBookNameWithMe.getText() +"') and renew = true;";
        System.out.println(sql);
        rs = Utilities.getResultSet(con,sql);
        try
        {
            if(rs.next())
            {
                tbtnRenew.setEnabled(false);
            }
            else
            {
               tbtnRenew.setEnabled(true);   
            }  
            rs.close();
            con.close();
        }
        catch(Exception e)
        {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabBooksWithMe;
    private javax.swing.JButton tbtnRenew;
    private javax.swing.JTextField txtBookNameWithMe;
    // End of variables declaration//GEN-END:variables
}