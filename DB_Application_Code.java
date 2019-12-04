package oracledb;
import java.sql.*;
import oracle.jdbc.pool.*;

public class DBTest {
	public static void main(String[] args) {
		
		String jdbcConnectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
		String userID = "javauser";
		String userPASS = "javapass";
		
		Statement stmt;
		ResultSet rset;
		String sqlQuery;
		
		