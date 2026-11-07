package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.LibraryBook;

public interface LibraryBookService
{
	LibraryBook addLibraryBook(LibraryBook libraryBook);

	List<LibraryBook> displayAllLibraryBooks();

	LibraryBook updateLibraryBook(LibraryBook libraryBook);

	LibraryBook displayLibraryBookById(Long libraryBookId);

	String deleteLibraryBookById(Long libraryBookId);

	List<LibraryBook> displayLibraryBookByName(String name);

	List<LibraryBook> displayLibraryBookByType(String type);
}