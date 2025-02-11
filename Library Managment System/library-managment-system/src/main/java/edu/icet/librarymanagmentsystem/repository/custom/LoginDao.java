package edu.icet.librarymanagmentsystem.repository.custom;


import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.repository.CrudDao;

import java.sql.SQLException;


public interface LoginDao extends CrudDao<User,String> {

    boolean authenticateUser(String email, String password) throws SQLException;

}
