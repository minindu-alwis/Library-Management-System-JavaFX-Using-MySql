package edu.icet.librarymanagmentsystem.repository.custom;


import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.entity.UserEntity;
import edu.icet.librarymanagmentsystem.repository.CrudDao;

import java.sql.SQLException;


public interface LoginDao extends CrudDao<UserEntity,String> {

    UserEntity authenticateUser(String email, String password) throws SQLException;

}
