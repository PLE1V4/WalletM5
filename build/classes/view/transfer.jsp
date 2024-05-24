<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transferencias</title>
</head>
<body>
<h1>Transferir</h1>
<h2>Saldo Actual: <c:out value="${saldo}"></c:out></h2>
<form action="#" method="post">
<label for="transferAmount">Monto</label>
<input type="number" name="transferAmount" min=1  max=<c:out value="${saldo}"></c:out> placeholder="Ingrese monto a Transferir" required>
<br>
<c:forEach var="contacto" items="${contactos}">
	<input type="radio" id="${contacto.getName()}" name="transferContact" value="${contacto.getContactId()}">
	<label for="${contacto.getName()}"><c:out value="${contacto.getName()}"></c:out></label>
</c:forEach>
<br>
<input type="submit" value="Transferir">
</form> 
</body>
</html>