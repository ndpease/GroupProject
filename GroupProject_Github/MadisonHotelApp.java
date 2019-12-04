/*
Author: Nick Pease, Aaron Morgan, Connor Hotaling, Stephen Pannier
Date: 11/25/19
Title: Group Project Part I: Madison Hotel, Application Class
Purpose: Provide an interface for users to access the Madison Hotel Application
*/

package GroupProjectAMEdits;

import java.util.*;
import GroupProjectAMEdits.Booking;
import GroupProjectAMEdits.Employee;
import GroupProjectAMEdits.Guest;
import GroupProjectAMEdits.Room;
import GroupProjectAMEdits.ValueGuest;

public class MadisonHotelApp {
    
    public static void main(String[] args) {
        // Default Room objects
        Room room1 = new Room(1,1,1,1,1);
        Room room2 = new Room(1,1,1,1,2);
        
        // Test Employee and Guest Accounts
        Employee admin = new Employee("admin", "pass", "Hotel Administrator");
        Guest testguest = new Guest("guest","pass", "Hotel Guest");
        
        
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Madison Hotel!");
        int choice = 0;
        do {
            displayMenu();
            System.out.print("Please Enter an Option: ");
            choice = input.nextInt();
            handleMenuChoice(choice);
        } while (choice != 4);
        
    } // Main
    
    
    
    /////////////// HOTEL MENU ///////////////
    public static void displayMenu() {
        System.out.println("====================");
        System.out.println("Please Select an Option: ");
        System.out.println("1: Create an Employee Account");
        System.out.println("2: Log in as an Employee");
        System.out.println("3: Log in as a Guest");
        System.out.println("4: Exit System");
        System.out.println("====================");
        System.out.println();
    }
    
