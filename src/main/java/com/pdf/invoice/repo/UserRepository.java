package com.pdf.invoice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdf.invoice.entity.GlobalMaster;
import com.pdf.invoice.entity.UserMaster;

public interface UserRepository extends JpaRepository<UserMaster, Integer>{
	List<UserMaster> findAll();

}
