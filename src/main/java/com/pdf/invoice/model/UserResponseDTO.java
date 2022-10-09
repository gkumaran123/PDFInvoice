package com.pdf.invoice.model;

import lombok.Getter;
import lombok.Setter;


public class UserResponseDTO {
	private int Id;
	private String name;
	private String mobile;
	private String city;
	private String email;
	@Override
	public String toString() {
		return "UserResponseDTO [Id=" + Id + ", name=" + name + ", mobile=" + mobile + ", city=" + city + ", email="
				+ email + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
