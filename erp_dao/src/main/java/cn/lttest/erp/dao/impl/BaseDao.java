package cn.lttest.erp.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


public class BaseDao<T> extends HibernateDaoSupport {
	private Class<T> entityClass;
	
	public BaseDao(){
		Type type = getClass().getGenericSuperclass();//得到子类的class的父一级Class
		//可以得到泛型类型的type
		ParameterizedType ptype = (ParameterizedType)type;
		//得到所有泛型中所有类型
		Type[] types = ptype.getActualTypeArguments();
		
		entityClass = (Class<T>)types[0];
		
	}
	
	public void update(T t){
		getHibernateTemplate().update(t);
	}
	
	
	
	public T get(Long id){
		return getHibernateTemplate().get(entityClass, id);
	}
	
	/**
	 * 删除部门
	 */
	public void delete(Long id){
		getHibernateTemplate().delete(getHibernateTemplate().get(entityClass, id));
	}
	
	/**
	 * 查询部门数据
	 */
	public List<T> getList() {

		return (List<T>)getHibernateTemplate().find("from T");
	}
	
	/**
	 * 添加部门
	 */
	public void add(T t){
		getHibernateTemplate().save(t);
	}
	
	/**
	 * 条件查询列表
	 * t1.name   t1.tele
	 * t1.date   t2.date
	 * 
	 * Object param
	 * 
	 * 
	 */
	public List<T> getList(T t1,T t2,Object param) {
		DetachedCriteria dc = getDetachedCriteria(t1,t2,param);
		return (List<T>)getHibernateTemplate().findByCriteria(dc);
	}



	public DetachedCriteria getDetachedCriteria(T t1, T t2, Object param) {
		return null;
	}

	/**
	 * 分页查询
	 */
	public List<T> getListByPage(T t1, T t2, Object param,
			int firstResult, int maxResult) {
		DetachedCriteria dc = getDetachedCriteria(t1,t2,param);
		return (List<T>)getHibernateTemplate().findByCriteria(dc,firstResult,maxResult);
	}
	
	
	/**
	 * 统计部门总数
	 */
	public Long getCount(T t1,T t2,Object param){
		DetachedCriteria dc = getDetachedCriteria(t1,t2,param);
		
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>)getHibernateTemplate().findByCriteria(dc);
		return list.get(0);
	}
	
	
	public T  get(String id){
		return (T)getHibernateTemplate().get(entityClass, id);
	}
	
}
