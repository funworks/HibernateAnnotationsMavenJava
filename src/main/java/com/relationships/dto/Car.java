package com.relationships.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="CAR")
public class Car {
	
	@Id
	@GeneratedValue
	@Column(name="CAR_ID")
	private Integer id;
	
	@Column(name="REGISTRATION_NUMBER", nullable=false, length=30)
	private String registrationNumber;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "PERSON_ID")
	private Person person;

	public Car() {
		super();
	}
	
	public Car(String registrationNumber) {
		super();
		this.registrationNumber = registrationNumber;
	}

	public Car(String registrationNumber, Person person) {
		super();
		this.registrationNumber = registrationNumber;
		this.person = person;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
