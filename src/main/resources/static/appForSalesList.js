var app = angular.module('app', []);

var req1 = {
		 method: 'GET',
		 url: '/sublist/getsaleslist',
		 headers: {
		   'Content-Type': 'charset=utf-8'
		}
	}

app.controller('GetCtrl', function($scope, $http, $filter) {
	
	$scope.csToken = angular.element(document.getElementsByName("_csrf")).attr("content");
	$scope.csHeaderName = angular.element(document.getElementsByName("_csrf_header")).attr("content");

	$scope.getPeriodList = function() {
		$scope.totalPrice = 0;
	    $http({
	    	method: 'POST',
			url: '/sublist/getperiodlist',
			headers: { 'X-CSRF-TOKEN' : $scope.csToken, 'Content-Type': 'application/x-www-form-urlencoded'},
			data : { fromDate : $scope.fromDate, toDate : $scope.toDate }
		}).then(function(value) {
			$scope.salesList = value.data;
			for(i = 0; i < value.data.length; i++) {
				$scope.totalPrice += value.data[i].rPrice;
			}
		}, function(reason) {
		  	
		}, function(value) {
		  	
		})
		
	}
	
	$scope.initFunc = function() {
		var nowDate = new Date();
		$scope.fromDate = $filter('date')(nowDate, 'yyyy-MM') + "-01";
	    $scope.toDate = $filter('date')(nowDate, 'yyyy-MM-dd');
	    $scope.getPeriodList();				
	}
	
	$scope.sDateIndex = ['sDate', '-sDate', 0];
	$scope.nameIndex = ['name', '-name', 0];
	$scope.titleIndex = ['title', '-title', 0];
	$scope.amountIndex = ['amount', '-amount', 0];
	$scope.rPriceIndex = ['rPrice', '-rPrice', 0];
	$scope.indexForOrder = 'sDate';
	  
	$scope.toggleIndex = function(target) {
		var idx = target[2];
		if($scope.indexForOrder != target[0] && $scope.indexForOrder != target[1]) {
			$scope.indexForOrder = target[idx];
		}
		else if($scope.indexForOrder == target[0]) {
			$scope.indexForOrder = target[1];
			target[2] = 1;
		}
		else if($scope.indexForOrder == target[1]) {
			$scope.indexForOrder = target[0];
			target[2] = 0;
		}
	}
	  
});
