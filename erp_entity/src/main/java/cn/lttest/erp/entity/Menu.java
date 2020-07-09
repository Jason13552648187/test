package cn.lttest.erp.entity;

import java.util.List;

public class Menu {
	private String  menuid;
	private String menuname;
	private String icon;
	private String url;
	
	private List<Menu> menus;

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(String menuid, String menuname, String icon, String url,
			List<Menu> menus) {
		super();
		this.menuid = menuid;
		this.menuname = menuname;
		this.icon = icon;
		this.url = url;
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", menuname=" + menuname + ", icon="
				+ icon + ", url=" + url + ", menus=" + menus + "]";
	}
	
	
	
	
	
}	
