package com.io.giordano.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.io.giordano.dao.dbClass;

public class mainApp {
	public static void main(String [] args) {
	//Import the config file...
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(configClass.class);
	//Summin the bean
		dbClass db = context.getBean("dbClass",dbClass.class);
		
	// act upon it...
	String result =	db.user("<script>alert(22)</script>");
		System.out.println(result);
		//close context
		context.close();
		
		
		
	}
}
