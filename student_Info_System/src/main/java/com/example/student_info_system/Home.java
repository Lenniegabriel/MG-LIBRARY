package com.example.student_info_system;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private Button btnAddNew;

    @FXML
    private Button btnDisplayInfo;


    @FXML
    private Button btnHomeBack;

    @FXML
    private Button btnHomeLogOut;



    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnAddNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseController.change(event,"student.fxml","Add Student");
            }
        });

        btnHomeBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseController.change(event,"login.fxml", "Login");

            }
        });
        btnHomeLogOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseController.change(event,"login.fxml", "Login");

            }
        });
        btnDisplayInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseController.change(event,"display_student.fxml", "Display Details");

            }
        });

    }
}
