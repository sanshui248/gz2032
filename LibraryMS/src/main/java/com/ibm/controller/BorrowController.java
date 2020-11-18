package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ibm.domain.BorrowingDetails;
import com.ibm.service.BorrowService;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

	@Autowired
	private BorrowService borrowService;

	/**
	 * @Description 获取借阅记录列表
	 * @param pageNum：页数 pageSize：页面记录数
	 * @return 借阅记录列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public PageInfo<BorrowingDetails> selectBorrowList(Integer pageNum, Integer pageSize) {
		List<BorrowingDetails> borrows = borrowService.selectAll(pageNum, pageSize);
		PageInfo<BorrowingDetails> pageInfo = new PageInfo<BorrowingDetails>(borrows);
		return pageInfo;
	}

	/**
	 * @Description 根据用户ID获取对应借阅记录
	 * @param 用户ID
	 * @return 对应用户的借阅记录
	 */
	@ResponseBody
	@RequestMapping("/query/user")
	public List<BorrowingDetails> selectBorrowByUserId(Integer userId) {
		return borrowService.selectByUserId(userId);
	}

	/**
	 * @Description 根据图书ID获取对应借阅记录
	 * @param 图书ID
	 * @return 对应图书的借阅记录
	 */
	@ResponseBody
	@RequestMapping("/query/book")
	public List<BorrowingDetails> selectBorrowByBookId(Integer bookId) {
		return borrowService.selectByBookId(bookId);
	}

	/**
	 * @Description 根据关键字模糊查询对应借阅记录
	 * @param 关键字
	 * @return 对应的借阅记录列表
	 */
	@ResponseBody
	@RequestMapping("/list/key")
	public PageInfo<BorrowingDetails> selectBorrowListByKey(String key, Integer pageNum, Integer pageSize) {
		List<BorrowingDetails> borrows = borrowService.selectByKey(key, pageNum, pageSize);
		PageInfo<BorrowingDetails> pageInfo = new PageInfo<BorrowingDetails>(borrows);
		return pageInfo;
	}

	/**
	 * @Description 添加借阅记录
	 * @param 新的借阅记录
	 * @return 跳转到列表页面
	 */
	@RequestMapping("/add")
	public String addBorrow(@RequestBody BorrowingDetails borrow) {
		borrowService.save(borrow);
		return "redirect:/borrow/list";
	}

	/**
	 * @Description 修改借阅记录
	 * @param 更新后的借阅记录
	 * @return 跳转到列表页面
	 */
	@RequestMapping("/update")
	public String updateBorrow(@RequestBody BorrowingDetails borrow) {
		borrowService.update(borrow);
		return "redirect:/borrow/list";
	}

	/**
	 * @Description 根据用户ID和图书ID删除对应借阅记录
	 * @param userId:用户ID bookId:图书ID
	 * @return 跳转到列表页面
	 */
	@RequestMapping("/delete")
	public String deleteBorrow(Integer userId, Integer bookId) {
		borrowService.deleteById(userId, bookId);
		return "redirect:/borrow/list";
	}

}
