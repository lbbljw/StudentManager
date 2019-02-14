/**
 *
 */
package com.student.bean;

/**
 *
 * studentのBeanクラス
 *
 * @author firstdevelop zhangyong
 *
 */
public class Student {

	// 変数定義id
	private int id;
	// 変数定義氏名
	private String name;
	// 変数定義生年月日
	private String birthday;
	// 変数定義年齢
	private int age;
	// 変数定義成績
	private double score;
	// 変数定義授業id
	private int classid;

	private int JY;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age セットする age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return score
	 */
	public double getScore() {
		return score;
	}
	/**
	 * @param score セットする score
	 */
	public void setScore(double score) {
		this.score = score;
	}
	/**
	 * @return classid
	 */
	public int getClassid() {
		return classid;
	}
	/**
	 * @param classid セットする classid
	 */
	public void setClassid(int classid) {
		this.classid = classid;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + ", score=" + score
				+ ", classid=" + classid + "]";
	}
	/**
	 * @param id
	 * @param name
	 * @param birthday
	 * @param age
	 * @param score
	 * @param classid
	 */
	public Student(int id, String name, String birthday, int age, double score, int classid) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.score = score;
		this.classid = classid;

	}
	/**
	 *
	 */
	public Student() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
