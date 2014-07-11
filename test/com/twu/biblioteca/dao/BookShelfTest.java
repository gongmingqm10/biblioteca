package com.twu.biblioteca.dao;

import com.twu.biblioteca.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookShelfTest {
    private BookShelf bookShelf;

    @Before
    public void setUp() throws Exception {
        bookShelf = new BookShelf("books.csv");
    }

    @Test
    public void listBooksTest() {
        List<Book> books = bookShelf.listBooks();
        if (books == null || books.size() == 0) {
            Assert.fail("No book loaded");
        } else {
            Assert.assertEquals("First book name should be 'Seven Database in Seven Weeks'", "Seven Database in Seven Weeks", books.get(0).getName());
        }
    }


}