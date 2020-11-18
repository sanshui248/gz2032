package com.ibm.service;

import java.util.List;

import com.ibm.domain.Book;
import com.ibm.domain.BookLabel;

public interface BookService {
	public List<Book> selectAll(Integer pageNum, Integer pageSize);

	public Book getById(Integer id);

	public List<Book> selectByLabel(BookLabel bookLabel, Integer pageNum, Integer pageSize);

	public List<Book> selectByKey(String key, Integer pageNum, Integer pageSize);

	public void save(Book book);

	public void deleteById(Integer id);

	public void update(Book book);
}
