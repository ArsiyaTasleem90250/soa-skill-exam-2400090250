package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.LibraryBook;

@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long>
{
	
	List<LibraryBook> findByName(String name);
	List<LibraryBook> findByType(String type);
}