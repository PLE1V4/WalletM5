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
</style>
</head>
<body class="bg-body-tertiary">
	<header class="container text-center">
		<h1 class="h1">AlkeWallet</h1>
	</header>
	<main>
		<div class="container mt-5 text-center glassContainer">
			<h2 class="h2 mt-3 mb-5">Menu Principal</h2>
			<div class="d-grid">
				<span class="h2">Bienvenido <c:out value="${userNombres}"></c:out> <c:out
						value="${userApellidos}"></c:out>
				</span>
			</div>
			<div>
				<label class="h3">Saldo:</label>
				<div class="mb-3">
					<span class="h3"><c:out value="${currencySymbol}"></c:out> <c:out
							value="${accBalance }"></c:out></span>

				</div>
			</div>
			<div class="d-grid gap-2 mb-5 d-flex justify-content-center">
				<a href="deposit"><input type="button" value="Depositar"
					class="btn btn-lg btn-primary"></a> <a href="Transfer"><input
					type="button" value="Transferir" class="btn btn-lg btn-primary"></a>
				<a href="Movimientos"><input type="button" value="Movimientos"
					class="btn btn-lg btn-primary"></a>
			</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>