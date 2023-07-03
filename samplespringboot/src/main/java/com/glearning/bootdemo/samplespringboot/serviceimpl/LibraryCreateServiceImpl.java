package com.glearning.bootdemo.samplespringboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;
import com.glearning.bootdemo.samplespringboot.repository.LibraryRepository;
import com.glearning.bootdemo.samplespringboot.service.LibraryCreateService;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public String addSingleLibrary(LibraryEntity libraryEntity) {
		
		libraryRepository.save(libraryEntity);
		libraryRepository.flush();
		
		return "library saved";
				
	}
	
	@Override
	public String addAllLibraries(List<LibraryEntity> libs) {
		
		libraryRepository.saveAll(libs);
		libraryRepository.flush();
		
		return "All Libraries are saved";
		
	}
	
	@Override
	public LibraryEntity addLibrararywithSaveAndFlush(LibraryEntity library) {
		
		return libraryRepository.saveAndFlush(library);
		
	}

}
