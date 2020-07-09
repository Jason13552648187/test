package cn.lttest.erp.action;

import cn.lttest.erp.biz.IOrderDetailBiz;
import cn.lttest.erp.entity.OrderDetail;

public class OrderDetailAction extends BaseAction<OrderDetail>{
	private IOrderDetailBiz orderDetailBiz;
	
	public IOrderDetailBiz getOrderDetailBiz() {
		return orderDetailBiz;
	}

	public void setOrderDetailBiz(IOrderDetailBiz orderDetailBiz) {
		this.orderDetailBiz = orderDetailBiz;
		super.setBaseBiz(orderDetailBiz);
	}
	
}
