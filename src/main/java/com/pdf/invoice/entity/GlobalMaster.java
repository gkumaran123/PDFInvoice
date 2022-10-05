package com.pdf.invoice.entity;

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
@Table(name = "GLOBALMASTER")
@Getter
@Setter
@NoArgsConstructor
public class GlobalMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", insertable=false, updatable=false)
	private Long id;
	
	@Column(name="CODE",insertable=false, updatable=false)
	private String code;
	
	@Column(name="VALUE",insertable=false, updatable=false)
	private String value;
	
	@Column(name="REMARKS",insertable=false, updatable=false)
	private String remarks;

}
