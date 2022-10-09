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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public byte[] getPdfData() {
		return pdfData;
	}
	public void setPdfData(byte[] pdfData) {
		this.pdfData = pdfData;
	}
	

}
