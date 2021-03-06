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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sravani
 */
public class panelBooksPurchased extends javax.swing.JPanel {

    /**
     * Creates new form panelBooksPurchased
     */
    public panelBooksPurchased() {
        initComponents();
        btnBooksPurchasedAdd.setEnabled(false);
        btnBooksPurchasedUpdate.setEnabled(true);
        btnBooksPurchasedDelete.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        txttitle = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        txtAuthorID = new javax.swing.JTextField();
        txtPublisherID = new javax.swing.JTextField();
        txtEdition = new javax.swing.JTextField();
        txtNoOfPages = new javax.swing.JTextField();
        txtTotalCopies = new javax.swing.JTextField();
        txtShelfNo = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        txtSubject = new javax.swing.JTextField();
        btnBooksPurchasedAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCopiesLeft = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnBooksPurchasedDelete = new javax.swing.JButton();
        tbtnBooksPurchasedNewBook = new javax.swing.JToggleButton();
        comboBooksPurchasedUpdate = new javax.swing.JComboBox<>();
        btnBooksPurchasedUpdate = new javax.swing.JButton();

        txttitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttitleActionPerformed(evt);
            }
        });

        btnBooksPurchasedAdd.setText("Add");
        btnBooksPurchasedAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksPurchasedAddActionPerformed(evt);
            }
        });

        jLabel2.setText("Title");

        jLabel3.setText("AuthorID");

        jLabel4.setText("PublisherID");

        jLabel5.setText("Edition");

        jLabel6.setText("No. of pages");

        jLabel7.setText("Total Copies");

        jLabel8.setText("Copies Left");

        jLabel9.setText("Type");

        jLabel10.setText("Subject");

        jLabel11.setText("ISBN");

        jLabel12.setText("Shelf No");

        btnBooksPurchasedDelete.setText("Delete");
        btnBooksPurchasedDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksPurchasedDeleteActionPerformed(evt);
            }
        });

        tbtnBooksPurchasedNewBook.setText("New Book");
        tbtnBooksPurchasedNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnBooksPurchasedNewBookActionPerformed(evt);
            }
        });

        comboBooksPurchasedUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "Edition", "No of Pages", "Shelf No", "Type", "Subject" }));

        btnBooksPurchasedUpdate.setText("Update");
        btnBooksPurchasedUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksPurchasedUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtShelfNo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNoOfPages, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPublisherID, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAuthorID, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalCopies, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbtnBooksPurchasedNewBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBooksPurchasedAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBooksPurchasedUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBooksPurchasedDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBooksPurchasedUpdate, 0, 100, Short.MAX_VALUE)))
                    .addComponent(txtCopiesLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(70, 70, 70)
                            .addComponent(btnBooksPurchasedUpdate))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tbtnBooksPurchasedNewBook)
                            .addGap(18, 18, 18)
                            .addComponent(btnBooksPurchasedAdd)
                            .addGap(38, 38, 38)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAuthorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPublisherID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(btnBooksPurchasedDelete))
                        .addGap(26, 26, 26)
                        .addComponent(comboBooksPurchasedUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoOfPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalCopies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCopiesLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtShelfNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txttitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttitleActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txttitleActionPerformed

    private void btnBooksPurchasedAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksPurchasedAddActionPerformed
        // TODO add your handling code here:
        try
        {
            Utilities.registerDriver();
            Connection con;
            con = Utilities.getSqlConnection();  
            ResultSet rs = null; 
            String sql = "Insert into books values ('" + txtISBN.getText() + "', '" + txttitle.getText() + "'," + txtAuthorID.getText() + "," + txtPublisherID.getText() + "," + txtEdition.getText() + "," + txtNoOfPages.getText() + "," + txtTotalCopies.getText() + "," + txtCopiesLeft.getText() + ",'" + txtShelfNo.getText() + "', '" + txtType.getText() + "','" + txtSubject.getText() + "');";
            System.out.println(sql);
            rs = Utilities.getResultSet(con,sql);
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_btnBooksPurchasedAddActionPerformed

    private void tbtnBooksPurchasedNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnBooksPurchasedNewBookActionPerformed
        // TODO add your handling code here:
        if(tbtnBooksPurchasedNewBook.isSelected())
        {
            btnBooksPurchasedUpdate.setEnabled(false);
            btnBooksPurchasedDelete.setEnabled(false);
            btnBooksPurchasedAdd.setEnabled(true);
        }
        else
        {
            btnBooksPurchasedAdd.setEnabled(false);
            btnBooksPurchasedUpdate.setEnabled(true);
            btnBooksPurchasedDelete.setEnabled(true);
        }
    }//GEN-LAST:event_tbtnBooksPurchasedNewBookActionPerformed

    public void updateData() {     
          try {  
                Utilities.registerDriver();
                Connection con;
                con = Utilities.getSqlConnection();  
                ResultSet rs = null; 
                String comboSelect = comboBooksPurchasedUpdate.getSelectedItem().toString();
                String sql = "";
                if(comboSelect.equals("Title"))
                {
                    sql = "Update books set title = '" + txttitle.getText() + "'where isbn = '" + txtISBN.getText() + "';";
                }
                else if(comboSelect.equals("Edition"))
                {
                   sql = "Update books set edition = " + txtEdition.getText() + "where isbn = '" + txtISBN.getText() + "';";
                }
                else if(comboSelect.equals("Number of pages"))
                {
                    sql = "Update books set no_of_pages = " + txtNoOfPages.getText() + "where isbn = '" + txtISBN.getText() + "';";
                }
                else if(comboSelect.equals("Type"))
                {
                    sql = "Update books set type = '" + txtType.getText() + "'where isbn = '" + txtISBN.getText() + "';";
                }
                else if(comboSelect.equals("Subject"))
                {
                    sql = "Update books set subject = '" + txtSubject.getText() + "'where isbn = '" + txtISBN.getText() + "';";
                }
                System.out.println(sql);
                rs = Utilities.getResultSet(con,sql);  
        } 
        catch (Exception ex) 
        {  
          //Logger.getLogger(JdefaluttableDemo.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    public void deleteData() {     
          try {  
                Utilities.registerDriver();
                Connection con;
                con = Utilities.getSqlConnection();  
                ResultSet rs = null;
                ResultSet rs1 = null;
                String comboSelect = comboBooksPurchasedUpdate.getSelectedItem().toString();
                String sql = "";
                String sql1 = "";
                sql1 = "Delete from issuedbooks where isbn = '" + txtISBN.getText() + "';"; 
                sql = "Delete from books where isbn = '" + txtISBN.getText() + "';"; 
                System.out.println(sql1);
                System.out.println(sql);
                rs1 = Utilities.getResultSet(con,sql1);
                rs = Utilities.getResultSet(con,sql);  
        } 
        catch (Exception ex) 
        {  
          //Logger.getLogger(JdefaluttableDemo.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    private void btnBooksPurchasedUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksPurchasedUpdateActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_btnBooksPurchasedUpdateActionPerformed

    private void btnBooksPurchasedDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksPurchasedDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBooksPurchasedDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooksPurchasedAdd;
    private javax.swing.JButton btnBooksPurchasedDelete;
    private javax.swing.JButton btnBooksPurchasedUpdate;
    private javax.swing.JComboBox<String> comboBooksPurchasedUpdate;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToggleButton tbtnBooksPurchasedNewBook;
    private javax.swing.JTextField txtAuthorID;
    private javax.swing.JTextField txtCopiesLeft;
    private javax.swing.JTextField txtEdition;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtNoOfPages;
    private javax.swing.JTextField txtPublisherID;
    private javax.swing.JTextField txtShelfNo;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTotalCopies;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txttitle;
    // End of variables declaration//GEN-END:variables
}
