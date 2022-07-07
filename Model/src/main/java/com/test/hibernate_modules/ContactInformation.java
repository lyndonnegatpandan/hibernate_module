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
@Table(name="contact_information")
public class ContactInformation{

	@Id
	@Column(name="contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="mobile_num")
	private String mobileNumber;

	@ManyToOne
	@JoinColumn(name="person_id", insertable=true, updatable=true)
	private Person person;

	public ContactInformation(){
		super();
	}

	public ContactInformation(String mobileNumber, Person person){
		super();
		this.mobileNumber = mobileNumber;
		this.person = person;
	}

	public long getId(){
		return this.id;
	}

	public void setId(long id){
		this.id = id;
	}

	public Person getPerson(){
		return this.person;
	}

	public void setPerson(Person person){
		this.person = person;
	}


}