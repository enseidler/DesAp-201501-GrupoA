'use strict';

var app = angular.module('desappGrupoaFrontendApp', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
    
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
          controller: 'SearchPatientController'
        }).
        when('/ModifyPatient/:id', {
          templateUrl: 'views/modify-patient.html',
          controller: 'ModifyPatientController'
        }).
      	otherwise({
        	redirectTo: '/Home'
    	});

}]);


app.controller('MainController', ['$scope', function($scope) {

  $scope.mkSearch = function() {
    $scope.final_search = $scope.search_text;
  };
  
}]);


app.controller('CreatePatientController', ['$scope', '$http', function($scope, $http) {

  $scope.create = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/patients/create', $scope.newPatient).
      success(function() {
        $scope.newPatient = null;
      });
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


app.controller('ModifyPatientController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams) { 
  
  $scope.modify = function() {
    $http.put('http://localhost:8080/desapp-groupa-backend/rest/patients/modify', $scope.modPatient).
      success(function(data) {
        
      });
  };

  $scope.patient = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/patients/' + $routeParams.id).
      success(function(data) {
        $scope.modPatient = data;
      });
  };

  $scope.patient()


  
}]);