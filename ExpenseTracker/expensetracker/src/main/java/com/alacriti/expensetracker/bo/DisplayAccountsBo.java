package com.alacriti.expensetracker.bo;

import java.sql.Connection;

import com.alacriti.expensetracker.delegate.DisplayAccountsDelegate;
import com.alacriti.expensetracker.delegate.UserDelegate;
import com.alacriti.expensetracker.utility.AccountData;

public class DisplayAccountsBo {
	
	public static Connection createConnection(){
		Connection con = DisplayAccountsDelegate.createConnection();
		return con;
	}
	
	public static AccountData getAllAccounts(){
		return null;
	}

}
