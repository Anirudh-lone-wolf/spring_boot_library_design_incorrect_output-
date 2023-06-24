package com.glearning.bootdemo.samplespringboot.serviceimpl;

import org.springframework.stereotype.Service;

import com.glearning.bootdemo.samplespringboot.model.FullName;
import com.glearning.bootdemo.samplespringboot.model.GreatLearning;
import com.glearning.bootdemo.samplespringboot.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService{
	
	public GreatLearning get() {
		log.info("the get method");
//		GreatLearning greatLearning = new GreatLearning("Controllers", "IT", "Samarth Narula");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("Controllers");
		greatLearning.setCourseType("IT");
		//greatLearning.setInstructorName("Samarth Narua");
		greatLearning.setInstructorName(FullName.builder().firstName("Samath").lastName("Narula").build());
		return greatLearning;
	}
	
	public GreatLearning customInfo(String courseName, String courseType,
														String firstName, String lastName) {
		log.info("the customInfo method");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName(courseName);
		greatLearning.setCourseType(courseType);
		greatLearning.setInstructorName(FullName.builder().firstName(firstName).lastName(lastName).build());
		return greatLearning;
	}

}
