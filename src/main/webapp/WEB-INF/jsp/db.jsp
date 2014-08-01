<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-81">
<title>spring mvc</title>
</head>
<body>
	<!-- spring 表单标签 -->
	<form:form action="db.do" method="post">
		<input type="hidden" name="method" value="oper" /> 
		服务器接受的信息：${do} 
		<br />
		<input type="text" name="dbName" value="" />
		<br />
		结果是：${result} <br />
		<input type="submit" value=" 提交 " />
	</form:form>
</body>
</html>