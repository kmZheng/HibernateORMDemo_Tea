package com.company.dao.pojo.twowaym2n;

import java.io.Serializable;

public class Score implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//��������
	private Stu stu;//�������
	private Course course;//�������
	private Double courseScore;//����--�м��˽������  ʹ�ð�װ�࣬Ĭ��ֵΪnull��������0
	
	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(Stu stu, Course course) {
		super();
		this.stu = stu;
		this.course = course;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Stu getStu() {
		return stu;
	}

	public void setStu(Stu stu) {
		this.stu = stu;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Double getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(Double courseScore) {
		this.courseScore = courseScore;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", stu=" + stu + ", course=" + course + ", courseScore=" + courseScore + "]";
	}
	
	
	
	
}
