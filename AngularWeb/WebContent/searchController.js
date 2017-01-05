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
myApp.controller("search", function($scope,$http) {
	$scope.busList=null;
	$scope.isEmpty=true;
    $scope.find = function() {
        $http.get('http://localhost:8080/SpringApp/buslist/'+$scope.origin+"/"+$scope.destination).
        success(function(data) {
            $scope.busList = data;
        });
    }
    $scope.isEmpty = function(obj,$window) {
    	  for(var prop in obj) {
    	      if(obj.hasOwnProperty(prop))
    	          return false;
    	  }
    	  $window.alert("No buses");
    	  return true;
    	};  
});