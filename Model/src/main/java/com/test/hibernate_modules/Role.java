package com.test.hibernate_modules;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.*;

@Entity 
@Table(name="role")	
public class Role{
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long role_id;

	@Column(name="role")
	private String role;


	
	@ManyToMany(mappedBy="roles", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set < Person > persons = new HashSet<>();


	public Role(){
		super();
	}

	public Role(String role){
		super();
		this.role = role;
		
	}

	public long getId(){
		return role_id;
	}

	public String getRole(){
		return role;
	}


	public void setRole(String role){
		this.role = role;
	}

	public void setRoleId(long role_id){
		this.role_id = role_id;
	}

	

	public Set<Person> getPerson(){
		return persons;
	}

	public void setPerson(Set<Person> persons){
		this.persons = persons;
	}

	public void addPerson(Person person){
		this.persons.add(person);
	}
	public void removePerson(Person person){
		this.persons.remove(person);
	}

	@Override
	public String toString(){
		return "Role = " + this.role;
	}
	
}