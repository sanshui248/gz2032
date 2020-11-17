package com.ibm.mapper;

import java.util.List;

import com.ibm.domain.Book;
import com.ibm.domain.BookKey;

public interface BookMapper {

	// 查询所有图书信息
	public List<Book> selectAll();

	// 根据ID查询图书信息
	public Book getById(Integer id);

	// 根据设置的关键字查找图书信息
	public List<Book> selectByKeys(BookKey bookKey);

	// 保存图书信息
	public void save(Book book);

	// 根据ID删除图书信息
	public void deleteById(Integer id);

	// 更新图书信息
	public void update(Book book);

}
