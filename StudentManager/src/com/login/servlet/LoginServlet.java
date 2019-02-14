package com.login.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.login.bean.User;
import com.login.dao.UserDao;
import com.login.dao.UserDaoImpl;

public class LoginServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("賬號或密碼錯誤");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username + " , " + password );
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserByUsernameAndPassword(username, password);
		if(user == null) {
			resp.sendRedirect("login.html");
		}else {
			out.println("<h1><font color='green'>Login Success! 逋ｻ蠖墓�仙粥<font><h1>");
		}
	}

}
