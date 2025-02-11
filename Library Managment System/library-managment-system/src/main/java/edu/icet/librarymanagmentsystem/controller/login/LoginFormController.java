package edu.icet.librarymanagmentsystem.controller.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.icet.librarymanagmentsystem.service.ServiceFactory;
import edu.icet.librarymanagmentsystem.service.custome.LoginService;
import edu.icet.librarymanagmentsystem.util.ServiceType;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public JFXTextField emailTxtField;
    public JFXPasswordField passwordTxtField;

    LoginService loginService= ServiceFactory.getInstance().getServiceType(ServiceType.LOGIN);

    public void btnLoginOnAction(ActionEvent actionEvent) throws SQLException {

        if(emailTxtField.getText().isEmpty() || passwordTxtField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all fields!");
            alert.show();
            return;
        }

        if(loginService.authenticateUser(emailTxtField.getText(), passwordTxtField.getText())){
            System.out.println("User Exists");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please Create Account and Try Again");
            alert.show();
        }
    }


    public void btnSignUpOnAction(ActionEvent actionEvent) throws IOException {
        // Your logic for opening the sign-up form
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/singup.fxml"))));
        stage.show();
    }

}
