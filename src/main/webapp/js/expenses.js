$(document).ready(function() {

  // input style
  $(":input[type=text]").addClass("form-control input-sm");
  $("select").addClass("form-control");

  // 取下拉選單
  initMenu();

  // TODO 為了消除死不隱藏的 aria-hidden=true
  $("[aria-hidden=true]").hide();

  // select2
  $(".select2").select2({
    width: '100%'
  });

  initExpensesGrid();

  // 表單驗證
  comValidation.validationInit(condition1, "form1");
  comValidation.validationInit(condition2, "form2");
});

var condition1 = [{
  name: "billDate",
  rule: "validate[custom[date]]"
}, {
  name: "billStore",
  rule: "validate[maxSize[20]]"
}, {
  name: "realTotalAmt",
  rule: "validate[custom[number]], max[999999999999999]"
}];

var condition2 = [{
  name: "realDate",
  rule: "validate[custom[date]]"
}, {
  name: "realStore",
  rule: "validate[maxSize[20]]"
}, {
  name: "source",
  rule: "validate[maxSize[20]]"
}, {
  name: "accountIteam",
  rule: "validate[maxSize[20]]"
}, {
  name: "detail",
  rule: "validate[maxSize[60]]"
}, {
  name: "payeeUnit",
  rule: "validate[maxSize[1]]"
}, {
  name: "payee",
  rule: "validate[maxSize[20]]"
}, {
  name: "workTime",
  rule: "validate[maxSize[20]]"
}, {
  name: "workType",
  rule: "validate[validate[custom[number]], maxSize[1]], validate[max[9]]"
}, {
  name: "price",
  rule: "validate[custom[number]], max[999999999999999]"
}, {
  name: "quantity",
  rule: "validate[custom[number]], max[999999999999999]"
}, {
  name: "unit",
  rule: "validate[maxSize[20]]"
}, {
  name: "amt",
  rule: "validate[custom[number]], max[999999999999999]"
}, {
  name: "mark",
  rule: "validate[maxSize[60]]"
}];

function initMenu() {
  $.ajax({
    type: 'GET',
    contentType: 'application/json',
    url: "/song/menu/queryStroe",
    dataType: "json", // data type of response
    success: function(json) {
      for ( var o in json) {
        $('#billStore, #realStore').append(
                '<option value="' + json[o].key + '">' + json[o].value
                        + '</option>');
      }
    },
    error: function(xhr, ajaxOptions, thrownError) {
      alert(xhr.status);
      alert(thrownError);
    }
  });

  $.ajax({
    type: 'GET',
    contentType: 'application/json',
    url: "/song/menu/queryPayeeUnit",
    dataType: "json", // data type of response
    success: function(json) {
      for ( var o in json) {
        $('#payeeUnit').append(
                '<option value="' + json[o].key + '">' + json[o].value
                        + '</option>');
      }
    },
    error: function(xhr, ajaxOptions, thrownError) {
      alert(xhr.status);
      alert(thrownError);
    }
  });

  $("#payee").select2(
          {
            width: "70%", // 若你的版面是 RWD 可以這樣，讓他重新調整寬度
            placeholder: "要查找的會員編號",

            // 使用如$.ajax 參閱 ajax
            ajax: {
              url: "/song/menu/queryPayee?unit=" + $("#payeeUnit").val()
                      + "&name=" + $("#payee").val(),
              dataType: 'json',
              type: "GET",
              // 成功返回的項目
              results: function(data) {
                // 因為 dataType: 'html' 所以要自己解碼喔。但用html可以方便debug。
                console.log(data);

                var obj = $.parseJSON(data);
                if (obj.status == "success") return {
                  results: obj.data
                };

                // 假設我自己回傳的值不等於success，我希望選單項目是空的 :D 可以這麼寫
                var empty = [{
                  id: 0,
                  text: null
                }]
                return {
                  results: empty
                };
              },
              error: function(xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
              }
            }
          });

}

