<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp" />
<!-- 自訂 css (位置要固定)-->
<!-- jqgrid -->
<link rel="stylesheet" href="plugins/jqGrid/css/ui.jqgrid.css">

<!-- Select2 -->
<link rel="stylesheet" href="plugins/almsaeed/plugins/select2/select2.min.css">

<!-- dialog -->
<link rel="stylesheet" href="plugins/bootstrap/css/bootstrap-dialog.min.css">
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
									<div>
										<input type="text" id="billDate" placeholder="YYYY-MM-DD">
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
									<label>總金額<span id="realTotalAmtChk" class="pull-right badge">bg-green</span></label>
									<div>
										<input type="text" id="realTotalAmt">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<input class="btn btn-success btn-sm" type="button" value="查詢" onclick="findMain();" /> <input class="btn btn-primary btn-sm" type="button"
									value="新增" onclick="addMain();" /> <input class="btn btn-warning btn-sm" type="button" value="修改金額" onclick="updateTotalAmt();" />
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
					<div class="form-group">
						<div class="jqGrid_wrapper">
							<table id="grid1"></table>
							<div id="jqGrid1Pager"></div>
						</div>
					</div>
				</div>
			</div>

			<!-- menu 2 -->
			<!-- Modal -->
			<div class="modal fade" id="table2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-primary" onclick="save();">確認</button>
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
						<input class="btn btn-primary btn-sm" type="button" value="新增" onclick="openModel(1);" /> <input class="btn btn-warning btn-sm" type="button"
							value="修改" onclick="openModel(2);" /> <input class="btn btn-danger btn-sm" type="button" value="刪除" onclick="deleteDetail();" />
					</div>
					<div class="jqGrid_wrapper">
						<table id="grid2"></table>
						<div id="jqGrid2Pager"></div>
					</div>
				</div>
			</div>
		</section>
	</div>
</div>
<!-- /.content -->
<jsp:include page="../common/endmenu.jsp" />
<jsp:include page="../common/footer.jsp" />
<!-- 自訂 js (位置要固定)-->
<!-- jqgrid -->
<script src="plugins/jqGrid/js/jquery.jqGrid.min.js"></script>
<script src="plugins/jqGrid/js/grid.locale-tw.js"></script>
<!-- Select2 -->
<script src="plugins/almsaeed/plugins/select2/select2.full.min.js"></script>
<!-- dialog -->
<script src="plugins/bootstrap/js/bootstrap-dialog.min.js"></script>

<script type="text/javascript" src="js/expenses.js"></script>
</body>
</html>
