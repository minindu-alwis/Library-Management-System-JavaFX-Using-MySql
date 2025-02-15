package edu.icet.librarymanagmentsystem.repository.custom;

import edu.icet.librarymanagmentsystem.entity.UserEntity;
import edu.icet.librarymanagmentsystem.repository.CrudDao;

public interface FogotDao extends CrudDao<UserEntity,String> {

    UserEntity checkemailrepeat(String email);

    UserEntity updatePassword(String email,String newPassword);

}
