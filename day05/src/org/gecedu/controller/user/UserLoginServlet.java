package org.gecedu.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import org.gecedu.dao.UserDao;
import org.gecedu.dao.impl.UserDaoImpl;
import org.gecedu.model.User;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前端传进来的账号密码
		String account = request.getParameter("account");
		String password= request.getParameter("password");
		String rememberme= request.getParameter("rememberme");
		//根据账号密码信息查询数据库
		UserDao userDao = new UserDaoImpl();
		User user = userDao.queryByAccountAndPwd(account,password);
		//1.查询到数据，登陆成功
		if(user!=null) {
			//记录登录状态
			// session表示一个会话
			//会话的开始，打开浏览器访问我们的这个网站
			//会话结束，关闭所有的该网站的时候
			request.getSession().setAttribute("loginUser", user);//里面的内容会在内容
			
			//下次自动登录
			//1、创建一个cookie，放进用户的账号和密码
			Cookie accountCookie = new Cookie("account",account);
			Cookie pwdCookie = new Cookie("password",password);
			accountCookie.setPath(request.getContextPath());
			pwdCookie.setPath(request.getContextPath());
			if(rememberme!=null&&rememberme.equals("1")) {
				accountCookie.setMaxAge(60*15);
				pwdCookie.setMaxAge(60*15);
			}else {
				accountCookie.setMaxAge(0);
				pwdCookie.setMaxAge(0);
			}
			response.addCookie(accountCookie);
			response.addCookie(pwdCookie);
			response.sendRedirect(request.getContextPath()+"/MainController");
		}else {
			//2.没有查询到数据，登录失败
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
