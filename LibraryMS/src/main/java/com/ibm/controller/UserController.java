package com.ibm.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
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
 * @date 2020-11-18 16:25:59
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	BookService bookService;

	@Autowired
	BorrowService borrowService;

	/**
	 * @Description保存用户
	 * @param user添加的用户
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		System.out.println(user.getName());
		this.userService.saveUser(user);
		return "插入成功";
	}

	/**
	 * @Description更新用户
	 * @param user更新的用户
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		this.userService.updateUser(user);
		return "更新成功";
	}

	/**
	 * @Description 查询用户
	 * @param pageNum页面号
	 * @param pageSize页面记录数
	 * @return
	 */
	@RequestMapping("/selectUserPage")
	public PageInfo<User> selectUserListByPage(int pageNum, int pageSize) {
		List<User> selectUserListByPage = this.userService.selectUserListByPage(pageNum, pageSize);
		PageInfo<User> pageInfo = new PageInfo<User>();
		pageInfo.setList(selectUserListByPage);
		return pageInfo;
	}

	/**
	 * @Description 查询用户
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/selectAllUser")
	public List<User> selectAllUser() {
		List<User> allUser = this.userService.selectAllUser();
		return allUser;
	}

	/**
	 * @Description 模糊查询用户
	 * @param vageName 模糊名
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/selectUserByVagueName/{vageName}")
	public List<User> selectUserListByVageName(@PathVariable("vageName") String vagueName) {
		List<User> selectUserListByVageName = this.userService.selectUserListByVagueName(vagueName);
		return selectUserListByVageName;
	}

	/**
	 * @Description用户详情
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping("/selectBorrowHistory")
	public List<BorrowingDetails> selectBorrowHistory(int userId) {
		List<BorrowingDetails> selectBorrowHistory = this.userService.selectBorrowingDetailsByUserId(userId);
		return selectBorrowHistory;
	}

	/**
	 * @Description注销用户
	 * @param userId 用户id
	 * @return
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") int userId) {
		this.userService.deleteUser(userId);
		return "删除成功";
	}
	
	/**
	 * @Description用户书架
	 * @param session
	 * @return
	 */
	@CrossOrigin(origins = "*",allowedHeaders = "*")
	@RequestMapping("/bookshelves")
	public List<BorrowingDetails> bookshelves(HttpSession session){
		System.out.println(session.getId());
		User user = (User) session.getAttribute("user");
		List<BorrowingDetails> bookshelves = this.userService.selectShelves(user.getUserId());
		return bookshelves;
	} 

	/**
	 * @Description借阅书籍
	 * @param bookId  书籍id
	 * @param session
	 * @return
	 */
	@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
	@RequestMapping("/borrow/{bookId}")
	public String borrowBook(@PathVariable("bookId") int bookId, HttpSession session) {
		System.out.println(session.getId());
		User user = (User) session.getAttribute("user");
		int userId = user.getUserId();
//		User user = this.userService.getUserByName("赵");
//		int userId = user.getUserId();
		System.out.println(userId);
		int borrowNum = user.getBooksNumber();

		if (borrowNum == 3) {
			return "借阅数量达到上限，请先归还";
		} else {
			Book book = this.bookService.getById(bookId);
			if (book.getSurplusNumber() <= 0) {
				return "该书籍已全部借出";
			} else {
				this.borrowService.saveBorrowRecords(userId, bookId);
				book.setSurplusNumber(book.getSurplusNumber() - 1);
				this.bookService.update(book);
				user.setBooksNumber(user.getBooksNumber() + 1);
				this.userService.updateUser(user);
				return "借阅成功";
			}
		}
	}

	/**
	 * @Description归还书籍
	 * @param bookId  书籍id
	 * @param session
	 * @return
	 */
	@CrossOrigin(origins = "*",allowedHeaders = "*")
	@RequestMapping("/return/{bookId}")
	public String returnBook(@PathVariable("bookId") int bookId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		int userId = user.getUserId();
//		User user = this.userService.getUserByName("赵");
//		int userId = user.getUserId();
		Book book = this.bookService.getById(bookId);

//		BorrowingDetails borrowingDetails2 = new BorrowingDetails();
//		Book book2 = new Book();
//		book2.setBookId(bookId);
//		borrowingDetails2.setBook(book2);
//		User user2 = new User();
//		user2.setUserId(userId);
//		borrowingDetails2.setUser(user2);
//		BorrowingDetails borrowingDetails = this.borrowService.selectByBookIdAndUserId(borrowingDetails2);

//		borrowingDetails.setBorrowStates(0);
//		borrowingDetails.setReturnTime(new Date());
//		this.borrowService.update(borrowingDetails);
		
		this.borrowService.updateStatesById(new Date(), userId, bookId);
		
		book.setSurplusNumber(book.getSurplusNumber() + 1);
		this.bookService.update(book);
		user.setBooksNumber(user.getBooksNumber() - 1);
		this.userService.updateUser(user);
		return "归还成功";
	}
	
	/**
	 * @Description修改密码
	 * @param password
	 * @param session
	 * @return
	 */
	@CrossOrigin(origins = "*",allowedHeaders = "*")
	@RequestMapping("/changPwd")
	public String changPassword(String password,HttpSession session) {
		User user = (User) session.getAttribute("user");
		String encryPassword = new Md5Hash(password,"salt").toString();
		this.userService.updatePasswordByUserId(encryPassword,user.getUserId());
		return "修改成功";
	}

	/**
	 * @Description导入用户信息
	 * @param file
	 * @return
	 */
	@CrossOrigin(origins = "*",allowedHeaders = "*")
	@RequestMapping("/import")
	public String importUser(@RequestParam("file") MultipartFile file) {
		try {
			// 根据路径获取这个操作excel的实例
			XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream()); // 根据页面index 获取sheet页
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = null;

			// 循环sesheet页中数据从第二行开始，第一行是标题
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

				// 获取每一行数据
				row = sheet.getRow(i);

				User user = new User();
				Md5Hash passwordEncry = new Md5Hash(row.getCell(4).getStringCellValue(),"salt");

				user.setName(row.getCell(0).getStringCellValue());
				user.setSex(Integer.valueOf((int) row.getCell(1).getNumericCellValue()));
				user.setAge(Integer.valueOf((int) row.getCell(2).getNumericCellValue()));
				user.setEmail(row.getCell(3).getStringCellValue());
				user.setPassword(passwordEncry.toString());
				user.setBirthday(row.getCell(5).getDateCellValue());
				user.setPhone(row.getCell(6).getStringCellValue());
				user.setAddress(row.getCell(7).getStringCellValue());
				user.setIntroduction(row.getCell(8).getStringCellValue());
				user.setIdentity(0);
				user.setBooksNumber(0);

				this.userService.saveUser(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "导入成功!";
	}

	/**
	 * @Description导出用户表
	 * @param response
	 * @throws IOException
	 */
	@CrossOrigin(origins = "*",allowedHeaders = "*")
	@RequestMapping("/export")
	public void exportUser(HttpServletResponse response) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("用户表");

		List<User> allUser = this.userService.selectAllUser();

		String fileName = "user" + ".xls";// 设置要导出的文件的名字
		// 新增数据行，并且设置单元格数据

		int rowNum = 1;
		String[] headers = { "账号", "姓名", "性别", "年龄", "生日","电话号码","住址","自我介绍","已借书籍数量" };
		// headers表示excel表中第一行的表头

		XSSFRow row = sheet.createRow(0);
		// 在excel表中添加表头

		for (int i = 0; i < headers.length; i++) {
			XSSFCell cell = row.createCell(i);
			XSSFRichTextString text = new XSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// 在表中存放查询到的数据放入对应的列
		for (User user : allUser) {
			XSSFRow row1 = sheet.createRow(rowNum);
			row1.createCell(0).setCellValue(user.getUserId());
			row1.createCell(1).setCellValue(user.getName());
			row1.createCell(2).setCellValue(user.getSexStr());
			row1.createCell(3).setCellValue(user.getAge());
			row1.createCell(4).setCellValue(user.getBirthdayStr());
			row1.createCell(5).setCellValue(user.getPhone());
			row1.createCell(6).setCellValue(user.getAddress());
			row1.createCell(7).setCellValue(user.getIntroduction());
			row1.createCell(8).setCellValue(user.getBooksNumber());
			rowNum++;
		}
		
		// 设置ContentType 请求信息格式
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);

		workbook.write(response.getOutputStream());
		response.flushBuffer();

	}
}
