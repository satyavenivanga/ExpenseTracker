package com.alacriti.expensetracker.delegate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.alacriti.expensetracker.bo.ExpenseBo;
import com.alacriti.expensetracker.utility.ExpenseData;
import com.alacriti.expensetracker.utility.UserLoggers;

public class ExpenseDelegate {
	
	private static Connection con = null;
	
	public static Connection createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.35.70:3306/expensetrack_dev",
					"expensetrack_dev", "expensetrack_dev");
			UserLoggers.FILE_EXPENSELOGGER.info("connection created successfully in delegate layer");
		} catch (ClassNotFoundException e) {
			UserLoggers.FILE_EXPENSELOGGER.error("there is a class not found exception "+e);
			return null;
		} catch (SQLException e) {
			UserLoggers.FILE_EXPENSELOGGER.error("there is an error wil sql connection "+e);
			return null;
		}
		
		return con;
	}
	
	public static ExpenseData addExpenseDetails(int accountNumber, Date date,
			String description, float amount, String category) {
		return ExpenseBo.addExpenseDetails(accountNumber, date, description, amount, category);
		
	}

}
