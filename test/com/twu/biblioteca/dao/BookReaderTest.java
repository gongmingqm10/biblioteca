package com.twu.biblioteca.dao;

import com.twu.biblioteca.model.Book;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookReaderTest{
    private BookReader reader;

    @Before
    public void setUp() throws Exception {
        reader = new BookReader("books.csv");
    }

    @Test
    public void listBooksTest() {
        List<Book> books = reader.listBooks();
        if (books == null || books.size() == 0) {
            Assert.fail("No book loaded");
        } else {
            Assert.assertEquals("First book name should be 'Seven Database in Seven Weeks'", "Seven Database in Seven Weeks", books.get(0).getName());
        }
    }


}