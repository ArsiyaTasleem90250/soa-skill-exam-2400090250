
package com.klef.soa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.klef.soa.entity.LibraryBook;
import com.klef.soa.repository.LibraryBookRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LibraryBookRepositoryTest {

    @Autowired
    private LibraryBookRepository repo;

    private LibraryBook b1;
    private LibraryBook b2;

    @BeforeEach
    public void setData() {

        b1 = new LibraryBook();
        b1.setName("Java Programming");
        b1.setType("Technical");
        b1.setStatus(true);
        b1.setLocation("Shelf A");

        b2 = new LibraryBook();
        b2.setName("Python Basics");
        b2.setType("Technical");
        b2.setStatus(false);
        b2.setLocation("Shelf B");

        repo.save(b1);
        repo.save(b2);
    }

    @Test
    public void testFindAll() {

        List<LibraryBook> books = repo.findAll();

        assertNotNull(books);
        assertEquals(2, books.size());
    }

    @Test
    public void testFindById() {

        Optional<LibraryBook> book = repo.findById(b1.getLibraryBookId());

        assertTrue(book.isPresent());

        assertEquals(b1.getLibraryBookId(),
                book.get().getLibraryBookId());

        Optional<LibraryBook> book2 = repo.findById(999L);

        assertFalse(book2.isPresent());
    }

    @Test
    public void testFindByName() {

        List<LibraryBook> books = repo.findByName("Java Programming");

        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals("Java Programming", books.get(0).getName());
    }

    @Test
    public void testCount() {

        long count = repo.count();

        assertEquals(2, count);
    }

    @Test
    public void testEntityDetails() {

        LibraryBook book = repo.findById(b1.getLibraryBookId()).get();

        assertNotNull(book.getName());
        assertNotNull(book.getType());
        assertNotNull(book.getLocation());
        assertTrue(book.isStatus());
    }
}
