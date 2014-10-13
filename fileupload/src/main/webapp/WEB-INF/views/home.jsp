<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Home</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
</head>
<body>
	<form method="POST" enctype="multipart/form-data" action="file/upload.htm">
		<input type="file" name="img_file" id="img_file"/>
		<input type="submit"/>
	</form>
</body>
</html>
