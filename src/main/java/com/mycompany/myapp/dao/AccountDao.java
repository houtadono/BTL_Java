package com.mycompany.myapp.dao;

import com.mycompany.myapp.helpers.DatabaseHelper;
import com.mycompany.myapp.model.Account;
import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Houta
 */
public class AccountDao {

    public static Account checkLogin(String user, String pass) {
        try {
            String sql = "SELECT * FROM tai_khoan WHERE username = ? and password = ?";
            Connection conn = DatabaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setUsername(user);
                acc.setPassword(pass);
                //acc.setRole(rs.getString("role"));
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
