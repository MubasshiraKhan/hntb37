package com.demo.model;

public class Courses {
	int course_id;
	String course_name;
	String course_teacher;
	int course_duration;
	double total_fees;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_teacher() {
		return course_teacher;
	}
	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}

	
	public int getCourse_duration() {
		return course_duration;
	}
	public void setCourse_duration(int course_duration) {
		this.course_duration = course_duration;
	}
	public double getTotal_fees() {
		return total_fees;
	}
	public void setTotal_fees(double total_fees) {
		this.total_fees = total_fees;
	}
	
	public Courses(int course_id, String course_name, String course_teacher, int course_duration, double total_fees) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_teacher = course_teacher;
		this.course_duration = course_duration;
		this.total_fees = total_fees;
	}
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name + ", course_teacher=" + course_teacher
				+ ", course_duration=" + course_duration + ", total_fees=" + total_fees + "]";
	}
	
	


}
