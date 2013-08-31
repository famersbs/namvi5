
function bootstraptest_controller( $scope ){
	
	$scope.showMyModal = function(){
		$("#myModal").modal('show');                // initializes and invokes show immediately
	};
	
	
	//$scope.onpopup_testclick = function(){
		$('#popup_test').popover({
			animation : true,
			placement : 'right',
			html		: true,
			selector : true,
			triger : 'click',
			title : 'pop over test',
			content : 'aaaaaaaaaaaaa<br/>aaa\naaaaaaaa<br/>aaaaa',
			delay : 1000
		});
	//};
}