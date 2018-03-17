package com.turkeytech.homelib.java.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Book {

    /*final*/ String id;
    /*final*/ String name;
    /*final*/ String author;
    /*final*/ String category;
    /*final*/ String publisher;
    /*final*/ String published;
    /*final*/ String collection;
    /*final*/ String description;
    /*final*/ String fileType;

    /*final*/ int pages;

    private  /*final*/ ArrayList<String> tags;


    public Book(String id, String name, String author,
                String category, String publisher, String published,
                String collection, String description, String fileType, int pages) {

        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.published = published;
        this.collection = collection;
        this.description = description;
        this.fileType = fileType;
        this.pages = pages;

        this.tags = new ArrayList<>();
    }


    ArrayList<String> getTags() {
        return tags;
    }

    void setTags(String... tags) {
        this.tags.addAll(Arrays.asList(tags));
    }

}
