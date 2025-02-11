package edu.icet.librarymanagmentsystem.service.custome.impl;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.repository.DaoFactory;
import edu.icet.librarymanagmentsystem.repository.custom.SignupDao;
import edu.icet.librarymanagmentsystem.service.custome.SignUpService;
import edu.icet.librarymanagmentsystem.util.DaoType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupServiceImpl implements SignUpService {

    SignupDao signupDao= DaoFactory.getInstance().getDaoType(DaoType.SINGNUP);

    private static SignupServiceImpl instance;

    private SignupServiceImpl(){

    }

    public static SignupServiceImpl getInstance(){
        return instance==null ? instance=new SignupServiceImpl() : instance;
    }

    @Override
    public boolean checkemailrepeat(String email) throws SQLException {
        return signupDao.checkemailrepeat(email);
    }

    @Override
    public boolean registerUser(User newUser) throws SQLException {
        return signupDao.registerUser(newUser);
    }

    @Override
    public String genarateuserID() throws SQLException {
     return signupDao.genarateuserID();
    }
}