    public static int handleMenuChoice(int choice) {
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1: createEmployee(); break;
            case 2: loginEmployee(); break;
            case 3: loginGuest(); break;
        }
        return choice;
    }
    
    ///// MENU CHOICE 1 /////
    public static void createEmployee() {
        Scanner input = new Scanner(System.in);
        String username = "";
        
        do {
            System.out.print("Enter Username: ");
            username = input.nextLine();
            boolean bool = false;
            for (int i=0; i<Employee.employees.size(); i++) {
                bool = username.equals(Employee.employees.get(i).getUsername());
            }
            if (bool == true) {
                System.out.println("Username already exists. ");
            } 
            else if (bool == false) {
               break; 
            }
        } while (true);
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        Employee emp1 = new Employee(username, password, name);
        System.out.println();    
    }
    
    ///// MENU CHOICE 2 /////
    public static void loginEmployee() {
        Scanner input = new Scanner(System.in);
        boolean bool = false;
        while (true) {
            System.out.print("Enter Username: ");
            String username = input.nextLine();
            if (username.equals("X"))
            {
                return;
            }
            System.out.print("Enter Password: ");
            String password = input.nextLine();
            for (int i=0; i<Employee.employees.size(); i++) {
                if ((Employee.employees.get(i) != null) && (Employee.employees.get(i).getUsername().equals(username))) {
                    bool = Employee.employees.get(i).checkCredentials(username, password);
                }     
            }
            if (bool == false) {
                System.out.print("Invalid Credentials. If you are not an employee, set the username to 'X'");
                System.out.println();
                System.out.println();
            }
            else {
                break;
            }
        }
        int answer = 0;
        do {
            displayEmployeeMenu();
            System.out.print("Please Select an Option: ");
            answer = input.nextInt();
            handleEmployeeMenu(answer);
        } while (answer != 8);
    }
    
    ///// MENU CHOICE 3 /////
    public static void loginGuest() {
        Scanner input = new Scanner(System.in);
        String username = "";
        String password = "";
        boolean bool = false;
        while (true) {
            System.out.print("Enter Username: ");
            username = input.nextLine();
            if (username.equals("X"))
            {
                return;
            }
            System.out.print("Enter Password: ");
            password = input.nextLine();
            for (int i=0; i<Guest.guests.size(); i++) {
                if ((Guest.guests.get(i) != null) && (Guest.guests.get(i).getUsername().equals(username))) {
                    bool = Guest.guests.get(i).checkCredentials(username, password);
                }
            }
            if (bool == false) {
                System.out.print("Invalid Credentials. If you would like to exit, set the username to 'X'");
                System.out.println();
                System.out.println();
            }
            else {
                break;
            }
        }
        int answer = 0;
        do {
            displayGuestMenu();
            System.out.print("Please Select an Option: ");
            answer = input.nextInt();
            handleGuestMenu(answer, username);
        } while (answer != 4);
    }
    
    
    
    /////////////// GUEST MENU ///////////////
    public static void displayGuestMenu() {
        System.out.println();
        System.out.println("====================");
        System.out.println("Please Select an Option: ");
        System.out.println("1: Book a Room");
        System.out.println("2: View a Personal Booking Report");
        System.out.println("3: Edit Personal Information");
        System.out.println("====================");
        System.out.println();
    }
    
    ///// FIND GUEST /////
    public static Guest findGuest(String username) {
        Guest guest1 = Guest.guests.get(0);
        for (int i=0; i<Guest.guests.size(); i++) {
            if (Guest.guests.get(i).getUsername().equals(username)) {
                guest1 = Guest.guests.get(i);
            }
        }
        return guest1;
    }
    
    public static void handleGuestMenu(int choice, String username) {
        Scanner input = new Scanner(System.in);
        Guest guest1 = findGuest(username);
        switch (choice) {
            case 1: bookRoom(guest1); break;
            case 2: personalBookingReport(username); break;
            case 3: handleChangeGuestInfo(guest1); break;
        }
    }
    
    ///// GUEST MENU CHOICE 1 /////
    public static void bookRoom(Guest guest1) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please select the following room you would like to book!");
        for (int i=0; i<Room.rooms.size(); i++) {
            if (Room.rooms.get(i).roomStatus == true && Room.rooms.get(i).getBooked() == false) {
                System.out.println(Room.rooms.get(i).roomDescription());
            }
        }
        System.out.print("Please enter the number of the room you would like to book: ");
        int choice = input.nextInt();
        boolean roomFound = false;
        for (int i=0; i<Room.rooms.size(); i++) {
            if (Room.rooms.get(i).getRoomNumber() == choice) {
                if (!Room.rooms.get(i).bookRoom())
                {
                    System.out.println("Sorry, this room is already booked");
                }
                else
                {
                    System.out.println("You have booked room: " + choice);
                    Booking booked = new Booking(guest1,Room.rooms.get(i),2019,1,2);
                    roomFound = true;
                    ValueGuest.valueGuests.get(i).bookingCount();
                    break;
                }
            }
        }
        if (!roomFound)
        {
            System.out.println("Sorry, that room is currently not available.");
        }
    }
    
    ///// GUEST MENU CHOICE 2 /////
    public static void personalBookingReport(String username) {
        int count = 0;
        for (int i=0; i<Booking.bookings.size(); i++) {
            if (Booking.bookings.get(i).bookingGuest.getUsername().equalsIgnoreCase(username)) {
                System.out.print(Booking.bookings.get(i).bookedRoom.roomDescription() + "\n");
                count++;
            } else {
            System.out.println("Sorry, no booking history is available.");
        }
    }
    }
    
    ///// GUEST MENU CHOICE 3 /////
    public static void handleChangeGuestInfo(Guest guest1) {
        Scanner input = new Scanner(System.in);
        while (true) {
            displayChangeGuestInfoMenu();
            System.out.print("Please Select an Option: ");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Enter New Guest Name: ");
                String name = input.nextLine();
                guest1.setGuestName(name);
            }
            else if (choice == 2) {
                break;
            }
            else {
                System.out.println("Invalid Choice. Please Try Again!");
            }
        }
    }
    
    
    
    ///// GUEST INFO MENU /////
    public static void displayChangeGuestInfoMenu() {
        System.out.println();
        System.out.println("====================");
        System.out.println("Please Select an Option to Edit: ");
        System.out.println("1: Update Guest Name");
        System.out.println("2: Return to Guest Menu");
        System.out.println("====================");
        System.out.println();
    }
    
    
    
    /////////////// EMPLOYEE METHODS ///////////////
    public static void displayEmployeeMenu() {
        System.out.println();
        System.out.println("==============================");
        System.out.println("Please Select an Option: ");
        System.out.println("1: Run an Booking Report");
        System.out.println("2: Check-out a Guest");
        System.out.println("3: Create a Guest Account");
        System.out.println("4: Edit Guest Information");
        System.out.println("5: Create an Employee Account");
        System.out.println("6: Edit Employee Information");
        System.out.println("7: Create, Edit, or Change Room Status");
        System.out.println("8: Log Out");
        System.out.println("==============================");
        System.out.println();
    }
    
    public static void handleEmployeeMenu(int choice) {
        switch (choice) {
            case 1: handleBookingReport(); break;
            case 2: handleGuestCheckout(); break;
            case 3: createGuestAccount(); break;
            case 4: editGuestInfo(); break;
            case 5: createEmployee(); break;
            case 6: editEmployee(); break;
            case 7: handleRoomOptions(); break;
        }
    }
    
    ///// EMPLOYEE MENU CHOICE 1 /////
    public static void handleBookingReport() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("====================");
        System.out.println("Please Select an Option: ");
        System.out.println("1: Single Room");
        System.out.println("2: All Rooms");
        System.out.println("====================");
        System.out.println();
        System.out.print("Please Enter Choice Number: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1: 
                System.out.print("Enter Room Number: ");
                int room = input.nextInt();
                for (int i=0; i<Room.rooms.size(); i++) {
                    if (Room.rooms.get(i).roomNumber == room) {
                        System.out.print(Room.rooms.get(i).roomDescription() + "\nRevenue Generated: $"
                                + Room.rooms.get(i).getRoomRevenue() + "\n"); 
                    }
                    System.out.println();
                }
                break;
            case 2: 
                for (int i=0; i<Room.rooms.size(); i++) {
                    System.out.print(Room.rooms.get(i).roomDescription() + "\nRevenue Genterated: $"
                            + Room.rooms.get(i).getRoomRevenue() + "\n");
                    System.out.println();
                } 
                break;
        }
    }
    
    ///// EMPLOYEE MENU CHOICE 2 /////
    public static void handleGuestCheckout() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter the Room Number: ");
        int roomNum = input.nextInt();
        Room checkoutRoom = null;
        for (int i=0; i<Room.rooms.size(); i++) {
            if (Room.rooms.get(i).getRoomNumber() == roomNum) {
                checkoutRoom = Room.rooms.get(i);
            }
        }
        if (checkoutRoom == null) {
            System.out.println();
            System.out.println("The Room Does Not Exist.");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("You Have Sucessfully Checked Out Room: " + roomNum);
            System.out.println();
        }
    }
    
    ///// EMPLOYEE MENU CHOICE 3 /////
    public static void createGuestAccount() {
        Scanner input = new Scanner(System.in);
        String username = "";
        boolean bool = false;
        int counter = 0;
        Guest guest;
        ValueGuest vGuest;
        System.out.print("Would the Guest like to join the Value Guest Savings Club? (Yes or No) ");
        String valueGuest = input.nextLine();
        while (true) {
            System.out.print("Enter Guest Username: ");
            username = input.nextLine();
            for (int i=0; i<Guest.guests.size(); i++) {
                bool = username.equals(Guest.guests.get(i).getUsername());
                if (bool == true) {
                    System.out.println("Sorry Username Already Exists. Please Try Again!");
                    break;
                }
            }
            if (bool == false) {
                break;
            }
        }
        System.out.print("Enter Guest Password: ");
        String password = input.nextLine();
        System.out.print("Enter Guest Name: ");
        String name = input.nextLine();
        System.out.print("Enter Savings Number: ");
        String saveNum = input.nextLine();
        if (valueGuest.startsWith("Y")) {
            vGuest = new ValueGuest(username,password,name, saveNum);
        }
        else {
            guest = new Guest(username,password,name);
        }
    }
    
    ///// EMPLOYEE MENU CHOICE 4 /////
    public static void editGuestInfo() {
        Scanner inputA = new Scanner(System.in);
        Scanner inputB = new Scanner(System.in);
        boolean bool = true;
        System.out.print("Enter the Username of the Guest you would like to edit: ");
        String username = inputA.nextLine();
        int guestNum = -1;
        for (int i=0; i<Guest.guests.size(); i++) {
            if (username.equalsIgnoreCase(Guest.guests.get(i).getUsername())) {
                guestNum = i;
            }
        }
        if (guestNum != -1) {
            System.out.println("Please Choose Information to Edit: ");
            System.out.println();
            System.out.println("====================");
            System.out.println("1: Update Guest Name");
            System.out.println("2: Update Guest Password");
            System.out.println("3: Return to Employee Menu");
            System.out.println("====================");
            System.out.println("Please Enter Choice Number: ");
            int choice = inputA.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter New Guest Name: ");
                    String name = inputB.nextLine();
                    Guest.guests.get(guestNum).setGuestName(name);
                    System.out.print("Name Change Successful! \n\n");
                    break;
                case 2:
                    do {
                        System.out.print("Enter New Guest Password: ");
                        String password = inputB.nextLine();
                        System.out.println("Plese Confirm New Password: ");
                        String password2 = inputB.nextLine();
                        if (password.equals(password2)) {
                            Guest.guests.get(guestNum).setPassword(Guest.guests.get(guestNum).getPassword(), password);
                            bool = true;
                            System.out.println("Password Change Successful! \n");
                        }
                        else {
                            bool = false;
                            System.out.println("Password Not Entered Properly. Please Try Again!");
                        }
                    } while (bool == false);
            }
        }
        else {
            System.out.println("Sorry, guest does not exist.");
        }
    }
    
    ///// EMPLOYEE MENU CHOICE 6 /////
    public static void editEmployee() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username of Employee that you would like to edit: ");
        String username = input.nextLine();
        int employeeNum = -1;
        do {
            for (int i = 0; i < Employee.employees.size(); i++) {
                if (username.equalsIgnoreCase(Employee.employees.get(i).getUsername())) {
                    employeeNum = i;
                }
            }
            if (employeeNum == -1) {
                System.out.println("Employee Not Found. Please Try Again!");
                break;
            }
            System.out.println();
            System.out.println("Choose Information to Edit: ");
            System.out.println("1: Update Employee Name");
            System.out.println("2: Update Employee Password");
            System.out.println("3: Return to Employee Menu");
            System.out.print("Please Enter Choice Number: ");
            int answer = input.nextInt();
            if (answer == 1) {
                System.out.print("Enter New Employee Name: ");
                String name = input.nextLine();
                Employee.employees.get(employeeNum).setEmployeeName(name);
                System.out.println("Name Change Successful!");
            }
            if (answer == 2) {
                System.out.println("Enter New Employee Password: ");
                String password = input.nextLine();
                System.out.println("Please Confirm New Password: ");
                String password2 = input.nextLine();
                if (password.equals(password2)) {
                    Employee.employees.get(employeeNum).setPassword(Employee.employees.get(employeeNum).getPassword(), password);
                    System.out.println("Password Change Successful!");
                }
            }
            if (answer == 3) {
                break;
            }
        } while (true);  
    }
    
    ///// EMPLOYEE MENU CHOICE 7 /////
    public static void handleRoomOptions() {
        Scanner input = new Scanner(System.in);
        displayRoomOptionsMenu();
        System.out.print("Please Select an Option: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1: createRoom(); break;
            case 2: updateRoom(); break;
            case 3: updateRoomStatus(); break;
        }
    }
    
    
    
    /////////////// MENU FOR HANDLING ROOMS ///////////////
    public static void displayRoomOptionsMenu() {
        System.out.println();
        System.out.println("====================");
        System.out.println("1: Create a Room");
        System.out.println("2: Update a Room");
        System.out.println("3: Update Room Status");
        System.out.println("====================");
        System.out.println();
    }
     
    ///// ROOM HANDLING MENU CHOICE 1 /////
    public static void createRoom() {
        Scanner input = new Scanner(System.in);
        int newRoom = 0;
        System.out.print("Enter Room Number: ");
        int roomNum = input.nextInt();
        
        for (int i=0; i<Room.rooms.size(); i++) {
            while (Room.rooms.get(i).roomNumber == roomNum) {
                System.out.println("This room number already exists.");
                System.out.print("Please enter another room number: ");
                roomNum = input.nextInt();
            }
            newRoom = roomNum;
        }
        System.out.println("Bed Options: ");
        System.out.println("1: 1 Queen Bed\n2: 2 Queen Beds\n3: 1 King Bed");
        System.out.print("\nEnter Bed Option Number: ");
        int bedOption = input.nextInt();
        
        System.out.println("\nKitchen Options:");
        System.out.println("1: Microwave\n2: Refrigerator + Microwave");
        System.out.print("\nEnter Kitchen Option Number: ");
        int kitchenOption = input.nextInt();
        
        System.out.println("\nCoffee Options: ");
        System.out.println("1: 1-cup Standard Coffee Machine\n2: Keurig Hot K200 Machine");
        System.out.print("\nEnter Coffee Option Number: ");
        int coffeeOption = input.nextInt();
        
        System.out.println("Accessibility Options: ");
        System.out.println("1: Standard Room\n2: Enhanced Accessibility Room");
        System.out.print("\nEnter Accessibility Option Number: ");
        int accessOption = input.nextInt();
        
        Room room1 = new Room(bedOption, kitchenOption, coffeeOption, accessOption, newRoom);
    }
      
    ///// ROOM HANDLING MENU CHOICE 2 /////
    public static void updateRoom() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter room number to update: ");
        int room = input.nextInt();
        Room roomUpdate;
        for (int i=0; i<Room.rooms.size(); i++) {
            if (Room.rooms.get(i).roomNumber == room) {
                roomUpdate = Room.rooms.get(i);
            }
        }
        System.out.println("Please choose one of the following to edit: ");
        System.out.println("1: Bed Options\n2: Kitchen Options\n3: Coffee Options\n4: Accessibility Options");
        System.out.print("\nEnter Number Choice: ");
        int choice = input.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("Bed Options: ");
                System.out.println("1: 1 Queen Bed\n2: 2 Queen Beds\n3: 1 King Bed\n");
                System.out.print("Enter Bed Option #: ");
                int bedChoice = input.nextInt();
                for (int i = 0; i < Room.rooms.size(); i++) {
                    if (Room.rooms.get(i).roomNumber == room) {
                        Room.rooms.get(i).bedOption = bedChoice;
                    }
                }
                break;
            case 2:
                System.out.println("Kitchen Options: ");
                System.out.println("1: Microwave\n2: Refrigerator + Microwave\n");
                System.out.print("Enter Kitchen Option #: ");
                int kitChoice = input.nextInt();
                for (int i = 0; i < Room.rooms.size(); i++) {
                    if (Room.rooms.get(i).roomNumber == room) {
                        Room.rooms.get(i).kitchenOption = kitChoice;
                    }
                }
                break;
            case 3: 
                System.out.println("Coffee Options: ");
                System.out.println("1: 1-cup Standard Coffee Machine\n2: Keurig Hot K200 Machine\n");
                System.out.print("Enter Coffee Option #: ");
                int coffeeChoice = input.nextInt();
                for (int i = 0; i < Room.rooms.size(); i++) {
                    if (Room.rooms.get(i).roomNumber == room) {
                        Room.rooms.get(i).coffeeOption = coffeeChoice;
                    }
                }
                break;
            case 4:
                System.out.println("Accessbility Options: ");
                System.out.println("1: Standard Room\n2: Enhanced Accessibility Room\n");
                System.out.print("Enter Accessibility Option #: ");
                int accessChoice = input.nextInt();
                for (int i = 0; i < Room.rooms.size(); i++) {
                    if (Room.rooms.get(i).roomNumber == room) {
                        Room.rooms.get(i).accessibleOption = accessChoice;
                    }
                }
                break;
        }
    }

    ///// ROOM HANDLING MENU CHOICE 3 /////
    public static void updateRoomStatus() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the room to update: ");
        int room = input.nextInt();
        System.out.println("Status Options: ");
        System.out.println("1: Activate Room\n2: Deactivate Room");
        System.out.print("Please Enter Option Number: ");
        int choice = input.nextInt();
        
        if (choice == 1) {
            for (int i=0; i<Room.rooms.size(); i++) {
                if (Room.rooms.get(i).getRoomNumber() == room) {
                    room = i;
                }
            }
        }
        else if (choice == 2) {
            for (int i=0; i<Room.rooms.size(); i++) {
                if (Room.rooms.get(i).getRoomNumber() == room) {
                    room = i;
                }
            }
            Room.rooms.get(room).setRoomInactive();
        }
        else {
            System.out.println("Invalid Status Choice.");
        }
    }
    
} // Class
