<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>
<body>

	<div id="helloHeader">
		<h2><i class="far fa-user"></i> <c:out value="${user.getFirstName()}"/> <c:out value="${user.getLastName()}"/></h2>
		<a href="/logout"><button type="submit">
			Log Out <i class="fas fa-sign-out-alt"></i>
		</button></a>

	</div>

	<div id="coverImage">
		<h1><i class="fas fa-list-alt"></i> Contacts</h1>
	</div>

	<div id="nav">
		
		<a href="/addContactRedirect"><button type="submit" formaction="/hehe" id="add">
			<i class="fas fa-plus-circle"></i> Add Contact
		</button></a>
		<div id="search">
		
			<form action="/searchContacts" method="get">
			<input type="search" name="searchField" id="searchField" placeholder="Search">
			<button id="searchButton" type="submit">
				<i class="fas fa-search"></i>
			</button>
			</form>
			
		</div>
	</div>

	<div id="contactTableDiv">
		
		<table class="tables">
			<tr class="tableHeader">
				<th>&nbsp;</th>
				<th>Name</th>
				<th>Phone Number</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<c:forEach items="${contacts}" var="contact" varStatus="loop">
				<tr>
					<th class="numeration">${loop.index+1}</th>
					<td>${contact.getContactName()}</td>
					<td>${contact.getPhoneNumber()}</td>							
					<td><form action="/editContactRedirect"><button class="tableButton" type="submit" value="${contact.getContactId()}" name="editButton">Edit</button></form></td>
					<td><form><button class="tableButton" type="submit" formmethod="get" formaction="deleteContact" value="${contact.getContactId()}" name="deleteButton">Delete</button></form></td>
				</tr>
			</c:forEach>

		</table>

	</div>

</body>
</html>