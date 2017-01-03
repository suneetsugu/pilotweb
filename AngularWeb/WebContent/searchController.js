var myApp = angular.module('myApp', ["ngRoute"]);

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
	$scope.busList;
	$scope.showme=false;
    $scope.find = function() {
        $http.get('http://localhost:8080/SpringApp/buslist/'+$scope.origin+"/"+$scope.destination).
        success(function(data) {
            $scope.busList = data;
        });
    }
    $scope.toggle = function() 
    {
    	   $scope.showme = !$scope.showme;
    }    
});