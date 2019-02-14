package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Stutea;
import com.student.mapper.StuteaMapper;

public class StuteaDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Stutea> queryAll() {
		String sql = "select" +
				 "student.name ," +
				"student.birthday," +
				"   student.age," +
				"   student.classid," +
				"    teacher.id as teaid," +
				"	 teacher.course " +
				"				from" +
				"  student" +
				"  left join teacher" +
				"    on student.id = teacher.id";
		ArrayList<Stutea> stuteaList = new ArrayList<Stutea>();
		stuteaList = (ArrayList<Stutea>) jdbcTemplate.query(sql, new StuteaMapper());
		return stuteaList;
	}
}
