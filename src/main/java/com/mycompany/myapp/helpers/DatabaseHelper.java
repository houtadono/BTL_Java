package com.mycompany.myapp.helpers;
import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Houta
 */
public class DatabaseHelper {
    public static Connection openConnection(){
        
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\myapp\\helpers\\databaseConnect.properties"));
        } catch (IOException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = properties.getProperty("url"); // lấy giá trị url trong file
        String user = properties.getProperty("user"); // lấy giá trị user trong file
        String password = properties.getProperty("password"); // lấy giá trị password trong file
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /// test connect Database
//    public static void main(String[] args) {
//        Connection conn = openConnection();
//        if(conn != null)
//            System.out.println("ok");
//        else 
//            System.out.println("Ko");
//    }
}
