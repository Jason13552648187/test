package cn.lttest.erp.biz.impl;

import cn.lttest.erp.biz.IDepBiz;
import cn.lttest.erp.dao.IDepDao;
import cn.lttest.erp.entity.Dep;

public class DepBiz extends BaseBiz<Dep> implements IDepBiz {
	private IDepDao depDao;

	public IDepDao getDepDao() {
		return depDao;
	}

	public void setDepDao(IDepDao depDao) {
		this.depDao = depDao;
		super.setBaseDao(depDao);
		
	}
	
	
	

}
