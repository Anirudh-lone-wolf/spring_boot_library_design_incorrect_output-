package com.glearning.bootdemo.samplespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;
import com.glearning.bootdemo.samplespringboot.service.LibraryCreateService;

@RestController
@RequestMapping("/createservice")
public class LibraryCreateController {
	
	@Autowired
	LibraryCreateService createService;
	
	@PostMapping("/addSingleLib")
	public String addSingleLib(LibraryEntity entity) {
		
		return createService.addSingleLibrary(entity);
		
	}
	
	@PostMapping("/insertAllLibraries")
	public String insertAllLibraries(@RequestBody List<LibraryEntity> libs) {
		
		return createService.addAllLibraries(libs);
		
	}
	
	@PostMapping("/addLibWithSandF")
	public LibraryEntity addLibWithSandF(LibraryEntity entity) {
		
		return createService.addLibrararywithSaveAndFlush(entity);
		
	}

}
