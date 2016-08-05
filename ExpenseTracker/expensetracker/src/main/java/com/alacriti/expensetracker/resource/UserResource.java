package com.alacriti.expensetracker.resource;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.HttpRequest;

import com.alacriti.expensetracker.dao.UserDao;
import com.alacriti.expensetracker.delegate.UserDelegate;
import com.alacriti.expensetracker.utility.AccountData;
import com.alacriti.expensetracker.utility.UserLoggers;

@Path("/user")
public class UserResource {
	public  Logger logger = Logger.getLogger(UserDao.class);
	public static Map<Integer, AccountData> accountMap = new HashMap<Integer, AccountData>();
	UserDelegate userDelegate = new UserDelegate();
	AccountData accountData = new AccountData();
	
	@POST
	@Path("/transaction")
	public Response displayData(@FormParam("name") String name,
	@FormParam("age") int age){
		System.out.println("data is in resource page");
		UserDelegate.addUser(name, age);
		return Response.status(200).entity("username :"+name+" age : "+age).build();
		
	}
	
	@POST
	@Path("/registration")
	public Response addNewUser(@FormParam("fname") String fname,
			@FormParam("lname") String lname,
			@FormParam("email") String email,
			@FormParam("dob") Date dob,
			@FormParam("password") String password,
			@FormParam("accountnumber") int accountnumber,
			@FormParam("nickname") String nickname){
		
			UserLoggers.FILE_REGISTRATIONLOGGER.info("registration details are in resource page");
			UserDelegate.addRegistrationDetails(fname, lname, email, dob, password, accountnumber, nickname);
		return Response.status(200).entity("successfully forwarded the details...").build();
	}

	@Context 
	private HttpRequest request;
	
	@POST
	@Path("/addaccounts")
	
	public Response addAdditionalAccounts(){
		
		final Map<String,List<String>> params = request.getFormParameters();
		for(String AccountNumber : params.keySet()){
			List<String> fieldList = params.get(AccountNumber);
			System.out.println(fieldList);
		}
		return null;
	}

@GET
@Path("/accounts")
@Produces("application/json")
public List<AccountData> getAllAccounts(){
		accountMap.put(accountData.getLoginid(),accountData);
		logger.info(accountMap);
		return userDelegate.getAllAccounts();
		
	}

@GET
@Path("/accountsftl")
public Response getFtl(){
	return Response.status(200).entity(userDelegate.createConfiguration()).build();
}
}