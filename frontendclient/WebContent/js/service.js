app.factory('PersonService',function($http){
	var personService={}
	
	personService.getAllPersons=function(){
		return $http.get("http://localhost:9090/restfulproject/person");
	}
	personService.savePerson=function(person){
		return $http.post("http://localhost:9090/restfulproject/person",person);
	}
	
	personService.deletePerson=function(id){
		return $http['delete']("http://localhost:9090/restfulproject/person/"+id);
	}
	
	personService.getPersonById=function(id){
		return $http.get("http://localhost:9090/restfulproject/person/"+id);
	}
	
	personService.updatePerson=function(person){
		return $http.put("http://localhost:9090/restfulproject/person",person);
	}
	return  personService;
})