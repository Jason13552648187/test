package cn.lttest.erp.action;

import java.util.List;

import cn.lttest.erp.biz.IOrdersBiz;
import cn.lttest.erp.entity.Emp;
import cn.lttest.erp.entity.OrderDetail;
import cn.lttest.erp.entity.Orders;

import com.alibaba.fastjson.JSON;

public class OrdersAction extends BaseAction<Orders>{
	private IOrdersBiz ordersBiz;
	private String json;
	
	
	
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public IOrdersBiz getOrdersBiz() {
		return ordersBiz;
	}

	public void setOrdersBiz(IOrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
		super.setBaseBiz(ordersBiz);
	}
	
	
	public void add(){
		
		Emp emp = getUser();
		
		if (emp == null) {
			write(ajaxReturn(false, "您还没有登陆，别瞎溜达！"));
			return;
		}
		
		try {
			Orders order = getT();
			//给订单设置下单员
			order.setCreater(emp.getUuid());
			
			List<OrderDetail> orderdetails = JSON.parseArray(json,OrderDetail.class);
			
			order.setOrderDetails(orderdetails);
			
			ordersBiz.add(order);
			
			write(ajaxReturn(true, "添加成功！"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxReturn(false, "添加失败！"));
		}
	}
	
	
	
}