function initExpensesGrid() {

  $("#grid1").jqGrid({
    datatype: "json",
    styleUI: 'Bootstrap',// 设置jqgrid的全局样式为bootstrap样式
    viewrecords: true,
    multiselect: true,
    rownumbers: true,
    autowidth: true,
    height: "auto",
    rowNum: 20,
    rownumbers: true, // 显示行号
    rownumWidth: 35, // the width of the row numbers columns
    pager: "#jqGrid1Pager",// 分页控件的id
    subGrid: false,// 是否启用子表格
    rowNum: 10, // 由Server取回10筆
    rowList: [10, 20, 30], // 每頁顯示筆數
    colNames: ['請款日期', '請款店家', '請款店家', '總金額'],
    colModel: [{
      name: 'billDate',
      index: 'billDate'
    }, {
      name: 'billStore',
      index: 'billStore',
      hidden: true
    }, {
      name: 'billStoreF',
      index: 'billStoreF',
      formatter: formatBillStore
    }, {
      name: 'realTotalAmt',
      index: 'realTotalAmt'
    }],
    beforeSelectRow: onBeforeSelectGrid1Row,
    onSelectRow: onSelectGrid1Row,
    gridComplete: cancelCheck1Box
  }); // jqGrid

  $("#grid2").jqGrid(
          {
            datatype: "json",
            styleUI: 'Bootstrap',// 设置jqgrid的全局样式为bootstrap样式
            viewrecords: true,
            multiselect: true,
            rownumbers: true,
            autowidth: true,
            height: "auto",
            rowNum: 20,
            rownumbers: true, // 显示行号
            rownumWidth: 35, // the width of the row numbers columns
            pager: "#jqGrid2Pager",// 分页控件的id
            subGrid: false,// 是否启用子表格
            rowNum: 10, // 由Server取回10筆
            rowList: [10, 20, 30], // 每頁顯示筆數
            colNames: ['', '發生日期', '發生店家', '支出去向', '項目', '請款單位', '請款人', '支出內容',
                '時間', '班別', '單價', '數量', '單位', '金額'],
            colModel: [{
              name: 'index',
              index: 'index',
              hidden: true
            }, {
              name: 'realDate',
              index: 'realDate'
            }, {
              name: 'realStore',
              index: 'realStore'
            }, {
              name: 'source',
              index: 'source'
            }, {
              name: 'accountIteam',
              index: 'accountIteam'
            }, {
              name: 'payeeUnit',
              index: 'payeeUnit'
            }, {
              name: 'payee',
              index: 'payee'
            }, {
              name: 'detail',
              index: 'detail'
            }, {
              name: 'workTime',
              index: 'workTime'
            }, {
              name: 'workType',
              index: 'workType'
            }, {
              name: 'price',
              index: 'price'
            }, {
              name: 'quantity',
              index: 'quantity'
            }, {
              name: 'unit',
              index: 'unit'
            }, {
              name: 'amt',
              index: 'amt'
            }],
            beforeSelectRow: function(rowid, e) // 單選
            {
              jQuery("#" + grid2).jqGrid('resetSelection');
              return (true);
            },
            onSelectRow: onSelectGrid2Row,
            gridComplete: cancelCheck2Box
          }); // jqGrid

  // hide
  cancelCheck1Box();
  cancelCheck2Box();

  $("#table1Grid, #table2Grid").hide();
}

// format
function formatBillStore(cellvalue, options, rowObject) {
  var val = rowObject.billStore;
  var name = $('#billStore option[value=' + val + ']').text();
  return name == "" ? val : name;
}

// table control
function controlTable1(falg) {
  $("#billDate, #billStore").attr("disabled", falg);
}

// onSelect
function cancelCheck1Box() {
  $("#cb_grid1").hide();
}
function cancelCheck2Box() {
  $("#cb_grid2").hide();
}

