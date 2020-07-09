package cn.lttest.erp.biz.impl;
import cn.lttest.erp.biz.IGoodsBiz;
import cn.lttest.erp.dao.IGoodsDao;
import cn.lttest.erp.entity.Goods;
/**
 * 商品业务逻辑类
 * @author Administrator
 *
 */
public class GoodsBiz extends BaseBiz<Goods> implements IGoodsBiz {

	private IGoodsDao goodsDao;
	
	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		super.setBaseDao(this.goodsDao);
	}
	
}
