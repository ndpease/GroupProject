/*
Author: Nick Pease, Aaron Morgan, Connor Hotaling, Stephen Pannier
Date: 11/25/19
Title: Group Project Part II: Madison Hotel, UI Class
Purpose: Provide an interface for users to access the Madison Hotel Application
*/


package FinalGroupProject;

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
/*
import java.sql.*;
import oracle.jdbc.pool.*;
import java.util.*;
*/

public class ApplicationUI extends Application {
    private Stage stage;
    Employee admin = new Employee("admin", "pass", "Hotel Administrator");
    Guest testguest = new Guest("guest","pass", "Hotel Guest");
    Room room1 = new Room(1,1,1,1,1);
    Room room2 = new Room(1,1,1,1,2);
    /*    
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;

    String empTbl = "EMPLOYEE";
    String guesTbl = "GUEST";
    String bookingTbl = "BOOKING";
    String roomTbl = "ROOM";
    String valTbl = "VALUE_GUEST";
    String roomServTbl = "ROOM_SERVICE"; 
    */
    public Button btnReturnToMenu = new Button("Return to Employee Menu");

    //Login Variable
    public TextField txtLogUsername = new TextField();
    public TextField txtLogPassword = new TextField();
    public Label lblLogUsername = new Label("Username: ");
    public Label lblLogPassword = new Label("Password: ");
    public Button btnNewEmployee = new Button("New Employee");
    public Button btnLogin = new Button("Login");
    //Create a new employee variable
    public TextField txtEmpUsername = new TextField();
    public TextField txtEmpPassword = new TextField();
    public Label lblEmpUsername = new Label("Username: ");
    public Label lblEmpPassword = new Label("Password: ");
    public Label lblEmpName = new Label("Employee Name: ");
    public Label lblexistingEName = new Label();
    public TextField txtEmpName = new TextField();
    public Button btnCreateEmp = new Button("Create Employee");
    Label lblBadEmpPass = new Label();
    
    //Empoyee Menu page buttons 
    public Button btnCreateGuest = new Button("Manage Guests");
    public Button btnCreateRooms = new Button("Manage Rooms");
    public Button btnLogout = new Button("Logout");
    
    //Guest Create UI variables
    public Label lblGuestUser = new Label("Guest Username");
    public Label lblGuestPass = new Label("Guest Password: ");
    public Label lblGuestName = new Label("Guest Name: ");
    public Label lblValueID = new Label("Value ID: ");
    public TextField txtGuestUser = new TextField();
    public TextField txtGuestPass = new TextField();
    public TextField txtGuestName = new TextField();
    public TextField txtValueID = new TextField();
    public RadioButton r1 = new RadioButton("Value Guest"); 
    public RadioButton r2 = new RadioButton("Regular Guest");
    public Button btnNewGuest = new Button("Create");
    public Label lblGuestExist = new Label();
    Label lblBadGuestPass = new Label();
    
    //Employee user change variables
    public Label lbloldGuestName = new Label("Enter Old Name: ");
    public Label lblEditGuestName = new Label("Enter New Guest Name: ");
    public TextField txtEditGuestName = new TextField();
    public TextField txtOldGuestName = new TextField();
    public Button btnEditGuestName = new Button("Change Name");
    public Label lblNameChangeSuccessful = new Label("Name Change Successful");
    
    public Label lblEditGuestName1 = new Label("Enter New Guest Name: ");
    public TextField txtEditGuestName1 = new TextField();
    public Button btnEditGuestName1 = new Button("Submit Name Change");
    public Label lblNameChangeSuccessful1 = new Label();
    
    public Label lblOldPass = new Label("Enter Old Password:");
    public TextField txtOldPass = new TextField();
    public Label lblNewPass = new Label("Enter New Password:");
    public TextField txtNewPass = new TextField();
    public Label lblConfirmNewPass = new Label("Confirm New Password:");
    public TextField txtConfirmNewPass = new TextField();
    public Button btnSubmitNewPass = new Button("Submit Password Change");
    public Label lblPassChange = new Label();
    /*
    Label lbloldGuestPass = new Label("Enter Old Guest Pass: ");
    Label lblEditGuestPass = new Label("Enter New Guest Pass: ");
    TextField txtEditGuestPass = new TextField();
    TextField txtOldGuestPass = new TextField();
    Button btnEditGuestPass = new Button("Change Password");
    Label lblPassChangeSuccessful = new Label("Password Change Successful");*/
    
