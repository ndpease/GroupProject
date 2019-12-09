/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupProjectAMEdits;

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
public class ApplicationUIUpdated extends Application {

    private Stage stage;
    Employee admin = new Employee("admin", "pass", "Hotel Administrator");

    TextField txtLogUsername = new TextField();
    TextField txtLogPassword = new TextField();
    Label lblLogUsername = new Label("Username: ");
    Label lblLogPassword = new Label("Password: ");
    Button btnNewEmployee = new Button("New Employee");
    Button btnLogin = new Button("Login");
    Label lblNotFound = new Label();

    TextField txtEmpUsername = new TextField();
    TextField txtEmpPassword = new TextField();
    Label lblEmpUsername = new Label("Username: ");
    Label lblEmpPassword = new Label("Password: ");
    Label lblEmpName = new Label("Employee Name: ");
    Label lblexistingEName = new Label();
    TextField txtEmpName = new TextField();
    Button btnCreateEmp = new Button("Create Employee");
    Label lblBadEmpPass = new Label();

    Button btnCreateGuest = new Button("Guest Creator");
    Button btnCreateRooms = new Button("Create Room");
    Button btnEditGuest = new Button("Edit Guest");
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
    Label lblBadGuestPass = new Label();

    Label lblWelcomeGuest = new Label("Welcome");

// ROOM Tab
    public Button btnCreateRoom = new Button("Create Room");
    public Button btnSaveChanges = new Button("Save Changes");
    public TextField tfERRoomNo = new TextField();
    public TextField tfERRoomCost = new TextField();
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

//EDIT GUEST pane
    public Button btnEditName = new Button("Edit Guest Name");
    public Button btnEditPassword = new Button("Edit Guest Password");
    public Button btnReturnToMenu = new Button("Return to Employee Menu");

//EDIT GUEST USERNAME pane
    public Label lblEditGuestUsername = new Label("Enter the Username of the Guest you would like to edit: ");
    public TextField txtEditGuestUsername = new TextField();
    public Button btnEditGuestUsername = new Button("Submit Username: ");
    public Label lblEditGuestUsernameError = new Label();
    public Button btnReturnToMenu1 = new Button("Return to Employee Menu");

//EDIT GUEST NAME tab
    public Label lblEditGuestName = new Label("Enter New Guest Name: ");
    public TextField txtEditGuestName = new TextField();
    public Button btnEditGuestName = new Button("Submit Name Change");
    public Label lblNameChangeSuccessful = new Label();

//EDIT GUEST PASS tab
    public Label lblOldPass = new Label("Enter Old Password:");
    public TextField txtOldPass = new TextField();
    public Label lblNewPass = new Label("Enter New Password:");
    public TextField txtNewPass = new TextField();
    public Label lblConfirmNewPass = new Label("Confirm New Password:");
    public TextField txtConfirmNewPass = new TextField();
    public Button btnSubmitNewPass = new Button("Submit Password Change");
    public Label lblPassChange = new Label();

//GridPanes
    public GridPane logonPane = new GridPane();
    public GridPane newEmployeePane = new GridPane();
    public GridPane empPane = new GridPane();
    public GridPane createGuestPane = new GridPane();
    public GridPane guestPane = new GridPane();
    public GridPane empRoomPane = new GridPane();
    public GridPane empBookingPane = new GridPane();
    public GridPane roomABookingPane = new GridPane();
    public GridPane handleGuestPane = new GridPane();
    public GridPane editGuestPane = new GridPane();
    public GridPane editGuestUsernamePane = new GridPane();
    public GridPane editGuestNamePane = new GridPane();
    public GridPane editGuestPassPane = new GridPane();

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
    public TabPane roomBookingTab = new TabPane();
    public Tab tabEmpBooking = new Tab("Bookings");
    public Tab tabEmpRoom = new Tab("Rooms");

    public TabPane editGuestTabPane = new TabPane();
    public Tab editGuestNameTab = new Tab("Click To Edit Guest Name");
    public Tab editGuestPassTab = new Tab("Click To Edit Guest Password");

//Scenes
    public Scene loginScene = new Scene(logonPane, 500, 400);
    public Scene newEmpScene = new Scene(newEmployeePane, 500, 400);
    public Scene empWelcomeScene = new Scene(empPane, 500, 400);
    public Scene newGuestScene = new Scene(createGuestPane, 500, 400);
    public Scene guestWelcomeScene = new Scene(guestPane, 500, 400);
    public Scene roombookingScene = new Scene(roomABookingPane, 500, 400);
    public Scene handleGuestScene = new Scene(handleGuestPane, 500, 400);
    public Scene editGuestScene = new Scene(editGuestPane, 500, 400);
    public Scene editGuestUsernameScene = new Scene(editGuestUsernamePane, 500, 400);

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
        logonPane.add(lblNotFound, 0, 4);

//Create New Employee     
        newEmployeePane.setAlignment(Pos.CENTER);
        newEmployeePane.add(lblEmpUsername, 0, 0);
        newEmployeePane.add(lblEmpPassword, 0, 1);
        newEmployeePane.add(lblEmpName, 0, 2);
        newEmployeePane.add(txtEmpUsername, 1, 0);
        newEmployeePane.add(txtEmpPassword, 1, 1);
        newEmployeePane.add(txtEmpName, 1, 2);
        newEmployeePane.add(btnCreateEmp, 1, 3);
        newEmployeePane.add(lblexistingEName, 3, 3);
        newEmployeePane.add(lblBadEmpPass, 1, 4);

//Employee Welcome Pane  
        empPane.setAlignment(Pos.CENTER);
        empPane.add(btnCreateGuest, 0, 1);
        empPane.add(btnEditGuest, 0, 2);
        empPane.add(btnCreateRooms, 0, 3);
        empPane.add(btnLogout, 0, 4);

