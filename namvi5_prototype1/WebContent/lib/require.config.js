'use strict';

requirejs.config({
	
	baseUrl:'../js/',
	
	paths: {
		'jquery' 			: '../lib/jquery/jquery.min',
		'angular' 			: '../lib/angular/angular.min',
		'bootstrap' 		: '../lib/bootstrap/js/bootstrap.min',
		'angular-strap' 	: '../lib/angular/angular-strap.min',
		'nggrid'			: '../lib/nggrid/ng-grid.min',
		'flot'				: '../lib/flot/jquery.flot'
	},
	
	shim:{
		'jquery' : {
			exports:'$'
		},
		'angular' : {
			deps:['jquery'],
			exports:'angular'
		},
		'angular-strap' :{
			deps:['angular']
		},
		'bootstrap':{
			deps:['jquery']
		},
		'nggrid':{
			deps:['angular']
		},
		'flot':{
			deps:['jquery']
		}
	}
	
});

define([
           'jquery',
           'angular',
           'angular-strap',
           'bootstrap',
           'nggrid',
           'flot'
           ],
   function( $, angular ){
		var module_list = [
		                   { id : "module_dynamic" }, 
		                   { id :"module_static" }, 
		                   { id :"bootstraptest" }
		                   ];
		// 기본 객체 들을 생성 하여 전달 해 준다. --> 여기서 전역 초기화를 하면 될까?
		return { '$':$, 
				 'angular':angular, 
				 'module_list': module_list };
	});

