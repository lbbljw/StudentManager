package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
//import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import com.student.bean.Teacher;
import com.student.mapper.TeacherMapper;


public class TeacherDao {

	/**
	 * @Fields jdbcTemplate
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * spring提供的?
	 *
	 * @param jdbcTemplate
	 *            返回??型： void
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * データベースから全部ユーザ検索して結果をindex,jspに返却
	 *
	 * @return 返回??型： List<Student>
	 */
	public List<Teacher> queryteaAll() {
		String sql = "select id,teachername,course from teacher";
		// 将???果映射到Student?中，添加到list中，并返回
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = (ArrayList<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;
	}

	public List<Teacher> queryteaByName(String teachername) {
		String sql = "select id,teachername,course from teacher where teachername like '%" + teachername + "%'";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = (ArrayList<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;
	}

	public boolean addtea(Teacher teacher) {
		String sql = "insert into teacher(id,teachername,course) values(0,?,?)";


		return jdbcTemplate.update(sql,
				new Object[] { teacher.getTeachername(), teacher.getCourse() },
				new int[] { Types.VARCHAR, Types.VARCHAR }) == 1;
	}

	public boolean deleteTea(Integer id) {

		String sql = "delete from teacher where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	public boolean updateTeachert(Teacher teacher) {

		String sql = "update teacher set teachername=?,course=?  where id =?";
		Object terObj[] = new Object[] { teacher.getTeachername(),teacher.getCourse(),teacher.getId() };

		return jdbcTemplate.update(sql, terObj) == 1;
	}

}
