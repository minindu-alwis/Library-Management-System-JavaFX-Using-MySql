package edu.icet.librarymanagmentsystem.controller.singup;

import com.jfoenix.controls.JFXTextField;
import edu.icet.librarymanagmentsystem.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import org.jasypt.util.text.BasicTextEncryptor;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpFromController implements Initializable{

    public Label txtUserID;
    public JFXTextField userNameTxtField;
    public JFXTextField gmailTxtField;
    public JFXTextField passwordTxtField;

    public void btnSingUpOnAction(ActionEvent actionEvent) throws SQLException {

        if(SignUpController.getInstance().checkemailrepeat(gmailTxtField.getText())){
                String password=encryptPassword();
                if(SignUpController.getInstance().registerUser(new User(txtUserID.getText(),userNameTxtField.getText(), gmailTxtField.getText(), password))) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "User Registered Successfully");
                    alert.show();

                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "User Not Registerd");
                    alert.show();
                }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Email Alredy Exits");
            alert.show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getUserID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getUserID() throws SQLException {
        String userId=SignUpController.getInstance().genarateuserID();
        txtUserID.setText(userId);
    }

    public String encryptPassword(){
        String key="12345";
        BasicTextEncryptor basicTextEncryptor=new BasicTextEncryptor();
        String password=passwordTxtField.getText();

        basicTextEncryptor.setPassword(key);
        String encriptpassword=basicTextEncryptor.encrypt(password);
        return encriptpassword;
    }

}
