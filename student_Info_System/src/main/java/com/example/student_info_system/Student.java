package com.example.student_info_system;

import com.example.student_info_system.DataBaseController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


//import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Student implements Initializable {

    @FXML
    private TextField txtStudent_ID;
    @FXML
    private TextField txtStudentName;
    @FXML
    private TextField txtStudentDOB;
    @FXML
    private TextField txtStudentGender;
    @FXML
    private TextField txtStudentGuardian;
    @FXML
    private TextField txtContact;
    @FXML
    private TextField txtResidence;
    @FXML
    private TextField txtAddress;
    @FXML
    private Button StudentInfoSave;
    @FXML
    private Button StudentInfoBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        StudentInfoSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!txtStudentName.getText().trim().isEmpty() && !txtStudentDOB.getText().trim().isEmpty()
                        && !txtStudentGender.getText().trim().isEmpty() && !txtStudentGuardian.getText().trim().isEmpty()
                        && !txtContact.getText().trim().isEmpty() && !txtResidence.getText().trim().isEmpty()
                        && !txtAddress.getText().trim().isEmpty() && !txtStudent_ID.getText().trim().isEmpty()) {
                    DataBaseController.AddStudentInfo(event, txtStudent_ID.getText(),txtStudentName.getText(),txtStudentDOB.getText(),txtStudentGender.getText(), txtStudentGuardian.getText(), txtContact.getText(), txtResidence.getText(),txtAddress.getText());
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Enter details in all fields");
                    alert.show();
                }
            }
        });
        StudentInfoBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseController.change(event, "home.fxml", "Home");
            }


        });

    }
}

