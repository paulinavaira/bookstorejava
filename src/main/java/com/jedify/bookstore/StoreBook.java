package com.jedify.bookstore;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class StoreBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    private int stock;

    public StoreBook(Store store, Book book, int stock) {
        this.store = store;
        this.book = book;
        this.stock = stock;
    }

    public StoreBook() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static Map<String,Object> storeBookDTO(StoreBook storeBook){
        Map<String,Object> dto = new HashMap<>();
        dto.put("book", storeBook.getBook());
        return dto;
    }
}
