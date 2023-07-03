package com.glearning.bootdemo.samplespringboot.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;
import com.glearning.bootdemo.samplespringboot.repository.LibraryRepository;
import com.glearning.bootdemo.samplespringboot.service.LibraryCountService;

@Service
public class LibraryCountServicelmpl implements LibraryCountService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public long countLibraries() {

		return libraryRepository.count();

	}

	@Override
	public long countLibrariesWithZeroBooks() {

		LibraryEntity libraryEntity = new LibraryEntity();
		libraryEntity.setCommaSeparatedBooks("");

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooks", GenericPropertyMatchers.exact()).withIgnorePaths("id", "name");
		
		Example<LibraryEntity> example = Example.of(libraryEntity, exampleMatcher);
		
		return libraryRepository.count(example);

	}

}
