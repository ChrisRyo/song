$( document ).ready(function() {
	
	alert(14123);
	
    initMemberGrid();
    
    findAll();
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
        url: "/test-webapp/rest/member",
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
        url: "/test-webapp/rest/member",
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