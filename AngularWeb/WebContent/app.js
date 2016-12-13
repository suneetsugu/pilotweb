function Fetch($scope, $http) {
    $http.get('http://localhost:8080/SpringApp/buslist').
        success(function(data) {
            $scope.busList = data;
        });
}