	$( document ).ready(function() {
	    initExpensesGrid();
	    findAll();
	});
	
	function initExpensesGrid(){
		
		$("#expensesGrid").jqGrid({
		      datatype: "local",
		      height: "auto",  // Grid高度
		      autowidth: true, // 自動欄寬
		      rownumbers: true,
		      multiSort : true,
		      multiselect: true,
		      colNames:['請款日','發生日期', '請款店家', '發生店家','支出去向','項目','支出內容','請款人','時間','班別','單價','數量','單位','金額'],
		      colModel:[
		        {name:'billDate',index:'billDate'},
		        {name:'realDate',index:'realDate'},
		        {name:'billStore',index:'billStore'},
		        {name:'realStore',index:'realStore'},
		        {name:'source',index:'source'},
		        {name:'accountIteam',index:'accountIteam'},
		        {name:'detail',index:'detail'},
		        {name:'payee',index:'payee'},
		        {name:'workTime',index:'workTime'},
		        {name:'workType',index:'workType'},
		        {name:'price',index:'price'},
		        {name:'quantity',index:'quantity'},
		        {name:'unit',index:'unit'},
		        {name:'amt',index:'amt'}
		       ],
		       
		      caption: "Expenses data grid",
		      rowNum:10,  // 由Server取回10筆
		      rowList:[10,20,30],  // 每頁顯示筆數
		      beforeSelectRow: function(rowid, e) // 單選
		      {
		          jQuery("#expensesGrid").jqGrid('resetSelection');
		          return(true);
		      },
		      onSelectRow: onSelectGridRow
		});  // jqGrid
	}
	
	function onSelectGridRow(id){
		var row = $("#expensesGrid").jqGrid('getRowData', id)
		
		for (var o in row) {
			$("#"+o).val(row[o]);
		}
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