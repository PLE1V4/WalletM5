<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<meta charset="UTF-8">
<title>Wallet</title>
<style>
.glassContainer {
	background: rgba(255, 255, 255, 0.25);
	border-radius: 16px;
	box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
	backdrop-filter: blur(9.8px);
	-webkit-backdrop-filter: blur(9.8px);
	border: 1px solid rgba(255, 255, 255, 1);
}

.btnBack {
	border: none;
	appearance: none;
	background: inherit;
}

input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

input[type=number] {
	-moz-appearance: textfield;
}
</style>
</head>
<body class="bg-body-tertiary">
	<header class="container text-center">
		<h1 class="h1">AlkeWallet</h1>
	</header>
	<main>
		<div class="container text-center mt-5 glassContainer">
			<div class="d-flex align-items-start justify-content-start pt-3">
				<a href="home"><button class="btnBack">
						<span class="material-symbols-outlined"> arrow_back </span>
					</button></a>
			</div>
			<h2 class="h2 mt-0 mb-5">Transferir</h2>
			<span class="h5 mb-3"> Saldo Actual: <c:out value="${saldo}"></c:out>
			</span>
			<form action="#" method="post">
				<div class="form-floating mb-3">
					<input type="number" name="transferAmount" min=1
						max=<c:out value="${saldo}"></c:out>
						placeholder="Ingrese monto a Transferir" class="form-control"
						required> <label for="transferAmount">Monto</label>
					<div id="amountHelper" class="form-text invalid-feedback"></div>
				</div>
				<table
					class="table table-responsive table-hover table-sm table-borderless-column">
					<tbody>
						<c:forEach var="contacto" items="${contactos}">
							<tr>
								<td><input type="radio" id="${contacto.getName()}"
									name="transferContact" value="${contacto.getContactId()}"><label
									for="${contacto.getName()}"><c:out
											value="${contacto.getName()}"></c:out></label></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="d-grid gap-2 mb-5">
					<input type="submit" value="Transferir" class="btn btn-lg btn-primary">
				</div>
				
			</form>
		</div>

	</main>

</body>
</html>