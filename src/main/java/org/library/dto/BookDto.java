package org.library.dto;

public class BookDto {

    private String title;
    private String author;
    private int page;

    public BookDto(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPage() {
        return page;
    }
}