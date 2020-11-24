package com.ibm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.domain.Book;
import com.ibm.domain.BookLabel;
import com.ibm.domain.BorrowingDetails;
import com.ibm.service.BookService;
import com.ibm.service.BorrowService;

/**
 * 
 * @author:刘志勇
 * @Description:图书模块
 */
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BorrowService borrowService;

	/**
	 * @Description 获取图书信息列表
	 * @param pageNum：页数 pageSize：页面记录数
	 * @return 图书信息列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/list")
	public List<Book> selectBookList() {
		List<Book> books = bookService.selectAll();
		return books;
	}

	/**
	 * @Description 根据ID获取对应图书信息
	 * @param 图书ID
	 * @return 对应的图书信息
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/query")
	public Book selectBookById(Integer bookId) {
		return bookService.getById(bookId);
	}

	/**
	 * @Description 根据设置的标签获取对应图书信息
	 * @param bookLabel：图书关键字类 pageNum：页数 pageSize：页面记录数
	 * @return 对应的图书信息列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/list/label")
	public List<Book> selectBookListByLabel(@RequestBody BookLabel bookLabel) {
		List<Book> books = bookService.selectByLabel(bookLabel);
		return books;
	}

	/**
	 * @Description 根据关键字模糊查询对应图书信息
	 * @param 关键字
	 * @return 对应的图书信息列表
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/list/key")
	public List<Book> selectBookListByKey(String key) {
		List<Book> books = bookService.selectByKey(key);
		return books;
	}

	/**
	 * @Description 根据图书ID设置图书借阅记录列表
	 * @param 图书ID
	 * @return 更新好的图书信息类
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/borrows")
	public List<BorrowingDetails> selectBookBorrows(Integer id) {
		List<BorrowingDetails> bookBorrowingHistory = this.borrowService.selectBorrowsByUserId(id);
		return bookBorrowingHistory;
	}

	/**
	 * @Description 添加图书信息
	 * @param 新的图书信息
	 * @return 跳转到列表页面
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/add")
	public String addBook(@RequestBody Book book) {
		book.setOnTime(new Date());
		bookService.save(book);
		return "保存成功";
	}

	/**
	 * @Description 修改图书信息
	 * @param 更新后的图书信息
	 * @return 跳转到列表页面
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/update")
	public String updateBook(@RequestBody Book book) {
		if(book.getOffNumber() != 0) {
			book.setOffTime(new Date());
		}
		bookService.update(book);
		return "更新成功";
	}

	/**
	 * @Description 根据ID删除对应图书信息
	 * @param 图书ID
	 * @return 跳转到列表页面
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping("/delete")
	public String deleteBook(Integer bookId) {
		bookService.deleteById(bookId);
		return "删除成功";
	}
	
}
