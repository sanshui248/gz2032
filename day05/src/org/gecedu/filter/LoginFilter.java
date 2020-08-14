package org.gecedu.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gecedu.dao.UserDao;
import org.gecedu.dao.impl.UserDaoImpl;
import org.gecedu.model.User;

public class LoginFilter implements Filter{

	//存到需要放行的请求路径
	private List<String> list;
	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//类型转换
		HttpServletRequest request  = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		//从session里面获取登录状态
		Object obj = request.getSession().getAttribute("loginUser");
		
		//获取请求路径
		String requestURI = request.getRequestURI();
		boolean flag = checkUrl(requestURI);    //flag true 放行，否则跳转到登录页面
		boolean flagCookie = checkCookie(request);
		if(obj!=null||flag||flagCookie) {
			//表示已登录
			//放行
			chain.doFilter(request, response);
		}else {
			//如果没有获取到，重定向到登录页面
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
	}

	private boolean checkCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String account = null;
		String password = null;
		if(cookies!=null&&cookies.length>0) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("account")){
					account = cookie.getValue();
				}
				if(cookie.getName().equals("password")){
					password = cookie.getValue();
				}
			}
		}
	
		//自动登录
		if(account!=null&&password!=null) {
			UserDao userDao = new UserDaoImpl();
			User user = userDao.queryByAccountAndPwd(account, password);
			if(user!=null) {
				request.getSession().setAttribute("loginUser", user);
				return true;
			}
		}
		
		return false;
	}

	private boolean checkUrl(String requestURI) {
		
		for(String str:list) {
			if(requestURI.contains(str)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		//允许放行
		list = new ArrayList<String>();
		list.add("/login");
		list.add("/assets");
		list.add("/UserLoginServlet");
		
	}

}
