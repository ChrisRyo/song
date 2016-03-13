/**
 * chrisryo
 */
var expensesSubmit = function() {
  return {

    findMain: function() {
      expensesGrid1.watable.update(expensesSubmit.formMainToJSON(), true);
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
            message: '新增成功！'
          });
          commonUtils.autoJsonToGrid(_grid1, json.data);
          $("#table2Grid").show();
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
            message: '新增成功！'
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
            message: '更新成功！'
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
            message: '更新成功！'
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
      BootstrapDialog.confirm({
        message: '是否確定刪除?',
        type: BootstrapDialog.TYPE_WARNING,
        callback: function(result) {
          // result will be true if button was click, while it will be false if
          // users close the dialog directly.
          if (result) {
            $.ajax({
              type: 'POST',
              contentType: 'application/json',
              url: _path + "/expenses/removeDetail",
              dataType: "json",
              data: expensesSubmit.formDetailToJSON(),
              success: function(json) {
                BootstrapDialog.show({
                  message: '刪除成功！'
                });
                commonUtils.autoJsonToGrid(_grid2, json.data);
                expenses.totalAmtFormat($('#realTotalAmt').val(), json.other);
              },
              error: function(jqXHR, textStatus, errorThrown) {
                alert('addExpenses error: ' + textStatus);
              }
            });
          }
        }
      })
    },

    formMainToJSON: function() {
      return JSON.stringify({
        "billDate": new Date($('#billDate').val()),
        "billStore": $('#billStore').val(),
        "source": $("#source").val(),
        "realTotalAmt": $('#realTotalAmt').val(),
      });
    },

    formDetailToJSON: function(type) {
      if ("query" == type) { return JSON.stringify({
        "billDate": new Date($('#billDate').val()),
        "billStore": $('#billStore').val(),
        "source": $("#source").val(),
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
  }
}();