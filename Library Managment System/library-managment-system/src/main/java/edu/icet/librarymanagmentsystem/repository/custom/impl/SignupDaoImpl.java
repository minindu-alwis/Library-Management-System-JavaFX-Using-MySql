package edu.icet.librarymanagmentsystem.repository.custom.impl;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.repository.custom.SignupDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SignupDaoImpl implements SignupDao {


    @Override
    public boolean checkemailrepeat(String email) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("SELECT email FROM users WHERE email = ?");
        preparedStatement.setString(1, email);

        ResultSet rst = preparedStatement.executeQuery();
        if(rst.next()){
            return false;
        }
        return true;
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
