package edu.icet.librarymanagmentsystem.service;

import edu.icet.librarymanagmentsystem.service.custome.impl.FogotPasswordServiceImpl;
import edu.icet.librarymanagmentsystem.service.custome.impl.LoginServiceImpl;
import edu.icet.librarymanagmentsystem.service.custome.impl.MemberServiceImpl;
import edu.icet.librarymanagmentsystem.service.custome.impl.SignupServiceImpl;
import edu.icet.librarymanagmentsystem.util.ServiceType;

public class ServiceFactory {

    private static ServiceFactory instance;

    private ServiceFactory(){}
    public static ServiceFactory getInstance() {
        return instance==null?instance=new ServiceFactory():instance;
    }
    public <T extends SuperService>  T getServiceType(ServiceType serviceType){
        switch (serviceType){
            case LOGIN:return (T) LoginServiceImpl.getInstance();
            case SIGNUP:return (T) SignupServiceImpl.getInstance();
            case FOGGOTPASSWORD:return (T) FogotPasswordServiceImpl.getInstance();
            case MEMBER:return (T) MemberServiceImpl.getInstance();

        }
        return null;
    }
}
