var _form1 = "form1";
var _form2 = "form2";
var _grid1 = "grid1";
var _grid2 = "grid2";
var _tmpAmt;

$(document).ready(function() {

  // input style
  $(":input[type=text]").addClass("form-control input-sm");
  $("select").addClass("form-control");

  // 取下拉選單
  expenses.initMenu();

  // TODO 為了消除死不隱藏的 aria-hidden=true
  $("[aria-hidden=true]").hide();

  // select2
  $("#billStore, #realStore, #payeeUnit").select2({
    width: '100%'
  });

  // Datepicker
  $('#billDate, #realDate').datepicker({
    language: "zh-TW",
    todayBtn: true,
    format: "yyyy-mm-dd"
  });

  expensesGrid.initExpensesGrid();

  // 表單驗證
  comValidation.validationInit(expensesValid.condition1(), _form1);
  comValidation.validationInit(expensesValid.condition2(), _form2);

  // event
  $("#realTotalAmt").change(function() {
    expenses.totalAmtFormat($(this).val(), $("#realTotalAmtChk").text());
  }).blur(function() {
    if (_tmpAmt != $(this).val()) {
      $("#realTotalAmtUpdate").show();
    } else {
      $("#realTotalAmtUpdate").hide();
    }
  });

  $("#price, #quantity").change(function() {
    $("#amt").val($("#price").val() * $("#quantity").val());
  });

});

/**
 * chrisryo
 */
var expenses = function() {
  return {

    initMenu: function() {
      $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: _path + "/menu/queryStroe",
        dataType: "json", // data type of response
        success: function(json) {
          for ( var o in json) {
            $('#billStore, #realStore').append(
                    '<option value="' + json[o].id + '">' + json[o].text + '</option>');
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
        url: _path + "/menu/queryPayeeUnit",
        dataType: "json", // data type of response
        success: function(json) {
          for ( var o in json) {
            $('#payeeUnit').append(
                    '<option value="' + json[o].id + '">' + json[o].text + '</option>');
          }
        },
        error: function(xhr, ajaxOptions, thrownError) {
          alert(xhr.status);
          alert(thrownError);
        }
      });

      $("#payee").select2({
        ajax: {
          url: _path + "/menu/queryPayee",
          dataType: 'json',
          type: "GET",

          // 夾帶參數
          data: function(info, page) {
            return {
              unit: $('#payeeUnit').val(),
              name: info.term, // 在上面打的搜尋文字項目
              page_limit: 10, // page size
              page: page, // page number
            };
          },

          // 成功返回的項目
          processResults: function(data, params) {
            return {
              results: data
            };
          },
        },
        width: "100%",
        placeholder: "請款人",
      });

      // event
      $("#payeeUnit").change(function() {
        $("#payee option[value!='']").remove();
        $("#payee").val('').change();
      });
    },

    // button
    openModel: function(type) {
      
      if (type == 1) {
        $("#saveDetail").val("新增");
      } else {
        $("#saveDetail").val("修改");
      }

      $('#table2').modal("show");

      var id = $("#" + _grid2).getGridParam('selrow');

      var row = $("#" + _grid2).jqGrid('getRowData', id)

      for ( var o in row) {
        $("#" + o).val(row[o]);
      }

      $("#saveType").val(type);

    },

    save: function() {
      var type = $("#saveType").val();
      if (type == 1) {
        this.addDetail();
      } else if (type == 2) {
        this.updateDetail();
      } else {
        alert("err saveType");
      }
    },

    // event
    findMain: function() {
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: _path + "/expenses/queryMain",
        dataType: "json", // data type of response
        data: this.formMainToJSON(),
        success: function(json) {
          commonUtils.autoJsonToGrid(_grid1, json.data);
          $("#table1Grid").show();
        },
        error: function(xhr, ajaxOptions, thrownError) {
          alert(xhr.status);
          alert(thrownError);
        }
      });
    },

    findDetail: function() {
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: _path + "/expenses/queryDetail",
        dataType: "json", // data type of response
        data: this.formDetailToJSON("query"),
        success: function(json) {
          commonUtils.autoJsonToGrid(_grid2, json.data);
          expenses.totalAmtFormat($('#realTotalAmt').val(), json.other);
          $("#table2Grid").show();
        },
        error: function(xhr, ajaxOptions, thrownError) {
          alert(xhr.status);
          alert(thrownError);
        }
      });
    },

    addMain: function() {
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: _path + "/expenses/addMain",
        dataType: "json",
        data: this.formMainToJSON(),
        success: function(json) {
          BootstrapDialog.show({
            message:'新增成功！'
          });
          commonUtils.autoJsonToGrid(_grid1, json.data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
          alert('addExpenses error: ' + textStatus);
        }
      });
    },

    addDetail: function() {
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: _path + "/expenses/addDetail",
        dataType: "json",
        data: this.formDetailToJSON(),
        success: function(json) {
          BootstrapDialog.show({
            message:'新增成功！'
          });
          commonUtils.autoJsonToGrid(_grid2, json.data);
          expenses.totalAmtFormat($('#realTotalAmt').val(), json.other);
        },
        error: function(jqXHR, textStatus, errorThrown) {
          alert('addExpenses error: ' + textStatus);
        }
      });
    },
    
    updateMain: function() {
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: _path + "/expenses/updateMain",
        dataType: "json",
        data: this.formMainToJSON(),
        success: function(json) {
          BootstrapDialog.show({
            message:'更新成功！'
          });
          _tmpAmt = $("#realTotalAmt");
          $("#realTotalAmtUpdate").hide();
          commonUtils.autoJsonToGrid(_grid1, json.data);
          $("#table1Grid").show();
        },
        error: function(jqXHR, textStatus, errorThrown) {
          alert('addExpenses error: ' + textStatus);
        }
      });
    },

    updateDetail: function() {
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: _path + "/expenses/updateDetail",
        dataType: "json",
        data: this.formDetailToJSON(),
        success: function(json) {
          BootstrapDialog.show({
            message:'更新成功！'
          });
          commonUtils.autoJsonToGrid(_grid2, json.data);
          expenses.totalAmtFormat($('#realTotalAmt').val(), json.other);
        },
        error: function(jqXHR, textStatus, errorThrown) {
          alert('addExpenses error: ' + textStatus);
        }
      });
    },

    deleteDetail: function() {
      $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: _path + "/expenses/deleteDetail",
        dataType: "json",
        data: this.formDetailToJSON(),
        success: function(json) {
          alert('delete ok!');
          commonUtils.autoJsonToGrid(_grid2, json.data);
          expenses.totalAmtFormat($('#realTotalAmt').val(), json.other);
        },
        error: function(jqXHR, textStatus, errorThrown) {
          alert('addExpenses error: ' + textStatus);
        }
      });
    },

    formMainToJSON: function() {
      return JSON.stringify({
        "billDate": new Date($('#billDate').val()),
        "billStore": $('#billStore').val(),
        "realTotalAmt": $('#realTotalAmt').val(),
      });
    },

    formDetailToJSON: function(type) {
      if ("query" == type) { return JSON.stringify({
        "billDate": new Date($('#billDate').val()),
        "billStore": $('#billStore').val(),
      }); }

      return JSON.stringify({
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
      });
    },
    
    totalAmtFormat: function(realTotalAmt, chkTotalAmt) {
      if (realTotalAmt != chkTotalAmt) {
        $("#realTotalAmtChk").removeClass("bg-green").addClass("bg-red").text(chkTotalAmt);
      } else {
        $("#realTotalAmtChk").removeClass("bg-red").addClass("bg-green").text(chkTotalAmt);
      }

    }
  }
}();