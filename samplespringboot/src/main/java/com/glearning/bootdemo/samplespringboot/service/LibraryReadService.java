package com.glearning.bootdemo.samplespringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;

public interface LibraryReadService {

	List<LibraryEntity> getAllLibrary();

	List<LibraryEntity> getAllLibrariesWithNoBooks();

	Page<LibraryEntity> getLibrariesPaged();

	Page<LibraryEntity> getLibrariesCustomPaged(int pageNo, int numberOfRecords);

	List<LibraryEntity> getLibrariesWithLatestAddedOrder();

	List<LibraryEntity> getLibrariesCustomSortedById(Direction direction);

	List<LibraryEntity> getLibrariesCustomSortedByName(Direction direction);

	Page<LibraryEntity> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames);

	Page<LibraryEntity> getLibrariesPagedAndSortedByName();

	Page<LibraryEntity> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeparatedBookNames, int pageNo, int numberOfRecords);

	List<LibraryEntity> getSortedByNameAndWithTheseBooks(String commaSeperatedBookNames);

	List<LibraryEntity> getLibrariesByIds(List<Long> ids);

	Optional<LibraryEntity> getALibraryById(Long id);

	Optional<LibraryEntity> getALibraryWithTheseBooks(String commaSeparatedBookNames);

}