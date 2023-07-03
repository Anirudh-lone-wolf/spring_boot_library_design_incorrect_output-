package com.glearning.bootdemo.samplespringboot.service;

import java.util.List;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;

public interface LibraryCreateService {

	String addSingleLibrary(LibraryEntity libraryEntity);

	String addAllLibraries(List<LibraryEntity> libs);

	LibraryEntity addLibrararywithSaveAndFlush(LibraryEntity library);

}