package com.test.hibernate_modules;
import java.util.*;
import java.io.*;

import java.sql.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ServiceClass{
	public void createPerson(Person person){
		Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		try{
			transaction = session.beginTransaction();
			session.save(person);
			transaction.commit();
			System.out.println("Person Created");
		}catch(Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		session.close();
	}

	public void updatePerson(long id, String firstName){
		Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		Person person = session.get(Person.class, id);
		try{
			transaction = session.beginTransaction();
			person.setFirstName(firstName);
			session.update(person);
			transaction.commit();
			System.out.println("Person Updated");
		}catch(Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		session.close();
	}

	public Person getPersonId(long id){
		Transaction transaction = null;
		Person person = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		try{
			transaction = session.beginTransaction();
			person = session.get(Person.class, id);
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		return person;
	}

	

	public void deletePerson(long id){
		Transaction transaction = null;
		Person person = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		try{
			transaction = session.beginTransaction();
			person = session.get(Person.class, id);
			if(person != null){
				session.delete(person);
				System.out.println("Person Deleted");
			}
			transaction.commit();
		}catch(Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		session.close();
		
	}

	public void saveRole(Role role){
		Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		try{
			transaction = session.beginTransaction();
			session.save(role);
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		session.close();
	}

	public void updateRole(long id, String role_update){
		Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		Role role = session.get(Role.class, id);
		try{
			transaction = session.beginTransaction();
			role.setRole(role_update);
			session.update(role);
			transaction.commit();
			//System.out.println("Person Updated");
		}catch(Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		session.close();
	}


	public void deleteRole(long id){
		Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		Role role = session.get(Role.class, id);
		
		try{
			transaction = session.beginTransaction();
			Set<Person> roleSet = role.getPerson();
			for(Person person : roleSet){
				person.getRoles().remove(role);
				session.update(person);
			}
			session.delete(role);
			transaction.commit();
		}catch(Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		session.close();
		
	}

	public Role getRoleId(long id){
		Transaction transaction = null;
		Role role = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		try{
			transaction = session.beginTransaction();
			role = session.get(Role.class, id);
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null){
				transaction.rollback();
			}
		}
		return role;
	}




}