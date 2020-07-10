$(function(){
	$("#tree").tree({
		url:"role_readRoleMenus?id=" + 1,
		animate:true,
		checkbox:true//是否显示复选框
	});
	
	$("#grid").datagrid({
		url:"role_list",
		columns:[[
		          {field:"uuid",title:'编号',width:100},
		          {field:"name",title:'角色名称',width:100},
		]],
		singleSelect:true,
		onClickRow:function(index,data){
			$("#tree").tree({
				url:"role_readRoleMenus?id=" +  data.uuid,
				animate:true,
				checkbox:true
			});
		}
		          
	});
	
	
	$("#btnSave").bind("click",function(){
		var nodes = $("#tree").tree("getChecked");
		var checkStr =  new Array();
		//将所有的节点id值放入数组中
		$.each(nodes,function(i,node){
			checkStr.push(node.id);
		});
		
		//通过,号合并在一起
		checkStr = checkStr.join(",");
		
		var formdata = {};
		
		formdata.id = $("#grid").datagrid("getSelected").uuid;
		formdata.checkStr = checkStr;
		alert(JSON.stringify(formdata));
		$.ajax({
			url:"role_updateRoleMenus",
			data:formdata,
			type:"post",
			dataType:"json",
			success:function(result){
				$.messager.alert("提示",result.message,"info");
			}
		});
	});
})