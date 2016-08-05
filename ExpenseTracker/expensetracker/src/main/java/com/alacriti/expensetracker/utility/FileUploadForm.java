package com.alacriti.expensetracker.utility;

import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {

	public FileUploadForm() {
	}

	private byte[] expenseData;

	public byte[] getExpenseData() {
		return expenseData;
	}
	
	@FormParam("uploadedFile")
	@PartType("application/octet-stream")
	public void setExpenseData(byte[] expenseData) {
		this.expenseData = expenseData;
	}
	
	
}
