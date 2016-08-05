package com.alacriti.expensetracker.delegate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.alacriti.expensetracker.utility.AccountData;
import com.alacriti.expensetracker.utility.UserLoggers;

public class DisplayAccountsDelegate {	
	
	private static Connection con = null;
	
	public static Connection createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.35.70:3306/expensetrack_dev",
					"expensetrack_dev", "expensetrack_dev");
			
			UserLoggers.FILE_ACCOUNTLOGGER.info("connection is created in delegate layer..");
		} catch (ClassNotFoundException e) {
			UserLoggers.FILE_ACCOUNTLOGGER.info("there is a class not found exception "+e);
		} catch (SQLException e) {
			UserLoggers.FILE_ACCOUNTLOGGER.info("there is an sql exception "+e);
		}
		
		return con;
	}
	public static AccountData getAllAccounts(){
		return null;
	}
	
	

}
