package com.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.order.bean.Order;
import com.order.dao.OrderDao;

@Controller
public class OrderController {

	@RequestMapping(value = "/ull")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderDao dao = (OrderDao) context.getBean("orderdao");
		List<Order> orderList = new ArrayList<Order>();
		orderList = dao.queryAll();
		model.addAttribute("orders", orderList);
		return "order";
	}
	@RequestMapping(value = "/queryorByName")
	public String queryByName(String name,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderDao dao = (OrderDao) context.getBean("orderdao");
		List<Order> orderList = new ArrayList<Order>();
		orderList = dao.queryByName(name);
		model.addAttribute("orders", orderList);
		return "order";
	}

}
