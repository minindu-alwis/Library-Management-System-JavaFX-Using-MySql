package edu.icet.librarymanagmentsystem.controller.login;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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

    public void btnSignUpOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/singup.fxml"))));
        stage.show();

    }
}
