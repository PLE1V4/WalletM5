<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Depositar</h1>
<h2>Saldo Actual: <c:out value="${saldo}"></c:out></h2>
<form action="#" method="post">
<label for="inAmount">Monto</label>
<input type="number" name="inAmount" min=1  placeholder="Ingrese monto a Depositar" required>
<input type="submit" value="Depositar">
</form> 
</body>
</html>