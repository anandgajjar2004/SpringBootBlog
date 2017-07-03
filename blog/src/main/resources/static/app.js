var app = angular.module('blog', []);
app.controller('blogController', function($scope, $http) {
	
	 $http.get("/posts")
	    .then(function(response) {
	        $scope.listOfPost = response.data;
	 });
});