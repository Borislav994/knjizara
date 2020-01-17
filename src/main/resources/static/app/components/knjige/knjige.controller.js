var knjizaraApp = angular.module("knjizaraApp");
knjizaraApp.controller("knjigaCtrl", function($scope,$routeParams, $http, $location){
	
	$scope.knjige = [];
	$scope.izdavaci = [];
	
	$scope.knjiga = {};
	$scope.knjiga.naziv = "";
	$scope.knjiga.izdanje = "";
	$scope.knjiga.pisac = "";
	$scope.knjiga.isbn = "";
	$scope.knjiga.izdavacId = "";
	
	
	var baseUrl = "/api/knjige";
	var izdavaciUrl = "/api/izdavaci";
	
var getIzdavace = function(){
		
		var promise = $http.get(izdavaciUrl);
		
		promise.then(
			function success(res){
				$scope.izdavaci = res.data;
				getKnjige();
				
			},
			function error(){
				alert("Unsuccessful fetch!")
			}
		);

	}


var getKnjige = function(){
	

	$http.get(baseUrl).then(
		function success(res){
			$scope.knjige = res.data;
		},
		function error(){
			alert("Something went wrong.");
		}
	);
}
getIzdavace();

	
	$scope.doAdd = function(){
		$http.post(baseUrl, $scope.knjiga).then(
			function success(){
				console.log($scope.knjiga);
				getKnjige();
				
			},
			function error(){
				console.log(JSON.stringify($scope.knjiga));
				alert("Couldn't add activity!");
			}
		);
	}
	
	$scope.doDelete = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getKnjige();
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
	
	$scope.goToEdit = function(id){
		$location.path("/knjige/edit/" + id);
	}

	
	
});