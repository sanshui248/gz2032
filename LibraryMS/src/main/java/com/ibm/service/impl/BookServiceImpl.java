package com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.domain.Book;
import com.ibm.domain.BookLabel;
import com.ibm.mapper.BookMapper;
import com.ibm.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;

//	@Override
//	public List<Book> selectAll(Integer pageNum, Integer pageSize) {
//		PageHelper.startPage(pageNum, pageSize);
//		List<Book> books = this.bookMapper.selectAll();
//		return books;
//	}

	@Override
	public Book getById(Integer id) {
		return this.bookMapper.getById(id);
	}

//	@Override
//	public List<Book> selectByLabel(BookLabel bookLabel, Integer pageNum, Integer pageSize) {
//		PageHelper.startPage(pageNum, pageSize);
//		List<Book> books = bookMapper.selectByLabel(bookLabel);
//		return books;
//	}

//	@Override
//	public List<Book> selectByKey(String key, Integer pageNum, Integer pageSize) {
//		PageHelper.startPage(pageNum, pageSize);
//		List<Book> books = bookMapper.selectByKey(key);
//		return books;
//	}

	@Override
	public List<Book> selectAll() {
		return bookMapper.selectAll();
	}

	@Override
	public List<Book> selectByLabel(BookLabel bookLabel) {
		return bookMapper.selectByLabel(bookLabel);
	}

	@Override
	public List<Book> selectByKey(String key) {
		return bookMapper.selectByKey(key);
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
