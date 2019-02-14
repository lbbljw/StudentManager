package com.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.student.bean.Student;
import com.student.bean.Stutea;
import com.student.dao.StudentDao;
import com.student.dao.StuteaDao;

@Controller
public class StudentController {

	private static final String INDEX = "index";
/**
 *	DBから学生情報を取る
 * @param model
 * @return INDEX
 */
	@RequestMapping(value = "/all")
	public String queryAll(Model model) {
		// フィルダー情報の配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从iocからdaoを取る
		StudentDao dao = (StudentDao) context.getBean("dao");
		// 新学生リストを生成する
		List<Student> studentList = new ArrayList<Student>();
		// studentdaoから貰ったqueryAll方法で学生情報をstudentlistへ戻す
		studentList = dao.queryAll();
		model.addAttribute("students", studentList);
		return INDEX;
	}
/**
 *
 * @param name
 * @param model
 * @return INDEX
 */
	@RequestMapping(value = "/queryByName")
	public String queryByName(String name,Model model) {
		// フィルダー情報の配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从iocからdaoを取る
		StudentDao dao = (StudentDao) context.getBean("dao");
		// 新学生リストを生成する
		List<Student> studentList = new ArrayList<Student>();
		// studentdaoから貰ったqueryAll方法で学生情報をstudentlistへ戻す
		studentList = dao.queryByName(name);
		model.addAttribute("students", studentList);
		return INDEX;
	}




	/**
	 * 求學生平均成績
	 *
	 * @param model
	 * @return index
	 */
	// @RequestMapping(value = "/queryAvgScore")
	// public String queryScore(Model model) {
	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("applicationContext.xml");
	// StudentDao dao = (StudentDao) context.getBean("dao");
	// List<Student> studentList = new ArrayList<Student>();
	// studentList = dao.queryAvgScore();
	// model.addAttribute("students", studentList);
	// return "index";
	// }
	/**
	 * Idで学生を検索
	 *
	 * @param id
	 * @param model
	 * @return 返回值型： String
	 */

	@RequestMapping(value = "/queryById")
	public String queryById(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		List<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) dao.queryByID(id);
		model.addAttribute("students", studentList);
		return INDEX;
	}

	/**
	 * 分页显示数据从第strBPoint条开始，共显示strPageRecordNum条
	 *
	 * @param strBPoint
	 * @param strPageRecordNum
	 * @param model
	 * @return 返回值型： String
	 */
	@RequestMapping(value = "/pageall")
	public String querypageAll(String strBPoint, String strPageRecordNum, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		if (strBPoint == null) {
			strBPoint = "0";
		}
		if (strPageRecordNum == null) {
			strPageRecordNum = "10";
		}
		StudentDao studao = (StudentDao) context.getBean("dao");
		List<Student> studentList = new ArrayList<Student>();
		List<Student> studentAll = new ArrayList<Student>();
		studentAll = (ArrayList<Student>) studao.queryAll();
		int count = studentAll.size();
		int start = Integer.parseInt(strBPoint) * Integer.parseInt(strPageRecordNum);
		double pageCount = Math.ceil(count / Integer.valueOf(strPageRecordNum));
		studentList = (ArrayList<Student>) studao.querypageAll(start, Integer.parseInt(strPageRecordNum));
		model.addAttribute("students", studentList);
		model.addAttribute("pageCounts", pageCount);
		return "NewFile";
	}

	/**
	 * 表接合显示数据
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stuteaall")
	public String querystuteaAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中?取dao
		StuteaDao stuteadao = (StuteaDao) context.getBean("stuteadao");
		ArrayList<Stutea> stuteaList = new ArrayList<Stutea>();
		stuteaList = (ArrayList<Stutea>) stuteadao.queryAll();
		model.addAttribute("stuteas", stuteaList);
		return "stutea";
	}

	/**
	 *
	 * 名前で学生を検索する index.jspへ戻す
	 *
	 * @param name
	 * @param model
	 * @return 返回值型： String
	 */
