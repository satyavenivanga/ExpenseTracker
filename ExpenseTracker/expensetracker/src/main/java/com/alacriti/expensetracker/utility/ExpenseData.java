package com.alacriti.expensetracker.utility;

import java.sql.Date;

public class ExpenseData {
	private int accountNumber;
	private Date date;
	private String description;
	private float amount;
	private String category;
	
	public ExpenseData() {

	}

	public ExpenseData(int accountNumber, Date date, String description,
			float amount, String category) {

		this.accountNumber = accountNumber;
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.category = category;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
