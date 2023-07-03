package com.glearning.bootdemo.samplespringboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;
import com.glearning.bootdemo.samplespringboot.repository.LibraryRepository;
import com.glearning.bootdemo.samplespringboot.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImplClass implements LibraryDeleteService {

	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public String deleteOneLibrary(LibraryEntity libraryEntity) {
		
		libraryRepository.delete(libraryEntity);
		
		return "this library has been deleted : "+libraryEntity ;
		
	}

	@Override
	public String pruneTable() {
		
		libraryRepository.deleteAll();
		return "all records deleted (table is truncated or pruned)";

	}

	@Override
	public String deleteAllThese(List<LibraryEntity> libraryEntities) {
		
		libraryRepository.deleteAll(libraryEntities);
		return "deleted all the libraries in the list";

	}
	
	@Override
	public String deleteAllInBatch() {
		
		libraryRepository.deleteAllInBatch();
		return "deletes all records in batch";

	}
	
	@Override
	public String deleteLibraryById(Long Id) {
		
		libraryRepository.deleteById(Id);
		return "Library with this id - "+Id+" has been deleted";

	}
	
	@Override
	public String deleteAllTheseInBatch(List<LibraryEntity> libraryEntities) {
		
		libraryRepository.deleteInBatch(libraryEntities);
		return "deleted all the libraries in the list in batch";
		
	}

}
