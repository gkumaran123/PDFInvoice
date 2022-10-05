package com.pdf.invoice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdf.invoice.entity.GlobalMaster;

public interface GlobalMasterRepository extends JpaRepository<GlobalMaster, Long>{
	GlobalMaster findByCode(String code) throws Exception;

}
