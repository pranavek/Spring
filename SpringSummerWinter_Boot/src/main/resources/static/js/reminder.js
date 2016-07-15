/**
 * 
 */

var app = angular.module('smile', []);

app.controller('reminder', function($scope, $http) {
	// $scope.greeting = {id: 'xxx', content: 'Hello World!'}
	$http.get('/resource/').success(function(data) {
		$scope.reminder = data;
	})

});