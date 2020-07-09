package cn.lttest.erp.biz.impl;

import cn.lttest.erp.biz.IMenuBiz;
import cn.lttest.erp.dao.IMenuDao;
import cn.lttest.erp.entity.Menu;

public class MenuBiz extends BaseBiz<Menu> implements IMenuBiz {
	private IMenuDao menuDao;

	public IMenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(IMenuDao menuDao) {
		this.menuDao = menuDao;
		super.setBaseDao(menuDao);
		
	}


}
