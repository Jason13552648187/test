package cn.lttest.erp.biz;

import java.util.List;

import cn.lttest.erp.entity.Role;
import cn.lttest.erp.entity.Tree;


public interface IRoleBiz extends IBaseBiz<Role>{
	
	public List<Tree>  readRoleMenus(Long uuid);
	
	public void updateRoleMenus(Long uuid,String str);
	
}
