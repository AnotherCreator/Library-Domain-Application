<%--
  Created by IntelliJ IDEA.
  User: Josh
  Date: 9/16/2022
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>Country Page</title>
  </head>

  <body>
    <h1>Add a new country!</h1>
    <form method="post" action="${pageContext.request.contextPath}/ctry">
      <div>
        <label for="countryCode">Country Code</label>
        <input type="text" id="countryCode" name="countryCode" maxlength="3" placeholder="AAA">
      </div>
      <div>
        <label for="countryName">Country Name</label>
        <input type="text" id="countryName" name="countryName" maxlength="52" placeholder="Canada">
      </div>
      <div>
        <label for="countryContinent">Country Continent</label>
        <select id="countryContinent" name="countryContinent">
          <option value="asia">Asia</option>
          <option value="europe">Europe</option>
          <option value="northAmerica">North America</option>
          <option value="africa">Africa</option>
          <option value="oceania">Oceania</option>
          <option value="antarctica">Antarctica</option>
          <option value="southAmerica">South America</option>
        </select>
      </div>
      <div>
        <label for="countryRegion">Country Region</label>
        <input type="text" id="countryRegion" name="countryRegion" maxlength="26" placeholder="North America">
      </div>
      <div>
        <label for="surfaceArea">Surface Area</label>
        <input type="text" id="surfaceArea" name="surfaceArea" placeholder="100.00">
      </div>
      <div>
        <label for="population">Population</label>
        <input type="text" id="population" name="population" placeholder="500500">
      </div>
      <div>
        <label for="localName">Local Name</label>
        <input type="text" id="localName" name="localName" maxlength="45" placeholder="Canada">
      </div>
      <div>
        <label for="governmentForm">Government Form</label>
        <input type="text" id="governmentForm" name="governmentForm" maxlength="45" placeholder="Republic">
      </div>
      <div>
        <label for="countryCode2">Secondary Country Code</label>
        <input type="text" id="countryCode2" name="countryCode2" maxlength="2" placeholder="AA">
      </div>
      <button type="submit">Create</button>
    </form>
  </body>
</html>
