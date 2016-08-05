package com.alacriti.expensetracker.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.expensetracker.bo.DisplayAccountsBo;
import com.alacriti.expensetracker.utility.AccountData;
import com.alacriti.expensetracker.utility.UserLoggers;

public class DisplayAccountsDao {

	public static AccountData getAllAccounts(){
		Connection con = DisplayAccountsBo.createConnection();
		try {
			Statement st = con.createStatement();
			UserLoggers.FILE_ACCOUNTLOGGER.info("statement created in dao layer");
		//	int loginid= LoginDao.verifyLoginDetails(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
