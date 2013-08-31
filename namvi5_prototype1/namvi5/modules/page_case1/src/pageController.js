'use strict';

define([ '../lib/require.config.js' ],
   
   function( ){
	
		return function( app, namvi5 ){
			// 컨트롤러 등록
			app.controller( 'pageController', function( $scope ){
				
				$scope.module_list = namvi5.module_list;
				
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
			});
		};
	}
);

