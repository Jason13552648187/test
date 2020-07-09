//将操作部门的方法提取成一个变量
var method = "";


/**
 * 修改
 * @param id
 */
function edit(id){
	method="update";
	//打开编辑窗口
	$("#editDialog").dialog("open");
	//清空表单的数据
	$("#editForm").form("clear");
	//加载表单数据：数据回显到弹框里
	$("#editForm").form("load",name + "_get.action?id="+id);
	
}






/**
 * 删除部门
 * @param id
 */
function dele(id){
	//调用后台完成删除操作
	
	$.messager.confirm("提示","确定要删除吗？",function(value){//value就是点击true  false
		if(value){
			$.ajax({
				url:name + "_delete.action?id=" + id,
				dataType:"json",
				success:function(result){//result就是后台返回数据
					$.messager.alert("提示",result.message);
					if(result.success){
						//重新刷新表格
						$("#grid").datagrid("reload");
					}
				}
			});
		}
	});
}



$(document).ready(function(){
	
	$("#grid").datagrid({
		url:name + "_listByPage.action",
		columns:columns,
		singleSelect:true,
		pagination:true,
		toolbar:[
		         {
		        	 text:"新增",
		        	 iconCls:"icon-add",
		        	 handler:function(){
		        		 method = "add";
		        		 //弹出对话框
		        		 $("#editForm").form("clear");
		        		 $("#editDialog").dialog("open");
		        	 }
		         }
		         ]
	});
	
	
	//条件查询
	$("#btnSearch").bind("click",function(){
		
		//将表单的数据进行序列化
		var formdata = $("#searchForm").serializeJSON();
		
		//将表单数据重新提交后台查询，并更新数据表格
		//将formdata数据重新访问url地址，将数据更新到表格中
		$("#grid").datagrid("load",formdata);
	});
	
	
	
	
	
	
	/*编辑部门按钮*/
	$("#btnSave").bind("click",function(){
		//验证表单是否都通过校验了
		var bool = $("#editForm").form("validate");
		if(!bool){
			return;
		}
		
		//将表单的数据序列化
		var formdata = $("#editForm").serializeJSON();
		
		//ajax异步请求dep_add，完成添加
		$.ajax({
			url:name + "_" + method + ".action",
			dataType:"json",
			type:"post",
			data:formdata,
			success:function(result){
				if (result.success) {
					$.messager.alert("提示",result.message,"info");
					//关闭当前新增窗口
					$("#editDialog").dialog("close");
					
					//刷新表格数据
					$("#grid").datagrid("reload");
					
				}
				
			}
		});
	});
});