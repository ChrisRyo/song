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
	        {name:'bill_date',index:'bill_date', width:300, align:'center'},
	        {name:'real_date',index:'real_date', width:300, align:'center'},
	        {name:'bill_store',index:'bill_store', width:150, align:'center'},
	        {name:'real_store',index:'real_store', width:150, align:'center'},
	        {name:'source',index:'source', width:150, align:'center'},
	        {name:'account_iteam',index:'account_iteam', width:150, align:'center'},
	        {name:'detail',index:'detail', width:150, align:'center'},
	        {name:'payee',index:'payee', width:150, align:'center'},
	        {name:'work_time',index:'work_time', width:150, align:'center'},
	        {name:'work_type',index:'work_type', width:150, align:'center'},
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
        url: "/sample-webapp/rest/expenses",
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
        "id": $('#id').val(),
        "pwd": $('#pwd').val(),
        "email": $('#email').val(),
        "phone": $('#phone').val()
        });
}