app.controller('EditController',function($scope,PersonService,$routeParams){
	var id=$routeParams.id;
	$scope.person=PersonService.getPersonById(id)
	.then(function(response){
		$scope.person=response.data;
		console.log(response.data);
	},function(response){
		console.log(response.status)
	})
})