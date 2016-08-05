package com.alacriti.expensetracker.utility;

import java.sql.Date;

public class Income {
	private int accountNubmer;
	private float amount;
	private Date date;
	
	public Income() {
		
	}

	public Income(int accountNubmer, float amount, Date date) {
		this.accountNubmer = accountNubmer;
		this.amount = amount;
		this.date = date;
	}

	public int getAccountNubmer() {
		return accountNubmer;
	}

	public void setAccountNubmer(int accountNubmer) {
		this.accountNubmer = accountNubmer;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
