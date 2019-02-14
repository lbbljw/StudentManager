package com.order.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.order.bean.Order;

public class OrderMapper implements RowMapper<Order> {
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order=new Order();
		order.setName(rs.getString("name"));
		order.setDate(getStringDate(rs.getString("date")));
		order.setAmount(rs.getInt("amount"));
		return order;
	}


	private  String getStringDate(String date) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateString = new Date();
		String strRtnDate = "";
		try {
			dateString = formatter.parse(date);
			strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strRtnDate;
	}
}