function onBeforeSelectGrid1Row(rowid, e) {
  var chkId = $("#grid1").getGridParam('selrow');

  if (rowid == chkId) {
    $("#grid1").jqGrid('resetSelection');
    $("#table1").find(":input[type=text], select").val("").change();
    controlTable1(false);
    return false;
  } else {
    $("#grid1").jqGrid('resetSelection');
    $("#table1Grid").find(".btn-box-tool").click();
    return true;
  }
}

function onSelectGrid1Row(rowid) {

  var row = $("#grid1").jqGrid('getRowData', rowid);

  for ( var o in row) {
    $("#" + o).val(row[o]).change();
  }

  controlTable1(true);

  findDetail();

}

function onSelectGrid2Row(id) {

}

// button
function openModel(type) {

  $('#table2').modal("show");

  var id = $("#grid2").getGridParam('selrow');

  var row = $("#grid2").jqGrid('getRowData', id)

  for ( var o in row) {
    $("#" + o).val(row[o]);
  }

  $("#saveType").val(type);

}

function save() {
  var type = $("#saveType").val();
  if (type == 1) {
    addDetail();
  } else if (type == 2) {
    updateDetail();
  } else {
    alert("err saveType");
  }
}

// event
function findMain() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: "/song/expenses/queryMain",
    dataType: "json", // data type of response
    data: formMainToJSON(),
    success: function(json) {
      commonUtils.autoJsonToGrid("grid1", json);
      $("#table1Grid").show();
    },
    error: function(xhr, ajaxOptions, thrownError) {
      alert(xhr.status);
      alert(thrownError);
    }
  });
}

function findDetail() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: "/song/expenses/queryDetail",
    dataType: "json", // data type of response
    data: formDetailToJSON("query"),
    success: function(json) {
      commonUtils.autoJsonToGrid("grid2", json);
      $("#table2Grid").show();
    },
    error: function(xhr, ajaxOptions, thrownError) {
      alert(xhr.status);
      alert(thrownError);
    }
  });
}

function addMain() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: "/song/expenses/addMain",
    dataType: "json",
    data: formMainToJSON(),
    success: function(json) {
      alert('add ok!');
      commonUtils.autoJsonToGrid(grid1, json);
    },
    error: function(jqXHR, textStatus, errorThrown) {
      alert('addExpenses error: ' + textStatus);
    }
  });
}

function addDetail() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: "/song/expenses/addDetail",
    dataType: "json",
    data: formDetailToJSON(),
    success: function(json) {
      alert('add ok!');
      commonUtils.autoJsonToGrid(grid2, json);
    },
    error: function(jqXHR, textStatus, errorThrown) {
      alert('addExpenses error: ' + textStatus);
    }
  });
}

function updateDetail() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: "/song/expenses/updateDetail",
    dataType: "json",
    data: formDetailToJSON(),
    success: function(json) {
      alert('update ok!');
      commonUtils.autoJsonToGrid(grid2, json);
    },
    error: function(jqXHR, textStatus, errorThrown) {
      alert('addExpenses error: ' + textStatus);
    }
  });
}

function deleteDetail() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: "/song/expenses/deleteDetail",
    dataType: "json",
    data: formDetailToJSON(),
    success: function(json) {
      alert('delete ok!');
      commonUtils.autoJsonToGrid(grid2, json);
    },
    error: function(jqXHR, textStatus, errorThrown) {
      alert('addExpenses error: ' + textStatus);
    }
  });
}

function formMainToJSON() {
  return JSON.stringify({
    "billDate": new Date($('#billDate').val()),
    "billStore": $('#billStore').val(),
    "realTotalAmt": $('#realTotalAmt').val(),
  });
}

function formDetailToJSON(type) {
  if ("query" == type) { return JSON.stringify({
    "billDate": new Date($('#billDate').val()),
    "billStore": $('#billStore').val(),
  }); }

  return JSON.stringify({
    "index": $("#index").val(),
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