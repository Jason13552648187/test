package cn.lttest.erp.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import cn.lttest.erp.dao.IRoleDao;
import cn.lttest.erp.entity.Role;
import cn.lttest.erp.entity.Role;

public class RoleDao extends BaseDao<Role> implements IRoleDao{
	
	/**
	 * 构建查询条件
	 * @param dep1
	 * @param dep2
	 * @param param
	 * @return
	 */
	public DetachedCriteria getDetachedCriteria(Role role1,Role role2,Object param){
		DetachedCriteria dc=DetachedCriteria.forClass(Role.class);
		if(role1!=null){
			if(null != role1.getUuid()){
				dc.add(Restrictions.eq("uuid", role1.getUuid()));
			}
			if(null != role1.getName() && role1.getName().trim().length()>0){
				dc.add(Restrictions.like("name", role1.getName(),MatchMode.ANYWHERE));
			}
		}
		return dc;
	}
}
