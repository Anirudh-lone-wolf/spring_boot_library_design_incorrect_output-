package com.glearning.bootdemo.samplespringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.bootdemo.samplespringboot.model.GreatLearning;

//@Controller
@RestController // @Controller + @ResponseBody = @RestController
public class ExampleController {

	@GetMapping("/info")
//	@ResponseBody
	public GreatLearning get() {
//		GreatLearning greatLearning = new GreatLearning("Controllers", "IT", "Samarth Narula");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("Controllers");
		greatLearning.setCourseType("IT");
		greatLearning.setInstructorName("Samarth Narua");
		return greatLearning;
	}

	@PostMapping("/cusinfo")
	public GreatLearning customInfo(String courseName, String courseType, String instructorName) {
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName(courseName);
		greatLearning.setCourseType(courseType);
		greatLearning.setInstructorName(instructorName);
		return greatLearning;
	}

}
