/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.shape.*;

/**
 *
 * @author AJnike
 */
public class ApplicationUI extends Application {
    private Stage stage;
    
    TextField txtLogUsername = new TextField();
    TextField txtLogPassword = new TextField();
    Label lblLogUsername = new Label("Username: ");
    Label lblLogPassword = new Label("Password: ");
    Button btnNewEmployee = new Button("New Employee");
    Button btnLogin = new Button("Login");
    
    TextField txtEmpUsername = new TextField();
    TextField txtEmpPassword = new TextField();
    Label lblEmpUsername = new Label("Username: ");
    Label lblEmpPassword = new Label("Password: ");
    Label lblEmpName = new Label("Employee Name: ");
    Label lblexistingName = new Label("Username already Exists");
    TextField txtEmpName = new TextField();
    Button btnCreateEmp = new Button("Create Employee");
    
    Button btnCreateGuest = new Button("Guest Creator");
    Button btnCreateRooms = new Button("Create Room");
    Button btnEditGuest = new Button("Edit Guest");
    
    Label lblGuestUser = new Label("Username");
    Label lblGuestPass = new Label("Password: ");
    Label lblGuestName = new Label("Guest Name: ");
    TextField txtGuestUser = new TextField();
    TextField txtGuestPass = new TextField();
    TextField txtGuestName = new TextField();
    Button btnNewGuest = new Button("Create");
    
    
    
//Login   
    //GridPanes
    public GridPane logonPane = new GridPane(); 
    public GridPane newEmployee = new GridPane();
    public GridPane empScene = new GridPane();
    public GridPane createGuest = new GridPane();
    
    //Combobox
    String visitor[] = {"Guest", "Employee"};
    ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(visitor)); 
    
    //Tabs
    public TabPane tabPaneEmp = new TabPane();
    public Tab tabNewEmp = new Tab("Create");
    public Tab tabEmpBooking = new Tab("Bookings");
    
    public Scene loginScene = new Scene(logonPane,500,400);
    public Scene newEmpScene = new Scene(newEmployee, 500, 400);
    public Scene empWelcome = new Scene(empScene, 500, 400);
    public Scene newGuestScene = new Scene(createGuest, 500, 400);
    
    
    
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        
//Login     
        logonPane.setAlignment(Pos.CENTER);
        logonPane.add(lblLogUsername, 0, 0);
        logonPane.add(lblLogPassword, 0, 1);
        logonPane.add(txtLogUsername, 1, 0);
        logonPane.add(txtLogPassword, 1, 1);
        logonPane.add(btnNewEmployee, 0, 2);
        logonPane.add(combo_box, 1, 2);
        logonPane.add(btnLogin, 0, 3);
        
//Create New Employee     
        newEmployee.setAlignment(Pos.CENTER);
        newEmployee.add(lblEmpUsername, 0,0);
        newEmployee.add(lblEmpPassword, 0, 1);
        newEmployee.add(lblEmpName, 0, 2);
        newEmployee.add(txtEmpUsername, 1, 0);
        newEmployee.add(txtEmpPassword, 1, 1);
        newEmployee.add(txtEmpName, 1, 2);
        newEmployee.add(btnCreateEmp, 1,3);
  
//Employee Welcome Scene  
        empScene.setAlignment(Pos.CENTER);
        empScene.add(btnCreateGuest, 0, 1);
        empScene.add(btnEditGuest, 0, 2);
        empScene.add(btnCreateRooms, 0, 3);
        
//Guest Creation
        createGuest.setAlignment(Pos.CENTER);
        createGuest.add(lblGuestUser, 0,0);
        createGuest.add(lblGuestPass, 0, 1);
        createGuest.add(lblGuestName, 0, 2);
        createGuest.add(txtGuestUser, 1, 0);
        createGuest.add(txtGuestPass, 1, 1);
        createGuest.add(txtGuestName, 1, 2);
        createGuest.add(btnNewGuest,0,3);

        
        
        
     

  
 //Stage
        primaryStage.setTitle("Madison Login System");
        primaryStage.setScene(loginScene);
        primaryStage.show();
        
        btnNewEmployee.setOnAction(e -> {
            primaryStage.setScene(newEmpScene);
        });
        
        btnCreateEmp.setOnAction(e -> {
            String empUsername = txtEmpUsername.getText();
            boolean bool = false;
            for (int i=0; i<Employee.employees.size(); i++) {
                bool = empUsername.equals(Employee.employees.get(i).getUsername());
            }
            if (bool == true) {
                txtEmpUsername.clear();
                newEmployee.add(lblexistingName, 3, 3);
            }
            else if (bool == false) {
                String empPassword = txtEmpPassword.getText();
                String empName = txtEmpName.getText();
                Employee emp1 = new Employee(empUsername, empPassword, empName);
                txtEmpUsername.clear();
                txtEmpName.clear();
                txtEmpPassword.clear();
                primaryStage.setScene(loginScene);
            }
            
            
        });
        
        btnLogin.setOnAction(e -> {
            
            if(combo_box.getValue().equals("Employee"))
            {
                {
                   employeeLogin(); 
                } 
            }
            
            else if(combo_box.getValue().equals("guest"))
            {
                
            }
            else
            {
                
            }
        });
        
        btnCreateGuest.setOnAction(e -> {
            primaryStage.setScene(newGuestScene);
        });
    }
    
    public void employeeLogin()
    {
        String username;
        String password;
        boolean bool = false;
        username = txtLogUsername.getText();
                password = txtLogPassword.getText();
                for (int i=0; i<Employee.employees.size(); i++) {
                if ((Employee.employees.get(i) != null) && (Employee.employees.get(i).getUsername().equals(username))) {
                    bool = Employee.employees.get(i).checkCredentials(username, password);
                }     
                }
            if (bool == false) 
                { 
                    
                }
            else
                {
                    stage.setScene(empWelcome);
                    stage.setTitle("Employee Center");
                }
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
