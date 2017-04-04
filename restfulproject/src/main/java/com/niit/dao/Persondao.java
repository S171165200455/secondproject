package com.niit.dao;

import com.niit.restmodel.Person;

public interface Persondao {

	Person addperson(Person person);

	Person getperson(int personId);

	Person updateperson(Person person);

	void deleteperson(int personId);

	
}
