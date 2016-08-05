package com.alacriti.expensetracker.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.alacriti.expensetracker.bo.LoginBo;
import com.alacriti.expensetracker.utility.ExpenseData;
import com.alacriti.expensetracker.utility.Income;
import com.alacriti.expensetracker.utility.UserAccountData;
import com.alacriti.expensetracker.utility.UserLoggers;

public class LoginDao {
	
		public static  List<UserAccountData> accountList = new ArrayList<UserAccountData>();
		public static  List<Income> incomeList = new ArrayList<Income>();
		public static List<ExpenseData> expenseList = new ArrayList<ExpenseData>();
		public static boolean flag = false;
		public Timestamp time=null;
		public static int login_id=0;
		public static double accountNumber =0;
		
	public static int verifyLoginDetails(String email, String password) {
		Connection con = LoginBo.getConnection();
		UserLoggers.FILE_LOGINLOGGER.info("connection created successfully in dao layer...");
		try {
			Statement st = con.createStatement();
			
			String q1="select login_id from Expt_rgstruser_tbl where email_id='"+email+"' and login_password=password('"+password+"')";
			ResultSet rs = st.executeQuery(q1);
			UserLoggers.FILE_LOGINLOGGER.info("login id");
			rs.next();
			UserLoggers.FILE_LOGINLOGGER.info(rs.getInt(1));
			int loginid=rs.getInt(1);
			login_id=loginid;
			UserLoggers.FILE_LOGINLOGGER.info(loginid);
			
			if(loginid!=0){
				flag = true;
				String q2 = "insert into Expt_loginfo_tbl(email_id,logout_time) values('"+email+"','2016/08/03 12:12:12')";
				int i = st.executeUpdate(q2);
				UserLoggers.FILE_LOGINLOGGER.info("login table is updated...."+i);
				
				String q3 ="select account_no from Expt_account_info_tbl where login_id = "+loginid;
				ResultSet rs2 = st.executeQuery(q3);
				
				rs2.next();
				accountNumber=rs2.getDouble(1);
				UserLoggers.FILE_LOGINLOGGER.info("account number");
				UserLoggers.FILE_LOGINLOGGER.info(accountNumber);
				
				return loginid;
			}
			
			else{
				flag = false;
				JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
			
				return loginid;
			}
			
		} catch (SQLException e) {
			UserLoggers.FILE_LOGINLOGGER.info("sql exception in dao layer:"+e);
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e1) {
					UserLoggers.FILE_LOGINLOGGER.info("error at connection closing:"+e);
				}
			}
			return 0;
		}
	}
	
	public static List<UserAccountData> getAllAccounts(){
		Connection con = LoginBo.getConnection();
		try {
			Statement st = con.createStatement();
			int loginid= LoginDao.login_id;
			String q3 ="SELECT account_no, account_name FROM Expt_account_info_tbl WHERE login_id ="+loginid;
			ResultSet accountRs = st.executeQuery(q3);
			while(accountRs.next()){				
				accountList.add(new UserAccountData(accountRs.getDouble(1), accountRs.getString(2)));
			}
			
		} catch (SQLException e) {
			UserLoggers.FILE_ACCOUNTLOGGER.equals("there is sql exception"+e);
			if(con!=null){
				UserLoggers.FILE_LOGINLOGGER.info("error at conneciton closing :"+e);
			}
		}
		return accountList;
	}

	public static List<Income> getIncomeDetails(){
		Connection con = LoginBo.getConnection();
		
		try {
			Statement st = con.createStatement();
			String q4 ="select account_no, amount, transaction_date from Expt_transaction_tbl where description is null and catogary is null and account_no ="+accountNumber;
			ResultSet incomeRs = st.executeQuery(q4);
			while(incomeRs.next()){
				incomeList.add(new Income(incomeRs.getInt(1), incomeRs.getFloat(2), incomeRs.getDate(3)));
				UserLoggers.FILE_INCOMELOGGER.info(incomeList);
			}
		} catch (SQLException e) {
			UserLoggers.FILE_INCOMELOGGER.error("connection to create statement at dao level at view income details"+e);
		}
		
		return incomeList;
	}
	
	public static List<ExpenseData> getExpenseDetails(){
		Connection con = LoginBo.getConnection();
		try {
			Statement st = con.createStatement();
			UserLoggers.FILE_EXPENSELOGGER.info("statement is created at login dao layer....");
			String q5 ="select * from Expt_transaction_tbl where description is not null and catogary is not null and account_no=123456789";
			ResultSet expenseRs = st.executeQuery(q5);
			while(expenseRs.next()){
				expenseList.add(new ExpenseData(expenseRs.getInt(1), expenseRs.getDate(4), expenseRs.getString(5),expenseRs.getFloat(3),expenseRs.getString(6)));
				UserLoggers.FILE_EXPENSELOGGER.info(expenseList);
			}
		} catch (SQLException e) {
			UserLoggers.FILE_EXPENSELOGGER.error("sql connection occured at login dao layer "+e);
		}
		
		return expenseList;
	}
	
}
