********STUDENT INFORMATION MANAGER********
To run program;

1. You First Have to download and install XAMPP or mySQL. No username or password is required.

2. Copy the following queries as listed and paste in the query section.


CREATE DATABASE student_info_manager;

CREATE TABLE student_details(id INT(255) NOT NULL PRIMARY KEY,Student_Name VARCHAR(255) NOT NULL,Student_Dob 
VARCHAR(255) NOT NULL,Student_Gender VARCHAR(255) NOT NULL,Student_Guardian VARCHAR(255) NOT NULL,
contact INT(10) NOT NULL, residence VARCHAR(255) NOT NULL, Address VARCHAR(255) NOT NULL);

CREATE TABLE users(user_id INT(100) NOT NULL PRIMARY KEY,username VARCHAR(255) NOT NULL,password VARCHAR(255) NOT NULL);

3. Then click on "create new account" link from the login page to have an account.

4. Go back to the login page and enter credentials to log into the app.

5. Click on "Add new student account" from the homepage to open interface for student details. Add a student.

6. Select back from the page to return to "home" and select "Display student information" to open next page.

7. Type the unique id of the student added and tap search button to display info. 
NB: The unique ID of students not in the database will display nothing. 

You can log out by going to the homepage.
