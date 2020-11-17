package com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Book;
import com.ibm.domain.BookKey;
import com.ibm.mapper.BookMapper;
import com.ibm.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> selectAll() {
		return bookMapper.selectAll();
	}

	@Override
	public Book getById(Integer id) {
		return bookMapper.getById(id);
	}

	@Override
	public List<Book> selectByKeys(BookKey bookKey) {
		return bookMapper.selectByKeys(bookKey);
	}

	@Override
	public void save(Book book) {
		bookMapper.save(book);
	}

	@Override
	public void deleteById(Integer id) {
		bookMapper.deleteById(id);
	}

	@Override
	public void update(Book book) {
		bookMapper.update(book);
	}

}
