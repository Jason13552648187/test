package cn.lttest.erp.biz.impl;
import cn.lttest.erp.biz.ISupplierBiz;
import cn.lttest.erp.dao.ISupplierDao;
import cn.lttest.erp.entity.Supplier;
/**
 * 商品业务逻辑类
 * @author Administrator
 *
 */
public class SupplierBiz extends BaseBiz<Supplier> implements ISupplierBiz {

	private ISupplierDao supplierDao;
	
	public void setSupplierDao(ISupplierDao supplierDao) {
		this.supplierDao = supplierDao;
		super.setBaseDao(this.supplierDao);
	}
	
}
