package edu.icet.librarymanagmentsystem.service.custome;

import edu.icet.librarymanagmentsystem.entity.UserEntity;
import edu.icet.librarymanagmentsystem.service.SuperService;

import java.sql.SQLException;

public interface LoginService extends SuperService {

    boolean authenticateUser(String email, String password) throws SQLException;

}
