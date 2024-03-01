package com.dantes.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dantes.demo.classes.Laptop;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	
		Laptop lenovo = context.getBean(Laptop.class);
		
		lenovo.setBrandName("Lenovo");
		lenovo.setWeight(3);
		System.out.println(lenovo.toString());
		
	}

}
