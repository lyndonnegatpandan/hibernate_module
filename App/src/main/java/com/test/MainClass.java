package com.test.hibernate_modules;
import java.util.*;
import java.io.*;

import java.sql.*;
import org.hibernate.Session;

public class MainClass{

	public static void main (String args[]){
		ServiceClass service = new ServiceClass();
		Role roleService = new Role();
		
	
		Person person = new Person("Lyndonne", "Gatpandan");
		Person person1 = new Person("Juan", "Dela Cruz");
		Person person2 = new Person("Alex", "Timberlake");


		ContactInformation contactInformation = new ContactInformation("0912344521", person);
		ContactInformation contactInformation1 = new ContactInformation("091909090", person);
		ContactInformation contactInformation2 = new ContactInformation("0928988770", person1);

		Role role1 = new Role("User");
		Role role2 = new Role("Admin");

		person.getContactInfo().add(contactInformation);
		person.getContactInfo().add(contactInformation1);
		person1.getContactInfo().add(contactInformation2);

		person.getRoles().add(role1);
		person.getRoles().add(role2);
		person1.getRoles().add(role2);

		service.saveRole(role1);
		service.saveRole(role2);

		service.createPerson(person);
		service.createPerson(person1);
		service.createPerson(person2);

		service.deleteRole(1);
		service.deletePerson(3);

		service.updatePerson(2, "Mark");
		service.updateRole(2, "Administrator");

		System.out.println(service.getPersonId(1));
		System.out.println(service.getRoleId(2));


		


	}
}