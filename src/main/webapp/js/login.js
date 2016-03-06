$(function() {

  // none, bounce, rotateplane, stretch, orbit,
  // roundBounce, win8, win8_linear or ios
  var current_effect = 'bounce'; //
  $('#demo').click(function() {
    run_waitMe(current_effect);
  });
});

function login() {
  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: location.href,
    data: formToJSON(),
    success: function(json) {
      if (json.status) {
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
    "account": $('#account').val(),
    "password": $('#password').val()
  });
}