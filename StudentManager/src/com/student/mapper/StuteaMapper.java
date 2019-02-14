package com.student.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;
import com.student.bean.Student;
import com.student.bean.Stutea;
import com.student.bean.Teacher;


	public class StuteaMapper implements RowMapper<Stutea> {

		public Stutea mapRow(ResultSet rs, int rowNum) throws SQLException {
			Stutea stutea = new Stutea();
			Student student = new Student();
			Teacher teacher = new Teacher();
			student.setName(rs.getString(1));
			student.setBirthday(getStringDate(rs.getString(2)));
			student.setAge(rs.getInt(3));
			student.setClassid(rs.getInt(4));
			teacher.setId(rs.getInt(5));
			teacher.setCourse(rs.getString(6));
			stutea.setStudent(student);
			stutea.setTeacher(teacher);
			return stutea;
		}

		private  String getStringDate(String birthday) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateString = new Date();
			String strRtnDate = "";
			try {
				dateString = formatter.parse(birthday);
				strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return strRtnDate;
		}
//web ->controller ->dao -queryall()
}
