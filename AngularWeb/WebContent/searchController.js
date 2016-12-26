angular.module('myApp', []).controller('search', function($scope,$http) {
	$scope.busList;
    $scope.find = function() {
        $http.get('http://localhost:8080/SpringApp/buslist/'+$scope.origin+"/"+$scope.destination).
        success(function(data) {
            $scope.busList = data;
        });
    }
});