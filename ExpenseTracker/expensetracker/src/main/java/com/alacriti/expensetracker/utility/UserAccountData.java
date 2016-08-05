package com.alacriti.expensetracker.utility;

public class UserAccountData {
	
	private double accountnumber;
	private String nickname;
	public UserAccountData() {
		super();
	}
	public UserAccountData(double accountnumber, String nickname) {
		super();
		this.accountnumber = accountnumber;
		this.nickname = nickname;
	}
	public double getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(double accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
