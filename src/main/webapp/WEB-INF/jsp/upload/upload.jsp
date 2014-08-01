<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-81">
<title>spring upload</title>
</head>
<body>
	<!-- 需要上传，必须：1、post 2、指定 enctype="multipart/form-data -->
	<form:form action="upload.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="method" value="fileItemUpload" />
	文件上传：
		<input type="text" name="fileName" /> <br>
		<input type="file" name="file" /><br>
		<input type="submit" value=" 提交 " />
	</form:form>
</body>
</html>