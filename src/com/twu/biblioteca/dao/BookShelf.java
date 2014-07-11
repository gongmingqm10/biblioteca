package com.twu.biblioteca.dao;

import com.twu.biblioteca.model.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: gongming
 * Date: 7/11/14
 * Time: 9:07 AM
 * Email:gongmingqm10@foxmail.com
 */
public class BookShelf {

    private List<Book> books;
    private List<Book> checkoutBookList;

    public BookShelf(String file) {
        books = new ArrayList<Book>();
        checkoutBookList = new ArrayList<Book>();
        readFile(file);
    }

    public List<Book> listBooks() {
        return books;
    }

    public void checkoutBook(int position) {
        checkoutBookList.add(books.remove(position));
    }

    public List<Book> getCheckoutList() {
        return checkoutBookList;
    }

    public void returnBook(int position) {
        books.add(checkoutBookList.remove(position));
    }

    private void readFile(String file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            bufferedReader.readLine();//skip first title line.
            while((line = bufferedReader.readLine()) != null) {
                String[] content = line.split(",");
                if (content.length != 3) continue;
                books.add(new Book(content[0], content[1], content[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
