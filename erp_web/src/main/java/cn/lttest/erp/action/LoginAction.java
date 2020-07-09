package cn.lttest.erp.action;

import com.opensymphony.xwork2.ActionContext;

import cn.lttest.erp.biz.IEmpBiz;
import cn.lttest.erp.entity.Emp;

public class LoginAction extends BaseAction<Emp>{
	
	private IEmpBiz empBiz;
	
	public void setEmpBiz(IEmpBiz empBiz){
		this.empBiz = empBiz;
		super.setBaseBiz(empBiz);
	}
	
	private String username;
	private String pwd;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public IEmpBiz getEmpBiz() {
		return empBiz;
	}
	
	/**
	 * 登陆用户检查
	 */
	public void checkUser(){
		
		try {
			Emp emp = empBiz.findByUsernameAndPasswd(username, pwd);
			if (emp == null) {
				write(ajaxReturn(false,"用户名或密码错误！"));
				return;
			}
			ActionContext.getContext().getSession().put("loginUser", emp);
			write(ajaxReturn(true,""));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxReturn(false, "登陆失败！请稍后重试！"));
		}
	}
	
	
	/**
	 * 展示用户名
	 */
	public void showName(){
		Emp emp =  (Emp)ActionContext.getContext().getSession().get("loginUser");
		
		if(emp == null){
			write(ajaxReturn(false, ""));
		}else{
			write(ajaxReturn(true, emp.getName()));
		}
	}
	
	
	/**
	 * 退出
	 */
	public void loginOut(){
		ActionContext.getContext().getSession().remove("loginUser");
	}
	
	
	
	
	
	
}
