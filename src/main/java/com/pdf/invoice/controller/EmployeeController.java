package com.pdf.invoice.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pdf.invoice.entity.EmailDetails;
import com.pdf.invoice.entity.UserMaster;
import com.pdf.invoice.model.UserResponseDTO;
import com.pdf.invoice.service.EmployeeService;



@Controller
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class EmployeeController {
	
	@Autowired
	EmployeeService userService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }
	
	@RequestMapping({"/welcome","/","/home"})
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping({"/contactus"})
	public ModelAndView contactUS() {
		ModelAndView mav = new ModelAndView("contactus");
		EmailDetails emaildetails = new EmailDetails();
		mav.addObject("details", emaildetails);
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("list-employees");
		mav.addObject("employees", userService.getUsers());
		return mav;
	}
	
	@GetMapping("/addEmployeeForm")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("add-employee-form");
		UserResponseDTO newEmployee = new UserResponseDTO();
		mav.addObject("employee", newEmployee);
		return mav;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute UserResponseDTO employee) throws IOException {
		userService.addUsers(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Integer employeeId) {
		ModelAndView mav = new ModelAndView("add-employee-form");
		UserMaster employee = userService.findById(employeeId).get();
		mav.addObject("employee", employee);
		return mav;
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Integer employeeId) {
		userService.deleteById(employeeId);
		return "redirect:/list";
	}
}