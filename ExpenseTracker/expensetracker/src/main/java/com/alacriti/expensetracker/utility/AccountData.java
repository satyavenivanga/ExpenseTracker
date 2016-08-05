package com.alacriti.expensetracker.utility;

public class AccountData {
	private int loginid;
	private Double accountnumber;
	private String nickname;

	public AccountData() {

	}

	public AccountData(int loginid, Double accountnumber, String nickname) {
		this.loginid= loginid;
		this.accountnumber = accountnumber;
		this.nickname = nickname;
	}
	
	public AccountData(Double accountnumber, String nickname){
		this.accountnumber = accountnumber;
		this.nickname=nickname;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public Double getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Double accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
