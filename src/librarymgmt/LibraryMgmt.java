/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymgmt;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author sravani
 */
public class LibraryMgmt {

    /**
     * @param the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      JPanel _panelLogin = new panelLogin();    
      showDialog(_panelLogin, "Login");
      if(AppValues.validAdmin == true)
      {
        JFrame _frameAdmin = new frameAdminEntry();
        _frameAdmin.setExtendedState(_frameAdmin.MAXIMIZED_BOTH);
        _frameAdmin.setVisible(true);
      }
      else if(AppValues.validStudent == true)
      {
        JFrame _frameStudent = new frameStudentEntry();
        _frameStudent.setExtendedState(_frameStudent.MAXIMIZED_BOTH);
        _frameStudent.setVisible(true);
      }
    }
    
static void showDialog(JPanel _panel, String _title)
{
      JDialog dlgLogin = new JDialog();
      dlgLogin.setTitle(_title);
      dlgLogin.setModal(true);
      dlgLogin.getContentPane().add(_panel);
      dlgLogin.pack();
      dlgLogin.setLocationRelativeTo(null);
      dlgLogin.setVisible(true);
      dlgLogin.dispose();

}

}


