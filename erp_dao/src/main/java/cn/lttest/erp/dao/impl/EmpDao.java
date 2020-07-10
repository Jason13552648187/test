package cn.lttest.erp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import cn.lttest.erp.dao.IEmpDao;
import cn.lttest.erp.entity.Emp;

public class EmpDao extends BaseDao<Emp> implements IEmpDao{
	
	public DetachedCriteria getDetachedCriteria(Emp emp1,Emp emp2,Object param) {
		DetachedCriteria dc = DetachedCriteria.forClass(Emp.class);
		
		if (emp1 != null) {
			if (emp1.getName() != null && emp1.getName().length() > 0) {
				dc.add(Restrictions.like("name",emp1.getName(),MatchMode.ANYWHERE));
			}
			if (emp1.getTele() != null && emp1.getTele().length() > 0) {
				dc.add(Restrictions.like("tele",emp1.getTele(),MatchMode.ANYWHERE));
			}
			if (emp1.getPwd() != null && emp1.getPwd().length() > 0) {
				dc.add(Restrictions.like("pwd",emp1.getPwd(),MatchMode.ANYWHERE));
			}
			if (emp1.getUsername() != null && emp1.getUsername().length() > 0) {
				dc.add(Restrictions.like("username",emp1.getUsername(),MatchMode.ANYWHERE));
			}
			
			if (emp1.getEmail() != null && emp1.getEmail().length() > 0) {
				dc.add(Restrictions.like("email",emp1.getEmail(),MatchMode.ANYWHERE));
			}
			if (emp1.getGender() != null ) {
				dc.add(Restrictions.eq("gender",emp1.getGender()));
			}
			if (emp1.getAddress() != null && emp1.getAddress().length() > 0) {
				dc.add(Restrictions.like("address",emp1.getAddress(),MatchMode.ANYWHERE));
			}
			if (emp1.getBirthday() != null ) {
				dc.add(Restrictions.eq("birthday",emp1.getBirthday()));
			}
			if (emp1.getDep() != null) {
				dc.add(Restrictions.eq("depuuid",emp1.getDep().getUuid()));
			}
		}
		return dc;
	}

	/**
	 * 通过用户名和密码查询用户
	 */
	public Emp findByUserNameAndPasswd(String username, String pwd) {
		
		List<Emp> list= (List<Emp>)getHibernateTemplate().find("from Emp where username = ? and pwd  = ?"
				,username,pwd);
		
		if(list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}
	
	
	
	
	
}
