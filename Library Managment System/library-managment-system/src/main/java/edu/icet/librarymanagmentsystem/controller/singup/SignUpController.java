package edu.icet.librarymanagmentsystem.controller.singup;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpController implements SingUpService{

    private static SignUpController instance;

    private SignUpController(){

    }

    public static SignUpController getInstance(){
        return instance==null ? instance=new SignUpController() : instance;
    }

    @Override
    public boolean checkemailrepeat(String email) {
        return false;
    }

    @Override
    public boolean registerUser(User newUser) throws SQLException {
        PreparedStatement prepareStm = DBConnection.getInstance().getConnection().prepareStatement(
                "INSERT INTO users (id,username, email, password) VALUES (?, ?, ?, ?)"
        );
        prepareStm.setString(1, newUser.getId());
        prepareStm.setString(2, newUser.getUsername());
        prepareStm.setString(3, newUser.getEmail());
        prepareStm.setString(4, newUser.getPassword());
        return prepareStm.executeUpdate() > 0;

    }

    @Override
    public String genarateuserID() throws SQLException {

        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery(
                "SELECT id FROM users ORDER BY id DESC LIMIT 1"
        );
        if (rst.next()) {
            String existId = rst.getString(1);
            int id=Integer.parseInt(existId.substring(1));
            return String.format("L%04d", id + 1);
        } else {
            return "L0001";
        }

    }
}
