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
public class panelStudentSearchBooks extends javax.swing.JPanel {

    /**
     * Creates new form panelStudentSearchBooks
     */
    public panelStudentSearchBooks() {
        initComponents();
        setTableData();
    }
    
    public void setTableData()
    {
        DefaultTableModel dtm = new DefaultTableModel(0, 0);  
            String s[] = new String[]{"ISBN", "Book Name", "Author Name", "Publisher Name", "Edition", "No Of Pages", "Total Copie", "Copies Left", "Shelf No", "Type", "Subject"};  
            dtm.setColumnIdentifiers(s);  
            tableStudentSearch.setModel(dtm);
    }

     public void getTableData() {  
           
           DefaultTableModel dtm = new DefaultTableModel(0, 0);  
            String s[] = new String[]{"ISBN", "Book Name", "Author Name", "Publisher Name", "Edition", "No Of Pages", "Total Copie", "Copies Left", "Shelf No", "Type", "Subject"};  
            dtm.setColumnIdentifiers(s);  
            tableStudentSearch.setModel(dtm); 
            
          try {  
                Utilities.registerDriver();
                Connection con;
                con = Utilities.getSqlConnection();  
                ResultSet rs = null; 
                String comboSelect = comboBoxStudent.getSelectedItem().toString();
                String sql = "";
                if(comboSelect.equals("Subject"))
                {
                    sql = "Select distinct books.isbn, title, author_name, publisher_name,edition, no_of_pages, total_copies, copies_left, shelf_no, type, subject from books inner join authors on books.author_id = authors.author_id inner join publishers on books.publisher_id = publishers.publisher_id where subject like '%" + txtSearchStudent.getText() + "%';";
                }
                else if(comboSelect.equals("Author"))
                {
                    sql = "Select distinct books.isbn, title, author_name, publisher_name,edition, no_of_pages, total_copies, copies_left, shelf_no, type, subject from books inner join authors on books.author_id = authors.author_id inner join publishers on books.publisher_id = publishers.publisher_id where author_name like '%" + txtSearchStudent.getText() + "%';";
                }
                else if(comboSelect.equals("Publisher"))
                {
                    sql = "Select distinct books.isbn, title, author_name, publisher_name,edition, no_of_pages, total_copies, copies_left, shelf_no, type, subject from books inner join authors on books.author_id = authors.author_id inner join publishers on books.publisher_id = publishers.publisher_id where publisher_name like '%" + txtSearchStudent.getText() + "%';";
                }
                else if(comboSelect.equals("Type"))
                {
                    sql = "Select distinct books.isbn, title, author_name, publisher_name,edition, no_of_pages, total_copies, copies_left, shelf_no, type, subject from books inner join authors on books.author_id = authors.author_id inner join publishers on books.publisher_id = publishers.publisher_id where type like '%" + txtSearchStudent.getText() + "%';";
                }
                System.out.println(sql);
                rs = Utilities.getResultSet(con,sql);
                while (rs.next()) 
                {  
                    String isbn = rs.getString(1);
                    String title = rs.getString(2);
                    String authorName = rs.getString(3);
                    String publisherName = rs.getString(4);
                    String edition = rs.getString(5);
                    String noOfPages = rs.getString(6);
                    String totalCopies = rs.getString(7);
                    String copiesLeft = rs.getString(8);
                    String shelfNo = rs.getString(9);
                    String type = rs.getString(10);
                    String subject = rs.getString(11);
                    Vector<String> vector = new Vector<String>();  
                    vector.add(isbn);  
                    vector.add(title);  
                    vector.add(authorName);
                    vector.add(publisherName);  
                    vector.add(edition);
                    vector.add(noOfPages);
                    vector.add(totalCopies); 
                    vector.add(copiesLeft);  
                    vector.add(shelfNo);
                    vector.add(type);
                    vector.add(subject);

                    dtm.addRow(vector);  
                }  
        } 
        catch (SQLException ex) 
        {  
          //Logger.getLogger(JdefaluttableDemo.class.getName()).log(Level.SEVERE, null, ex);  
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

        txtSearchStudent = new javax.swing.JTextField();
        btnStudentSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudentSearch = new javax.swing.JTable();
        comboBoxStudent = new javax.swing.JComboBox<>();

        txtSearchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchStudentActionPerformed(evt);
            }
        });

        btnStudentSearch.setText("Search");
        btnStudentSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentSearchActionPerformed(evt);
            }
        });

        tableStudentSearch.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableStudentSearch);

        comboBoxStudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject", "Author", "Publisher", "Type" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(comboBoxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btnStudentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnStudentSearch)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchStudentActionPerformed

    private void btnStudentSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentSearchActionPerformed
        // TODO add your handling code here:
        getTableData();
    }//GEN-LAST:event_btnStudentSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStudentSearch;
    private javax.swing.JComboBox<String> comboBoxStudent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStudentSearch;
    private javax.swing.JTextField txtSearchStudent;
    // End of variables declaration//GEN-END:variables
}
