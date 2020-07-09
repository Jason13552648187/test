package cn.lttest.erp.biz.impl;

import java.util.List;

import cn.lttest.erp.dao.IBaseDao;

public class BaseBiz<T> {

	private IBaseDao<T> baseDao;

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/**
	 * 删除部门
	 */
	public void delete(Long id){
		baseDao.delete(id);
	}
	
	/**
	 * 部门更新
	 */
	public void update(T t){
		baseDao.update(t);
	}
	
	/**
	 * 查询部门
	 */
	public List<T> getList() {
		return baseDao.getList();
	}
	
	
	public T get(Long id){
		return baseDao.get(id);
	}
	
	/**
	 * 条件查询
	 */
	public List<T> getList(T t1,T t2,Object param){
		return baseDao.getList(t1,t2,param);
	}

	
	/**
	 * 分页查询
	 */
	public List<T> getListByPage(T t1, T t2, Object param,
			int firstResult, int maxResult) {
		return baseDao.getListByPage(t1, t2, param, firstResult, maxResult);
	}
	
	public Long getCount(T t1, T t2, Object param){
		return baseDao.getCount(t1, t2, param);
	}
	
	
	public void add(T t){
		baseDao.add(t);
	}
	
	
	public T get(String id){
		return baseDao.get(id);
	}
	
}
