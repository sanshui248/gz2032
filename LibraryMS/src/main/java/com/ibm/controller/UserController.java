package com.ibm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.domain.Book;
import com.ibm.domain.BorrowingDetails;
import com.ibm.domain.User;
import com.ibm.service.BookService;
import com.ibm.service.BorrowService;
import com.ibm.service.UserService;

/**
 * 
 * @author 吕守淼
 *
 * @date   2020-11-18 16:25:59
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BorrowService borrowService;
	
	/**
	 * 保存用户
	 * @param user添加的用户
	 * @return
	 */
	@RequestMapping("/saveUser")
	@ResponseBody
	public String saveUser(User user) {
		this.userService.saveUser(user);
		return "插入成功";
	}
	
	/**
	 * 更新用户
	 * @param user更新的用户
	 * @return
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(User user) {
		this.userService.updateUser(user);
		return "更新成功";
	}
	
	/**
	 * 查询用户
	 * @param pageNum页面号
	 * @param pageSize页面记录数
	 * @return
	 */
	@RequestMapping("/selectUser")
	@ResponseBody
	public List<User> selectUserListByPage(int pageNum,int pageSize) {
		List<User> selectUserListByPage = this.userService.selectUserListByPage(pageNum, pageSize);
		return selectUserListByPage;
	}
	
	/**
	 * 用户详情
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping("/selectBorrowHistory")
	@ResponseBody
	public List<BorrowingDetails> selectBorrowHistory(int userId) {
		List<BorrowingDetails> selectBorrowHistory = this.userService.selectBorrowingDetailsByUserId(userId);
		return selectBorrowHistory;
	}
	
	/**
	 * 注销用户
	 * @param userId  用户id
	 * @return
	 */
	@RequestMapping("/deleteUser/{userId}")
	@ResponseBody
	public String deleteUser(@PathVariable("userId") int userId) {
		this.userService.deleteUser(userId);
		return "删除成功";
	} 
	
	/**
	 *       借阅书籍
	 * @param bookId 书籍id
	 * @param session
	 * @return
	 */
	@RequestMapping("/borrow/{bookId}")
	@ResponseBody
	public String borrowBook(@PathVariable("bookId") int bookId,HttpSession session) {
//		User user = (User) session.getAttribute("user");
//		int userId = user.getUserId();
//		int borrowNum = user.getBooksNumber();
		User user = this.userService.getUserByName("赵");
		int userId = user.getUserId();
		int borrowNum = user.getBooksNumber();
		
		if (borrowNum==3) {
			return "借阅数量达到上限，请先归还";
		}else {
			Book book = this.bookService.getById(bookId);
			if (book.getSurplusNumber()<=0) {
				return "该书籍已全部借出";
			}else {
				this.borrowService.saveBorrowRecords(userId,bookId);
				book.setSurplusNumber(book.getSurplusNumber()-1);
				this.bookService.update(book);
				user.setBooksNumber(user.getBooksNumber()+1);
				this.userService.updateUser(user);
				return "借阅成功";
			}
		}
	} 
	
	/**
	 *       归还书籍
	 * @param bookId 书籍id
	 * @param session
	 * @return
	 */
	@RequestMapping("/return/{bookId}")
	@ResponseBody
	public String returnBook(@PathVariable("bookId") int bookId,HttpSession session) {
//		User user = (User) session.getAttribute("user");
//		int userId = user.getUserId();
		User user = this.userService.getUserByName("赵");
		int userId = user.getUserId();
		Book book = this.bookService.getById(bookId);
		
		BorrowingDetails borrowingDetails2 = new BorrowingDetails();
		borrowingDetails2.setBookId(bookId);
		borrowingDetails2.setUserId(userId);
		BorrowingDetails borrowingDetails = this.borrowService.selectByBookIdAndUserId(borrowingDetails2);
		
		borrowingDetails.setBorrowStutas(0);
		borrowingDetails.setReturnTime(new Date());
		this.borrowService.update(borrowingDetails);
		book.setSurplusNumber(book.getSurplusNumber()+1);
		this.bookService.update(book);
		user.setBooksNumber(user.getBooksNumber()-1);
		this.userService.updateUser(user);
		return "归还成功";
	} 
	
	
}