    Label lblWelcomeGuest = new Label("Welcome");
    
// ROOM Tab
    public Button btnCreateRoom = new Button("Create Room");
    public Button btnSaveChanges = new Button("Save Changes");
    public TextField tfERRoomNo = new TextField();
    public TextField tfERRoomCost = new TextField();

    Button btnEditGuest = new Button("Edit Guest");
    
    // Room booking variable 
    public Label lblFreeRoom = new Label("Free Rooms: ");
    public ListView bookingList = new ListView();
    public Label lblYear = new Label("Check in Year: ");
    public Label lblInDay = new Label("Check in Day: ");
    public Label lblOutDay = new Label("Check Out Day: ");
    public TextField txtYear = new TextField();
    public TextField txtInDay = new TextField();
    public TextField txtOutDay = new TextField();
    public Button btnBookRoom = new Button("Book Room ^");
    
    // Room creation variables 
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
    public GridPane editGuestPane = new GridPane();
    public GridPane editGuestUsernamePane = new GridPane();
    public GridPane editGuestNamePane1 = new GridPane();
    public GridPane editGuestPassPane1 = new GridPane();
    public GridPane roomServicePane = new GridPane();
    
    //Combobox's
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
    public String services[] = {"Pizza", "Milkshake", "Burgers", "Towels", "Blankets"};
    public ComboBox serviceBox = new ComboBox(FXCollections.observableArrayList(services)); 
    public Label lblserviceChoice = new Label("Select Service");
    public Button BtnOrder = new Button("Place Order");
    public ListView serviceList = new ListView();
    
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
    public Tab roomServiceTab = new Tab ("Order Room Service");
    public Tab guestLogoutTab = new Tab ("Logout");
    
    public TabPane editGuestTabPane = new TabPane();
    public Tab editGuestNameTab = new Tab("Click To Edit Guest Name");
    public Tab editGuestPassTab = new Tab ("Click To Edit Guest Password");
    
    //Employee guest access variables 
    public Label lblEditGuestUsername = new Label("Enter the Username of the Guest you would like to edit: ");
    public TextField txtEditGuestUsername = new TextField();
    public Button btnEditGuestUsername = new Button("Submit Username: ");
    public Label lblEditGuestUsernameError = new Label();
    public Button btnReturnToMenu1 = new Button("Return to Employee Menu");
    
//Scenes
    public Scene loginScene = new Scene(logonPane,500,400);
    public Scene newEmpScene = new Scene(newEmployeePane, 500, 400);
    public Scene empWelcomeScene = new Scene(empPane, 500, 400);
    public Scene newGuestScene = new Scene(createGuestPane, 500, 400);
    public Scene guestWelcomeScene = new Scene(guestWelcomePane, 500,400);
    public Scene roombookingScene = new Scene(roomABookingPane, 500, 400);
    public Scene handleGuestScene = new Scene(handleGuestPane, 500, 400);
    public Scene editGuestScene = new Scene(editGuestPane, 500, 400);
    public Scene editGuestUsernameScene = new Scene(editGuestUsernamePane, 500, 400);
    
    
    
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        
        //Employee guest editor pane layout
        editGuestPane.setAlignment(Pos.TOP_CENTER);
        editGuestPane.add(editGuestTabPane, 2, 0);
        editGuestTabPane.getTabs().add(editGuestNameTab);
        editGuestTabPane.getTabs().add(editGuestPassTab);
        editGuestPane.add(btnReturnToMenu, 2, 7);
        
        //Employee guest name editor pane layout
        editGuestNameTab.setContent(editGuestNamePane);
        editGuestNamePane.add(lblEditGuestName, 4, 1);
        editGuestNamePane.add(txtEditGuestName, 4, 2);
        editGuestNamePane.add(btnEditGuestName, 4, 3);
        editGuestNamePane.add(lblNameChangeSuccessful, 4, 4);
        
