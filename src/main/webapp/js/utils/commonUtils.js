/**
 * chrisryo
 */
var commonUtils = function() {
  return {
    /*
     * 自動將json欄位寫入grid中 (欄位必須相同)
     * 
     * @param gridId string @param jsonjson
     */
    autoJsonToGrid: function(gridId, json) {

      $("#" + gridId).jqGrid("clearGridData", true);
      for ( var i in json) {
        if (json[i]["id"] != null) {
          for ( var o in json[i]["id"]) {
            json[i][o] = json[i]["id"][o];
          }
        }
        $("#" + gridId).jqGrid('addRowData', i + 1, json[i]);
      }
    },

    getMenu: function(url, selectObj) {
      $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: _path + url,
        dataType: "json",
        success: function(json) {
          for ( var o in json) {
            selectObj.append('<option value="' + json[o].id + '">' + json[o].text + '</option>');
          }
        },
        error: function(xhr, ajaxOptions, thrownError) {
          alert(xhr.status);
          alert(thrownError);
        }
      });
    },
  }
}();