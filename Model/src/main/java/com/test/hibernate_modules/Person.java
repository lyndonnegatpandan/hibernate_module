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
@Table(name="person")
public class Person{

	@Id
	@Column(name="person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;


	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name = "person_roles",
		joinColumns = {
			@JoinColumn(name = "person_id")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "role_id")
		}
		)
	private Set < Role > roles = new HashSet<Role>();
	

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<ContactInformation> contactInfo = new ArrayList<>();




	public Person(){
		super();
	}

	public Person(String firstName, String lastName){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId(){
		return personId;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public Set < Role > getRoles(){
		return roles;
	}
	public void setRoles(Set < Role > roles){
		this.roles=roles;
	}
	

	public void setContactInfo(List<ContactInformation> contactInfo){
		this.contactInfo = contactInfo;
	}

	public List<ContactInformation> getContactInfo(){
		return this.contactInfo;
	}

	@Override
	public String toString(){
		return "Person = " + this.firstName+ " "+ this.lastName;
	}

	

}