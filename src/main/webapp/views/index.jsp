<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>To Do List</title>
<link
	href="https://fonts.googleapis.com/css2?family=Raleway&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="./views/style.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
</head>

<body>
	<div class="box" id="heading">
		<h1>To Do List</h1>
	</div>

	<div class="box">
		<c:forEach var="item" items="${metaData}">
			<form class="item" action='<c:url value= "/home"/>' method="POST">
				<input type="text" name="id" value="<c:out value="${item.id}"/>"
					autocomplete="off"> <input type="text" name="action"
					value="<c:out value="update"/>" autocomplete="off"><input
					type="text" name="name" value="<c:out value="${item.name}"/>"
					autocomplete="off"><button class="update"><i
					class="fa-solid fa-pen"></i></button> <a
					href='<c:url value= "/home"/>?id=<c:out value = "${item.id}&action=delete"/>'
					class="delete"><i class="fa-solid fa-trash-can"></i></a>
			</form>
		</c:forEach>

		<!-- Input and add new item -->
		<form class="form" action='<c:url value= "/home"/>' method="POST">
			<input class = "new" type="text" name="name" placeholder="New item"
				autocomplete="off"> <a class="submit">+</a>
		</form>

	</div>
	<script type="text/javascript" src="./views/app.js"></script>

</body>
</html>