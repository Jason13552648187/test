package cn.lttest.erp.action;

import java.util.List;

import cn.lttest.erp.biz.IRoleBiz;
import cn.lttest.erp.entity.Role;
import cn.lttest.erp.entity.Tree;

import com.alibaba.fastjson.JSON;

public class RoleAction extends BaseAction<Role>{
	
	private IRoleBiz roleBiz;
	private String checkStr;
	
	public String getCheckStr() {
		return checkStr;
	}

	public void setCheckStr(String checkStr) {
		this.checkStr = checkStr;
	}

	public void setRoleBiz(IRoleBiz roleBiz){
		this.roleBiz = roleBiz;
		super.setBaseBiz(roleBiz);
	}
	
	public IRoleBiz getRoleBiz() {
		return roleBiz;
	}
	
	
	public void readRoleMenus(){
		List<Tree> listtree = roleBiz.readRoleMenus(getId());
		write(JSON.toJSONString(listtree));
	}
	
	public void updateRoleMenus(){
		try {
			roleBiz.updateRoleMenus(getId(), checkStr);
			write(ajaxReturn(true, "更新成功！"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxReturn(false, "更新失败！"));
		}
	}
	
	
}
