package cn.lttest.erp.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import cn.lttest.erp.dao.IOrderDetailDao;
import cn.lttest.erp.entity.OrderDetail;

public class OrderDetailDao extends BaseDao<OrderDetail> implements IOrderDetailDao{
	
	/**
	 * 构建查询条件
	 * @param dep1
	 * @param dep2
	 * @param param
	 * @return
	 */
	public DetachedCriteria getDetachedCriteria(OrderDetail orderdetail1,OrderDetail orderdetail2,Object param){
		DetachedCriteria dc=DetachedCriteria.forClass(OrderDetail.class);
		if(orderdetail1!=null){
			if(null != orderdetail1.getGoodsname() && orderdetail1.getGoodsname().trim().length()>0){
				dc.add(Restrictions.like("goodsname", orderdetail1.getGoodsname(), MatchMode.ANYWHERE));
			}
			if(null != orderdetail1.getState() && orderdetail1.getState().trim().length()>0){
				dc.add(Restrictions.like("state", orderdetail1.getState(), MatchMode.ANYWHERE));
			}

		}
		return dc;
	}
	
	
	
}