        //Employee guest password editor pane layout
        editGuestPassTab.setContent(editGuestPassPane);
        editGuestPassPane.add(lblOldPass, 0, 1);
        editGuestPassPane.add(txtOldPass, 0, 2);
        editGuestPassPane.add(lblNewPass, 0, 4);
        editGuestPassPane.add(txtNewPass, 0, 5);
        editGuestPassPane.add(lblConfirmNewPass, 0, 7);
        editGuestPassPane.add(txtConfirmNewPass, 0, 8);
        editGuestPassPane.add(btnSubmitNewPass, 0, 9);
        editGuestPassPane.add(lblPassChange, 0, 10);
        
        ////Employee guest name pane layout
        editGuestUsernamePane.setAlignment(Pos.CENTER);
        editGuestUsernamePane.add(lblEditGuestUsername, 0, 0);
        editGuestUsernamePane.add(txtEditGuestUsername, 0, 1);
        editGuestUsernamePane.add(btnEditGuestUsername, 0, 2);
        editGuestUsernamePane.add(lblEditGuestUsernameError, 0, 3);
        editGuestUsernamePane.add(btnReturnToMenu1, 0, 4);
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
        newEmployeePane.add(lblBadEmpPass, 1, 4);
  
//Employee Welcome Pane  
        empPane.setAlignment(Pos.CENTER);
        empPane.add(btnCreateGuest, 0, 1);
        empPane.add(btnCreateRooms, 0, 3);
        empPane.add(btnLogout, 0, 4);
        
        //Room creation Tabpane layout
        roomABookingPane.add(roomBookingTabPane,0,0);
        tabEmpRoom.setContent(empRoomPane);
        tabEmpBooking.setContent(empBookingPane);
        roomBookingTabPane.getTabs().add(tabEmpRoom);
        roomBookingTabPane.getTabs().add(tabEmpBooking);
        roomBookingTabPane.getTabs().add(rbHandleLogoutTab);
        
        //Guest Editor Tabpane layout
        handleGuestPane.add(guestHandleTabPane, 0, 0);
        createNewGuestTab.setContent(createGuestPane);
        editGuestTab.setContent(editGuestUsernamePane);
        guestHandleTabPane.getTabs().add(createNewGuestTab);
        guestHandleTabPane.getTabs().add(editGuestTab);
        guestHandleTabPane.getTabs().add(gHandleLogoutTab);
        
        //Welcome Guest Tabpane layout
        guestWelcomePane.add(guestWelcomeTabPane, 0, 0);
        guestBookingViewTab.setContent(guestBookingViewPane);
        roomServiceTab.setContent(roomServicePane);
        guestWelcomeTabPane.getTabs().add(guestBookingViewTab);
        guestWelcomeTabPane.getTabs().add(roomServiceTab);
        guestWelcomeTabPane.getTabs().add(guestLogoutTab);
        
        
        
        //Guest booking pane layout
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
        createGuestPane.add(lblBadGuestPass, 1, 5);
        lblValueID.setVisible(false);
        txtValueID.setVisible(false);
        
        
        
        /*
        editGuestPassPane.setAlignment(Pos.CENTER);
        editGuestPassPane.add(lbloldGuestPass, 0, 1);
        editGuestPassPane.add(lblEditGuestPass, 0, 2);
        editGuestPassPane.add(txtOldGuestPass, 1, 1);
        editGuestPassPane.add(txtEditGuestPass, 1, 2);
        editGuestPassPane.add(btnEditGuestPass, 0, 3);
        editGuestPassPane.add(lblPassChangeSuccessful, 1, 3);
        lblPassChangeSuccessful.setVisible(false);*/
        
        
        
        /*public String services[] = {"Pizza", "Milkshake", "Burgers", "Towels", "Blankets"};
    public ComboBox serviceBox = new ComboBox(FXCollections.observableArrayList(services)); 
    public Label lblserviceChoice = new Label("Select Service");
    public Button BtnOrder = new Button("Place Order");*/
        
        
 //Guest Welcome Pane
       roomServicePane.setAlignment(Pos.CENTER);
       roomServicePane.add(lblserviceChoice, 0, 1);
       roomServicePane.add(serviceBox, 1, 1);
       roomServicePane.add(BtnOrder,0, 2);
       roomServicePane.add(serviceList, 3, 1);

