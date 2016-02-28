<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<!-- 最新編譯和最佳化的 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
			<!-- 選擇性佈景主題 -->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
				<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" rel="stylesheet">
					<!-- 最新編譯和最佳化的 JavaScript -->
					<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

					<%-- <script type="text/javascript" src="../test3/js/sample.js"></script> --%>
					<style>
					body {
						padding-top: 70px;
						padding-bottom: 30px;
					}

					.theme-dropdown .dropdown-menu {
						position: static;
						display: block;
						margin-bottom: 20px;
					}

					.theme-showcase > p > .btn {
						margin: 5px 0;
					}

					.theme-showcase .navbar .container {
						width: auto;
					}
					#MainTable{
						padding-top: 80px;
					}
					</style>
				</head>
				<body role="document">

					<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"><div class="container"><div class="navbar-header"><button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="#">Bootstrap theme</a></div><div id="navbar" class="navbar-collapse collapse"><ul class="nav navbar-nav"><li class="active"><a href="#">Home</a></li><li><a href="#about">About</a></li><li><a href="#contact">Contact</a></li><li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a><ul class="dropdown-menu" role="menu"><li><a href="#">Action</a></li><li><a href="#">Another action</a></li><li><a href="#">Something else here</a></li><li class="divider"></li><li class="dropdown-header">Nav header</li><li><a href="#">Separated link</a></li><li><a href="#">One more separated link</a></li></ul></li></ul></div></div></nav>

					<table ID="MainTable">
						<tr>
							<td>
								<input type = "text" id="aaa" value="ffffffff">
									<input type = "button" id="put" value= "put">
									</td>
								</tr>
							</table>
						</body>
					</html>
