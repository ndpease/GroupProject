/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupProject_v2_01;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;


public class MadisonHotelUI extends Application {
    
            // Default Room objects
        Room room1 = new Room(1,1,1,1,1);
        Room room2 = new Room(1,1,1,1,2);
        
        // Test Employee and Guest Accounts
        Employee admin = new Employee("admin", "pass", "Hotel Administrator");
        Guest testguest = new Guest("guest","pass", "Hotel Guest");
        
        
/// Elements for Login Menu //// 
        // Buttons
        public Button btnEmpLogon = new Button("Login as Employee");
        public Button btnGuestLogon = new Button("Login as Guest");
        
        // GridPane
        public GridPane logonPane = new GridPane(); 
       
/// Elements for Employee Menu ////
        
        // GridPane
        public GridPane empPrimaryPane = new GridPane();
        public GridPane empHomePane = new GridPane();
        public GridPane empBookingPane = new GridPane();
        public GridPane empRoomPane = new GridPane();
        public GridPane empAccountPane = new GridPane();
        // TabPane 
        public TabPane tabPaneEmp = new TabPane();
        public Tab tabEmpHome = new Tab("Home");
        public Tab tabEmpBooking = new Tab("Bookings");
        public Tab tabEmpRoom = new Tab("Rooms");
        public Tab tabEmpAccount = new Tab("Accounts");
        public Tab tabEmpLogout = new Tab("Log Out");

        // HOME Tab
        public Button btnCreateGuest = new Button("Create New Guest");
        public Button btnChkoutGuest = new Button("Checkout Guest");
        public Button btnRunBkgRpt = new Button("Run Booking Report");
        public Label lblCurActBook = new Label("Current Guest Bookings:");
        public ListView lvEmpHomeActBook = new ListView();
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
        
        // ROOM Tab
        public Button btnCreateRoom = new Button("Create Room");
        public Button btnSaveChanges = new Button("Save Changes");
        public TextField tfERRoomNo = new TextField();
        public TextField tfERRoomCost = new TextField();
        public ComboBox cbRoomBedOpt = new ComboBox();
        public ComboBox cbRoomKitchOpt = new ComboBox();
        public ComboBox cbRoomCoffeeOpt = new ComboBox();
        public ComboBox cbRoomAccessOpt = new ComboBox();
        public ComboBox cbRoomActiveOpt = new ComboBox();
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
        
        // ACCOUNT Tab
        public Button btnChangeYourPass = new Button("Change Your Password");
        public Button btnNewGuest = new Button("New Guest");
        public Button btnNewEmp = new Button("New Employee");
        public Button btnLookUpAcct = new Button("Lookup Account");
        public Label lblUsername = new Label("Username");
        public Label lblAcctType = new Label("Account Type");
        public Label lblEditAccount = new Label("Edit Account");
        public ComboBox cbAcctType = new ComboBox();
        public TextField tfUsername = new TextField(); 
        
        
        
/// Elements for Guest Menu ////
        
        // GridPane
        public GridPane guestPrimaryPane = new GridPane();
        public GridPane guestHomePane = new GridPane();
        public GridPane guestBookingPane = new GridPane();
        public GridPane guestRoomPane = new GridPane();
        public GridPane guestAccountPane = new GridPane();
        // TabPane 
        public TabPane tabPaneGuest = new TabPane();
        public Tab tabGuest = new Tab("Home");
        public Tab tabGuestBookings = new Tab("Bookings");
        public Tab tabGuestRoomServ = new Tab("Room Service");
        public Tab tabGuestAccount = new Tab("Account");
        public Tab tabGuestLogout = new Tab("Log Out");

        // HOME Tab
        
        
    @Override
    public void start(Stage primaryStage) {
        // Log On Screen
        logonPane.setAlignment(Pos.CENTER);
        logonPane.add(btnEmpLogon, 0,0);
        logonPane.add(btnGuestLogon, 0,1);
        
        // Employee Pane
        empPrimaryPane.setAlignment(Pos.TOP_LEFT);
        tabPaneEmp.getTabs().add(tabEmpHome);
        tabPaneEmp.getTabs().add(tabEmpBooking);
        tabPaneEmp.getTabs().add(tabEmpRoom);
        tabPaneEmp.getTabs().add(tabEmpAccount);
        tabPaneEmp.getTabs().add(tabEmpLogout);
        
        empPrimaryPane.add(tabPaneEmp, 0,0);
        
        tabEmpHome.setContent(empHomePane);
        tabEmpBooking.setContent(empBookingPane);
        tabEmpRoom.setContent(empRoomPane);
        tabEmpAccount.setContent(empAccountPane);
        // Employee Home Pane
        empHomePane.add(btnCreateGuest,1,1);
        empHomePane.add(btnChkoutGuest,1,2);
        empHomePane.add(btnRunBkgRpt,1,3);
        empHomePane.add(lvEmpHomeActBook,2,1, 1, 5);
        empHomePane.add(lblCurActBook,2,0);
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
        // Employee Room Pane
        empRoomPane.add(lblRoom, 0,0);
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
        //Employee Account Tab
        empAccountPane.add(btnChangeYourPass,0,0);
        empAccountPane.add(btnNewGuest,0,1);
        empAccountPane.add(btnNewEmp,0,2);
        empAccountPane.add(lblEditAccount,1,0);
        empAccountPane.add(lblUsername,1,1);
        empAccountPane.add(lblAcctType,1,2);
        empAccountPane.add(btnLookUpAcct,1,3);
        empAccountPane.add(tfUsername,2,1);
        empAccountPane.add(cbAcctType,2,2);
        
        
        
        
        
        /// Guest Portal
        guestPrimaryPane.setAlignment(Pos.CENTER);
     
        // Scene Creation 
        Scene empScene = new Scene(empPrimaryPane, 600, 700);
        Scene logonScene = new Scene(logonPane, 300, 200); 
        Scene guestScene = new Scene(guestPrimaryPane, 600, 700);

        tabPaneEmp.setMinWidth(empScene.getWidth());
        
        
        // Logout Tabs
        tabEmpLogout.setOnSelectionChanged (e -> 
        primaryStage.setScene(logonScene));
        tabGuestLogout.setOnSelectionChanged (e -> 
        primaryStage.setScene(logonScene));
        
        
        
        primaryStage.setTitle("Madison Hotel");
        primaryStage.setScene(logonScene);
        primaryStage.show();
        
        // Logon Scene Actions
        btnEmpLogon.setOnAction(e -> {primaryStage.setScene(empScene);});
        btnGuestLogon.setOnAction(e -> {primaryStage.setScene(guestScene);});
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void sendDBCommand(String sqlQuery) {
        String URL - "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "javauser";
        String userPASS = "javapass";
        OracleDataSource ds;
        
        // System.out.println(sqlQuery); --> Clear box tester
        
        try {
            ds = new OracleDataSource();
            ds.setURL(URL);
            dbConn = ds.getConnection(userID, userPASS);
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            dbResults = commStmt.executeQuery(sqlQuery);
        }
        catch (SQLException e) {
            System.out.println(e.toString());
        }   
    }
    
    
} // end main
