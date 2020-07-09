package cn.lttest.erp.action;

import cn.lttest.erp.biz.ISupplierBiz;
import cn.lttest.erp.entity.Supplier;

public class SupplierAction extends BaseAction<Supplier> {
	private ISupplierBiz supplierBiz;



	public ISupplierBiz getSupplierBiz() {
		return supplierBiz;
	}


	public void setSupplierBiz(ISupplierBiz supplierBiz) {
		this.supplierBiz = supplierBiz;
		super.setBaseBiz(supplierBiz);
	}

	
	
	
}
