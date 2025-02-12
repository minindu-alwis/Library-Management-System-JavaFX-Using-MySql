package edu.icet.librarymanagmentsystem.util;

import com.google.inject.*;
import edu.icet.librarymanagmentsystem.service.custome.LoginService;
import edu.icet.librarymanagmentsystem.service.custome.SignUpService;
import edu.icet.librarymanagmentsystem.service.custome.impl.LoginServiceImpl;
import edu.icet.librarymanagmentsystem.service.custome.impl.SignupServiceImpl;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LoginService.class).to(LoginServiceImpl.class);
        bind(SignUpService.class).to(SignupServiceImpl.class);
    }
}
