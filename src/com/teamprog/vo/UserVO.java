package com.teamprog.vo;

public class UserVO {
	String phone;
	String pwd;
	String name;
	int birth;
	int group;
	public UserVO(String phone, String pwd, String name, int birth, int group) {
		super();
		this.phone = phone;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.group = group;
	}
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "UserVO [phone=" + phone + ", pwd=" + pwd + ", name=" + name + ", birth=" + birth + ", group=" + group
				+ "]";
	}
}
