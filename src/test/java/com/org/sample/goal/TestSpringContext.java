package com.org.sample.goal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.cart.controller.LoginController;

public class TestSpringContext {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-configuration.xml");

		// EmployeeManager manager = (EmployeeManager)
		// context.getBean(EmployeeManager.class);

		// OR this will also work

		LoginController controller = (LoginController) context.getBean("loginController");
		System.out.println(controller);
	}
}
