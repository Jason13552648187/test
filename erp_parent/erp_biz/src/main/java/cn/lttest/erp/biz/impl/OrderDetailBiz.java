package cn.lttest.erp.biz.impl;

import cn.lttest.erp.biz.IOrderDetailBiz;
import cn.lttest.erp.dao.IOrderDetailDao;
import cn.lttest.erp.entity.OrderDetail;

public class OrderDetailBiz extends BaseBiz<OrderDetail> implements IOrderDetailBiz{
	private IOrderDetailDao orderDetailDao;

	public IOrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}

	public void setOrderDetailDao(IOrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
		super.setBaseDao(orderDetailDao);
	}


}

