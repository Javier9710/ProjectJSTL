<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="Entities.Mensaje"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de mensajes</title>
</head>
<body>
	<h1>Listado de Mensajes</h1>
	<jsp:useBean id="mD" class="Dao.MensajeDao" scope="request"></jsp:useBean>

	
	<table>						
		<tr>
			<th>Nombre</th>
			<th>Email</th>
			<th>Usuario</th>
		</tr>
		<c:forEach var="m" items="${mD.listar()}">

			<tr>
				<td><c:out value="${m.nombre}" /></td>
				<td><c:out value="${m.email}" /></td>
				<td><c:out value="${m.usuario.usuario}" /></td>
				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>