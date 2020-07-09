$(document).ready(function(){
	$("#btnLogin").bind("click",function(){
		//将表单数据进行序列化
		var formdata = $("#loginform").serializeJSON();
		
		//通过ajax异步请求后端
		$.ajax({
			url:"login_checkUser.action",
			data:formdata,
			dataType:"json",
			type:"post",
			success:function(result){
				if (result.success) {
					location.href="index.html";
				}else{
					$.messager.alert("警告",result.message,"error");
				}
			}
		});
	});
});