package com.relationships.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	@Column (name="ADDRESS_ID", nullable=false)
	private Integer id;
	
	@Column (name="ADDRESS")
	private String addr;

	public Address() {
		super();
	}

	public Address(String addr) {
		super();
		this.addr = addr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	

}
