package cn.lttest.erp.dao.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lttest.erp.dao.IReportDao;

public class ReportDao extends HibernateDaoSupport implements IReportDao{

	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	
	public List orderReport(Date startDate, Date endDate) {
		String hql = "select  new Map(gt.name as name, sum(od.money) as money) "
				+ " from Goodstype gt ,Goods g , Orders o, OrderDetail od"
				+ " where gt = g.goodstype  and o = od.orders "
				+ " and  od.goodsuuid = g.uuid and o.type='2'";
		List list = new ArrayList();
		if (startDate != null) {
			hql += " and createtime >= to_date('" + format.format(startDate) + "','yyyy-mm-dd')";
			list.add(startDate);
		}
		if (endDate != null) {
			hql += " and createtime <= to_date('" + format.format(endDate) + "','yyyy-mm-dd')";
			list.add(endDate);
		}
		hql += "group by gt.name";
		
		return getHibernateTemplate().find(hql);
	}
}
