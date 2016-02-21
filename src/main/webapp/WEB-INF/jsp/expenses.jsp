<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="//cdn.jsdelivr.net/jqgrid/4.5.2/jquery.jqGrid.js"></script>

<title>Sample</title>
</head>
<body>
	<form id = "expensesForm">
		<label>請款日:</label><input type="text" id="billDate"/><br/>
		<label>發生日期:</label><input type="password" id="realDate"/>
		<label>請款店家:</label><input type="text" id="billStore"/>
		<label>發生店家:</label><input type="text" id="realStore"/>
		<label>支出去向:</label><input type="text" id="source"/><br/>
		<label>項目:</label><input type="text" id="accountIteam"/>
		<label>支出內容:</label><input type="text" id="detail"/>
		<label>請款人:</label><input type="text" id="payee"/>
		<label>時間:</label><input type="text" id="workTime"/><br/>
		<label>班別:</label><input type="text" id="workType"/>
		<label>單價:</label><input type="text" id="price"/>
		<label>數量:</label><input type="text" id="quantity"/>
		<label>單位:</label><input type="text" id="unit"/><br/>
		<label>金額:</label><input type="text" id="amt"/><br/><br/>


		<input type="button" value="新增" onclick="addUser();"/>
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
	        url: "/test3/expenses/queryAll",
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
	        url: "/test3/expenses/add",
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