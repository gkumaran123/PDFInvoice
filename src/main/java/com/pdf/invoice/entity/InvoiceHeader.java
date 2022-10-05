package com.pdf.invoice.entity;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "INVOICEHEADER")
@Getter
@Setter
@NoArgsConstructor
public class InvoiceHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="INVOICEHEADERID", insertable=false, updatable=false)
	private Long invoiceHeaderID;
	
	@Column(name="INVOICENO", insertable=false, updatable=false)
	private Integer invoiceNo;
	
	//@Column(name="OrganizationID",insertable=false, updatable=false)
	private Integer organizationID;
	
	@Column(name="BOOKINGNO",insertable=false, updatable=false)
	private String bookingNo;

}