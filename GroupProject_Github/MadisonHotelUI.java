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
        
        logonPane.setAlignment(Pos.CENTER);
        logonPane.add(btnEmpLogon, 0,0);
        logonPane.add(btnGuestLogon, 0,1);
        
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
        
        empHomePane.add(btnCreateGuest,1,1);
        empHomePane.add(btnChkoutGuest,1,2);
        empHomePane.add(btnRunBkgRpt,1,3);
        empHomePane.add(lvEmpHomeActBook,2,1);
        empHomePane.add(lblCurActBook,2,0);
        
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
        empBookingPane.add(lvEmpBookingFull, 3, 0);
        
        
        
        /// Guest Portal
        guestPrimaryPane.setAlignment(Pos.CENTER);
     
        // Scene Creation 
        Scene empScene = new Scene(empPrimaryPane, 600, 700);
        Scene logonScene = new Scene(logonPane, 300, 200); 
        Scene guestScene = new Scene(guestPrimaryPane, 600, 700);

        tabPaneEmp.setMinWidth(empScene.getWidth());
        
        
        
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
    
}
