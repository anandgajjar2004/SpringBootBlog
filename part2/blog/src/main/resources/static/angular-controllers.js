app.controller('blogController', function($scope, $http) {

});

app.controller('ListOfPostController', function($scope, $http, $location) {

	$http.get("/posts").then(function(response) {
		$scope.listOfPost = response.data;
	});

	$scope.deletePost = function(id) {
		$http({
			method : "DELETE",
			url : "/post/" + id
		}).then(function(response) {
			alert(response.data["message"]);
			window.location.reload();
		}, function(error) {

		});
	}
});

app.controller('AddPostController', function($scope, $http) {

	$scope.fields = {
		title : '',
		body : ''
	};
	
	$scope.createPost = function(fields) {
		$http({
			method : "POST",
			url : "/post/",
			data : fields,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function(result) {
			alert("Post Created Successfully");
			window.history.back();
		}, function(error) {
			console.log(error);
		});
	}
});

app.controller('ViewPostController', function($scope, $http, $routeParams) {

	$scope.id = $routeParams.id;
	$http.get("/post/" + $scope.id).then(function(response) {
		$scope.fields = response.data;
	});

});
