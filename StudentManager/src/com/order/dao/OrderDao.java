package com.order.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import com.order.bean.Order;
import com.order.mapper.OrderMapper;

public class OrderDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Order> queryAll() {
		String sql = "select name,date,amount from ordertable";
		List<Order> orderList = new ArrayList<Order>();
		orderList = jdbcTemplate.query(sql, new OrderMapper());
		return orderList;
	}

	public List<Order> queryByName(String name) {
		String sql = "select name,date,amount from ordertable where name like '%" + name + "%'";
		List<Order> orderList = new ArrayList<Order>();
		orderList = jdbcTemplate.query(sql, new OrderMapper());
		return orderList;
	}
}
