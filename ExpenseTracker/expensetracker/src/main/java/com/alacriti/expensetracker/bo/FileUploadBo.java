package com.alacriti.expensetracker.bo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.expensetracker.dao.FileUploadDao;
import com.alacriti.expensetracker.delegate.FileUploadDelegate;
import com.alacriti.expensetracker.utility.ExpenseData;
import com.alacriti.expensetracker.utility.UserLoggers;

public class FileUploadBo {

	public static List<Object> uploadList = new ArrayList<Object>();

	public static ExpenseData expenseUpload(int accountNumber, Date date,
			String description, float amount, String category) {
		
		return null;
	}
	

}
