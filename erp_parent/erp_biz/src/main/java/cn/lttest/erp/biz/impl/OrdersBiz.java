package cn.lttest.erp.biz.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.lttest.erp.biz.IOrdersBiz;
import cn.lttest.erp.dao.IEmpDao;
import cn.lttest.erp.dao.IOrdersDao;
import cn.lttest.erp.dao.ISupplierDao;
import cn.lttest.erp.entity.OrderDetail;
import cn.lttest.erp.entity.Orders;

public class OrdersBiz extends BaseBiz<Orders> implements IOrdersBiz{
	private IOrdersDao ordersDao;
	private IEmpDao empDao;
	private ISupplierDao supplierDao;

	public IEmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}

	public ISupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(ISupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	public IOrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
		super.setBaseDao(ordersDao);
	}
	
	
	/**
	 * 添加订单
	 */
	public void add(Orders orders){
		orders.setType("1");//1采购订单     2销售订单
		orders.setState("0");//0:未审核    1：已审核   2：已确认   3：已入库
		orders.setCreatetime(new Date());
		
		double total = 0;
		
		for (OrderDetail orderdetail :  orders.getOrderDetails()) {
			total += orderdetail.getMoney();
			orderdetail.setState("0");
			orderdetail.setOrders(orders);
		}
		
		orders.setTotalmoney(total);
		//保存订单和订单详情到数据库
		ordersDao.add(orders);
	}
	
	
	
	@Override
	public List<Orders> getListByPage(Orders t1, Orders t2, Object param,
			int firstResult, int maxResult) {
		//获取原来的分页结果
		List<Orders> orderslist = super.getListByPage(t1, t2, param, firstResult, maxResult);
		
		//给订单数据动动手脚：订单绑定员工名    绑定供应商名    审核员名     库管员名
		//缓存员工：long   string
		Map<Long ,String > empMap = new HashMap<Long,String>();
		//缓存供应商：long string
		Map<Long ,String > supplierMap = new HashMap<Long,String>();
		
		for(Orders o : orderslist){
			o.setCreaterName(getEmpName(o.getCreater(),empMap));
			o.setCheckerName(getEmpName(o.getChecker(),empMap));
			o.setStaterName(getEmpName(o.getStarter(),empMap));
			o.setEnderName(getEmpName(o.getEnder(),empMap));
			
			o.setSupplierName(getSupplierName(o.getSupplieruuid(), supplierMap));
		}
		
		return orderslist;
	}
	
	private String getEmpName(Long uuid,Map<Long ,String> empMap){
		//从map缓存中查询，如果查询到了，则返回
		if (uuid == null) {
			return null;
		}
		
		String empName = empMap.get(uuid);
		//若没有呢，则dao中查询
		if (empName == null) {
			empName = empDao.get(uuid).getName();
			empMap.put(uuid, empName);
		}
		
		return empName;
	}
	
	private String getSupplierName(Long uuid,Map<Long ,String> supplierMap){
		//从map缓存中查询，如果查询到了，则返回
		if (uuid == null) {
			return null;
		}
		
		String supplierName = supplierMap.get(uuid);
		//若没有呢，则dao中查询
		if (supplierName == null) {
			supplierName = supplierDao.get(uuid).getName();
			supplierMap.put(uuid, supplierName);
		}
		
		return supplierName;
	}
	
	
	
	
	
}

