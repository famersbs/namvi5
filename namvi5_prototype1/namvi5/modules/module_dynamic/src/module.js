function test2_controller($scope){
	
	$scope.test2 = "tttt";
	
}

function module_dynamic_ctrl( $scope ){
	
	$scope.myData = [{name: "Moroni", age: 50},
	                 {name: "Tiancum", age: 43},
	                 {name: "Jacob", age: 27},
	                 {name: "Nephi", age: 29},
	                 {name: "Enos", age: 34}];
	
	$scope.gridOptions = { data: 'myData' };

}