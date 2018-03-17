package com.turkeytech.homelib.java.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookTest {

    @Test
    public void createBook() {
        Book book = new Book("WX984KF04YG", "Wong's Computational Fields",
                "Jimmy Wong", "Computations", "Tor Books", "2003",
                "none", "none", ".pdf", 803);

        String idResult = book.id;
        assertNotNull("The id of book is null!", idResult);
        assertEquals("Actual id does not match expected!", "WX984KF04YG", idResult);


        String nameResult = book.name;
        assertNotNull("The name of book is null!", nameResult);
        assertEquals("Actual name does not match expected!", "Wong's Computational Fields", nameResult);


        String authorResult = book.author;
        assertNotNull("The author of book is null!", authorResult);
        assertEquals("Actual author does not match expected!", "Jimmy Wong", authorResult);


        String categoryResult = book.category;
        assertNotNull("The category of book is null!", categoryResult);
        assertEquals("Actual category does not match expected!", "Computations", categoryResult);


        String publisherResult = book.publisher;
        assertNotNull("The publisher of book is null!", publisherResult);
        assertEquals("Actual publisher does not match expected!", "Tor Books", publisherResult);


        String publishedResult = book.published;
        assertNotNull("The published date of book is null!", publishedResult);
        assertEquals("Actual published date does not match expected!", "2003", publishedResult);


        String collectionResult = book.collection;
        assertNotNull("The collection value of book is null!", collectionResult);
        assertEquals("Actual collection values does not match expected!", "none", collectionResult);


        String descriptionResult = book.description;
        assertNotNull("The description of the book is null!", descriptionResult);
        assertEquals("Actual description does not match expected!", "none", descriptionResult);


        String fileTypeResult = book.fileType;
        assertNotNull("The fileType of book is null!", fileTypeResult);
        assertEquals("Actual fileType does not match expected!", ".pdf", fileTypeResult);


        int pagesResult = book.pages;
        assertNotNull("The pages value of book is null!", pagesResult);
        assertEquals("Actual pages does not match expected!", 803, pagesResult);

        book.setTags("");

        ArrayList<String> tagsResult = book.getTags();
        assertNotNull("The tags are null!", tagsResult);
        assertEquals("Actual tags does not match expected!", Collections.singletonList(""), tagsResult);
    }


}