 // Employee Room Pane
        ObservableList<Room> roomList = FXCollections.observableArrayList();
        ObservableList<RoomDisplay> displayList = FXCollections.observableArrayList();
        bookingList = new ListView(displayList);
        lvERList = new ListView(roomList);
        guestBookingViewPane.add(bookingList, 1,1);
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
        
        btnCreateRoom.setOnAction(e ->{ 
                Room room = new Room(beds.indexOf(cbRoomBedOpt.getValue()) + 1,
                kitchen.indexOf(cbRoomKitchOpt.getValue()) + 1,
                coffee.indexOf(cbRoomCoffeeOpt.getValue()) + 1,
                access.indexOf(cbRoomAccessOpt.getValue()) + 1,
                Integer.parseInt(tfERRoomNo.getText()));
                roomList.add(room);
                displayList.add(new RoomDisplay(room));
                //insertRoom();
                
                
        
        });
        
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
        guestLogoutTab.setOnSelectionChanged(e -> {
                txtLogUsername.clear();
                txtLogPassword.clear();
                primaryStage.setScene(loginScene);
                
        });
 //Sets Pane to Create a new Guest       
        btnCreateRooms.setOnAction(e -> {
            primaryStage.setScene(roombookingScene);
            
        });
        
        btnCreateGuest.setOnAction(e -> {
            primaryStage.setScene(handleGuestScene);
            
        });
        //Raio button initialization 
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
        
        btnEditGuest.setOnAction(e -> {
            stage.setScene(editGuestUsernameScene);
            editGuestUsername();
        });
        
        //Handles editing guest name 
        btnEditGuestUsername.setOnAction(e -> {
            if (editGuestUsername() != -2)
            {
                editGuestName(editGuestUsername());
                lblEditGuestUsernameError.setText("");
            }
            else
            {
               lblEditGuestUsernameError.setText("Username is not in the system. Try again!");
               txtEditGuestUsername.clear();
            }
        });
        
        //Clears guest name when logging out 
         btnReturnToMenu.setOnAction(e -> {
            primaryStage.setScene(empWelcomeScene);
            txtEditGuestName.clear();
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        });
        btnReturnToMenu1.setOnAction(e -> {
            primaryStage.setScene(empWelcomeScene);
            txtEditGuestUsername.clear();
        });
          
