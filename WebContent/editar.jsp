<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Editar Mensaje</h1>
	<form method="post" action="MensajeControl">

		<div class="form-group row">
			<br> <label for="inputEmail3" style="text-align: left;"
				class="col-sm-3 col-form-label">Nombre</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="usuarioLogin"
					name="nombre" placeholder="nombre"  required="Llena este campo" value="${mensaje.getNombre()}">
			</div>
		</div>
		<div class="form-group row">
			<label for="inputPassword3" style="text-align: left;"
				class="col-sm-3 col-form-label">Email</label>
			<div class="col-sm-9">
				<input value="${mensaje.getEmail()}" type="text" class="form-control" id="contraLogin"
					name="email" placeholder="email" required="Llena este campo">
			</div>
		</div>
		<div class="form-group row">
			<label for="inputPassword3" style="text-align: left;"
				class="col-sm-3 col-form-label">WebSite</label>
			<div class="col-sm-9">
				<input value="${mensaje.getWebsite()}" type="text" class="form-control" id="contraLogin"
					name="website" placeholder="website" required="Llena este campo">
			</div>
			<div>
				<label for="inputPassword3" style="text-align: left;"
					class="col-sm-3 col-form-label">Usuario</label>
				<div class="col-sm-9">
				
	<jsp:useBean id="uD" class="Dao.UsuarioDao" scope="request"></jsp:useBean>
	
					<select name="usuario">
						<option>Elije a un usuario</option>
						<c:forEach var="u" items="${uD.listar()}">
						
						<option value="<c:out value="${u.getUsuario()}"/>"><c:out value="${u.getUsuario()}"/></option>
						</c:forEach>
					</select>
				</div>



			</div>
		</div>
		<div class="form-group row">
			<label for="inputPassword3" style="text-align: left;"
				class="col-sm-3 col-form-label">Mensaje</label>
			<div class="col-sm-9">
				<textarea rows="10" cols="40" class="form-control" id="contraLogin"
					name="mensaje" placeholder="mensaje" required="Llena este campo">${mensaje.getMensaje()}</textarea>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-12">
				<button type="submit"  name="accion" value="update"
					class="btn btn-dark">Editar Mensaje</button>

			</div>
		</div>

	</form>

</body>
</html>