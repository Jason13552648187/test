package cn.lttest.erp.action;

import cn.lttest.erp.biz.IDepBiz;
import cn.lttest.erp.entity.Dep;

public class DepAction extends BaseAction<Dep>{
	
	private IDepBiz depBiz;
	
	public void setDepBiz(IDepBiz depBiz){
		this.depBiz = depBiz;
		super.setBaseBiz(depBiz);
	}
	

}
