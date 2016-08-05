package com.alacriti.expensetracker.delegate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alacriti.expensetracker.bo.UserBo;
import com.alacriti.expensetracker.dao.UserDao;
import com.alacriti.expensetracker.utility.AccountData;
import com.alacriti.expensetracker.utility.RegistrationData;
import com.alacriti.expensetracker.utility.UserData;
import com.alacriti.expensetracker.utility.UserLoggers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class UserDelegate {
	private static Connection con = null;
	private Configuration config = null;
	UserBo userBo = new UserBo();
	public Logger logger = Logger.getLogger(UserDao.class);

	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found here");
			UserLoggers.FILE_ACCOUNTLOGGER.info(e);
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.35.70:3306/expensetrack_dev",
					"expensetrack_dev", "expensetrack_dev");
		} catch (SQLException e) {
			System.out.println("database exception");
			UserLoggers.FILE_ACCOUNTLOGGER.info(e);
		}

		return con;
	}

	public String createConfiguration() {
		List<AccountData> accountList = userBo.getAllAccounts();
		config = new Configuration();
		config.setClassForTemplateLoading(UserDelegate.class, "/");
		config.setIncompatibleImprovements(new Version(2, 3, 20));
		config.setDefaultEncoding("UTF-8");
		config.setLocale(Locale.US);
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		try {
			Template template = config.getTemplate("allaccounts.ftl");
			Writer writer = new StringWriter();
			/*Map<String,List<Question>> input = new HashMap<String,List<Question>>();*/
			Map<String, List<AccountData>> accountMap = new HashMap<String, List<AccountData>>();
			accountMap.put("accountdetails", accountList);
			template.process(accountMap, writer);
			logger.info(accountMap);
			logger.info(accountList);
			
			Writer fileWriter = new FileWriter(new File("accountdetails.html"));
			template.process(accountMap, fileWriter);
			
			return writer.toString();
		} catch (IOException e) {
			logger.info(e);
			return null;
		} catch (TemplateException e) {
			logger.info(e);
			return null;
		}
		
		
	}

	public static UserData addUser(String name, int age) {
		System.out.println("now data is in delegate level");
		return UserBo.getTransactionDetails(name, age);
	}

	public static RegistrationData addRegistrationDetails(String fname,
			String lname, String email, Date dob, String password,
			int accountnumber, String nickname) {
		UserLoggers.FILE_REGISTRATIONLOGGER
				.info("data passed through delegate level");
		return UserBo.getRegistrationDetails(fname, lname, email, dob,
				password, accountnumber, nickname);
	}

	public List<AccountData> getAllAccounts() {
		return userBo.getAllAccounts();
	}

}
