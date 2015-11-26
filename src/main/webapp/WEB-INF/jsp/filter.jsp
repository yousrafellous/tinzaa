<%-- 
    Document   : filter
    Created on : 3 nov. 2015, 15:33:31
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Filter</title>
    </head>
    <body>
         <form:form   method="POST" commandName="us" action="filter.htm" >
             <table cellpadding="2" cellpacing="2" border="0">
              <tr>
                <td>Id</td>
                <td><form:input path="destination" ng-model="formData.destination"/></td>
                <td><form:errors path="destination" cssClass="error"></form:errors></td>
            </tr>    
             <tr>
                <td>Nom</td>
                <td><form:input path="picup" ng-model="formData.picup"/></td>
                <td><form:errors path="picup" cssClass="error"></form:errors></td>
            </tr> 
            <tr>
                
           
             <tr>
                 <td>&nbsp;</td>
                 <td colspan="2"><input type="submit" value="Confirm"></td>
            </tr>  
        </table>
            </form:form>
    </body>
</html>

