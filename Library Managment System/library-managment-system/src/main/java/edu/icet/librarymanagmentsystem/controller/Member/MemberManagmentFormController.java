package edu.icet.librarymanagmentsystem.controller.Member;

import edu.icet.librarymanagmentsystem.dto.Member;
import edu.icet.librarymanagmentsystem.service.ServiceFactory;
import edu.icet.librarymanagmentsystem.service.custome.MemberService;
import edu.icet.librarymanagmentsystem.util.ServiceType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
        if (txtIdField.getText().isEmpty() || txtNameField.getText().isEmpty() || txtContactField.getText().isEmpty() || txtMembershipDateField.getValue() == null) {
            new Alert(Alert.AlertType.WARNING, "Please Fill All Empty TEXT Fields.").show();
            return;
        }

        // Directly passing LocalDate since DatePicker returns LocalDate
        Member member = new Member(
                txtIdField.getText(),
                txtNameField.getText(),
                txtContactField.getText(),
                txtMembershipDateField.getValue()
        );

        boolean isAdded = memberService.isAdded(member);

        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "User Added Successfully!").show();
            clearFields();
        } else {
            new Alert(Alert.AlertType.ERROR, "User Not Added!").show();
        }
    }

    private void clearFields() {
        txtIdField.clear();
        txtNameField.clear();
        txtContactField.clear();
        txtMembershipDateField.setValue(null);
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
            loadTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadTable() throws SQLException {
        ObservableList<Member> customerObservableList = FXCollections.observableArrayList(memberService.getAll());
        tblCustomer.setItems(customerObservableList);
        cusIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        cusNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cusContactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        cusMembershipDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

}
