package com.glearning.bootdemo.samplespringboot.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;
import com.glearning.bootdemo.samplespringboot.repository.LibraryRepository;
import com.glearning.bootdemo.samplespringboot.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public boolean checkLibraryExistsById(Long Id) {

		return libraryRepository.existsById(Id);

	}

	@Override
	public boolean checkLibraryExistsByExample(String commaSeperatedBookNames) {

		LibraryEntity libraryEntity = new LibraryEntity();
		libraryEntity.setCommaSeparatedBooks(commaSeperatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", GenericPropertyMatchers.exact()).withIgnorePaths("name", "id");
		
		Example<LibraryEntity> example = Example.of(libraryEntity, exampleMatcher);
		
		return libraryRepository.exists(example);

	}

}
