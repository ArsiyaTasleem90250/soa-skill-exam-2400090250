package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.LibraryBook;
import com.klef.soa.service.LibraryBookService;

@RestController
@RequestMapping("/librarybook")
public class LibraryBookController
{
	@Autowired
	private LibraryBookService service;

	@GetMapping("/")
	public String test()
	{
		return "SOA Programming & MicroServices";
	}

	// Add Library Book
	@PostMapping("/add")
	public ResponseEntity<LibraryBook> addLibraryBook(@RequestBody LibraryBook libraryBook)
	{
		LibraryBook book = service.addLibraryBook(libraryBook);
		return ResponseEntity.status(201).body(book);
	}

	// Display All Library Books
	@GetMapping("/displayall")
	public ResponseEntity<List<LibraryBook>> displayAllLibraryBooks()
	{
		List<LibraryBook> books = service.displayAllLibraryBooks();
		return ResponseEntity.status(200).body(books);
	}

	// Display Library Book By ID
	@GetMapping("/display")
	public ResponseEntity<?> displayLibraryBookById(@RequestParam Long id)
	{
		LibraryBook book = service.displayLibraryBookById(id);

		if(book != null)
		{
			return ResponseEntity.status(200).body(book);
		}
		else
		{
			return ResponseEntity.status(404).body("Library Book ID Not Found");
		}
	}

	// Update Library Book
	@PutMapping("/update")
	public ResponseEntity<?> updateLibraryBook(@RequestBody LibraryBook libraryBook)
	{
		LibraryBook book = service.updateLibraryBook(libraryBook);

		if(book != null)
		{
			return ResponseEntity.ok(book);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Library Book ID Not Found");
		}
	}

	// Delete Library Book By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLibraryBookById(@PathVariable Long id)
	{
		String message = service.deleteLibraryBookById(id);

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Display Library Books By Name
	@GetMapping("/displaybyname/{name}")
	public ResponseEntity<List<LibraryBook>> displayLibraryBooksByName(
			@PathVariable String name)
	{
		List<LibraryBook> books = service.displayLibraryBookByName(name);

		return ResponseEntity.status(200).body(books);
	}

	// Display Library Books By Type
	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<LibraryBook>> displayLibraryBooksByType(
			@PathVariable String type)
	{
		List<LibraryBook> books = service.displayLibraryBookByType(type);

		return ResponseEntity.status(200).body(books);
	}
}