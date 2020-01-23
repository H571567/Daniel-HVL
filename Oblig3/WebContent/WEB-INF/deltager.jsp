<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/CSS/styles.css'>
<style>body {background-color: #d0f0f2;}</style>
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjonn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		
		<c:forEach var="p" items="${brukere}">
		<tr>
		<c:choose>
				<c:when test="${p.mobil == aktiv}">
	        		<tr bgcolor="#7FFF00">
	        	</c:when>
	        	<c:otherwise>
	        		<tr bgcolor="ffffff">
	        	</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${p.kjonn == 'mann'}">
					<td align="center">Mr</td>
				</c:when>
				<c:otherwise>
					<td align="center">Ms</td>
				</c:otherwise>
			</c:choose>
				<td><c:out value="${p.fornavn}"/> <c:out value="${p.etternavn}"/></td>
				<c:set value="${p.mobil}" var="tlf" />
				<td>${fn:substring(tlf, 0, 3)} ${fn:substring(tlf, 3, 5)} ${fn:substring(tlf, 5, 8)}</td>
        </tr>
		</c:forEach>
		
	</table>
	<p>
		<a href="logout">Ferdig</a>
	</p>
</body>
</html>