package edu.icet.librarymanagmentsystem.service.custome;

import edu.icet.librarymanagmentsystem.service.SuperService;

public interface FogotPasswordService extends SuperService {

    boolean isEmailValid(String email);
    boolean updatePasswordInDatabase(String email,String newPassword);

}
