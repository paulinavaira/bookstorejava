package com.jedify.bookstore.classes;

import javax.persistence.*;
import java.util.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @ManyToOne
    private Author author;
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToMany(mappedBy = "purchasedBooks", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> purchasedBooks;
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<StoreBook> storeBookSet;

    public Book(){}

    public Book(String title, Author author, Category category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public static Map<String,Object> bookDTO(Book book){
        Map<String,Object> dto = new HashMap<>();
        dto.put("id", book.getId());
        dto.put("title", book.getTitle());
        dto.put("author", book.getAuthor());
        dto.put("category", book.getCategory());
        return dto;
    }
}
