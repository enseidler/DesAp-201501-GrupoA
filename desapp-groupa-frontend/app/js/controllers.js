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
        when('/MedicalRecord/:patientId/CreateAllergy', {
          templateUrl: 'views/create-allergy.html',
          controller: 'CreateAllergyController'
        }).
        when('/MedicalRecord/:patientId/CreateDisease', {
          templateUrl: 'views/create-disease.html',
          controller: 'CreateDiseaseController'
        }).
        when('/Diagnose/CreateSymptom', {
          templateUrl: 'views/create-symptom.html',
          controller: 'CreateSymptomController'
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
      });
  };
}]);


app.controller('SearchPatientController', ['$scope', '$http', '$routeParams', 'LastSearchService', 'CurrentSymptoms', function($scope, $http, $routeParams, LastSearchService, CurrentSymptoms) { 

  LastSearchService.save($routeParams.search);
  $scope.last_search = LastSearchService.get();
  CurrentSymptoms.resetSymptoms();

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

  $scope.loadMedicalRecord = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/records/' + $routeParams.patientId).
      success(function(data) {
        $scope.medicalRecord = data;
      });
  };

  $scope.loadPatient = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/patients/' + $routeParams.patientId).
      success(function(data) {
        $scope.patient = data;
      });
  };

  $scope.allergiesList = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/drugs/list').
      success(function(data) {
        $scope.allergies = data;
      });
  };

  $scope.addAllergy = function(allergy) {
    $http.put('http://localhost:8080/desapp-groupa-backend/rest/records/' + $routeParams.patientId + '/addAllergy', allergy).
      success(function(data) {
        $scope.loadMedicalRecord();
        $scope.allergiesList();
      });      
  };

  $scope.deleteAllergy = function(allergy) {
    $http.delete('http://localhost:8080/desapp-groupa-backend/rest/records/' + $routeParams.patientId + '/deleteAllergy/'+ allergy.id).
      success(function(data) {
        $scope.loadMedicalRecord();
        $scope.allergiesList();
      });      
  };

  $scope.diseasesList = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/diseases/list').
      success(function(data) {
        $scope.diseases = data;
      });
  };

  $scope.addDisease = function(disease) {
    $http.put('http://localhost:8080/desapp-groupa-backend/rest/records/' + $routeParams.patientId + '/addDisease', disease).
      success(function(data) {
        $scope.loadMedicalRecord();
        $scope.diseasesList();
      });      
  };

  $scope.deleteDisease = function(disease) {
    $http.delete('http://localhost:8080/desapp-groupa-backend/rest/records/' + $routeParams.patientId + '/deleteDisease/'+ disease.id).
      success(function(data) {
        $scope.loadMedicalRecord();
        $scope.diseasesList();
      });      
  };



  $scope.loadPatient();
  $scope.loadMedicalRecord();
  $scope.allergiesList();
  $scope.diseasesList();

}]);


app.controller('ChooseSymptomsController', ['$scope', '$http', '$routeParams', 'LastSearchService', 'PatientDiagnoseID', 'CurrentSymptoms', function($scope, $http, $routeParams, LastSearchService, PatientDiagnoseID, CurrentSymptoms) { 

  $scope.last_search = LastSearchService.get();
  PatientDiagnoseID.save($routeParams.patientId);
  $scope.patient_id = PatientDiagnoseID.get();

  $scope.currentSymptoms = CurrentSymptoms.get();

  $scope.getSymptoms = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/symptoms/list').
      success(function(data) {
        $scope.symptoms = data;
      });
  };

  $scope.chooseSymptom = function(symptom) {
    $scope.currentSymptoms.addIfNotExist(symptom);
    CurrentSymptoms.save($scope.currentSymptoms);
  }

  $scope.removeSymptom = function(symptom) {
    $scope.currentSymptoms.removeIfExist(symptom);
    CurrentSymptoms.save($scope.currentSymptoms);
  }

  $scope.removeCurrentSymptoms = function() {
    $scope.currentSymptoms = [];
    CurrentSymptoms.save($scope.currentSymptoms);
  }

  $scope.getSymptoms();

}]);

app.controller('CreateAllergyController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {

  $scope.patientId = $routeParams.patientId;
  
  $scope.create = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/drugs/create', $scope.newAllergy).
      success(function() {
      });
  };

}]);


app.controller('CreateDiseaseController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {

  $scope.last_search = LastSearchService.get();
  $scope.patientId = $routeParams.patientId;
  
  $scope.create = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/diseases/create', $scope.newDisease).
      success(function() {
      });
  };

}]);

app.controller('CreateSymptomController', ['$scope', '$http', '$routeParams', 'PatientDiagnoseID', function($scope, $http, $routeParams, PatientDiagnoseID) {

  $scope.patient_id = PatientDiagnoseID.get();

  $scope.create = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/symptoms/create', $scope.newSymptom).
      success(function() {
      });
  };

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

app.service('CurrentSymptoms', function() {
  
  var _symptoms = [];

  this.get = function() {
    return _symptoms;
  }

  this.save = function(symptoms) {
    _symptoms = symptoms;
  }

  this.resetSymptoms = function() {
    _symptoms = [];
  }

});
