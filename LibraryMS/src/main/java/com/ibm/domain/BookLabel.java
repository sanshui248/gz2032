package com.ibm.domain;

//图书信息关键字类
public class BookLabel {

	private String country; // 国家
	private String type; // 类型
	private String theme; // 主题
	private Integer lengthRange; // 篇幅区间
	private Integer minPage; // 最小篇幅范围
	private Integer maxPage; // 最大篇幅范围

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

	public Integer getLengthRange() {
		return lengthRange;
	}

	// 根据篇幅区间设置最小和最大最小篇幅范围
	// 1:(1--500) 2:(501--1000) 3:(1001--1500) 4:(>1501)
	public void setLengthRange(Integer lengthRange) {
		this.lengthRange = lengthRange;
		switch (lengthRange) {
		case 1:
			this.setMinPage(1);
			this.setMaxPage(500);
			break;
		case 2:
			this.setMinPage(501);
			this.setMaxPage(1000);
			break;
		case 3:
			this.setMinPage(1001);
			this.setMaxPage(1500);
			break;
		case 4:
			this.setMinPage(1501);
			this.setMaxPage(Integer.MAX_VALUE);
			break;
		default:
			break;
		}
	}

	public Integer getMinPage() {
		return minPage;
	}

	public void setMinPage(Integer minPage) {
		this.minPage = minPage;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	@Override
	public String toString() {
		return "BookKey [country=" + country + ", type=" + type + ", theme=" + theme + ", lengthRange=" + lengthRange
				+ ", minPage=" + minPage + ", maxPage=" + maxPage + "]";
	}

}
