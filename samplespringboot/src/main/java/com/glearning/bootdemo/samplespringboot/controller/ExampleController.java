package com.glearning.bootdemo.samplespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.bootdemo.samplespringboot.model.GreatLearning;
import com.glearning.bootdemo.samplespringboot.serviceimpl.ExampleServiceImpl;

//@Controller
@RestController // @Controller + @ResponseBody = @RestController
public class ExampleController {
	
	@Autowired
	ExampleServiceImpl exampleServiceImpl;

	@GetMapping("/info")
//	@ResponseBody
	public GreatLearning get() {

		return exampleServiceImpl.get();
	}

	@PostMapping("/cusinfo")
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		
		return exampleServiceImpl.customInfo(courseName, courseType, firstName, lastName);
	}

}
