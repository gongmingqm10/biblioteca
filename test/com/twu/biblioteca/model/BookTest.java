package com.twu.biblioteca.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest{

    private Book instance;

    @Before
    public void setUp() throws Exception {
        instance = new Book("Refactoring", "Martin Fowler", "2003");
    }

    @Test
    public void testGetName() throws Exception {
        Assert.assertEquals("Book name should be 'Refactoring'", "Refactoring", instance.getName());

    }

    @Test
    public void testSetName() throws Exception {
        instance.setName("Algorithms");
        Assert.assertEquals("Book name should be 'Algorithms'", "Algorithms", instance.getName());
    }

    @Test
    public void testGetAuthor() throws Exception {
        Assert.assertEquals("Book author should be 'Martin Fowler'", "Martin Fowler", instance.getAuthor());

    }

    @Test
    public void testSetAuthor() throws Exception {
        instance.setAuthor("Robert Sedgewick");
        Assert.assertEquals("Book author should be 'Robert Sedgewick'", "Robert Sedgewick", instance.getAuthor());
    }

    @Test
    public void testGetPublishYear() throws Exception {
        Assert.assertEquals("Book pblish year should be 2003", "2003", instance.getPublishYear());
    }

    @Test
    public void testSetPublishYear() throws Exception {
        instance.setPublishYear("2010");
        Assert.assertEquals("Book author should be 2010", "2010", instance.getPublishYear());
    }
}