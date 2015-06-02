'use strict';

var app = angular.module('desappGrupoaFrontendApp', ['ngRoute']);


//////////////////////////////////////////
///////// ROUTES
//////////////////////////////////////////

app.config(['$routeProvider', function ($routeProvider) {
    
    $routeProvider.
        when('/Home', {
          templateUrl: 'views/home.html'
        }).
        when('/CreatePatient', {
          templateUrl: 'views/create-patient.html',
          controller: 'CreatePatientController'
        }).
        when('/SearchPatient/:search?', {
          templateUrl: 'views/search-patient.html',
          controller: 'SearchPatientController'
        }).
        when('/ModifyPatient/:id', {
          templateUrl: 'views/modify-patient.html',
          controller: 'ModifyPatientController'
        }).
        when('/MedicalRecord/:patientId', {
          templateUrl: 'views/medical-record.html',
          controller: 'MedicalRecordController'
        }).
        when('/Diagnose/:patientId/ChooseSymptoms', {
          templateUrl: 'views/choose-symptoms.html',
          controller: 'ChooseSymptomsController'
        }).
        otherwise({
          redirectTo: '/Home'
      });

}]);



//////////////////////////////////////////
///////// CONTROLLERS
//////////////////////////////////////////

app.controller('CreatePatientController', ['$scope', '$http', function($scope, $http) {

  $scope.create = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/patients/create', $scope.newPatient).
      success(function() {
        $scope.newPatient = null;
      });
  };
  
}]);


app.controller('SearchPatientController', ['$scope', '$http', '$routeParams', 'LastSearchService', function($scope, $http, $routeParams, LastSearchService) { 

  LastSearchService.save($routeParams.search);
  $scope.last_search = LastSearchService.get();

  $scope.list = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/patients/list').
      success(function(data) {
        $scope.patients = data;
      });
  };

  $scope.list();
  
}]);


app.controller('ModifyPatientController', ['$scope', '$http', '$routeParams', 'LastSearchService', function($scope, $http, $routeParams, LastSearchService) { 

  $scope.last_search = LastSearchService.get();

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

  $scope.patient();

}]);


app.controller('MedicalRecordController', ['$scope', '$http', '$routeParams', 'LastSearchService', function($scope, $http, $routeParams, LastSearchService) { 

  $scope.last_search = LastSearchService.get();

  $scope.medicalRecord = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/records/' + $routeParams.patientId).
      success(function(data) {
        $scope.medicalRecord = data;
      });
  };

  $scope.patient = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/patients/' + $routeParams.patientId).
      success(function(data) {
        $scope.patient = data;
      });
  };

  $scope.patient();
  $scope.medicalRecord();

}]);


app.controller('ChooseSymptomsController', ['$scope', '$http', '$routeParams', 'LastSearchService', 'PatientDiagnoseID', function($scope, $http, $routeParams, LastSearchService, PatientDiagnoseID) { 

  $scope.patient_id = PatientDiagnoseID.save($routeParams.patientId);
  $scope.last_search = LastSearchService.get();

  $scope.getSymptoms = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/symptoms/list').
      success(function(data) {
        $scope.symptoms = data;
      });
  };

  $scope.getSymptoms();

}]);


//////////////////////////////////////////
///////// SERVICES
//////////////////////////////////////////

app.service('LastSearchService', function() {
  
  var lastSearch;

  this.get = function() {
    return lastSearch;
  }

  this.save = function(search) {
    lastSearch = search;
  }

});


app.service('PatientDiagnoseID', function() {
  
  var patientID;

  this.get = function() {
    return patientID;
  }

  this.save = function(id) {
    patientID = id;
  }

});
