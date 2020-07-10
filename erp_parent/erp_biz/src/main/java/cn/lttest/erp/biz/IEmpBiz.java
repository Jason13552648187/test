package cn.lttest.erp.biz;

import cn.lttest.erp.entity.Emp;

public interface IEmpBiz extends IBaseBiz<Emp>{
	
	public Emp  findByUsernameAndPasswd(String username,String pwd);
	
	public void updatePwd(Long uuid,String newPwd);
	
}
