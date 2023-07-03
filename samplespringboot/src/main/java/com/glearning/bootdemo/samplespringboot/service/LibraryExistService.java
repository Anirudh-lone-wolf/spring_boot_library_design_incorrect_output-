package com.glearning.bootdemo.samplespringboot.service;

public interface LibraryExistService {

	boolean checkLibraryExistsById(Long Id);

	boolean checkLibraryExistsByExample(String commaSeperatedBookNames);

}