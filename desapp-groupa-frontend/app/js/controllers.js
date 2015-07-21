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
        when('/Diagnose', {
          templateUrl: 'views/diagnose.html',
          controller: 'DiagnoseController'
        }).
        when('/Treatment/:patientId/:diseaseId', {
          templateUrl: 'views/treatment.html',
          controller: 'TreatmentController'
        }).
        otherwise({
          redirectTo: '/Home'
      });
}]);



//////////////////////////////////////////
///////// CONTROLLERS
//////////////////////////////////////////

app.controller('CreatePatientController', ['$scope', '$http', '$location', function($scope, $http, $location) {

  $scope.create = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/patients/create', $scope.newPatient).
      success(function() {
        $location.path('/SearchPatient');
        successAlert("Patient [" + $scope.newPatient.name + " " + $scope.newPatient.surname + "] has been created successfuly");
      }).
      error(function() {
        errorAlert("An error occurred while trying to create the patient [" + $scope.newPatient.name + " " + $scope.newPatient.surname + "]. Try later");
      });
  };
}]);


app.controller('SearchPatientController', ['$scope', '$http', '$routeParams', 'LastSearchService', 'CurrentSymptoms', function($scope, $http, $routeParams, LastSearchService, CurrentSymptoms) { 

  LastSearchService.save($routeParams.search);
  $scope.last_search = LastSearchService.get();
  CurrentSymptoms.resetSymptoms(); 
  $scope.patients = [];

  $scope.list = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/patients/list').
      success(function(data) {
        $scope.patients = data;
      }).
      error(function() {
        errorAlert("An error occurred while trying to search the patients. Try later");
      });
  };

  $scope.itemsPerPage = 4;
  $scope.currentPage = 0;
  
  $scope.prevPage = function() {
    if ($scope.currentPage > 0) {
      $scope.currentPage--;
    }
  };
  
  $scope.prevPageDisabled = function() {
    return $scope.currentPage === 0 ? "disabled" : "";
  };
  
  $scope.pageCount = function() {
    return Math.ceil($scope.patients.length/$scope.itemsPerPage)-1;
  };
  
  $scope.nextPage = function() {
  if ($scope.currentPage < $scope.pageCount()) {
    $scope.currentPage++;
    }
  };
  
  $scope.nextPageDisabled = function() {
    return $scope.currentPage === $scope.pageCount() ? "disabled" : "";
  };
  
  $scope.page = function(nPage) {
    $scope.currentPage = nPage;
  };
  
  $scope.numberPages = function(){
    var countData = $scope.patients.length;
    var countPages = 0;
  
    $scope.listPages = [];
    for (var i=0; i<countData; i = i+4) {
      $scope.listPages.push(countPages);
      countPages++;
    }
    return $scope.listPages;
  };


  $scope.list();
  
}]);

app.filter('offset', function() {
  return function(input, start) {
    start = parseInt(start, 10);
    return input.slice(start);
  };
});


