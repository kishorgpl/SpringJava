package com.spring.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {

	public static void main(String[] args) {  
	      
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	      
	    EmployeeDao dao=(EmployeeDao)ctx.getBean("d");  
	      
	    Employee e=new Employee();  
	    e.setId(114);  
	    e.setName("varun");  
	    e.setSalary(50000);  
	      
	    dao.saveEmployee(e);  
	      
	}  

}
