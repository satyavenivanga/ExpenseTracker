package com.alacriti.expensetracker.resource;

import java.sql.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.alacriti.expensetracker.delegate.IncomeDelegate;
import com.alacriti.expensetracker.utility.UserLoggers;

@Path("/user")
public class IncomeResource {

	@POST
	@Path("/income")
	public Response addIncomeDetails(@FormParam("accountNumber") int accountNumber,
									@FormParam("amount") float amount,
									@FormParam("date") Date date){
		IncomeDelegate.addIncomeDetails(accountNumber, amount, date);
		UserLoggers.FILE_INCOMELOGGER.info("data passed from resourcelayer successfully");
		return Response.ok().entity("data passed from resource layer").build();
	}
}
