<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form:form action="/unosBrenda" method="post" modelAttribute="brend">			
Naziv Novog Brenda<br><br><form:input path="naziv"/><br>
Slika<br><input type="file" name="slikaBrenda"><br>
Opis<br><textarea name="opis" rows="40" cols="120" wrap="soft"></textarea>
<br><input type="submit" value=" Posalji"><br>
</form:form>
<br><br><br>
<form:form action="/brisanjeBrenda" method="delete">
<table>
	<c:forEach var="temp1" items="${sviBrendovi}">
		<tr>
			<td><input type="hidden" name="idB" value="${temp1.id_brand}"/></td>
			<td>${temp1.naziv}</td>
			<td><input type="submit" value="Obrisi"></td>
		</tr>
	</c:forEach>
</table>
</form:form>
	<br><br>
<form:form action="/unosProizvoda" method="post" modelAttribute="proizvod">
Naziv Novog Proizvoda<br><form:input path="naziv"/><br>
Cena<br><form:input path="cena"/><br>
Brend<br><select name = "id_brand">
		<c:forEach var="temp" items="${sviBrendovi}">
			<option value="${temp.id_brand}">${temp.naziv}</option>
		</c:forEach>
	</select>
	<br><br>
Slika<br><input type="file" name="slika">
	<br><br>
	<input type="submit" value=" Posalji">
</form:form>
	
		
</body>
</html>