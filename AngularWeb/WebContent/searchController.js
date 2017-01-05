var myApp = angular.module('myApp', []);

/*myApp.config(function($routeProvider) {
	$routeProvider
		.when("/",
				{
					controller: "search",
					templateUrl: "index.html"
				})
		.when("/busdetails",
				{
					controller: "search",
					templateUrl: "busDetails.html"
				})
		.otherwise({redirectTo: "/"})
	
});
*/
myApp.controller("search", function($scope,$http,$window) {
	$scope.busList=null;
	$scope.isEmpty=true;
    $scope.find = function() {
    	if($scope.origin==null || $scope.destination==null)
    		{
    		alert("Please provide your Origin and Destination");
    		return;
    		}
        $http.get('http://localhost:8080/SpringApp/buslist/'+$scope.origin+"/"+$scope.destination).
        success(function(data) 
        {
            $scope.busList = data;
            if($scope.isEmpty(data))
            	alert("No buses in this route");
        }
        );
    }
    $scope.isEmpty = function(obj) {
    	  for(var prop in obj) {
    	      if(obj.hasOwnProperty(prop))
    	          return false;
    	  }
    	  return true;
    	};   
});