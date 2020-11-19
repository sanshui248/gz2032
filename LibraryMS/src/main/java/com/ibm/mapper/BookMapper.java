package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.Book;
import com.ibm.domain.BookLabel;
import com.ibm.domain.BorrowingDetails;

public interface BookMapper {

	// 查询所有图书信息
	public List<Book> selectAll();

	// 根据ID查询图书信息
	public Book getById(Integer id);

	// 根据设置的标签查找图书信息
	public List<Book> selectByLabel(BookLabel bookLabel);

	// 根据关键字模糊查询图书信息
	public List<Book> selectByKey(String key);

	// 根据图书ID查询借阅记录
	public List<BorrowingDetails> selectBorrowsByBookId(Integer id);

	// 保存图书信息
	public void save(Book book);

	// 根据ID删除图书信息
	public void deleteById(Integer id);

	// 更新图书信息
	public void update(Book book);

}