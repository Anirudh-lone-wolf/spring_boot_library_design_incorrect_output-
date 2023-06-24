package com.glearning.bootdemo.samplespringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.glearning.bootdemo.samplespringboot.model.FullName;
import com.glearning.bootdemo.samplespringboot.model.GreatLearning;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SamplespringbootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SamplespringbootApplication.class, args);
		System.out.println("hi");
		
	}

	@Override
	public void run(String... args) throws Exception {
		
//		GreatLearning greatLearning  = new GreatLearning();
//		greatLearning.setCourseName("springboot");
//		greatLearning.setCourseType("spring framework");
//		//greatLearning.setInstructorName("Samarth Narula");
//		System.out.println("GreatLearning object using NoArgsConstructor : "+greatLearning);
//		
//		GreatLearning greatLearningUsingAllArgs  = new GreatLearning("webdev", "IT", "Samarth Narula");
//		System.out.println("GreatLearning object using AllArgsConstructor : "+greatLearningUsingAllArgs);
//		
//		//Telescoping Constructor Design Pattern
//		GreatLearning greatLearningTeleDesignPattern = new GreatLearning("Learning Constructor Design Patterns", 
//																											"Spring-Boot Framework");
//		System.out.println("GreatLearning object using Telescoping Constructor Design Pattern : "
//																											+greatLearningTeleDesignPattern);
//		
//		//Builder Pattern
//		GreatLearning greatLearningWithBuilderPatten = GreatLearning.builder()
//				.courseName("Learning Builder Design Pattern")
//				.courseType("spring-boot")
//				//.instructorName("samarth")
//				.build();
//		System.out.println("GreatLearning object using Builder Design Pattern : "+greatLearningWithBuilderPatten);
//		
//		GreatLearning greatLearningWithBuilderPattern2 = GreatLearning.builder()
//				.courseName("FULL STACK").build();
//		System.out.println("GreatLearning object using Builder Design Pattern, Only Course Name this time: "
//				+greatLearningWithBuilderPattern2);
		
		GreatLearning greatLearningComplexObjsUsingBuilderPattern = GreatLearning.builder()
				.courseName("Complex Objects")
				.courseType("Spring-Boot I")
				.instructorName(FullName.builder().firstName("Samarth").lastName("Narula").build())
				.build();
//		System.out.println("GreatLearning Object Using Builder Design Pattern With Complex Objects :: ");
//		System.out.println(greatLearningComplexObjsUsingBuilderPattern);
		
		log.info("GreatLearning Complex Object creation - > {} ", greatLearningComplexObjsUsingBuilderPattern);
		
	}

}
