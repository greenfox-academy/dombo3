package com.greenfoxacademy;

import com.greenfoxacademy.model.HelloWorld;
import com.greenfoxacademy.model.MyColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellobeanApplication implements CommandLineRunner {

	@Autowired
	HelloWorld hello;

	@Autowired
	MyColor color;

	public static void main(String[] args) {
		SpringApplication.run(HellobeanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		hello.setMessage("Hello World");
		System.out.println(hello.getMessage());
		color.printColor();
	}
}
