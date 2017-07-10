app.config(function($routeProvider) {
	$routeProvider.when('/posts/', {
		templateUrl : 'pages/listOfPost.html',
		controller : 'ListOfPostController'
	}).when('/post/new', {
		templateUrl : 'pages/addPost.html',
		controller : 'AddPostController'
	}).when('/post/:id', {
		templateUrl : 'pages/viewPost.html',
		controller : 'ViewPostController'
	}).otherwise({
		redirectTo : '/posts'
	});
});