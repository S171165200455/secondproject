package com.niit.dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.restmodel.Person;
@Repository
public class PersondaoImpl implements Persondao {
	
	@Autowired
	private SessionFactory sessionfactory;
	public Person addperson(Person person)
	{
		Session session=sessionfactory.openSession();
	
		Transaction trans=session.beginTransaction();
		session.save(person);
		trans.commit();
		session.close();
		return person;
		
	}
	
	
	public Person getperson(int personId)
	{
		Session session=sessionfactory.openSession();
		Transaction trans1=session.beginTransaction();
		Person person=(Person)session.get(Person.class,personId);
		trans1.commit();
		session.close();
		return person;
	}
	
	public Person updateperson(Person person){
		Session session=sessionfactory.openSession();
		Transaction trans1=session.beginTransaction();
		session.saveOrUpdate(person);
		trans1.commit();
		session.close();
		return person;
		
		
		
}


	
	public void deleteperson(int personId) {
		Session session=sessionfactory.openSession();
		Transaction trans1=session.beginTransaction();
	Person person=(Person)session.get(Person.class,personId);
	session.delete(person);
		trans1.commit();
		session.close();

		
	}
}
