package com.alacriti.expensetracker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.alacriti.expensetracker.bo.UserBo;
import com.alacriti.expensetracker.utility.AccountData;
import com.alacriti.expensetracker.utility.RegistrationData;
import com.alacriti.expensetracker.utility.UserData;
import com.alacriti.expensetracker.utility.UserLoggers;



public class UserDao {
	public  List<AccountData> accountlist = new ArrayList<AccountData>();
	public  Map<Integer, AccountData> accountMap = new HashMap<Integer, AccountData>();
	public  Logger logger = Logger.getLogger(UserDao.class);

	public static UserData getTransactionDetails(String name, int age) {
		Connection con = UserBo.getConnection();
		try {
			Statement st = con.createStatement();
			int i = st.executeUpdate("insert into userdata values('" + name
					+ "'," + age + ")");
			System.out.println("data inserted successfully : " + i + " , "
					+ name + " , " + age);
			con.commit();
		} catch (SQLException e) {
			System.out.println("these is an sql exception");
		} catch (Exception e) {
			System.out.println("there is an exception here");
		}
		return null;
	}

	public static RegistrationData getRegistrationDetails(String fname,
			String lname, String email, Date dob, String password, int accountnumber, String nickname) {
		Connection con = UserBo.getConnection();

		try {
			Statement st = (Statement) con.createStatement();
			int i = st
					.executeUpdate("INSERT INTO Expt_rgstruser_tbl values(NULL,'"
							+ fname
							+ "','"
							+ lname
							+ "','"
							+ email
							+ "','"
							+ dob + "', password('" + password + "'))");
			int j = st.executeUpdate("INSERT INTO Expt_account_info_tbl(login_id, account_no, account_name) SELECT login_id,"+accountnumber+", '"+nickname+"' from Expt_rgstruser_tbl where email_id='"+email+"'");
			UserLoggers.FILE_REGISTRATIONLOGGER
					.info("data inserted successfully" + i);
			System.out.println("in layer dao........");
			System.out.println("executed 2 inserts.........."+j);
		} catch (SQLException e) {
			UserLoggers.FILE_REGISTRATIONLOGGER
					.error("these is an sql exception");
		}
		return null;
	}

	public List<AccountData> getAllAccounts() {
		Connection con = UserBo.getConnection();
		try {
			Statement st = con.createStatement();
			String q1= "select * from Expt_account_info_tbl";
			ResultSet rs = st.executeQuery(q1);
			while(rs.next()){
				accountlist.add(new AccountData(rs.getInt(1), rs.getDouble(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			logger.info(e);
		}
		
		return accountlist;
	}
	
}
