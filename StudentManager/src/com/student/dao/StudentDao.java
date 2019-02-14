package com.student.dao;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.bean.Student;
import com.student.bean.Stutea;
import com.student.mapper.StudentMapper;


public class StudentDao {

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
 *
 * @return studentList
 */
	public List<Student> queryAll(){

		String sql="select id,name,birthday,age,score,classid from student";

		List<Student> studentList=new ArrayList<Student>();

		studentList=jdbcTemplate.query(sql, new StudentMapper());

		return studentList;

	}

	/**
	 * 通過姓名查找
	 *
	 * @param name
	 * @return  List<Student>
	 */

	public List<Student> queryByName(String name){

		String sql="select id,name,birthday,age,score,classid from student where name like '%"+name+"%'";

		List<Student> studentList=new ArrayList<Student>();

		studentList=jdbcTemplate.query(sql, new StudentMapper());

		return studentList;

	}







//	public List<Student> queryCount() {
//		String sql = "select count(*) from student";
//		List<Student> studentList = new ArrayList<Student>();
//		studentList = (ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper());
//		return studentList;
//	}
//	public Integer queryCount() {
//		int count=0;
//		String sql = "select count(*) from student";
//		count=(int)jdbcTemplate.query(sql, new StudentMapper());
//		return count;
//
//	}

/**
 * データベースから全部ユーザ検索して結果をindex.jsp
 * @return studentList
 */


/**
 *
 * @param sPoint
 * @param ePoint
 * @return
 */
	public List<Student> querypageAll(int sPoint ,int ePoint) {
		String sql = "select * from student limit ?,?";
		// 将???果映射到Student?中，添加到list中，并返回
		List<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) jdbcTemplate.query(sql,new Object[] {sPoint,ePoint},new StudentMapper());
		return studentList;
	}












	/**
	 *
	 * @param id
	 * @return
	 */
 public List<Student>queryByID(String id){
	 String sql="select id,name,birthday,age,score,classid from student where id like  "+id+" ";
	 List<Student> studentList=new ArrayList<Student>();
	 studentList=(ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper());
	return studentList;
 }
	/**
	 * 添加学生
	 * @param student
	 * @return 返回??型： boolean
	 */
	public boolean addStu(Student student) {
		String sql = "insert into student(id,name,birthday,age,score,classid) values(0,?,?,?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore(),student.getClassid() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE,Types.INTEGER }) == 1;
	}

	/**
	 * ?除学生
	 *
	 * @param id
	 * @return 返回??型： boolean
	 */
	public boolean deleteStu(Integer id) {
		String sql = "delete from student where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}
	//
	/**
	 * 更新学生信息
	 *
	 * @param student
	 * @return 返回??型： boolean
	 */
	public boolean updateStudent(Student student) {
		String sql = "update student set name=?,birthday=?,age=?,score =? ,classid =?  where id =?";
		Object stuObj[] = new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore(),
				student.getClassid(), student.getId() };
		return jdbcTemplate.update(sql, stuObj) == 1;
	}



	//
	// /**
	// * 通?姓名??
	// *
	// * @param name
	// * @return 返回??型： List<Student>
	// */
	// public List<Student> queryMaxAge() {
	// String sql = "select max(age) from student";
	//
	// return jdbcTemplate.query(sql, new StudentMaxMapper());
	// }
	//
	 /**
	 *
	 *
	 * @param name
	 * @return 返回??型： List<Student>
	 */
//	 public List<Student> queryAvgScore() {
//	 String sql = "select avg(score) from student";
//	 return jdbcTemplate.query(sql, new StudentMapper());
//	 }

	/**
	 *
	 * @return studentList
	 */
	public List<Student> getStudentList() {
		//フィルダー情報の配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		StudentDao studao = (StudentDao) context.getBean("dao");
		//新学生リストを生成する
		List<Student> studentList = new ArrayList<Student>();
		//studentdaoから貰ったqueryAll方法で学生情報をstudentlistへ戻す
		studentList = studao.queryAll();
		return studentList;
		}
/**
 *
 * @param studentList
 * @return
 */
	public double getAverAge(List<Student> studentList) {

//			BigDecimal average = BigDecimal.ZERO;
	//
//			for (Student student : studentList) {
//				average.add(new BigDecimal(student.getScore()));
//			}
//			return average.divide(new BigDecimal(studentList.size()));
			double SumStudentScore = 0;
			for(Student stu:studentList) {
				SumStudentScore+=stu.getScore();
			}
			return SumStudentScore/studentList.size();
		}
/**
 *
 * @param studentList
 * @param average
 * @return returnList
 */
		public List<Student> getReturnList(List<Student> studentList, double average) {

			List<Student> returnList = new ArrayList<>();

			for (Student student : studentList) {
//				if (new BigDecimal(student.getScore()).compareTo(average) > 0) {
//					returnList.add(student);
//				}
				if(student.getScore()>average) {
					returnList.add(student);
				}
			}
			return returnList;
		}

	public  List<Student> MinAge(List<Student> studentList) {
		// 最小年齢の初期化
		int minAge = 0;
		int num = 0;
		// Loop 最小値取得
		for (Student student : studentList) {
			if (num == 0) {
				minAge = student.getAge();
				num++;
			} else {
				if (student.getAge() < minAge) {
					minAge = student.getAge();
				}
			}
		}
		// 算出した年齢を返す
		return studentList;
	}
}
