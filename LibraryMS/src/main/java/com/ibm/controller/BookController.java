package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ibm.domain.Book;
import com.ibm.domain.BookLabel;
import com.ibm.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * @Description 获取图书信息列表
	 * @param
	 * @return 图书信息列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public PageInfo<Book> selectBookList(Integer pageNum, Integer pageSize) {
		List<Book> books = bookService.selectAll(pageNum, pageSize);
		PageInfo<Book> pageInfo = new PageInfo<Book>(books);
		return pageInfo;
	}

	/**
	 * @Description 根据ID获取对应图书信息
	 * @param 图书ID
	 * @return 对应的图书信息
	 */
	@ResponseBody
	@RequestMapping("/query")
	public Book selectBookList(Integer bookId) {
		return bookService.getById(bookId);
	}

	/**
	 * @Description 根据设置的标签获取对应图书信息
	 * @param 图书关键字类
	 * @return 对应的图书信息列表
	 */
	@ResponseBody
	@RequestMapping("/list/label")
	public PageInfo<Book> selectBookListByLabel(@RequestBody BookLabel bookLabel, Integer pageNum, Integer pageSize) {
		List<Book> books = bookService.selectByLabel(bookLabel, pageNum, pageSize);
		PageInfo<Book> pageInfo = new PageInfo<Book>(books);
		return pageInfo;
	}

	/**
	 * @Description 根据关键字模糊查询对应图书信息
	 * @param 关键字
	 * @return 对应的图书信息列表
	 */
	@ResponseBody
	@RequestMapping("/list/key")
	public PageInfo<Book> selectBookListByKey(String key, Integer pageNum, Integer pageSize) {
		List<Book> books = bookService.selectByKey(key, pageNum, pageSize);
		PageInfo<Book> pageInfo = new PageInfo<Book>(books);
		return pageInfo;
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
