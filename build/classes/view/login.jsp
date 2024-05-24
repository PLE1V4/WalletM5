<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="container text-center mt-5 glassContainer">
			<h2 class="h2 mt-3 mb-5">Iniciar Sesion</h2>
			<form action="login" method="post">
				<div class="form-floating mb-3">
					<input type="email" name="inEmail" class="form-control"
						aria-describedby="userMessage" required> <label
						for="inEmail" class="form-check-label">Email</label>
					<div id="userMessage" class="form-text invalid-feedback"></div>
				</div>
				<div class="form-floating mb-3" class="form-control"
					aria-describedby="pwdMessage">
					<input type="password" name="inPwd" class="form-control"
						aria-describedby="pwdMessage" required> <label for="inPwd">Contraseña:</label>
					<div id="pwdMessage" class="form-text invalid-feedback"></div>
				</div>
				<div class="d-grid gap-2 mb-5">
					<input type="submit" value="Iniciar Sesion" class="btn btn-lg btn-primary">
				</div>				
			</form>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>