        btnEditGuestName.setOnAction(e -> {
            editGuestName(editGuestUsername());
            txtEditGuestName.clear();
            lblNameChangeSuccessful.setText("Name Change Successful!");
        });
        btnSubmitNewPass.setOnAction(e -> {
            editGuestPass(editGuestUsername()); 
        });
    }
    
    //handles editing guest username
      public int editGuestUsername()
    {
        
        int guestNum = -1;
        for (int i=0; i<Guest.guests.size(); i++) 
        {
            if (txtEditGuestUsername.getText().equalsIgnoreCase(Guest.guests.get(i).getUsername()))
            {
                guestNum = i;
                return guestNum;
            }
            else
                guestNum = -2;
        }
        return guestNum;
    }
      
    //handles editing guests name 
        public void editGuestName(int guestNum)
    {
        stage.setScene(editGuestScene);
        
        String newName = txtEditGuestName.getText();
        Guest.guests.get(guestNum).setGuestName(newName);
    }
    
    // Handles editing guests password
    public void editGuestPass(int guestNum)
    {
        stage.setScene(editGuestScene);
        
        String oldP = txtOldPass.getText();
        String newP = txtNewPass.getText();
        String newP1 = txtConfirmNewPass.getText();
        
        if (newP.equals(newP1) && Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP) == 0)
        {
            Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP);
            lblPassChange.setText("");
            lblPassChange.setText("Password Change Successful!");
        }
        else if (!Guest.guests.get(guestNum).getPassword().equals(oldP))
        {
            lblPassChange.setText("");
            lblPassChange.setText("Your Old Password does not match. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        }
        else if (newP.equals(newP1) && Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP) == 1)
        {
            lblPassChange.setText("");
            lblPassChange.setText("Password Must Contain At Least 1 Uppercase letter and 1 Number. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        }
        else if (newP.equals(newP1) && Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP) == 2)
        {
            lblPassChange.setText("");
            lblPassChange.setText("Password Cannot Start With a Number. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        }
        else if (newP.equals(newP1) && Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP) == 3)
        {
            lblPassChange.setText("");
            lblPassChange.setText("New Password Cannot Be The Same As The Old Password. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        }
        else if (!newP.equals(newP1))
        {
            lblPassChange.setText("");
            lblPassChange.setText("Your Confirmed Password Does Not Match. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        }
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
               //Input validation for loging in  
            }
    }
    
    // Create a new guest login
    public void createGuest() {
        String guestUsername = txtGuestUser.getText();
        String guestPassword = txtGuestPass.getText();
        String guestName = txtGuestName.getText();
        boolean bool = false;

        for (int i = 0; i < Guest.guests.size(); i++) {
            bool = guestUsername.equals(Guest.guests.get(i).getUsername());
            if (bool == true) {
                txtGuestUser.clear();
                lblGuestExist.setText("Username already Exists");
            }
        }
        if (bool == false) {
            if (r1 != null) {
                String valueID = txtValueID.getText();
                ValueGuest vGuest = new ValueGuest(guestUsername, guestPassword, guestName, valueID);
                int check = vGuest.setPassword(guestPassword);

                if (check == 1) {
                    lblBadGuestPass.setText("Password Must Contain At Least 1 Uppercase letter and 1 Number.");
                    vGuest.setBlankPassword();
                    vGuest.setBlankUsername();
                    txtGuestPass.clear();
                } else if (check == 2) {
                    lblBadGuestPass.setText("Password Cannot Start With a Number.");
                    vGuest.setBlankPassword();
                    vGuest.setBlankUsername();
                    txtGuestPass.clear();
                } else {
                    vGuest.setPassword(guestPassword);
                    vGuest.setUsername(guestUsername);
                    stage.setScene(empWelcomeScene);
                    stage.setTitle("Employee Center");
                    txtValueID.clear();
                    txtGuestName.clear();
                    txtGuestPass.clear();
                    txtGuestUser.clear();
                }

            } else if (r2 != null) {
                Guest guest = new Guest(guestUsername, guestPassword, guestName);
                int check = guest.setPassword(guestPassword);

                if (check == 1) {
                    lblBadGuestPass.setText("Password Must Contain At Least 1 Uppercase letter and 1 Number.");
                    guest.setBlankPassword();
                    guest.setBlankUsername();
                    txtGuestPass.clear();
                } else if (check == 2) {
                    lblBadGuestPass.setText("Password Cannot Start With a Number.");
                    guest.setBlankPassword();
                    guest.setBlankUsername();
                    txtGuestPass.clear();
                } else {
                    guest.setPassword(guestPassword);
                    guest.setUsername(guestUsername);
                    stage.setScene(empWelcomeScene);
                    stage.setTitle("Employee Center");
                    txtGuestName.clear();
                    txtGuestPass.clear();
                    txtGuestUser.clear();
                }

            }
        }
//            if (txtGuestName.getText().equals("") || txtGuestPass.getText().equals("") || txtGuestUser.getText().equals(""))
//                lblBadPass.setText("Please Enter Valid Credentials");
    }
    
    //Creates a new employee login 
    public void createEmployee() {
        String empUsername = txtEmpUsername.getText();
        boolean bool = false;
        for (int i = 0; i < Employee.employees.size(); i++) {
            bool = empUsername.equals(Employee.employees.get(i).getUsername());
        }
        if (bool == true) {
            txtEmpUsername.clear();
            lblexistingEName.setText("Username already Exists");
        } else if (bool == false) {
            String empPassword = txtEmpPassword.getText();
            String empName = txtEmpName.getText();
            Employee emp1 = new Employee(empUsername, empPassword, empName);
            int check = emp1.setPassword(empPassword);

            if (check == 1) {
                lblBadEmpPass.setText("Password Must Contain At Least 1 Uppercase letter and 1 Number.");
                emp1.setBlankPassword();
                emp1.setBlankUsername();
                txtEmpPassword.clear();
            } else if (check == 2) {
                lblBadEmpPass.setText("Password Cannot Start With a Number.");
                emp1.setBlankPassword();
                emp1.setBlankUsername();
                txtEmpPassword.clear();
            } else {
                emp1.setPassword(empPassword);
                emp1.setUsername(empUsername);
                txtEmpUsername.clear();
                txtEmpName.clear();
                txtEmpPassword.clear();
                stage.setScene(loginScene);
            }
        }

    }
    
    // Logs employee in 
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
               //Validation for username existing      
            }
        else
            {
                stage.setScene(empWelcomeScene);
                stage.setTitle("Employee Center");
            }
    }
    
    //Logs guest in 
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
            //Handles invalid credentials 
            /*
                System.out.print("Invalid Credentials. If you would like to exit, set the username to 'X'");
                System.out.println();
                System.out.println();
            */
        }
        else
            {
                stage.setScene(guestWelcomeScene);
                stage.setTitle("Welcome New Guest");
            }
        
    }
    /*
    public void insertEmployee() {
        for (int i = 0; i < Employee.employees.size(); i++) {
            String sqlQuery = "INSERT INTO JAVAUSER." + empTbl + " VALUES (";
            sqlQuery += "\'" + Employee.employees.get(i).getEmployeeID() + "\',"; // might not need the .getText()
            sqlQuery += "\'" + Employee.employees.get(i).getEmployeeName() + "\',";
            sqlQuery += "\'" + Employee.employees.get(i).getUsername() + "\',";
            sqlQuery += "\'" + Employee.employees.get(i).getPassword() + "\');";
            sendDBCommand(sqlQuery);
        }
    }
    

    public void insertGuest() {
        for (int i = 0; i < Guest.guests.size(); i++) {
            String sqlQuery = "INSERT INTO JAVAUSER." + guesTbl + " VALUES (";
            sqlQuery += "\'" + Guest.guests.get(i).getGuestID() + "\'";
            sqlQuery += "\'" + Guest.guests.get(i).getGuestName() + "\',";
            sqlQuery += "\'" + Guest.guests.get(i).getUsername() + "\',";
            sqlQuery += "\'" + Guest.guests.get(i).getPassword() + "\');";
            sendDBCommand(sqlQuery);
        }
    }
    
	
    public void insertRoom() {
        for (int i=0; i<Room.rooms.size(); i++) {
            String sqlQuery = "INSERT INTO JAVAUSER." + roomTbl + " VALUES (";
            sqlQuery += Room.rooms.get(i).getRoomID() + ",";
            sqlQuery += "" + Room.rooms.get(i).getRoomNumber() + ",";
            sqlQuery += "" + Room.rooms.get(i).getRoomBookedQuantity() + ",";
            sqlQuery += "" + Room.rooms.get(i).getBooked() + ",";
            sqlQuery += "" + Room.rooms.get(i).bedOption + ",";
            sqlQuery += "" + Room.rooms.get(i).kitchenOption + ",";
            sqlQuery += "" + Room.rooms.get(i).coffeeOption + ",";
            sqlQuery += "" + Room.rooms.get(i).accessibleOption + ",";
            sqlQuery += "" + Room.rooms.get(i).roomCostPerNight + ",";
            sqlQuery += "" + Room.rooms.get(i).roomStatus + ");";
            sendDBCommand(sqlQuery);
        }       
    }

    
    public void insertBooking() {
        for (int i = 0; i < Booking.bookings.size(); i++) {
            String sqlQuery = "INSERT INTO JAVAUSER." + bookingTbl + " VALUES (";
            sqlQuery += Booking.bookings.get(i).getID() + ",";
            sqlQuery += Booking.bookings.get(i).bookedRoom.getRoomID() + ",";
            sqlQuery += Booking.bookings.get(i).bookingGuest.getGuestID() + ",";
            sqlQuery += Booking.bookings.get(i).bookingYear+ ",";
            sqlQuery += Booking.bookings.get(i).checkInDay + ",";
            sqlQuery += Booking.bookings.get(i).checkOutYear + ",";
            sqlQuery += Booking.bookings.get(i).checkOutDay + ");";
            sendDBCommand(sqlQuery);
        }
    }
    

    public void insertValueGuest() {
        for (int i=0; i<ValueGuest.valueGuests.size(); i++) {
            String sqlQuery = "INSERT INTO JAVAUSER." + valTbl + " VALUES (";
            sqlQuery += ValueGuest.valueGuests.get(i).getClubID() + ",";
            sqlQuery += ValueGuest.valueGuests.get(i).getNumberOfBookings() + ",";
            sqlQuery += ValueGuest.valueGuests.get(i).getAmountSpentWithHotel() + ",";
            sqlQuery += ValueGuest.valueGuests.get(i).getGuestID() + ",";
            sqlQuery += ValueGuest.valueGuests.get(i).getUsername() + ",";
            sqlQuery += ValueGuest.valueGuests.get(i).getPassword() + ");";
            sendDBCommand(sqlQuery);
        }
    }
    
    // NEEDED TO UPDATE THE ROOMSERVICE AND BOOKING CLASSES WITH CORRECT ARRAYS
    // AND THEN CALL THE CORRECT INFO TO INSERT IT INTO DATABASE
//    public void insertRoomService() {
//       String sqlQuery = "INSERT INTO JAVAUSER." + roomServTbl + " VALUES ("; 
//       sqlQuery += 
//    }
//    
//    public void showRoomService() {
//        
//    }
    
    
    public void showEmployees() {
        String sqlQuery = "SELECT * FROM JAVAUSER.EMPLOYEE";
        sendDBCommand(sqlQuery);
        String username = "";
        String password = "";
        String name = "";
        String ID = "";
        Employee emp = null;
        
        try {
            while(dbResults.next()) {
                ID += dbResults.getString(1);
                name += dbResults.getString(2);
                username += dbResults.getString(3);
                password += dbResults.getString(4);
                emp = new Employee(username,password,name);
            }    
        }
        catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    
    public void showGuests() {
        String sqlQuery = "SELECT * FROM JAVAUSER.GUEST";
        sendDBCommand(sqlQuery);
        String username = "";
        String password = "";
        String name = "";
        String ID = "";
        Guest gues = null;
        
        try {
            while (dbResults.next()) {
                ID += dbResults.getString(1);
                name += dbResults.getString(2);
                username += dbResults.getString(3);
                password += dbResults.getString(4);
                gues = new Guest(username,password,name);
            }
        }
        catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    
    public void showRooms() {
       String sqlQuery = "SELECT * FROM JAVAUSER.ROOM";
       sendDBCommand(sqlQuery);
       String roomID = "";
       int bedOption = 0;
       int kitOption = 0;
       int coffeeOption = 0;
       int accessOption = 0;
       int roomNumber = 0;
       String roomBooked = "";
       String cost = "";
       Room room = null;
       
       try {
           while (dbResults.next()) {
               roomID += dbResults.getString(1);
               roomNumber += Integer.valueOf(dbResults.getString(2));
               roomBooked += dbResults.getString(4);
               bedOption += Integer.valueOf(dbResults.getString(5));
               kitOption += Integer.valueOf(dbResults.getString(6));
               coffeeOption += Integer.valueOf(dbResults.getString(7));
               accessOption += Integer.valueOf(dbResults.getString(8));
               cost += dbResults.getString(9);
               room = new Room(bedOption,kitOption,coffeeOption,accessOption,roomNumber); 
           }
       }
       catch (SQLException e) {
           System.out.println(e.toString());
       }
    }
    
    // NEEDED TO FINISH WRITING THE SHOW BOOKINGS METHOD AFTER IT WAS UPDATED
    public void showBookings() {
        
    }
    
    public void stop() {
        insertEmployee();
        insertGuest();
        insertRoom();
        insertBooking();
        insertValueGuest();
        //insertRoomService();
    }
    
    
    public void sendDBCommand(String sqlQuery) {
        String jdbcConnectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "javauser";
        String userPASS = "javapass";
        OracleDataSource ds;

        System.out.println(sqlQuery);

        try {
            ds = new OracleDataSource();
            ds.setURL(jdbcConnectionURL);
            dbConn = ds.getConnection(userID, userPASS);
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            dbResults = commStmt.executeQuery(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
