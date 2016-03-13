var _form1 = "form1";
var _form2 = "form2";
var _grid1 = "grid1";
var _grid2 = "grid2";
var _table1 = "table1";
var _table2 = "table2";
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
  expenses.select2();

  // Datepicker
  $('#billDate_tool, #realDate_tool').datetimepicker({
    format: 'YYYY-MM-DD'
  });

  // grid
  expensesGrid1.watable = gridUtils.initGrid(expensesGrid1);

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
      
      var url = "/menu/getEmenu/";
      
      commonUtils.getMenu(url + "queryStroe", $('#billStore, #realStore'));
      commonUtils.getMenu(url + "querySource", $('#source'));
      commonUtils.getMenu(url + "queryPayeeUnit", $('#payeeUnit'));
      commonUtils.getMenu(url + "queryPlayer", $('#payeePlayer'));
      commonUtils.getMenu(url + "queryCompany", $('#payeeCompany'));
      commonUtils.getMenu(url + "queryGovernment", $('#payeeGovernment'));

    },

    select2: function() {
      $(".select2").select2({
        width: '100%'
      });

      // event
      $("#payeeUnit").change(function() {
        $("#payee option[value!='']").remove();
        
        if ($(this).val() == 1) {
          $("#payee").append($('#payeePlayer').html());
        } else if ($(this).val() == 2) {
          $("#payee").append($('#payeeCompany').html());
        } else if ($(this).val() == 3) {
          $("#payee").append($('#payeeGovernment').html());
        }
        
        $("#payee").val('').change();
      });
    },

    // button
    openModel: function(type) {

      if (type == 1) {
        $("#saveDetail").val("新增");
      } else {
        var chkId = $("#" + _grid2).getGridParam('selrow');
        if (!chkId) {
          BootstrapDialog.show({
            message: '請選取資料！'
          });
          return false;
        }
        
        $("#saveDetail").val("修改");
      }

      $('#table2').modal("show");

      $("#saveType").val(type);

    },

    save: function() {
      var type = $("#saveType").val();
      if (type == 1) {
        expensesSubmit.addDetail();
      } else if (type == 2) {
        expensesSubmit.updateDetail();
      } else {
        alert("err saveType");
      }
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