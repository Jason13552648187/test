package cn.lttest.erp.biz.impl;

import cn.lttest.erp.biz.IEmpBiz;
import cn.lttest.erp.dao.IEmpDao;
import cn.lttest.erp.entity.Emp;

public class EmpBiz extends BaseBiz<Emp> implements IEmpBiz {
	private IEmpDao empDao;

	public IEmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
		super.setBaseDao(empDao);
		
	}

	public Emp findByUsernameAndPasswd(String username, String pwd) {
		return empDao.findByUserNameAndPasswd(username, pwd);
	}
	
	/**
	 * 修改密码
	 */
	public void updatePwd(Long uuid,String newPwd){
		
		try {
			Emp emp = empDao.get(uuid);
			emp.setPwd(newPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
