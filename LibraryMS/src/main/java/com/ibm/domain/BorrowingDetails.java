package com.ibm.domain;

import java.util.Calendar;
import java.util.Date;

public class BorrowingDetails {
	private String bookName;
	private Date borrowTime;
	private String borrowTimeStr;
	private Date deadline;
	private String deadlineStr;
	private Date returnTime;
	private String returnTimeStr;
	private int validTime;
	private int borrowStutas;
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
	}
	public String getBorrowTimeStr() {
		return borrowTimeStr;
	}
	public void setBorrowTimeStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(borrowTime);					
		String str = calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE);
		this.borrowTimeStr = str;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getDeadlineStr() {
		return deadlineStr;
	}
	public void setDeadlineStr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(deadline);					
		String str = calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE);
		this.deadlineStr = str;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public String getReturnTimeStr() {
		return returnTimeStr;
	}
	public void setReturnTimeStr(String returnTimeStr) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(returnTime);					
		String str = calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE);
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
	
}
