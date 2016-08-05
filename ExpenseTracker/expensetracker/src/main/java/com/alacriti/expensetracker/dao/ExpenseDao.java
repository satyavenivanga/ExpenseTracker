package com.alacriti.expensetracker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.expensetracker.bo.ExpenseBo;
import com.alacriti.expensetracker.utility.ExpenseData;
import com.alacriti.expensetracker.utility.UserLoggers;

public class ExpenseDao {

	public static ExpenseData addExpenseDetails(int accountNumber, Date date,
			String description, float amount, String category) {
		Connection con = ExpenseBo.createConnection();
		UserLoggers.FILE_EXPENSELOGGER
				.info("Connection created successfully...");
		try {
			Statement st = con.createStatement();
			UserLoggers.FILE_EXPENSELOGGER
					.info("statement created successfully...");
			
			String q2 = "insert into Expt_transaction_tbl(account_no,login_id,amount,transaction_date,description,catogary) select "+accountNumber+" ,login_id,"+amount+",'"+date+"','"+description+"','"+category+"' from Expt_account_info_tbl where account_no="+accountNumber;
			int i = st.executeUpdate(q2);
			UserLoggers.FILE_EXPENSELOGGER
					.info("expense inserted successfully..." + i);
		} catch (SQLException e) {
			UserLoggers.FILE_EXPENSELOGGER.error("sql exception in dao layer "
					+ e);
		}

		return null;
	}

}
