package com.teacher.controller;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.student.bean.Teacher;
import com.student.dao.TeacherDao;
@Controller
public class TeacherController {
	@RequestMapping(value = "/teaall")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中?取dao
		 TeacherDao teadao = (TeacherDao) context.getBean("teadao");
		 ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		 teacherList=(ArrayList<Teacher>) teadao.queryteaAll();
		 model.addAttribute("teachers", teacherList);
		return "indexTeacher";
	}
	@RequestMapping(value = "/queryteaByName")
	public String queryteaByName(String teachername, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中?取dao
		 TeacherDao teadao = (TeacherDao) context.getBean("teadao");
		model.addAttribute("teachers", teadao.queryteaByName(teachername));
		return "indexTeacher";
	}
	@RequestMapping(value = "/addtea")
	public String Addteacher(String teachername, String course, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao teadao = (TeacherDao) context.getBean("teadao");
		Teacher teacher = new Teacher();
		teacher.setTeachername(teachername);
		teacher.setCourse(course);
		boolean result = teadao.addtea(teacher);
		if (result) {
			model.addAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添加失敗！')</script>");
		}
		model.addAttribute("teachers", teadao.queryteaAll());
		return "indexTeacher";
	}
	@RequestMapping(value = "/deleteteaById")
	public String deleteteaById(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao teadao = (TeacherDao) context.getBean("teadao");
		boolean result = teadao.deleteTea(Integer.parseInt(id));

		if (result) {
		System.out.println("消除成功");
		} else {
			System.out.println("消除失敗");
		}
		model.addAttribute("teachers", teadao.queryteaAll());
		return "indexTeacher";
	}

	@RequestMapping(value = "/teaupdate")
	public String updateTeacher(String id, String teachername, String course,Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao teadao = (TeacherDao) context.getBean("teadao");
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(id));
		teacher.setTeachername(teachername);
		teacher.setCourse(course);
		boolean result = teadao.updateTeachert(teacher);
		if (result) {
			System.out.println("update成功");
		} else {
			System.out.println("update失敗");
		}
		model.addAttribute("teachers", teadao.queryteaAll());
		return "indexTeacher";
	}
}

