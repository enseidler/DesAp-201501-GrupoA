'use strict';

var app = angular.module('desappGrupoaFrontendApp', ['ngRoute', 'ngResource']);

app.config(['$httpProvider', '$routeProvider', function ($httpProvider, $routeProvider) {

    $httpProvider.defaults.headers.common['Content-Type'] = 'application/json';
    
    $routeProvider.
      	when('/CreatePatient', {
        	templateUrl: 'views/create-patient.html',
        	controller: 'CreatePatientController'
      	}).
      	when('/ModifyPatient', {
        	templateUrl: 'views/modify-patient.html',
        	controller: 'ModifyPatientController'
      	}).
      	otherwise({
        	redirectTo: '/'
    	});

}]);



app.controller('CreatePatientController', ['$scope', '$http', '$resource', function($scope, $http, $resource) {

	$scope.create = function() {
		var req = $resource('http://localhost:8080/desapp-groupa-backend/rest/patients/create');
		req.save($scope.newPatient);
	};
	
}]);


app.controller('ModifyPatientController', ['$scope', '$http', function($scope, $http) {	
	
}]);