package com.pdf.invoice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdf.invoice.entity.InvoiceHeader;
@Repository
public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, Long>{
	
	//@Query("SELECT i FROM InvoiceHeader i  WHERE i.organizationID =:organizationID AND i.bookingNo = :bookingNo")
	//InvoiceHeader findByOrganizationIDandBookingNo(@Param("organizationID") int organizationID, @Param("bookingNo") String bookingNo);
	InvoiceHeader findByBookingNo(String bookingNo) throws Exception;

}
