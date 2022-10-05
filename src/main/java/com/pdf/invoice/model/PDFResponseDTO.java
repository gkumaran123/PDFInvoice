package com.pdf.invoice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PDFResponseDTO {
	private String status;
	private String message;
	private byte[] pdfData;
	public PDFResponseDTO() {
		super();
		this.status = "FAILURE";
		this.message = null;
		this.pdfData = null;
	}
	

}
