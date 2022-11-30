package com.demo.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.demo.model.Courses;



public class Courses_task{
public static void main(String args[])
{
	List<Courses> courseList=List.of(new Courses(101,"JEECore","ABC",10,10000),
			new Courses(102,"NEET","DEF",3,12000),
			new Courses(103,"AIPMT","GHI",4,11000),
			new Courses(104,"CET","JKL",6,13400),
			new Courses(105,"JEE-Advance","MNO",10,12500),
			new Courses(106,"CAT","PQR",5,30000),
			new Courses(107,"IBPS","STU",7,10000),
			new Courses(108,"MPSC","VWX",14,15000),
			new Courses(109,"UPSC","YZA",15,34000),
			new Courses(110,"TET","CBA",12,12000),
			new Courses(111,"NET","FED",7,11000),
			new Courses(112,"CLAT","IHG",1,16000),
			new Courses(113,"CSE","LKJ",20,40000),
			new Courses(114,"CDS","ONM",17,45000),
			new Courses(115,"CTET","RQP",27,25000));
	//System.out.println("Before Sorting");
	//courseList.forEach(System.out::println);
	Comparator<Courses> descPrice = (Courses c1,Courses c2) ->(int) (c2.getTotal_fees()-c1.getTotal_fees());
	List<Courses> courseListnew =new ArrayList<Courses>(courseList);
	Collections.sort(courseListnew ,descPrice);
	System.out.println("1] Task : Sorting based on course fees in Descending Order>>>>> ");
	courseListnew.forEach(System.out::println);
//	for(Courses c: courseListnew) {
//	 duplicateFees(c,c)->c.get
//	}
	System.out.println("2] Task : If price is same, then sort on duration form shortest to longest>>>>> ");
	courseListnew.stream().sorted((c1, c2)->{
		if(c2.getTotal_fees()==c1.getTotal_fees()) {
			
		return c2.getCourse_duration()-c1.getCourse_duration();
	} else
	return (int) (c1.getTotal_fees()-c2.getTotal_fees());
}).forEach(System.out::println);
	
	
}


			
	
	
	
}
