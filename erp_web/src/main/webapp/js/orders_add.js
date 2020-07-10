var  editIndex = -1;

/**
 * 获取编辑器
 */
function  getEditor(field){
	return $("#grid").datagrid("getEditor",{index:editIndex,field:field});
}


/**
 * 自动合计
 */
function  sum(){
	//获取所有商品记录数
	var rows = $("#grid").datagrid("getRows");
	//定义变量存总金额
	var total = 0;
	//循环累计统计
	for(var i = 0;i < rows.length;i++){
		total += parseFloat(rows[i].money);
	}
	
	
	//加载行脚，合计
	$("#grid").datagrid("reloadFooter",[{num:"合计",money:total.toFixed(2)}]);
}

//计算
function cal(){
	//获取数量的编辑器
	var numEdit = getEditor("num");
	
	//获取价格编辑器
	var priceEdit = getEditor("outprice");
	
	//将二者金额进行*
	var num = $(numEdit.target).val();
	var price = $(priceEdit.target).val();
	
	var s =  (num * price).toFixed(2);
	
	//获取金额编辑器，将结果放进去
	var moneyEdit = getEditor("money");
	$(moneyEdit.target).val(s);
	
	sum();
	
}


/**
 * 绑定事件
 */
function bindGridEvent(){
	//得到价格编辑框
	var priceEdit = getEditor("outprice");
	
	//绑定价格拜年祭的键盘输入事件
	$(priceEdit.target).bind("keyup",function(){
		cal();
		sum();
	});
	
	
	//得到数量编辑框
	var numEdit = getEditor("num");
	
	
	//给数量比那机框绑定一个键盘输入事件
	$(numEdit.target).bind("keyup",function(){
		cal();
		sum();
	});
}



/*
 * 
 * 删除行
 * 
 */
function  deleteRow(rowIndex){
	//关闭编辑器
	$("#grid").datagrid("endEdit",editIndex);
	//删除行
	$("#grid").datagrid("deleteRow",rowIndex);
	
	//重新加载数据
	var data = $("#grid").datagrid("getData");
	
	$("#grid").datagrid("loadData",data);
	
	sum();
}




$(function(){
	$("#grid").datagrid({
		showFooter:true,
		columns:[[
		          {field:"goodsuuid",title:"商品编号",width:100,editor:{
		        	  type:"numberbox",
		        	  options:{
		        		  disabled:true
		        	  }
		          }},
		          {field:"goodsname",title:"商品名称",width:100,editor:{
		        	  type:"combobox",
		        	  options:{
		        		  url:"goods_list.action",
		        		  textField:"name",
		        		  valueField:"name",
		        		  onSelect:function(goods){
		        			  //获取商品编号的编辑器
				     			var goodsuuidEditor =  getEditor("goodsuuid");
				     			
				     			//显示选中的商品编号
				     			$(goodsuuidEditor.target).val(goods.uuid);
				     			//获取商品价格的编辑器
				     			var priceEditor =  getEditor("outprice");
				     			
				     			//显示选中的商品价格
				     			$(priceEditor.target).val(goods.outprice);
				     			
				     			cal();
				     			
				     			sum();
				     			
				     			bindGridEvent();
		        		  }
		        	  }
		          }},
		          {field:"outprice",title:"商品价格",width:100,editor:{
		        	  type:"numberbox",
		        	  options:{
		        		  precision:2
		        	  }
		        	  
		          }},
		          {field:"num",title:"数量",width:100,editor:"numberbox"},
		          {field:"money",title:"金额",width:100,editor:{
		        	  type:"numberbox",
		        	  options:{
		        		  disabled:true,
		        		  precision:2
		        	  }
		          }},
		          {field:"---",title:"操作",width:100,formatter:function(value,row,index){
		        	  
		        	  if(row.num == "合计"){
		        		  return;
		        	  }
		        	  
		        	  return "<a href='javascript:void(0);' onclick='deleteRow(" + index + ")'>删除</a>";
		          }},
		]],
		singleSelect:true,
		toolbar:[
		         {
		        	 iconCls:"icon-add",
		        	 text:"增加",
		        	 handler:function(){
		        		 //判断其他行是否存在课编辑的行
		        		 
		        		 if(editIndex > -1){
		        			 $("#grid").datagrid("endEdit",editIndex);
		        		 }
		        		 
		        		 //添加一行
		        		 $("#grid").datagrid("appendRow",{'num':0,'money':0});
		        		 
		        		 //更新索引
		        		editIndex =  $("#grid").datagrid("getRows").length - 1;
		        		 
		        		//给新开的一行开启编辑状态
		        		$("#grid").datagrid("beginEdit",editIndex);
		        		bindGridEvent();
		        		
		        	 }
		         },
		         {
		        	 text:"保存",
		        	 iconCls:"icon-save",
		        	 handler:function(){
		        		 
		        		 if($("[name='t.supplieruuid']").val().trim().length == 0){
		        			 $.messager.alert("提示","供应商不能为空哦！","info");
		        			 return ;
		        		 }
		        		 
		        		 //将表单数据序列化
		        		var formdata = $("#orderForm").serializeJSON();
		        		 //获取表格数据
		        		 $("#grid").datagrid("endEdit",editIndex);
		        		 var gridjson = JSON.stringify($("#grid").datagrid("getRows"));
		        		 //将表单数据和表格数据整合再一起
		        		 formdata['json'] = gridjson;
		        		 //通过ajax，orders_add.action
		        		 $.ajax({
		        			 url:"orders_add.action",
		        			 dataType:"json",
		        			 type:"post",
		        			 data:formdata,
		        			 success:function(result){
		        				 if(result.success){
		        					 //清空数据
		           					  $("#grid").datagrid("loadData",[{}]);
		        				 }
		        				 
		        				 $.messager.alert("提示",result.message,"info");
		        			 }
		        		 });
		        	 }
		         }
		],
		onClickRow:function(rowIndex,rowData){//给所有行绑定点击事件，开启编辑
			//关闭正在编辑的行
			$("#grid").datagrid("endEdit",editIndex);
			editIndex = rowIndex;
			
			//开启鼠标选中的那一行编辑
			$("#grid").datagrid("beginEdit",editIndex);
			
			bindGridEvent();
			
			sum();
		}
	});
	
	$("#grid").datagrid("reloadFooter",[{num:"合计",money:0}]);
	
	$("#btnCal").bind("click",function(){
		cal();
		sum();
	});
	
	
	
	/**
	 * 供应商下拉列表
	 */
	$("#supplier").combogrid({
		url:"supplier_list.action",
		idField:"uuid",
		textField:"name",
		width:500,
		columns:[[
		         {field:"uuid",title:"供应商ID",width:50},
		         {field:"name",title:"名称",width:100},
		         {field:"address",title:"地址",width:100},
		         {field:"contact",title:"联系人",width:70},
		         {field:"tele",title:"电话",width:100},
		         {field:"type",title:"类型",width:50},
		         ]]
	});
})




