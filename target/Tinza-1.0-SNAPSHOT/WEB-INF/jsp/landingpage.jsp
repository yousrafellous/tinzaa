<%-- 
    Document   : landingpage
    Created on : 27 oct. 2015, 15:01:28
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
   <!-- CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootswatch/3.1.1/darkly/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    
    <!-- JS -->
    <!-- load angular, nganimate, and ui-router -->
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.10/angular-ui-router.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-animate.min.js"></script>
    <script src="app.js"></script>
        
    <title>Landing page</title> 
    </head>
    
    <body ng-app="formApp">
        <form:form   method="POST" commandName="us" action="landingpage.htm" >
       <a href="register.htm">Become a tinzer</a>
    
       <!-- views will be injected here -->
<div class="container">
    <div ui-view></div>
</div>

<div class="row">
    <div class="col-sm-8 col-sm-offset-2">
    <div class="jumbotron text-muted text-center">
         </div>
    </div>
</div>
       </form:form>
      
         
    </body>
</html>


    