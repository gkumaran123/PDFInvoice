package com.pdf.invoice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pdf.invoice.entity.UserMaster;
import com.pdf.invoice.model.PDFResponseDTO;
import com.pdf.invoice.model.UserResponseDTO;
import com.pdf.invoice.service.PDFInvoiceService;
import com.pdf.invoice.service.EmployeeService;


@RestController
@RequestMapping(value = "API/invoice/")
public class PdfController {
	private Logger log = LoggerFactory.getLogger(PdfController.class);
	
	@Autowired
	PDFInvoiceService pdfInvoiceService;
	
	@Autowired
	EmployeeService userService;
	
	@RequestMapping(path="employees", method=RequestMethod.GET)
	public String goHome(){
		return "index";
	}
	
	@RequestMapping(value = "getPdf", method = RequestMethod.GET)
	public ResponseEntity<?> getPDF(
			@RequestParam String BookingNo) {
		long stamp = System.currentTimeMillis();
		try {
			log.info(stamp + "Inside get PDF Controller");
			int invoiceNo = pdfInvoiceService.getPDFInvoiceNumber(BookingNo);
			if(invoiceNo!=0) {
				log.info("Invoice Number from DB : "+ invoiceNo);	
				PDFResponseDTO pdfResponseDTO = pdfInvoiceService.getPDFInvoice(invoiceNo);
			log.info(stamp + "Getting pdf Array");
			return new ResponseEntity<>(pdfResponseDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(new PDFResponseDTO(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error(stamp + "", e);
		}
		return new ResponseEntity<>(new PDFResponseDTO(),HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "getUsers", method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		long stamp = System.currentTimeMillis();
		try {
			log.info(stamp + "Inside get users Controller");
			//int invoiceNo = pdfInvoiceService.getPDFInvoiceNumber(BookingNo);
			//if(invoiceNo!=0) {
				//log.info("Invoice Number from DB : "+ invoiceNo);	
				List<UserResponseDTO> userResponseDTO = userService.getUsers();
				if(userResponseDTO!=null) {
			log.info(userResponseDTO.get(0).getName() + "Getting users");
			return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(new UserResponseDTO(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error(stamp + "", e);
		}
		return new ResponseEntity<>(new UserResponseDTO(),HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "addUser", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> addUser(@RequestBody UserResponseDTO user) {
		long stamp = System.currentTimeMillis();
		try {
			log.info(stamp + "Inside add user Controller");
			//int invoiceNo = pdfInvoiceService.getPDFInvoiceNumber(BookingNo);
			//if(invoiceNo!=0) {
				//log.info("Invoice Number from DB : "+ invoiceNo);	
				UserMaster userResponseDTO = userService.addUsers(user);
				if(userResponseDTO!=null) {
			log.info(userResponseDTO.getName() + "inserted user Name");
			return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(new UserMaster(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error(stamp + "", e);
		}
		return new ResponseEntity<>(new UserMaster(),HttpStatus.BAD_REQUEST);
	}

}
