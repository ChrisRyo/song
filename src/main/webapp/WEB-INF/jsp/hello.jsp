<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="<c:url value="expenses.js"/>"></script>
</head>
<body>
	Hello,
	<c:out value="${it.name}" />
</body>
</html>