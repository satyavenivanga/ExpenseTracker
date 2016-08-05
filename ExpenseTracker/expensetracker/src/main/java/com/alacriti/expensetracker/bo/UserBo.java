package com.alacriti.expensetracker.bo;

import java.sql.Date;
import java.util.List;
import com.alacriti.expensetracker.dao.UserDao;
import com.alacriti.expensetracker.delegate.UserDelegate;
import com.alacriti.expensetracker.utility.AccountData;
import com.alacriti.expensetracker.utility.RegistrationData;
import com.alacriti.expensetracker.utility.UserData;
import com.alacriti.expensetracker.utility.UserLoggers;
import com.mysql.jdbc.Connection;

public class UserBo {
	static UserData userData = new UserData();
	UserDao userDao= new UserDao();
	
	public static Connection getConnection(){
		Connection con = (Connection) UserDelegate.createConnection();
		return con;
	}
	public static UserData getTransactionDetails(String name, int age){
		
		System.out.println("data is in bo level");
		for(int i=0; i<100; i++){
		UserLoggers.FILE_USERLOGGER.info("its an info in logger......");
		UserLoggers.FILE_TRANSACTIONLOGGER.error("its an error message");
		}
		return UserDao.getTransactionDetails(name, age);
		
	}
	public static RegistrationData getRegistrationDetails(String fname,
			String lname, String email, Date dob, String password, int accountnumber, String nickname) {
		UserLoggers.FILE_REGISTRATIONLOGGER.info("data passed through bussiness logic");
		return UserDao.getRegistrationDetails(fname, lname, email, dob, password, accountnumber, nickname);
	}

	public List<AccountData> getAllAccounts() {
		return userDao.getAllAccounts();
	}
}
