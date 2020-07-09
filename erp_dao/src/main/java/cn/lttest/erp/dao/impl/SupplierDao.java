package cn.lttest.erp.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import cn.lttest.erp.dao.ISupplierDao;
import cn.lttest.erp.entity.Supplier;

public class SupplierDao extends BaseDao<Supplier> implements ISupplierDao{
	
	
	/**
	 * 员工的查询方法
	 * @param supplier1
	 * @param supplier2
	 * @param param
	 * @return
	 */
	public DetachedCriteria  getDetachedCriteria(Supplier supplier1,Supplier supplier2,Object param){
		
		DetachedCriteria dc = DetachedCriteria.forClass(Supplier.class);
		if (supplier1 != null) {
			if(null != supplier1.getName() && supplier1.getName().trim().length()>0){
				dc.add(Restrictions.like("name", supplier1.getName(), MatchMode.ANYWHERE));
			}
			if(null != supplier1.getAddress() && supplier1.getAddress().trim().length()>0){
				dc.add(Restrictions.like("address", supplier1.getAddress(), MatchMode.ANYWHERE));
			}
			if(null != supplier1.getContact() && supplier1.getContact().trim().length()>0){
				dc.add(Restrictions.like("contact", supplier1.getContact(), MatchMode.ANYWHERE));
			}
			if(null != supplier1.getTele() && supplier1.getTele().trim().length()>0){
				dc.add(Restrictions.like("tele", supplier1.getTele(), MatchMode.ANYWHERE));
			}
			if(null != supplier1.getEmail() && supplier1.getEmail().trim().length()>0){
				dc.add(Restrictions.like("email", supplier1.getEmail(), MatchMode.ANYWHERE));
			}
			//根据类型查询
			if(null != supplier1.getType() && supplier1.getType().trim().length()>0){
				dc.add(Restrictions.eq("type", supplier1.getType()));
			}
		}
		return dc;
	}
}
