package model;

import java.lang.reflect.Field;
import java.util.List;

public class ScoreProc {

	// 과목별 총점
	public int getSubjectTotal(String subject, List<Student> studentList) {
		int total = 0;
		for (Student student : studentList) {
			if(subject.equals("kor")) total += student.getScore().getKor();
			else if(subject.equals("eng")) total += student.getScore().getEng();
			else if(subject.equals("math")) total += student.getScore().getMath();
		}
		return total;
	}	
	
	// 과목별 평균
	public float getSubjectAverage(String subject, List<Student> studentList) {
		return getSubjectTotal(subject, studentList) / studentList.size();
	}
	
	// 학생별 총점
	public int getStudentTotal(Student student) {
		Score score = student.getScore();
		return score.getKor() + score.getEng() + score.getMath();
	}
	
	// 학생별 평균
	public float getStudentAverage(Student student) {
		
		// Reflection API를 활용해 Score클래스의 멤버변수(필드)의 수를 계산
		Class scoreClass = Score.class;
		// 객체로 클래스 정보 얻음, 멤버변수들을 배열로 받음
		Field[] fields = scoreClass.getDeclaredFields();
		
		return getStudentTotal(student) / fields.length-1; // serialVersionUID 제외
	}
	
} // class
