'use strict';

var app = angular.module('desappGrupoaFrontendApp', ['ngRoute', 'ngResource']);

app.config(['$httpProvider', '$routeProvider', function ($httpProvider, $routeProvider) {

    $httpProvider.defaults.headers.common['Content-Type'] = 'application/json';
    
    $routeProvider.
      	when('/Home', {
        	templateUrl: 'views/home.html'
      	}).
      	when('/CreatePatient', {
        	templateUrl: 'views/create-patient.html',
        	controller: 'CreatePatientController'
      	}).
        when('/SearchPatient', {
          templateUrl: 'views/search-patient.html',
          controller: 'SearchPatientController',
        }).
      	otherwise({
        	redirectTo: '/Home'
    	});

}]);


app.controller('CreatePatientController', ['$scope', '$http', '$resource', function($scope, $http, $resource) {

	$scope.create = function() {
		var req = $resource('http://localhost:8080/desapp-groupa-backend/rest/patients/create');
		req.save($scope.newPatient);
	};
	
}]);


app.controller('SearchPatientController', ['$scope', '$http', function($scope, $http) {	
	
  $scope.list = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/patients/list').
      success(function(data) {
        $scope.patients = data;
      });
  };

  $scope.list();

}]);

