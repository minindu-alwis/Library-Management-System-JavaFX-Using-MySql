package edu.icet.librarymanagmentsystem.repository;

import edu.icet.librarymanagmentsystem.repository.custom.impl.FogotDaoImpl;
import edu.icet.librarymanagmentsystem.repository.custom.impl.LoginDaoImpl;
import edu.icet.librarymanagmentsystem.repository.custom.impl.MemberDaoImpl;
import edu.icet.librarymanagmentsystem.repository.custom.impl.SignupDaoImpl;
import edu.icet.librarymanagmentsystem.util.DaoType;

public class DaoFactory {

    private static DaoFactory instance;
    private DaoFactory(){}
    public static DaoFactory getInstance() {
        return instance==null?instance=new DaoFactory():instance;
    }

    public <T extends SuperDao> T getDaoType(DaoType type){
        switch (type){
            case LOGIN: return (T) new LoginDaoImpl();
            case SINGNUP:return (T) new SignupDaoImpl();
            case FOGGOTPASSWORD:return (T) new FogotDaoImpl();
            case MEMBER:return (T) new MemberDaoImpl();
        }
        return null;
    }

}
