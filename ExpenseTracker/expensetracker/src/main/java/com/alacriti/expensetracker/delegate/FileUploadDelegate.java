package com.alacriti.expensetracker.delegate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.alacriti.expensetracker.bo.FileUploadBo;
import com.alacriti.expensetracker.utility.ExpenseData;
import com.alacriti.expensetracker.utility.UserLoggers;

public class FileUploadDelegate {
	public static List<Object> uploadList = new ArrayList<Object>();
	public static List<ExpenseData> expenseList = new ArrayList<ExpenseData>();
	
	public static ExpenseData writeFile(byte[] content, String filename)
			throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fout = new FileOutputStream(file);
		fout.write(content);
		fout.flush();
		fout.close();
		String line = "";
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		int accountNumber =0;
		java.sql.Date date = null;
		String description =null;
		float amount = 0;
		String category =null;

		while ((line = br.readLine()) != null) {

			st = new StringTokenizer(line, ",");

			DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
			
			accountNumber=Integer.parseInt(st.nextToken());
			UserLoggers.FILE_UPLOADLOGGER.info("account number"+accountNumber);
			try {
				date= new java.sql.Date(df.parse(st.nextToken()).getTime());
				UserLoggers.FILE_UPLOADLOGGER.info("date "+date);
			} catch (ParseException e) {
				UserLoggers.FILE_UPLOADLOGGER.error(e);
			}		
			description = st.nextToken();
			UserLoggers.FILE_UPLOADLOGGER.info("description "+description);
			amount=Float.parseFloat(st.nextToken());
			UserLoggers.FILE_UPLOADLOGGER.info("amount "+amount);
			category = st.nextToken();
			UserLoggers.FILE_UPLOADLOGGER.info("category "+category);
		}
		br.close();
		
		return FileUploadBo.expenseUpload(accountNumber, date, description, amount, category);
	}
	
}
