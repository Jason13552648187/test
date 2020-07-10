package cn.lttest.erp.action;
import cn.lttest.erp.biz.IGoodstypeBiz;
import cn.lttest.erp.entity.Goodstype;

/**
 * 商品分类Action 
 * @author Administrator
 *
 */
public class GoodstypeAction extends BaseAction<Goodstype> {

	private IGoodstypeBiz goodstypeBiz;

	public void setGoodstypeBiz(IGoodstypeBiz goodstypeBiz) {
		this.goodstypeBiz = goodstypeBiz;
		super.setBaseBiz(this.goodstypeBiz);
	}

}
