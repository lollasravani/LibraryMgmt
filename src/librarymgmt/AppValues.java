/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymgmt;

/**
 *
 * @author sravani
 */
public class AppValues {
    public static enum UserType
    {
        Admin, Student
    }
    public static UserType selectedUser;
    public static String selectedUserName;
    public static boolean validStudent;
    public static boolean validAdmin;
    public static String selectedUserPassword;
    public static boolean isCancelled = false;
    public static boolean renew = false;
}
