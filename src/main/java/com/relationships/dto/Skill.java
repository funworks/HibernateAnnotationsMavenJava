package com.relationships.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Skill {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="SKILL_ID")
	private Integer id;
	
	@Column(name="SKILL_NAME", nullable=false, length=30)
	private String name;
	
	@ManyToMany (mappedBy="skills")
	private List<Person> persons = new ArrayList<Person>();
	
	public Skill() {
		
	}
	
	public Skill(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
