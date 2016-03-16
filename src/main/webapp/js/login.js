function login() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: location.href,
    data: formToJSON(),
    success: function(json) {
      if (json.resultCode == 0) {
        alert("登入成功！");
        document.location.href = location.origin + json.data;
      } else {
        alert(json.data);
      }
    },
    error: function(xhr, ajaxOptions, thrownError) {
      alert(xhr.status);
      alert(thrownError);
    }
  });
}

function formToJSON() {
  return JSON.stringify({
    "userName": $('#userName').val(),
    "pwd": $('#pwd').val()
  });
}