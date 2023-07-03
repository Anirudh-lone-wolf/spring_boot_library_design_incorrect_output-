package com.glearning.bootdemo.samplespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.bootdemo.samplespringboot.service.LibraryCountService;

@RestController
@RequestMapping("/countservice")
public class LibraryCountController {
	
	@Autowired
	LibraryCountService countService;
	
	@GetMapping("/countLibraries")
	public long countLibraries() {
		
		return countService.countLibraries();
		
	}
	
	@GetMapping("/countLibsWithZeroBooks")
	public long countLibsWithZeroBook() {
		
		return countService.countLibrariesWithZeroBooks();
		
	}

}
