<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="common/header.jsp" />
<!-- 自訂 css (位置要固定)-->
<c:out value="${it.page_header}" />
</head>
<jsp:include page="common/topmenu.jsp" />

<!-- Main content -->
<div id="expensesForm">
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				首頁 <small> 這是首頁</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
				<li class="active">Here</li>
			</ol>
		</section>
	</div>
</div>
<!-- /.content -->
<jsp:include page="common/endmenu.jsp" />
<jsp:include page="common/footer.jsp" />
<!-- 自訂 js (位置要固定)-->
<!-- GRID -->
<script src="plugins/jquery-watable/js/jquery.watable.js"></script>

<!-- Select2 -->
<script src="plugins/almsaeed/plugins/select2/select2.full.min.js"></script>

<!-- bootstrap time picker -->
<script src="plugins/bootstrap-moment/js/moment.js"></script>
<script src="plugins/bootstrap-moment/js/locale/zh-tw.js"></script>
<script
	src="plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>

<!-- dialog -->
<script src="plugins/bootstrap-dialog/js/bootstrap-dialog.min.js"></script>

<!-- self -->
<script type="text/javascript" src="js/expenses/expenses.js"></script>
<script type="text/javascript" src="js/expenses/expenses_valid.js"></script>
<script type="text/javascript" src="js/expenses/expenses_grid1.js"></script>
<script type="text/javascript" src="js/expenses/expenses_submit.js"></script>
</body>
</html>
