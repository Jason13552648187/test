package cn.lttest.erp.entity;

public class Dep {
	private Long uuid;
	private String name;
	private String tele;
	@Override
	public String toString() {
		return "Dep [uuid=" + uuid + ", name=" + name + ", tele=" + tele + "]";
	}
	public Dep() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public Dep(Long uuid, String name, String tele) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.tele = tele;
	}
	
	
}	