//	@RequestMapping(value = "/queryByName")
//	public String queryByName(String name, Model model) {
//		// フィルダー情報の配置
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		// 从iocからdaoを取る
//		StudentDao dao = (StudentDao) context.getBean("dao");
//		// studentdaoから貰ったqueryAll方法で学生情報をstudentlistへ戻す
//		model.addAttribute("students", dao.queryByName(name));
//		return INDEX;
//	}

	/**
		 *
		 * 名前で学生を検索する index.jspへ戻す
		 *
		 * @param name
		 * @param model
		 * @return 返回值型： String
		 */
	//	@RequestMapping(value = "/queryByName")
	//	public String queryByName(String name, Model model) {
	//		// フィルダー情報の配置
	//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	//		// 从iocからdaoを取る
	//		StudentDao dao = (StudentDao) context.getBean("dao");
	//		// studentdaoから貰ったqueryAll方法で学生情報をstudentlistへ戻す
	//		model.addAttribute("students", dao.queryByName(name));
	//		return INDEX;
	//	}

		/**
		 * 学生追加
		 *
		 * @param name
		 * @param birthday
		 * @param age
		 * @param score
		 * @param classid
		 * @param model
		 * @return 返回值型： String
		 */


		@RequestMapping(value = "/add")
		public String AddStudent(String name, String birthday, String age, String score, String classid, Model model) {
			// フィルダー情報の配置
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			// 从ioc容器中获取dao
			StudentDao dao = (StudentDao) context.getBean("dao");
			// 新規student object
			Student student = new Student();
			student.setName(name);
			student.setBirthday(birthday);
			student.setAge(Integer.valueOf(age));
			student.setScore(Double.parseDouble(score));
			student.setClassid(Integer.valueOf(classid));
			boolean result = dao.addStu(student);

			if (result) {
				//model.addAttribute("msg", "<script>alert('添加成功！')</script>");
				System.out.println("添加成功！");
			} else {
				model.addAttribute("msg", "<script>alert('添加失敗！')</script>");
			}
			model.addAttribute("students", dao.queryAll());
			return INDEX;
		}


	/**
	 * 学生追加
	 *
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 * @param classid
	 * @param model
	 * @return 返回值型： String
	 */


	/**
	 * 通過id除学生
	 *
	 * @param id
	 * @param model
	 * @return 返回值型： String
	 */
	@RequestMapping(value = "/deleteById")
	public String deleteById(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		boolean result = dao.deleteStu(Integer.parseInt(id));
		if (result) {
			System.out.println("消除成功");
		} else {
			System.out.println("消除失敗");
		}
		model.addAttribute("students", dao.queryAll());
		return INDEX;
	}

	/**
	 *
	 * @param id
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 * @param classid
	 * @param model
	 * @return 返回值型： String
	 */
	@RequestMapping(value = "/update")
	public String updateStudent(String id, String name, String birthday, String age, String score, String classid,
			Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		Student student = new Student();
		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(Integer.valueOf(age));
		student.setScore(Double.parseDouble(score));
		student.setClassid(Integer.valueOf(classid));
		boolean result = dao.updateStudent(student);
		if (result) {
			System.out.println("update成功");
		} else {
			System.out.println("update失敗");
		}
		model.addAttribute("students", dao.queryAll());
		return INDEX;
	}

	/**
	 * Ajax
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/myajax", produces = "application/json;charset=UTF-8")
	public void getAjax(HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studao = (StudentDao) context.getBean("dao");
		List<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) studao.queryAll();
		// JSONArray array= JSONArray.parseArray(JSON.toJSONString(studentList));
		JSONArray data = new JSONArray(); // List
		for (Student stu : studentList) {
			JSONObject jsonObject = new JSONObject(); // Map
			jsonObject.put("id", stu.getId());
			jsonObject.put("name", stu.getName());
			jsonObject.put("birthday", stu.getBirthday());
			jsonObject.put("age", stu.getAge());
			jsonObject.put("score", stu.getScore());
			jsonObject.put("classid", stu.getClassid());
			data.add(jsonObject);
		}
		// {id:"1",name:"liming",age:"20"}

		// obj jsonobj JSONObject obj.put
		// data JSONArray data.add

		obj.put("result", true);
		obj.put("data", data);
		try {
			response.setContentType("application/json");
			response.getWriter().write(obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/goodscore")
	public String displayGoodScore(Model model) {
		List<Student> studentList = getStudentList();
		double average = getAverAge(studentList);
		List<Student> returnList = getReturnList(studentList, average);
		model.addAttribute("students", returnList);
		return INDEX;
	}

	public List<Student> getStudentList() {
		// フィルダー情報の配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		StudentDao studao = (StudentDao) context.getBean("dao");
		// 新学生リストを生成する
		List<Student> studentList = new ArrayList<Student>();
		// studentdaoから貰ったqueryAll方法で学生情報をstudentlistへ戻す
		studentList = studao.queryAll();
		return studentList;
	}

	/**
	 *
	 * @param studentList
	 * @return
	 */
	public double getAverAge(List<Student> studentList) {

		// BigDecimal average = BigDecimal.ZERO;
		//
		// for (Student student : studentList) {
		// average.add(new BigDecimal(student.getScore()));
		// }
		// return average.divide(new BigDecimal(studentList.size()));
		double SumStudentScore = 0;
		for (Student stu : studentList) {
			SumStudentScore += stu.getScore();
		}
		return SumStudentScore / studentList.size();
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
			// if (new BigDecimal(student.getScore()).compareTo(average) > 0) {
			// returnList.add(student);
			// }
			if (student.getScore() > average) {
				returnList.add(student);
			}
		}
		return returnList;
	}

}
