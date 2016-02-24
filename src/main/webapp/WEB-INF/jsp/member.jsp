<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="js/tools/jquery.min.js"></script>
<script type="text/javascript" src="js/tools/jquery.jqGrid.min.js"></script>

<!-- 自訂 -->
<script type="text/javascript" src="js/custom/member.js"></script>

<title>sampleWork</title>
</head>
<body>
	<form id = "memberForm">
		<label>User Name:</label><input type="text" id="name"/><br/>
		<label>Password:</label><input type="password" id="pwd"/><br/>
		<label>email:</label><input type="text" id="email"/><br/>
		<label>phone:</label><input type="text" id="phone"/><br/>
		<input type="button" value="query" onclick="findAll();"/>
		<input type="button" value="新增" onclick="addUser();"/>
		<input type="button" value="修改" onclick="updateUser();"/>
		<input type="button" value="刪除" onclick="removeUser();"/>
	</form>
</body>
<br><br><br>
<body>
<table id="memberGrid"><tbody></tbody></table>
</body>
</html>