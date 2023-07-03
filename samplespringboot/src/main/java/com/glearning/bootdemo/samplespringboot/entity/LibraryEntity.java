package com.glearning.bootdemo.samplespringboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LibraryEntity {

	@Id
	private long id;
	
	private String name;
	
	private String commaSeparatedBooks;
	
	
}
