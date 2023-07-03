package com.glearning.bootdemo.samplespringboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreatLearning {

	private String courseName;

	private String courseType;

	//private String instructorName;
	
	private FullName instructorName;

	public GreatLearning(String courseName) {
		super();
		this.courseName = courseName;
	}

	public GreatLearning(String courseName, String courseType) {
		super();
		this.courseName = courseName;
		this.courseType = courseType;
	}
	
}
