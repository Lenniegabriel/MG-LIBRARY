package com.example.student_info_system;

import com.example.student_info_system.models.StudentObj;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DisplayStudent implements Initializable {
    @FXML
    private TextField txtSearchBox;

    @FXML
    private Button btn_search;

    @FXML
    private TextField txtSName;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtGuardian;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtResidence;

    @FXML
    private TextField txtAddress;

    @FXML
    private Button btn_exit;



    @FXML
    public void search() {
        String filter = txtSearchBox.getText();
        if(filter.isEmpty()){
            // Raise an alert here if search box contains no information.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter Student ID");
            alert.show();
        } else {
            String id = filter;
            StudentObj stud = DataBaseController.selectSingleStudent(id);
            if(stud != null) {

                txtSName.setText(stud.name);
                txtDob.setText(stud.dob);
                txtGender.setText(stud.gender);
                txtGuardian.setText(stud.guardian);
                txtContact.setText(stud.contact);
                txtResidence.setText(stud.residence);
                txtAddress.setText(stud.address);
            }

        }
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                search();

            }
        });

        btn_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseController.change(event,"home.fxml", "Home");

            }
        });

    }



}