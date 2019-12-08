/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupProject;

import java.util.Arrays;
import java.util.List;
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
    Employee admin = new Employee("admin", "pass", "Hotel Administrator");
    Guest testguest = new Guest("guest","pass", "Hotel Guest");
    
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
    Label lblexistingEName = new Label();
    TextField txtEmpName = new TextField();
    Button btnCreateEmp = new Button("Create Employee");
    
    Button btnCreateGuest = new Button("Manage Guests");
    Button btnCreateRooms = new Button("Manage Rooms");
    Button btnLogout = new Button("Logout");
    
    Label lblGuestUser = new Label("Guest Username");
    Label lblGuestPass = new Label("Guest Password: ");
    Label lblGuestName = new Label("Guest Name: ");
    Label lblValueID = new Label("Value ID: ");
    TextField txtGuestUser = new TextField();
    TextField txtGuestPass = new TextField();
    TextField txtGuestName = new TextField();
    TextField txtValueID = new TextField();
    RadioButton r1 = new RadioButton("Value Guest"); 
    RadioButton r2 = new RadioButton("Regular Guest");
    Button btnNewGuest = new Button("Create");
    Label lblGuestExist = new Label();
    
    Label lbloldGuestName = new Label("Enter Old Name: ");
    Label lblEditGuestName = new Label("Enter New Guest Name: ");
    TextField txtEditGuestName = new TextField();
    TextField txtOldGuestName = new TextField();
    Button btnEditGuestName = new Button("Change Name");
    Label lblNameChangeSuccessful = new Label("Name Change Successful");
    
    Label lbloldGuestPass = new Label("Enter Old Guest Pass: ");
    Label lblEditGuestPass = new Label("Enter New Guest Pass: ");
    TextField txtEditGuestPass = new TextField();
    TextField txtOldGuestPass = new TextField();
    Button btnEditGuestPass = new Button("Change Password");
    Label lblPassChangeSuccessful = new Label("Password Change Successful");
    
    Label lblWelcomeGuest = new Label("Welcome");
    
// ROOM Tab
    public Button btnCreateRoom = new Button("Create Room");
    public Button btnSaveChanges = new Button("Save Changes");
    public TextField tfERRoomNo = new TextField();
    public TextField tfERRoomCost = new TextField();

    
    public Label lblFreeRoom = new Label("Free Rooms: ");
    public ListView bookingList = new ListView();
    public Label lblYear = new Label("Check in Year: ");
    public Label lblInDay = new Label("Check in Day: ");
    public Label lblOutDay = new Label("Check Out Day: ");
    public TextField txtYear = new TextField();
    public TextField txtInDay = new TextField();
    public TextField txtOutDay = new TextField();
    public Button btnBookRoom = new Button("Book Room ^");
    
    
    public Label lblBed = new Label("Bed");
    public Label lblBooked = new Label("Booked");
    public Label lblAvailable = new Label("Available");
    public Label lblKitchen = new Label("Kitchen");
    public Label lblCoffee = new Label("Coffee");
    public Label lblAccessibility = new Label("Accessibility");
    public Label lblPrice = new Label("Price");
    public Label lblStatus = new Label("Status");
    public Label lblERlistlabel = new Label("Select Room to View or Edit");
    public ListView lvERList = new ListView();
// BOOKING tab
    public Button btnNewBooking = new Button("New Booking");
    public Button btnDeleteBooking = new Button("Cancel Booking");
    public Button btnBtBookRpt = new Button("Run Booking Report");
    public Button btnSaveBooking = new Button("Save Booking");
    public Label lblName = new Label("Name");
    public Label lblGuestUsrName = new Label("Guest Username");
    public Label lblCheckIn = new Label("Check In");
    public Label lblCheckOut = new Label("Check Out");
    public Label lblRoom = new Label("Room");
    public Label lblTotalCost = new Label("Total Cost: ");
    public ListView lvEmpBookingFull = new ListView();
    public TextField tfGuestUsrName = new TextField();
    public TextField tfCheckIn = new TextField();
    public TextField tfCheckOut = new TextField();
    public TextField tfRoomNo = new TextField();  
  
