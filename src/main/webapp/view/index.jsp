<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="indexBg">
<head>
	<title>Welcome</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>
<body>

	<div id="landingHeader">
		<h1><i class="fas fa-address-book"></i> Phonebook</h1> 
	</div>

	<div id="landingWrapper">

		<div id="registrationForm">
			<form action="/registration" method="post">
				<input type="text" name="firstName" id="firstName" placeholder="First name" required="required">
				<input type="text" name="lastName" id="lastName" placeholder="Last name"><br>
				<input type="password" name="password" id="password" placeholder="Pasword" required="required"><br>

				<input type="submit" name="submit" value="Sign In">
			</form>

		</div>

		<div id="loginForm">
			<form action="" method="post">
				<input type="text" name="firstName" id="firstName" placeholder="First name" required="required"><br>
				<input type="password" name="password" id="password" placeholder="Pasword" required="required"><br>

				<input type="submit" name="submit" value="Log In">
			</form>
			
		</div>

	</div>

</body>
</html>