<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Edit Contact</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>
<body>
	<div id="helloHeader">
	
		<h2><i class="far fa-user"></i>  <c:out value="${user.getFirstName()}"/> <c:out value="${user.getLastName()}"/></h2>
		<a href="/logout"><button type="submit">
			Log Out <i class="fas fa-sign-out-alt"></i>
		</button></a>

	</div>

	<div id="coverImage">
		<h1><i class="fas fa-user-edit"></i> Edit Contact</h1>
	</div>

	<div id="contactForm">
		<form action="/editContact" method="post">
			<input type="text" name="contactName" id="contactName" placeholder="${contact.getContactName()}"><br>
			<input type="text" name="phoneNumber" id="phoneNumber" placeholder="${contact.getPhoneNumber()}"><br>

			<input type="submit" name="submit" value="Save">
		</form>	
	</div>

</body>
</html>