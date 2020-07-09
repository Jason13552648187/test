
function  showChart(data){
	$("#pieChart").highcharts({
		chart:{
			
			type:'pie',
			 options3d: {
                        enabled: true,
                        alpha: 50,
                        beta: 0
            }
		},
		title:{
			text:"销售统计"
		},
		subtitle:{
			text:"详情分布"
		},
		tooltip:{
			pointFormat:'{series.name}:<b>{point.percentage:.1f}</b>'
		},
		plotOptions:{
			pie:{
				allowPointSelect:true,
				cursor:'pointer',
				depth: 35,
				color: '#000000',
				connectorColor: '#000000',
				dataLabels:{
					enbled:true,
					format:'{point.name}:<b>{point.percentage:.1f}</b>'
				},
				showInlegend:true
			}
		},
		series:[{
			name:"比例",
			colorByPoint:true,
			data:data
			/*
			 * [[],[],[]]
			 * 
			 * */
		}]
	});
}



$(function(){
	$("#grid").datagrid({
		url:"report_orderReport.action",
		columns:[[
		          {field:"name",title:"商品类型",width:100},
		          {field:"money",title:"销售额",width:100},
		 ]],
		 singleSelect:true,
		 onLoadSuccess:function(data){
			data = data.rows;
			var d = [];
			
			for (var i = 0; i < data.length; i++) {
				d.push([data[i].name,data[i].money]);
			}
			 showChart(d);
		 }
		
	});
	
	
	$("#btnSearch").bind("click",function(){
		var formdata = $("#searchForm").serializeJSON();
		
		$("#grid").datagrid("load",formdata);
	});
	
})