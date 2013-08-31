'use strict';

requirejs([ '../lib/require.config.js'
            ,"../page_case1/pageController"],
   
   function( namvi5, pageController ){

		namvi5.$("document").ready( function(){
		var app = namvi5.angular.module('case1page', ['ngGrid']);

		// 컨트롤러 등록 
		pageController( app, namvi5 );
		
		namvi5.angular.bootstrap( document, ['case1page'] );
	});

});

