package edu.icet.librarymanagmentsystem.service.custome;

import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.service.SuperService;

import java.sql.SQLException;

public interface SignUpService extends SuperService {

    boolean checkemailrepeat(String email) throws SQLException;

    boolean registerUser(User newUser) throws SQLException;

    String genarateuserID() throws SQLException;




}
