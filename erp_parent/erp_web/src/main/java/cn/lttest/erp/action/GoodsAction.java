package cn.lttest.erp.action;
import cn.lttest.erp.biz.IGoodsBiz;
import cn.lttest.erp.entity.Goods;

/**
 * 商品Action 
 * @author Administrator
 *
 */
public class GoodsAction extends BaseAction<Goods> {

	private IGoodsBiz goodsBiz;

	public void setGoodsBiz(IGoodsBiz goodsBiz) {
		this.goodsBiz = goodsBiz;
		super.setBaseBiz(this.goodsBiz);
	}

}
