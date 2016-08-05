package com.alacriti.expensetracker.bo;

import java.sql.Connection;
import java.sql.Date;

import com.alacriti.expensetracker.dao.ExpenseDao;
import com.alacriti.expensetracker.delegate.ExpenseDelegate;
import com.alacriti.expensetracker.utility.ExpenseData;

public class ExpenseBo {

	public static Connection createConnection(){
		Connection con = ExpenseDelegate.createConnection();
		return con;
	}
	public static ExpenseData addExpenseDetails(int accountNumber, Date date,
			String description, float amount, String category) {
		return ExpenseDao.addExpenseDetails(accountNumber, date, description, amount, category);
	}

}
