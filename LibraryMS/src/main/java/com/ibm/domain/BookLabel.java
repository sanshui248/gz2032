package com.ibm.domain;

//图书信息标签类
public class BookLabel {

	private int countryId; // 国家id
	private int typeId; // 类型id
	private int themeId; // 主题id
	private int lengthRange; // 篇幅区间
	private Integer minPage; // 最小篇幅范围
	private Integer maxPage; // 最大篇幅范围

	public int getLengthRange() {
		return lengthRange;
	}

	// 根据篇幅区间设置最小和最大最小篇幅范围
	// 1:(1--500) 2:(501--1000) 3:(1001--1500) 4:(>1501)
	public void setLengthRange(int lengthRange) {
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

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

}
