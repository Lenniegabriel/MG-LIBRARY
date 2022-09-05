package com.example.student_info_system;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Account implements Initializable {

    @FXML
    private TextField txt_username;
    @FXML
    private PasswordField txt_password;
    @FXML
    private PasswordField txt_conPassword;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_back;
    @FXML
    private Button btnSignIn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!txt_username.getText().trim().isEmpty() && !txt_password.getText().trim().isEmpty() && !txt_conPassword.getText().trim().isEmpty()) {
                    DataBaseController.CreateAccount(event, txt_username.getText(), txt_password.getText());
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Enter details in all fields");
                    alert.show();
                }
            }
        });

        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseController.change(event,"login.fxml","Login");
            }
        });

        btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseController.change(event,"login.fxml","Login");

            }

        });



    }
}