app.controller('ModifyPatientController', ['$scope', '$http', '$routeParams', '$location', 'LastSearchService', function($scope, $http, $routeParams, $location, LastSearchService) { 

  $scope.last_search = LastSearchService.get();

  $scope.modify = function() {
    $http.put('http://localhost:8080/desapp-groupa-backend/rest/patients/modify', $scope.modPatient).
      success(function(data) {
        if(!angular.isUndefined($scope.last_search)) {
          $location.path('/SearchPatient/' + $scope.last_search);
        } else {
          $location.path('/SearchPatient/');
        }
        successAlert("Patient [" + $scope.newPatient.name + " " + $scope.newPatient.surname + "] has been modified successfuly");
      }).
      error(function() {
        errorAlert("An error occurred while trying to modify the patient [" + $scope.newPatient.name + " " + $scope.newPatient.surname + "]. Try later");
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
        successAlert("Drug [" + allergy.name + "] has been added to [" + $scope.patient.name + " " + $scope.patient.surname + "] medical record allergies");
      }).
      error(function() {
        errorAlert("An error occurred while trying to add the allergy to [" + allergy.name + "]. Try later");
      });     
  };

  $scope.deleteAllergy = function(allergy) {
    $http.put('http://localhost:8080/desapp-groupa-backend/rest/records/' + $routeParams.patientId + '/deleteAllergy/'+ allergy.id).
      success(function(data) {
        $scope.loadMedicalRecord();
        $scope.allergiesList();
        successAlert("Drug [" + allergy.name + "] has been deleted from [" + $scope.patient.name + " " + $scope.patient.surname + "] medical record allergies");
      }).
        error(function() {
        errorAlert("An error occurred while trying to delete the allergy to [" + allergy.name + "]. Try later");
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
        successAlert("Disease [" + disease.name + "] has been added to [" + $scope.patient.name + " " + $scope.patient.surname + "] medical record diseases");
      }).
      error(function() {
        errorAlert("An error occurred while trying to add the disease [" + disease.name + "]. Try later");
      });
  };

  $scope.deleteDisease = function(disease) {
    $http.put('http://localhost:8080/desapp-groupa-backend/rest/records/' + $routeParams.patientId + '/deleteDisease/'+ disease.id).
      success(function(data) {
        $scope.loadMedicalRecord();
        $scope.diseasesList();
        successAlert("Disease [" + disease.name + "] has been deleted from [" + $scope.patient.name + " " + $scope.patient.surname + "] medical record diseases");
      }).
      error(function() {
        errorAlert("An error occurred while trying to delete the disease [" + disease.name + "]. Try later");
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
  };

  $scope.removeSymptom = function(symptom) {
    $scope.currentSymptoms.removeIfExist(symptom);
    CurrentSymptoms.save($scope.currentSymptoms);
  };

  $scope.removeCurrentSymptoms = function() {
    $scope.currentSymptoms = [];
    CurrentSymptoms.save($scope.currentSymptoms);
  };

  $scope.noSymptomsChoosed = function() {
    return $scope.currentSymptoms.length == 0;
  };

  $scope.getSymptoms();

}]);

app.controller('CreateAllergyController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

  $scope.patient_id = $routeParams.patientId;
  
  $scope.create = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/drugs/create', $scope.newAllergy).
      success(function() {
        $location.path('/MedicalRecord/' + $scope.patient_id);
        successAlert("Drug [" + $scope.newAllergy.name + "] has been created successfuly");
      }).
      error(function() {
        errorAlert("An error occurred while trying to create the drug [" + $scope.newAllergy.name + "]. Try later");
      });
  };

}]);


app.controller('CreateDiseaseController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

  $scope.patient_id = $routeParams.patientId;
  
  $scope.create = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/diseases/create', $scope.newDisease).
      success(function() {
        $location.path('/MedicalRecord/' + $scope.patient_id);
        successAlert("Disease [" + $scope.newDisease.name + "] has been created successfuly");
      }).
      error(function() {
        errorAlert("An error occurred while trying to create the disease [" + $scope.newDisease.name + "]. Try later");
      });
  };

}]);


app.controller('CreateSymptomController', ['$scope', '$http', '$location', 'PatientDiagnoseID', function($scope, $http, $location, PatientDiagnoseID) {

  $scope.patient_id = PatientDiagnoseID.get();

  $scope.create = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/symptoms/create', $scope.newSymptom).
      success(function() {
        $location.path('/Diagnose/' + $scope.patient_id + '/ChooseSymptoms');
      });
  };

}]);


