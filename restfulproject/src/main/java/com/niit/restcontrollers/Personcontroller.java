package com.niit.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.Persondao;
import com.niit.restmodel.Errormessage;
import com.niit.restmodel.Person;

@RestController
public class Personcontroller {
	@Autowired
	private Persondao persondao;
	@RequestMapping(name="/addperson", method=RequestMethod.POST)
public Person savePerson(@RequestBody Person person)
{
		
		
	return persondao.addperson(person);
}

	@RequestMapping(value="/getperson/{personId}", method=RequestMethod.GET)
public ResponseEntity<?> getPersonbyId(@PathVariable(value="personId") int personId  )
{
		
		Person person=persondao.getperson(personId);
		if(person==null)
		{
		Errormessage error=new Errormessage(1,"personId ["+personId +"]" +"doesnot exists");
		return new ResponseEntity<Errormessage>(error,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Person>(person,HttpStatus.OK);
 }
	
	@RequestMapping(value="/updateperson", method=RequestMethod.PUT)
	public ResponseEntity<Person> updateperson(@RequestBody Person person)
	{
			
		Person updatedperson=persondao.updateperson(person);
		return new ResponseEntity<Person>(updatedperson,HttpStatus.OK);
}
	
	@RequestMapping(value="/deleteperson/{personId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteperson(@PathVariable(value="personId") int personId  ){
		Person person=persondao.getperson(personId);
		if(person==null)
		{
			Errormessage error=new Errormessage(1,"personId ["+personId +"]" +"doesnot exists");
			return new ResponseEntity<Errormessage>(error,HttpStatus.NOT_FOUND);
		}
		persondao.deleteperson(personId);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		
}

}
