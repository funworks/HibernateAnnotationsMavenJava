package com.relationships.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="PERSON_ID")
	private Integer id;
	
	@Column (name="NAME", nullable=false, length=20)
	private String name;
	
	//One to One Mapping to another table
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="PASSPORT_NUMBER")
	private Passport passport;

	//One to One Mapping to same table
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="FATHER_ID")
	private Person father;
	
	//One to One Mapping to same table
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="MOTHER_ID")
	private Person mother;
	
	//Bidirectional One to Many Mapping (See "person" field in Car class)
	@OneToMany(fetch=FetchType.EAGER, mappedBy="person")
	private List<Car> cars = new ArrayList<Car>();
	
	//Unidirectional Many to Many relationship 
	@ManyToMany (cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Address> addresses = new ArrayList<Address>();
	
	//Bidirectional Many to Many relationship
	@ManyToMany (cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Skill> skills = new ArrayList<Skill>();
	
	public Person() {
		
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public Person(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}

	public Person(String name, Passport passport, Person father, Person mother) {
		super();
		this.name = name;
		this.passport = passport;
		this.father = father;
		this.mother = mother;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	public void addSkill(Skill skill) {
		skills.add(skill);
		skill.getPersons().add(this);
	}

}
