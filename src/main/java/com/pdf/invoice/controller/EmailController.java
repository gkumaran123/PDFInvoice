package com.pdf.invoice.controller;
//Java Program to Create Rest Controller that
//Defines various API for Sending Mail


//Importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pdf.invoice.entity.EmailDetails;
import com.pdf.invoice.service.EmailService;

//Annotation
@Controller
//Class
public class EmailController {

	@Autowired private EmailService emailService;

	// Sending a simple Email
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute EmailDetails details, RedirectAttributes redirAttrs)
	{
		String status= emailService.sendSimpleMail(details);
		redirAttrs.addFlashAttribute("success", status);
		return "redirect:/contactus";
	}

	// Sending email with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(
		@RequestBody EmailDetails details)
	{
		//String status = emailService.sendMailWithAttachment(details);

		return "";
	}
}
