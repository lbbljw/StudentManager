package com.ajax.app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ajax.app.beans.ShoppingCart;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取请求参数  id  price
		String bookName=request.getParameter("id");
		int price=Integer.parseInt(request.getParameter("price"));
		//2 获取购物车对象
		HttpSession session=request.getSession();
		ShoppingCart sc=(ShoppingCart)session.getAttribute("sc");
		if(sc==null) {
			sc=new ShoppingCart();
			session.setAttribute("sc", sc);
		}
		//3 把点击的选项加入到购物车中
		sc.addToCart(bookName, price);
		//4准备响应的JSON对象 {"bookName":"","totalBookNumber":1,"totalMoney":1}
		StringBuilder resule=new StringBuilder();
		resule.append("{")
			  .append("\"bookName\":\""+bookName+"\"")
			  .append(",")
			  .append("\"totalBookNumber\":"+sc.getTotalBookNumber())
			  .append(",")
			  .append("\"totalMoney\":"+sc.getTotalMoney())
			  .append("}");

//		ObjectMapper mapper = new ObjectMapper();
//		String resule=mapper.writeValueAsString(sc);
//		System.out.println(resule);

		//5响应JSON对象
		response.setContentType("text/javascript");
		response.getWriter().print(resule.toString());
		//response.getWriter().print(resule);
	}

}
