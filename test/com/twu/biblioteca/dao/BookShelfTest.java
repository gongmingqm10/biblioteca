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

    @Test
    public void checkoutBookTest() {
        bookShelf.checkoutBook(0);
        Assert.assertEquals("'Seven Database in Seven Weeks' should be checked out", "Seven Database in Seven Weeks", bookShelf.getCheckoutList().get(0).getName());
    }

    @Test
    public void returnBookTest() {
        bookShelf.checkoutBook(0);
        Assert.assertEquals(4, bookShelf.listBooks().size());
        bookShelf.returnBook(0);
        Assert.assertEquals(5, bookShelf.listBooks().size());
    }


}