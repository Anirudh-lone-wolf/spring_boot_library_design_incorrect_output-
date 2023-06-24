package com.glearning.bootdemo.samplespringboot.service;

import org.springframework.stereotype.Component;

import com.glearning.bootdemo.samplespringboot.model.GreatLearning;

@Component
public interface ExampleService {
	
	public GreatLearning get();
	
	public GreatLearning customInfo(String courseName, String courseType,
														String firstName, String lastName);

}
