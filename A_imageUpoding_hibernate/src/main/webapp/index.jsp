<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hibernate Jsp Crud</title>
</head>
<body>

	<h1 align="center">Registration form</h1>

	<form action="addUser" method="post" enctype="multipart/form-data">
		<span>${msg}</span>
		<input type="hidden" name="id" value="${udata.getId()}"> <label>UserName</label> <input type="text"
			name="name" placeholder="Enter UserName" value="${udata.getName()}"> <label>Email</label>
		<input type="text" name="email" placeholder="Enter email" value="${udata.getEmail()}" > <label>Password</label>
		<input type="password" name="pass" placeholder="Enter Password" value="${udata.getPass()}">

		<label>Image</label> <input type="file" name="file"
			placeholder="Submit Image"> <input type="submit"> <a
			href="display">VIEW DATA</a>

	</form>
</body>
</html>