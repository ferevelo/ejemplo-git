<%@page import="org.hibernate.validator.internal.util.privilegedactions.GetMethod"%>
<%@ page import="puce.contacto.contacto" %>
<%@ page import="java.util.ArrayList" %><!-- importar -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% ArrayList<contacto>contactos;    %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libreta de direcciones</title>
</head>

<!-- llamar a la clase contacto y agregarlos -->
<% contactos=(ArrayList<contacto>)session.getAttribute("contactos");
	if(contactos==null){
	contactos=new ArrayList< contacto>();
	session.setAttribute("contactos", contactos);
	}
	
	String metodo= request.getMethod();
	if("POST".equals(metodo)){
	String nombre=request.getParameter("nombre");
	String apellido=request.getParameter("apellido");
	String telefono=request.getParameter("telefono");
	
	contacto contacto = new contacto();
	
	contacto.setNombre(nombre);
	contacto.setApellido(apellido);
	contacto.setTelefono(telefono);
	
	contactos.add(contacto);
	}else{
		System.out.print("error");
	}
%>
<body>
	<h1>LIBRETA DE DIRECCIONES</h1>
	<form method="post">
	<label>Nombre</label>
	<input type="text" name="nombre"/>
	<label>Apellido</label>
	<input type="text" name="apellido"/>
	<label>Telefono</label>
	<input type="text" name="telefono"/>
	<button type="submit">Agregar</button>
	</form>
	
	<!-- mostrar los usuarios agregados al arraylist -->
	<h1>Contactos Agregados</h1>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Telefono</th>
			</tr>
		</thead>
		
		<tbody>
		<% for(contacto c:contactos){ %>
		<tr>
			<th><%=c.getNombre() %></th>
			<th><%=c.getApellido() %></th>
			<th><%=c.getTelefono() %></th>
		</tr> 
		<%} %>
		</tbody>
	</table>
	
</body>
</html>