app.controller('DiagnoseController', ['$scope', '$http', 'PatientDiagnoseID', 'CurrentSymptoms', function($scope, $http, PatientDiagnoseID, CurrentSymptoms) {

  $scope.patient_id = PatientDiagnoseID.get();
  $scope.symptomsToDiagnose = CurrentSymptoms.get();

  $scope.diagnose = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/diagnose/diagnosedDiseases/' + $scope.collectIds()).
      success(function(data) {
        $scope.diagnosedDiseases = data;
      });
  };

  $scope.collectIds = function() {
    var idSymptoms = "";
    for (var i = $scope.symptomsToDiagnose.length - 1; i >= 1; i--) {
      idSymptoms = idSymptoms + $scope.symptomsToDiagnose[i].id +  " "; 
    };
    idSymptoms = idSymptoms + $scope.symptomsToDiagnose[0].id;
    return idSymptoms;
  };

  $scope.createDisease = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/diseases/create/' + $scope.collectIds(), $scope.newDisease).
      success(function() {
        $scope.diagnose();
        successAlert("Disease [" + $scope.newDisease.name + "] has been created successfuly");
      }).
      error(function() {
        errorAlert("An error occurred while trying to create the disease [" + $scope.newDisease.name + "]. Try later");
      });
  };

  $scope.diagnose();

}]);

app.controller('TreatmentController', ['$scope', '$http', '$routeParams', '$location', 'PatientDiagnoseID', function($scope, $http, $routeParams, $location, PatientDiagnoseID) {

  $scope.patient_id = $routeParams.patientId;

  $scope.getDisease = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/diseases/' + $routeParams.diseaseId).
      success(function(data) {
        $scope.diagnosedDisease = data;
      });
  }

  $scope.getMedicines = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/medicines/list').
      success(function(data) {
        $scope.medicines = data;
      });
  };

  $scope.getMedicalPractices = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/medicalPractices/list').
      success(function(data) {
        $scope.medicalPractices = data;
      });
  };

  $scope.diagnose = function() {
    $http.get('http://localhost:8080/desapp-groupa-backend/rest/diagnose/' + $scope.patient_id + '/makeTreatment/' + $routeParams.diseaseId).
      success(function(data) {
        $scope.diagnosedTreatment = data;
      });
  };

  $scope.addMedicine = function(medicine) {
    $scope.diagnosedTreatment.medicines.addIfNotExist(medicine);
  };

  $scope.deleteMedicine = function(medicine) {
    $scope.diagnosedTreatment.medicines.removeIfExist(medicine);
  };

  $scope.addMedicalPractice = function(medicalPractice) {
    $scope.diagnosedTreatment.medicalPractices.addIfNotExist(medicalPractice);
  };

  $scope.deleteMedicalPractice = function(medicalPractice) {
    $scope.diagnosedTreatment.medicalPractices.removeIfExist(medicalPractice);
  };

  $scope.create = function() {
    $http.put('http://localhost:8080/desapp-groupa-backend/rest/records/' +  $scope.patient_id + '/createConsultation/' + $scope.diagnosedDisease.id, $scope.diagnosedTreatment).
      success(function(data) {
        $location.path('/MedicalRecord/' + $scope.patient_id);
        successAlert("A new medical consultation has been added to current patient");
      }).
      error(function() {
        errorAlert("An error occurred while trying to add a new medical consultation to current patient. Try later");
      });
  };

  $scope.createMedicalPractice = function() {
    $http.post('http://localhost:8080/desapp-groupa-backend/rest/medicalPractices/create', $scope.newMedicalPractice).
      success(function(data) {
        $scope.getMedicalPractices();
        $scope.newMedicalPractice.name = "";
        successAlert("Disease [" + $scope.newMedicalPractice.name + "] has been created successfuly");
      }).
      error(function() {
        errorAlert("An error occurred while trying to create the medical practice [" + $scope.newMedicalPractice.name + "]. Try later");
      });
  };

  $scope.getDisease();
  $scope.getMedicines();
  $scope.getMedicalPractices();
  $scope.diagnose();

}]);

//////////////////////////////////////////
///////// SERVICES
//////////////////////////////////////////

app.service('LastSearchService', function() {
  
  var _lastSearch = '';

  this.get = function() {
    return _lastSearch;
  }

  this.save = function(search) {
    _lastSearch = search;
  }

});


app.service('PatientDiagnoseID', function() {
  
  var _patientID;

  this.get = function() {
    return _patientID;
  }

  this.save = function(id) {
    _patientID = id;
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
