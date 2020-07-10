package cn.lttest.erp.entity;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	private String id;
	private String text;
	private boolean checked;
	private List<Tree> children;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List<Tree> getChildren() {
		if (children == null) {
			children  =  new ArrayList<Tree>();
		}
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	public Tree() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tree(String id, String text, boolean checked, List<Tree> children) {
		super();
		this.id = id;
		this.text = text;
		this.checked = checked;
		this.children = children;
	}
	
	
}
