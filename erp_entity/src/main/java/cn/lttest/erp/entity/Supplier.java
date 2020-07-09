package cn.lttest.erp.entity;
public class Supplier {
	private Long uuid;//编号
	private String name;//名称
	private String address;//联系地址
	private String contact;//联系人
	private String tele;//联系电话
	private String email;//邮件地址
	private String type;//1：供应商 2：客户
	@Override
	public String toString() {
		return "Supplier [uuid=" + uuid + ", name=" + name + ", address="
				+ address + ", contact=" + contact + ", tele=" + tele
				+ ", email=" + email + ", type=" + type + "]";
	}
	public Supplier() {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Supplier(Long uuid, String name, String address, String contact,
			String tele, String email, String type) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.tele = tele;
		this.email = email;
		this.type = type;
	}
	
}