//GridPanes
    public GridPane logonPane = new GridPane(); 
    public GridPane newEmployeePane = new GridPane();
    public GridPane empPane = new GridPane();
    public GridPane createGuestPane = new GridPane();
    public GridPane empRoomPane = new GridPane();
    public GridPane empBookingPane = new GridPane();
    public GridPane roomABookingPane = new GridPane();
    public GridPane handleGuestPane = new GridPane();
    public GridPane editGuestNamePane = new GridPane();
    public GridPane editGuestPassPane = new GridPane();
    public GridPane guestWelcomePane = new GridPane();
    public GridPane guestBookingViewPane = new GridPane();
    public GridPane guestPasswordPane = new GridPane();
    
    //Combobox
    public String visitor[] = {"Guest", "Employee"};
    public ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(visitor)); 
    public String bedOptions[] = {"1 Queen Bed", "2 Queen Beds", "1 King Bed"};
    public ComboBox cbRoomBedOpt = new ComboBox(FXCollections.observableArrayList(bedOptions));
    public String kitchenOptions[] = {"Microwave", "Fridge + Microwave"};
    public ComboBox cbRoomKitchOpt = new ComboBox(FXCollections.observableArrayList(kitchenOptions));
    public String coffeeOpt[] = {"1-Cup Std. Coffee Machine", "Keuring Hot K200 Machine"};
    public ComboBox cbRoomCoffeeOpt = new ComboBox(FXCollections.observableArrayList(coffeeOpt));
    public String accessOptions[] = {"Standard Room", "Enhanced Accessiblity Room"};
    public ComboBox cbRoomAccessOpt = new ComboBox(FXCollections.observableArrayList(accessOptions));
    public String roomStatus[] = {"Active", "Deactive"};
    public ComboBox cbRoomActiveOpt = new ComboBox(FXCollections.observableArrayList(roomStatus));
    
    //Tabs
    public TabPane roomBookingTabPane = new TabPane();
    public Tab tabEmpBooking = new Tab("Bookings");
    public Tab tabEmpRoom = new Tab("Rooms");
    public Tab rbHandleLogoutTab = new Tab ("Logout");
    
    public TabPane guestHandleTabPane = new TabPane();
    public Tab createNewGuestTab = new Tab("Create");
    public Tab editGuestTab = new Tab ("Edit Name");
    public Tab editPassTab = new Tab ("EditName");
    public Tab gHandleLogoutTab = new Tab ("Logout");
    
    public TabPane guestWelcomeTabPane = new TabPane();
    public Tab guestBookingViewTab = new Tab("Booking");
    public Tab changePasswordTab = new Tab("Edit Password");
    
    
//Scenes
    public Scene loginScene = new Scene(logonPane,500,400);
    public Scene newEmpScene = new Scene(newEmployeePane, 500, 400);
    public Scene empWelcomeScene = new Scene(empPane, 500, 400);
    public Scene newGuestScene = new Scene(createGuestPane, 500, 400);
    public Scene guestWelcomeScene = new Scene(guestWelcomePane, 500,400);
    public Scene roombookingScene = new Scene(roomABookingPane, 500, 400);
    public Scene handleGuestScene = new Scene(handleGuestPane, 500, 400);
    
    
    
    
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
        newEmployeePane.setAlignment(Pos.CENTER);
        newEmployeePane.add(lblEmpUsername, 0,0);
        newEmployeePane.add(lblEmpPassword, 0, 1);
        newEmployeePane.add(lblEmpName, 0, 2);
        newEmployeePane.add(txtEmpUsername, 1, 0);
        newEmployeePane.add(txtEmpPassword, 1, 1);
        newEmployeePane.add(txtEmpName, 1, 2);
        newEmployeePane.add(btnCreateEmp, 1,3);
        newEmployeePane.add(lblexistingEName, 3, 3);
  