        roomABookingPane.add(roomBookingTab, 0, 0);
        tabEmpRoom.setContent(empRoomPane);
        tabEmpBooking.setContent(empBookingPane);
        roomBookingTab.getTabs().add(tabEmpRoom);
        roomBookingTab.getTabs().add(tabEmpBooking);

//Guest Creation
        createGuestPane.setAlignment(Pos.CENTER);
        createGuestPane.add(lblGuestUser, 0, 0);
        createGuestPane.add(lblGuestPass, 0, 1);
        createGuestPane.add(lblGuestName, 0, 2);
        createGuestPane.add(lblValueID, 0, 3);
        createGuestPane.add(txtGuestUser, 1, 0);
        createGuestPane.add(txtGuestPass, 1, 1);
        createGuestPane.add(txtGuestName, 1, 2);
        createGuestPane.add(txtValueID, 1, 3);
        createGuestPane.add(r1, 3, 0);
        createGuestPane.add(r2, 3, 1);
        createGuestPane.add(btnNewGuest, 1, 4);
        createGuestPane.add(lblGuestExist, 3, 3);
        createGuestPane.add(lblBadGuestPass, 1, 5);
        lblValueID.setVisible(false);
        txtValueID.setVisible(false);

        //Guest Welcome Pane
        guestPane.add(lblWelcomeGuest, 0, 0);

        // Employee Room Pane
        empRoomPane.add(tfERRoomNo, 1, 0);
        empRoomPane.add(lblBed, 0, 2);
        empRoomPane.add(cbRoomBedOpt, 1, 2);
        empRoomPane.add(lblKitchen, 0, 3);
        empRoomPane.add(cbRoomKitchOpt, 1, 3);
        empRoomPane.add(lblCoffee, 0, 4);
        empRoomPane.add(cbRoomCoffeeOpt, 1, 4);
        empRoomPane.add(lblAccessibility, 0, 5);
        empRoomPane.add(cbRoomAccessOpt, 1, 5);
        empRoomPane.add(lblPrice, 0, 6);
        empRoomPane.add(tfERRoomCost, 1, 6);
        empRoomPane.add(lblStatus, 0, 7);
        empRoomPane.add(cbRoomActiveOpt, 1, 7);
        empRoomPane.add(btnCreateRoom, 0, 8);
        empRoomPane.add(btnSaveChanges, 1, 8);
        empRoomPane.add(lblAvailable, 3, 0);
        empRoomPane.add(lblERlistlabel, 4, 0);
        empRoomPane.add(lvERList, 4, 1, 1, 8);

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

        //edit guest username pane
        editGuestUsernamePane.setAlignment(Pos.CENTER);
        editGuestUsernamePane.add(lblEditGuestUsername, 0, 0);
        editGuestUsernamePane.add(txtEditGuestUsername, 0, 1);
        editGuestUsernamePane.add(btnEditGuestUsername, 0, 2);
        editGuestUsernamePane.add(lblEditGuestUsernameError, 0, 3);
        editGuestUsernamePane.add(btnReturnToMenu1, 0, 4);

        //edit guest pane
        editGuestPane.setAlignment(Pos.TOP_CENTER);
        editGuestPane.add(editGuestTabPane, 2, 0);
        editGuestTabPane.getTabs().add(editGuestNameTab);
        editGuestTabPane.getTabs().add(editGuestPassTab);
        editGuestPane.add(btnReturnToMenu, 2, 7);

        //edit guest name tab
        editGuestNameTab.setContent(editGuestNamePane);
        editGuestNamePane.add(lblEditGuestName, 4, 1);
        editGuestNamePane.add(txtEditGuestName, 4, 2);
        editGuestNamePane.add(btnEditGuestName, 4, 3);
        editGuestNamePane.add(lblNameChangeSuccessful, 4, 4);

        //edit guest pass tab
        editGuestPassTab.setContent(editGuestPassPane);
        editGuestPassPane.add(lblOldPass, 0, 1);
        editGuestPassPane.add(txtOldPass, 0, 2);
        editGuestPassPane.add(lblNewPass, 0, 4);
        editGuestPassPane.add(txtNewPass, 0, 5);
        editGuestPassPane.add(lblConfirmNewPass, 0, 7);
        editGuestPassPane.add(txtConfirmNewPass, 0, 8);
        editGuestPassPane.add(btnSubmitNewPass, 0, 9);
        editGuestPassPane.add(lblPassChange, 0, 10);

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

