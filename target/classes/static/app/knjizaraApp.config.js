var knjizaraApp = angular.module("knjizaraApp");
knjizaraApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/knjige', {
			templateUrl : '/app/components/knjige/knige.html'
		})
		.when('/knjige/edit/:id', {
			templateUrl : '/app/components/edit-knjige/edit-knjige.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);