//Employee Welcome Pane  
        empPane.setAlignment(Pos.CENTER);
        empPane.add(btnCreateGuest, 0, 1);
        empPane.add(btnCreateRooms, 0, 3);
        empPane.add(btnLogout, 0, 4);
        
        roomABookingPane.add(roomBookingTabPane,0,0);
        tabEmpRoom.setContent(empRoomPane);
        tabEmpBooking.setContent(empBookingPane);
        roomBookingTabPane.getTabs().add(tabEmpRoom);
        roomBookingTabPane.getTabs().add(tabEmpBooking);
        roomBookingTabPane.getTabs().add(rbHandleLogoutTab);
        
        handleGuestPane.add(guestHandleTabPane, 0, 0);
        createNewGuestTab.setContent(createGuestPane);
        editGuestTab.setContent(editGuestNamePane);
        editPassTab.setContent(editGuestPassPane);
        guestHandleTabPane.getTabs().add(createNewGuestTab);
        guestHandleTabPane.getTabs().add(editGuestTab);
        guestHandleTabPane.getTabs().add(editPassTab);
        guestHandleTabPane.getTabs().add(gHandleLogoutTab);
        
        guestWelcomePane.add(guestWelcomeTabPane, 0, 0);
        guestBookingViewTab.setContent(guestBookingViewPane);
        changePasswordTab.setContent(guestPasswordPane);
        guestWelcomeTabPane.getTabs().add(guestBookingViewTab);
        guestWelcomeTabPane.getTabs().add(changePasswordTab);
        
        
        
        
        guestBookingViewPane.setAlignment(Pos.CENTER);
        guestBookingViewPane.add(lblFreeRoom, 0,1);
        guestBookingViewPane.add(bookingList, 1,1);
        guestBookingViewPane.add(lblYear, 0,2);
        guestBookingViewPane.add(txtYear, 1,2);
        guestBookingViewPane.add(lblInDay, 0,3);
        guestBookingViewPane.add(txtInDay, 1,3);
        guestBookingViewPane.add(lblOutDay, 0,4);
        guestBookingViewPane.add(txtOutDay, 1,4);
        guestBookingViewPane.add(btnBookRoom, 1,5);
        
          
