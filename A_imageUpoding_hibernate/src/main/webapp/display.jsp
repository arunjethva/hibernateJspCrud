<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span>${msg}</span>

	<table border="1">

		<tr>
			<th>Id</th>
			<th>UserName</th>
			<th>Email</th>
			<th>Image</th>
			<th colspan="2">Action</th>
		</tr>

		<c:forEach var="dt" items="${data}">
			<tr>
				<td>${dt.getId()}</td>
				<td>${dt.getName()}</td>
				<td>${dt.getEmail()}</td>

				<td><img src="img/${dt.getImg()}" alt="${dt.getImg()}"
					height="100px" width="100px"></td>
				<td><a href="update?action=delete&uid=${dt.getId()}">Delete</a></td>
				<td><a href="update?action=edit&uid=${dt.getId()}">Update</a></td>
			</tr>
		</c:forEach>


	</table>
	<a href="index.jsp">Rgistration</a>
</body>
</html>