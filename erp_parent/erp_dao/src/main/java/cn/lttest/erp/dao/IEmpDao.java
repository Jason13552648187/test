package cn.lttest.erp.dao;

import cn.lttest.erp.entity.Emp;

public interface IEmpDao extends IBaseDao<Emp> {

	public  Emp  findByUserNameAndPasswd(String username,String pwd);
	
}
