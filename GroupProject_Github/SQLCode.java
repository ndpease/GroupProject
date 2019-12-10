package javaProject;

import java.sql.*;
import oracle.jdbc.pool.*;
import java.util.*;

public class SQLCode {

    public class DBTest {

    // IN THE PUBLIC CLASS METHOD BEFORE START()
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;

    String empTbl = "EMPLOYEE";
    String guesTbl = "GUEST";
    String bookingTbl = "BOOKING";
    String roomTbl = "ROOM";
    String valTbl = "VALUE_GUEST";
    String roomServTbl = "ROOM_SERVICE";

    
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
            sqlQuery += Booking.bookings.get(i).checkInYear + ",";
            sqlQuery += Booking.bookings.get(i).checkInDay + ",";
            sqlQuery += Booking.bookings.get(i).checkOutYear + ",";
            sqlQuery += Booking.bookings.get(i).checkOutDay + ");";
            sendDBCommand(sqlQuery);
        }
    }
    

    public void insertValueGuest() {
        for (int i=0; i<ValueGuest.valueGuests.size(); i++) {
            String sqlQuery = "INSERT INTO JAVAUSER." + valTbl + " VALUES (";
            sqlQuery += ValueGuest.valueGuests.get(i).getSavingsNumber() + ",";
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
    
  
    
    
    public static void main(String[] args) {
        launch(args);
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
}