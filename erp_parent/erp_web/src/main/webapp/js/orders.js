

function  formateDate(value){
	return new Date(value).Format('yyyy-MM-dd');
}


function getState(value){
	switch(value * 1){
	case 0: return "未审核";
	case 1: return "已审核";
	case 2: return "已确认";
	case 3: return "已入库";
	default:return "";
	}
}

function  getDetailState(value){
	switch(value * 1){
	case 0: return "未入库";
	case 1: return "已入库";
	default:return "";
	}
	
}


$(function(){
	$("#grid").datagrid({
		url:"orders_listByPage?t1.type=1",
		columns:[[
		          {field:"uuid",title:"编号",width:100},
		          {field:"createtime",title:"生成日期",width:100,formatter:formateDate},
		          {field:"checktime",title:"审核日期",width:100,formatter:formateDate},
		          {field:"starttime",title:"确认日期",width:100,formatter:formateDate},
		          {field:"endtime",title:"入库或出库日期",width:100,formatter:formateDate},
		          {field:"createrName",title:"下单员",width:100},
		          {field:"checkerName",title:"审核员",width:100},
		          {field:"starterName",title:"采购员",width:100},
		          {field:"enderName",title:"库管员",width:100},
		          {field:"supplierName",title:"供应商",width:100},
		          {field:"totalmoney",title:"合计金额",width:100},
		          {field:"state",title:"状态",width:100,formatter:getState},
		          {field:"waybillsn",title:"运单号",width:100},
		          ]],
		singleSelect:true,
		pagination:true,
		fitColumns:true,
		onDblClickRow:function(rowIndex,rowData){
			$("#uuid").html(rowData.uuid);
			$("#suppliername").html(rowData.supplierName);
			$("#creater").html(rowData.createrName);
			$("#checker").html(rowData.checkerName);
			$("#starter").html(rowData.starterName);
			$("#enderer").html(rowData.enderName);
			$("#createtime").html(formateDate(rowData.createtime));
			$("#checktime").html(formateDate(rowData.checktime));
			$("#starttime").html(formateDate(rowData.starttime));
			$("#endtime").html(formateDate(rowData.endtime));
			$("#state").html(getDetailState(rowData.state));
			
			//打开窗口
			$("#ordersDialog").dialog("open");
			//加载订单明细数据
			$("#itemgrid").datagrid("loadData",rowData.orderDetails);
			
		}
	});
	
	//明细表格
	$('#itemgrid').datagrid({
		columns:[[
            {field:'uuid',title:'编号',width:100},
  		    {field:'goodsuuid',title:'商品编号',width:100},
  		    {field:'goodsname',title:'商品名称',width:100},
  		    {field:'price',title:'价格',width:100},
  		    {field:'num',title:'数量',width:100},
  		    {field:'money',title:'金额',width:100},
  		    {field:'state',title:'状态',width:100,formatter:getDetailState}
		]],
		fitColumns:true,
		singleSelect:true
	});
})