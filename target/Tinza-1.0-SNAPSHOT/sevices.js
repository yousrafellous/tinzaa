/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var raServices=angular.module('raServices',['ngResource']);
 
  
 
raServices.factory('StudentsService', ['$resource',
 
 function($resource){
 
         
 
   return $resource('http://localhost:8080/Tinza/service/:call', {}, {
 
     students: {method:'GET',params:{call:'students'},isArray:true},
 
        student:{method:'GET',params:{call:'student'},isArray:false}
 
   });
 
 }]);