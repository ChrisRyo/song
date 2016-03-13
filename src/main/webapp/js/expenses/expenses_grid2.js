/**
 * chrisryo
 */
var expensesGrid1 = function() {
  return {

    id: "grid2",
    url: "/expenses/queryDetail",
    watable: new Object(),

    coldefs: function() {
      return {
        seq: {
          friendly: "流水號",
          unique: true,
          hidden: true
        },
        realDate: {
          friendly: "發生日期"
        },
        realStore: {
          friendly: "發生店家",
          format: expensesGrid1.realStoreFM
        },
        accountIteam: {
          friendly: "項目"
        },
        payeeUnit: {
          friendly: "請款單位",
          format: expensesGrid1.payeeUnitFM
        },
        payee: {
          friendly: "請款人",
          format: expensesGrid1.payeeFM
        },
        detail: {
          friendly: "支出內容"
        },
        workTime: {
          friendly: "時間"
        },
        workType: {
          friendly: "班別"
        },
        price: {
          friendly: "單價"
        },
        quantity: {
          friendly: "數量"
        },
        unit: {
          friendly: "單位"
        },
        amt: {
          friendly: "金額"
        }
      }
    },

    formDeta: function(type) {
      if ("query" == type) { return {
        "billDate": new Date($('#billDate').val()),
        "billStore": $('#billStore').val(),
        "source": $("#source").val(),
      }; }

      return {
        "seq": $("#seq").val(),
        "billDate": new Date($('#billDate').val()),
        "realDate": new Date($('#realDate').val()),
        "billStore": $('#billStore').val(),
        "realStore": $('#realStore').val(),
        "source": $('#source').val(),
        "accountIteam": $('#accountIteam').val(),
        "detail": $('#detail').val(),
        "payeeUnit": $("#payeeUnit").val(),
        "payee": $('#payee').val(),
        "workTime": $('#workTime').val(),
        "workType": $('#workType').val(),
        "price": $('#price').val(),
        "quantity": $('#quantity').val(),
        "unit": $('#unit').val(),
        "amt": $('#amt').val()
      };
    },

    rowClicked: function(data) {
      alert(data);
    },

    realStoreFM: function(val, row) {
      var val = row.billStore;
      var name = $('#realStore option[value=' + val + ']').text();
      return name == "" ? val : name;
    },

    payeeUnitFM: function(val, row) {
      var val = row.payeeUnit;
      var name = $('#payeeUnit option[value=' + val + ']').text();
      return name == "" ? val : name;
    },

    payeeFM: function(val, row) {
      var val = row.payee;
      var id = "";
      if (row.payeeUnit == 1) {
        id = "payeePlayer";
      } else if (row.payeeUnit == 2) {
        id = "payeeCompany";
      } else if (row.payeeUnit == 3) {
        id = "payeeGovernment";
      }
      var name = $('#' + id + ' option[value=' + val + ']').text();
      return name == "" ? val : name;
    }
  }
}();

//
// // onSelect
// cancelCheck1Box: function() {
// $("#cb_" + _grid1).hide();
// },
//    
// cancelCheck2Box: function() {
// $("#cb_" + _grid2).hide();
// },
//
// onBeforeSelectGrid1Row: function(rowid, e) {
// var chkId = $("#" + _grid1).getGridParam('selrow');
//
// if (rowid == chkId) {
// $("#" + _grid1).jqGrid('resetSelection');
// $("#" + _grid2).jqGrid('resetSelection');
// $("#table1").find(":input[type=text], select").val("").change();
// // hide
// expensesGrid.cancelCheck1Box();
//
// $("#table1Grid, #table2Grid").hide();
// expensesGrid.controlTable1(false);
// _tmpAmt = 0;
// return false;
// } else {
// $("#" + _grid1).jqGrid('resetSelection');
// $("#table1Grid").find(".btn-box-tool").click();
// return true;
// }
// },
//
// onSelectGrid1Row: function(rowid) {
//
// var row = $("#" + _grid1).jqGrid('getRowData', rowid);
//
// for ( var o in row) {
// $("#" + _table1 + " [id=" + o + "]").val(row[o]).change();
// }
//
// _tmpAmt = row.realTotalAmt;
//
// expensesGrid.controlTable1(true);
//
// expensesSubmit.findDetail();
//
// },
//
// onSelectGrid2Row: function(rowid) {
// var row = $("#" + _grid2).jqGrid('getRowData', rowid);
//
// for ( var o in row) {
// $("#" + _table2 + " [id=" + o + "]").val(row[o]).change();
// }
// },
//
// // table control
// controlTable1: function(falg) {
// $("#billDate, #billStore, #source").attr("disabled", falg);
//
// if (!falg) {
// $("#realTotalAmtChk").text("");
// $("#addMain").show();
// } else {
// $("#addMain").hide();
// }
// },
// initExpensesGrid: function() {
//

// beforeSelectRow: function(rowid, e) // 單選
// {
// jQuery("#" + _grid2).jqGrid('resetSelection');
// return (true);
// },
// onSelectRow: this.onSelectGrid2Row
// }); // jqGrid
//
// // hide
// this.cancelCheck1Box();
// this.cancelCheck2Box();
//
// $("#table1Grid, #table2Grid").hide();
// },
//

