package com.pdf.invoice.service;

import com.pdf.invoice.model.PDFResponseDTO;

public interface PDFInvoiceService {

	public int getPDFInvoiceNumber(String bookingNo) throws Exception;

	public PDFResponseDTO getPDFInvoice(int invoiceNo);

}
