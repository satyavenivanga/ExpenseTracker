package com.alacriti.expensetracker.bo;

import java.sql.Connection;
import java.sql.Date;

import com.alacriti.expensetracker.dao.IncomeDao;
import com.alacriti.expensetracker.delegate.IncomeDelegate;
import com.alacriti.expensetracker.utility.Income;

public class IncomeBo {
	
	public static Connection getConnection(){
		Connection con = IncomeDelegate.getConnection();
		return con;
	}
	public static Income addIncomeDetails(int accountNumber, float amount, Date date){
		return IncomeDao.addIncomeDetails(accountNumber, amount, date);
	}
}
