<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆界面</title>
</head>
<body>
	<h3>欢迎登陆</h3>
	<!-- j_spring_security_check,这个路径也是Spring Security为我们自动生成的 -->
	<form:form action="/ctosii_middle/j_spring_security_check" method="post">
		<!-- 这里需要post的两个个参数为j_username,j_password -->
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>密 码:</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="登陆" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
