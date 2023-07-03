package com.glearning.bootdemo.samplespringboot.service;

import java.util.List;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;

public interface LibraryDeleteService {

	String deleteOneLibrary(LibraryEntity libraryEntity);

	String pruneTable();

	String deleteAllThese(List<LibraryEntity> libraryEntities);

	String deleteAllInBatch();

	String deleteLibraryById(Long Id);

	String deleteAllTheseInBatch(List<LibraryEntity> libraryEntities);

}