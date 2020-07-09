package cn.lttest.erp.action;

import com.alibaba.fastjson.JSON;

import cn.lttest.erp.biz.IMenuBiz;
import cn.lttest.erp.entity.Menu;

public class MenuAction extends BaseAction<Menu>{
	
	private IMenuBiz menuBiz;
	
	public void setMenuBiz(IMenuBiz menuBiz){
		this.menuBiz = menuBiz;
		super.setBaseBiz(menuBiz);
	}
	
	public IMenuBiz getMenuBiz() {
		return menuBiz;
	}
	
	
	public void getMenuTree(){
		Menu menu = menuBiz.get("0");
		
		String jsonString = JSON.toJSONString(menu,true);//true表示格式化输入
		
		write(jsonString);
		
	}
	
	
	
	
}
