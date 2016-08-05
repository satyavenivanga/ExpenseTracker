package com.alacriti.expensetracker.resource;

import java.net.URI;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


import com.alacriti.expensetracker.dao.LoginDao;
import com.alacriti.expensetracker.delegate.LoginDelegate;

@Path("/user")
public class LoginResource {
	LoginDelegate loginDelegate= new LoginDelegate();
	URI homeUri = null;
	@POST
	@Path("/login")
	public String verifyLoginDetails(@FormParam("email") String email,
									@FormParam("password") String password){
		homeUri = URI.create("/userhome.ftl");
		LoginDelegate.verifyLoginDetails(email, password);
		int loginid = LoginDao.verifyLoginDetails(email, password);
		if(loginid!=0){
		return loginDelegate.ftlAccountDetails();
		}
		else
			return null;
	}
	
	@GET
	@Path("/login")
	public Response getAllAccounts(){
		return Response.ok().entity(loginDelegate.ftlAccountDetails()).build();
		
	}
	
	@GET
	@Path("/income")
	public Response getIncomeDetails(){
		return Response.ok().entity(loginDelegate.ftlIncomeDetails()).build();
	}
}
