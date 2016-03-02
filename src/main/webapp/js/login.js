function login() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: "/song/login/check",
    dataType: "json", // data type of response
    data: formToJSON(),
    success: function(json) {

    },
    error: function(xhr, ajaxOptions, thrownError) {
      alert(xhr.status);
      alert(thrownError);
    }
  });
}

function formToJSON() {
  return JSON.stringify({
    "account": $('#account').val(),
    "password": $('#password').val()
  });
}