        //Sets Pane to Create a new Guest       
        btnCreateRooms.setOnAction(e -> {
            primaryStage.setScene(roombookingScene);

        });

        btnCreateGuest.setOnAction(e -> {
            primaryStage.setScene(newGuestScene);

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

        //Edit guest buttons
        btnEditGuest.setOnAction(e -> {
            stage.setScene(editGuestUsernameScene);
            editGuestUsername();
        });

        btnEditGuestUsername.setOnAction(e -> {
            if (editGuestUsername() != -2) {
                editGuestName(editGuestUsername());
                lblEditGuestUsernameError.setText("");
            } else {
                lblEditGuestUsernameError.setText("Username is not in the system.");
                txtEditGuestUsername.clear();
            }
        });

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

            if (txtEditGuestName.getText().equals("")) {
                lblNameChangeSuccessful.setText("Please enter a valid name");
            } else {
                lblNameChangeSuccessful.setText("Name Change Successful!");
            }

            txtEditGuestName.clear();

        });

        btnSubmitNewPass.setOnAction(e -> {
            editGuestPass(editGuestUsername());
        });
    }

    public void loginHandler() {
        if (combo_box.getValue().equals("Employee")) {
            employeeLogin();
        } else if (combo_box.getValue().equals("Guest")) {
            guestLogin();
        } else {

        }
    }

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

    public void employeeLogin() {
        String username;
        String password;
        boolean bool = false;
        username = txtLogUsername.getText();
        password = txtLogPassword.getText();
        for (int i = 0; i < Employee.employees.size(); i++) {
            if ((Employee.employees.get(i) != null) && (Employee.employees.get(i).getUsername().equals(username))) {
                bool = Employee.employees.get(i).checkCredentials(username, password);
            }
        }
        if (bool == false) {
            lblNotFound.setText("User not found. Try again");
            txtLogUsername.clear();
            txtLogPassword.clear();
        } else {
            stage.setScene(empWelcomeScene);
            stage.setTitle("Employee Center");
        }
    }

    public void guestLogin() {
        String username;
        String password;
        boolean bool = false;
        username = txtLogUsername.getText();
        password = txtLogPassword.getText();
        for (int i = 0; i < Guest.guests.size(); i++) {
            if ((Guest.guests.get(i) != null) && (Guest.guests.get(i).getUsername().equals(username))) {
                bool = Guest.guests.get(i).checkCredentials(username, password);
            }
        }
        if (bool == false) {
            System.out.print("Invalid Credentials. If you would like to exit, set the username to 'X'");
            System.out.println();
            System.out.println();
        } else {
            stage.setScene(guestWelcomeScene);
            stage.setTitle("Welcome New Guest");
        }

    }

    public int editGuestUsername() {

        int guestNum = -1;
        for (int i = 0; i < Guest.guests.size(); i++) {
            if (txtEditGuestUsername.getText().equalsIgnoreCase(Guest.guests.get(i).getUsername())) {
                guestNum = i;
                return guestNum;
            } else {
                guestNum = -2;
            }
        }
        return guestNum;
    }

    public void editGuestName(int guestNum) {
        stage.setScene(editGuestScene);

        if (!txtEditGuestName.getText().equals("")) {
            String newName = txtEditGuestName.getText();
            Guest.guests.get(guestNum).setGuestName(newName);
        }
    }

    public void editGuestPass(int guestNum) {
        stage.setScene(editGuestScene);

        String oldP = txtOldPass.getText();
        String newP = txtNewPass.getText();
        String newP1 = txtConfirmNewPass.getText();

        if (newP.equals(newP1) && Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP) == 0) {
            Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP);
            lblPassChange.setText("");
            lblPassChange.setText("Password Change Successful!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        } else if (!Guest.guests.get(guestNum).getPassword().equals(oldP)) {
            lblPassChange.setText("");
            lblPassChange.setText("Your Old Password does not match. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        } else if (newP.equals(newP1) && Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP) == 1) {
            lblPassChange.setText("");
            lblPassChange.setText("Password Must Contain At Least 1 Uppercase letter and 1 Number. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        } else if (newP.equals(newP1) && Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP) == 2) {
            lblPassChange.setText("");
            lblPassChange.setText("Password Cannot Start With a Number. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        } else if (newP.equals(newP1) && Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), newP) == 3) {
            lblPassChange.setText("");
            lblPassChange.setText("New Password Cannot Be The Same As The Old Password. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        } else if (!newP.equals(newP1)) {
            lblPassChange.setText("");
            lblPassChange.setText("Your Confirmed Password Does Not Match. Please Try Again!");
            txtOldPass.clear();
            txtNewPass.clear();
            txtConfirmNewPass.clear();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
