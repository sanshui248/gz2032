package org.gecedu.bean;

import java.util.List;

import org.gecedu.model.Department;

public class PageInfo2 {
	private Integer currentPage;
	private List<Department> list;
	private Integer endPage;
	private Integer beginPage;
	private Integer totalPages;
	private Long totalRecord;
	
	
	public PageInfo2( Integer currentPage,List<Department> list,Long totalRecord) {
		super();
		this.currentPage = currentPage;
		this.list = list;
		//this.endPage = endPage;
		//this.beginPage = beginPage;
		//this.totalPages = totalPages;
		this.totalRecord = totalRecord;
		
		//总页数计算
		if(totalRecord%8==0) {
			this.totalPages = totalRecord.intValue()/8;
		}else {
			this.totalPages = totalRecord.intValue()/8+1;
		}
		
		//中间页码显示6页码
		if(this.totalPages<6) {
			this.beginPage=1;
			this.endPage=totalPages;
		}else {
			this.beginPage=currentPage-3;
			this.endPage=currentPage+2;
			if(this.beginPage<=0) {
				this.beginPage=1;
				this.endPage=6;
			}
			if(this.endPage>this.totalPages) {
				this.beginPage = this.totalPages-6;
				this.endPage=this.totalPages;
			}
		}
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<Department> getList() {
		return list;
	}
	public void setList(List<Department> list) {
		this.list = list;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public Integer getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(Integer beginPage) {
		this.beginPage = beginPage;
	}
	public Integer getTotalPage() {
		return totalPages;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPages = totalPage;
	}
	public Long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}

}
