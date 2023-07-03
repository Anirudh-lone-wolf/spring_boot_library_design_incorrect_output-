package com.glearning.bootdemo.samplespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;
import com.glearning.bootdemo.samplespringboot.service.LibraryDeleteService;

@Controller
@RequestMapping("/deleteService")
public class LibraryDeleteController {
	
	@Autowired
	LibraryDeleteService deleteService;
	
	@DeleteMapping("/deleteOneLib")
	public String deleteOneLib(LibraryEntity entity) {
		
		return deleteService.deleteOneLibrary(entity);
	}
	
}
