package com.alacriti.expensetracker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import com.alacriti.expensetracker.bo.IncomeBo;
import com.alacriti.expensetracker.utility.Income;
import com.alacriti.expensetracker.utility.UserLoggers;

public class IncomeDao {
	
	public static Income addIncomeDetails(int accountNumber, float amount, Date date){
		Connection con = IncomeBo.getConnection();
		UserLoggers.FILE_INCOMELOGGER.info("connection created successfully in dao layer...");
		try{
			
			Statement st = con.createStatement();			
			String q2 = "insert into Expt_transaction_tbl(account_no,login_id,amount,transaction_date) select "+accountNumber+" ,login_id,"+amount+",'"+date+"' from Expt_account_info_tbl where account_no="+accountNumber;
			int i = st.executeUpdate(q2);
			UserLoggers.FILE_INCOMELOGGER.info("query inserted...."+i);
		} catch (SQLException e1) {
			UserLoggers.FILE_INCOMELOGGER.error("there is an sql exception in dao layer"+e1);
		}
		return null;
	}
}
