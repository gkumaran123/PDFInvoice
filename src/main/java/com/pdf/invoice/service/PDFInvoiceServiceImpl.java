package com.pdf.invoice.service;

import java.io.File;
import java.io.FileInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdf.invoice.entity.GlobalMaster;
import com.pdf.invoice.entity.InvoiceHeader;
import com.pdf.invoice.model.PDFResponseDTO;
import com.pdf.invoice.repo.GlobalMasterRepository;
import com.pdf.invoice.repo.InvoiceHeaderRepository;

@Service
@Transactional
public class PDFInvoiceServiceImpl implements PDFInvoiceService {
	
	private Logger log = LoggerFactory.getLogger(PDFInvoiceServiceImpl.class);
	
	private String EBILLING_DOCUMENT_SERVER_PATH="EBILLING_DOCUMENT_SERVER_PATH";
	
	@Value("${pdf.location}")
    private String pdfLocation;
	
	@Autowired
	InvoiceHeaderRepository invoiceHeaderRepo;
	
	@Autowired
	GlobalMasterRepository globalMasterRepo;
	
	@Override
	public int getPDFInvoiceNumber(String bookingNo) throws Exception {
		InvoiceHeader invoiceHeader = invoiceHeaderRepo.findByBookingNo(bookingNo);
		if (invoiceHeader != null)
			return invoiceHeader.getInvoiceNo();
		else
			return 0;
	}

	@Override
	public PDFResponseDTO getPDFInvoice(int invoiceNo) {
		byte[] arr = null;
		PDFResponseDTO pdfResponseDTO = new PDFResponseDTO();
		try {
			GlobalMaster globalMaster = globalMasterRepo.findByCode(EBILLING_DOCUMENT_SERVER_PATH);
			log.info("PDF Location is : "+globalMaster.getValue());
		File file = new File(pdfLocation+invoiceNo+".pdf");
		 FileInputStream fl = new FileInputStream(file);
		 arr = new byte[(int)file.length()];
		 fl.read(arr);
		 fl.close();
		 if(arr!=null) {
			 pdfResponseDTO.setStatus("SUCCESS");
			 pdfResponseDTO.setPdfData(arr);
		 }
		} catch (Exception e) {
			log.error("", e);
		}
		return pdfResponseDTO;
		
	}

}
