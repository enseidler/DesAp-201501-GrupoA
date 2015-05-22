'use strict';

var app = angular.module('desappGrupoaFrontendApp', []);

app.config(['$httpProvider', function ($httpProvider) {

    $httpProvider.defaults.headers.common['Content-Type'] = 'application/json';
    
}]);

app.controller('PatientsController', ['$scope', '$http', function($scope, $http) {

	$scope.patient = {
        "height": 1.81,
        "weight": 74.5,
        "name": "Ezequiel",
        "password": "e36396386",
        "surname": "Seidler",
        "dni": 36396386
    };

	$scope.create = function() {
		
        //$http(req).success(function(){}).error(function(){});
        //$http.get('http://localhost:8080/desapp-groupa-backend/rest/patients/list').
        $http.post('http://localhost:8080/desapp-groupa-backend/rest/patients/create', $scope.patient).
		  success(function(data, status, headers, config) {
		    // this callback will be called asynchronously
		    // when the response is available
		  }).
		  error(function(data, status, headers, config) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });

	};
	
	
	
}]);