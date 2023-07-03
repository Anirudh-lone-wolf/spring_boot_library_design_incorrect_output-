package com.glearning.bootdemo.samplespringboot.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;
import com.glearning.bootdemo.samplespringboot.repository.LibraryRepository;
import com.glearning.bootdemo.samplespringboot.service.LibraryReadService;

@Service
public class LibraryReadServiceImpl implements LibraryReadService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public List<LibraryEntity> getAllLibrary() {

		return libraryRepository.findAll();

	}

	@Override
	public List<LibraryEntity> getAllLibrariesWithNoBooks() {

		LibraryEntity libraryWithNoBooks = new LibraryEntity();
		libraryWithNoBooks.setCommaSeparatedBooks("");

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooks", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<LibraryEntity> example = Example.of(libraryWithNoBooks, exampleMatcher);

		return libraryRepository.findAll(example);

	}

	@Override
	public Page<LibraryEntity> getLibrariesPaged() {

		Pageable first3records = PageRequest.of(1, 3);

		return libraryRepository.findAll(first3records);

	}

	@Override
	public Page<LibraryEntity> getLibrariesCustomPaged(int pageNo, int numberOfRecords) {

		Pageable customPagedRecords = PageRequest.of(pageNo, numberOfRecords);

		return libraryRepository.findAll(customPagedRecords);

	}

	@Override
	public List<LibraryEntity> getLibrariesWithLatestAddedOrder() {

		return libraryRepository.findAll(Sort.by(Direction.DESC, "id"));

	}

	@Override
	public List<LibraryEntity> getLibrariesCustomSortedById(Direction direction) {

		return libraryRepository.findAll(Sort.by(direction, "id"));

	}

	@Override
	public List<LibraryEntity> getLibrariesCustomSortedByName(Direction direction) {

		return libraryRepository.findAll(Sort.by(direction, "name"));

	}

	@Override
	public Page<LibraryEntity> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {

		LibraryEntity libraryWithTheseBooks = new LibraryEntity();
		libraryWithTheseBooks.setCommaSeparatedBooks(commaSeparatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooks", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<LibraryEntity> example = Example.of(libraryWithTheseBooks, exampleMatcher);

		Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));

		return libraryRepository.findAll(example, pageable);

	}

	@Override
	public Page<LibraryEntity> getLibrariesPagedAndSortedByName() {

		Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));

		return libraryRepository.findAll(pageable);

	}

	@Override
	public Page<LibraryEntity> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeparatedBookNames, int pageNo, int numberOfRecords) {

		LibraryEntity libraryWithTheseBooks = new LibraryEntity();
		libraryWithTheseBooks.setCommaSeparatedBooks(commaSeparatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooks", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<LibraryEntity> example = Example.of(libraryWithTheseBooks, exampleMatcher);

		Pageable pageable = PageRequest.of(pageNo, numberOfRecords, Sort.by("name"));

		return libraryRepository.findAll(example, pageable);

	}

	@Override
	public List<LibraryEntity> getSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {

		LibraryEntity libraryWithTheseBooks = new LibraryEntity();
		libraryWithTheseBooks.setCommaSeparatedBooks(commaSeperatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooks", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<LibraryEntity> example = Example.of(libraryWithTheseBooks, exampleMatcher);

		return libraryRepository.findAll(example, Sort.by("name"));

	}

	@Override
	public List<LibraryEntity> getLibrariesByIds(List<Long> ids) {

		return libraryRepository.findAllById(ids);

	}

	@Override
	public Optional<LibraryEntity> getALibraryById(Long id) {

		return libraryRepository.findById(id);

	}

	@Override
	public Optional<LibraryEntity> getALibraryWithTheseBooks(String commaSeparatedBookNames) {

		LibraryEntity libraryEntity = new LibraryEntity();
		libraryEntity.setCommaSeparatedBooks(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<LibraryEntity> example = Example.of(libraryEntity, exampleMatcher);

		return libraryRepository.findOne(example);

	}

	// Chanchal's Method
//	public Page<LibraryEntity> getLibrariesPagedAndSortedByNameAndWithTheseBooks2(String commaSeperatedBookNames) {
//		LibraryEntity libraryWithTheseBooks = new LibraryEntity();
//		libraryWithTheseBooks.setCommaSeparatedBooks(commaSeperatedBookNames);
//		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
//				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
//				.withIgnorePaths("id", "name");
//		Example<LibraryEntity> example = Example.of(libraryWithTheseBooks, exampleMatcher);
//		Pageable first3records = PageRequest.of(0, 2, Sort.by("name"));
//		return libraryRepository.findAll(example, first3records);
//	}

}
