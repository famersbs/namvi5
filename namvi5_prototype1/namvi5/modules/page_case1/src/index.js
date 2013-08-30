angular.module('case1page', ['ngGrid']);

var pageController = function( $scope ){

	$scope.target_module = target_module;
	
	// 매뉴 선택자 만들기
	$scope.menuClassSelector = function( module ){
		if( module == $scope.target_module ) return "active";
		return "";
	};
	
	$scope.changeMainModule = function( module ){
		// View 전환 하는 방법을 찾아 보자 ~!
		$scope.target = "../module/" + module;
		$scope.target_module = module;
	};
	
	$scope.changeMainModule( target_module );
};
