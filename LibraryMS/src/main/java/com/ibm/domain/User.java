package com.ibm.domain;

import java.util.Calendar;
import java.util.Date;

public class User {
	private int userId; // 用户id
	private String name; // 姓名
	private int sex;// 性别
	private int age;// 年龄
	private String email;// 邮件
	private int identity;//用户身份
	private String password;// 密码
	private Date birthday;// 出生日期
	private String birthdayStr;// 页面显示的出生日期
	private String phone;// 联系电话
	private String address;// 居住地址
	private String introduction;// 个人描述
	private int booksNumber;// 可借书籍数量
	public String getBirthdayStr() {
		return birthdayStr;
	}
	public void setBirthdayStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);					
		String str = calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE);
		this.birthdayStr = str;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
		this.setBirthdayStr();
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getBooksNumber() {
		return booksNumber;
	}
	public void setBooksNumber(int booksNumber) {
		this.booksNumber = booksNumber;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", sex=" + sex + ", age=" + age + ", email=" + email
				+ ", password=" + password + ", birthday=" + birthday + ", phone=" + phone + ", address=" + address
				+ ", introduction=" + introduction + ", booksNumber=" + booksNumber + "]";
	}

}
