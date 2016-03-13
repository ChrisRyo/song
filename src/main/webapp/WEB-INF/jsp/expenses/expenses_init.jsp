<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp" />
<!-- 自訂 css (位置要固定)-->
<!-- GRID -->
<link rel="stylesheet" href="plugins/jquery-watable/css/watable.css">

<!-- Select2 -->
<link rel="stylesheet"
	href="plugins/almsaeed/plugins/select2/select2.min.css">

<!-- Bootstrap time Picker -->
<link rel="stylesheet"
	href="plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">

<!-- dialog -->
<link rel="stylesheet"
	href="plugins/bootstrap-dialog/css/bootstrap-dialog.min.css">
</head>
<jsp:include page="../common/topmenu.jsp" />

<!-- Main content -->
<div id="expensesForm">
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				支出功能作業 <small>支出支出支出支出支出噢！！</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
				<li class="active">Here</li>
			</ol>
		</section>
		<section class="content">
			<form id="form1">
				<!-- menu 1 -->
				<div class="box box-default" id="table1" id="form1">
					<div class="box-header with-border">
						<h3 class="box-title">支出主檔</h3>
						<div class="box-tools pull-right">
							<button class="btn btn-box-tool" data-widget="collapse">
								<i class="fa fa-minus"></i>
							</button>
						</div>
					</div>
					<!-- box-body -->
					<div class="box-body">

						<div class="form-group">
							<div class="row">
								<div class="col-md-2">
									<label>請款日期</label>
									<div class="form-group">
										<div class='input-group date' id='billDate_tool'>
											<input type='text' id='billDate' placeholder="YYYY-MM-DD" />
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
								<div class="col-md-2">
									<label>來源</label>
									<div>
										<select id="source" class="select2">
											<option value="">請選擇</option>
										</select>
									</div>
								</div>
								<div class="col-md-2">
									<label>請款店家</label>
									<div>
										<select id="billStore" class="select2">
											<option value="">請選擇</option>
										</select>
									</div>
								</div>
								<div class="col-md-2 ">
									<label>總金額 <i id="realTotalAmtChk"
										class="pull-right badge"></i>
									</label>
									<div>
										<input type="text" id="realTotalAmt" value="345345"> <input
											type="button" id="realTotalAmtUpdate"
											class="btn btn-xs btn-warning" value="金額存檔"
											onclick="expensesSubmit.updateMain();" aria-hidden="true">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<input class="btn btn-success btn-sm" type="button" value="查詢"
									onclick="expensesSubmit.findMain();" /> <input
									class="btn btn-primary btn-sm" type="button" id="addMain"
									value="新增" onclick="expensesSubmit.addMain();" />
							</div>
						</div>

					</div>
				</div>
			</form>
			<!-- grid 1 -->
			<div class="box box-default" id="table1Grid">
				<div class="box-header with-border">
					<h3 class="box-title">Main Data Table</h3>
					<div class="box-tools pull-right">
						<button class="btn btn-box-tool" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div id="grid1" style="width: 100%"></div>
				</div>
			</div>

			<!-- menu 2 -->
			<!-- Modal -->
			<div class="modal fade" id="table2" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="table2Label">支出明細</h4>
						</div>
						<div class="modal-body">
							<!-- 內容 -->
							<jsp:include page="expenses_dialog.jsp" />
							<!-- 內容 end -->
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="取消"> <input type="button" id="saveDetail"
								class="btn btn-primary" value="確認" onclick="expenses.save();">
						</div>
					</div>
				</div>
			</div>
			<!-- grid 2 -->
			<div class="box box-default" id="table2Grid">
				<div class="box-header with-border">
					<h3 class="box-title">支出明細</h3>
					<div class="box-tools pull-right">
						<button class="btn btn-box-tool" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="control-group">
						<input class="btn btn-primary btn-sm" type="button" value="新增"
							onclick="expenses.openModel(1);" /> <input
							class="btn btn-warning btn-sm" type="button" value="修改"
							onclick="expenses.openModel(2);" /> <input
							class="btn btn-danger btn-sm" type="button" value="刪除"
							onclick="expensesSubmit.deleteDetail();" />
					</div>
					<div id="grid2" style="width: 100%"></div>
				</div>
			</div>
		</section>
	</div>
</div>
<!-- /.content -->
<jsp:include page="../common/endmenu.jsp" />
<jsp:include page="../common/footer.jsp" />
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
