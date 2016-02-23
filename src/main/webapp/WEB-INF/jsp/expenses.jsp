<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/tools/jquery.min.js"></script>
<!-- 最新編譯和最佳化的 CSS -->
<link rel="stylesheet" href="css/tools/bootstrap.min.css">
<!-- 選擇性佈景主題 -->
<link rel="stylesheet" href="css/tools/bootstrap-theme.min.css">
<link href="css/tools/bootstrap-theme.min.css" rel="stylesheet">
<!-- 最新編譯和最佳化的 JavaScript -->
<script type="text/javascript" src="js/tools/bootstrap.min.js"></script>
<script type="text/javascript" src="js/tools/jquery.jqGrid.min.js"></script>

<!-- 自訂 -->
<script type="text/javascript" src="js/custom/expenses.js"></script>

<style>
	#expensesForm{
		padding-top: 80px;
		padding-left: 15px;
	}
    #expensesForm input{
        padding-left: 5px;
    }
</style>

<title>Sample</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Bootstrap theme</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
	<div class="form-group">
  		<label for="usr">Name:</label>
  		<input type="text" class="form-control" id="usr">
	</div>
	<form id = "expensesForm" style="width:70%">
		<input id="billDate" placeholder="請款日" required="" autofocus="" type="text">
		<input id="realDate" placeholder="發生日期" required="" autofocus="" type="text">
        <input id="billStore" placeholder="請款店家" required="" autofocus="" type="text">
        <input id="realStore" placeholder="發生店家" required="" autofocus="" type="text">
        <input id="source" placeholder="支出去向" required="" autofocus="" type="text">
        <input id="accountIteam" placeholder="項目" required="" autofocus="" type="text">
        <input id="detail" placeholder="支出內容" required="" autofocus="" type="text">
        <input id="payee" placeholder="請款人" required="" autofocus="" type="text">
        <input id="workTime" placeholder="時間" required="" autofocus="" type="text">
        <input id="workType" placeholder="班別" required="" autofocus="" type="text">
        <input id="price" placeholder="單價" required="" autofocus="" type="text">
        <input id="quantity" placeholder="數量" required="" autofocus="" type="text">
        <input id="unit" placeholder="單位" required="" autofocus="" type="text">
        <input id="amt" placeholder="金額" required="" autofocus="" type="text">
		<br/>
		<input class="btn btn-info" type="button" value="新增" onclick="addUser();"/>
	</form>
</body>
<br><br><br>
<body>
<div class="jqGrid">
  <table id="expensesGrid"></table>
</div>
</body>

<!-- table-striped -->
</html>