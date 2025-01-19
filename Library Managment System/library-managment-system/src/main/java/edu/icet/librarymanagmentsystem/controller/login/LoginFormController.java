package edu.icet.librarymanagmentsystem.controller.login;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

import java.sql.SQLException;

public class LoginFormController {
    public JFXTextField emailTxtField;
    public JFXTextField passwordTxtField;

    public void btnLoginOnAction(ActionEvent actionEvent) throws SQLException {

        if(LoginController.getInstance().authenticateUser(emailTxtField.getText(),passwordTxtField.getText())){
            System.out.println("User Have");
        }else{
            System.out.println("User Not");
        }


    }
}
