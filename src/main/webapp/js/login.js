function login() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: location.href,
    data: formToJSON(),
    success: function(json) {
      document.location.href= location.origin + json;
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