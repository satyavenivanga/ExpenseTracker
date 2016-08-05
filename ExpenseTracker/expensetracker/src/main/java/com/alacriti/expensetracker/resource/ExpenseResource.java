package com.alacriti.expensetracker.resource;

import java.sql.Date;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.alacriti.expensetracker.delegate.ExpenseDelegate;
import com.alacriti.expensetracker.utility.UserLoggers;

@Path("/user")
public class ExpenseResource {

	@POST
	@Path("/expense")
	public Response addExpenseDetails(@FormParam("accountNumber") int accountNumber,
									@FormParam("date") Date date,
									@FormParam("description") String description,
									@FormParam("amount") float amount,
									@FormParam("category") String category){
		ExpenseDelegate.addExpenseDetails(accountNumber, date, description, amount, category);
		UserLoggers.FILE_EXPENSELOGGER.info("expense passed from resource layer");
		return Response.ok().entity("expense passed from resource layer..."+accountNumber+"-----"+date+"-----"+description).build();
	}
}
