package cn.lttest.erp.biz;

import java.util.List;

public interface IBaseBiz<T> {
	public List<T> getList();
	
	public List<T> getList(T t1,T t2,Object param);
	
	public List<T> getListByPage(T t1,T t2,Object param,int firstResult,int maxResult);
	
	public Long getCount(T t1,T t2,Object param);
	
	public void add(T t);
	
	public void delete(Long id);
	
	
	public T get(Long id);
	
	public T get(String id);
	
	public void update(T t);
}
