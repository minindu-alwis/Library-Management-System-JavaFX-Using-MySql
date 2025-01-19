package edu.icet.librarymanagmentsystem.controller.login;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import org.jasypt.util.text.BasicTextEncryptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController implements LoginService{

    private static LoginController instance;

    private LoginController(){

    }

    public static LoginController getInstance(){
        return instance == null ? instance=new LoginController() : instance;
    }

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
}
