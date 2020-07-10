package cn.lttest.erp.entity;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Role {
	private Long uuid;
	private String name;
	
	
	private List<Menu> menus;
	
	public Role() {
		super();
	}

	public Role(Long uuid, String name, List<Menu> menus) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.menus = menus;
	}
	

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "Role [uuid=" + uuid + ", name=" + name + ", menus=" + menus
				+ "]";
	}
}
