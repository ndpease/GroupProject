package oracledb;
import java.sql.*;
import oracle.jdbc.pool.*;
import java.util.*;

public class DBTest {
	
	// IN THE PUBLIC CLASS METHOD BEFORE START()
	Connection dbConn;
	Statment commStmt;
	ResultSet dbResults;
	
	String empTbl = "EMPLOYEE";
	String guesTbl = "GUEST";
	String bookingTbl = "BOOKING";
	String roomTbl = "ROOM";
	String valTbl = "VALUE_GUEST";
	String roomServTbl = "ROOM_SERVICE";
	
	// NEED TO ADD FOR LOOPS TO EACH OF THE INSERT METHODS!!!!!!!!!!!!!!!!!!!!!!
	
	public void insertEmployee() {
		String sqlQuery = "INSERT INTO JAVAUSER." + empTbl + " (EMPLOYEEID,NAME,USERNAME,PASSWORD) VALUES (";
		sqlQuery += "\'" + Employee.employees.getEmployeeID().getText() + "\'"; // might not need the .getText()
		sqlQuery += txtEmpName.getText() + ",";
		sqlQuery += txtEmpUsername.getText() + ",";
		sqlQuery += txtEmpPassword.getText() + ");";
		
		sendDBCommand(sqlQuery)
	}
	
	public void insertGuest() {
		String sqlQuery = "INSERT INTO JAVAUSER." + guesTbl + " (GUESTID,NAME,USERNAME,PASSWORD) VALUES (";
		sqlQuery += "\'" + Guest.guests.getGuestID().getText() + "\'";
		sqlQuery += txtGuestName.getText() + ",";
		sqlQuery += txtGuestUser.getText() + ",";
		sqlQuery += txtGuestPass.getText() + ");"
		
		sendDBCommand(sqlQuery);
	}
	
	public void insertRoom() {
		String sqlQuery = "INSERT INTO JAVAUSER." + roomTbl + " (ROOMID,ROOMNUMBER,ROOMBOOKEDQUANTITY,
			ROOMBOOKED,BEDOPTION,KITCHENOPTION,COFFEEOPTION,ACCESSIBLEOPTION,ROOMCOSTPERNIGHT,ROOMSTATUS) VALUES (";
		sqlQuery += // roomID
		sqlQuery += tfERRoomNo.getText() + ",";
		sqlQuery += // Room quantity + ",";
		sqlQuery += // Room booked
		sqlQuery += cbRoomBedOpt.getText() + ",";
		sqlQuery += cbRoomKitchOpt.getText() + ",";
		sqlQuery += cbRoomCoffeeOpt.getText() + ",";
		sqlQuery += cbRoomAccessOpt.getText() + ",";
		
		
		sendDBCommand(sqlQuery);
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
		
	public void sendDBCommand(String sqlQuery) {		
		String jdbcConnectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
		String userID = "javauser";
		String userPASS = "javapass";
		OracleDataSource ds;
		
		System.out.println(sqlQuery);
		
		try {
			ds = new OracleDataSource();
			ds.setURL(URL);
			dbConn = ds.getConnection(userID,userPASS);
			commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			dbResults = commStmt.executeQuery(sqlQuery);
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}	