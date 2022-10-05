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
@Table(name = "PDF_USER")
@Getter
@Setter
@NoArgsConstructor
public class UserMaster {
	
	@Id
	@Column(name="Id", insertable=true, updatable=true)
	private int id;
	
	@Column(name="Name",insertable=true, updatable=true)
	private String name;
	
	@Column(name="Mobile",insertable=true, updatable=true)
	private String mobile;
	
	@Column(name="City",insertable=true, updatable=true)
	private String city;
	
	@Column(name="Password",insertable=true, updatable=true)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
