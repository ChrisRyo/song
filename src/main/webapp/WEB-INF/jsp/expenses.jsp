<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- 最新編譯和最佳化的 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<!-- 選擇性佈景主題 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- 最新編譯和最佳化的 JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="//cdn.jsdelivr.net/jqgrid/4.5.2/jquery.jqGrid.js"></script>
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
	<form id = "expensesForm" style="width:50%">
		<input id="inBillDate" placeholder="請款日" required="" autofocus="" type="text">
		<input id="inRealDate" placeholder="發生日期" required="" autofocus="" type="text">
        <input id="inBillStore" placeholder="請款店家" required="" autofocus="" type="text">
        <input id="inRealStore" placeholder="發生店家" required="" autofocus="" type="text">
        <input id="inSource" placeholder="支出去向" required="" autofocus="" type="text">
        <input id="inAccountIteam" placeholder="項目" required="" autofocus="" type="text">
        <input id="inDetail" placeholder="支出內容" required="" autofocus="" type="text">
        <input id="inPayee" placeholder="請款人" required="" autofocus="" type="text">
        <input id="inWorkTime" placeholder="時間" required="" autofocus="" type="text">
        <input id="inWorkType" placeholder="班別" required="" autofocus="" type="text">
        <input id="inPrice" placeholder="單價" required="" autofocus="" type="text">
        <input id="inQuantity" placeholder="數量" required="" autofocus="" type="text">
        <input id="inUnit" placeholder="單位" required="" autofocus="" type="text">
        <input id="inAmt" placeholder="金額" required="" autofocus="" type="text">

		<input class="btn btn-info" type="button" value="新增" onclick="addUser();"/>
	</form>
</body>
<br><br><br>
<body>
<table id="expensesGrid"><tbody></tbody></table>
</body>
<script>
	$( document ).ready(function() {
	    initExpensesGrid();
	    findAll();
	});

	function initExpensesGrid(){
		$("#expensesGrid").jqGrid({
		      datatype: "local",
		      height: 250,
		      colNames:['請款日','發生日期', '請款店家', '發生店家','支出去向','項目','支出內容','請款人','時間','班別','單價','數量','單位','金額'],
		      colModel:[
		        {name:'billDate',index:'billDate', width:200, align:'center'},
		        {name:'realDate',index:'realDate', width:200, align:'center'},
		        {name:'billStore',index:'billStore', width:150, align:'center'},
		        {name:'realStore',index:'realStore', width:150, align:'center'},
		        {name:'source',index:'source', width:150, align:'center'},
		        {name:'accountIteam',index:'accountIteam', width:150, align:'center'},
		        {name:'detail',index:'detail', width:150, align:'center'},
		        {name:'payee',index:'payee', width:150, align:'center'},
		        {name:'workTime',index:'workTime', width:150, align:'center'},
		        {name:'workType',index:'workType', width:150, align:'center'},
		        {name:'price',index:'price', width:150, align:'center'},
		        {name:'quantity',index:'quantity', width:150, align:'center'},
		        {name:'unit',index:'unit', width:150, align:'center'},
		        {name:'amt',index:'amt', width:150, align:'center'}
		       ],
		      caption: "Expenses data grid"
		});  // jqGrid
	}

	function findAll(){
	    $.ajax({
	        type: 'GET',
	        url: "/song/expenses/queryAll",
	        dataType: "json", // data type of response

	        success: function(expensesList){
	        	for(var i in expensesList){
	        		$("#expensesGrid").jqGrid('addRowData',i+1,expensesList[i]);
	        	}
	        },

	         error:function(xhr, ajaxOptions, thrownError){
	            alert(xhr.status);
	            alert(thrownError);
	         }
	    });
	}

	function addUser(){
		$.ajax({
	        type: 'POST',
	        contentType: 'application/json',
	        url: "/song/expenses/add",
	        dataType: "json",
	        data: formToJSON(),
	        success: function(expensesList){
	            alert('add ok!');
	            $('#expensesGrid').jqGrid('clearGridData');
	        	for(var i in expensesList){
	        		$("#expensesGrid").jqGrid('addRowData',i+1,expensesList[i]);
	        	}
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	            alert('addExpenses error: ' + textStatus);
	        }
	    });
	}

	function formToJSON() {
		return JSON.stringify({
	        "billDate": new Date($('#billDate').val()),
	        "realDate": new Date($('#realDate').val()),
	        "billStore": $('#billStore').val(),
	        "realStore": $('#realStore').val(),
	        "source": $('#source').val(),
	        "accountIteam": $('#accountIteam').val(),
	        "detail": $('#detail').val(),
	        "payee": $('#payee').val(),
	        "workTime": $('#workTime').val(),
	        "workType": $('#workType').val(),
	        "price": $('#price').val(),
	        "quantity": $('#quantity').val(),
	        "unit": $('#unit').val(),
	        "amt": $('#amt').val()
	        });
	}
</script>


</html>
