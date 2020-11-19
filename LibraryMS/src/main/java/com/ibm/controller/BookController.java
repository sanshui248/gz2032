package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ibm.domain.Book;
import com.ibm.domain.BookLabel;
import com.ibm.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * @Description 获取图书信息列表
	 * @param pageNum：页数 pageSize：页面记录数
	 * @return 图书信息列表
	 */
	@RequestMapping("/list")
	public PageInfo<Book> selectBookList(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize) {
		List<Book> books = bookService.selectAll(pageNum, pageSize);
		PageInfo<Book> pageInfo = new PageInfo<Book>(books);
		return pageInfo;
	}

	/**
	 * @Description 根据ID获取对应图书信息
	 * @param 图书ID
	 * @return 对应的图书信息
	 */
	@RequestMapping("/query")
	public Book selectBookById(Integer bookId) {
		return bookService.getById(bookId);
	}

	/**
	 * @Description 根据设置的标签获取对应图书信息
	 * @param bookLabel：图书关键字类 pageNum：页数 pageSize：页面记录数
	 * @return 对应的图书信息列表
	 */
	@RequestMapping("/list/label")
	public PageInfo<Book> selectBookListByLabel(@RequestBody BookLabel bookLabel,
			@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize) {
		List<Book> books = bookService.selectByLabel(bookLabel, pageNum, pageSize);
		PageInfo<Book> pageInfo = new PageInfo<Book>(books);
		return pageInfo;
	}

	/**
	 * @Description 根据关键字模糊查询对应图书信息
	 * @param 关键字
	 * @return 对应的图书信息列表
	 */
	@RequestMapping("/list/key")
	public PageInfo<Book> selectBookListByKey(String key,
			@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
			@RequestParam(defaultValue = "5", value = "pageSize") Integer pageSize) {
		List<Book> books = bookService.selectByKey(key, pageNum, pageSize);
		PageInfo<Book> pageInfo = new PageInfo<Book>(books);
		return pageInfo;
	}

	/**
	 * @Description 根据图书ID设置图书借阅记录列表
	 * @param 图书ID
	 * @return 更新好的图书信息类
	 */
	@RequestMapping("/borrows")
	public Book setBookBorrows(Integer id) {
		Book book = bookService.getById(id);
		book.setBorrows(bookService.selectBorrowsByUserId(id));
		return book;
	}

	/**
	 * @Description 添加图书信息
	 * @param 新的图书信息
	 * @return 跳转到列表页面
	 */
	@RequestMapping("/add")
	public String addBook(@RequestBody Book book) {
		bookService.save(book);
		return "redirect:/book/list";
	}

	/**
	 * @Description 修改图书信息
	 * @param 更新后的图书信息
	 * @return 跳转到列表页面
	 */
	@RequestMapping("/update")
	public String updateBook(@RequestBody Book book) {
		bookService.update(book);
		return "redirect:/book/list";
	}

	/**
	 * @Description 根据ID删除对应图书信息
	 * @param 图书ID
	 * @return 跳转到列表页面
	 */
	@RequestMapping("/delete")
	public String deleteBook(Integer bookId) {
		bookService.deleteById(bookId);
		return "redirect:/book/list";
	}
}
