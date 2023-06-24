package com.glearning.bootdemo.samplespringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.glearning.bootdemo.samplespringboot.model.GreatLearning;

@SpringBootApplication
public class SamplespringbootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SamplespringbootApplication.class, args);
		System.out.println("hi");
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		GreatLearning greatLearning  = new GreatLearning();
		greatLearning.setCourseName("webdev");
		greatLearning.setCourseType("backend");
		greatLearning.setInstructorName("samarth the boss");
		System.out.println(greatLearning);
		
//		GreatLearning greatLearning2  = new GreatLearning("webdev", "backend", "samarth the boss");
//		System.out.println(greatLearning2);
		
	}

}
