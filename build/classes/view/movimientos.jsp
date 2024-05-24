<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Movimientos</h1>

	<table>
		<thead>
			<tr>
				<th>Monto</th>
				<th>Cuenta Destino</th>
				<th>Tipo</th>
				<th>Fecha</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transactions}" var="transaction">
				<tr>
					<td><c:out value="${transaction.getAmount()}"></c:out></td>
					<td><c:out value="${transaction.getReceiverId()}"></c:out></td>
					<td><c:choose>
							<c:when test="${transaction.getTipo() == 1}">Deposito</c:when>
							<c:when test="${transaction.getTipo() == 2}">Transferencia</c:when>
						</c:choose></td>
					<td><c:out value="${transaction.getFecha()}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="home"><input type="button" value="Volver"></a>

</body>
</html>