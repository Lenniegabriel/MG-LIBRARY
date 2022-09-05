package com.example.student_info_system;

import com.example.student_info_system.models.StudentObj;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DataBaseController {

    public static void CreateAccount(ActionEvent event, String Username, String Password) {
        Connection connect = null;
        PreparedStatement insert = null;
        PreparedStatement validateUser = null;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info_manager", "root", "");
            validateUser = connect.prepareStatement("SELECT * FROM `users` WHERE username=?");
            validateUser.setString(1, Username);
            resultSet = validateUser.executeQuery();

            if (resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User already exist");
                alert.show();
            } else {
                String sql = "INSERT INTO users(username,password) VALUES (?,?)";
                insert = connect.prepareStatement(sql);
                insert.setString(1, Username);
                insert.setString(2, Password);

                int row = insert.executeUpdate();
                if (row > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("New User registered");
                    alert.show();
                }

            }



        } catch (SQLException e) {
            e.printStackTrace();

        }
    }



    public static StudentObj selectSingleStudent(String  userId){
        try{
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info_manager","root","");
            String selectQuery = "SELECT * FROM student_details WHERE user_id=?";
            PreparedStatement prepare = connect.prepareStatement(selectQuery);
            prepare.setString(1, userId);
            ResultSet result = prepare.executeQuery();

            StudentObj studentObj = new StudentObj();
            if (result.next()) {

                studentObj.id = result.getString("user_id");
                studentObj.name = result.getString("Student_Name");
                studentObj.dob = result.getString("Student_Dob");
                studentObj.gender = result.getString("Student_Gender");
                studentObj.guardian = result.getString("Student_Guardian");
                studentObj.contact = result.getString("contact");
                studentObj.residence = result.getString("residence");
                studentObj.address = result.getString("Address");
            }
            return studentObj;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public static void AddStudentInfo(ActionEvent event, String Id,String StudentName, String StudentDob, String
            StudentGender, String StudentGuardian, String Contact, String Residence, String Address){
        Connection connect = null;
        PreparedStatement insert = null;
        PreparedStatement validateUser = null;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info_manager","root","");
            validateUser = connect.prepareStatement("SELECT * FROM `student_details` WHERE user_id=?");
            validateUser.setString(1, Id);
            validateUser = connect.prepareStatement("SELECT * FROM `student_details` WHERE Student_Name=?");
            validateUser.setString(1, StudentName);
            validateUser = connect.prepareStatement("SELECT * FROM `student_details` WHERE Student_Dob=?");
            validateUser.setString(1, StudentDob);
            validateUser = connect.prepareStatement("SELECT * FROM `student_details` WHERE Student_Gender=?");
            validateUser.setString(1, StudentGender);
            validateUser = connect.prepareStatement("SELECT * FROM `student_details` WHERE Student_Guardian=?");
            validateUser.setString(1, StudentGuardian);
            validateUser = connect.prepareStatement("SELECT * FROM `student_details` WHERE contact=?");
            validateUser.setString(1, Contact);
            validateUser = connect.prepareStatement("SELECT * FROM `student_details` WHERE residence=?");
            validateUser.setString(1, Residence);
            validateUser = connect.prepareStatement("SELECT * FROM `student_details` WHERE address=?");
            validateUser.setString(1, Address);

            resultSet = validateUser.executeQuery();

            if (resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User already exist");
                alert.show();
            } else {
                String sql = "INSERT INTO student_details(user_id,Student_Name,Student_Dob,Student_Gender,Student_Guardian,contact,residence,address) VALUES (?,?,?,?,?,?,?,?)";
                insert = connect.prepareStatement(sql);
                insert.setString(1, Id);
                insert.setString(2, StudentName);
                insert.setString(3, StudentDob);
                insert.setString(4, StudentGender);
                insert.setString(5, StudentGuardian);
                insert.setInt(6, Integer.parseInt(Contact));
                insert.setString(7, Residence);
                insert.setString(8, Address);

                int row = insert.executeUpdate();
                if (row > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("New Student Added successfully");
                    alert.show();
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void change(ActionEvent event,String fxmlFile, String title) {
        Parent root = null;
        try {
            root = FXMLLoader.load(DataBaseController.class.getResource(fxmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void login(ActionEvent event, String username, String password){
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info_manager","root","");

            preparedStatement = connect.prepareStatement("SELECT password FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect username or password");
                alert.show();

            }else {
                while (resultSet.next()){
                    String retPass = resultSet.getString("password");
                    if (retPass.equals(password)){

                        change(event,"home.fxml","home");


                    }else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(" Incorrect username or password");
                        alert.show();
                    }
                }

            }

        } catch (SQLException e){
            e.printStackTrace();
        }



    }



}










