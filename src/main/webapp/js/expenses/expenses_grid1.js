/**
 * chrisryo
 */
var expensesGrid1 = function() {
  return {

    id: "grid1",
    url: "/expenses/queryMain",
    watable: new Object(),

    coldefs: function() {
      return {
        billDate: {
          friendly: "請款日期",
          unique: true
        },
        source: {
          friendly: "來源",
          format: expensesGrid1.sourceFM
        },
        billStore: {
          friendly: "請款店家",
          format: expensesGrid1.billStoreFM
        },
        realTotalAmt: {
          friendly: "總金額",
        }
      }
    },

    formData: function() {
      return {
        "billDate": new Date($('#billDate').val()),
        "billStore": $('#billStore').val(),
        "source": $("#source").val(),
        "realTotalAmt": $('#realTotalAmt').val(),
      };
    },

    rowClicked: function(data) {
      var row = data.row;
      for ( var o in row) {
        $("#" + _table1 + " [id=" + o + "]").val(row[o]).change();
      }
    },

    sourceFM: function(val, row) {
      var val = row.source;
      var name = $('#source option[value=' + val + ']').text();
      return name == "" ? row.val : name;
    },

    billStoreFM: function(val, row) {
      var val = row.billStore;
      var name = $('#billStore option[value=' + val + ']').text();
      return name == "" ? row.val : name;
    },
  }
}();