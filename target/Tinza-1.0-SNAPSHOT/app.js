/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// create our angular app and inject ngAnimate and ui-router 
// =============================================================================
angular.module('formApp', ['ngAnimate','ngResource','ui.router'])

// configuring our routes 
// =============================================================================
.config(function($stateProvider, $urlRouterProvider) {
    
    $stateProvider
    
        // route to show our basic form (/form)
        .state('form', {
            url: '/form',
            templateUrl: 'form.html',
            controller: 'formController'
        })
        
        // nested states 
        // each of these sections will have their own view
        // url will be nested (/form/profile)
        .state('form.picup', {
            url: '/picup',
            templateUrl: 'form-picup.html'
        })
        .state('form.date', {
            url: '/date',
            templateUrl: 'date.html'
        })
        .state('form.destination', {
            url: '/destination',
            templateUrl: 'form-destination.html'
        })
        // url will be /form/interests
        .state('form.category', {
            url: '/category',
            templateUrl: 'form-category.html'
        })
        
        // url will be /form/payment
        .state('form.payment', {
            url: '/Filter',
            templateUrl: 'form-payment.html'
        })
        
         // url will be /form/payment
        .state('form.morefilter', {
            url: '/morefilter',
            templateUrl: 'form-morefilter.html'
        });
       
    // catch all route
    // send users to the form page 
    $urlRouterProvider.otherwise('/form/picup');
})

// our controller for the form
// =============================================================================
.controller('formController', function($scope,$http) {
    
    // we will store all of our form data in this object
    $scope.formData = {};
 
// function to process the form
   
				$scope.processForm = function(){
                                $http.get('student',{params: {id:'123'}})
// Create a  class object
				var dataObj = {
				city : $scope.formData.place,
                                date : $scope.formData.date,
				size : $scope.formData.size,
                                transport : $scope.formData.transport
                                };	
		
                                var res = $http.post('student', dataObj);
                                res.success(function(data, status, headers, config) {
                                $scope.message = data;
                                alert( "MESSAGE message: " + JSON.stringify({data:dataObj}));
                                });
                                res.error(function(data, status, headers, config) {
                                alert( "failure message: " + JSON.stringify({data: data}));
                                });		
// Making the fields empty
                                $scope.city='';
                                $scope.date='';
                                $scope.size='';
                                $scope.transport='';
					
				};
				
    
    
    
    
    
    
    
    
    
    
    
  
    
   
         $scope.myVar = false;
    $scope.toggle = function() {
        $scope.myVar = !$scope.myVar;
    };
    
});


