package com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ibm.domain.Book;
import com.ibm.domain.BookLabel;
import com.ibm.domain.BorrowingDetails;
import com.ibm.mapper.BookMapper;
import com.ibm.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> selectAll(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Book> books = bookMapper.selectAll();
		return books;
	}

	@Override
	public Book getById(Integer id) {
		return bookMapper.getById(id);
	}

	@Override
	public List<Book> selectByLabel(BookLabel bookLabel, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Book> books = bookMapper.selectByLabel(bookLabel);
		return books;
	}

	@Override
	public List<Book> selectByKey(String key, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Book> books = bookMapper.selectByKey(key);
		return books;
	}

	@Override
	public List<BorrowingDetails> selectBorrowsByUserId(Integer id) {
		List<BorrowingDetails> borrows = bookMapper.selectBorrowsByBookId(id);
		return borrows;
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
