package com.ibm.service;

import java.util.List;

import com.ibm.domain.Book;
import com.ibm.domain.BookLabel;

public interface BookService {
	public List<Book> selectAll();

	public Book getById(Integer id);

	public List<Book> selectByLabel(BookLabel bookLabel);

	public List<Book> selectByKey(String key);

	public void save(Book book);

	public void deleteById(Integer id);

	public void update(Book book);
}
