package com.twu.biblioteca;

import com.twu.biblioteca.dao.BookReader;
import com.twu.biblioteca.model.Book;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        BookReader reader = new BookReader("books.csv");
        int i = 1;
        for (Book book : reader.listBooks()) {
            System.out.println( i++ + ". " +book.getName() + ", " + book.getAuthor() + ", " + book.getPublishYear());
        }
    }
}
