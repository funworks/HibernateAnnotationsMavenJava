package com.relationships.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;

@Entity
public class Passport {
	
	@Id
	@NaturalId (mutable=false)
	@Column (name="PASSPORT_NUMBER", unique=true, nullable=false, length=8)
	private String passportNumber;
	
	@Column (name="ISSUED_AT", nullable=false, length=20)
	private String issuedAt;
	
	@Column (name="ISSUE_DATE", nullable=false)
	@Temporal (TemporalType.DATE)
	private Date issueDate;
	
	@Column (name="EXPIRY_DATE", nullable=false)
	@Temporal (TemporalType.DATE)
	private Date expiryDate;
	
	public Passport() {
		
	}
	
	public Passport(String passportNumber, String issuedAt, Date issueDate, Date expiryDate) {
		super();
		this.passportNumber = passportNumber;
		this.issuedAt = issuedAt;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(String issuedAt) {
		this.issuedAt = issuedAt;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
