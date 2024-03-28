package com.dantes.demo.entities;

import java.sql.Date;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

// mandatory annotation 

@Component

public class Vendor {

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getContactPerson() {
		return ContactPerson;
	}

	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegDate() {
		return RegDate;
	}

	public void setRegDate(Date regDate) {
		RegDate = regDate;
	}

//	@Setter
//	@Getter
	private String Code;
//	@Setter
//	@Getter
	private String CompanyName;
//	@Setter
//	@Getter
	private String ContactPerson;
//	@Setter
//	@Getter
	private String FirstName;
//	@Setter
//	@Getter
	private String LastName;
//	@Setter
//	@Getter
	private String Website;
//	@Setter
//	@Getter
	private String email;
//	@Setter
//	@Getter
	private String status;
//	@Setter
//	@Getter
	private Date RegDate;

//	public Vendor(String code, String companyName, String contactPerson, String firstName, String lastName,
//			String website, String email, String status, Date regDate) {

	public Vendor() {
		super();

// In the following Order the output items will be displayed 
		this.Code = "Vendor_1";
		this.CompanyName = "Nephra Proxim";
		this.ContactPerson = "Alec";
		this.FirstName = "Jaques";
		this.LastName = "Lexine";
		this.Website = "www.google.com";
		this.email = "arya_stark@nep.com";
		this.status = "A";

//		email = "arya_stark@nep.com";
//		status = "A";
//		Code = "Vendor_1";
//		CompanyName = "Nephra Proxim";
//		ContactPerson = "Alec";
//		FirstName = "Jaques";
//		LastName = "Lexine";
//		Website = "www.google.com";
//		RegDate = new Date(0);

		this.RegDate = new Date(0);
	}

	@Override
	public String toString() {
		return "Vendor" + "[Code=" + Code + ", " + "CompanyName=" + CompanyName + ", " + "ContactPerson="
				+ ContactPerson + "," + "FirstName=" + FirstName + ", " + "LastName=" + LastName + ", " + "Website="
				+ Website + ", " + "email=" + email + "," + "status=" + status + ", " + "RegDate=" + RegDate + "]";
	}

}
