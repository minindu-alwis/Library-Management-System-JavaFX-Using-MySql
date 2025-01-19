package edu.icet.librarymanagmentsystem.controller.login;

import java.sql.SQLException;

public interface LoginService {

    boolean authenticateUser(String email, String password) throws SQLException;

}
