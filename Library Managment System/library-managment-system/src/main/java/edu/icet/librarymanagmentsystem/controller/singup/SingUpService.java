package edu.icet.librarymanagmentsystem.controller.singup;

import edu.icet.librarymanagmentsystem.model.User;

import java.sql.SQLException;

public interface SingUpService {

    boolean checkemailrepeat(String email);

    boolean registerUser(User newUser) throws SQLException;

    String genarateuserID() throws SQLException;




}
