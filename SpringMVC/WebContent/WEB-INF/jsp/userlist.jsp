<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<% response.setCharacterEncoding("UTF-8"); %>
<h2>This is Spring MVC demo page</h2>
<form name="form1">
<p>你的姓名：  
     <input type="text" name="name"> 
</p> 
<p>你的年龄：  
     <input type="text" name="age"> 
</p> 
<p> 
     <input type="Submit" value="提交"> 
     <input type="Reset" value="重置"> 
</p> 
</form>
<h2>The users are below</h2>
<c:forEach items="${users}" var="user">
	user id : <c:out value="${user.id}"></c:out><br/>
	user name : <c:out value="${user.name}"></c:out><br/>
	user age  : <c:out value="${user.age }"></c:out><br/>
	<p></p>
</c:forEach>
