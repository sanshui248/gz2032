package com.ibm.domain;

import java.util.Date;

//图书信息类
public class Book {

	private Integer bookId; // 图书ID
	private String bookName; // 图书名称
	private String country; // 国家
	private String type; // 类型
	private String theme; // 主题
	private Integer pages; // 篇幅
	private String brief; // 简介
	private Integer onNumber; // 上架数量
	private Date onTime; // 上架时间
	private Integer offNumber; // 下架数量
	private Date offTime; // 下架时间
	private Integer surplusNumber; // 剩余数量

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Integer getOnNumber() {
		return onNumber;
	}

	public void setOnNumber(Integer onNumber) {
		this.onNumber = onNumber;
	}

	public Date getOnTime() {
		return onTime;
	}

	public void setOnTime(Date onTime) {
		this.onTime = onTime;
	}

	public Integer getOffNumber() {
		return offNumber;
	}

	public void setOffNumber(Integer offNumber) {
		this.offNumber = offNumber;
	}

	public Date getOffTime() {
		return offTime;
	}

	public void setOffTime(Date offTime) {
		this.offTime = offTime;
	}

	public Integer getSurplusNumber() {
		return surplusNumber;
	}

	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", country=" + country + ", type=" + type
				+ ", theme=" + theme + ", pages=" + pages + ", brief=" + brief + ", onNumber=" + onNumber + ", onTime="
				+ onTime + ", offNumber=" + offNumber + ", offTime=" + offTime + ", surplusNumber=" + surplusNumber
				+ "]";
	}

}
