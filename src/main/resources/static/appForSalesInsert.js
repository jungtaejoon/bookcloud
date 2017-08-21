var app = angular.module('app', ['ui.bootstrap']);

var req1 = {
		 method: 'GET',
		 url: '/sublist/getbookstorelist',
		 headers: {
		   'Content-Type': 'charset=utf-8'
		}
	}

var req2 = {
		 method: 'GET',
		 url: '/sublist/getbooklist',
		 headers: {
		   'Content-Type': 'charset=utf-8'
		}
	}

app.directive('focus', function() {
	return {
		link: function(scope, element, attrs) {
			element[0].focus();
		}
	};
});

app.controller('GetCtrl', function($scope, $http) {
	$scope.getList = function() {
		$http(req1).then(function(value) {
			$scope.bookStoreList = value.data;
		}, function(reason) {
		  	
		}, function(value) {
		  	
		})
		$http(req2).then(function(value) {
			$scope.bookList = value.data;
		}, function(reason) {
			  	
		}, function(value) {
			  	
		})
		
		$scope.sDate = Date.now();
		$scope.amount = 0;
		$scope.sPrice = 0;
	}
	
	$scope.calSPrice = function() {
		if($scope.selectedBookStore) {var temper = $scope.selectedBookStore.per;}
		if($scope.selectedBook) {var temprice = $scope.selectedBook.price;}
		$scope.sPrice = temprice * temper;
	}
	
	$scope.down2 = function(keyCode) {
	}
});
