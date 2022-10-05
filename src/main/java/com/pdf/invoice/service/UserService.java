package com.pdf.invoice.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdf.invoice.entity.GlobalMaster;
import com.pdf.invoice.entity.InvoiceHeader;
import com.pdf.invoice.entity.UserMaster;
import com.pdf.invoice.model.PDFResponseDTO;
import com.pdf.invoice.model.UserResponseDTO;
import com.pdf.invoice.repo.GlobalMasterRepository;
import com.pdf.invoice.repo.InvoiceHeaderRepository;
import com.pdf.invoice.repo.UserRepository;

@Service
@Transactional
public class UserService {
	
	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	private String EBILLING_DOCUMENT_SERVER_PATH="EBILLING_DOCUMENT_SERVER_PATH";
	
	@Value("${pdf.location}")
    private String pdfLocation;
	
	@Autowired
	InvoiceHeaderRepository invoiceHeaderRepo;
	
	@Autowired
	GlobalMasterRepository globalMasterRepo;
	
	@Autowired
	UserRepository userRepo;

	public List<UserResponseDTO> getUsers() {
		
		List<UserMaster> usersResponse = new ArrayList<>();
		List<UserResponseDTO> usersList = new ArrayList<>();
		try {
			usersResponse = userRepo.findAll();
			
		 if(usersResponse!=null) {
			 usersList = getUsersList(usersResponse);
		 }
		} catch (Exception e) {
			log.error("", e);
		}
		
		return usersList;
	}

	private List<UserResponseDTO> getUsersList(List<UserMaster> usersResponse) {
		List<UserResponseDTO> users = new ArrayList<>();
		usersResponse.forEach(user->{
			UserResponseDTO UserResponseDTO = new UserResponseDTO();	
			UserResponseDTO.setId(user.getId());
			System.out.println(user.getName()+" : Name");
			UserResponseDTO.setName(user.getName());
			UserResponseDTO.setMobile(user.getMobile());
			UserResponseDTO.setCity(user.getCity());
			UserResponseDTO.setPassword(user.getPassword());
			users.add(UserResponseDTO);
		});
		return users;
	}

	public UserMaster addUsers(UserResponseDTO user) {
		UserMaster userMaster = new UserMaster();
		System.out.println(user.toString());
		userMaster.setId(user.getId());
		userMaster.setName(user.getName());
		userMaster.setMobile(user.getMobile());
		userMaster.setCity(user.getCity());
		userMaster.setPassword(user.getPassword());
		
		return userRepo.save(userMaster);
	}

}
