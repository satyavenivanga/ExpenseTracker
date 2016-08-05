package com.alacriti.expensetracker.delegate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.alacriti.expensetracker.bo.IncomeBo;
import com.alacriti.expensetracker.utility.Income;
import com.alacriti.expensetracker.utility.UserLoggers;

public class IncomeDelegate {
	
	private static Connection con= null;
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.35.70:3306/expensetrack_dev",
					"expensetrack_dev", "expensetrack_dev");
			UserLoggers.FILE_INCOMELOGGER.info("connection created successfully...");
			
		} catch (ClassNotFoundException e) {
			UserLoggers.FILE_INCOMELOGGER.error("there is a class not found exception "+e);
			return null;
		} catch (SQLException e) {
			UserLoggers.FILE_INCOMELOGGER.error("there is an sql exception in delegate creating connection section"+e);
			return null;
		}
		return con;
	}
	
	public static Income addIncomeDetails(int accountNumber, float amount, Date date){
		return IncomeBo.addIncomeDetails(accountNumber, amount, date);
	}
}
