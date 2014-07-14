<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>THis is Spring MVC demo page</h2>
<c:forEach items="${users}" var="user">
	<c:out value="${user.username}"></c:out><br/>
	<c:out value="${user.age }"></c:out><br/>
</c:forEach>