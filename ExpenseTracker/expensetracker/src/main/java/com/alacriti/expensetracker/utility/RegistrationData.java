package com.alacriti.expensetracker.utility;

import java.sql.Date;

public class RegistrationData {
	private String fname;
	private String lname;
	private String email;
	private Date dob;
	private String password;
	private int accountnumber;
	private String nickname;
	
	
	public RegistrationData() {
	}
	
	public RegistrationData(String fname, String lname, String email, Date dob,
			String password, int accountnumber, String nickname) {
	
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.accountnumber=accountnumber;
		this.nickname=nickname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

		
}
