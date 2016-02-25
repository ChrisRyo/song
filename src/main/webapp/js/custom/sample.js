$(document).ready(function() {

  initSample();
});

function initSample() {

  $("#put").click(function() {
    $.ajax({
      type: 'GET',
      url: "/sample",
      dataType: "json", // data type of response

      success: function(json) {
        $("#aaa").val(json.name);
      },

      error: function(xhr, ajaxOptions, thrownError) {
        alert(xhr.status);
        alert(thrownError);
      }
    });
  });

}