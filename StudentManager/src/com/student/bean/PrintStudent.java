/**
 *
 */
package com.student.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author a
 *
 */
public class PrintStudent {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// Studentクラスを使って 新規studentOne
		Student studentOne=new Student();
		Student StudentOne=new Student();
	}

	/**
	 *
	 *
	 * @param studentList
	 * @return SumScore
	 */

	private static double getSumStudentScore(List<Student> studentList) {
		double SumScore = 0;
		for (Student student : studentList) {
			SumScore = SumScore + student.getScore();
		}
		return SumScore;
	}

	/**
	 *
	 * @param studentMap
	 * @return
	 */

	private static double getSumStudentScoreMap(Map<String, Student> studentMap) {

		double SumScore = 0;
		for (Student student : studentMap.values()) {
			SumScore = SumScore + student.getScore();
		}
		return SumScore;
	}

}
