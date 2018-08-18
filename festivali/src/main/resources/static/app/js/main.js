var app = angular.module("Wafepa", ["ngRoute"]);

app.controller("ctrl", function($scope){
	$scope.message = "Hello JWD 29!";
});

app.controller("knjigeCtrl", function($scope, $http, $location){
	var baseUrlIzdavaci="/api/izdavaci"
	var baseUrl="/api/knjige";
	var baseUrlGlas="/api/glas";
	
	
	$scope.knjige=[];
	$scope.izdavaci=[];
	$scope.novaKnjiga={};
	$scope.novaKnjiga.brojGlasova=0;
	$scope.novaKnjiga.izdavacId="";
	
	$scope.unesi={};
	$scope.unesi.broj="";
	
	$scope.pretraga={};
	$scope.pretraga.naziv="";
	$scope.pretraga.pisac="";
	$scope.pretraga.minBroj="";
	
	$scope.pageNum=0;
	$scope.totalPages = 0;
$scope.pretraga=function(){
	$scope.pageNum=0;
	getKnjige();
	
}	
	
$scope.nazad = function(){
    if($scope.pageNum > 0) {
        $scope.pageNum = $scope.pageNum - 1;
        getKnjige();
    }
};

$scope.napred = function(){
    if($scope.pageNum < $scope.totalPages - 1){
        $scope.pageNum = $scope.pageNum + 1;
        getKnjige();
    }
};
	
	
$scope.kupi=function(id,broj){
	
	var promise = $http.post(baseUrl + "/" + id + "/" +  broj +"/glasanje");
	promise.then(
		function success(){
			alert("uspeh");
			getKnjige();
		},
		function error(){
			console.log("Something went wrong!");
			console.log($scope.salji);
		}
	);
	
}
	
$scope.najvecii={};

$scope.najveci=function(najveci){
	var promise = $http.get(baseUrl + "/" + najveci);
	promise.then(
		function success(res){
			//console.log(res);
			$scope.najvecii = res.data;
			getKnjige();
		},
		function error(res){
			alert("Something went wrong!");
		}
	);
	
}
	
	
var getKnjige = function(){
	
	 var config = {params: {}};

     config.params.pageNum = $scope.pageNum;
     
     if($scope.pretraga.naziv != ""){
    	 config.params.naziv=$scope.pretraga.naziv;
     }
	
     if($scope.pretraga.pisac != ""){
    	 config.params.pisac=$scope.pretraga.pisac;
     }
     
     if($scope.pretraga.minBroj != ""){
    	 config.params.minBroj=$scope.pretraga.minBroj;
     }
	
	
	
	
	
	
		var promise = $http.get(baseUrl,config);
		promise.then(
			function success(res){
				//console.log(res);
				$scope.knjige = res.data;
				$scope.totalPages = res.headers('totalPages');
			},
			function error(res){
				alert("Something went wrong!");
			}
		);
	}
	
	//console.log("Test");
	
	getKnjige();
	
	
	
var getIzdavaci = function(){
		
		var promise = $http.get(baseUrlIzdavaci);
		promise.then(
			function success(res){
				//console.log(res);
				$scope.izdavaci = res.data;
			},
			function error(res){
				alert("Something went wrong!");
			}
		);
	}

getIzdavaci();

	$scope.add = function(){
		var promise = $http.post(baseUrl, $scope.novaKnjiga);
		promise.then(
			function success(){
				getKnjige();
				getIzdavaci();
			},
			function error(){
				console.log("Something went wrong!");
				console.log($scope.novaKnjiga);
			}
		)
	}
	
	
	$scope.delete=function(id){
		$http.delete(baseUrl + "/" + id).then(
				function uspeh(){
					getKnjige();
					getIzdavaci();
				},
				function neuspeh(){
					console.log("Something went wrong!");
				}
		
		)	
	}
	
	$scope.goToEdit = function(id){
		$location.path("/knjige/edit/" + id);
	}
});





app.controller("activitiesCtrl", function($scope, $http, $location){
	
	var baseUrl = "/api/activities";
	$scope.activities = [];
	
	$scope.newActivity = {};
	$scope.newActivity.name = "";
	
	var getActivities = function(){
		
		var promise = $http.get(baseUrl);
		promise.then(
			function success(res){
				//console.log(res);
				$scope.activities = res.data;
			},
			function error(res){
				alert("Something went wrong!");
			}
		);
	}
	
	//console.log("Test");
	
	getActivities();
	
	$scope.goToEdit = function(id){
		$location.path("/activities/edit/" + id);
	}
	
	$scope.add = function(){
		var promise = $http.post(baseUrl, $scope.newActivity);
		promise.then(
			function success(res){
				getActivities();
			},
			function error(){
				console.log("Something went wrong!");
			}
		)
	}
	
	$scope.delete = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getActivities();
			},
			function error(){
				alert("Could not delete the activity.");
			}
		);
	}
});

app.controller("editKnjigeCtrl", function($scope, $routeParams, $http, $location){
	
	//console.log($routeParams);
	var knjigeId = $routeParams.aid;
	var baseUrl = "/api/knjige";
	
	$scope.knjige = {};
	
	
	var getKnjige = function(){
		
		$http.get(baseUrl + "/" + knjigeId).then(
			function success(res){
				$scope.knjige = res.data;
			},
			function error(res){
				console.log("Something went wrong!");
			}	
		);
	}
	
	getKnjige();
	
	$scope.edit = function(){
		$http.put(baseUrl + "/" + knjigeId, $scope.knjige).then(
			function success(res){
				//alert("Uspeh");
				$location.path("/knjige");
			},
			function error(res){
				alert("Something went wrong");
			}
		);
	}
	
});



app.controller("editActivityCtrl", function($scope, $routeParams, $http, $location){
	
	//console.log($routeParams);
	var activityId = $routeParams.aid;
	var baseUrl = "/api/activities";
	
	$scope.activity = {};
	$scope.activity.name = "";
	
	var getActivity = function(){
		
		$http.get(baseUrl + "/" + activityId).then(
			function success(res){
				$scope.activity = res.data;
			},
			function error(res){
				console.log("Something went wrong!");
			}	
		);
	}
	
	getActivity();
	
	$scope.edit = function(){
		$http.put(baseUrl + "/" + activityId, $scope.activity).then(
			function success(res){
				//alert("Uspeh");
				$location.path("/activities");
			},
			function error(res){
				alert("Something went wrong");
			}
		);
	}
	
});



app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/partial/home.html',
			controller: 'ctrl'
		})
		.when('/activities', {
			templateUrl : '/app/html/partial/activities.html'
		})
		.when('/knjige', {
			templateUrl : '/app/html/partial/knjige.html'
		})
		.when('/activities/edit/:aid', {
			templateUrl : '/app/html/partial/edit-activity.html'
		})
		.when('/knjige/edit/:aid', {
			templateUrl : '/app/html/partial/edit-knjige.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);
