package cn.lttest.erp.biz.impl;

import java.util.ArrayList;
import java.util.List;

import cn.lttest.erp.biz.IRoleBiz;
import cn.lttest.erp.dao.IMenuDao;
import cn.lttest.erp.dao.IRoleDao;
import cn.lttest.erp.entity.Menu;
import cn.lttest.erp.entity.Role;
import cn.lttest.erp.entity.Tree;

public class RoleBiz extends BaseBiz<Role> implements IRoleBiz {
	private IRoleDao roleDao;
	private IMenuDao menuDao;
	

	public IMenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(IMenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
		super.setBaseDao(roleDao);
	}

	
	/**
	 * 读取角色菜单
	 * @return
	 */
	public List<Tree>  readRoleMenus(Long uuid){
		List<Tree> treelist = new ArrayList<Tree>();
		//读取menu菜单数据：一级和二级
		//一级 --> tree  
		//二级 --> tree
		//查询所有菜单
		Menu root = menuDao.get("0");
		
		//通过id查询角色有那个权限，然后在t2里打对号
		List<Menu> menus = roleDao.get(uuid).getMenus();
		
		Tree t1 = null;
		Tree t2 = null;
		for(Menu m1 : root.getMenus()){
			t1 = new Tree();
			t1.setId(m1.getMenuid());
			t1.setText(m1.getMenuname());
			for (Menu m2 : m1.getMenus()) {
				t2 = new Tree();
				t2.setId(m2.getMenuid());
				t2.setText(m2.getMenuname());
				if (menus.contains(m2)) {
					t2.setChecked(true);
				}
				t1.getChildren().add(t2);
			}
			treelist.add(t1);
		}
		return treelist;
	}

	
	/**
	 * 更新权限
	 */
	public void updateRoleMenus(Long uuid, String str) {
		Role role = roleDao.get(uuid);
		//清空当前角色下的菜单
		role.setMenus(new ArrayList<Menu>());
		
		String[] ids = str.split(",");
		
		for (String id : ids) {
			Menu menu = menuDao.get(id);
			role.getMenus().add(menu);
		}
		System.out.println(role);
		
	}
	
	
	
	

}
