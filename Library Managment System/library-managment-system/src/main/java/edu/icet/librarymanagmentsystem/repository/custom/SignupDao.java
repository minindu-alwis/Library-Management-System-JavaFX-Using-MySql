package edu.icet.librarymanagmentsystem.repository.custom;

import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.repository.CrudDao;

import java.sql.SQLException;

public interface SignupDao extends CrudDao <User,String> {

    boolean checkemailrepeat(String email) throws SQLException;

    boolean registerUser(User newUser) throws SQLException;

    String genarateuserID() throws SQLException;

}
