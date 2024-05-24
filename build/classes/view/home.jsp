<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wallet</title>
</head>
<body>
<h1>Bienvenido <c:out value="${userNombres}"></c:out> <c:out value="${userApellidos}"></c:out></h1>
<h2>Saldo: <c:out value="${currencySymbol}"></c:out> <c:out value="${accBalance }"></c:out></h2>
<form>
<a href="deposit"><input type="button" value="Depositar"></a>
<a href="Transfer"><input type="button" value="Transferir"></a>
<a href="Movimientos"><input type="button" value="Movimientos"></a>
</form>
</body>
</html>