var app = angular.module('myApp', []);
app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.timeout = 20000;
}])


app.controller('myCtrl', function($scope, $http) {
    this.retrieve = function() {
    $http.get('http://127.0.0.1:8761/api/stock-service/rest/stack/' + $scope.name )
    .then(function (response) {
		 
        console.log('inside'+ response);
        $scope.quotes = response.data;
    }, function (response) {
		
        console.log('came here'+response.data);
    });
    }


    this.add = function() {
        var message = {
            userName: $scope.name,
            quote: [$scope.quote]
        }
        $http.post('http://127.0.0.1:8761/api/db-service/rest/db/addUser', message,{
		headers: { 'Content-Type': 'application/json'}
		})
            .then(function(response) {
                $scope.quotes = response.data;
            }, function(response) {
                console.log('error..');
            });
    }
});