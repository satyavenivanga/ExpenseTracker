package com.alacriti.expensetracker.bo;

import java.sql.Connection;
import java.util.List;

import com.alacriti.expensetracker.dao.LoginDao;
import com.alacriti.expensetracker.delegate.UserDelegate;
import com.alacriti.expensetracker.utility.ExpenseData;
import com.alacriti.expensetracker.utility.Income;
import com.alacriti.expensetracker.utility.UserAccountData;
import com.alacriti.expensetracker.utility.UserLoggers;

public class LoginBo {
	
	LoginDao loginDao= new LoginDao();
	public static Connection getConnection(){
		Connection con = UserDelegate.createConnection();
		UserLoggers.FILE_LOGINLOGGER.info("account created in login bo layer...");
		return con;
	}
	
	public static int verifyLoginDetails(String email, String password) {
		UserLoggers.FILE_LOGINLOGGER.info("logging details getting verified...."+email);
		return LoginDao.verifyLoginDetails(email, password);
		
	}
	
	public List<UserAccountData> getAccountDetails(){
		return LoginDao.getAllAccounts();
	}

	public List<Income> getIncomeDetails(){
		return LoginDao.getIncomeDetails();
	}
	
	public List<ExpenseData> getExpenseDetails(){
		return LoginDao.getExpenseDetails();
	}
}
