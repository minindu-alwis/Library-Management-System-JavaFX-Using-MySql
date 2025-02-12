package edu.icet.librarymanagmentsystem.repository.custom;

import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.entity.UserEntity;
import edu.icet.librarymanagmentsystem.repository.CrudDao;

import java.sql.SQLException;

public interface SignupDao extends CrudDao <UserEntity,String> {

    UserEntity checkemailrepeat(String email) throws SQLException;

    boolean registerUser(UserEntity newUser) throws SQLException;

    UserEntity generateUserID() throws SQLException;

}
