/**
 * chrisryo
 */
var expensesGrid = function() {
  return {

    initExpensesGrid: function() {

      $("#" + _grid1).jqGrid({
        datatype: "json",
        styleUI: 'Bootstrap',
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
        colNames: ['請款日期', '來源', '請款店家h', '請款店家', '總金額'],
        colModel: [{
          name: 'billDate',
          index: 'billDate'
        }, {
          name: 'source',
          index: 'source'
        }, {
          name: 'billStore',
          index: 'billStore',
          hidden: true
        }, {
          name: 'billStoreF',
          index: 'billStoreF',
          formatter: this.formatBillStore
        }, {
          name: 'realTotalAmt',
          index: 'realTotalAmt'
        }],
        beforeSelectRow: this.onBeforeSelectGrid1Row,
        onSelectRow: this.onSelectGrid1Row,
        gridComplete: this.cancelCheck1Box
      }); // jqGrid

      $("#" + _grid2).jqGrid(
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
                colNames: ['', '發生日期', '發生店家h', '發生店家', '項目', '請款單位h', '請款單位', '請款人h', '請款人',
                    '支出內容', '時間', '班別', '單價', '數量', '單位', '金額'],
                colModel: [{
                  name: 'seq',
                  index: 'seq',
                  hidden: true
                }, {
                  name: 'realDate',
                  index: 'realDate'
                }, {
                  name: 'realStore',
                  index: 'realStore',
                  hidden: true
                }, {
                  name: 'realStoreF',
                  index: 'realStoreF',
                  formatter: this.formatRealStore
                }, {
                  name: 'accountIteam',
                  index: 'accountIteam'
                }, {
                  name: 'payeeUnit',
                  index: 'payeeUnit',
                  hidden: true
                }, {
                  name: 'payeeUnitF',
                  index: 'payeeUnitF',
                  formatter: this.formatPayeeUnit
                }, {
                  name: 'payee',
                  index: 'payee',
                  hidden: true
                }, {
                  name: 'payeeF',
                  index: 'payeeF',
                  formatter: this.formatPayee

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
                  jQuery("#" + _grid2).jqGrid('resetSelection');
                  return (true);
                },
                onSelectRow: this.onSelectGrid2Row
              }); // jqGrid

      // hide
      this.cancelCheck1Box();
      this.cancelCheck2Box();

      $("#table1Grid, #table2Grid").hide();
    },

    // format
    formatRealStore: function(cellvalue, options, rowObject) {
      var val = rowObject.billStore;
      var name = $('#realStore option[value=' + val + ']').text();
      return name == "" ? val : name;
    },

    formatBillStore: function(cellvalue, options, rowObject) {
      var val = rowObject.billStore;
      var name = $('#billStore option[value=' + val + ']').text();
      return name == "" ? val : name;
    },

    formatPayeeUnit: function(cellvalue, options, rowObject) {
      var val = rowObject.payeeUnit;
      var name = $('#payeeUnit option[value=' + val + ']').text();
      return name == "" ? val : name;
    },

    formatPayee: function(cellvalue, options, rowObject) {
      var val = rowObject.payee;
      var id = "";
      if (rowObject.payeeUnit == 1) {
        id = "payeePlayer";
      } else if (rowObject.payeeUnit == 2) {
        id = "payeeCompany";
      } else if (rowObject.payeeUnit == 3) {
        id = "payeeGovernment";
      }

      var name = $('#' + id + ' option[value=' + val + ']').text();
      return name == "" ? val : name;
    },

    // onSelect
    cancelCheck1Box: function() {
      $("#cb_" + _grid1).hide();
    },
    
    cancelCheck2Box: function() {
      $("#cb_" + _grid2).hide();
    },

    onBeforeSelectGrid1Row: function(rowid, e) {
      var chkId = $("#" + _grid1).getGridParam('selrow');

      if (rowid == chkId) {
        $("#" + _grid1).jqGrid('resetSelection');
        $("#" + _grid2).jqGrid('resetSelection');
        $("#table1").find(":input[type=text], select").val("").change();
        // hide
        expensesGrid.cancelCheck1Box();

        $("#table1Grid, #table2Grid").hide();
        expensesGrid.controlTable1(false);
        _tmpAmt = 0;
        return false;
      } else {
        $("#" + _grid1).jqGrid('resetSelection');
        $("#table1Grid").find(".btn-box-tool").click();
        return true;
      }
    },

    onSelectGrid1Row: function(rowid) {

      var row = $("#" + _grid1).jqGrid('getRowData', rowid);

      for ( var o in row) {
        $("#" + _table1 + " [id=" + o + "]").val(row[o]).change();
      }

      _tmpAmt = row.realTotalAmt;

      expensesGrid.controlTable1(true);

      expensesSubmit.findDetail();

    },

    onSelectGrid2Row: function(rowid) {
      var row = $("#" + _grid2).jqGrid('getRowData', rowid);

      for ( var o in row) {
        $("#" + _table2 + " [id=" + o + "]").val(row[o]).change();
      }
    },

    // table control
    controlTable1: function(falg) {
      $("#billDate, #billStore, #source").attr("disabled", falg);

      if (!falg) {
        $("#realTotalAmtChk").text("");
        $("#addMain").show();
      } else {
        $("#addMain").hide();
      }
    },
  }
}();