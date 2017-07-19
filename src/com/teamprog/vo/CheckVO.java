package com.teamprog.vo;

public class CheckVO {
	String phone;
	String name;
	String time; // 출석 시간
	String flag; // 출석, 지각, 결석
	String part; // = "오전", "오후", "끝"
	public CheckVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckVO(String phone, String name, String time, String flag, String part) {
		super();
		this.phone = phone;
		this.name = name;
		this.time = time;
		this.flag = flag;
		this.part = part;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}	
	@Override
	public String toString() {
		return "CheckVO [phone=" + phone + ", name=" + name + ", time=" + time + ", flag=" + flag + ", part=" + part
				+ "]";
	}
}
