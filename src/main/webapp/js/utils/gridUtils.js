/**
 * chrisryo
 */
var gridUtils = function() {
  return {

    initGrid: function(grid) {
      return $('#'+grid.id).WATable({
        url: _path + grid.url,      //Url to a webservice if not setting data manually as we do in this example
        urlData: grid.formData(),   //Any data you need to pass to the webservice
        urlPost: true,              //Use POST httpmethod to webservice. Default is GET.
        debug:false,                //Prints some debug info to console
        dataBind: true,             //Auto-updates table when changing data row values. See example below. (Note. You need a column with the 'unique' property)
        pageSize: 10,               //Initial pagesize
        //pageSizePadding: true,      //Pads with empty rows when pagesize is not met
        transition: 'slide',      //Type of transition when paging (bounce, fade, flip, rotate, scroll, slide).Requires https://github.com/daneden/animate.css.
        //transitionDuration: 0.2,  //Duration of transition in seconds.
        //filter: true,               //Show filter fields
        sorting: true,              //Enable sorting
        sortEmptyLast:true,         //Empty values will be shown last
        columnPicker: true,         //Show the columnPicker button
        pageSizes: [2,10,20,30,50],   //Set custom pageSizes. Leave empty array to hide button.
        hidePagerOnEmpty: true,     //Removes the pager if data is empty.
        checkboxes: true,           //Make rows checkable. (Note. You need a column with the 'unique' property)
        checkAllToggle:false,        //Show the check-all toggle
        preFill: true,              //Initially fills the table with empty rows (as many as the pagesize).
        rownumbers: true,
        data:{
          cols: grid.coldefs(),
          rows:[]
        },
        types: { //type specific options
          string: {},
          number: {},
          bool: {},
          date: {}
        },
        tableCreated: grid.tableCreated,
        rowClicked: function (data) {
          if (typeof grid.rowClicked == 'function') {
            grid.rowClicked.call($(this), data)
          }
        },
        columnClicked: grid.columnClicked,
        pageChanged: grid.pageChanged,
        pageSizeChanged: grid.pageSizeChanged
      }).data('WATable');  //This step reaches into the html data property to get the actual WATable object. Important if you want a reference to it as we want here.
    },
  }
}();