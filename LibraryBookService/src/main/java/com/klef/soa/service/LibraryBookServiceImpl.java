package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.LibraryBook;
import com.klef.soa.repository.LibraryBookRepository;

@Service
public class LibraryBookServiceImpl implements LibraryBookService
{
	@Autowired
	private LibraryBookRepository repo;

	@Override
	public LibraryBook addLibraryBook(LibraryBook libraryBook)
	{
		return repo.save(libraryBook);
	}

	@Override
	public List<LibraryBook> displayAllLibraryBooks()
	{
		return repo.findAll();
	}

	@Override
	public LibraryBook updateLibraryBook(LibraryBook b)
	{
		Optional<LibraryBook> optional = repo.findById(b.getLibraryBookId());

		if(optional.isPresent())
		{
			LibraryBook book = optional.get();

			book.setName(b.getName());
			book.setType(b.getType());
			book.setStatus(b.isStatus());
			book.setLocation(b.getLocation());

			return repo.save(book);
		}
		else
		{
			return null;
		}
	}

	@Override
	public LibraryBook displayLibraryBookById(Long libraryBookId)
	{
		return repo.findById(libraryBookId).orElse(null);
	}

	@Override
	public String deleteLibraryBookById(Long libraryBookId)
	{
		boolean status = repo.existsById(libraryBookId);

		if(status)
		{
			repo.deleteById(libraryBookId);
			return "Library Book Deleted Successfully...!";
		}
		else
		{
			return "Library Book ID Not Found...!";
		}
	}

	@Override
	public List<LibraryBook> displayLibraryBookByName(String name)
	{
		return repo.findByName(name);
	}

	@Override
	public List<LibraryBook> displayLibraryBookByType(String type)
	{
		return repo.findByType(type);
	}
}