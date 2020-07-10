package cn.lttest.erp.action;

import cn.lttest.erp.biz.IEmpBiz;
import cn.lttest.erp.entity.Emp;

public class EmpAction extends BaseAction<Emp>{
	
	private IEmpBiz empBiz;
	private String newPwd;
	
	
	public String getNewPwd() {
		return newPwd;
	}


	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}


	public IEmpBiz getEmpBiz() {
		return empBiz;
	}


	public void setEmpBiz(IEmpBiz empBiz){
		this.empBiz = empBiz;
		super.setBaseBiz(empBiz);
	}
	
	/**
	 * 修改密码
	 */
	public void updatePwd(){
		try {
			empBiz.updatePwd(getUser().getUuid(), newPwd);
			write(ajaxReturn(true, "修改密码成功！"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxReturn(false, "修改密码失败！" + e.getMessage()));
		}
	}
	
	
	
	
	
	
	
	
	
	
}
