<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="Entities.Mensaje"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de mensajes</title>
</head>
<body>
	<form action="MensajeControl" method="post">
		<div class="form-group row">
			<div class="col-sm-12">
				<button type="submit" name="accion" value="atras"
					class="btn btn-dark">Regresar</button>

			</div>
		</div>

	</form>
	<h1>Listado de Mensajes</h1>
	<jsp:useBean id="mD" class="Dao.MensajeDao" scope="request"></jsp:useBean>


	<table>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Email</th>
			<th>Usuario</th>
			<th>Mensaje</th>
			<th>Acciones</th>


		</tr>
		<c:forEach var="m" items="${mD.listar()}">

			<tr>
				<td><c:out value="${m.getId()}" /></td>
				<td><c:out value="${m.nombre}" /></td>
				<td><c:out value="${m.email}" /></td>
				<td><c:out value="${m.usuario.getUsuario()}" /></td>
				<td><c:out value="${m.getMensaje()}" /></td>
				<td>
					<form action="MensajeControl" method="post">
					<input type="hidden" name="id" value="${m.getId()}">
						<div class="form-group row">
							<div class="col-sm-12">
								<button type="submit" name="accion" value="editar"
									class="btn btn-dark">Editar</button>
								<button type="submit" name="accion" value="eliminar"
									class="btn btn-dark">Eliminar</button>

							</div>
						</div>
						

					</form>

				</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>