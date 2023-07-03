package com.glearning.bootdemo.samplespringboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.glearning.bootdemo.samplespringboot.entity.LibraryEntity;
import com.glearning.bootdemo.samplespringboot.service.LibraryCountService;
import com.glearning.bootdemo.samplespringboot.service.LibraryCreateService;
import com.glearning.bootdemo.samplespringboot.service.LibraryDeleteService;
import com.glearning.bootdemo.samplespringboot.service.LibraryExistService;
import com.glearning.bootdemo.samplespringboot.service.LibraryReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SamplespringbootApplication implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryReadServiceImpl;

	@Autowired
	LibraryCreateService libraryCreateServiceImpl;

	@Autowired
	LibraryCountService libraryCountServicelmpl;

	@Autowired
	LibraryExistService libraryExistServiceImpl;

	@Autowired
	LibraryDeleteService libraryDeleteServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SamplespringbootApplication.class, args);
		System.out.println("hi");

	}

	@Override
	public void run(String... args) throws Exception {

		//readServiceImplMethodsExecution();

		//createServiceImplMethodsExecution();

		// countServiceImplMethodsExecution();

		// existServiceImplMethodsExecution();

		//deleteServiceImplMethodsExecution();

	}

	private void deleteServiceImplMethodsExecution() {
//		log.info("Delete One Library -> {}", libraryDeleteServiceImpl.deleteOneLibrary(
//				LibraryEntity.builder().id(10l).name("C Library").commaSeparatedBooks("ABCD, EFGH, IJKL").build()));
//		
//		log.info("Delete All Libraries -> {}", libraryDeleteServiceImpl.pruneTable());
		
//		List<LibraryEntity> libraries = new ArrayList<LibraryEntity>();
//		libraries.add(LibraryEntity.builder().id(3l).name("Remote Library").commaSeparatedBooks("").build());
//		libraries.add(LibraryEntity.builder().id(4l).name("Random Library").commaSeparatedBooks("").build());
//		log.info("Delete All Libraries in the list-> {}", libraryDeleteServiceImpl.deleteAllThese(libraries));
		
//		log.info("Delete All Libraries in batch -> {}", libraryDeleteServiceImpl.deleteAllInBatch());
		
//		long id = 3l;
//		log.info("Delete Library by ID -> {}", libraryDeleteServiceImpl.deleteLibraryById(id));
		
//		List<LibraryEntity> libraries = new ArrayList<LibraryEntity>();
//		libraries.add(LibraryEntity.builder().id(3l).name("Remote Library").commaSeparatedBooks("").build());
//		libraries.add(LibraryEntity.builder().id(4l).name("Random Library").commaSeparatedBooks("").build());
//		log.info("Delete All Libraries in the list-> {}", libraryDeleteServiceImpl.deleteAllTheseInBatch(libraries));
		
	}

	private void existServiceImplMethodsExecution() {
		Long id = 1l;
		log.info("Check if Library Exists for Id " + id + " -> {}", libraryExistServiceImpl.checkLibraryExistsById(id));

		log.info("Check if Library Exists for Example -> {}",
				libraryExistServiceImpl.checkLibraryExistsByExample("Cosmos, A HitchHikers Guide To the Galaxy"));
	}

	private void countServiceImplMethodsExecution() {
		log.info("count the number of Libraries -> {}", libraryCountServicelmpl.countLibraries());

		log.info("count Libraries with zero books -> {}", libraryCountServicelmpl.countLibrariesWithZeroBooks());
	}

	private void createServiceImplMethodsExecution() {
		LibraryEntity libraryEntity = new LibraryEntity(11l, "Philoshophy Library",
				"Beyond Good and Evil, Meditations, The Art of War");
		log.info("Add Single Library -> {}", libraryCreateServiceImpl.addSingleLibrary(libraryEntity));

		List<LibraryEntity> libraries = new ArrayList<LibraryEntity>();
		libraries.add(LibraryEntity.builder().id(12l).name("F Library").commaSeparatedBooks("abc,efg").build());
		libraries.add(LibraryEntity.builder().id(13l).name("G Library").commaSeparatedBooks("efg").build());
		log.info("Add all Libraries -> {}", libraryCreateServiceImpl.addAllLibraries(libraries));

		log.info("Add a single library by saveAndFlush method -> {}",
				libraryCreateServiceImpl.addLibrararywithSaveAndFlush(LibraryEntity.builder().id(14l).name("H Library")
						.commaSeparatedBooks("Harry Potter Series, Hunger Games, The Hobbit").build()));
	}

	private void readServiceImplMethodsExecution() {
		log.info("Fetch All Libraries -> {}", libraryReadServiceImpl.getAllLibrary());

		log.info("Fetch All Libraries with no books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());

		Page<LibraryEntity> page = libraryReadServiceImpl.getLibrariesPaged();
		List<LibraryEntity> librariesPaged = page.get().collect(Collectors.toList());
		log.info("Fetch Libraries in Page Format -> {}", librariesPaged);

		log.info("Fetch Libraries in Custom Page Format -> {}",
				libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));

		log.info("Fetch Libraries in Latest Added Order -> {}",
				libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());

		log.info("Fetch Libraries in Custom Orderding by Id -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.ASC));
		log.info("Fetch Libraries in Custom Orderding by Id -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.DESC));

		log.info("Fetch Libraries in Custom Orderding by Name -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.ASC));
		log.info("Fetch Libraries in Custom Orderding by Name -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.DESC));

		log.info("Fetch All Libraries default Paged, Sorted by Name and with these Books -> {}",
				libraryReadServiceImpl.getLibrariesPagedAndSortedByNameAndWithTheseBooks("ABCD, EFGH, IJKL").get()
						.collect(Collectors.toList()));

		log.info("Fetch Libraries Paged and Sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));

		log.info("Fetch All Libraries Custom Paged, Sorted by Name and with these Books -> {}", libraryReadServiceImpl
				.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks("ABCD, EFGH, IJKL", 0, 4).get()
				.collect(Collectors.toList()));

		log.info("Fetch All Libraries Sorted by Name and with these books -> {}",
				libraryReadServiceImpl.getSortedByNameAndWithTheseBooks("ABCD, EFGH, IJKL"));

		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		log.info("Fetch all Libraries by their IDs -> {}", libraryReadServiceImpl.getLibrariesByIds(ids));

		long id = 11l;
		Optional<LibraryEntity> optionalLibrary = libraryReadServiceImpl.getALibraryById(id);
		if (optionalLibrary.isPresent())
			log.info("Fetch A Library By Id -> {}", optionalLibrary.get());
		else
			log.info("No matching Library with  an ID of " + id + " was found");

		String books = "GRE Prep, GATE Question Bank, IES Test Papers";
		Optional<LibraryEntity> optionalMatchingLibrary = libraryReadServiceImpl.getALibraryWithTheseBooks(books);
		if (optionalMatchingLibrary.isPresent())
			log.info("Fetch a Library with these books -> {}", optionalMatchingLibrary.get());
		else
			log.info("No matching Library with the books " + books + " has been found");
	}

}
