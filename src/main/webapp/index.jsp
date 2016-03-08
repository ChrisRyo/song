<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang=en>
<head>
<meta charset=utf-8>
<meta http-equiv=X-UA-Compatible content="IE=edge">
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name=description content="">
<meta name=author content="">
<link rel=icon href=/Content/AssetsBS3/img/favicon.ico>
<title>Signin Template for Bootstrap</title>
<link
	href=https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css
	rel=stylesheet>
<link href=plugins/bootstrap/css/signin.css rel=stylesheet>
<link href="plugins/bootstrap-validator/css/bootstrapValidator.css"
	rel="stylesheet" />

<!-- jQuery 2.1.4 -->
<script src="plugins/almsaeed/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!--[if lt IE 9]><script src=~/Scripts/AssetsBS3/ie8-responsive-file-warning.js></script><![endif]-->
<script src=plugins/bootstrap/js/ie-emulation-modes-warning.js></script>
<!--[if lt IE 9]><script src=https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js></script><script src=https://oss.maxcdn.com/respond/1.4.2/respond.min.js></script><![endif]-->


<script src="plugins/almsaeed/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="plugins/bootstrap-validator/js/bootstrapValidator.js"></script>
<body>
	<div class=container>
		<form id="defaultForm" method="post" class="form-horizontal"
			action="target.php">
			<div class="form-group">
				<label class="col-lg-3 control-label">用户名</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" id="username" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-lg-3 control-label">邮箱</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" id="email" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-lg-3 control-label">生日</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" id="birthday" />
					(YYYY/MM/DD)
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3">
					<button type="submit" class="btn btn-primary" name="signup"
						value="Sign up">提交</button>
					<button type="button" class="btn btn-info" id="validateBtn">自动验证</button>
					<button type="button" class="btn btn-info" id="resetBtn">重置表单</button>
				</div>
			</div>
		</form>
	</div>
	<script src=plugins/bootstrap/js/ie10-viewport-bug-workaround.js></script>
	<script>
    $('#defaultForm').bootstrapValidator({
      message: 'This value is not valid',
      feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
      },
      fields: {
        username: {
          selector: '#username',
          message: 'The username is not valid',
          validators: {
            notEmpty: {
              message: 'The username is required and cannot be empty'
            },
            stringLength: {
              min: 6,
              max: 30,
              message: 'The username must be more than 6 and less than 30 characters long'
            },
            regexp: {
              regexp: /^[a-zA-Z0-9_\.]+$/,
              message: 'The username can only consist of alphabetical, number, dot and underscore'
            },
            remote: {
              url: 'remote.php',
              message: 'The username is not available'
            },
            different: {
              field: 'password',
              message: 'The username and password cannot be the same as each other'
            }
          }
        },
        email: {
          selector: '#email',
          validators: {
            emailAddress: {
              message: 'The input is not a valid email address'
            }
          }
        },
      }
    });
  </script>
</body>
</html>