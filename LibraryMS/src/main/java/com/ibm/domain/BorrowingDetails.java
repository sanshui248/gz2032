package com.ibm.domain;

import java.util.Calendar;
import java.util.Date;

public class BorrowingDetails {
	private Integer userId; // 用户ID
	private String name;// 用户姓名
	private Integer bookId;// 图书ID
	private String bookName;// 图书名称
	private Date borrowTime; // 借阅日期
	private String borrowTimeStr; // 借阅日期--String类型
	private Date deadline; // 截止日期
	private String deadlineStr; // 截止日期--String类型
	private Date returnTime; // 归还日期
	private String returnTimeStr; // 归还日期--String类型
	private int validTime; // 借阅有效期
	private int borrowStutas; // 借阅状态

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Date getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
		this.setBorrowTimeStr();
	}

	public String getBorrowTimeStr() {
		return borrowTimeStr;
	}

	public void setBorrowTimeStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(borrowTime);
		String str = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		this.borrowTimeStr = str;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
		this.setDeadlineStr();
	}

	public String getDeadlineStr() {
		return deadlineStr;
	}

	public void setDeadlineStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(deadline);
		String str = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		this.deadlineStr = str;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
		this.setReturnTimeStr();
	}

	public String getReturnTimeStr() {
		return returnTimeStr;
	}

	public void setReturnTimeStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(returnTime);
		String str = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		this.returnTimeStr = str;
	}

	public int getValidTime() {
		return validTime;
	}

	public void setValidTime(int validTime) {
		this.validTime = validTime;
	}

	public int getBorrowStutas() {
		return borrowStutas;
	}

	public void setBorrowStutas(int borrowStutas) {
		this.borrowStutas = borrowStutas;
	}

	@Override
	public String toString() {
		return "BorrowingDetails [userId=" + userId + ", name=" + name + ", bookId=" + bookId + ", bookName=" + bookName
				+ ", borrowTime=" + borrowTime + ", borrowTimeStr=" + borrowTimeStr + ", deadline=" + deadline
				+ ", deadlineStr=" + deadlineStr + ", returnTime=" + returnTime + ", returnTimeStr=" + returnTimeStr
				+ ", validTime=" + validTime + ", borrowStutas=" + borrowStutas + "]";
	}

}
