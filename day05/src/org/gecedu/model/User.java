package org.gecedu.model;

import java.sql.Date;

/**
 *  用户实体类 
 * 对应到一张表， user
 */
public class User {
	private Integer id;
	private String name;
	private Integer age;
	private Date registerTime;
	private String account;
	private String password;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
	}
	public User(Integer id, String name, Integer age, Date registerTime,String account,String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.registerTime = registerTime;
		this.account=account;
		this.password=password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}	

}
