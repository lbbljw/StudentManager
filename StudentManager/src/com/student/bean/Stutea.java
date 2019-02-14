package com.student.bean;

public class Stutea {
Student student= new Student();
Teacher teacher= new Teacher();
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
@Override
public String toString() {
	return "Stutea [student=" + student + ", teacher=" + teacher + "]";
}
public Stutea(Student student, Teacher teacher) {
	super();
	this.student = student;
	this.teacher = teacher;
}
public Stutea() {
	super();
	// TODO 自動生成されたコンストラクター・スタブ
}

}
