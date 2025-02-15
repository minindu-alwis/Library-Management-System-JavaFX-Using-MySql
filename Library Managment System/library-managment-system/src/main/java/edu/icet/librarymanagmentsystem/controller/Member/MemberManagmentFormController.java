package edu.icet.librarymanagmentsystem.controller.Member;

import edu.icet.librarymanagmentsystem.dto.Member;
import edu.icet.librarymanagmentsystem.service.ServiceFactory;
import edu.icet.librarymanagmentsystem.service.custome.MemberService;
import edu.icet.librarymanagmentsystem.util.ServiceType;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MemberManagmentFormController implements Initializable {

    public TextField txtIdField;
    public TextField txtNameField;
    public TextField txtContactField;
    public TableView tblCustomer;
    public DatePicker txtMembershipDateField;
    public TableColumn cusSalaryCol;
    public TableColumn cusIdCol;
    public TableColumn cusNameCol;
    public TableColumn cusContactCol;
    public TableColumn cusMembershipDateCol;

    MemberService memberService= ServiceFactory.getInstance().getServiceType(ServiceType.MEMBER);

    public void addaCustomerOnAction(ActionEvent actionEvent) throws SQLException {

        if (txtIdField.getText().isEmpty() || txtNameField.getText().isEmpty() || txtContactField.getText().isEmpty() || txtMembershipDateField.getValue()==null) {
            new Alert(Alert.AlertType.WARNING, "Please Fill All Empty TEXT Fields.").show();
            return;
        }

        boolean isAdded=memberService.isAdded(
               new Member(txtIdField.getText(),txtNameField.getText(),txtContactField.getText(),txtMembershipDateField.getValue())
        );

        if(isAdded){
            new Alert(Alert.AlertType.INFORMATION, "User Added Sucsess !").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "User Not Added !").show();
        }

    }

    public void deleteCustomerOnAction(ActionEvent actionEvent) {

    }

    public void updateCustomerOnAction(ActionEvent actionEvent) {

    }

    public void searchCustomerOnAction(ActionEvent actionEvent) {

    }

    public void getUserID() throws SQLException {
        String userId = memberService.genarateuserID();
        txtIdField.setText(userId);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            txtIdField.setEditable(false);
            getUserID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
