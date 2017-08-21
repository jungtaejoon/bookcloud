//<script th:inline="javascript">
//    /*<![CDATA[*/
//    query = [[${list}]];
//    console.log("성공");
//    /*]]>*/
//</script>

var app = angular.module('app', []);

app.controller('GetCtrl', function($scope, $http, $filter) 
{
	$scope.csToken = angular.element(document.getElementsByName("_csrf")).attr("content");
	$scope.csHeaderName = angular.element(document.getElementsByName("_csrf_header")).attr("content");
	$scope.tYear = tYear;
	$scope.tMonth = tMonth;

$scope.taxToExcel = function() 
	{
		$scope.totalPrice = 0;
	    $http({
	    	method: 'POST',
			url: '/tax/taxtoexcel',
			headers: { 'X-CSRF-TOKEN' : $scope.csToken, 'Content-Type': 'application/x-www-form-urlencoded'},
			dataType    :   "json",
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
});