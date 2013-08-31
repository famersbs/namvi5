'use strict';

requirejs([
   '../lib/require.config.js',
   ],
   
   
   function( namvi5, pageController ){

		namvi5.$("document").ready( function(){
		var app = namvi5.angular.module('case2page', ['ngGrid']);

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
		
		namvi5.angular.bootstrap( document, ['case2page'] );
		});
});

