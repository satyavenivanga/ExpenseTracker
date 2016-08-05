package com.alacriti.expensetracker.delegate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.alacriti.expensetracker.bo.LoginBo;
import com.alacriti.expensetracker.utility.ExpenseData;
import com.alacriti.expensetracker.utility.Income;
import com.alacriti.expensetracker.utility.UserAccountData;
import com.alacriti.expensetracker.utility.UserLoggers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class LoginDelegate {

	private static Connection con= null;
	private Configuration config = null;
	LoginBo loginBo= new LoginBo();
/*	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.35.70:3306/expensetrack_dev",
					"expensetrack_dev", "expensetrack_dev");
			return con;
		} catch (ClassNotFoundException e) {
			UserLoggers.FILE_LOGINLOGGER.error("there is a class not found exception "+e);
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e1) {
					UserLoggers.FILE_LOGINLOGGER.error("there is an sql exception in delegate closing connection "+e);
				}
			}
			return null;
		} catch (SQLException e) {
			UserLoggers.FILE_LOGINLOGGER.error("there is an sql exception in delegate creating connection"+e);
			return null;
		}*/

	//}
	
	public static int verifyLoginDetails(String email, String password) {
		return LoginBo.verifyLoginDetails(email, password);
	}
	
	
	public String ftlAccountDetails(){
		List<UserAccountData> accountList = loginBo.getAccountDetails();
		List<Income> incomeList = loginBo.getIncomeDetails();
		List<ExpenseData> expenseList = loginBo.getExpenseDetails();
		config = new Configuration();
		config.setClassForTemplateLoading(UserDelegate.class, "/");
		config.setIncompatibleImprovements(new Version(2, 3, 20));
		config.setDefaultEncoding("UTF-8");
		config.setLocale(Locale.US);
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		try {
			Template template = config.getTemplate("userhome.ftl");
			Writer writer = new StringWriter();
		/*	Map<String, List<UserAccountData>> accountMap = new HashMap<String, List<UserAccountData>>();
			Map<String, List<Income>> incomeMap = new HashMap<String, List<Income>>();*/
			
			Map<String, Object> detailMap = new HashMap<String, Object>();
			detailMap.put("accountsdetails", accountList);
			detailMap.put("incomedetails",incomeList);
			detailMap.put("expensedetails", expenseList);
			template.process(detailMap, writer);

			
			return writer.toString();
		} catch (IOException e) {
			UserLoggers.FILE_ACCOUNTLOGGER.error(e);
			return null;
		} catch (TemplateException e) {
			UserLoggers.FILE_ACCOUNTLOGGER.error(e);
			return null;
		}

	}
	
	public String ftlIncomeDetails(){
		List<Income> incomeList = loginBo.getIncomeDetails();
		config = new Configuration();
		config.setClassForTemplateLoading(UserDelegate.class, "/");
		config.setIncompatibleImprovements(new Version(2, 3, 20));
		config.setDefaultEncoding("UTF-8");
		config.setLocale(Locale.US);
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		try {
			Template templete = config.getTemplate("income.ftl");
			Writer writer = new StringWriter();
			Map<String, List<Income>> incomeMap = new HashMap<String, List<Income>>();
			incomeMap.put("incomedetails",incomeList);
			templete.process(incomeMap, writer);
			return writer.toString();
		} catch (IOException e) {
			UserLoggers.FILE_INCOMELOGGER.error("input output exception in login delegate layer..."+e);
			return null;
		} catch (TemplateException e) {
			UserLoggers.FILE_INCOMELOGGER.error("templete exception in login delegate layer..."+e);
			return null;
		}
		
	}

}
