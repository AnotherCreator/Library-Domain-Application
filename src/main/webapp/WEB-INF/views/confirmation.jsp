<%--
  Created by IntelliJ IDEA.
  User: Josh
  Date: 9/17/2022
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Country was Created</title>
  </head>
  <body>
    <h1>${requestScope.country.name} was Created</h1>
    <ul>
      <li>${requestScope.country.code}</li>
      <li>${requestScope.country.continent}</li>
      <li>${requestScope.country.region}</li>
      <li>${requestScope.country.surfaceArea}</li>
      <li>${requestScope.country.population}</li>
      <li>${requestScope.country.localName}</li>
      <li>${requestScope.country.governmentForm}</li>
      <li>${requestScope.country.code2}</li>
    </ul>
  </body>
</html>
