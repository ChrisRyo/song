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

<title>sampleWork</title>
</head>
<body>
	<form id = "memberForm">
		<label>User Name:</label><input type="text" id="id"/><br/>
		<label>Password:</label><input type="password" id="pws"/><br/>
		<label>email:</label><input type="text" id="email"/><br/>
		<label>phone:</label><input type="text" id="phone"/><br/>
		<input type="button" value="query" onclick="findAll();"/>
		<input type="button" value="新增" onclick="addUser();"/>
	</form>
</body>
<br><br><br>
<body>
<table id="memberGrid"><tbody></tbody></table>
</body>
<script>
$( document ).ready(function() {
    initMemberGrid();
});

function initMemberGrid(){
	$("#memberGrid").jqGrid({
	      datatype: "local",
	      height: 250,
	      colNames:['帳號','密碼', 'E-MAIL', '電話'],
	      colModel:[
	        {name:'id',index:'id', width:90, align:'center'},
	        {name:'pws',index:'invdate', width:90, align:'center', edittype:"password"},
	        {name:'email',index:'email', width:150, align:'center'},
	        {name:'phone',index:'phone', width:100, align:'center'}
	      ],
	      caption: "Member data grid"
	});  // jqGrid
}

function findAll(){
    $.ajax({
        type: 'GET',
        url: "/test3/member/queryAll",
        dataType: "json", // data type of response
        
        success: function(memberList){
        	for(var i in memberList){
        		$("#memberGrid").jqGrid('addRowData',i+1,memberList[i]); 
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
        url: "/test3/member/add",
        dataType: "json",
        data: formToJSON(),
        success: function(memberList){
            alert('add ok!');
            $('#memberGrid').jqGrid('clearGridData');
        	for(var i in memberList){
        		$("#memberGrid").jqGrid('addRowData',i+1,memberList[i]); 
        	}
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('addMember error: ' + textStatus);
        }
    });
}

function formToJSON() {
	return JSON.stringify({
        "id": $('#id').val(),
        "pws": $('#pws').val(),
        "email": $('#email').val(),
        "phone": $('#phone').val()
        });
}

</script>
</html>