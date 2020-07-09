package cn.lttest.erp.entity;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Emp {
	private Long uuid;
	private String username;
	
	@JSONField(serialize=false)
	private String pwd;
	private String name;
	private String email;
	private Long gender;
	private String tele;
	private String address;
	private Date birthday;
	private Dep dep;
	
	@JSONField(serialize=false)
	private List<Role> roles;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(Long uuid, String username, String pwd, String name,
			String email, Long gender, String tele, String address,
			Date birthday, Dep dep) {
		super();
		this.uuid = uuid;
		this.username = username;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.tele = tele;
		this.address = address;
		this.birthday = birthday;
		this.dep = dep;
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getGender() {
		return gender;
	}
	public void setGender(Long gender) {
		this.gender = gender;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Dep getDep() {
		return dep;
	}
	public void setDep(Dep dep) {
		this.dep = dep;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}	
