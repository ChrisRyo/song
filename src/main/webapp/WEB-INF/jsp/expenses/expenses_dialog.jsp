<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div>
	<form class="form-horizontal" id="form2">
		<input type="hidden" id="saveType"> <input type="hidden" id="index">
		<div class="form-group">
			<label class="col-sm-2 control-label">發生日期</label>
			<div class="col-sm-4 controls">
				<div class="input-group">
					<input type="text" id="realDate" placeholder="YYYY-MM-DD">
					<div class="input-group-addon">
						<i class="fa fa-calendar"></i>
					</div>
				</div>
			</div>
			<label class="col-sm-2 control-label">發生店家</label>
			<div class="col-sm-4 controls">
				<select id="realStore" class="select2 col-sm-4">
					<option value="">請選擇</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">支出去向</label>
			<div class="col-sm-4 controls">
				<input type="text" id="source" placeholder="支出去向" class="validate[maxSize[1]]">
			</div>
			<label class="col-sm-2 control-label">項目</label>
			<div class="col-sm-4 controls">
				<input type="text" id="accountIteam" placeholder="項目">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">請款單位</label>
			<div class="col-sm-4 controls">
				<select id="payeeUnit" class="select2"><option value="">請選擇</option></select>
			</div>
			<label class="col-sm-2 control-label">請款人</label>
			<div class="col-sm-4 controls">
				<select id="payee" class="select2 js-data-example-ajax select2"><option value="">請選擇</option></select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">支出內容</label>
			<div class="col-sm-4 controls">
				<input type="text" id="detail" placeholder="支出內容">
			</div>
			<label class="col-sm-2 control-label">時間</label>
			<div class="col-sm-4 controls">
				<input type="text" id="workTime" placeholder="時間">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">班別</label>
			<div class="col-sm-4 controls">
				<input type="text" id="workType" placeholder="班別">
			</div>
			<label class="col-sm-2 control-label">單價</label>
			<div class="col-sm-4 controls">
				<input type="text" id="price" placeholder="單價">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">數量</label>
			<div class="col-sm-4 controls">
				<input type="text" id="quantity" placeholder="數量">
			</div>
			<label class="col-sm-2 control-label">單位</label>
			<div class="col-sm-4 controls">
				<input type="text" id="unit" placeholder="單位">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">金額</label>
			<div class="col-sm-4 controls">
				<input type="text" id="amt" placeholder="金額" disabled>
			</div>
			<label class="col-sm-2 control-label">備註</label>
			<div class="col-sm-4 controls">
				<input type="text" id="mark" size="100%" placeholder="備註">
			</div>
		</div>
	</form>
</div>