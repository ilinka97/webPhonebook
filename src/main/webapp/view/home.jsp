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
		<h1><i class="fas fa-list-alt"></i>Contacts</h1>
	</div>

	<div id="nav">
		
		<button type="submit" formaction="/hehe" id="add">
			<i class="fas fa-plus-circle"></i> Add Contact
		</button>
		<div id="search">
			<input type="search" name="searchField" id="searchField" placeholder="Search">
			<button id="searchButton" formaction="/hehe">
				<i class="fas fa-search"></i>
			</button>
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
			<tr>
				<th class="numeration">1</th>
				<td>ko</td>
				<td>02646</td>
				<td><button class="tableButton">Edit</button></td>
				<td><button class="tableButton">Delete</button></td>

			</tr>
			<tr>
				<th class="numeration">2</th>
				<td>sdfg</td>
				<td>216464</td>
				<td><button class="tableButton">Edit</button></td>
				<td><button class="tableButton">Delete</button></td>
			</tr>
			<tr>
				<th class="numeration">2</th>
				<td>sdfg</td>
				<td>216464</td>
				<td><button class="tableButton">Edit</button></td>
				<td><button class="tableButton">Delete</button></td>
			</tr>
		</table>

	</div>

</body>
</html>