package edu.icet.librarymanagmentsystem.service.custome.impl;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.entity.UserEntity;
import edu.icet.librarymanagmentsystem.repository.DaoFactory;
import edu.icet.librarymanagmentsystem.repository.custom.SignupDao;
import edu.icet.librarymanagmentsystem.service.custome.SignUpService;
import edu.icet.librarymanagmentsystem.util.DaoType;
import org.modelmapper.ModelMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupServiceImpl implements SignUpService {

    private final ModelMapper modelMapper=new ModelMapper();

    SignupDao signupDao= DaoFactory.getInstance().getDaoType(DaoType.SINGNUP);

    private static SignupServiceImpl instance;

    private SignupServiceImpl(){

    }

    public static SignupServiceImpl getInstance(){
        return instance==null ? instance=new SignupServiceImpl() : instance;
    }

    @Override
    public boolean checkemailrepeat(String email) throws SQLException {
        UserEntity userEntity = signupDao.checkemailrepeat(email);
        return userEntity == null;
    }
    @Override
    public boolean registerUser(User newUser) throws SQLException {
        UserEntity entity = modelMapper.map(newUser, UserEntity.class);
        return signupDao.registerUser(entity);
    }

    @Override
    public String genarateuserID() throws SQLException {
        UserEntity userEntity = signupDao.generateUserID();
        return userEntity.getId();

    }
}
