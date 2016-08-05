package com.alacriti.expensetracker.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.alacriti.expensetracker.delegate.FileUploadDelegate;
import com.alacriti.expensetracker.utility.ExpenseData;
import com.alacriti.expensetracker.utility.FileUploadForm;

@Path("/user")
public class FileUploadResource {

	public List<ExpenseData> expenseList = new ArrayList<ExpenseData>();

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadExpenseFile(@MultipartForm FileUploadForm form) {
		String fileName = "transcation.csv";

		try {
			FileUploadDelegate.writeFile(form.getExpenseData(), fileName);
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Done");

		return Response.status(200)
				.entity("File uploaded successfully...: " + fileName).build();

	}

}
