package edu.icet.librarymanagmentsystem.repository.custom.impl;


import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.repository.custom.LoginDao;
import org.jasypt.util.text.BasicTextEncryptor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LoginDaoImpl implements LoginDao {

    @Override
    public boolean authenticateUser(String email, String password) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("SELECT password FROM users WHERE email = ?");
        preparedStatement.setString(1, email);

        ResultSet rst = preparedStatement.executeQuery();
        if (rst.next()) {
            String encryptedPassword = rst.getString("password");
            String key = "12345";
            BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
            basicTextEncryptor.setPassword(key);
            String decryptpassword = basicTextEncryptor.decrypt(encryptedPassword);
            System.out.println(decryptpassword);
            return password.equals(decryptpassword);
        } else {
            return false;
        }
    }

    @Override
    public boolean save(User entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User entity) throws SQLException {
        return false;
    }

    @Override
    public User search(String s) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }
}

