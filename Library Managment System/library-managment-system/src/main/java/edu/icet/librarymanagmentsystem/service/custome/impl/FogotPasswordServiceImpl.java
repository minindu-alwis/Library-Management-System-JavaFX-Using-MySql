package edu.icet.librarymanagmentsystem.service.custome.impl;

import edu.icet.librarymanagmentsystem.entity.UserEntity;
import edu.icet.librarymanagmentsystem.repository.DaoFactory;
import edu.icet.librarymanagmentsystem.repository.custom.FogotDao;
import edu.icet.librarymanagmentsystem.service.custome.FogotPasswordService;
import edu.icet.librarymanagmentsystem.util.DaoType;

public class FogotPasswordServiceImpl implements FogotPasswordService {
    private static FogotPasswordServiceImpl instance;

    FogotDao fogotDao= DaoFactory.getInstance().getDaoType(DaoType.FOGGOTPASSWORD);

    private FogotPasswordServiceImpl(){}

    public static FogotPasswordServiceImpl getInstance(){
        return instance==null?new FogotPasswordServiceImpl():instance;
    }

    @Override
    public boolean isEmailValid(String email) {
        UserEntity userEntity = fogotDao.checkemailrepeat(email);
        return userEntity != null;
    }


    @Override
    public boolean updatePasswordInDatabase(String email, String newPassword) {
        UserEntity userEntity = fogotDao.updatePassword(email, newPassword);
        return userEntity != null;
    }
}
