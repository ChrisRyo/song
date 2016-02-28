$(document).ready(function() {

  
 
});

/**
 * chrisryo
 */
var commonUtils = function() {
  return {
    /*
     * 自動將json欄位寫入grid中 (欄位必須相同)
     * 
     * @param gridId string 
     * @param jsonjson
     */
    autoJsonToGrid: function(gridId, json) {

      $("#" + gridId).jqGrid("clearGridData", true).trigger("reloadGrid");
      for ( var i in json) {
        if (json[i]["id"] != null) {
          for ( var o in json[i]["id"]) {
            json[i][o] = json[i]["id"][o];
          }
        }
        $("#" + gridId).jqGrid('addRowData', i + 1, json[i]);
      }
    },
  }
}();