//Guest Creation
        createGuestPane.setAlignment(Pos.CENTER);
        createGuestPane.add(lblGuestUser, 0,1);
        createGuestPane.add(lblGuestPass, 0, 2);
        createGuestPane.add(lblGuestName, 0, 3);
        createGuestPane.add(lblValueID, 0, 4);
        createGuestPane.add(txtGuestUser, 1, 1);
        createGuestPane.add(txtGuestPass, 1, 2);
        createGuestPane.add(txtGuestName, 1, 3);
        createGuestPane.add(txtValueID, 1, 4);
        createGuestPane.add(r1, 3, 1);
        createGuestPane.add(r2, 3, 2);
        createGuestPane.add(btnNewGuest,0,5);
        createGuestPane.add(lblGuestExist, 3, 4);
        lblValueID.setVisible(false);
        txtValueID.setVisible(false);
        
        editGuestNamePane.setAlignment(Pos.CENTER);
        editGuestNamePane.add(lbloldGuestName, 0, 1);
        editGuestNamePane.add(lblEditGuestName, 0, 2);
        editGuestNamePane.add(txtOldGuestName, 1, 1);
        editGuestNamePane.add(txtEditGuestName, 1, 2);
        editGuestNamePane.add(btnEditGuestName, 0, 3);
        editGuestNamePane.add(lblNameChangeSuccessful, 1, 3);
        lblNameChangeSuccessful.setVisible(false);
        
        
        editGuestPassPane.setAlignment(Pos.CENTER);
        editGuestPassPane.add(lbloldGuestPass, 0, 1);
        editGuestPassPane.add(lblEditGuestPass, 0, 2);
        editGuestPassPane.add(txtOldGuestPass, 1, 1);
        editGuestPassPane.add(txtEditGuestPass, 1, 2);
        editGuestPassPane.add(btnEditGuestPass, 0, 3);
        editGuestPassPane.add(lblPassChangeSuccessful, 1, 3);
        lblPassChangeSuccessful.setVisible(false);
        
        
        
        
        
        
 //Guest Welcome Pane
       

 // Employee Room Pane
        ObservableList<Room> roomList = FXCollections.observableArrayList();
        lvERList = new ListView(roomList);
        empRoomPane.add(tfERRoomNo,1,0);
        empRoomPane.add(lblBed,0,2);
        empRoomPane.add(cbRoomBedOpt,1,2);
        empRoomPane.add(lblKitchen,0,3);
        empRoomPane.add(cbRoomKitchOpt, 1,3);
        empRoomPane.add(lblCoffee,0,4);
        empRoomPane.add(cbRoomCoffeeOpt,1,4);
        empRoomPane.add(lblAccessibility,0,5);
        empRoomPane.add(cbRoomAccessOpt,1,5);
        empRoomPane.add(lblPrice,0,6);
        empRoomPane.add(tfERRoomCost,1,6);
        empRoomPane.add(lblStatus,0,7);
        empRoomPane.add(cbRoomActiveOpt,1,7);
        empRoomPane.add(btnCreateRoom,0,8);
        empRoomPane.add(btnSaveChanges,1,8);
        empRoomPane.add(lblAvailable,3,0);
        empRoomPane.add(lblERlistlabel,4,0);
        empRoomPane.add(lvERList,4,1,1, 8); 
        List<String> beds = Arrays.asList(bedOptions);
        List<String> kitchen = Arrays.asList(kitchenOptions);
        List<String> coffee = Arrays.asList(coffeeOpt);
        List<String> access = Arrays.asList(accessOptions);
        btnCreateRoom.setOnAction(e -> 
                roomList.add(new Room(beds.indexOf(cbRoomBedOpt.getValue()) + 1,
                kitchen.indexOf(cbRoomKitchOpt.getValue()) + 1,
                coffee.indexOf(cbRoomCoffeeOpt.getValue()) + 1,
                access.indexOf(cbRoomAccessOpt.getValue()) + 1,
                Integer.parseInt(tfERRoomNo.getText())))
                
                
        
        );
        
 // Employee Booking Pane
        empBookingPane.add(lblGuestUsrName, 0, 0);
        empBookingPane.add(tfGuestUsrName, 1, 0);
        empBookingPane.add(lblName, 0, 1);
        empBookingPane.add(lblCheckIn, 0, 2);
        empBookingPane.add(tfCheckIn, 1, 2);
        empBookingPane.add(lblCheckOut, 0, 3);
        empBookingPane.add(tfCheckOut, 1, 3);
        empBookingPane.add(lblRoom, 0, 4);
        empBookingPane.add(tfRoomNo, 1, 4);
        empBookingPane.add(lblTotalCost, 0, 5);
        empBookingPane.add(btnNewBooking, 0, 6);
        empBookingPane.add(btnDeleteBooking, 1, 6);
        empBookingPane.add(btnBtBookRpt, 0, 7);
        empBookingPane.add(lvEmpBookingFull, 3, 0, 1, 7);
        
        
     

  
 //Stage
        primaryStage.setTitle("Madison Login System");
        primaryStage.setScene(loginScene);
        primaryStage.show();
        
        btnNewEmployee.setOnAction(e -> {
            primaryStage.setScene(newEmpScene);
        });
        
        btnCreateEmp.setOnAction(e -> {
            createEmployee();
            
        });
        
        btnLogin.setOnAction(e -> {
            loginHandler();
        });
        gHandleLogoutTab.setOnSelectionChanged(e -> 
                primaryStage.setScene(empWelcomeScene));
        rbHandleLogoutTab.setOnSelectionChanged(e -> 
                primaryStage.setScene(empWelcomeScene));
 //Sets Pane to Create a new Guest       
        btnCreateRooms.setOnAction(e -> {
            primaryStage.setScene(roombookingScene);
            
        });
        
        btnCreateGuest.setOnAction(e -> {
            primaryStage.setScene(handleGuestScene);
            
        });
        r1.setOnAction(e -> {
            lblValueID.setVisible(true);
            txtValueID.setVisible(true);  
        });
        r2.setOnAction(e -> {
            lblValueID.setVisible(false);
            txtValueID.setVisible(false);  
        });
        btnNewGuest.setOnAction(e -> {
            createGuest();
        });
        btnLogout.setOnAction(e -> {
            txtLogUsername.clear();
            txtLogPassword.clear();
            primaryStage.setScene(loginScene);   
        });
    }
    
    
    
    public void loginHandler(){
        if(combo_box.getValue().equals("Employee"))
            {
                employeeLogin();
            }
            
            else if(combo_box.getValue().equals("Guest"))
            {
                guestLogin(); 
            }
            else
            {
                
            }
    }
    public void createGuest(){
        String username = txtGuestUser.getText();
            String password = txtGuestPass.getText();
            String name = txtGuestName.getText();
            boolean bool = false;
            for (int i=0; i<Guest.guests.size(); i++) {
                bool = username.equals(Guest.guests.get(i).getUsername());
                if (bool == true) {
                    txtGuestUser.clear();
                    lblGuestExist.setText("Username already Exists");
                }
            }
            if (bool == false) 
            {
                if(r1 != null)
                {
                   String valueID = txtValueID.getText();
                   ValueGuest vGuest = new ValueGuest(username,password,name, valueID);
                   txtValueID.clear();
                }
                else
                {
                   Guest guest = new Guest(username,password,name);
                }
                txtGuestUser.clear();
                txtGuestPass.clear();
                txtGuestName.clear();
                stage.setScene(empWelcomeScene);
                stage.setTitle("Employee Center");
            }
    }
    
    public void createEmployee(){
        String empUsername = txtEmpUsername.getText();
            boolean bool = false;
            for (int i=0; i<Employee.employees.size(); i++) {
                bool = empUsername.equals(Employee.employees.get(i).getUsername());
            }
            if (bool == true) {
                txtEmpUsername.clear();
                lblexistingEName.setText("Username already Exists");
            }
            else if (bool == false) {
                String empPassword = txtEmpPassword.getText();
                String empName = txtEmpName.getText();
                Employee emp1 = new Employee(empUsername, empPassword, empName);
                txtEmpUsername.clear();
                txtEmpName.clear();
                txtEmpPassword.clear();
                stage.setScene(loginScene);
            }
            
    }
    public void employeeLogin()
    {
        String username;
        String password;
        boolean bool = false;
        username = txtLogUsername.getText();
        password = txtLogPassword.getText();
        for (int i=0; i<Employee.employees.size(); i++) 
        {
            if ((Employee.employees.get(i) != null) && (Employee.employees.get(i).getUsername().equals(username))) 
            {
                bool = Employee.employees.get(i).checkCredentials(username, password);
            }     
        }
        if (bool == false) 
            { 
                    
            }
        else
            {
                stage.setScene(empWelcomeScene);
                stage.setTitle("Employee Center");
            }
    }
    public void guestLogin()
    {
        String username;
        String password;
        boolean bool = false;
        username = txtLogUsername.getText();
        password = txtLogPassword.getText();
        for (int i=0; i<Guest.guests.size(); i++) 
        {
            if ((Guest.guests.get(i) != null) && (Guest.guests.get(i).getUsername().equals(username))) 
            {
                bool = Guest.guests.get(i).checkCredentials(username, password);
            }
        }
        if (bool == false) 
        {
                System.out.print("Invalid Credentials. If you would like to exit, set the username to 'X'");
                System.out.println();
                System.out.println();
        }
        else
            {
                stage.setScene(guestWelcomeScene);
                stage.setTitle("Welcome New Guest");
            }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
